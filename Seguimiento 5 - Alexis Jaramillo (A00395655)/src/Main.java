import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese los elementos deseados separados por un espacios: ");
        String[] array = sc.nextLine().split(" ");
        sc.close();

        Arrays.sort(array); // ordenar el arreglo

        Node root = treeBuilder(array, 0, array.length - 1);

        System.out.println("\nEl árbol balanceado en orden es:");
        printInOrder(root);
        System.out.println();

        System.out.println("\nEl árbol balanceado al reves es:");
        printInReverse(root);
        System.out.println();

        int finalDepth = depth(root);
        System.out.printf("\nLa profundidad del árbol es: %d%n", finalDepth);
        System.out.println("\nEl árbol balanceado en orden es:");
        printDepth(root, 1);
        System.out.println();


    }



    // función para construir el BST balanceado a partir de un arreglo de Strings
    public static Node treeBuilder(String[] array, int start, int end) {
        //Caso base recursivo
        if (start > end) {
            return null;
        }

        // Encuentra el nodo central de todo el arreglo
        int centralNode = (start + end) / 2;

        //Lo asigna como el nodo raiz
        Node root = new Node(array[centralNode]);

        //Construir recursivamente los subárboles izquierdo y derecho
        //Dependiendo del tamaño del valor comparado se define hacia que lado del arbol va
        root.left = treeBuilder(array, start, centralNode - 1);
        root.right = treeBuilder(array, centralNode + 1, end);

        return root;
    }

    // función para imprimir el arbol en orden ascendiente de manera recursiva
    public static void printInOrder(Node root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.value + " ");
        printInOrder(root.right);
    }

    // función para imprimir el arbol en orden descendiente de manera recursiva
    public static void printInReverse(Node root) {
        if (root == null) {
            return;
        }
        printInReverse(root.right);
        System.out.print(root.value + " ");
        printInReverse(root.left);
    }

    // función para calcular la profundidad de un árbol binario de manera recursiva
    public static int depth(Node root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // función para imprimir el árbol en orden ascendente junto con su profundidad
    public static void printDepth(Node root, int depth) {
        if (root == null) {
            return;
        }
        printDepth(root.left, depth + 1);
        System.out.printf("%s (profundidad: %d)%n", root.value, depth);
        printDepth(root.right, depth + 1);
    }


}