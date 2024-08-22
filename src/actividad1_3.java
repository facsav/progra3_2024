package Clase2;
import java.util.Random;
public class actividad1_3 {
    /*
     * Sumar los primeros n números enteros, implementando en java un algoritmo que use recursión.
     * Realice el análisis de recurrencia.
    */

    public static int SumarPrimerosNNumeros(int n){
        if(n == 0){
            return 0;
        }else{
            return n + SumarPrimerosNNumeros(n - 1);
        }
    } 
    /*
     * Analisis de recurrencia del metodo:
     * T(n) =  T(n-1) + O(1)
     */
    public static void main(String[] args) {
        Random rand = new Random();
        int cantidadNumeros = rand.nextInt(1,500);
        int resultado = SumarPrimerosNNumeros(cantidadNumeros);
        System.out.println("El resultado de sumar los primeros " + cantidadNumeros + " numeros enteros es: " + resultado);
    }
}
