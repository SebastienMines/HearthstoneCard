package fr.alfun.smines.hearthstonecard.activity;

import fr.alfun.smines.hearthstonecard.viewModel.CarteViewModel;

/**
 * Created by s.mines on 19/11/2017.
 */

public interface CarteActivityView {
    void displayCarteName(CarteViewModel viewModel);
    void displayCarteImg(CarteViewModel viewModel);
    void displayCarteText(CarteViewModel viewModel);
    void displayCarteFlavor(CarteViewModel viewModel);
    void displayCarteNotFound();
    void displayError();
}
