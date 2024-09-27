package clase6;
//Actividad 1
public class Mochila {
    public static void main(String[] args) {
        int[] pesos = {1, 2, 3, 4};
        int[] valores = {1, 2, 4, 5};
        int capacidad = 6;
        int n = pesos.length;

        int[][] dp = new int[n + 1][capacidad + 1];


        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacidad; w++) {
                if (pesos[i - 1] <= w) {
                    dp[i][w] = Math.max(valores[i - 1] + dp[i - 1][w - pesos[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }


        System.out.println("El valor máximo que se puede obtener es: " + dp[n][capacidad]);


        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacidad; w++) {
                System.out.print(dp[i][w] + "\t");
            }
            System.out.println();
        }
    }
}
