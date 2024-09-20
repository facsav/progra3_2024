package Clase5;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
//Actividad 1
public class RedSocial {

    // Mapa para representar la lista de adyacencia (usuario -> lista de usuarios que sigue)
    private Map<String, List<String>> seguidores;

    // Constructor
    public RedSocial() {
        seguidores = new HashMap<>();
    }

    // Método para agregar un usuario
    public void agregarUsuario(String usuario) {
        if (!seguidores.containsKey(usuario)) {
            seguidores.put(usuario, new ArrayList<>());
            System.out.println("Usuario " + usuario + " agregado a la red social.");
        } else {
            System.out.println("El usuario " + usuario + " ya existe.");
        }
    }

    // Método para que un usuario siga a otro usuario
    public void seguir(String seguidor, String seguido) {
        // Ambos usuarios deben existir
        if (!seguidores.containsKey(seguidor)) {
            System.out.println("El usuario " + seguidor + " no existe.");
            return;
        }

        if (!seguidores.containsKey(seguido)) {
            System.out.println("El usuario " + seguido + " no existe.");
            return;
        }

        // Agregamos al usuario seguido en la lista del seguidor
        List<String> listaDeSeguidos = seguidores.get(seguidor);
        if (!listaDeSeguidos.contains(seguido)) {
            listaDeSeguidos.add(seguido);
            System.out.println(seguidor + " ahora sigue a " + seguido);
        } else {
            System.out.println(seguidor + " ya sigue a " + seguido);
        }
    }

    // Método para consultar los usuarios que un usuario sigue
    public List<String> obtenerSeguidos(String usuario) {
        if (seguidores.containsKey(usuario)) {
            return seguidores.get(usuario);
        } else {
            System.out.println("El usuario " + usuario + " no existe.");
            return new ArrayList<>();
        }
    }

    // Método para consultar los usuarios que siguen a un determinado usuario
    public List<String> obtenerSeguidores(String usuario) {
        List<String> listaSeguidores = new ArrayList<>();

        // Recorrer el mapa para encontrar quién sigue al usuario dado
        for (Map.Entry<String, List<String>> entry : seguidores.entrySet()) {
            if (entry.getValue().contains(usuario)) {
                listaSeguidores.add(entry.getKey());
            }
        }

        return listaSeguidores;
    }

    // Método para mostrar la red completa (para ver la lista de adyacencia)
    public void mostrarRed() {
        for (Map.Entry<String, List<String>> entry : seguidores.entrySet()) {
            System.out.println(entry.getKey() + " sigue a: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        // Crear la red social
        RedSocial redSocial = new RedSocial();

        // Agregar usuarios
        redSocial.agregarUsuario("Alice");
        redSocial.agregarUsuario("Bob");
        redSocial.agregarUsuario("Charlie");

        // Establecer relaciones de seguidores
        redSocial.seguir("Alice", "Bob");
        redSocial.seguir("Alice", "Charlie");
        redSocial.seguir("Bob", "Charlie");

        // Mostrar la red social
        redSocial.mostrarRed();

        // Consultar a quién sigue un usuario
        System.out.println("Usuarios que sigue Alice: " + redSocial.obtenerSeguidos("Alice"));

        // Consultar quién sigue a un usuario
        System.out.println("Usuarios que siguen a Charlie: " + redSocial.obtenerSeguidores("Charlie"));
    }
}
