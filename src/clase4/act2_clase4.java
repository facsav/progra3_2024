package clase4;

import java.util.ArrayList;
import java.util.Arrays;
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
        Comprobante c3 = new Comprobante("moneda050", 0.50);
        Comprobante c4 = new Comprobante("moneda025", 0.25);
        Comprobante c5 = new Comprobante("moneda01", 0.01);
        Comprobante c6 = new Comprobante("billete100", 100);
        Comprobante c7 = new Comprobante("billete1000", 1000);
        Comprobante c8 = new Comprobante("billete2000", 2000);
        Comprobante c9 = new Comprobante("billete200", 200);
        Comprobante c10 = new Comprobante("billete500", 500);
        Comprobante c11 = new Comprobante("billete50", 50);
        Comprobante c12 = new Comprobante("billete20", 20);
        Comprobante c13 = new Comprobante("moneda1", 1);
        Comprobante c14 = new Comprobante("moneda2", 2);
        Comprobante c15 = new Comprobante("moneda5", 10);
        Comprobante c16 = new Comprobante("moneda10", 20);

        Comprobante[] comprobantes = {c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12,c13,c14,c15,c16};
        MonedaExtranjera m1 = new MonedaExtranjera("dolar", 1257.76);
        MonedaExtranjera m2 = new MonedaExtranjera("euro", 1500.43);
        MonedaExtranjera m3 = new MonedaExtranjera("libra", 2000.91);
        MonedaExtranjera m4 = new MonedaExtranjera("real", 300.73);
        

        List<Comprobante> resultado = minimizarComprobantes(comprobantes, m1, 10);
        System.out.println("Comprobantes necesarios: " + resultado);

    }
}
