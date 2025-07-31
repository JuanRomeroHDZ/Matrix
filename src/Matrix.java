/*
Leer el README.md
*/

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

public class Matrix {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int registro = 1;//Se inicializa porque si no da error en el do-while

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
                    System.out.print("Desea hacer su registro?\n1. Si\n2. No\nDecisión (Ingrese un número entre 1 y 2): ");
                    registro = sc.nextInt();

                    switch (registro) {
                        case 1:
                            System.out.println();
                            sc.nextLine();
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
                    System.out.println("❌ Error: No se permiten letras ni caracteres especiales.");
                    sc.nextLine();
                }
            } while (registro != 2);
        }
    }

    public static void datosUsuarios(Scanner sc){
        do {
            System.out.print("Ingrese su nombre completo (Empezando por apellidos): ");
            String nombreUsuario = sc.nextLine();

            System.out.print("Ingrese su número de telefono: ");
            Long telefonoUsuario = sc.nextLong();
            sc.nextLine();

            System.out.print("Ingrese su correo electrónico: ");
            String correoUsuario = sc.nextLine();

            System.out.print("Cantidad de persona a asistir al evento: ");
            int personasUsuario = sc.nextInt();
            if(personasUsuario <= 0){
                System.out.println(); // Salto de linea para mejor apariencia
                System.out.println("❌ Error: Cantidad inválida");
                sc.nextLine(); // Limpia buffer
                System.out.println(); // Salto de linea para mejor apariencia
            }else{
                System.out.print("\nNota: El evento lo elegirá en el siguiente apartado\nCantidad de días que reservará el evento: ");
                int diasUsuario = sc.nextInt();

                opciones(sc, nombreUsuario, telefonoUsuario, correoUsuario, personasUsuario, diasUsuario);
            }
        } while (true);

    }

    public static void opciones(Scanner sc, String nombreUsuario, Long telefonoUsuario, String correoUsuario, int personasUsuario, int diasUsuario){
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
                        eventoSocial(sc, nombreUsuario, telefonoUsuario, correoUsuario, personasUsuario, diasUsuario);
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

    public static void eventoSocial(Scanner sc, String nombreUsuario, Long telefonoUsuario, String correoUsuario, int personasUsuario, int diasUsuario) {
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
                        montaje_conferencia(sc, false);//Aplicar como boleano by: Jose
                        break;
                    case 2:
                        System.out.println("Teatro en mantenimiento");
                        break;
                    case 3:
                        System.out.println("Iniciando configuración de recepción...");
                        eventoRecepcion(sc, false, nombreUsuario, telefonoUsuario, correoUsuario, personasUsuario, diasUsuario); // ← NUEVA FUNCIÓN RECEPCIÓN
                        break;
                    case 4:
                        System.out.println("Iniciando configuración de banquete...");
                        eventoBanquete(sc, false); // ← NUEVA FUNCIÓN BANQUETE
                        break;
                    case 5:
                        System.out.println();
                        System.out.println("Salón en mantenimiento");
                        System.out.println(); // Borrar o considerar borrar al finalizar
                        montajeSalonSocial(sc, nombreUsuario, telefonoUsuario, correoUsuario, personasUsuario, diasUsuario);
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
                        montaje_conferencia(sc, true);//Aplicar como boleano by:jose.
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

/*                                          1 .Conferencia, parte de Jose (yo).                                          */     
    public static void equipamiento_conferencial(Scanner sc, boolean esEmpresarial){
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

        if (esEmpresarial) {
            System.out.println("Se aplicará el 10% extra para eventos empresariales.");
            for (int i = 0; i < equipamiento.length; i++) {
                equipamiento[i] = (int)(equipamiento[i] *  1.1);
            }
        }

        System.out.println(Arrays.toString(equipamiento));
    }

    public static void servicio_conferencial(Scanner sc){
        // En construcción
    }

/*                                          Lo de el good Isaac, en construccion                                          */
    public static void eventoRecepcion(Scanner sc, boolean esEmpresarial, String nombreUsuario, Long telefonoUsuario, String correoUsuario, int personasUsuario, int diasUsuario) {

        sc.nextLine();

        if (diasUsuario <= 0) {
            System.out.println("❌ Días inválidos. Se usará 1 día por defecto.");
            diasUsuario = 1;
        }

        int totalEquipamiento = equipamientoRecepcion(esEmpresarial, diasUsuario);
        int totalServicios = serviciosRecepcion(esEmpresarial, diasUsuario);
        int total = totalEquipamiento + totalServicios;

        System.out.println(" Total por el evento Recepción (" + diasUsuario + " días): $" + total);
    }

    public static int equipamientoRecepcion(boolean esEmpresarial, int dias) {
        String[] nombres = {
            "Mesas altas tipo cóctel", "Barra de bebidas", "Sistema de sonido ambiental",
            "Área de bienvenida", "Iluminación decorativa", "Decoración floral"
        };
        int[] precios = {300, 800, 400, 250, 500, 600};

        if (esEmpresarial) {
            for (int i = 0; i < precios.length; i++) {
                precios[i] *= 1.1;
            }
        }

        System.out.println(" Equipamiento para Recepción:");
        int subtotal = 0;
        for (int i = 0; i < precios.length; i++) {
            int precioTotal = precios[i] * dias;
            subtotal += precioTotal;
            System.out.println(" - " + nombres[i] + ": $" + precioTotal);
        }
        return subtotal;
    }

    public static int serviciosRecepcion(boolean esEmpresarial, int dias) {
        String[] nombres = {
            "Servicio de catering", "DJ o música en vivo", "Fotografía y video",
            "Guardarropa", "Valet parking", "Seguridad", "Meseros y anfitriones"
        };
        int[] precios = {1200, 1500, 1000, 300, 400, 350, 500};

        if (esEmpresarial) {
            for (int i = 0; i < precios.length; i++) {
                precios[i] *= 1.1;
            }
        }

        System.out.println(" Servicios para Recepción:");
        int subtotal = 0;
        for (int i = 0; i < precios.length; i++) {
            int precioTotal = precios[i] * dias;
            subtotal += precioTotal;
            System.out.println(" - " + nombres[i] + ": $" + precioTotal);
        }
        return subtotal;
    }

    public static void eventoBanquete(Scanner sc, boolean esEmpresarial) {
        System.out.print("¿Cuántos días desea rentar el evento de Banquete?: ");
        int dias = sc.nextInt();
        sc.nextLine();

        if (dias <= 0) {
            System.out.println(" Días inválidos. Se usará 1 día por defecto.");
            dias = 1;
        }

        int totalEquipamiento = equipamientoBanquete(esEmpresarial, dias);
        int totalServicios = serviciosBanquete(esEmpresarial, dias);
        int total = totalEquipamiento + totalServicios;

        System.out.println(" Total por el evento Banquete (" + dias + " días): $" + total);
    }

    public static int equipamientoBanquete(boolean esEmpresarial, int dias) {
        String[] nombres = {
            "Mesas redondas o rectangulares", "Sillas con fundas", "Mantelería y vajilla formal",
            "Centros de mesa", "Iluminación ambiental", "Tarima para discursos"
        };
        int[] precios = {700, 400, 650, 300, 500, 350};

        if (esEmpresarial) {
            for (int i = 0; i < precios.length; i++) {
                precios[i] *= 1.1;
            }
        }

        System.out.println(" Equipamiento para Banquete:");
        int subtotal = 0;
        for (int i = 0; i < precios.length; i++) {
            int precioTotal = precios[i] * dias;
            subtotal += precioTotal;
            System.out.println(" - " + nombres[i] + ": $" + precioTotal);
        }
        return subtotal;
    }

    public static int serviciosBanquete(boolean esEmpresarial, int dias) {
        String[] nombres = {
            "Menú completo", "Cocineros y meseros", "Música en vivo o DJ",
            "Pastel formal", "Fotografía profesional", "Brindis y discursos", "Estación de bebidas"
        };
        int[] precios = {2500, 1800, 1500, 500, 1000, 600, 400};

        if (esEmpresarial) {
            for (int i = 0; i < precios.length; i++) {
                precios[i] *= 1.1;
            }
        }

        System.out.println(" Servicios para Banquete:");
        int subtotal = 0;
        for (int i = 0; i < precios.length; i++) {
            int precioTotal = precios[i] * dias;
            subtotal += precioTotal;
            System.out.println(" - " + nombres[i] + ": $" + precioTotal);
        }
        return subtotal;
    }

    /*                                          Juan                                          */
    public static void montajeSalonSocial(Scanner sc,String nombreUsuario,Long telefonoUsuario,String correoUsuario,int personasUsuario,int diasUsuario){
        System.out.print("""
                |-------------------------------------------------------------------------------------------|
                | Bienvenido/a a la renta del salón, contamos con los siguientes equipamientos y servicios  |
                | ------------------------------------------------------------------------------------------|
                | Equipamientos:                                                                            |
                | 1. Mesas y sillas                                                                         |
                | 2. Sistema de climatización                                                               |
                | 3. Pantallas o proyectores                                                                |
                | 4. Ilumunación regulable                                                                  |
                |                                                                                           |                                         
                | Sevicios:                                                                                 |
                | 1. Personal de limpieza                                                                   |
                | 2. Soporte técnico                                                                        |
                | 3. Wi-Fi                                                                                  |
                | 4. Servicio de comida                                                                     |
                |-------------------------------------------------------------------------------------------|    
                """);
    }
    public static void equipamientoSalonSocial(Scanner sc,String nombreUsuario,Long telefonoUsuario,String correoUsuario,int personasUsuario,int diasUsuario){
        mesasSillas(sc);

    }
    public static void mesasSillas(Scanner sc){
        System.out.println("1. Mesas y sillas");
        try {
            System.out.print("Cantidad de mesas: ");
            int cantidadMesas = sc.nextInt();

            System.out.println("Cantidad de sillas: ");
            int cantidadSillas = sc.nextInt();
        } catch (InputMismatchException e) {
            // TODO: handle exception
        }

    }
}
