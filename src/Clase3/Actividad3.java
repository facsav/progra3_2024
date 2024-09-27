package Clase3;

public class Actividad3 {





    static class Cliente {
        int id;
        String nombre;
        int scoring;

        public Cliente(int id, String nombre, int scoring) {
            this.id = id;
            this.nombre = nombre;
            this.scoring = scoring;
        }
    }

    public static void main(String[] args) {
        Cliente[] clientes = {
                new Cliente(1, "Carlos", 85),
                new Cliente(2, "Ana", 92),
                new Cliente(3, "Juan", 76),
                new Cliente(4, "Lucia", 95),
                new Cliente(5, "Pablo", 88)
        };

        Cliente[] mejoresClientes = encontrarDosMejoresClientes(clientes, 0, clientes.length - 1);
        System.out.println("Los dos mejores clientes son: " + mejoresClientes[0].nombre + " y " + mejoresClientes[1].nombre);
    }

    public static Cliente[] encontrarDosMejoresClientes(Cliente[] clientes, int inicio, int fin) {
        if (fin == inicio + 1) {
            if (clientes[inicio].scoring > clientes[fin].scoring) {
                return new Cliente[] { clientes[inicio], clientes[fin] };
            } else {
                return new Cliente[] { clientes[fin], clientes[inicio] };
            }
        }

        if (fin == inicio) {
            return new Cliente[] { clientes[inicio], null };
        }

        int mitad = (inicio + fin) / 2;
        Cliente[] mejoresIzquierda = encontrarDosMejoresClientes(clientes, inicio, mitad);
        Cliente[] mejoresDerecha = encontrarDosMejoresClientes(clientes, mitad + 1, fin);

        Cliente mejor1, mejor2;

        if (mejoresIzquierda[0].scoring > mejoresDerecha[0].scoring) {
            mejor1 = mejoresIzquierda[0];
            mejor2 = Math.max(mejoresIzquierda[1] != null ? mejoresIzquierda[1].scoring : Integer.MIN_VALUE, mejoresDerecha[0].scoring) == mejoresDerecha[0].scoring ? mejoresDerecha[0] : mejoresIzquierda[1];
        } else {
            mejor1 = mejoresDerecha[0];
            mejor2 = Math.max(mejoresDerecha[1] != null ? mejoresDerecha[1].scoring : Integer.MIN_VALUE, mejoresIzquierda[0].scoring) == mejoresIzquierda[0].scoring ? mejoresIzquierda[0] : mejoresDerecha[1];
        }

        return new Cliente[] { mejor1, mejor2 };
    }

}

//PSEUDOCODIGO

/*
FUNCIÓN EncontrarDosMejoresClientes(clientes, inicio, fin)
    SI fin == inicio + 1 ENTONCES
        SI clientes[inicio].scoring > clientes[fin].scoring ENTONCES
            RETORNAR clientes[inicio], clientes[fin]
        SINO
            RETORNAR clientes[fin], clientes[inicio]
        FIN SI
    SI fin == inicio ENTONCES
        RETORNAR clientes[inicio], NULL
    FIN SI

    mitad = (inicio + fin) / 2

    mejorIzquierda, segundoMejorIzquierda = EncontrarDosMejoresClientes(clientes, inicio, mitad)
    mejorDerecha, segundoMejorDerecha = EncontrarDosMejoresClientes(clientes, mitad + 1, fin)

    mayor1 = MAXIMO(mejorIzquierda.scoring, mejorDerecha.scoring)
    mayor2 = MAXIMO(MINIMO(mejorIzquierda.scoring, mejorDerecha.scoring), segundoMejorIzquierda.scoring, segundoMejorDerecha.scoring)

    SI mayor1 == mejorIzquierda.scoring ENTONCES
        cliente1 = mejorIzquierda
    SINO
        cliente1 = mejorDerecha
    FIN SI

    SI mayor2 == mejorIzquierda.scoring O mayor2 == segundoMejorIzquierda.scoring ENTONCES
        cliente2 = mejorIzquierda
    SINO
        cliente2 = mejorDerecha
    FIN SI

    RETORNAR cliente1, cliente2
FIN FUNCIÓN

FUNCIÓN Principal()
    clientes = [Lista de clientes con id, nombre y scoring]
    cliente1, cliente2 = EncontrarDosMejoresClientes(clientes, 0, tamaño(clientes) - 1)
    IMPRIMIR "Los dos mejores clientes son: ", cliente1.nombre, " y ", cliente2.nombre
FIN FUNCIÓN
 */
