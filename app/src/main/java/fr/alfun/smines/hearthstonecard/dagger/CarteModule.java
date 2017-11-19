package fr.alfun.smines.hearthstonecard.dagger;

import java.util.concurrent.Executor;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import fr.alfun.smines.hearthstonecard.activity.CarteActivityView;
import fr.alfun.smines.hearthstonecard.interactor.MyCarteInteractor;
import fr.alfun.smines.hearthstonecard.presenter.MyCartePresenter;
import fr.alfun.smines.hearthstonecard.presenter.MyCartePresenterImpl;
import fr.alfun.smines.hearthstonecard.repository.MyCarteRepository;
import fr.alfun.smines.hearthstonecard.repository.MyCarteRepositoryImpl;
import fr.alfun.smines.hearthstonecard.viewModel.CarteViewModel;

/**
 * Created by s.mines on 19/11/2017.
 */
@Module
public class CarteModule {

    private final CarteActivityView view;

    public CarteModule(CarteActivityView view) {
        this.view = view;
    }

    @Provides
    MyCartePresenter providesMyCartePresenter(
            @Named(MainCarteModule.BACKGROUND_THREAD)Executor executor,
            CarteActivityView view,
            MyCarteInteractor interactor
    ){
        return new MyCartePresenterDecorator(executor, new MyCartePresenterImpl(view, interactor));
    }

    @Provides
    CarteActivityView provideCarteActivityView(
            @Named(MainCarteModule.MAIN_THREAD) Executor executor
    ){
                return new CarteViewDecorator(executor, view);
    }

    @Provides
    MyCarteInteractor provideMyCarteInteractor(MyCarteRepository repository){
                return new MyCarteInteractor(repository);
    }

    @Provides
    MyCarteRepository provideMyCarteRepository(){ return new MyCarteRepositoryImpl(); }

    class MyCartePresenterDecorator implements MyCartePresenter{

        private Executor executor;
        private MyCartePresenter presenter;

        public MyCartePresenterDecorator(Executor executor, MyCartePresenter presenter) {
            this.executor = executor;
            this.presenter = presenter;
        }

        @Override
        public void load(final String name) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    presenter.load(name);
                }
            });
        }
    }

    class CarteViewDecorator implements CarteActivityView {

        private Executor executor;
        private CarteActivityView view;

        public CarteViewDecorator(Executor executor, CarteActivityView view) {
            this.executor = executor;
            this.view = view;
        }

        @Override
        public void displayCarteName(final CarteViewModel viewModel) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    view.displayCarteName(viewModel);
                }
            });
        }

        @Override
        public void displayCarteImg(final CarteViewModel viewModel) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    view.displayCarteImg(viewModel);
                }
            });
        }

        @Override
        public void displayCarteText(final CarteViewModel viewModel) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    view.displayCarteText(viewModel);
                }
            });
        }

        @Override
        public void displayCarteNotFound() {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    view.displayCarteNotFound();
                }
            });
        }

        @Override
        public void displayError() {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    view.displayError();
                }
            });
        }
    }
}
