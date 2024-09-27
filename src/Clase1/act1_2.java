package Clase1;

import java.math.BigInteger;

public class act1_2 {
    /*Consigna:
    Hacer factorial con ese tipo de dato, probar limites 
     * ¿ Cómo usaría los tipos de datos long y BigInteger ?
     */
    public static int factorial(int n) {
        if (n == 0) { // Caso base
        return 1;
        } else { // Llamada recursiva
        return n * factorial(n - 1);
        }
    }

    public static long factorialLong(long n) {
        if (n == 0) { // Caso base
        return 1;
        } else { // Llamada recursiva
        return n * factorialLong(n - 1);
        }
    }

    public static BigInteger factorialBigInteger(BigInteger n) {
        if (n.compareTo(BigInteger.ZERO) == 0) { // Caso base
            return BigInteger.ONE;
        } else { // Llamada recursiva
            return n.multiply(factorialBigInteger(n.subtract(BigInteger.ONE)));
        }
    }
    public static void main(String[] args) {

        System.out.println("El factorial de 10 es: " + factorial(10));
        System.out.println("El factorial de 31 es: " + factorial(31)); // Numero mas grande que da un resultado positivo, luego da un resultado negativo o 0
        System.out.println("El factorial long de 65 es: " + factorialLong(65)); // Numero mas grande que da un resultado distinto de 0
        
        BigInteger bigInt = new BigInteger("100");
        System.out.println("El factorial BigInteger de 100 es: " + factorialBigInteger(bigInt));
        // utilizando BigInteger no existe un limite, es infinito
    }
}
