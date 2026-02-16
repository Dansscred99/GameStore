package classes;

public class Game {
    private int id;
    private String title;
    private String genre;
    private String status;
    private int realeseYear;
    private double rating;
    private double hoursPlayed;

    public Game(int id, String title, String genre, String status, int realeseYear, double hoursPlayed, double rating){
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.status = status;
        this.realeseYear = realeseYear;
        this.hoursPlayed = hoursPlayed;
        this.rating = rating;
    }
    public Game(){

    }

    public void mostrarInfo(){
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

    public String getGenre() {
        return genre;
    }

    public String getStatus() {
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
