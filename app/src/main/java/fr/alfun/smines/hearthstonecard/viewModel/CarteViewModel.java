package fr.alfun.smines.hearthstonecard.viewModel;

/**
 * Created by s.mines on 19/11/2017.
 */

public class CarteViewModel {
    private final String name;
    private final String img;
    private final String text;
    private final String flavor;

    public CarteViewModel(String name, String img, String text, String flavor) {
        this.name = name;
        this.img = img;
        this.text = text;
        this.flavor = flavor;
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

    public String getFlavor() {
        return flavor;
    }
}
