package classes;

import java.util.Collections;
import java.util.Set;

public class Game {
    private static int contId = 1;
    private boolean validation;
    private int id;
    private String title;
    private Set<Genre> genre;
    private Set<Platform> platform;
    private String developer;
    private Status status;
    private int releaseYear;
    private double rating;
    private double hoursPlayed;

    public Game(String title, Set<Genre> genre, Set<Platform> platform,String developer, Status status, int releaseYear, double hoursPlayed, double rating){
        this.id = contId++;
        //validacion de datos
        this.title = title;
        this.genre = genre;
        this.platform = platform;
        this.developer = developer;
        this.status = status;
        this.releaseYear = releaseYear;
        this.hoursPlayed = hoursPlayed;
        this.rating = rating;
        validation = true;

    }

    public Game(){

    }

    public boolean isValid() {
        return validation;
    }
        @Override
        public String toString() {
        return "ID: "+id+
                " | Title: " + title +
                " | Developer: " + developer +
                " | Genre: " + genre +
                " | Platform: " + platform +
                " | Year: " + releaseYear +
                " | Rating: " + rating +
                " | Hours Played: " + hoursPlayed;
        }

    public void showInfo(){
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Genre: " + genre);
        System.out.println("Status: " + status);
        System.out.println("RealeseYear: " + releaseYear);
        System.out.println("Rating: " + rating);
        System.out.println("Hours Played: " + hoursPlayed);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Set<Genre> getGenre() {
        return genre;
    }

    public Status getStatus() {
        return status;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public double getRating() {
        return rating;
    }

    public double getHoursPlayed() {
        return hoursPlayed;
    }

    public double setHoursPlayed(double hoursPlayed) {
        this.hoursPlayed = hoursPlayed;
        return hoursPlayed;
    }

    public String getDeveloper() {
        return developer;
    }

    public Set<Platform> getPlatform() {
        return platform;
    }
}
