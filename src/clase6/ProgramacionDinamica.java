package clase6;
//Actividad 2
public class ProgramacionDinamica {
    public static void main(String[] args) {
        int[] pesos = {2, 3, 4, 5};
        int[] valores = {3, 4, 5, 6};
        int capacidad = 10;
        int n = pesos.length;

        System.out.println("Valor máximo obtenido: " + knapsackDP(n, capacidad, pesos, valores));
    }

    public static int knapsackDP(int n, int P, int[] pesos, int[] valores) {

        int[][] dp = new int[n + 1][P + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= P; w++) {
                if (pesos[i - 1] <= w) {
                    dp[i][w] = Math.max(valores[i - 1] + dp[i - 1][w - pesos[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][P];
    }
}

