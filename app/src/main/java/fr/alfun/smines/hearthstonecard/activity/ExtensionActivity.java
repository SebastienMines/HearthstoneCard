package fr.alfun.smines.hearthstonecard.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.alfun.smines.hearthstonecard.R;
import fr.alfun.smines.hearthstonecard.dagger.DaggerMainExtensionComponent;
import fr.alfun.smines.hearthstonecard.dagger.ExtensionModule;
import fr.alfun.smines.hearthstonecard.presenter.MyExtensionPresenter;
import fr.alfun.smines.hearthstonecard.viewModel.ExtensionViewModel;

/**
 * Created by s.mines on 19/11/2017.
 */

public class ExtensionActivity extends BaseActivity implements ExtensionActivityView{

    public static final String NAME_EXTENSION = "name_extension";

    @Inject
    MyExtensionPresenter presenter;

    @BindView(R.id.lv1)
    ListView listViewExtension;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerMainExtensionComponent.builder()
                .build()
                .plus(new ExtensionModule(this))
                .inject(this);
        setContentView(R.layout.extension);
        ButterKnife.bind(this);
        String extension = getIntent().getExtras().getString(NAME_EXTENSION);
        if(extension != null){
            presenter.load(extension);
        }
    }

    @Override
    public void displayExtensionName(ExtensionViewModel viewModel) {
        Log.e("RESULT_JSON", String.valueOf(viewModel.getCartes().size()));
        String[] values = new String[viewModel.getCartes().size()];
        for(int i=0; i<viewModel.getCartes().size(); i++){
            values[i]=viewModel.getCartes().get(i).getName();
        }
        ArrayAdapter mAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, values);
        listViewExtension.setAdapter(mAdapter);
    }

    @Override
    public void displayExtensionNotFound() {

    }

    @Override
    public void displayError() {

    }
}
