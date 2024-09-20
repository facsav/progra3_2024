package Clase1;
public class act1_1_a {
/*Consigna 
Realizar un programa en java, dado un array, calcular el máximo.
¿ Cual es el orden de complejidad asintótica ?
*/
    public static void ejercicioA(){
        int [] numeros = {12454,8,5,23,34,54,214,1,90}; // 1
        int mayor = numeros[0]; //2
        for(int i=0; i < numeros.length;i++){ // 1 + 2 * (n+1)
            mayor = esMayor(mayor, numeros[i]); // 7
        }
    
        System.out.println("The mayor number is: " + mayor); //2
    }

    private static int esMayor(int mayor, int val) { // --> 7
        // TODO Auto-generated method stub
        if(val > mayor){ // 3
            return val; // 2
        }else{
            return mayor; //2
        }
    }
    

    public static void main(String[] args) {
        ejercicioA();


    }

}

/*
 * f(n) = 1 + 2 + 1 + 2 * (n + 1) + 7 + 2
 * f(n) = 1 + 2 + 1 + 2n + 2 + 7 + 2
 * f(n) = 2n + 15
 * 
 * 
 * 
 * Demostracion
 * 2n + 15 <= c.n
 * Dividimos por n --> 2 + 15/n <= c
 * Puedo elegir c= 5 
 * n0 = 5
 * 2 + 3 <= 5
 * 2 + 15/6 <= 5 --> se cumple para todos los n <= 5 
 */