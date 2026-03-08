package lists;

import model.*;
import model.Platform;
import util.ScannerUtil;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class GameStorage {
    private List<GameBase> gamesList;
    private List<PlaySession> sessions;

    public GameStorage() {
        this.gamesList = new ArrayList<>();
        this.sessions = new ArrayList<>();
    }
    //guardar las sesiones en una lista
    public void logPlaySession(int gameId, double hours) {
    GameBase gameBase = this.gamesList.stream().filter(g -> g.getId() == gameId).
            findFirst().
            orElse(null);
        if (gameBase == null) {
            System.out.println("GameBase with id " + gameId + " not found");
            return;
        }
        PlaySession session1 = new PlaySession(
                gameId,
                hours,
                LocalDateTime.now()
        );
        sessions.add(session1);
        gameBase.setHoursPlayed(gameBase.getHoursPlayed() + hours);
        System.out.println();
        System.out.println("Session logged"+"\nGameBase Id : " + gameBase.getId()
                        +"\nTitle: "+ gameBase.getTitle()
                        +" \nHours played: "+ gameBase.getHoursPlayed());

    }
    //basic crud
    public void addGame(GameBase gameBase) {
        this.gamesList.add(gameBase);
    }


    public void showGames() {
        gamesList.forEach(gameBase -> {
            gameBase.showInfo();
            System.out.println("--------------------");
            });
        }

    public void deleteGame(int id) {

        boolean removed = gamesList.removeIf(gameBase -> gameBase.getId() == id);

        if (removed) {
            System.out.println("Game deleted.");
        } else {
            System.out.println("Game not found.");
        }
    }

    public void searchById(int id) {
         gamesList.stream()
                .filter(gameBase -> gameBase.getId() == id).findFirst().ifPresentOrElse(
                         GameBase::showInfo,
                        () -> System.out.println("GameBase not found.")
                 );

    }
    //estadisticas con mapas
    public void top5mostPlayedGames() {
        System.out.println("\n----- TOP 5 MOST PLAYED GAMES -----");

        System.out.printf("%-25s %10s%n", "GameBase", "Hours");
        System.out.println("-------------------------------------------");

        gamesList.stream()
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
                gamesList.stream().flatMap(gameBase -> gameBase.getPlatform().stream())
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
                gamesList.stream().flatMap(gameBase -> gameBase.getGenre().stream())
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
        totalHoursPlayed=gamesList.stream().mapToDouble(GameBase::getHoursPlayed).sum();
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

    //opcion 7 toString
    //metodo que permite buscar por titulo o developer
    public void searchOptions( String text) {
            gamesList.stream()
                    .filter(gameBase -> gameBase.getTitle() != null && gameBase.getTitle().toLowerCase().contains(text.toLowerCase()) ||
                    gameBase.getDeveloper() != null && gameBase.getDeveloper().toLowerCase().contains(text.toLowerCase()))
                    .forEach(System.out::println);
            /*.filter(gameBase ->
        (gameBase.getTitle() != null &&
        gameBase.getTitle().toLowerCase().contains(text.toLowerCase()))
        ||
        (gameBase.getDeveloper() != null &&
        gameBase.getDeveloper().toLowerCase().contains(text.toLowerCase()))
)*/
    }
        //metodos para filtrar datos
    public void filterOptionGenre(Genre genre) {
        gamesList.stream()
                .filter(gameBase -> gameBase.getGenre() != null && gameBase.getGenre().contains(genre))
                .forEach(System.out::println);
    }
    public void filterOptionPlatfom(Platform platform) {
        gamesList.stream()
                .filter(gameBase -> gameBase.getPlatform() != null && gameBase.getPlatform().contains(platform))
                .forEach(System.out::println);
    }
    public void filterOptionStatus(Status status) {
        gamesList.stream()
                .filter(gameBase -> gameBase.getStatus() != null && gameBase.getStatus() == status)
                .forEach(System.out::println);
    }
    //metodos para sortear los datos.
    public void sortOptionReleaseYear( ) {
        gamesList.stream()
                .sorted((g1, g2) -> Integer.compare(g1.getReleaseYear(), g2.getReleaseYear()))
                .forEach(System.out::println);
    }
    public void sortOptionTitle( ) {
            gamesList.stream()
                    .sorted((g1, g2) -> g1.getTitle().compareToIgnoreCase(g2.getTitle()))
                    .forEach(System.out::println);
    }

    public void sortOptionRating( ) {
            gamesList.stream()
                    .sorted((g1, g2) -> Double.compare(g2.getRating(), g1.getRating()))
                    .forEach(System.out::println);
    }

    public String showTitle(int id){
       return  gamesList.stream().filter(gameBase -> gameBase.getId() == id).
                map(GameBase::getTitle).findFirst().orElse("game not found");

    }
    public void editGame(int id) {

        Optional<GameBase> gameOpt = gamesList.stream()
                .filter(g -> g.getId() == id)
                .findFirst();
        gameOpt.ifPresentOrElse(gameBase -> {
            int option;
            do {

                System.out.println("\n===== EDIT GAME =====");
                System.out.println("\n===== "+ gameBase.getTitle()+" =====");
                System.out.println("1. Edit title");
                System.out.println("2. Edit genre");
                System.out.println("3. Edit platform");
                System.out.println("4. Edit developer");
                System.out.println("5. Edit status");
                System.out.println("6. Edit release year");
                System.out.println("7. Edit rating");
                System.out.println("8. Exit");

                option = ScannerUtil.captureNumber("Select option");

                switch (option) {
                    case 1:
                        String newTitle = ScannerUtil.captureText("New title");
                        gameBase.setTitle(newTitle);
                        break;
                    case 2:
                        Genre genre = ScannerUtil.captureEnum("Select genre", Genre.class);
                        gameBase.setGenre(Set.of(genre));
                        break;
                    case 3:
                        Platform platform = ScannerUtil.captureEnum("Select platform", Platform.class);
                        gameBase.setPlatform(Set.of(platform));
                        break;
                    case 4:
                        String dev = ScannerUtil.captureText("New developer");
                        gameBase.setDeveloper(dev);
                        break;
                    case 5:
                        Status status = ScannerUtil.captureEnum("Select status", Status.class);
                        gameBase.setStatus(status);
                        break;
                    case 6:
                        int year = ScannerUtil.captureNumber("New release year");
                        gameBase.setReleaseYear(year);
                        break;
                    case 7:
                        double rating = ScannerUtil.captureDecimal("New rating");
                        gameBase.setRating(rating);
                        break;
                    case 8:
                        System.out.println("Exiting editor...");
                        break;
                    default:
                        System.out.println("Invalid option");
                }

            } while (option != 8);

        }, () -> System.out.println("GameBase not found."));
    }

    public List<GameBase> getGamesList() {
        return gamesList;
    }
    public List<PlaySession> getSession() {
        return sessions;
    }
}
