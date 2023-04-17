import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Pais> paises = new ArrayList<>();


        while (true) {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Ingresar un país");
            System.out.println("2. Mostrar medallería");
            System.out.println("3. Mostrar total de medallas");
            System.out.println("4. Mostrar países");
            System.out.println("5. Salir");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del país:");
                    String nombre = sc.nextLine();
                    System.out.println("Ingrese el número de medallas de oro:");
                    int oro = sc.nextInt();
                    System.out.println("Ingrese el número de medallas de plata:");
                    int plata = sc.nextInt();
                    System.out.println("Ingrese el número de medallas de bronce:");
                    int bronce = sc.nextInt();
                    sc.nextLine();

                    Pais pais = new Pais(nombre, oro, plata, bronce);
                    paises.add(pais);
                    System.out.println("El país " + nombre + " ha sido agregado con éxito.");
                    break;

                case 2:
                    Collections.sort(paises);
                    System.out.println("\nTabla de medallería convencional:");
                    System.out.println("----------------------------------");
                    for (Pais p : paises) {
                        System.out.println(p);
                    }
                    System.out.println();
                    break;

                case 3:
                    Collections.sort(paises, new Comparator<Pais>() {
                        @Override
                        public int compare(Pais p1, Pais p2) {
                            return p2.getTotalMedallas() - p1.getTotalMedallas();
                        }
                    });
                    System.out.println("\nTabla de total de medallas:");
                    System.out.println("---------------------------");
                    for (Pais p : paises) {
                        System.out.println(p.getNombre() + ": " + p.getTotalMedallas() + " medallas");
                    }
                    System.out.println();
                    break;

                case 4:
                    burbuja(paises);
                    System.out.println("\nTabla de medallería por orden alfabético:");
                    System.out.println("-----------------------------------------");
                    for (Pais p : paises) {
                        System.out.println(p);
                    }
                    System.out.println();
                    break;

                case 5:
                    System.out.println("\n¡Gracias por usar el programa!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    public static void burbuja(ArrayList<Pais> paises) {
        for (int i = 0; i < paises.size() - 1; i++) {
            for (int j = 0; j < paises.size() - i - 1; j++) {
                if (paises.get(j).getNombre().compareTo(paises.get(j + 1).getNombre()) > 0) {
                    Pais temp = paises.get(j);
                    paises.set(j, paises.get(j + 1));
                    paises.set(j + 1, temp);
                }
            }
        }
    }

}




