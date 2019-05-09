package fr.gsb.rv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class SaisieRvActivity extends AppCompatActivity {

    TextView tvDateVisite ;
    Button bModifier ;
    TextView tvPraticien ;
    Spinner spPraticien ;
    TextView tvMotif ;
    Spinner spMotif ;
    TextView tvBilan ;
    EditText etBilan ;
    TextView tvCoefficient ;
    Spinner spCoefficient ;
    Button bValider ;
    Button bAnnuler ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saisie_rv);
    }

 /*
    public void afficherDate() {
        // Obtient la date actuelle
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        //on récupère le numéro du jour dans la semaine
        cDay=c.get(Calendar.DAY_OF_WEEK);
    }

*/




}
