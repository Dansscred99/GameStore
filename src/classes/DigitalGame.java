package classes;

import java.util.Set;

public class  DigitalGame extends GameBase {
    private String storeName;

    public DigitalGame(String title,
                       Set<Genre> genre,
                       Set<Platform> platform,
                       String developer,
                       Status status,
                       int releaseYear,
                       double hoursPlayed,
                       double rating,
                       String storeName) {

        super(title, genre, platform, developer, status, releaseYear, hoursPlayed, rating);

        this.storeName = storeName;
    }


    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
