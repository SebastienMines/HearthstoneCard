package fr.alfun.smines.hearthstonecard.repository;

import fr.alfun.smines.hearthstonecard.exception.HearthstoneCardNotFoundException;
import fr.alfun.smines.hearthstonecard.exception.HearthstoneRepositoryException;
import fr.alfun.smines.hearthstonecard.model.Carte;

/**
 * Created by s.mines on 19/11/2017.
 */

public interface MyCarteRepository {
    Carte getCarteByName(String name) throws HearthstoneCardNotFoundException, HearthstoneRepositoryException;
}
