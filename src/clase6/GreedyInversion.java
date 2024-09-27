package clase6;

import java.util.Arrays;
//Actividad 4
public class GreedyInversion {
    public static void main(String[] args) {
        int[] costos = {12, 20, 15, 25};
        int[] ganancias = {150, 200, 100, 300};
        int presupuesto = 35;

        double maxGanancia = greedy(costos, ganancias, presupuesto);
        System.out.println("Ganancia máxima (Greedy): " + maxGanancia);
    }

    public static double greedy(int[] costos, int[] ganancias, int presupuesto) {
        int n = costos.length;
        double[] ratio = new double[n];

        for (int i = 0; i < n; i++) {
            ratio[i] = (double) ganancias[i] / costos[i];
        }

        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) indices[i] = i;
        Arrays.sort(indices, (a, b) -> Double.compare(ratio[b], ratio[a]));

        double gananciaTotal = 0;
        for (int i = 0; i < n && presupuesto > 0; i++) {
            int index = indices[i];
            if (costos[index] <= presupuesto) {
                presupuesto -= costos[index];
                gananciaTotal += ganancias[index];
            }
        }

        return gananciaTotal;
    }
}
