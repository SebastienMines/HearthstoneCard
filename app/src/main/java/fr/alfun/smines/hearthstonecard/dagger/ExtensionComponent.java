package fr.alfun.smines.hearthstonecard.dagger;

import dagger.Subcomponent;
import fr.alfun.smines.hearthstonecard.activity.ExtensionActivity;

/**
 * Created by s.mines on 19/11/2017.
 */
@Subcomponent(modules = ExtensionModule.class)
public interface ExtensionComponent {
    void inject(ExtensionActivity activity);
}
