package lists;

import classes.Game;
import classes.Genre;
import classes.Platform;
import classes.Platform;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GameStorage {
    private List<Game> gamesList;
    private List<PlaySession> sessions;

    public GameStorage() {
        this.gamesList = new ArrayList<>();
        this.sessions = new ArrayList<>();
    }

    public void logPlaySession(int gameId, double hours) {
    Game game = this.gamesList.stream().filter(g -> g.getId() == gameId).
            findFirst().
            orElse(null);
        if (game == null) {
            System.out.println("Game with id " + gameId + " not found");
            return;
        }
        PlaySession session1 = new PlaySession(
                gameId,
                hours,
                LocalDateTime.now()
        );
        sessions.add(session1);
        game.setHoursPlayed(game.getHoursPlayed() + hours);
        System.out.println();
        System.out.println("Session logged"+"\nGame Id : " +game.getId()
                        +"\nTitle: "+game.getTitle()
                        +" \nHours played: "+game.getHoursPlayed());

    }

    public void addGame(Game game) {
        this.gamesList.add(game);
    }


    public void showGames() {
        gamesList.forEach(game -> {
            game.toString();
            System.out.println("--------------------");
        });
    }

    public void deleteGame(String title) {
        boolean removed = gamesList.removeIf(game -> game.getTitle().equalsIgnoreCase(title));
        if(removed){
            System.out.println("Game has been deleted.");
        }else {
            System.out.println("Game not found.");
        }
    }

    public void searchById(int id) {
         gamesList.stream()
                .filter(game -> game.getId() == id).findFirst().ifPresentOrElse(
                         Game::showInfo,
                        () -> System.out.println("Game not found.")
                 );

    }
    //opcion 7
    //metodo que permite buscar por titulo o developer
    public void searchOptions( String text) {
            gamesList.stream()
                    .filter(game -> game.getTitle() != null && game.getTitle().toLowerCase().contains(text.toLowerCase()) ||
                    game.getDeveloper() != null && game.getDeveloper().toLowerCase().contains(text.toLowerCase()))
                    .forEach(System.out::println);
    }
        //metodos para filtrar datos
    public void filterOptionGenre(Genre genre) {
        gamesList.stream()
                .filter(game -> game.getGenre() != null && game.getGenre().contains(genre))
                .forEach(System.out::println);
    }
    public void filterOptionPlatfom(Platform platform) {
        gamesList.stream()
                .filter(game -> game.getPlatform() != null && game.getGenre().contains(platform))
                .forEach(System.out::println);
    }
    public void filterOptionStatus(Genre genre) {
        gamesList.stream()
                .filter(game -> game.getGenre() != null && game.getGenre().contains(genre))
                .forEach(System.out::println);
    }
    //metodos para sortear los datos.
    public void sortOptionReleaseYear( ) {
        gamesList.stream()
                .sorted((g1, g2) -> Integer.compare(g1.getReleaseYear(), g2.getReleaseYear()))
                .forEach(System.out::println);
    }
    public void sortOptionTitle( ) {
            gamesList.stream()
                    .sorted((g1, g2) -> g1.getTitle().compareToIgnoreCase(g2.getTitle()))
                    .forEach(System.out::println);
    }

    public void sortOptionRating( ) {
            gamesList.stream()
                    .sorted((g1, g2) -> Double.compare(g2.getRating(), g1.getRating()))
                    .forEach(System.out::println);
    }

    public String showTitle(int id){
       return  gamesList.stream().filter(game-> game.getId() == id).
                map(Game::getTitle).findFirst().orElse("game not found");

    }

    public List<Game> getGamesList() {
        return gamesList;
    }
    public List<PlaySession> getSession() {
        return sessions;
    }
}
