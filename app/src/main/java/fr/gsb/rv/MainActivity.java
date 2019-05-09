package fr.gsb.rv;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request ;
import com.android.volley.RequestQueue ;
import com.android.volley.Response ;
import com.android.volley.VolleyError ;
import com.android.volley.toolbox.JsonObjectRequest ;
import com.android.volley.toolbox.Volley ;

import org.json.JSONException ;
import org.json.JSONObject ;

import fr.gsb.rv.entites.Visiteur;

// Activite principale - 

public class MainActivity extends AppCompatActivity {

    ImageView image ;
    TextView tvMatricule ;
    EditText etMatricule ;
    TextView tvMdp ;
    EditText etMdp ;
    Button bValider ;
    Button bAnnuler ;

    private static final String TAG="GSB_MAIN_ACTIVITY";
    //@Override : permet d'indiquer que l'on va redéfinir une méthode qui existait auparavant dans la classe parente.
    // OnCreate : Cette méthode est la première qui est lancée au démarrage d'une application,


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //on declare nos attributs
        this.image = (ImageView)findViewById(R.id.image);
        this.tvMatricule = (TextView)findViewById(R.id.tvMatricule);
        this.etMatricule = (EditText) findViewById(R.id.etMatricule);
        this.tvMdp = (TextView)findViewById(R.id.tvMdp);
        this.etMdp = (EditText) findViewById(R.id.etMdp);
        this.bValider = (Button) findViewById(R.id.bValider);
        this.bAnnuler = (Button) findViewById(R.id.bAnnuler);

        bValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, MenuRvActivity.class);
                startActivity(intent);
            }

        });

    }

    public void seConnecter(View view){

        String matricule = etMatricule.getText().toString();
        String mdp = etMdp.getText().toString();
        String url = String.format( "http://192.168.104.223:5000/visiteurs/%s/%s" , matricule , mdp ) ;

        //Création d'écouteurs
        Response.Listener<JSONObject> ecouteurReponse = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Visiteur visiteur = new Visiteur() ;

                try
                {
                    visiteur.setMatricule( response.getString( "matricule" ) );
                    visiteur.setMdp( response.getString( "mdp" ) );
                    visiteur.setNom( response.getString( "nom" ) ) ;
                    visiteur.setPrenom( response.getString( "prenom" ) ) ;
                    System.out.println( visiteur ) ;
                    Toast.makeText(MainActivity.this,"Connexion réussie", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,MenuRvActivity.class);
                    startActivity(intent);
                }
                catch (JSONException e)
                {
                    System.out.println("Nok");
                }

                System.out.println("HTTP OK");
            }

        } ;

        Response.ErrorListener ecouteurErreur = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("HTTP Error");
            }

        } ;

        JsonObjectRequest requete = new JsonObjectRequest(Request.Method.GET , null, null, ecouteurReponse, ecouteurErreur);
        RequestQueue fileRequete = Volley.newRequestQueue(this) ;
        fileRequete.add(requete) ;

    }

    public void Annuler(View view){
        this.etMatricule.setText("");
        this.etMdp.setText("");

        Log.i(TAG,"Initialisation des champs.");
    }



}
