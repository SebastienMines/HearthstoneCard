package fr.alfun.smines.hearthstonecard.model;

/**
 * Created by s.mines on 19/11/2017.
 */

public class Carte {
    private String name;
    private String img;
    private String text;

    public Carte(String name, String img, String text) {
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
