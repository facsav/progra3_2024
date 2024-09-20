package Clase4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class act1_clase4 {
    /*
     * Dada una lista de monedas con denominaciones convencionales (1, 5, 10, 25, etc.), 
     * implementar una función greedy que determine si es posible entregar un cambio exacto utilizando una lista de monedas disponible.
     */
    public static List<Integer> encontrarMinimoMonedas(int[] monedas, int monto) {
        if (esPosibleDarVuelto(monedas, monto)) {
            int cantidad = monto;   
            
            Arrays.sort(monedas);
            List<Integer> resultado = new ArrayList<>();
            for (int i = monedas.length - 1; i >= 0; i--) {
                while (monto >= monedas[i]) {
                    monto -= monedas[i];
                    resultado.add(monedas[i]);
                }
            }
            System.out.println("Monedas usadas para hacer " + cantidad + ": " + resultado);
            return resultado;
        }
        return null;
        
    }

    public static boolean esPosibleDarVuelto(int[] monedas, int monto){
        Arrays.sort(monedas);
        int cantidad = monto;
        for (int i = monedas.length - 1; i >= 0; i--) {
            while (monto >= monedas[i]) {
                monto -= monedas[i];
            }
        }
        if (monto != 0) {
            System.out.println("No es posible dar el vuelto exacto de: " + cantidad);
            return false;
        }else 
            return true;
    }/*
    * La complejidad temporal del metodo es O(n log n)
    */
    public static void main(String[] args) {
        int[] monedas = {1, 5, 10, 25};
        encontrarMinimoMonedas(monedas, 36);
        encontrarMinimoMonedas(monedas, 972);
        System.out.println(esPosibleDarVuelto(monedas, 57));
    }
}
