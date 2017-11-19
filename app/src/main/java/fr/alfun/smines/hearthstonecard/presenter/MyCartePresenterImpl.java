package fr.alfun.smines.hearthstonecard.presenter;

import fr.alfun.smines.hearthstonecard.activity.CarteActivityView;
import fr.alfun.smines.hearthstonecard.exception.HearthstoneCardNotFoundException;
import fr.alfun.smines.hearthstonecard.exception.HearthstoneRepositoryException;
import fr.alfun.smines.hearthstonecard.interactor.MyCarteInteractor;
import fr.alfun.smines.hearthstonecard.model.Carte;
import fr.alfun.smines.hearthstonecard.viewModel.CarteViewModel;

/**
 * Created by s.mines on 19/11/2017.
 */

public class MyCartePresenterImpl implements MyCartePresenter {

    private final CarteActivityView view;
    private final MyCarteInteractor interactor;

    public MyCartePresenterImpl(CarteActivityView view, MyCarteInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void load(String name) {
        try{
            Carte carte = interactor.getCarteByName(name);
            CarteViewModel viewModel = new CarteViewModel(carte.getName(), carte.getImg());
            view.displayCarteName(viewModel);
            view.displayCarteImg(viewModel);
        }catch (HearthstoneRepositoryException e) {
            view.displayCarteNotFound();
        }catch (HearthstoneCardNotFoundException e) {
            view.displayError();
        }
    }
}
