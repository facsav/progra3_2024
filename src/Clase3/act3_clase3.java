package Clase3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class act3_clase3 {
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

    public static List<Cliente> retornarDosClienteConMaximoScoring(List<Cliente> clientes){
        if(clientes.size() < 2){
            System.out.println("La lista contiene menos de dos elementos");
            return null;
        }
        return retornarDosClienteConMaximoScoringRecursivo(clientes, 0, clientes.size() -1);
    }

    private static List<Cliente> retornarDosClienteConMaximoScoringRecursivo(List<Cliente> clientes, int bajo, int alto){
        if (bajo == alto) {
            List<Cliente> resultado = new ArrayList<>();
            resultado.add(clientes.get(bajo));
            return resultado;
        }

        int medio = (bajo + alto) / 2;

        List<Cliente> maxIzquierda = retornarDosClienteConMaximoScoringRecursivo(clientes, bajo, medio);
        List<Cliente> maxDerecha = retornarDosClienteConMaximoScoringRecursivo(clientes, medio + 1, alto);

        return combinarDosListas(maxIzquierda, maxDerecha);
    } 

    private static List<Cliente> combinarDosListas(List<Cliente> lista1, List<Cliente> lista2){
        List<Cliente> combinados = new ArrayList<>();
        combinados.addAll(lista1);
        combinados.addAll(lista2);

        combinados.sort((c1, c2) -> c2.scoring - c1.scoring);

        // Retornar los dos primeros elementos (los de mayor scoring)
        return combinados.subList(0, 2);
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
        List<Cliente> maximosClientes = retornarDosClienteConMaximoScoring(clientes);

        if (maximosClientes != null) {
            System.out.println("Los dos clientes con máximo scoring son:");
            for(Cliente cliente : maximosClientes){
                System.out.println(cliente);
            }
        }
    }
}
/*
 * La complejidad temporal del metodo es O(n log n)
 */