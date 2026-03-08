package service;

import model.GameBase;
import model.Genre;
import model.Platform;
import repository.GameRepository;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class StatsService {
    private final GameRepository gameRepository;

    public StatsService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }
    //estadisticas con mapas
    public void top5mostPlayedGames() {
        System.out.println("\n----- TOP 5 MOST PLAYED GAMES -----");

        System.out.printf("%-25s %10s%n", "GameBase", "Hours");
        System.out.println("-------------------------------------------");

        gameRepository.findAll().stream()
                .sorted(Comparator.comparingDouble(GameBase::getHoursPlayed).reversed())
                .limit(5)
                .forEach(gameBase ->
                        System.out.printf("%-25s %10.2f%n",
                                gameBase.getTitle(),
                                gameBase.getHoursPlayed())
                );
    }
    public void countbyPlatform() {
        Map<Platform, Long> cantPl=
                gameRepository.findAll().stream().flatMap(gameBase -> gameBase.getPlatform().stream())
                        .collect(Collectors.groupingBy(platform -> platform,
                                Collectors.counting()));
        System.out.println("\n----- GAMES BY PLATFORM -----");

        System.out.printf("%-15s %10s%n", "Platform", "Games");
        System.out.println("-----------------------------");

        cantPl.forEach((platform, count) ->
                System.out.printf("%-15s %10d%n", platform, count));
    }

    public void countbyGenre() {
        Map<Genre,Long> cantGen=
                gameRepository.findAll().stream().flatMap(gameBase -> gameBase.getGenre().stream())
                        .collect(Collectors.groupingBy(genre -> genre,
                                Collectors.counting()));
        System.out.println("\n----- GAMES BY GENRE -----");

        System.out.printf("%-15s %10s%n", "Genre", "Games");
        System.out.println("-----------------------------");

        cantGen.forEach((genre, count) ->
                System.out.printf("%-15s %10d%n", genre, count));
    }
    public void totalHoursPlayed() {
        double totalHoursPlayed = 0;
        totalHoursPlayed=gameRepository.findAll().stream().mapToDouble(GameBase::getHoursPlayed).sum();
        System.out.println("\n----- TOTAL HOURS PLAYED -----");

        System.out.printf("Total hours played: %.2f%n", totalHoursPlayed);
    }
    //muestra todas las estadisticas con los metodos anteriores
    public void showStatistics() {

        System.out.println("\n==================================");
        System.out.println("        GAME STATISTICS");
        System.out.println("==================================");

        top5mostPlayedGames();
        countbyPlatform();
        countbyGenre();
        totalHoursPlayed();

        System.out.println("==================================\n");
    }
}
