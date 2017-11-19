package fr.alfun.smines.hearthstonecard.interactor;

import fr.alfun.smines.hearthstonecard.exception.HearthstoneCardNotFoundException;
import fr.alfun.smines.hearthstonecard.exception.HearthstoneRepositoryException;
import fr.alfun.smines.hearthstonecard.model.Carte;
import fr.alfun.smines.hearthstonecard.repository.MyCarteRepository;

/**
 * Created by s.mines on 19/11/2017.
 */

public class MyCarteInteractor {

    private final MyCarteRepository repository;

    public MyCarteInteractor(MyCarteRepository repository) {
        this.repository = repository;
    }

    public Carte getCarteByName(String name) throws HearthstoneRepositoryException, HearthstoneCardNotFoundException {
        return repository.getCarteByName(name);
    }
}
