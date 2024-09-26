package Clase1;
public class act1_1_a {
/*Consigna 
Realizar un programa en java, dado un array, calcular el máximo.
¿ Cual es el orden de complejidad asintótica ?
*/
    public static void ejercicioA(){
        int [] numeros = {12454,8,5,23,34,54,214,1,90}; // 1
        int mayor = numeros[0]; //2
        for(int i=0; i < numeros.length;i++){
            mayor = esMayor(mayor, numeros[i]);
        }
    
        System.out.println("The mayor number is: " + mayor); 
    }

    private static int esMayor(int mayor, int val) { 
        if(val > mayor){ 
            return val; 
        }else{
            return mayor; 
        }
    }
    

    public static void main(String[] args) {
        ejercicioA();


    }

}

//El orden de complejidad asintótica es O(n) ya que el algoritmo recorre el array una vez.