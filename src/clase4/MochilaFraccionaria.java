package clase4;
import java.util.Arrays;
import java.util.Collections;

import java.util.Arrays;
import java.util.Comparator;
//Actividad 3
class Objeto {
    double peso;
    double valor;

    public Objeto(double peso, double valor) {
        this.peso = peso;
        this.valor = valor;
    }


    public double valorPorPeso() {
        return valor / peso;
    }
}

public class MochilaFraccionaria {


    public static double cargarCamion(Objeto[] objetos, double capacidad) {

        Arrays.sort(objetos, new Comparator<Objeto>() {
            @Override
            public int compare(Objeto o1, Objeto o2) {
                return Double.compare(o2.valorPorPeso(), o1.valorPorPeso());
            }
        });

        double valorTotal = 0.0;
        double pesoRestante = capacidad;

        for (Objeto objeto : objetos) {
            if (pesoRestante > 0) {
                if (objeto.peso <= pesoRestante) {

                    valorTotal += objeto.valor;
                    pesoRestante -= objeto.peso;
                } else {

                    valorTotal += objeto.valorPorPeso() * pesoRestante;
                    pesoRestante = 0;
                }
            }
        }
        return valorTotal;
    }

    public static void main(String[] args) {

        Objeto[] objetos = {
                new Objeto(10, 60),
                new Objeto(20, 100),
                new Objeto(30, 120)
        };


        double capacidad = 50;


        double valorMaximo = cargarCamion(objetos, capacidad);

        System.out.println("El valor máximo que se puede cargar en el camión es: " + valorMaximo);
    }
}

