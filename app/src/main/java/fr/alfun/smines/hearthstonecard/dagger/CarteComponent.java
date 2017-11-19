package fr.alfun.smines.hearthstonecard.dagger;

import dagger.Subcomponent;
import fr.alfun.smines.hearthstonecard.activity.CarteActivity;

/**
 * Created by s.mines on 19/11/2017.
 */
@Subcomponent(modules = CarteModule.class)
public interface CarteComponent {
    void inject(CarteActivity activity);
}
