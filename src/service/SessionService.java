package service;
import model.PlaySession;
import model.GameBase;
import repository.GameRepository;
import repository.SessionRepository;

import java.time.LocalDateTime;

public class SessionService {
    private SessionRepository sessionRepository;
    private GameRepository gameRepository;

    public SessionService(SessionRepository sessionRepo, GameRepository gameRepo){

        this.sessionRepository = sessionRepo;
        this.gameRepository = gameRepo;

    }
    public void logPlaySession(int gameId, double hours) {
        GameBase gameBase = this.gameRepository.findById(gameId).stream().filter(g -> g.getId() == gameId).
                findFirst().
                orElse(null);
        if (gameBase == null) {
            System.out.println("GameBase with id " + gameId + " not found");
            return;
        }
        PlaySession session = new PlaySession(
                gameId,
                hours,
                LocalDateTime.now()
        );
        sessionRepository.save(session);
        gameBase.setHoursPlayed(gameBase.getHoursPlayed() + hours);
        System.out.println();
        System.out.println("Session logged"+"\nGameBase Id : " + gameBase.getId()
                +"\nTitle: "+ gameBase.getTitle()
                +" \nHours played: "+ gameBase.getHoursPlayed());

    }
}
