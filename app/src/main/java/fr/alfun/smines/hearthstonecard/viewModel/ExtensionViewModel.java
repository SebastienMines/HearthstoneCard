package fr.alfun.smines.hearthstonecard.viewModel;

import java.util.List;

import fr.alfun.smines.hearthstonecard.model.Carte;

/**
 * Created by s.mines on 19/11/2017.
 */

public class ExtensionViewModel {
    private final List<Carte> cartes;

    public ExtensionViewModel(List<Carte> cartes) {
        this.cartes = cartes;
    }

    public List<Carte> getCartes() {
        return cartes;
    }
}
