package fr.alfun.smines.hearthstonecard.dagger;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by s.mines on 19/11/2017.
 */
@Singleton
@Component(modules = MainCarteModule.class)
public interface MainCarteComponent {
    CarteComponent plus(CarteModule module);
}
