import classes.Game;
import lists.GameStorage;
import util.ScannerUtil;

public class Main {

    public static void main(String[] args){
        //variable para el switch y la inizializacion de los objetos
        int option=0;

        Game game = new Game();
        GameStorage gmst = new GameStorage();
        cargarGame(gmst);

        //siclo controlado por el usuario.
        do{
            Game Gm = new Game();
            //lectura de la oppcion
            option= ScannerUtil.captureMenu();
            switch(option){

                case 1:
                    //se puede añadir juegos hasta que el usuario salga al menu
                    while(option!=2){
                        System.out.println("opcion 1");
                        //asignacion datos a la clase Game
                        String title = ScannerUtil.captureText("ingrese el titulo");
                        String genre = ScannerUtil.captureText("ingrese el genero");
                        String status = ScannerUtil.captureText("ingrese el estatus");
                        int releseYear = ScannerUtil.captureNumber("ingrese año de lanzamiento");
                        double rating = ScannerUtil.captureDecimal("califique el juego");
                        double hoursPlayed = ScannerUtil.captureDecimal("ingrese la cantidad de horas jugadas");
                        // guardando los datos en el objeto
                        Game gm = new Game(title, genre, status, releseYear, rating, hoursPlayed);

                        //si son validos se guardan en la lista
                        if(gm.isValid()){
                            gmst.addGame(gm);
                            System.out.println("juego agregado");
                        }else {
                            System.out.println("datos  no validos, no se guardo el juego");
                        }
                        option = ScannerUtil.menuAdd();
                    }


                    break;
                case 2:
                    option=1;
                    while(option!=2){
                        System.out.println("opcion 2 mostrar lista");
                        gmst.showGames();
                        option = ScannerUtil.menuList();
                    }

                    break;
                case 3:
                    System.out.println("opcion 3 mostrar lista por id");
                    option=1;
                    while(option!=2){
                        gmst.searchById(ScannerUtil.captureNumber("ingrese el Id del Juego"));
                        option = ScannerUtil.menuById();
                    }
                    break;
                case 4:
                    System.out.println("opcion 4 editar videojuego");
                    break;
                case 5:
                    System.out.println("opcion 5 eliminar videojuego");
                    option=1;
                    while(option!=2){
                        String title = ScannerUtil.captureText("ingrese el titulo del juego a eliminar");
                        gmst.deleteGame(title);
                        option = ScannerUtil.menuDelete();
                    }
                    break;
                case 6:
                    System.out.println("opcion 6");
                    break;
                case 7:
                    System.out.println("opcion 7");
                    break;
                case 8:
                    System.out.println("opcion 8");
                    break;
                case 9:
                    System.out.println("Guardando y saliendo");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    option=0;
                    break;
            }

        }while (option !=9);



    }
    public static void cargarGame(GameStorage game){
        game.addGame(new Game("The Witcher 3", "RPG", "COMPLETED", 2015, 120.5, 4.9));
        game.addGame(new Game("FIFA 24", "Sports", "Playing", 2023, 35.0, 4.2));
        game.addGame(new Game("Minecraft", "Sandbox", "Completed", 2011, 250.0, 5.0));
        game.addGame(new Game("Cyberpunk 2077", "RPG", "Playing", 2020, 60.0, 4.0));
        game.addGame(new Game("Resident Evil 4", "Horror", "Completed", 2005, 40.0, 4.8));

    }
}


