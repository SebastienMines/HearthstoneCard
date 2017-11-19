package fr.alfun.smines.hearthstonecard.presenter;

import java.util.List;

import fr.alfun.smines.hearthstonecard.activity.ExtensionActivityView;
import fr.alfun.smines.hearthstonecard.exception.HearthstoneCardNotFoundException;
import fr.alfun.smines.hearthstonecard.exception.HearthstoneRepositoryException;
import fr.alfun.smines.hearthstonecard.interactor.MyExtensionInteractor;
import fr.alfun.smines.hearthstonecard.model.Carte;
import fr.alfun.smines.hearthstonecard.model.Extension;
import fr.alfun.smines.hearthstonecard.viewModel.CarteViewModel;
import fr.alfun.smines.hearthstonecard.viewModel.ExtensionViewModel;

/**
 * Created by s.mines on 19/11/2017.
 */

public class MyExtensionPresenterImpl implements MyExtensionPresenter {

    private final ExtensionActivityView view;
    private final MyExtensionInteractor interactor;

    public MyExtensionPresenterImpl(ExtensionActivityView view, MyExtensionInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void load(String name) {
        try{
            List<Carte> extension = interactor.getExtensionByName(name);
            ExtensionViewModel viewModel = new ExtensionViewModel(extension);
            view.displayExtensionName(viewModel);
        }catch (HearthstoneRepositoryException e){
            view.displayExtensionNotFound();
        }catch (HearthstoneCardNotFoundException e){
            view.displayError();
        }
    }
}
