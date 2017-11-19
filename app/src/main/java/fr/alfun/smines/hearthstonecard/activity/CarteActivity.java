package fr.alfun.smines.hearthstonecard.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.alfun.smines.hearthstonecard.R;
import fr.alfun.smines.hearthstonecard.dagger.CarteModule;
import fr.alfun.smines.hearthstonecard.dagger.DaggerMainCarteComponent;
import fr.alfun.smines.hearthstonecard.presenter.MyCartePresenter;
import fr.alfun.smines.hearthstonecard.viewModel.CarteViewModel;

/**
 * Created by s.mines on 19/11/2017.
 */

public class CarteActivity extends AppCompatActivity implements CarteActivityView{

    public static final String NAME_CARD = "name_card";

    @Inject
    MyCartePresenter presenter;

    @BindView(R.id.name_carte_solo)
    TextView carteNameTextView;
    @BindView(R.id.image_carte)
    ImageView imageCarte;
    @BindView(R.id.text_carte_solo)
    TextView carteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerMainCarteComponent.builder()
                .build()
                .plus(new CarteModule(this))
                .inject(this);
        setContentView(R.layout.carte);
        ButterKnife.bind(this);
        String carteName = getIntent().getExtras().getString(NAME_CARD);
        if (carteName != null) {
            presenter.load(carteName);
        }
    }

    @Override
    public void displayCarteName(CarteViewModel viewModel) {
        carteNameTextView.setText(viewModel.getName());
    }

    @Override
    public void displayCarteImg(CarteViewModel viewModel) {
        Picasso.with(this)
                .load(viewModel.getImg())
                .resize(1842, 2790)
                .into(imageCarte);
    }

    @Override
    public void displayCarteText(CarteViewModel viewModel) {
        carteTextView.setText(viewModel.getText());
    }

    @Override
    public void displayCarteNotFound() {

    }

    @Override
    public void displayError() {

    }
}
