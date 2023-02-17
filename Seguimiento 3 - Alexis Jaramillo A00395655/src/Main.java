import java.util.Scanner;

public class Main {

    public static int turn = 1;

    public static void main(String[] args) {

        CircularList list = new CircularList();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n1. Dar turno. ");
            System.out.println("2. Mostrar turno actual.");
            System.out.println("3. Pasar turno");
            System.out.println("4. Seguir");
            System.out.println("5. Salir del programa\n");
            int option;
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    list.addNode(new Node(turn));
                    turn += 1;
                    list.print();
                    break;

                case 2:
                    System.out.println(list.getActual());
                    break;

                case 3:
                    break;

                case 4:
                    list.skipTurn();
                    break;

                case 5:
                    exit = true;

                default:
                    System.out.println("Ingresa una opcion valida en el sistema...");
                    break;
            }
        }


    }
}