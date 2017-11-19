package fr.alfun.smines.hearthstonecard.dagger;

import java.util.concurrent.Executor;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import fr.alfun.smines.hearthstonecard.activity.ExtensionActivityView;
import fr.alfun.smines.hearthstonecard.interactor.MyExtensionInteractor;
import fr.alfun.smines.hearthstonecard.presenter.MyExtensionPresenter;
import fr.alfun.smines.hearthstonecard.presenter.MyExtensionPresenterImpl;
import fr.alfun.smines.hearthstonecard.repository.MyExtensionRepository;
import fr.alfun.smines.hearthstonecard.repository.MyExtensionRepositoryImpl;
import fr.alfun.smines.hearthstonecard.viewModel.ExtensionViewModel;

/**
 * Created by s.mines on 19/11/2017.
 */
@Module
public class ExtensionModule {

    private final ExtensionActivityView view;

    public ExtensionModule(ExtensionActivityView view) {
        this.view = view;
    }

    @Provides
    MyExtensionPresenter provideMyExtensionPresenter(
            @Named(MainExtensionModule.BACKGROUND_THREAD)Executor executor,
            ExtensionActivityView view,
            MyExtensionInteractor interactor
    ){
        return new MyExtensionPresenterDecorator(executor, new MyExtensionPresenterImpl(view, interactor));
    }

    @Provides
    ExtensionActivityView provideExtensionActivityView(
            @Named(MainExtensionModule.MAIN_THREAD) Executor executor
    ){
                return new ExtensionViewDecorator(executor, view);
    }

    @Provides
    MyExtensionInteractor provideMyExtensionInteractor(MyExtensionRepository repository){
                return new MyExtensionInteractor(repository);
    }

    @Provides
    MyExtensionRepository provideMyExtensionRepository(){ return new MyExtensionRepositoryImpl(); }

    class MyExtensionPresenterDecorator implements MyExtensionPresenter{

        private Executor executor;
        private MyExtensionPresenter presenter;

        public MyExtensionPresenterDecorator(Executor executor, MyExtensionPresenter presenter) {
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

    class ExtensionViewDecorator implements ExtensionActivityView {

        private Executor executor;
        private ExtensionActivityView view;

        public ExtensionViewDecorator(Executor executor, ExtensionActivityView view) {
            this.executor = executor;
            this.view = view;
        }

        @Override
        public void displayExtensionName(final ExtensionViewModel viewModel) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    view.displayExtensionName(viewModel);
                }
            });
        }

        @Override
        public void displayExtensionNotFound() {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    view.displayExtensionNotFound();
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
