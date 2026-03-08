package classes;

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

        if (title == null || title.isBlank()) return;
        if (developer == null || developer.isBlank()) return;
        if (genre == null || genre.isEmpty()) return;
        if (platform == null || platform.isEmpty()) return;
        if (releaseYear < 1970 || releaseYear > 2026) return;
        if (rating < 0 || rating > 5) return;
        if (hoursPlayed < 0) return;

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

    public GameBase(){

    }

    public boolean isValid() {
        return validation;
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
