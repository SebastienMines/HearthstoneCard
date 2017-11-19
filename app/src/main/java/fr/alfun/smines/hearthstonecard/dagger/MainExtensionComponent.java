package fr.alfun.smines.hearthstonecard.dagger;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by s.mines on 19/11/2017.
 */
@Singleton
@Component(modules = MainExtensionModule.class)
public interface MainExtensionComponent {
    ExtensionComponent plus(ExtensionModule module);
}
