package clase3;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class act1_clase3 {
    public static class  Cliente {
        int id;
        String nombre;
        int scoring;

        public Cliente(int id, String nombre, int scoring){
            this.id = id;
            this.nombre = nombre;
            this.scoring = scoring;
        }

        @Override
        public String toString() {
            return "Cliente [ID=" + id + ", Nombre=" + nombre + ", Scoring=" + scoring + "]";
        }
    }

    public static Cliente clienteConMaximoScoring(List<Cliente> clientes){
        if(clientes.isEmpty()){
            System.out.println("La lista esta vacia");
            return null;
        }
        return clienteConMaximoScoringRecursivo(clientes, 0, clientes.size() -1);
    }

    private static Cliente clienteConMaximoScoringRecursivo(List<Cliente> clientes, int bajo, int alto){
        if (bajo == alto) {
            return clientes.get(bajo);
        }

        int medio = (bajo + alto) / 2;

        Cliente maxIzquierda = clienteConMaximoScoringRecursivo(clientes, bajo, medio);
        Cliente maxDerecha = clienteConMaximoScoringRecursivo(clientes, medio + 1, alto);

        return maxIzquierda.scoring > maxDerecha.scoring ? maxIzquierda : maxDerecha;
    } 

    public static List<Cliente> llenarClientes(List<Cliente> clientes){
        String[] nombresParte1 = {"Ari", "Bel", "Car", "Dav", "Eva", "Fla", "Gil", "Hes", "Iza", "Jen"};
        String[] nombresParte2 = {"an", "en", "in", "or", "ar", "os", "us", "el", "ra", "la"};
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int id = i + 1; // IDs del 1 al 10
            String nombre = nombresParte1[random.nextInt(nombresParte1.length)] +
                            nombresParte2[random.nextInt(nombresParte2.length)]; 
            int scoring = random.nextInt(0,10000); 

            Cliente cliente = new Cliente(id, nombre, scoring);
            clientes.add(cliente);
        }
        return clientes;
    }


    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes = llenarClientes(clientes);
        for(Cliente cliente : clientes){
            System.out.println(cliente);
        }
        Cliente maxCliente = clienteConMaximoScoring(clientes);
        if (maxCliente != null) {
            System.out.println("Cliente con máximo scoring:");
            System.out.println(maxCliente); // Utiliza el método toString() implícitamente
        }
    }
}
/*
 * La complejidad temporal del metodo clienteConMaximoScoring es O(n log n)
 */