package classes;

public class Game {
    private static int contId = 1;
    private boolean validation;
    private int id;
    private String title;
    private String genre;
    private String status;
    private int realeseYear;
    private double rating;
    private double hoursPlayed;

    public Game(String title, String genre, String status, int realeseYear, double hoursPlayed, double rating){
        this.id = contId++;
        //validacion de datos
        if(title == null || title.trim().isEmpty()
                || genre == null || genre.trim().isEmpty()
                || status == null || status.trim().isEmpty()
                || realeseYear < 1970 || realeseYear > 2026
                || rating < 0 || rating > 5){
            validation = false;
            //si los datos no son correctos detiene el codigo y no ingresan al objeto
            return;
        }
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
