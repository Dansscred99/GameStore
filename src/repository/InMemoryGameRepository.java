package repository;

import model.GameBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryGameRepository implements GameRepository {
    private List<GameBase> games = new ArrayList<>();

    public void save(GameBase game){
        games.add(game);
    }

    public List<GameBase> findAll(){
        return games;
    }

    public Optional<GameBase> findById(int id){

        return games.stream()
                .filter(g -> g.getId() == id)
                .findFirst();
    }

    public void deleteById(int id){
        games.removeIf(g -> g.getId() == id);
    }
}
