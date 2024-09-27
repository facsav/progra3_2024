package Clase1;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class act1_1_b {
/*Consigna:
 * Un sistema de facturación, recibe una lista de comprobantes facturas
electrónicas, con id de factura, id de cliente, e importe y una lista de clientes,
con id cliente, y nombre de cliente, realizar un código de java, que genere
otra lista, con id cliente, nombre de cliente, suma importes de las facturas
¿ Cual es el orden de complejidad asintótica ?
 */
    public static class Factura {
        public int idFactura; 
        public int idCliente; 
        public float importe; 


        public Factura(int idFactura, int idCliente, float importe) {
            this.idFactura = idFactura; 
            this.idCliente = idCliente; 
            this.importe = importe; 
        }
    }


    public static class  Cliente {
        public int idCliente; 
        public String nombre; 
        
        public Cliente(int idCliente, String nombre) {
            this.idCliente = idCliente; 
            this.nombre = nombre; 
        }
    }

    public static class ElementoResultado{
        int idCliente;
        String nombre;
        float importeTotal; 

        public ElementoResultado(int idCliente, String nombre, float importeTotal){
            this.idCliente = idCliente; 
            this.nombre = nombre; 
            this.importeTotal = importeTotal; 
        }
    }


    public static List<ElementoResultado> resumenClientes(List<Factura> facturas, List<Cliente> clientes){
        List<ElementoResultado> resumen = new ArrayList<>(); 
        for(Cliente cliente : clientes){

            int idCliente = cliente.idCliente; 
            String nombre = cliente.nombre; 
            float importeTotal = 0; 

            for(Factura factura : facturas){ 
                if (factura.idCliente == idCliente) {
                    importeTotal += factura.importe; 
                }
            }
            ElementoResultado elem = new ElementoResultado(idCliente,nombre,importeTotal); 
            resumen.add(elem); 
        } 
        return resumen; 
    }


    public static void main(String[] args) {

        // Crear 3 clientes y agregarlos a la lista
        List<Cliente> clientes = new ArrayList<>(); 
        clientes.add(new Cliente(1, "Juan Perez")); 
        clientes.add(new Cliente(2, "Nicolas Hernandez")); 
        clientes.add(new Cliente(3, "Lucia Garcia")); 

        // Crear 10 facturas correspondientes a los 3 clientes
        List<Factura> facturas = new ArrayList<>(); 

        Random randomNumbers = new Random(); 
        for(int i = 0; i < randomNumbers.nextInt(5,15);i++){ 
            facturas.add(new Factura(i, randomNumbers.nextInt(4), randomNumbers.nextFloat(100,50000))); 
        } 
        List<ElementoResultado> resultado = resumenClientes(facturas, clientes); 

        for(ElementoResultado elem : resultado){
            System.out.println("Id del cliente: " + elem.idCliente + "; Nombre del cliente: " + elem.nombre + "; Importe total: " +
            elem.importeTotal); 
        }
    }
}
// El orden de complejidad asintótica es O(n*m) donde n es la cantidad de clientes y m es la cantidad de facturas.