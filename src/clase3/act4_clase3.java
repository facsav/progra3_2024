package clase3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class act4_clase3 {
    
    public static List<Integer> encontrarNElementosMasGrandes(List<Integer> numeros, int n){
        if(numeros.size() < n){
            System.out.println("Se piden mas elemenos de los que tiene la lista.");
        }else if (numeros.size() == n) {
            Collections.sort(numeros);
            return numeros;
        }

        int medio = numeros.size() / 2;

        List<Integer> izquierda = numeros.subList(0, medio);
        List<Integer> derecha = numeros.subList(medio, numeros.size());

        List<Integer> mayoresIzquierda = encontrarNElementosMasGrandes(new ArrayList<>(izquierda),n);
        List<Integer> mayoresDerecha = encontrarNElementosMasGrandes(new ArrayList<>(derecha),n);
    
        return combinarNMayores(mayoresIzquierda, mayoresDerecha, n);
    }

    public static List<Integer> combinarNMayores(List<Integer> izquierda, List<Integer> derecha, int n){
        List<Integer> combinadas = new ArrayList<>();

        combinadas.addAll(izquierda);
        combinadas.addAll(derecha);

        Collections.sort(combinadas, Collections.reverseOrder());

        return combinadas.subList(0, n);
    }

    public static List<Integer> llenarLista(List<Integer> numeros){
        Random ran = new Random();
        for(int i = 0;i <10; i++){
            numeros.add(ran.nextInt(10,100));
        }
        return numeros;
    }

    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<Integer>();
        llenarLista(numeros);
        System.out.println(numeros);

        List<Integer> resultado = encontrarNElementosMasGrandes(numeros, 5);
        System.out.println("Los " + 5 + " mayores elementos son: " + resultado);
    }
}
/*
 * Objetivo: Encontrar los "n" elementos más grandes en una lista utilizando la técnica de Divide y Vencerás
Tareas:
Realizar el análisis de recurrencia mediante método inductivo (sin utilizar fórmulas matemáticas) para indicar la complejidad algorítmica.
Implementar en java

 */

/*
 * La complejidad temporal del metodo es O(n log n)
 */