/*
Leer el README.md
*/

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

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
                System.out.println();
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
                        case 1:
                            System.out.println();
                            sc.nextLine(); // Limpia el buffer
                            datosUsuarios(sc);
                            break;
                        case 2:
                            System.out.println();
                            System.out.println("👋 Vuelva pronto.");
                            break;
                        default:
                            System.out.println();
                            System.out.println("❌ Error: Ingresa un número entre (1 - 2).");
                            sc.nextLine();
                            continue;
                    }
                } catch (InputMismatchException a) {
                    System.out.println();
                    System.out.println("❌ Error: No se permiten letras ni caracteres especiales (#, !, /, -, etc.).");
                    sc.nextLine();
                }
            } while (registro != 2);
        }
    }

    public static void datosUsuarios(Scanner sc){
        System.out.print("Ingrese su nombre completo (Empezando por apellidos): ");
        String nombreUsuario = sc.nextLine();

        System.out.print("Ingrese su número de telefono: ");
        Long telefonoUsuario = sc.nextLong();
        sc.nextLine();

        System.out.print("Ingrese su correo electrónico: ");
        String correoUsuario = sc.nextLine();
        opciones(sc);
    }

    public static void opciones(Scanner sc){
        int tipoEvento = 1;
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
                sc.nextLine();

                switch (tipoEvento) {
                    case 1:
                        System.out.println();
                        eventoSocial(sc);
                        break;
                    case 2:
                        System.out.println();
                        eventoEmpresarial(sc);
                        break;
                    case 3:
                        System.out.println();
                        System.out.println("👋 Adiós!\nNo has elegido ningún evento.");
                        break;
                    default:
                        System.out.println();
                        System.out.println("❌ Error: Ingresa un número entre (1 - 3).");
                }
            } catch (InputMismatchException b) {
                System.out.println();
                System.out.println("❌ Error: Ingresa un número entre (1- 3).");
                sc.nextLine();
            }
        } while (tipoEvento != 3);
    }

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
                sc.nextLine();

                switch (tipoReservacion) {
                    case 1:
                        System.out.println("Iniciando configuración de conferencia...");
                        montaje_conferencia(sc, false); //Aplicar como boleano
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
                sc.nextLine();
            }
        } while (tipoReservacion != 7);
    }

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
                sc.nextLine();

                switch (tipoReservacion) {
                    case 1:
                        System.out.println("Conferencia empresarial en mantenimiento");
                        montaje_conferencia(sc, true);//Para aplicar como boleano
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
                sc.nextLine();
            }
        } while (tipoReservacion != 5);
        
    }

    public static void montaje_conferencia(Scanner sc, boolean esEmpresarial){
        System.out.println("Montaje del teatro en mantenimiento");
        equipamiento_conferencial(sc, esEmpresarial);
        servicio_conferencial(sc);
    }

    public static void equipamiento_conferencial(Scanner sc, boolean esEmpresarial){
        System.out.println("Precio estandar para eventos sociales.");
        int[] equipamiento = new int[8];
        equipamiento[0] = 400;  // Sillas
        equipamiento[1] = 1000; // Escenario
        equipamiento[2] = 500;  // Microfono
        equipamiento[3] = 750;  // Proyector y pantalla
        equipamiento[4] = 450;  // Sistema de sonido
        equipamiento[5] = 300;  // Podio
        equipamiento[6] = 150;  // Pizarra y rotafolios
        equipamiento[7] = 525;  // Iluminacion focal

        if (esEmpresarial) {
            System.out.println("Se aplicará el 10% extra para eventos empresariales.");
            for (int i = 0; i < equipamiento.length; i++) {
                equipamiento[i] = (int)(equipamiento[i] *  1.1);
            }
        }

        System.out.println(Arrays.toString(equipamiento));
    }

    public static void servicio_conferencial(Scanner sc){
    
}
}