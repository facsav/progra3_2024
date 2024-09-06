package clase4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Un sistema de tesorería tiene a disposición una variedad de comprobantes que incluyen monedas, 
 * cheques, bonos y otros documentos financieros. Cada comprobante tiene un valor específico.
 * El objetivo es realizar una compra de moneda extranjera minimizando el número de comprobantes utilizados.
 */
public class act2_clase4 {
   
    public static class Comprobante implements Comparable<Comprobante> {
        public String descripcion;
        public double valor;
    
        public Comprobante(String descipcion, double valor){
            this.descripcion = descipcion;
            this.valor = valor;
        }
    
        @Override
        public int compareTo(Comprobante other) {
            return Double.compare(this.valor, other.valor);
        }

        @Override
        public String toString() {
            return descripcion + ": " + valor;
        }
    }

    public static class MonedaExtranjera {
        public String descripcion;
        public double valorEnPesos;

        public MonedaExtranjera(String descripcion, double valorEnPesos) {
            this.descripcion = descripcion;
            this.valorEnPesos = valorEnPesos;
        }
    }
    public static List<Comprobante> minimizarComprobantes(Comprobante[] comprobantes, MonedaExtranjera moneda, int cantidad){
        double total = cantidad * moneda.valorEnPesos;
        Arrays.sort(comprobantes);
        List<Comprobante> resultado = new ArrayList<>();
        for (int i = comprobantes.length - 1; i >= 0; i--) {
            while (total >= comprobantes[i].valor) {
                total -= comprobantes[i].valor;
                resultado.add(comprobantes[i]);
            }
        }
        return resultado;
    }/*
    * La complejidad temporal del metodo es O(n log n)
    */
    public static void main(String[] args) {
        Comprobante c1 = new Comprobante("bono", 10000);
        Comprobante c2 = new Comprobante("cheque", 5000);
        Comprobante c3 = new Comprobante("moneda50", 0.50);
        Comprobante c4 = new Comprobante("moneda25", 0.25);
        Comprobante c5 = new Comprobante("moneda1", 0.01);
        Comprobante c6 = new Comprobante("billete100", 100);
        Comprobante c7 = new Comprobante("billete1000", 1000);
        Comprobante c8 = new Comprobante("billete2000", 2000);

        Comprobante[] comprobantes = {c1, c2, c3, c4, c5, c6, c7, c8};

        MonedaExtranjera m1 = new MonedaExtranjera("dolar", 1257.76);
        MonedaExtranjera m2 = new MonedaExtranjera("euro", 1500.43);
        MonedaExtranjera m3 = new MonedaExtranjera("libra", 2000.91);
        MonedaExtranjera m4 = new MonedaExtranjera("real", 300.73);
        

        List<Comprobante> resultado = minimizarComprobantes(comprobantes, m4, 10);
        System.out.println("Comprobantes necesarios: " + resultado);

    }
}
