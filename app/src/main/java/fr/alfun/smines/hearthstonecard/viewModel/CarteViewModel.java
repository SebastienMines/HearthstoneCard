package fr.alfun.smines.hearthstonecard.viewModel;

/**
 * Created by s.mines on 19/11/2017.
 */

public class CarteViewModel {
    private final String name;
    private final String img;

    public CarteViewModel(String name, String img) {
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }
}
