package fr.alfun.smines.hearthstonecard.retrofit;

import java.util.List;

import fr.alfun.smines.hearthstonecard.model.Carte;
import fr.alfun.smines.hearthstonecard.model.Extension;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by s.mines on 19/11/2017.
 */

public interface ExtensionService {
    @Headers({
            "X-Mashape-Key: f7pY3SgA7Umsh2HCYXbINnBA8IpQp1vVPiljsn4MkWZl3DXzfy"
    })
    @GET("cards/search/{set}?collectible=1&locale=frFR")
    Call<Extension> getCardByExtension(@Path("set") String name);
}
