package lists;

import classes.Game;

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
            game.showInfo();
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

    public List<Game> getGamesList() {
        return gamesList;
    }
}
