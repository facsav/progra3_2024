package clase3;
import java.util.Random;
public class act2_clase3 {

    public static int[] retornar2Mayores(int[] arreglo){
        if (arreglo.length < 2) {
            System.out.println("La lista debe tener al menos dos elementos");
            return null;
        }
        return retornar2MayoresRecursivo(arreglo, 0, arreglo.length - 1);
    }

    private static int[] retornar2MayoresRecursivo(int[] numeros, int bajo, int alto) {
        if (bajo == alto) {
            return new int[]{numeros[bajo], Integer.MIN_VALUE};
        }

        int medio = (bajo+alto) / 2;

        int[] mayoresIzquierda = retornar2MayoresRecursivo(numeros, bajo, medio);
        int[] mayoresDerecha = retornar2MayoresRecursivo(numeros, medio + 1, alto);

        return combinarDosMayores(mayoresIzquierda, mayoresDerecha);
    }

    private static int[] combinarDosMayores(int[] izquierda, int[] derecha) {
        int mayor1, mayor2;

        // Determinar el mayor
        if (izquierda[0] > derecha[0]) {
            mayor1 = izquierda[0];
            mayor2 = Math.max(derecha[0], Math.max(izquierda[1], derecha[1]));
        } else {
            mayor1 = derecha[0];
            mayor2 = Math.max(izquierda[0], Math.max(izquierda[1], derecha[1]));
        }

        // Asegurarse de que mayor1 y mayor2 sean distintos
        if (mayor1 == mayor2) {
            if (izquierda[1] != Integer.MIN_VALUE && izquierda[1] != mayor1) {
                mayor2 = izquierda[1];
            } else if (derecha[1] != Integer.MIN_VALUE && derecha[1] != mayor1) {
                mayor2 = derecha[1];
            }
        }

        return new int[]{mayor1, mayor2};
    }


    public static int[] llenarLista(int[] arreglo){
        int i=0;
        Random ran = new Random();
        while(i < arreglo.length){
            arreglo[i] = ran.nextInt(1,99);
            i++;
        }
        return arreglo;
    }

    public static String toString(int[] arreglo){
        String salida = "";
        for(int num : arreglo){
            salida+= num + " ";
        }
        return salida;
    }

    public static void main(String[] args) {
        int[] nums = new int[30];
        nums = llenarLista(nums);
        System.out.println(toString(nums));

        int[] dosMayores = retornar2Mayores(nums);
        System.out.println(toString(dosMayores));
    }
}
/*
 * La complejidad temporal del metodo es O(n log n)
 */