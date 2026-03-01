import classes.Game;
import classes.Genre;
import classes.Platform;
import classes.Status;
import lists.GameStorage;
import util.ScannerUtil;

import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        //variable para el switch y la inizializacion de los objetos
        int option = 0;

        Game game = new Game();
        GameStorage gmst = new GameStorage();
        cargarGame(gmst);

        //siclo controlado por el usuario.
        do {
            Game Gm = new Game();
            //lectura de la oppcion
            option = ScannerUtil.captureMenu();
            switch (option) {

                case 1:
                    //se puede añadir juegos hasta que el usuario salga al menu
                    while (option != 2) {
                        System.out.println("opcion 1");
                        //asignacion datos a la clase Game
                        String title = ScannerUtil.captureText("ingrese el titulo");
                        Genre genre = Genre.valueOf(ScannerUtil.captureText("ingrese el genero"));
                        Status status = Status.valueOf(ScannerUtil.captureText("ingrese el estatus"));
                        Platform platform = Platform.valueOf(ScannerUtil.captureText("ingrese el platform"));
                        String developer = ScannerUtil.captureText("ingrese el developer");
                        int releaseYear = ScannerUtil.captureNumber("ingrese año de lanzamiento");
                        double rating = ScannerUtil.captureDecimal("califique el juego");
                        double hoursPlayed = ScannerUtil.captureDecimal("ingrese la cantidad de horas jugadas");
                        // guardando los datos en el objeto
                        Game gm = new Game(title, Set.of(genre), Set.of(platform), developer, status, releaseYear, rating, hoursPlayed);

                        //si son validos se guardan en la lista
                        if (gm.isValid()) {
                            gmst.addGame(gm);
                            System.out.println("juego agregado");
                        } else {
                            System.out.println("datos  no validos, no se guardo el juego");
                        }
                        option = ScannerUtil.menuAdd();
                    }
                    break;
                case 2:
                    option = 1;
                    while (option != 2 && option != 0) {
                        System.out.println("opcion 2 mostrar lista");
                        System.out.println(gmst.toString());
                        option = ScannerUtil.menuList();
                    }

                    break;
                case 3:
                    System.out.println("opcion 3 mostrar lista por id");
                    option = 1;
                    while (option != 2) {
                        gmst.searchById(ScannerUtil.captureNumber("ingrese el Id del Juego"));
                        option = ScannerUtil.menuById();
                    }
                    break;
                case 4:
                    System.out.println("opcion 4 editar videojuego");
                    break;
                case 5:
                    System.out.println("opcion 5 eliminar videojuego");
                    option = 1;
                    while (option != 2) {
                        String title = ScannerUtil.captureText("ingrese el titulo del juego a eliminar");
                        gmst.deleteGame(title);
                        option = ScannerUtil.menuDelete();
                    }
                    break;
                case 6:
                    System.out.println("opcion 6, serch, filter sort");
                    int ans;
                    do {
                        ans = ScannerUtil.ser_fil_sor_Menu();
                        switch (ans) {
                            case 1:
                                do {
                                    String text = ScannerUtil.captureText("ingrese el titulo del juego o el developer");
                                    gmst.searchOptions(text);
                                    ans = ScannerUtil.searchMenu();
                                } while (ans == 1);

                                break;
                            case 2:
                                do {
                                    ans = ScannerUtil.filterMenu();
                                    if (ans == 1) {
                                        try {
                                            String genre = ScannerUtil.captureText("ingrese el genero");
                                            gmst.filterOptionGenre(Genre.valueOf(genre));
                                        } catch (IllegalArgumentException e) {
                                            System.out.println("Genero no valido");

                                        }

                                    } else if (ans == 2) {
                                        try {
                                            String platform = ScannerUtil.captureText("ingrese la plataforma");
                                            gmst.filterOptionPlatfom(Platform.valueOf(platform));
                                        } catch (IllegalArgumentException e) {
                                            System.out.println("Plataforma no valida");

                                        }

                                    } else if (ans == 3) {
                                        try {
                                            String status = ScannerUtil.captureText("ingrese el status");
                                            gmst.filterOptionStatus(Genre.valueOf(status));
                                        } catch (IllegalArgumentException e) {
                                            System.out.println("Status no valido");
                                        }

                                    } else {

                                        System.out.println("Opcion no valida");
                                        ans = 0;
                                    }

                                } while (ans < 4);
                                break;
                            case 3:
                                do {
                                    ans = ScannerUtil.sortMenu();
                                    if (ans == 1) {
                                        gmst.sortOptionReleaseYear();
                                    } else if (ans == 2) {
                                        gmst.sortOptionTitle();
                                    } else if (ans == 3) {
                                        gmst.sortOptionRating();
                                    } else {
                                        System.out.println("Opcion no valida");
                                        ans = 0;
                                    }
                                } while (ans < 4);

                                break;
                            default:
                                System.out.println("Opcion no valida");
                                ans = 0;
                                break;
                        }
                    } while (ans < 4);
                    break;
                case 7:
                    System.out.println("opcion 7 log play sessions");
                    do {
                        ans=1;
                        try {
                            int id= ScannerUtil.captureNumber("ingrese el Id del Juego");
                            System.out.println("Game Title: "+gmst.showTitle(id));
                            double hours = ScannerUtil.captureDecimal("ingrese la cantidad de horas del Juego");
                                if (hours < 0) {
                                    throw new IllegalArgumentException();

                                }
                            gmst.logPlaySession(id, hours);
                            ans=ScannerUtil.captureNumber("Desea continuar?\n1-añadir nueva secion\n2-volver al menu\n ");
                        } catch (IllegalArgumentException e) {
                            System.out.println("La hora ingresada no valida");
                        }
                    } while (ans==1);
                    break;
                case 8:
                    System.out.println("opcion 8 view stadistics");

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
    public static void cargarGame (GameStorage game){

        game.addGame(new Game(
                "The Witcher 3",
                Set.of(Genre.RPG, Genre.ADVENTURE),
                Set.of(Platform.PC),
                "CD Projekt Red",
                Status.COMPLETED,
                2015,
                120.5,
                4.9
        ));

        game.addGame(new Game(
                "FIFA 24",
                Set.of(Genre.SPORTS),
                Set.of(Platform.PLAYSTATION),
                "EA Sports",
                Status.PLAYING,
                2023,
                35.0,
                4.2
        ));

        game.addGame(new Game(
                "Minecraft",
                Set.of(Genre.SIMULATION),
                Set.of(Platform.PC),
                "Mojang",
                Status.IN_LIBRARY,
                2011,
                250.0,
                5.0
        ));

        game.addGame(new Game(
                "Cyberpunk 2077",
                Set.of(Genre.RPG),
                Set.of(Platform.PC),
                "CD Projekt Red",
                Status.DOWNLOADED,
                2020,
                60.0,
                4.0
        ));

        game.addGame(new Game(
                "Resident Evil 4",
                Set.of(Genre.HORROR),
                Set.of(Platform.PLAYSTATION),
                "Capcom",
                Status.COMPLETED,
                2005,
                40.0,
                4.8
        ));
    }
}

