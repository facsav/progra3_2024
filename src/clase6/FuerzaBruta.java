package clase6;
//Actividad 2
public class FuerzaBruta {
    public static void main(String[] args) {
        int[] pesos = {2, 3, 4, 5};
        int[] valores = {3, 4, 5, 6};
        int capacidad = 10;
        int n = pesos.length;


        System.out.println("Valor máximo obtenido: " + fuerzaBruta(n, capacidad, pesos, valores));
    }
    public static int fuerzaBruta(int n, int P, int[] pesos, int[] valores) {
        return explorarCombinaciones(n, P, pesos, valores, 0);
    }


    public static int explorarCombinaciones(int n, int P, int[] pesos, int[] valores, int indice) {

        if (indice == n || P == 0) return 0;
        int sinIncluir = explorarCombinaciones(n, P, pesos, valores, indice + 1);

        if (pesos[indice] <= P) {
            int incluir = valores[indice] + explorarCombinaciones(n, P - pesos[indice], pesos, valores, indice + 1);
            return Math.max(sinIncluir, incluir);
        }

        return sinIncluir;
    }
}

