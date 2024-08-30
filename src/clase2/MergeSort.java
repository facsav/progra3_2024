package clase2;
import java.util.Arrays;
public class MergeSort {

    // Método principal que ordena el arreglo
    public static void mergeSort(int[] arreglo) {
        if (arreglo.length < 2) {
            return; // Si el arreglo tiene 0 o 1 elementos, ya está ordenado
        }
        int medio = arreglo.length / 2;

        // Dividir el arreglo en dos mitades
        int[] izquierda = new int[medio];
        int[] derecha = new int[arreglo.length - medio];

        // Copiar los elementos a las mitades
        for (int i = 0; i < medio; i++) {
            izquierda[i] = arreglo[i];
        }
        for (int i = medio; i < arreglo.length; i++) {
            derecha[i - medio] = arreglo[i];
        }

        // Llamadas recursivas para ordenar las mitades
        mergeSort(izquierda);
        mergeSort(derecha);

        // Mezclar las mitades ordenadas
        merge(arreglo, izquierda, derecha);
    }

    // Método para mezclar dos mitades ordenadas
    private static void merge(int[] arreglo, int[] izquierda, int[] derecha) {
        int i = 0, j = 0, k = 0;

        // Mezclar los elementos en orden
        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i] <= derecha[j]) {
                arreglo[k++] = izquierda[i++];
            } else {
                arreglo[k++] = derecha[j++];
            }
        }

        // Copiar los elementos restantes de la mitad izquierda
        while (i < izquierda.length) {
            arreglo[k++] = izquierda[i++];
        }

        // Copiar los elementos restantes de la mitad derecha
        while (j < derecha.length) {
            arreglo[k++] = derecha[j++];
        }
    }

    public static void main(String[] args) {
        // declara el arreglo con tamaño 30
        int[] numeros = new int[30];
        // Llena el arreglo con numeros aleatorios llamando a la funcion llenarArreglo
        numeros = QuickSort.llenarArreglo(numeros);
        System.out.println("Arreglo antes de ordenar: ");
        System.out.println(Arrays.toString(numeros));
        // ordena el arreglo llamando a mergeSort
        mergeSort(numeros);
        System.out.println("Arreglo despues de ordenar: ");
        System.out.println(Arrays.toString(numeros));


    }
}
