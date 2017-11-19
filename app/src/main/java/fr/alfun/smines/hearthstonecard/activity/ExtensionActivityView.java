package fr.alfun.smines.hearthstonecard.activity;

import fr.alfun.smines.hearthstonecard.viewModel.ExtensionViewModel;

/**
 * Created by s.mines on 19/11/2017.
 */

public interface ExtensionActivityView {
    void displayExtensionName(ExtensionViewModel viewModel);
    void displayExtensionNotFound();
    void displayError();
}
