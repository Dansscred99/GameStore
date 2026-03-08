package repository;

import model.PlaySession;

import java.util.ArrayList;
import java.util.List;

public class InMemorySessionRepository implements SessionRepository {

    private List<PlaySession> sessions = new ArrayList<>();

    @Override
    public void save(PlaySession session) {
        sessions.add(session);
    }
    
    @Override
    public List<PlaySession> findAll() {
        return new  ArrayList<>(sessions);
    }
}
