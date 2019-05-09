package fr.gsb.rv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class RechercheRvActivity extends AppCompatActivity {

    private static final Integer [] lesMois = {1,2,3,4,5,6,7,8,9,10,11,12} ;
    private static final Integer [] lesAnnees = {2017,2018,2019,2020};
    Spinner spMois ;
    Spinner spAnnee ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_rv);
        //je m occupe du mois : je l adapte
        spMois = ( Spinner ) findViewById( R.id.spMois ) ;

        ArrayAdapter<Integer> aaMois = new ArrayAdapter<Integer>(
                this,
                android.R.layout.simple_spinner_item ,
                lesMois
        ) ;
        aaMois.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item
        );
        spMois.setAdapter(aaMois);

        //je m occupe de l annee : je l adapte
        spAnnee = ( Spinner ) findViewById(R.id.spAnnee) ;

        ArrayAdapter<Integer> aaAnnees = new ArrayAdapter<Integer>(
                this,
                android.R.layout.simple_spinner_item ,
                lesAnnees
        ) ;
        aaAnnees.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spAnnee.setAdapter(aaAnnees);

    }


    public void voirSelection(View vue){
        //valeur de l item selectionne
        spMois.getSelectedItem();
    }


}
