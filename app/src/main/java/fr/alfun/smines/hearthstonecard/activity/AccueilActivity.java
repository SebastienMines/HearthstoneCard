package fr.alfun.smines.hearthstonecard.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fr.alfun.smines.hearthstonecard.R;

public class AccueilActivity extends AppCompatActivity {

    @BindView(R.id.input_rechercher_all_accueil)EditText recherche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_rechercher_all_accueil)
    public void onButtonRechercheClicked(){
        Intent i = new Intent(AccueilActivity.this, CarteActivity.class);
        i.putExtra(CarteActivity.NAME_CARD, recherche.getText().toString());
        startActivity(i);
    }
}
