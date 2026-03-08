package model;

import java.util.Set;

public class PhysicalGame extends GameBase {
    private Set<GameCondition> condition;

    public PhysicalGame(String title,
                        Set<Genre> genre,
                        Set<Platform> platform,
                        String developer,
                        Status status,
                        int releaseYear,
                        double hoursPlayed,
                        double rating,
                        Set<GameCondition> condition) {

        super(title, genre, platform, developer, status, releaseYear, hoursPlayed, rating);

        this.condition = condition;
    }
    public PhysicalGame(){

    }

    public Set<GameCondition> getCondition() {
        return condition;
    }

}
