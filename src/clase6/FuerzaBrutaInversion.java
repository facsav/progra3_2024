package clase6;
//Actividad 4
public class FuerzaBrutaInversion {
    public static void main(String[] args) {
        int[] costos = {12, 20, 15, 25};
        int[] ganancias = {150, 200, 100, 300};
        int presupuesto = 35;

        int maxGanancia = fuerzaBruta(costos, ganancias, presupuesto, 0);
        System.out.println("Ganancia máxima (Fuerza Bruta): " + maxGanancia);
    }

    public static int fuerzaBruta(int[] costos, int[] ganancias, int presupuesto, int indice) {
        if (indice == costos.length || presupuesto == 0) return 0;

        int sinIncluir = fuerzaBruta(costos, ganancias, presupuesto, indice + 1);

        int incluir = 0;
        if (costos[indice] <= presupuesto) {
            incluir = ganancias[indice] + fuerzaBruta(costos, ganancias, presupuesto - costos[indice], indice + 1);
        }

        return Math.max(sinIncluir, incluir);
    }
}

