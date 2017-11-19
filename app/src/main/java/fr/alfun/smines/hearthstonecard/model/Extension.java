package fr.alfun.smines.hearthstonecard.model;

import java.util.List;

/**
 * Created by s.mines on 19/11/2017.
 */

public class Extension {

    private List<Carte> cartes;

    public Extension(List<Carte> cartes) {
        this.cartes = cartes;
    }

    public List<Carte> getCartes() {
        return cartes;
    }
}
