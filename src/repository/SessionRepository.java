package repository;

import model.PlaySession;

import java.util.List;

public interface SessionRepository {
    void save(PlaySession session);

    List<PlaySession> findAll();
}
