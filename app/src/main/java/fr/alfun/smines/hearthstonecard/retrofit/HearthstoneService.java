package fr.alfun.smines.hearthstonecard.retrofit;

import java.util.List;

import fr.alfun.smines.hearthstonecard.model.Carte;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by s.mines on 19/11/2017.
 */

public interface HearthstoneService {
    @Headers({
            "X-Mashape-Key: f7pY3SgA7Umsh2HCYXbINnBA8IpQp1vVPiljsn4MkWZl3DXzfy"
    })
    @GET("cards/{name}?collectible=1&locale=frFR")
    Call<List<Carte>> getCardByName(@Path("name") String name);
}
