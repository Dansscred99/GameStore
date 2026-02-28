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

    public void showTitles() {
        for (Game game : gamesList) {
            System.out.println(game.getTitle());
        }
    }

    public void showGames() {
        for (Game game : gamesList) {
            game.showInfo();
            System.out.println("--------------------");
        }
    }

    public void deleteGame(String title) {
        for (Game game : gamesList) {
            if (game.getTitle().equalsIgnoreCase(title)) {
                gamesList.remove(game);
                System.out.println("Game deleted successfully.");
                return;
            }
        }
        System.out.println("Game not found.");
    }

    public void searchById(int id) {
        for (Game game : gamesList) {
            if (game.getId() == id) {
                game.showInfo();
                return;
            }
        }
        System.out.println("Game not found.");
    }

    public List<Game> getGamesList() {
        return gamesList;
    }
}
