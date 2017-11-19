package fr.alfun.smines.hearthstonecard.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fr.alfun.smines.hearthstonecard.R;

public class AccueilActivity extends AppCompatActivity {

    @BindView(R.id.input_rechercher_all_accueil)EditText recherche;
    @BindView(R.id.button_banniere_naxxramax)
    ImageButton buttonNaxxrama;
    @BindView(R.id.button_banniere_meca)
    ImageButton buttonMeca;
    @BindView(R.id.button_banniere_rochenoir)
    ImageButton buttonRochenoir;
    @BindView(R.id.button_banniere_tournois)
    ImageButton buttonTournoi;
    @BindView(R.id.button_banniere_explorateur)
    ImageButton buttonExplorateur;
    @BindView(R.id.button_banniere_dieux)
    ImageButton buttonDieux;
    @BindView(R.id.button_banniere_kharazan)
    ImageButton buttonKharazan;
    @BindView(R.id.button_banniere_gadgetzan)
    ImageButton buttonGadgetzan;
    @BindView(R.id.button_banniere_ungoro)
    ImageButton buttonUngoro;
    @BindView(R.id.button_banniere_trone)
    ImageButton buttonTrone;


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
    @OnClick(R.id.button_banniere_naxxramax)
    public void onButtonNaxxramasClicked(){
        Intent i = new Intent(AccueilActivity.this, ExtensionActivity.class);
        i.putExtra(ExtensionActivity.NAME_EXTENSION, "Naxxramas");
        startActivity(i);
    }
    @OnClick(R.id.button_banniere_meca)
    public void onButtonMecaClicked(){
        Intent i = new Intent(AccueilActivity.this, ExtensionActivity.class);
        i.putExtra(ExtensionActivity.NAME_EXTENSION, "Goblins vs Gnomes");
        startActivity(i);
    }
    @OnClick(R.id.button_banniere_rochenoir)
    public void onButtonRochenoirClicked(){
        Intent i = new Intent(AccueilActivity.this, ExtensionActivity.class);
        i.putExtra(ExtensionActivity.NAME_EXTENSION, "Blackrock Mountain");
        startActivity(i);
    }
    @OnClick(R.id.button_banniere_tournois)
    public void onButtonTournoisClicked(){
        Intent i = new Intent(AccueilActivity.this, ExtensionActivity.class);
        i.putExtra(ExtensionActivity.NAME_EXTENSION, "The Grand Tournament");
        startActivity(i);
    }
    @OnClick(R.id.button_banniere_explorateur)
    public void onButtonExplorateurClicked(){
        Intent i = new Intent(AccueilActivity.this, ExtensionActivity.class);
        i.putExtra(ExtensionActivity.NAME_EXTENSION, "The League of Explorers");
        startActivity(i);

    }
    @OnClick(R.id.button_banniere_dieux)
    public void onButtonDieuxClicked(){
        Intent i = new Intent(AccueilActivity.this, ExtensionActivity.class);
        i.putExtra(ExtensionActivity.NAME_EXTENSION, "Whispers of the Old Gods");
        startActivity(i);
    }
    @OnClick(R.id.button_banniere_kharazan)
    public void onButtonKharazanClicked(){
        Intent i = new Intent(AccueilActivity.this, ExtensionActivity.class);
        i.putExtra(ExtensionActivity.NAME_EXTENSION, "One Night in Karazhan");
        startActivity(i);
    }
    @OnClick(R.id.button_banniere_gadgetzan)
    public void onButtonGadgetzanClicked(){
        Intent i = new Intent(AccueilActivity.this, ExtensionActivity.class);
        i.putExtra(ExtensionActivity.NAME_EXTENSION, "Mean Streets of Gadgetzan");
        startActivity(i);
    }
    @OnClick(R.id.button_banniere_ungoro)
    public void onButtonUngoroClicked(){
        Intent i = new Intent(AccueilActivity.this, ExtensionActivity.class);
        i.putExtra(ExtensionActivity.NAME_EXTENSION, "Journey to Un'goro");
        startActivity(i);
    }
    @OnClick(R.id.button_banniere_trone)
    public void onButtonTroneClicked(){
        Intent i = new Intent(AccueilActivity.this, ExtensionActivity.class);
        i.putExtra(ExtensionActivity.NAME_EXTENSION, "Knights of the Frozen Throne");
        startActivity(i);
    }
}
