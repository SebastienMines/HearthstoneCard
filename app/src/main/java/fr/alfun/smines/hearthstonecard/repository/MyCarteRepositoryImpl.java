package fr.alfun.smines.hearthstonecard.repository;

import java.io.IOException;
import java.util.List;

import fr.alfun.smines.hearthstonecard.exception.HearthstoneCardNotFoundException;
import fr.alfun.smines.hearthstonecard.exception.HearthstoneRepositoryException;
import fr.alfun.smines.hearthstonecard.model.Carte;
import fr.alfun.smines.hearthstonecard.retrofit.HearthstoneService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by s.mines on 19/11/2017.
 */

public class MyCarteRepositoryImpl implements MyCarteRepository {

    private static final String BASE_URL = "https://omgvamp-hearthstone-v1.p.mashape.com/";

    @Override
    public Carte getCarteByName(String name) throws HearthstoneCardNotFoundException, HearthstoneRepositoryException {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        HearthstoneService service = retrofit.create(HearthstoneService.class);

        try{
            List<Carte> carte = service.getCardByName(name).execute().body();
            if(carte==null) throw new HearthstoneCardNotFoundException();
            return carte.get(0);
        }catch (IOException e){
            throw new HearthstoneRepositoryException(e);
        }
    }
}
