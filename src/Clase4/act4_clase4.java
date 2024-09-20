package Clase4;

import java.util.Arrays;
import java.util.Scanner;

public class act4_clase4 {
    public static int getMinimumCost(int k, int[] c) {
        Arrays.sort(c);
        int n = c.length;
        int totalCost = 0;

        // Recorrer el array de precios desde el más caro al más barato
        for (int i = 0; i < n; i++) {
            // Calcular el costo de la flor actual
            totalCost += c[n - 1 - i] * (i / k + 1);
        }

        return totalCost;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de flores disponibles: ");
        int n = scanner.nextInt();
        System.out.print("Ingrese la cantidad de amigos que compraran flores: ");
        int k = scanner.nextInt();
        
        int[] c = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese el precio de la flor " + (i + 1) + ": ");
            c[i] = scanner.nextInt();
        }

        int minimumCost = getMinimumCost(k, c);
        System.out.println(minimumCost);

        scanner.close();
    }
}