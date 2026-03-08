package classes;

import java.util.Set;

public class PhysicalGame extends GameBase {
    private String condition;

    public PhysicalGame(String title,
                        Set<Genre> genre,
                        Set<Platform> platform,
                        String developer,
                        Status status,
                        int releaseYear,
                        double hoursPlayed,
                        double rating,
                        String condition) {

        super(title, genre, platform, developer, status, releaseYear, hoursPlayed, rating);

        this.condition = condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;

    }
    public String getCondition() {
        return condition;
    }

}
