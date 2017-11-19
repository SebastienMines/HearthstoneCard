package fr.alfun.smines.hearthstonecard.viewModel;

/**
 * Created by s.mines on 19/11/2017.
 */

public class CarteViewModel {
    private final String name;
    private final String img;
    private final String text;

    public CarteViewModel(String name, String img, String text) {
        this.name = name;
        this.img = img;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public String getText() {
        return text;
    }
}
