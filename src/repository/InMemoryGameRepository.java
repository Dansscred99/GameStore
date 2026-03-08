package repository;

import model.GameBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryGameRepository implements GameRepository {
    private List<GameBase> games = new ArrayList<>();

    @Override
    public void save(GameBase game) {

        Optional<GameBase> existing = findById(game.getId());

        if (existing.isPresent()) {

            int index = games.indexOf(existing.get());
            games.set(index, game);

        } else {

            games.add(game);

        }
    }

    @Override
    public List<GameBase> findAll(){

        return new  ArrayList<>(games);
    }

    @Override
    public Optional<GameBase> findById(int id){

        return games.stream()
                .filter(g -> g.getId() == id)
                .findFirst();
    }

    @Override
    public void deleteById(int id){
        games.removeIf(g -> g.getId() == id);
    }
}
