package fr.alfun.smines.hearthstonecard.model;

/**
 * Created by s.mines on 19/11/2017.
 */

public class Carte {
    private String name;
    private String img;
    private String text;
    private String flavor;

    public Carte(String name, String img, String text, String flavor) {
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
