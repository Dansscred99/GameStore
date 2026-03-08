package lists;

import classes.*;
import classes.Platform;
import util.ScannerUtil;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class GameStorage {
    private List<Game> gamesList;
    private List<PlaySession> sessions;

    public GameStorage() {
        this.gamesList = new ArrayList<>();
        this.sessions = new ArrayList<>();
    }
    //guardar las sesiones en una lista
    public void logPlaySession(int gameId, double hours) {
    Game game = this.gamesList.stream().filter(g -> g.getId() == gameId).
            findFirst().
            orElse(null);
        if (game == null) {
            System.out.println("Game with id " + gameId + " not found");
            return;
        }
        PlaySession session1 = new PlaySession(
                gameId,
                hours,
                LocalDateTime.now()
        );
        sessions.add(session1);
        game.setHoursPlayed(game.getHoursPlayed() + hours);
        System.out.println();
        System.out.println("Session logged"+"\nGame Id : " +game.getId()
                        +"\nTitle: "+game.getTitle()
                        +" \nHours played: "+game.getHoursPlayed());

    }
    //basic crud
    public void addGame(Game game) {
        this.gamesList.add(game);
    }


    public void showGames() {
        gamesList.forEach(game -> {
            game.showInfo();
            System.out.println("--------------------");
        });
    }

    public void deleteGame(String title) {
        boolean removed = gamesList.removeIf(game -> game.getTitle().equalsIgnoreCase(title));
        if(removed){
            System.out.println("Game has been deleted.");
        }else {
            System.out.println("Game not found.");
        }
    }

    public void searchById(int id) {
         gamesList.stream()
                .filter(game -> game.getId() == id).findFirst().ifPresentOrElse(
                         Game::showInfo,
                        () -> System.out.println("Game not found.")
                 );

    }
    //estadisticas con mapas
    public void top5mostPlayedGames() {
        System.out.println("\n----- TOP 5 MOST PLAYED GAMES -----");

        System.out.printf("%-25s %10s%n", "Game", "Hours");
        System.out.println("-------------------------------------------");

        gamesList.stream()
                .sorted(Comparator.comparingDouble(Game::getHoursPlayed).reversed())
                .limit(5)
                .forEach(game ->
                        System.out.printf("%-25s %10.2f%n",
                                game.getTitle(),
                                game.getHoursPlayed())
                );
    }
    public void countbyPlatform() {
        Map<Platform, Long> cantPl=
                gamesList.stream().flatMap(game ->game.getPlatform().stream())
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
                gamesList.stream().flatMap(game -> game.getGenre().stream())
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
        totalHoursPlayed=gamesList.stream().mapToDouble(Game::getHoursPlayed).sum();
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

    //opcion 7
    //metodo que permite buscar por titulo o developer
    public void searchOptions( String text) {
            gamesList.stream()
                    .filter(game -> game.getTitle() != null && game.getTitle().toLowerCase().contains(text.toLowerCase()) ||
                    game.getDeveloper() != null && game.getDeveloper().toLowerCase().contains(text.toLowerCase()))
                    .forEach(System.out::println);
    }
        //metodos para filtrar datos
    public void filterOptionGenre(Genre genre) {
        gamesList.stream()
                .filter(game -> game.getGenre() != null && game.getGenre().contains(genre))
                .forEach(System.out::println);
    }
    public void filterOptionPlatfom(Platform platform) {
        gamesList.stream()
                .filter(game -> game.getPlatform() != null && game.getPlatform().contains(platform))
                .forEach(System.out::println);
    }
    public void filterOptionStatus(Status status) {
        gamesList.stream()
                .filter(game -> game.getStatus() != null && game.getStatus() == status)
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
       return  gamesList.stream().filter(game-> game.getId() == id).
                map(Game::getTitle).findFirst().orElse("game not found");

    }
    public void editGame(int id) {

        Optional<Game> gameOpt = gamesList.stream()
                .filter(g -> g.getId() == id)
                .findFirst();
        gameOpt.ifPresentOrElse(game -> {
            int option;
            do {

                System.out.println("\n===== EDIT GAME =====");
                System.out.println("\n===== "+game.getTitle()+" =====");
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
                        game.setTitle(newTitle);
                        break;
                    case 2:
                        Genre genre = ScannerUtil.captureEnum("Select genre", Genre.class);
                        game.setGenre(Set.of(genre));
                        break;
                    case 3:
                        Platform platform = ScannerUtil.captureEnum("Select platform", Platform.class);
                        game.setPlatform(Set.of(platform));
                        break;
                    case 4:
                        String dev = ScannerUtil.captureText("New developer");
                        game.setDeveloper(dev);
                        break;
                    case 5:
                        Status status = ScannerUtil.captureEnum("Select status", Status.class);
                        game.setStatus(status);
                        break;
                    case 6:
                        int year = ScannerUtil.captureNumber("New release year");
                        game.setReleaseYear(year);
                        break;
                    case 7:
                        double rating = ScannerUtil.captureDecimal("New rating");
                        game.setRating(rating);
                        break;
                    case 8:
                        System.out.println("Exiting editor...");
                        break;
                    default:
                        System.out.println("Invalid option");
                }

            } while (option != 8);

        }, () -> System.out.println("Game not found."));
    }

    public List<Game> getGamesList() {
        return gamesList;
    }
    public List<PlaySession> getSession() {
        return sessions;
    }
}
