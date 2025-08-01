/*
Leer el README.md
*/

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

public class MatrixPrueba {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int registro = 1;//Se inicializa porque si no da error en el do-while

            System.out.print("""
            +-------------------------------------------------------------+
            |             Universidad Tecnológica de Tijuana              |
            |                                                             |
            |                           Matrix                            |
            |                                                             |
            |               Heredia Avalos Jose Angel                     |
            |               Montaño López Ángel Isaac                     |
            |               Romero Hernández Juan José                    |
            |                                                             |
            +-------------------------------------------------------------+
            """);

            System.out.print("Bienvenido/a, pulsa enter para continuar: ");
            sc.nextLine();

            do {
                System.out.println();
                System.out.print("""
                +---------------------------------------------------------------------+
                |                       Bienvenido a Matrix                           |
                |---------------------------------------------------------------------|
                | Ofrecemos servicios para eventos sociales y empresariales.          |
                | Estos son algunos de nuestros servicios disponibles:                |
                |                                                                     |
                |   > Conferencias                                                    |
                |   > Teatro                                                          |
                |   > Banquetes                                                       |
                |   > Renta de salones                                                |
                |   > ¡Y muchos más!                                                  |
                |                                                                     |
                |---------------------------------------------------------------------|
                | ¿Desea hacer su registro?                                           |
                |   1. Sí                                                             |
                |   2. No                                                             |
                +---------------------------------------------------------------------+
                Decisión (Ingrese un número entre 1 y 2): """ + " ");

                try {
                    registro = sc.nextInt();
                    sc.nextLine();

                    switch (registro) {
                        case 1:
                            System.out.println();
                            datosUsuarios(sc);
                            break;
                        case 2:
                            System.out.println();
                            System.out.println("👋 Vuelva pronto.");
                            break;
                        default:
                            System.out.println("\n❌ Error: Ingresa un número entre (1 - 2).");
                    }
                } catch (InputMismatchException a) {
                    System.out.println("\n❌ Error: No se permiten letras ni caracteres especiales.");
                    sc.nextLine();
                }
            } while (registro != 2);
        }
    }

    public static void datosUsuarios(Scanner sc) {
        do {
            System.out.println("+---------------------------------------------------------------------------------------");
            System.out.print("| Ingrese su nombre completo (Empezando por apellidos): ");
            String nombreUsuario = sc.nextLine();

            System.out.print("| Ingrese su número de telefono: ");
            Long telefonoUsuario = sc.nextLong();
            sc.nextLine();

            System.out.print("| Ingrese su correo electrónico: ");
            String correoUsuario = sc.nextLine();

            System.out.print("| Cantidad de persona a asistir al evento: ");
            int personasUsuario = sc.nextInt();
            sc.nextLine();

            if (personasUsuario <= 0) {
                System.out.println(); // Salto de linea para mejor apariencia
                System.out.println("❌ Error: Cantidad inválida");
                System.out.println(); // Salto de linea para mejor apariencia
            } else {
                System.out.print("| Cantidad de días que reservará el evento: ");
                int diasUsuario = sc.nextInt();
                sc.nextLine();

                System.out.println("+---------------------------------------------------------------------------------------");
                System.out.println();
                opciones(sc, nombreUsuario, telefonoUsuario, correoUsuario, personasUsuario, diasUsuario);
                break;
            }
        } while (true);

    }

    public static void opciones(Scanner sc, String nombreUsuario, Long telefonoUsuario, String correoUsuario, int personasUsuario, int diasUsuario) {
        int tipoEvento = 1;
        do {
            System.out.print("""
                +----------------------------------------+
                | Qué tipo de evento deseas contratar?   |
                |----------------------------------------|
                | 1. Social                              |
                | 2. Empresarial                         |
                | 3. Ninguno                             |
                +----------------------------------------+
                """);
            try {
                System.out.print("Ingresa una opción (1 - 3): ");
                tipoEvento = sc.nextInt();
                sc.nextLine();

                switch (tipoEvento) {
                    case 1:
                        System.out.println();
                        eventoSocial(sc, nombreUsuario, telefonoUsuario, correoUsuario, personasUsuario, diasUsuario);
                        break;
                    case 2:
                        System.out.println();
                        eventoEmpresarial(sc, nombreUsuario, telefonoUsuario, correoUsuario, personasUsuario, diasUsuario);
                        break;
                    case 3:
                        System.out.println("\n👋 Adiós!\nNo has elegido ningún evento.");
                        break;
                    default:
                        System.out.println("\n❌ Error: Ingresa un número entre (1 - 3).\n");
                }
            } catch (InputMismatchException b) {
                System.out.println();
                System.out.println("\n❌ Error: No se permiten letras ni caracteres especiales.\n");
                sc.nextLine(); // Limpia el buffer, importante mantenerlo
            }
        } while (tipoEvento != 3);
    }

    public static void eventoSocial(Scanner sc, String nombreUsuario, Long telefonoUsuario, String correoUsuario, int personasUsuario, int diasUsuario) {
        int tipoReservacion = 1;
        do {
            System.out.print("""
                +----------------------------------------------------------------+
                | El evento cuenta con los siguientes tipos de reservaciones     |
                |----------------------------------------------------------------|
                | 1. Conferencia                                                 |
                | 2. Teatro                                                      |
                | 3. Recepción                                                   |
                | 4. Banquete                                                    |
                | 5. Salón                                                       |
                | 6. Disposición en forma de U                                   |
                | 7. Salir                                                       |
                +----------------------------------------------------------------+
                """);
            System.out.print("Elige el evento (1 - 7): ");
            try {
                tipoReservacion = sc.nextInt();
                sc.nextLine();

                switch (tipoReservacion) {
                    case 1:
                        System.out.println("Iniciando configuración de conferencia...");
                        montaje_conferencia(sc, false, diasUsuario);//Aplicar como boleano by: Jose
                        break;
                    case 2:
                        System.out.println("Teatro en mantenimiento");
                        break;
                    case 3:
                        System.out.println("Iniciando configuración de recepción...");
                        eventoRecepcion(sc, false, nombreUsuario, telefonoUsuario, correoUsuario, personasUsuario, diasUsuario);
                        break;
                    case 4:
                        System.out.println("Iniciando configuración de banquete...");
                        eventoBanquete(sc, false, diasUsuario);
                        break;
                    case 5:
                        montajeSalonSocial(sc, nombreUsuario, telefonoUsuario, correoUsuario, personasUsuario, diasUsuario);
                        break;
                    case 6:
                        System.out.println("Disposición en forma de U en mantenimiento");
                        break;
                    case 7:
                        System.out.println("Saliendo del evento social...");
                        break;
                    default:
                        System.out.println("\n❌Error, debes ingresar un número entre (1 - 7)\n");
                }
            } catch (InputMismatchException c) {
                System.out.println("\n❌ Error: No se permiten letras ni caracteres especiales\n");
                sc.nextLine();
            }
        } while (tipoReservacion != 7);
    }

    public static void eventoEmpresarial(Scanner sc, String nombreUsuario, Long telefonoUsuario, String correoUsuario, int personasUsuario, int diasUsuario) {
        int tipoReservacion = 1;
        do {
            System.out.print("""
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
                        System.out.print("¿Cuántos días desea rentar el evento?: ");
                        int dias = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Conferencia empresarial en mantenimiento");
                        montaje_conferencia(sc, true, dias);//Aplicar como boleano by:jose.
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
                        break;
                }
            } catch (InputMismatchException d) {
                System.out.println();
                System.out.println("❌ Error, debes ingresar un número entre 1 y 5.");
                sc.nextLine();
            }
        } while (tipoReservacion != 5);
    }

    public static void montaje_conferencia(Scanner sc, boolean esEmpresarial, int dias) {
        equipamiento_conferencial(sc, esEmpresarial, dias);
        servicio_conferencial(sc, esEmpresarial, dias);
    }

    /*                                          1 .Conferencia, parte de Jose (yo).                                          */
    public static void equipamiento_conferencial(Scanner sc, boolean esEmpresarial, int dias) {
        System.out.println("Precio estandar para eventos sociales.");
        int[] equipamiento = new int[8];
        equipamiento[0] = 400;  // Sillas
        equipamiento[1] = 1000; // Escenario
        equipamiento[2] = 500;  // Micrófono
        equipamiento[3] = 750;  // Proyector y pantalla
        equipamiento[4] = 450;  // Sistema de sonido
        equipamiento[5] = 300;  // Podio
        equipamiento[6] = 150;  // Pizarra y rotafolios
        equipamiento[7] = 525;  // Iluminacion focal

        if (esEmpresarial == false) {
            System.out.println("Precio estandar en equipamiento para eventos sociales.");
            System.out.println(Arrays.toString(equipamiento));

        } else if (esEmpresarial) {
            System.out.println("En equipamiento se aplicará el 10% extra para eventos empresariales.");
            for (int i = 0; i < equipamiento.length; i++) {
                equipamiento[i] = (int) (equipamiento[i] * 1.1);
            }
            System.out.println(Arrays.toString(equipamiento));
        }

        // Mostrar precio total con días
        int totalEquipamiento = 0;
        for (int i = 0; i < equipamiento.length; i++) {
            totalEquipamiento += equipamiento[i] * dias;
        }
        System.out.println("Total equipamiento por " + dias + " día(s): $" + totalEquipamiento);
    }

    public static void servicio_conferencial(Scanner sc, boolean esEmpresarial, int dias) {
        int[] servicios = new int[7];
        servicios[0] = 700;  // Reagistro de asistentes.
        servicios[1] = 1500; // Traduccion simultánea.
        servicios[2] = 800;  // Tranmision en vivo o grabación.
        servicios[3] = 350;  // Café o coffe break
        servicios[4] = 2000;  // Personal tecnico(Audio y video).
        servicios[5] = 740;  // Material de apoyo
        servicios[6] = 350;  // Wi-fi.

        if (esEmpresarial == false) {
            System.out.println("En servicios, precio estandar para eventos sociales.");
            System.out.println(Arrays.toString(servicios));

        } else if (esEmpresarial) {
            System.out.println("En servicios se aplicará el 10% extra para eventos empresariales.");
            for (int i = 0; i < servicios.length; i++) {
                servicios[i] = (int) (servicios[i] * 1.1);

            }
            System.out.println(Arrays.toString(servicios));
        }

        int totalServicios = 0;
        for (int i = 0; i < servicios.length; i++) {
            totalServicios += servicios[i] * dias;
        }
        System.out.println("Total servicios por " + dias + " día(s): $" + totalServicios);
    }

    /*                                          ISAAC                                          */
    // EN ESTA FUNCION LLAMO A LAS DEMAS FUNCIONES Y LES ASIGNO VARIABLES.
    public static void eventoRecepcion(Scanner sc, boolean esEmpresarial, String nombreUsuario, Long telefonoUsuario, String correoUsuario, int personasUsuario, int diasUsuario) {
        int totalEquipamiento = equipamientoRecepcion(esEmpresarial, diasUsuario);
        int totalServicios = serviciosRecepcion(esEmpresarial, diasUsuario);
        int total = totalEquipamiento + totalServicios;

        System.out.println(" Total por el evento Recepción (" + diasUsuario + " días): $" + total);
    }
    // ARRAY PARA NOMBRES DEL EQUIPAMIENTO 
    public static int equipamientoRecepcion(boolean esEmpresarial, int dias) {
        String[] nombres = {
                "Mesas altas tipo cóctel", "Barra de bebidas", "Sistema de sonido ambiental",
                "Área de bienvenida", "Iluminación decorativa", "Decoración floral"
        };
        //ARRAYS DE PRECIOS DEL EQUIPAMIENTO 
        int[] precios = {300, 800, 400, 250, 500, 600};
        // SI EL EVENTO ES EMPRESARAL EL FOR HACE UN AUMENTO DEL 20% A CADA COSTO
        if (esEmpresarial) {
            for (int i = 0; i < precios.length; i++) {
                precios[i] = (int)(precios[i] * 1.2);
            }
        }
        // HACE EL CALCULO DE LOS COSTOS POR LOS DIAS RENTADOS 
        System.out.println(" Equipamiento para Recepción:");
        int subtotal = 0;
        for (int i = 0; i < precios.length; i++) {
            int precioTotal = precios[i] * dias;
            subtotal += precioTotal;
            System.out.println(" - " + nombres[i] + ": $" + precioTotal);
        }
        return subtotal;
    }
    // ARRAYS QUE GUARDA LOS NOMBRES DE LOS SERVICIOS DE RECEPCION
    public static int serviciosRecepcion(boolean esEmpresarial, int dias) {
        String[] nombres = {
                "Servicio de catering", "DJ o música en vivo", "Fotografía y video",
                "Guardarropa", "Valet parking", "Seguridad", "Meseros y anfitriones"
        };
        // ESTE ARRAY GUARDA LOS PRECIOS DE CADA SERVICIO 
        int[] precios = {1200, 1500, 1000, 300, 400, 350, 500};
        // SI EL EVENTO ES EMPRESARIAL EL FOR AUMENTA EL COSTO DE LOS SERVICIOS 
        if (esEmpresarial) {
            for (int i = 0; i < precios.length; i++) {
                precios[i] = (int)(precios[i] * 1.2);
            }
        }
        // ARRAYS SUMA DE COSTOS POR LOS DIAS.
        System.out.println(" Servicios para Recepción:");
        int subtotal = 0;
        for (int i = 0; i < precios.length; i++) {
            int precioTotal = precios[i] * dias;
            subtotal += precioTotal;
            System.out.println(" - " + nombres[i] + ": $" + precioTotal);
        }
        return subtotal;
    }
    // FUNCION DE BANQUETE 
    public static void eventoBanquete(Scanner sc, boolean esEmpresarial, int diasUsuario) {
        int totalEquipamiento = equipamientoBanquete(esEmpresarial, diasUsuario);
        int totalServicios = serviciosBanquete(esEmpresarial, diasUsuario);
        int total = totalEquipamiento + totalServicios;

        System.out.println(" Total por el evento Banquete (" + diasUsuario + " días): $" + total);
    }
    //ARRAYS PARA GUARDAR LOS NOMBRE DE LOS EQUIPAMENTOS DE BANQUETE 
    public static int equipamientoBanquete(boolean esEmpresarial, int dias) {
        String[] nombres = {
                "Mesas redondas o rectangulares", "Sillas con fundas", "Mantelería y vajilla formal",
                "Centros de mesa", "Iluminación ambiental", "Tarima para discursos"
        };
        int[] precios = {700, 400, 650, 300, 500, 350};
        // SI ES EMPRESARIAL LE AUMENTA 20% AL COSTO 
        if (esEmpresarial) {
            for (int i = 0; i < precios.length; i++) {
                precios[i] = (int)(precios[i] * 1.2);
            }
        }
        // RECORRE CADA UNO PARA SUMARLOS Y GUARDAR EL PRECIO EN SUBTOTAL
        System.out.println(" Equipamiento para Banquete:");
        int subtotal = 0;
        for (int i = 0; i < precios.length; i++) {
            int precioTotal = precios[i] * dias;
            subtotal += precioTotal;
            System.out.println(" - " + nombres[i] + ": $" + precioTotal);
        }
        return subtotal;
    }
    // SERVICIOS DE BANQUETE, ARRAY CON  NOMBRES.
    public static int serviciosBanquete(boolean esEmpresarial, int dias) {
        String[] nombres = {
                "Menú completo", "Cocineros y meseros", "Música en vivo o DJ",
                "Pastel formal", "Fotografía profesional", "Brindis y discursos", "Estación de bebidas" };
        int[] precios = {2500, 1800, 1500, 500, 1000, 600, 400};
        // AUMENTA 20% AL SER EMPRESARIAL 
        if (esEmpresarial) {
            for (int i = 0; i < precios.length; i++) {
                precios[i] = (int)(precios[i] * 1.2);
            }
        }
        //SUMA LOS PRECIOS MULTIPLICADOS POR LOS DIAS 
        System.out.println(" Servicios para Banquete:");
        int subtotal = 0;
        for (int i = 0; i < precios.length; i++) {
            int precioTotal = precios[i] * dias;
            subtotal += precioTotal;
            System.out.println(" - " + nombres[i] + ": $" + precioTotal);
        }
        return subtotal;
    }

    /*                                                JUAN                                                */
    public static void montajeSalonSocial(Scanner sc, String nombreUsuario, Long telefonoUsuario, String correoUsuario, int personasUsuario, int diasUsuario) {
        System.out.println("-------------- Renta de salón para evento social --------------");

        System.out.println("| Datos del usuario:");
        System.out.println("| Nombre: " + nombreUsuario);
        System.out.println("| Teléfono: " + telefonoUsuario);
        System.out.println("| Correo electrónico: " + correoUsuario);
        System.out.println("| Número de personas: " + personasUsuario);
        System.out.println("| Días de renta: " + diasUsuario);

        int costoDia = 1500; // Precio por día
        int total = costoDia * diasUsuario;

        System.out.println("| Costo por día: $" + costoDia);
        System.out.println("| Total a pagar: $" + total);

        System.out.println("---------------------------------------------------------------");
    }
}
