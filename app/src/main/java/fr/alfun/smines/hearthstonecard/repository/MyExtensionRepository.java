package fr.alfun.smines.hearthstonecard.repository;

import java.util.List;

import fr.alfun.smines.hearthstonecard.exception.HearthstoneCardNotFoundException;
import fr.alfun.smines.hearthstonecard.exception.HearthstoneRepositoryException;
import fr.alfun.smines.hearthstonecard.model.Carte;
import fr.alfun.smines.hearthstonecard.model.Extension;

/**
 * Created by s.mines on 19/11/2017.
 */

public interface MyExtensionRepository {
    Extension getCarteByExtension(String name) throws HearthstoneCardNotFoundException, HearthstoneRepositoryException;
}
