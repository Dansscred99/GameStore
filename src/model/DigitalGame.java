package model;

import java.util.Set;

public class  DigitalGame extends GameBase {
    private Set<Store> stores;

    public DigitalGame(String title,
                       Set<Genre> genre,
                       Set<Platform> platform,
                       String developer,
                       Status status,
                       int releaseYear,
                       double hoursPlayed,
                       double rating,
                       Set<Store> storeName) {

        super(title, genre, platform, developer, status, releaseYear, hoursPlayed, rating);

        this.stores = storeName;
    }

    public DigitalGame() {

    }

    public Set<Store> getStoreName() {
        return stores;
    }

}
