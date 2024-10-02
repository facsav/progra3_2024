package clase6;
//Actividad 3
public class SeleccionOptimaDeProyectos {
    public static void main(String[] args) {
        int[] costos = {1, 3, 4, 5};
        int[] beneficios = {1500, 2000, 3000, 3500};
        int presupuesto = 7;

        int beneficioMaximo = seleccionarProyectos(costos, beneficios, presupuesto);
        System.out.println("El beneficio máximo que se puede obtener es: " + beneficioMaximo);
    }

    public static int seleccionarProyectos(int[] costos, int[] beneficios, int presupuesto) {
        int n = costos.length;

        int[][] dp = new int[n + 1][presupuesto + 1];

        for (int i = 1; i <= n; i++) {
            for (int p = 1; p <= presupuesto; p++) {
                if (costos[i - 1] <= p) {
                    int incluir = beneficios[i - 1] + dp[i - 1][p - costos[i - 1]];
                    int noIncluir = dp[i - 1][p];
                    dp[i][p] = Math.max(incluir, noIncluir);
                } else {
                    dp[i][p] = dp[i - 1][p];
                }
            }
        }
        
        return dp[n][presupuesto];
    }
}

