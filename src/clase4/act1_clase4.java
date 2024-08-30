package clase4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class act1_clase4 {
    // Función para encontrar la cantidad mínima de monedas
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
        }else{
            System.out.println("No es posible armar el monto: " + monto);
            return null;
        }
        
    }

    public static boolean esPosibleDarVuelto(int[] monedas, int monto){
        Arrays.sort(monedas);
        for (int i = monedas.length - 1; i >= 0; i--) {
            while (monto >= monedas[i]) {
                monto -= monedas[i];
            }
        }
        return monto == 0;
    }
    public static void main(String[] args) {
        int[] monedas = {1, 5, 10, 25};
        List<Integer> resultado = encontrarMinimoMonedas(monedas, 36);
        System.out.println(esPosibleDarVuelto(monedas, 57));
    }
}
// hecho