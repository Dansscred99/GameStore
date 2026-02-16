import classes.Game;
import lists.GameStorage;
import util.ScannerUtil;

public class Main {
    public static void main(String[] args) {
        int option=0;
        Game game = new Game();
        GameStorage gmst = new GameStorage();
        do{
            Game Gm = new Game();

            option= ScannerUtil.capturarMenu();
            switch(option){

                case 1:
                    System.out.println("opcion 1");
                    int id = ScannerUtil.capturarNumero("ingrese el Id: ");
                    String title = ScannerUtil.capturarTexto("ingrese el title: ");
                    String genre = ScannerUtil.capturarTexto("ingrese el genero: ");
                    String status = ScannerUtil.capturarTexto("ingrese el estatus: ");
                    int releseYear = ScannerUtil.capturarNumero("ingrese año de lanzamiento: ");
                    double rating = ScannerUtil.capturarNumero("califique el juego: ");
                    double hoursPlayed = ScannerUtil.capturarNumero("ingrese la cantidad de horas jugadas: ");

                    Game gm = new Game(id, title, genre, status, releseYear, rating, hoursPlayed);
                    gmst.agregar(gm);

                   gmst.mostrarTitulos();

                    break;
                case 2:
                    System.out.println("opcion 2");
                    Gm.mostrarInfo();
                    break;
                case 3:
                    System.out.println("opcion 3");
                    break;
                case 4:
                    System.out.println("opcion 4");
                    break;
                case 5:
                    System.out.println("opcion 5");
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
}
