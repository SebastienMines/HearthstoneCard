package fr.alfun.smines.hearthstonecard.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.ListView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.alfun.smines.hearthstonecard.R;
import fr.alfun.smines.hearthstonecard.presenter.MyExtensionPresenter;
import fr.alfun.smines.hearthstonecard.viewModel.ExtensionViewModel;

/**
 * Created by s.mines on 19/11/2017.
 */

public class ExtensionActivity extends AppCompatActivity implements ExtensionActivityView{

    public static final String NAME_EXTENSION = "name_extension";

    @Inject
    MyExtensionPresenter presenter;

    @BindView(R.id.lv1)
    ListView listViewExtension;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.extension);
        ButterKnife.bind(this);
    }

    @Override
    public void displayExtensionName(ExtensionViewModel viewModel) {

    }

    @Override
    public void displayExtensionNotFound() {

    }

    @Override
    public void displayError() {

    }
}
