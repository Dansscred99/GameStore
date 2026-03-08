package repository;

import model.GameBase;

import java.util.List;
import java.util.Optional;

public interface GameRepository {

    void save(GameBase game);
    List<GameBase> findAll();
    Optional<GameBase> findById(int id);
    void deleteById(int id);

}
