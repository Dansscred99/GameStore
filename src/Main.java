import model.*;
import repository.GameRepository;
import repository.InMemoryGameRepository;
import repository.InMemorySessionRepository;
import repository.SessionRepository;
import service.GameService;
import service.SessionService;
import service.StatsService;
import util.ScannerUtil;

import java.util.Set;

public class Main {
    //toString;
    public static void main(String[] args) {
        //variable para el switch y la inizializacion de los objetos
        int option = 0;
        GameBase game = null;
        GameRepository gameRepository = new InMemoryGameRepository();
        SessionRepository sessionRepository = new InMemorySessionRepository();

        GameService gameService = new GameService(gameRepository);
        SessionService sessionService = new SessionService(sessionRepository, gameRepository);
        StatsService statsService = new StatsService(gameRepository);

        cargarGame(gameService);
        //siclo controlado por el usuario.
        do {
            //lectura de la oppcion
            option = ScannerUtil.captureMenu();
            switch (option) {

                case 1:
                    //se puede añadir juegos hasta que el usuario salga al menu
                    while (option == 1) {
                        System.out.println("Añadiendo nuevo Juego");
                        //object type designation
                        int type = ScannerUtil.captureNumber("Ingrese el tipo de juego a Agregar \n1 Digital\n2 Fisico\nOption");
                        if (type == 1) {
                            game = new DigitalGame();
                        } else if (type == 2) {
                            game = new PhysicalGame();
                        }
                        //base game data
                        String title = ScannerUtil.captureText("ingrese el titulo");

                        Genre genre = ScannerUtil.captureEnum("Ingrese el genero:", Genre.class);

                        Status status = ScannerUtil.captureEnum("Ingrese el estatus:", Status.class);

                        Platform platform = ScannerUtil.captureEnum("Ingrese la plataforma:", Platform.class);

                        String developer = ScannerUtil.captureText("ingrese el developer");

                        int releaseYear = ScannerUtil.captureNumber("ingrese año de lanzamiento");

                        double rating = ScannerUtil.captureDecimal("califique el juego");

                        double hoursPlayed = ScannerUtil.captureDecimal("ingrese la cantidad de horas jugadas");
                        boolean valid = GameBase.validation(title, Set.of(genre), Set.of(platform), developer, status, releaseYear, hoursPlayed, rating);

                        //gametype date capture

                        if (type == 1 && valid) {

                            Store store = ScannerUtil.captureEnum("Ingrese la Tienda:", Store.class);

                            game = new DigitalGame(
                                    title,
                                    Set.of(genre),
                                    Set.of(platform),
                                    developer,
                                    status,
                                    releaseYear,
                                    hoursPlayed,
                                    rating,
                                    Set.of(store)
                            );
                            gameService.addGame(game);
                            System.out.println("Juego agregado correctamente");
                        } else if (type == 2 && valid) {

                            GameCondition gcn = ScannerUtil.captureEnum("Ingrese la Condicon del Juego:", GameCondition.class);

                            game = new PhysicalGame(
                                    title,
                                    Set.of(genre),
                                    Set.of(platform),
                                    developer,
                                    status,
                                    releaseYear,
                                    hoursPlayed,
                                    rating,
                                    Set.of(gcn)
                            );
                            gameService.addGame(game);
                            System.out.println("Juego agregado correctamente");
                        } else {
                            System.out.println("Error, datos incorrectos, juego no valido");
                        }
                        option = ScannerUtil.menuAdd();
                    }
                    break;
                case 2:
                    option = 1;
                    while (option == 1) {
                        System.out.println("Mostrando Lista de Juegos");
                        gameService.showGames();
                        option = ScannerUtil.menuList();
                    }

                    break;
                case 3:
                    System.out.println("opcion 3 mostrar lista por id");
                    option = 1;
                    while (option == 1) {
                        gameService.searchById(ScannerUtil.captureNumber("ingrese el Id del Juego"));
                        option = ScannerUtil.menuById();
                    }
                    break;
                case 4:
                    System.out.println("opcion 4 editar videojuego");
                    int id = ScannerUtil.captureNumber("Enter gameBase ID to edit");
                    gameService.editGame(id);
                    break;
                case 5:
                    System.out.println("opcion 5 eliminar videojuego");
                    option = 1;
                    while (option == 1) {
                        int idDelet = ScannerUtil.captureNumber("ingrese el Id del juego a eliminar");
                        System.out.println("Game Title: " + gameService.showTitle(idDelet));
                        gameService.deleteGame(idDelet);
                        option = ScannerUtil.menuDelete();
                    }
                    break;
                case 6:
                    int ansSFS;

                    while (true) {

                        ansSFS = ScannerUtil.ser_fil_sor_Menu();
                        switch (ansSFS) {
                            case 1: // SEARCH
                                while (true) {

                                    String text = ScannerUtil.captureText("Ingrese el titulo del juego o el developer");
                                    gameService.searchOptions(text);

                                    int searchOption = ScannerUtil.searchMenu();

                                    if (searchOption != 1) {
                                        break; // volver al menu anterior
                                    }
                                }
                                break;

                            case 2: // FILTER
                                while (true) {

                                    int filterOption = ScannerUtil.filterMenu();

                                    if (filterOption == 4) {
                                        break; // salir del filtro
                                    }

                                    switch (filterOption) {

                                        case 1:
                                            try {
                                                Genre genre = ScannerUtil.captureEnum("Ingrese el genero", Genre.class);
                                                gameService.filterOptionGenre(genre);
                                            } catch (IllegalArgumentException e) {
                                                System.out.println("Genero no valido");
                                            }
                                            break;

                                        case 2:
                                            try {
                                                Platform platform = ScannerUtil.captureEnum("Ingrese la plataforma", Platform.class);
                                                gameService.filterOptionPlatfom(platform);
                                            } catch (IllegalArgumentException e) {
                                                System.out.println("Plataforma no valida");
                                            }
                                            break;

                                        case 3:
                                            try {
                                                Status status = ScannerUtil.captureEnum("Ingrese el status", Status.class);
                                                gameService.filterOptionStatus(status);
                                            } catch (IllegalArgumentException e) {
                                                System.out.println("Status no valido");
                                            }
                                            break;

                                        default:
                                            System.out.println("Opcion no valida");
                                    }
                                }
                                break;
                            case 3: // SORT
                                while (true) {

                                    int sortOption = ScannerUtil.sortMenu();

                                    if (sortOption == 4) {
                                        break; // salir del sort
                                    }

                                    switch (sortOption) {

                                        case 1:
                                            gameService.sortOptionReleaseYear();
                                            break;

                                        case 2:
                                            gameService.sortOptionTitle();
                                            break;

                                        case 3:
                                            gameService.sortOptionRating();
                                            break;

                                        default:
                                            System.out.println("Opcion no valida");
                                    }
                                }
                                break;
                            case 4: // EXIT
                                break;
                            default:
                                System.out.println("Opcion no valida");
                        }
                        if (ansSFS == 4) {
                            break;
                        }
                    }
                    break;
                case 7:
                    System.out.println("opcion 7 log play sessions");
                    int ansPs=0;
                    do {
                        try {
                            id = ScannerUtil.captureNumber("ingrese el Id del Juego");
                            System.out.println("GameBase Title: " + gameService.showTitle(id));
                            double hours = ScannerUtil.captureDecimal("ingrese la cantidad de horas del Juego");
                            if (hours < 0) {
                                throw new IllegalArgumentException();

                            }
                            sessionService.logPlaySession(id, hours);
                            ansPs = ScannerUtil.captureNumber("Desea continuar?\n1-añadir nueva secion\n2-volver al menu\n ");
                        } catch (IllegalArgumentException e) {
                            System.out.println("La hora ingresada no valida");
                        }
                    } while (ansPs == 1);
                    break;
                case 8:
                    System.out.println("opcion 8 view stadistics");
                    statsService.showStatistics();


                    break;
                case 9:
                    System.out.println("Guardando y saliendo");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    option = 0;
                    break;


            }
        } while (option != 9);


        }
    public static void cargarGame (GameService gameService){

        gameService.addGame(new DigitalGame(
                "The Witcher 3",
                Set.of(Genre.RPG, Genre.ADVENTURE),
                Set.of(Platform.PC),
                "CD Projekt Red",
                Status.COMPLETED,
                2015,
                120.5,
                4.9,
                Set.of(Store.STEAM)
        ));

        gameService.addGame(new DigitalGame(
                "FIFA 24",
                Set.of(Genre.SPORTS),
                Set.of(Platform.PLAYSTATION),
                "EA Sports",
                Status.PLAYING,
                2023,
                35.0,
                4.2,
                Set.of(Store.STEAM)
        ));

        gameService.addGame(new DigitalGame(
                "Minecraft",
                Set.of(Genre.SIMULATION),
                Set.of(Platform.PC),
                "Mojang",
                Status.IN_LIBRARY,
                2011,
                250.0,
                5.0,
                Set.of(Store.STEAM)
        ));

        gameService.addGame(new DigitalGame(
                "Cyberpunk 2077",
                Set.of(Genre.RPG),
                Set.of(Platform.PC),
                "CD Projekt Red",
                Status.DOWNLOADED,
                2020,
                60.0,
                4.0,
                Set.of(Store.STEAM)
        ));

        gameService.addGame(new DigitalGame(
                "Resident Evil 4",
                Set.of(Genre.HORROR),
                Set.of(Platform.PLAYSTATION),
                "Capcom",
                Status.COMPLETED,
                2005,
                40.0,
                4.8,
                Set.of(Store.STEAM)
        ));
    }
}

