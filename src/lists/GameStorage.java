package lists;

import classes.Game;
import classes.Genre;

import java.util.ArrayList;
import java.util.List;

public class GameStorage {
    private List<Game> gamesList;

    public GameStorage() {
        this.gamesList = new ArrayList<>();
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
    public void filterOptionPlatfom(Genre genre) {
        gamesList.stream()
                .filter(game -> game.getGenre() != null && game.getGenre().contains(genre))
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

    public List<Game> getGamesList() {
        return gamesList;
    }
}
