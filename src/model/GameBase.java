package model;

import java.util.Set;

public  abstract class GameBase {
    protected static int contId = 1;
    protected boolean validation;
    protected int id;
    protected String title;
    protected Set<Genre> genre;
    protected Set<Platform> platform;
    protected String developer;
    protected Status status;
    protected int releaseYear;
    protected double rating;
    protected double hoursPlayed;

    protected GameBase(String title, Set<Genre> genre, Set<Platform> platform, String developer, Status status, int releaseYear, double hoursPlayed, double rating){

        this.id = contId++;
        this.title = title;
        this.genre = genre;
        this.platform = platform;
        this.developer = developer;
        this.status = status;
        this.releaseYear = releaseYear;
        this.hoursPlayed = hoursPlayed;
        this.rating = rating;

    }

    public GameBase(){

    }

    public static boolean validation(String title, Set<Genre> genre, Set<Platform> platform, String developer, Status status, int releaseYear, double hoursPlayed, double rating) {

        return title != null && !title.isBlank() &&
                developer != null && !developer.isBlank() &&
                genre != null && !genre.isEmpty() &&
                platform != null && !platform.isEmpty() &&
                releaseYear >= 1970 && releaseYear <= 2026 &&
                rating >= 0 && rating <= 5 &&
                hoursPlayed >= 0;
    }
        @Override
        public String toString() {
            String extra ="";
            if(this instanceof DigitalGame dg){
                extra = "Store: "+dg.getStoreName();
            }else if(this instanceof PhysicalGame pg){
                extra= "Condition"+pg.getCondition();
            }
        return "ID: "+id+
                " | Title: " + title +
                " | Developer: " + developer +
                " | Genre: " + genre +
                " | Platform: " + platform +
                " | Year: " + releaseYear +
                " | Rating: " + rating +
                " | Hours Played: " + hoursPlayed+" "+ extra;
        }

    public void showInfo(){
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Genre: " + genre);
        System.out.println("Status: " + status);
        System.out.println("RealeseYear: " + releaseYear);
        System.out.println("Rating: " + rating);
        System.out.println("Hours Played: " + hoursPlayed);
        System.out.println("Developer: " + developer);
        System.out.println("Platform: " + platform);
        if(this instanceof DigitalGame dg){
            System.out.println("Store: "+dg.getStoreName());
        }else if(this instanceof PhysicalGame pg){
            System.out.println("Condition"+pg.getCondition());
        }
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
    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(Set<Genre> genre) {
        this.genre = genre;
    }

    public void setPlatform(Set<Platform> platform) {
        this.platform = platform;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
