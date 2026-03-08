package repository;

import model.PlaySession;

import java.util.ArrayList;
import java.util.List;

public class InMemorySessionRepository implements SessionRepository {
    private List<PlaySession> sessions = new ArrayList<>();

    public void save(PlaySession session) {
        sessions.add(session);
    }

    public List<PlaySession> findAll() {
        return sessions;
    }
}
