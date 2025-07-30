/*
Leer el README.md
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int registro = 1; // Se inicializa porque si no da error en el do-while

            System.out.print("""
                |---------------------------------------|
                |  Universidad Tecnológica de Tijuana   |
                |                                       |
                |                 Matrix                |
                |                                       |
                | Heredia Avalos Jose Angel             |
                | Montaño Lopez Ángel Isaac             |
                | Romero Hernández Juan José            |
                |                                       |
                |---------------------------------------|
                """);
            System.out.print("Bienvenido/a, pulsa enter para continuar: ");
            sc.nextLine();

            do {
                System.out.println(); // Salto de linea para mejor apariencia
                System.out.print("""
                    |-------------------------------------------------------------------|
                    | Bienvenido a Matrix                                               |
                    |-------------------------------------------------------------------|
                    | Ofrecemos un servicio para eventos sociales y empresariales.      |
                    | Ambos eventos cuentan con los siguientes servicios;               |
                    | 1. Conferencia                                                    |
                    | 2. Teatro                                                         |
                    | 3. Banquete                                                       |
                    | 4. Renta de salones                                               |
                    | 5. Entre otros más!                                               |
                    |-------------------------------------------------------------------|
                    """);
                try {
                    System.out.print("Desea hacer su registro?\n1. Si\n2. No\nDecisión: ");
                    registro = sc.nextInt();

                    switch (registro) {
                        case 1: // Recolecta los datos del usuario
                            System.out.println(); // Salto de linea para mejor apariencia
                            sc.nextLine(); // Limpia el buffer
                            datosUsuarios(sc); // Entra a la función para requerir los datos del usuario
                            break;

                        case 2: // No entra a ninguna función
                        System.out.println(); // Salto de linea para mejor apariencia
                            System.out.println("👋 Vuelva pronto.");
                            break;
                            
                        default:
                            System.out.println(); // Salto de linea para mejor apariencia
                            System.out.println("❌ Error: Ingresa un número entre (1 - 2).");
                            sc.nextLine(); // Limpia el buffer
                            continue;
                    } 
                } catch (InputMismatchException a) {
                    System.out.println(); // Salto de linea para mejor apariencia
                    System.out.println("❌ Error: No se permiten letras ni caracteres especiales (#, !, /, -, etc.).");
                    sc.nextLine(); // Limpia el buffer
                }
            } while (registro != 2);
        }
    }
    public static void datosUsuarios(Scanner sc){
        System.out.print("Ingrese su nombre completo (Empezando por apellidos): ");
        String nombreUsuario = sc.nextLine();

        System.out.print("Ingrese su número de telefono: ");
        Long telefonoUsuario = sc.nextLong();
        sc.nextLine(); // Importante, debe ir debajo de -> "Ingrese su número de telefono"

        System.out.print("Ingrese su correo electrónico: ");
        String correoUsuario = sc.nextLine();
        opciones(sc); // Entra a la parte de las opciones
    }

    public static void opciones(Scanner sc){
        int tipoEvento = 1; // Se inicializa porque si no da error en el do-while
        do {
            System.out.println();
            System.out.print("""
                |----------------------------------------|
                | Qué tipo de evento deseas contratar?   |
                |----------------------------------------|
                | 1. Social                              |
                | 2. Empresarial                         |
                | 3. Ninguno                             |
                |----------------------------------------|
                """);
            
            try {
                System.out.print("Ingresa una opción (1 - 3): ");
                tipoEvento = sc.nextInt();
                sc.nextLine();  // Importante, impide un ciclo fallido

                switch (tipoEvento) {
                    case 1: // Evento social
                        System.out.println();
                        eventoSocial(sc);
                        break;
                    case 2: // Evento empresarial
                        System.out.println();
                        eventoEmpresarial(sc);
                        break;
                    case 3: // El usuario no eligió ninguna opción 
                        System.out.println();
                        System.out.println("👋 Adiós!\nNo has elegido ningún evento.");
                        break;
                    default:
                        System.out.println();
                        System.out.println("❌ Error: Ingresa un número entre (1 - 3).");
                        continue;
                }

            } catch (InputMismatchException b) {
                System.out.println();
                System.out.println("❌ Error: Ingresa un número entre (1- 3).");
                sc.nextLine(); // Importante, impide un ciclo infinito
            }
        } while (tipoEvento != 3);

    }


/*  - - - - - - - - Eventos Principales  - - - - - - - -*/
    // Evento social
    public static void eventoSocial(Scanner sc) {
        int tipoReservacion = 1;
        do {
            System.out.println("""
                |----------------------------------------------------------------|
                | El evento cuenta con los siguientes tipos de reservaciones     |
                |----------------------------------------------------------------|
                | 1. Conferencia                                                 |
                | 2. Teatro                                                      |
                | 3. Recepción                                                   |
                | 4. Banquete                                                    |
                | 5. Salón                                                       |
                | 6. Disposición en forma de U                                   |
                | 7. Salir                                                       |
                |----------------------------------------------------------------|
                """);
            System.out.print("Elige el evento (1 - 7): ");
            try {
                tipoReservacion = sc.nextInt();
                sc.nextLine(); // Limpia el buffer

                switch (tipoReservacion) {
                    case 1:
                        System.out.println("Conferencia en mantenimiento");
                        break;
                    case 2:
                        System.out.println("Teatro en mantenimiento");
                        break;
                    case 3:
                        System.out.println("Recepción en mantenimiento");
                        break;
                    case 4:
                        System.out.println("Banquete en mantenimiento");
                        break;
                    case 5:
                        System.out.println("Salón en mantenimiento");
                        break;
                    case 6:
                        System.out.println("Disposición en forma de U en mantenimiento");
                        break;
                    case 7:
                        System.out.println("Saliendo del evento social...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intenta nuevamente.");
                }
            } catch (InputMismatchException c) {
                System.out.println();
                System.out.println("Error, debes ingresar un número entre 1 y 7.");
                sc.nextLine(); // Impide un ciclo infinito
            }
        } while (tipoReservacion != 7);
    }

    // Evento empresarial
    public static void eventoEmpresarial(Scanner sc) {
        int tipoReservacion = 1;
        do {
            System.out.println("""
                |--------------------------------------------------------------|
                | El evento empresarial cuenta con los siguientes servicios     |
                |--------------------------------------------------------------|
                | 1. Conferencia                                               |
                | 2. Junta                                                     |
                | 3. Taller                                                    |
                | 4. Seminario                                                 |
                | 5. Salir                                                     |
                |--------------------------------------------------------------|
                """);
            System.out.print("Elige el servicio (1 - 5): ");
            try {
                tipoReservacion = sc.nextInt();
                sc.nextLine(); // Limpia el buffer

                switch (tipoReservacion) {
                    case 1:
                        System.out.println("Conferencia empresarial en mantenimiento");
                        break;
                    case 2:
                        System.out.println("Junta empresarial en mantenimiento");
                        break;
                    case 3:
                        System.out.println("Taller empresarial en mantenimiento");
                        break;
                    case 4:
                        System.out.println("Seminario empresarial en mantenimiento");
                        break;
                    case 5:
                        System.out.println("Saliendo del evento empresarial...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intenta nuevamente.");
                }
            } catch (InputMismatchException d) {
                System.out.println();
                System.out.println("Error, debes ingresar un número entre 1 y 5.");
                sc.nextLine(); // Impide un ciclo infinito
            }
        } while (tipoReservacion != 5);
    }
}