package clase6;
//Actividad 4
public class ProgramacionDinamicaInversion {
    public static void main(String[] args) {
        int[] costos = {12, 20, 15, 25};
        int[] ganancias = {150, 200, 100, 300};
        int presupuesto = 35;

        int maxGanancia = programacionDinamica(costos, ganancias, presupuesto);
        System.out.println("Ganancia máxima (Programación Dinámica): " + maxGanancia);
    }

    public static int programacionDinamica(int[] costos, int[] ganancias, int presupuesto) {
        int n = costos.length;

        int[][] dp = new int[n + 1][presupuesto + 1];

        for (int i = 1; i <= n; i++) {
            for (int p = 1; p <= presupuesto; p++) {
                if (costos[i - 1] <= p) {
                    dp[i][p] = Math.max(ganancias[i - 1] + dp[i - 1][p - costos[i - 1]], dp[i - 1][p]);
                } else {
                    dp[i][p] = dp[i - 1][p];
                }
            }
        }
        
        return dp[n][presupuesto];
    }
}

