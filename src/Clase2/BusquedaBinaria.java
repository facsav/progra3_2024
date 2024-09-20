package Clase2;

public class BusquedaBinaria {
/*Consigna:
 * Utilizar la implementación de la búsqueda binaria que está en el repo de la
materia, para buscar un elemento en un array ordenado.
 */
    // Método para realizar la búsqueda binaria
    public static int busquedaBinaria(int[] arreglo, int objetivo) {
        int izquierda = 0;
        int derecha = arreglo.length - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            // Verificar si el objetivo está en el medio
            if (arreglo[medio] == objetivo) {
                return medio; // Retorna el índice del objetivo
            }

            // Si el objetivo es mayor, ignorar la mitad izquierda
            if (arreglo[medio] < objetivo) {
                izquierda = medio + 1;
            } 
            // Si el objetivo es menor, ignorar la mitad derecha
            else {
                derecha = medio - 1;
            }
        }

        // Si no se encuentra el objetivo, retorna -1
        return -1;
    }

    public static String verificarResultado(int res){
        if (res == -1) {
           return "Elemento no encontrado en el arreglo";
        } else {
            return "Elemento encontrado en la posicion : " + (res+1);
        }
    }
    public static void main(String[] args) {
        int[] arreglo = {1, 3, 5, 7, 9, 11, 13};
        int resultado = busquedaBinaria(arreglo, 7);

        System.out.println(verificarResultado(resultado));
        
        int res2 = busquedaBinaria(arreglo, 90);
        System.out.println(verificarResultado(res2));
    }
}