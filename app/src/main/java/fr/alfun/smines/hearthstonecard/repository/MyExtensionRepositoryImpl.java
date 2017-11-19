package fr.alfun.smines.hearthstonecard.repository;

import java.io.IOException;
import java.util.List;

import fr.alfun.smines.hearthstonecard.exception.HearthstoneCardNotFoundException;
import fr.alfun.smines.hearthstonecard.exception.HearthstoneRepositoryException;
import fr.alfun.smines.hearthstonecard.model.Carte;
import fr.alfun.smines.hearthstonecard.model.Extension;
import fr.alfun.smines.hearthstonecard.retrofit.ExtensionService;
import fr.alfun.smines.hearthstonecard.retrofit.HearthstoneService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by s.mines on 19/11/2017.
 */

public class MyExtensionRepositoryImpl implements MyExtensionRepository {

    private static final String BASE_URL = "https://omgvamp-hearthstone-v1.p.mashape.com/";

    @Override
    public List<Carte> getCarteByExtension(String name) throws HearthstoneCardNotFoundException, HearthstoneRepositoryException {

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        ExtensionService service = retrofit.create(ExtensionService.class);

        try {
            List<Carte> extension = service.getCardByExtension(name).execute().body();
            if(extension==null) throw new HearthstoneCardNotFoundException();
            return extension;
        }catch (IOException e){
            throw new HearthstoneRepositoryException(e);
        }
    }
}
