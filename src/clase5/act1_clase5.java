package clase5;

import java.util.ArrayList;
import java.util.List;

public class act1_clase5 {
    /*
     * Desarrolla un programa que modele un sistema de seguidores en una red social
    utilizando un grafo representado con una lista de adyacencia. En este sistema,
    cada usuario puede seguir a otros usuarios, y queremos almacenar y consultar
    estas relaciones de manera eficiente.
    Especificaciones:
    Representación del Grafo:
    Utiliza una lista de adyacencia para representar el grafo. En esta representación,
    cada nodo (usuario) tiene una lista de nodos a los que sigue (usuarios que lo siguen).
    */

    static class Usuario {
        String username;
        List<Usuario> seguidos;
    
        public Usuario(String username) {
            this.username = username;
            this.seguidos = new ArrayList<>();
        }
        
        public void agregarSeguido(Usuario seguido) {
            for(Usuario usuario : this.seguidos){
                if(usuario.username.equals(seguido.username)){
                    System.out.println("Este usuario ya sigue a " + seguido.username);
                    return;
                }
            }
            this.seguidos.add(seguido);
        }
    
        public void devolverSeguidos() {
            for (Usuario seguido : this.seguidos) {
                System.out.println(seguido.username);
            }
        }
          
    }

    public static void main(String[] args) {
        List<Usuario> grafo = new ArrayList<>();

        Usuario usuario1 = new Usuario("nicoNA");
        Usuario usuario2 = new Usuario("Almiklopp");
        Usuario usuario3 = new Usuario("Chadvincula");
        Usuario usuario4 = new Usuario("Burrentiel");

        grafo.add(usuario1);
        grafo.add(usuario2);
        grafo.add(usuario3);
        grafo.add(usuario4);
        // Hacer que el primer usuario siga a todos los demás
        usuario1.agregarSeguido(usuario2);
        usuario1.agregarSeguido(usuario2);
        usuario1.agregarSeguido(usuario3);
        usuario1.agregarSeguido(usuario4);
        usuario2.agregarSeguido(usuario3);

        // Devolver seguidos del primer usuario
        usuario1.devolverSeguidos();
        //for(Usuario usuario : grafo){
          //  System.out.println(usuario.username);
        //} 
    }
}
