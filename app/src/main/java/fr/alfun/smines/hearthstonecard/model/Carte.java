package fr.alfun.smines.hearthstonecard.model;

/**
 * Created by s.mines on 19/11/2017.
 */

public class Carte {
    private String name;
    private String img;

    public Carte(String name, String img) {
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
