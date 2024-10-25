package Clase3;

import java.util.ArrayList;
import java.util.List;

class Cliente {
    int id;
    String nombre;
    double scoring;

    public Cliente(int id, String nombre, double scoring) {
        this.id = id;
        this.nombre = nombre;
        this.scoring = scoring;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre='" + nombre + '\'' + ", scoring=" + scoring + '}';
    }
}

public class Actividad1 {

    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "Juan Perez", 85.5));
        clientes.add(new Cliente(2, "Maria Lopez", 92.0));
        clientes.add(new Cliente(3, "Carlos Garcia", 78.3));
        clientes.add(new Cliente(4, "Ana Martinez", 89.7));
        clientes.add(new Cliente(5, "Luis Gomez", 91.2));

        Cliente mejorCliente = encontrarMejorCliente(clientes);
        System.out.println("Cliente con el scoring máximo: " + mejorCliente);
    }

    private static Cliente encontrarMejorCliente(List<Cliente> clientes) {
        return encontrarMejorCliente(clientes, 0, clientes.size());
    }

    private static Cliente encontrarMejorCliente(List<Cliente> clientes, int i, int f) {
        if (i == f - 1) return clientes.get(i);

        int mitad = (i + f) / 2;
        Cliente mejorIzquierda = encontrarMejorCliente(clientes, i, mitad);
        Cliente mejorDerecha = encontrarMejorCliente(clientes, mitad, f);

        return (mejorIzquierda.scoring > mejorDerecha.scoring) ? mejorIzquierda : mejorDerecha;
    }
}


//PSEUDOCODIGO

/*
FUNCIÓN EncontrarMejorCliente(clientes, inicio, fin)
    SI inicio == fin - 1 ENTONCES
        RETORNAR clientes[inicio]
    FIN SI

    mitad = (inicio + fin) / 2

    mejorIzquierda = EncontrarMejorCliente(clientes, inicio, mitad)
    mejorDerecha = EncontrarMejorCliente(clientes, mitad, fin)

    SI mejorIzquierda.scoring > mejorDerecha.scoring ENTONCES
        RETORNAR mejorIzquierda
    SINO
        RETORNAR mejorDerecha
    FIN SI
FIN FUNCIÓN

FUNCIÓN Principal()
    clientes = [Lista de clientes con id, nombre, scoring]
    mejorCliente = EncontrarMejorCliente(clientes, 0, tamaño de la lista)
    IMPRIMIR "Cliente con el scoring máximo: ", mejorCliente
FIN FUNCIÓN

*/
