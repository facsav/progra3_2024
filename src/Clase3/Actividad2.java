package Clase3;

/*

Objetivo: Dada una lista de números, encontrar los dos números mayores utilizando la técnica de
Divide y Conquista.
Tareas:
Pseudocódigo: Escribe el pseudocódigo que resuelva el problema. Implementación en Java:
Implementa el pseudocódigo en Java.
Análisis de Recurrencia: Realiza el análisis de recurrencia conceptual por el método inductivo
(sin utilizar fórmulas matemáticas) para determinar la complejidad algorítmica del algoritmo.


*/


public class Actividad2 {


    public static int[] encontrarDosMayores(int[] lista) {
        return encontrarDosMayoresRecursivo(lista, 0, lista.length - 1);
    }

    private static int[] encontrarDosMayoresRecursivo(int[] lista, int inicio, int fin) {
        if (fin - inicio == 1) {  // Caso base: dos elementos
            int mayor1 = Math.max(lista[inicio], lista[fin]);
            int mayor2 = Math.min(lista[inicio], lista[fin]);
            return new int[] { mayor1, mayor2 };
        } else if (fin == inicio) {  // Caso base: un elemento
            return new int[] { lista[inicio], Integer.MIN_VALUE };
        }

        // Dividir el array en dos mitades
        int mitad = (inicio + fin) / 2;
        int[] izquierda = encontrarDosMayoresRecursivo(lista, inicio, mitad);
        int[] derecha = encontrarDosMayoresRecursivo(lista, mitad + 1, fin);

        // Conquistar y combinar
        int mayor1 = Math.max(izquierda[0], derecha[0]);
        int mayor2 = Math.max(Math.min(izquierda[0], derecha[0]), Math.max(izquierda[1], derecha[1]));

        return new int[] { mayor1, mayor2 };
    }

    public static void main(String[] args) {
        int[] lista = {10, 5, 20, 7, 3, 40, 50};
        int[] resultado = encontrarDosMayores(lista);
        System.out.println("Los dos mayores son: " + resultado[0] + " y " + resultado[1]);
    }

}

//PSEUDOCODIGO

/*
FUNCIÓN EncontrarDosMayores(lista, inicio, fin)
    SI fin == inicio + 1 ENTONCES
        SI lista[inicio] > lista[fin] ENTONCES
            RETORNAR lista[inicio], lista[fin]
        SINO
            RETORNAR lista[fin], lista[inicio]
        FIN SI
    SI fin == inicio ENTONCES
        RETORNAR lista[inicio], -infinito
    FIN SI

    mitad = (inicio + fin) / 2

    mayorIzquierda, segundoMayorIzquierda = EncontrarDosMayores(lista, inicio, mitad)
    mayorDerecha, segundoMayorDerecha = EncontrarDosMayores(lista, mitad + 1, fin)

    mayor1 = MÁXIMO(mayorIzquierda, mayorDerecha)
    mayor2 = MÁXIMO(MÍNIMO(mayorIzquierda, mayorDerecha), segundoMayorIzquierda, segundoMayorDerecha)

    RETORNAR mayor1, mayor2
FIN FUNCIÓN

FUNCIÓN Principal()
    lista = [arreglo de números]
    mayor1, mayor2 = EncontrarDosMayores(lista, 0, tamaño(lista) - 1)
    IMPRIMIR "Los dos mayores números son: ", mayor1, mayor2
FIN FUNCIÓN
 */
