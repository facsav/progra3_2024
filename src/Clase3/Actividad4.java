package Clase3;
import java.util.Arrays;

public class Actividad4 {

    public static void main(String[] args) {
        int[] lista = {10, 5, 20, 7, 3, 40, 50};
        int n = 3; // Número de elementos que queremos encontrar

        int[] mayores = encontrarNElementosMayores(lista, 0, lista.length - 1, n);
        System.out.println("Los " + n + " elementos mayores son: " + Arrays.toString(mayores));
    }

    public static int[] encontrarNElementosMayores(int[] lista, int inicio, int fin, int n) {
        if (fin - inicio + 1 <= n) {
            int[] subarray = Arrays.copyOfRange(lista, inicio, fin + 1);
            Arrays.sort(subarray);
            return Arrays.copyOfRange(subarray, Math.max(subarray.length - n, 0), subarray.length);
        }

        int mitad = (inicio + fin) / 2;

        int[] mayoresIzquierda = encontrarNElementosMayores(lista, inicio, mitad, n);
        int[] mayoresDerecha = encontrarNElementosMayores(lista, mitad + 1, fin, n);

        return combinarYOrdenar(mayoresIzquierda, mayoresDerecha, n);
    }

    private static int[] combinarYOrdenar(int[] izq, int[] der, int n) {
        int[] combinar = new int[izq.length + der.length];
        System.arraycopy(izq, 0, combinar, 0, izq.length);
        System.arraycopy(der, 0, combinar, izq.length, der.length);

        Arrays.sort(combinar);
        return Arrays.copyOfRange(combinar, Math.max(combinar.length - n, 0), combinar.length);
    }

}

//PSEUDOCODIGO

/*
FUNCIÓN EncontrarNElementosMayores(lista, inicio, fin, n)
    SI fin - inicio + 1 <= n ENTONCES
        RETORNAR los n elementos mayores del rango [inicio, fin]
    FIN SI

    mitad = (inicio + fin) / 2

    mayoresIzquierda = EncontrarNElementosMayores(lista, inicio, mitad, n)
    mayoresDerecha = EncontrarNElementosMayores(lista, mitad + 1, fin, n)

    todosMayores = COMBINAR_Y_ORDENAR(mayoresIzquierda, mayoresDerecha, n)

    RETORNAR todosMayores
FIN FUNCIÓN

FUNCIÓN COMBINAR_Y_ORDENAR(izquierda, derecha, n)
    combinar = CONCATENAR(izquierda, derecha)
    ordenar = ORDENAR(combinar)
    retornar los n primeros elementos de ordenar
FIN FUNCIÓN

FUNCIÓN Principal()
    lista = [Lista de números]
    n = [Número de elementos que queremos encontrar]
    mayores = EncontrarNElementosMayores(lista, 0, tamaño(lista) - 1, n)
    IMPRIMIR "Los " + n + " elementos mayores son: " + mayores
FIN FUNCIÓN
 */