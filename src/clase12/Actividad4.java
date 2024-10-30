package clase12;

import java.util.*;

public class Actividad4 {

    static class Usuario {
        private int id;
        private String nombre;

        public Usuario(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        public int getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        @Override
        public String toString() {
            return nombre + " (ID: " + id + ")";
        }
    }

    static class RedSocial {
        private Map<Integer, Usuario> usuarios;
        private Map<Integer, List<Integer>> amistades;

        public RedSocial() {
            usuarios = new HashMap<>();
            amistades = new HashMap<>();
        }


        public void agregarUsuario(Usuario usuario) {
            usuarios.put(usuario.getId(), usuario);
            amistades.putIfAbsent(usuario.getId(), new ArrayList<>());
        }


        public void conectarAmistad(int id1, int id2) {
            if (usuarios.containsKey(id1) && usuarios.containsKey(id2)) {
                amistades.get(id1).add(id2);
                amistades.get(id2).add(id1);
            }
        }


        public void dfs(int idInicio) {
            Set<Integer> visitados = new HashSet<>();
            System.out.println("Recorrido DFS:");
            dfsRecursivo(idInicio, visitados);
        }

        private void dfsRecursivo(int idActual, Set<Integer> visitados) {
            if (!visitados.contains(idActual)) {
                visitados.add(idActual);
                System.out.println(usuarios.get(idActual));

                for (int amigo : amistades.get(idActual)) {
                    if (!visitados.contains(amigo)) {
                        dfsRecursivo(amigo, visitados);
                    }
                }
            }
        }

        public void bfs(int idInicio) {
            Set<Integer> visitados = new HashSet<>();
            Queue<Integer> cola = new LinkedList<>();

            cola.add(idInicio);
            visitados.add(idInicio);
            System.out.println("Recorrido BFS:");

            while (!cola.isEmpty()) {
                int idActual = cola.poll();
                System.out.println(usuarios.get(idActual));

                for (int amigo : amistades.get(idActual)) {
                    if (!visitados.contains(amigo)) {
                        visitados.add(amigo);
                        cola.add(amigo);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        RedSocial redSocial = new RedSocial();

        Usuario usuario1 = new Usuario(1, "Alice");
        Usuario usuario2 = new Usuario(2, "Bob");
        Usuario usuario3 = new Usuario(3, "Charlie");
        Usuario usuario4 = new Usuario(4, "Diana");
        Usuario usuario5 = new Usuario(5, "Eve");


        redSocial.agregarUsuario(usuario1);
        redSocial.agregarUsuario(usuario2);
        redSocial.agregarUsuario(usuario3);
        redSocial.agregarUsuario(usuario4);
        redSocial.agregarUsuario(usuario5);


        redSocial.conectarAmistad(1, 2);
        redSocial.conectarAmistad(1, 3);
        redSocial.conectarAmistad(2, 4);
        redSocial.conectarAmistad(3, 5);
        redSocial.conectarAmistad(4, 5);

        redSocial.dfs(1);
        System.out.println();
        redSocial.bfs(1);
    }
}
