package Clase13;

public class Actividad1 {
}

/*

1- Ejemplos de Acciones posibles del atacante:

- Retirar grandes cantidades de dinero.
- Cambiar la dirección de envío de una tarjeta.
- Realizar una transferencia inusual a un país extranjero.

2- Funciones del sistema de detección y herramientas que puede usar:

- Monitoreo de transacciones inusuales.
- Detección de cambios en la dirección de envío.
- Monitoreo de transferencias internacionales.

3- Cómo se aplicaría la poda alfa-beta:

- Alfa representa el valor máximo que el sistema de detección puede garantizar (el mejor valor de detección de fraude).

- Beta representa el valor mínimo que el atacante puede garantizar (el mejor valor para el atacante sin ser detectado).

4- Árbol de decisión simplificado:

Inicio
├── Atacante (Maximizar fraude)
│   ├── Retirar una gran cantidad de dinero
│   │   ├── Monitorear transacciones (Puntaje: -5)
│   │   └── No hacer nada (Puntaje: 0)
│   ├── Cambiar la dirección de envío
│   │   ├── Monitorear dirección (Puntaje: -3)
│   │   └── No hacer nada (Puntaje: 0)
│   └── Transferencia internacional inusual
│       ├── Monitorear transferencias (Puntaje: -4)
│       └── No hacer nada (Puntaje: 0)
└── Sistema de detección (Minimizar fraude)
    ├── Monitoreo de transacciones
    │   ├── Detectar fraude (Puntaje: +5)
    │   └── No detectar fraude (Puntaje: 0)
    ├── Monitoreo de dirección
    │   ├── Detectar fraude (Puntaje: +3)
    │   └── No detectar fraude (Puntaje: 0)
    └── Monitoreo de transferencias
        ├── Detectar fraude (Puntaje: +4)
        └── No detectar fraude (Puntaje: 0)



 */
