package fr.alfun.smines.hearthstonecard.activity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;
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
    public Animator animator;

    @Inject
    MyCartePresenter presenter;

    @BindView(R.id.loading)
    ImageView imageLoading;
    @BindView(R.id.name_carte_solo)
    TextView carteNameTextView;
    @BindView(R.id.image_carte)
    ImageView imageCarte;
    @BindView(R.id.text_carte_solo)
    TextView carteTextView;
    @BindView(R.id.text_carte_description)
    TextView carteFlavorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerMainCarteComponent.builder()
                .build()
                .plus(new CarteModule(this))
                .inject(this);
        setContentView(R.layout.carte);
        ButterKnife.bind(this);
        animator = AnimatorInflater.loadAnimator(this, R.animator.anim);
        animator.setTarget(imageLoading);
        animator.start();
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
        animator.end();
        Picasso.with(this)
                .load(R.drawable.launch_icon)
                .resize(1,1)
                .into(imageLoading);
        imageLoading.setVisibility(View.INVISIBLE);
        Picasso.with(this)
                .load(viewModel.getImg())
                .resize(1842, 2790)
                .into(imageCarte);
    }

    @Override
    public void displayCarteText(CarteViewModel viewModel) {
        carteTextView.setText(Html.fromHtml(viewModel.getText()));
    }

    @Override
    public void displayCarteFlavor(CarteViewModel viewModel) {
        carteFlavorTextView.setText(viewModel.getFlavor());
    }

    @Override
    public void displayCarteNotFound() {
        animator.end();
        Picasso.with(this)
                .load(R.drawable.launch_icon)
                .resize(1,1)
                .into(imageLoading);
        imageLoading.setVisibility(View.INVISIBLE);
        Picasso.with(this)
                .load("https://s3.amazonaws.com/cardgenhs/t/PeKiCNby.png")
                .resize(1842, 2790)
                .into(imageCarte);
    }

    @Override
    public void displayError() {
        animator.end();
        Picasso.with(this)
                .load(R.drawable.launch_icon)
                .resize(1,1)
                .into(imageLoading);
        imageLoading.setVisibility(View.INVISIBLE);
        Picasso.with(this)
                .load("https://s3.amazonaws.com/cardgenhs/t/PeKiCNby.png")
                .resize(1842, 2790)
                .into(imageCarte);
    }
}
