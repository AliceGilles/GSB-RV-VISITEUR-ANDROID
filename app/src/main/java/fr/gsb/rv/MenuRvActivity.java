package fr.gsb.rv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuRvActivity extends AppCompatActivity {

    Button bconsulter ;
    Button bsaisir ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_rv);

        this.bconsulter= (Button) findViewById(R.id.bconsulter);
        this.bsaisir=(Button) findViewById(R.id.bsaisir);
        //permet de faire le lien entre les deux pages
        bconsulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MenuRvActivity.this, RechercheRvActivity.class);
                startActivity(intent);
            }
        });

        bsaisir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent( MenuRvActivity.this, SaisieRvActivity.class);
                startActivity(intent);
            }
        });
    }

    public void consulter(View vue){

    }

}
