package lists;

import classes.Game;

import java.util.ArrayList;
import java.util.List;

public class GameStorage {
    private List<Game> gamesList;
    Game game = new Game();

    public GameStorage() {
        this.gamesList = new ArrayList<>();
    }

    public void agregar(Game elemento) {
        this.gamesList.add(elemento);
    }

    public void mostrarTitulos() {
        for (Game game1 : gamesList) {
            System.out.println(game1.getTitle());
        }
    }

    public void eliminar(Game elemento) {
        this.gamesList.remove(elemento);
    }

    public List<Game> getGamesList() {
        return gamesList;
    }
}
