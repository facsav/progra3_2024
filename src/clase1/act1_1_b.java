package clase1;
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
        public int idFactura; // 1
        public int idCliente; // 1
        public float importe; // 1


        public Factura(int idFactura, int idCliente, float importe) {
            this.idFactura = idFactura; // 1
            this.idCliente = idCliente; // 1
            this.importe = importe; // 1
        }
    }

   

    public static class  Cliente {
        public int idCliente; // 1
        public String nombre; // 1
        
        public Cliente(int idCliente, String nombre) {
            this.idCliente = idCliente; // 1
            this.nombre = nombre; // 1
        }
    }

    public static class ElementoResultado{
        int idCliente; //1
        String nombre; //1
        float importeTotal; //1

        public ElementoResultado(int idCliente, String nombre, float importeTotal){
            this.idCliente = idCliente; //1
            this.nombre = nombre; //1
            this.importeTotal = importeTotal; //1
        }
    }


    public static List<ElementoResultado> resumenClientes(List<Factura> facturas, List<Cliente> clientes){
        List<ElementoResultado> resumen = new ArrayList<>(); //1
        for(Cliente cliente : clientes){ // n 

            int idCliente = cliente.idCliente; // 1
            String nombre = cliente.nombre; // 1
            float importeTotal = 0; // 1

            for(Factura factura : facturas){ // n
                if (factura.idCliente == idCliente) { // n
                    importeTotal += factura.importe; // 1
                }
            }
            ElementoResultado elem = new ElementoResultado(idCliente,nombre,importeTotal); // 2
            resumen.add(elem); // n
        } // n* [(n*n + 1) + 2 + n + 3]
        return resumen; // 1
    }


    public static void main(String[] args) {

        // Crear 3 clientes y agregarlos a la lista
        List<Cliente> clientes = new ArrayList<>(); // 1

        clientes.add(new Cliente(1, "Juan Perez")); //2
        clientes.add(new Cliente(2, "Nicolas Hernandez")); // 2
        clientes.add(new Cliente(3, "Lucia Garcia")); // 2

        // Crear 10 facturas correspondientes a los 3 clientes
        List<Factura> facturas = new ArrayList<>(); //1

        Random randomNumbers = new Random(); //1
        for(int i = 0; i < randomNumbers.nextInt(5,15);i++){ // 1 + 2 * (10 - 1)
            facturas.add(new Factura(i, randomNumbers.nextInt(4), randomNumbers.nextFloat(100,50000))); // 4
        } // 4 + 1 + 2 * (10 - 1)
       
        List<ElementoResultado> resultado = resumenClientes(facturas, clientes); //2

        for(ElementoResultado elem : resultado){ // 4 * n
            System.out.println("Id del cliente: " + elem.idCliente + "; Nombre del cliente: " + elem.nombre + "; Importe total: " +
            elem.importeTotal); // 4
        }
    }
}
