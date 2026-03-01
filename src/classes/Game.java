package classes;

public class Game {
    private static int contId = 1;
    private boolean validation;
    private int id;
    private String title;
    private Genre genre;
    private Platform platform;
    private String Developer;
    private Status status;
    private int realeseYear;
    private double rating;
    private double hoursPlayed;

    public Game(String title, Genre genre,Platform platform,String developer, Status status, int realeseYear, double hoursPlayed, double rating){
        this.id = contId++;
        //validacion de datos
        this.title = title;
        this.genre = genre;
        this.status = status;
        this.realeseYear = realeseYear;
        this.hoursPlayed = hoursPlayed;
        this.rating = rating;
        validation = true;

    }

    public Game(){

    }

    public boolean isValid() {
        return validation;
    }

    public void showInfo(){
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Genre: " + genre);
        System.out.println("Status: " + status);
        System.out.println("RealeseYear: " + realeseYear);
        System.out.println("Rating: " + rating);
        System.out.println("Hours Played: " + hoursPlayed);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }

    public Status getStatus() {
        return status;
    }

    public int getRealeseYear() {
        return realeseYear;
    }

    public double getRating() {
        return rating;
    }

    public double getHoursPlayed() {
        return hoursPlayed;
    }
}
