package clase4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * Una empresa distribuidora necesita cargar un camión con mercancía que se puede fraccionar. 
 * Indicar con una lista los elementos a 
 * subir al camión para maximizar el valor total, dado que el camión tiene una capacidad limitada.
 */
public class act3_clase4 {
    public static class Camion{
        int capacidad;
        List<Elemento> elementos;

        public Camion(int capacidad){
            this.capacidad = capacidad;
            this.elementos = new ArrayList<>();
        }
    }

    public static class Elemento{
        String descripcion;
        int valor;
        int peso;
        int relacionVW = valor / peso;

        public Elemento(String descripcion, int valor, int peso){
            this.descripcion = descripcion;
            this.valor = valor;
            this.peso = peso;
        }

        @Override
        public String toString() {
            return descripcion + " (Peso: " + peso + ", Valor: " + valor + ")";
        }
    }

    public static List<String> cargarCamion(Camion camion, Elemento[] elementos){
        List<String> resultado = new ArrayList<>();
        int pesoTotal = 0;
        double valorTotal = 0;

        Arrays.sort(elementos, new Comparator<Elemento>() {
            @Override
            public int compare(Elemento e1, Elemento e2) {
                return Integer.compare(e1.valor, e2.valor);
            }
        });
        for (Elemento elemento : elementos) {
            if (valorTotal + elemento.valor <= camion.capacidad) {
                resultado.add(elemento.toString());
                pesoTotal += elemento.peso;
                valorTotal += elemento.valor;
            }/*  else {
                int valorRestante = camion.capacidad - valorTotal;
                double fraccion = (double) pesoRestante / elemento.peso;
                resultado.add(elemento.descripcion + " (Peso: " + pesoRestante + ", Valor: " + (elemento.valor * fraccion) + ")");
                valorTotal += elemento.valor * fraccion;
                break;
            }*/
        }

        System.out.println("Valor total cargado: " + valorTotal);
        return resultado;
    }
    public static void main(String[] args) {
        Elemento e1 = new Elemento("e1",30,10);
        Elemento e2 = new Elemento("e2",50,20);
        Elemento e3 = new Elemento("e3",60,30);

        Elemento[] elementos = {e1,e2,e3};

        Camion camion = new Camion(120);

        List<String> res = cargarCamion(camion, elementos);
        System.out.println("Elementos cargados en el camión:");
        for (String e : res) {
            System.out.println(e);
        }
    }
}
