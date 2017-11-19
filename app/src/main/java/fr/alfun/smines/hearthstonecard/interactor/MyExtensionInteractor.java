package fr.alfun.smines.hearthstonecard.interactor;

import fr.alfun.smines.hearthstonecard.exception.HearthstoneCardNotFoundException;
import fr.alfun.smines.hearthstonecard.exception.HearthstoneRepositoryException;
import fr.alfun.smines.hearthstonecard.model.Extension;
import fr.alfun.smines.hearthstonecard.repository.MyExtensionRepository;

/**
 * Created by s.mines on 19/11/2017.
 */

public class MyExtensionInteractor {

    private final MyExtensionRepository repository;

    public MyExtensionInteractor(MyExtensionRepository repository) {
        this.repository = repository;
    }

    public Extension getExtensionByName(String name) throws HearthstoneRepositoryException, HearthstoneCardNotFoundException {
        return repository.getCarteByExtension(name);
    }
}
