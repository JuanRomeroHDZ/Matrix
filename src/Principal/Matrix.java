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
                +---------------------------------------------------------------------+
                | Ofrecemos servicios para eventos sociales y empresariales.          |
                | Estos son algunos de nuestros servicios disponibles:                |
                |                                                                     |
                |   > Conferencias                                                    |
                |   > Teatro                                                          |
                |   > Banquetes                                                       |
                |   > Renta de salones                                                |
                |   > ¡Y muchos más!                                                  |
                |                                                                     |
                +---------------------------------------------------------------------+
                | ¿Desea hacer su registro?                                           |
                |   1. Sí                                                             |
                |   2. No                                                             |
                +---------------------------------------------------------------------+
                Decisión (Ingrese un número entre 1 y 2):""" + " ");

                try {
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
                            System.out.println("\n❌ Error: Ingresa un número entre (1 - 2).");
                            sc.nextLine();
                    }
                } catch (InputMismatchException a) {
                    System.out.println("\n❌ Error: No se permiten letras ni caracteres especiales.");
                    sc.nextLine();
                }
            } while (registro != 2);
        }
    }

    public static void datosUsuarios(Scanner sc){
        do {
            System.out.println("+---------------------------------------------------------------------------------------");
            System.out.print("| Ingrese su nombre completo (Empezando por apellidos): ");
            String nombreUsuario = sc.nextLine();

            System.out.print("| Ingrese su número de telefono: ");
            Long telefonoUsuario = sc.nextLong();
            sc.nextLine();

            System.out.print("| Ingrese su correo electrónico: ");
            String correoUsuario = sc.nextLine();

            System.out.print("| Cantidad de personas a asistir al evento: ");
            int personasUsuario = sc.nextInt();

            if(personasUsuario <= 0){
                System.out.println(); // Salto de linea para mejor apariencia
                System.out.println("❌ Error: Cantidad inválida");
                sc.nextLine(); // Limpia buffer
                System.out.println(); // Salto de linea para mejor apariencia
            }else{
                System.out.print("| Cantidad de días que reservará el evento: ");
                int diasUsuario = sc.nextInt();
                System.out.println("+---------------------------------------------------------------------------------------");
                System.out.println();
                opciones(sc, nombreUsuario, telefonoUsuario, correoUsuario, personasUsuario, diasUsuario);
                break;
            }
        } while (true);

    }

    public static void opciones(Scanner sc, String nombreUsuario, Long telefonoUsuario, String correoUsuario, int personasUsuario, int diasUsuario){
        int tipoEvento = 1;
        do {
            System.out.print("""
                +----------------------------------------+
                | Qué tipo de evento deseas contratar?   |
                +----------------------------------------+
                | 1. Social                              |
                | 2. Empresarial                         |
                | 3. Ninguno                             |
                +----------------------------------------+
                """);

            try {

                System.out.print("Ingresa una opción (1 - 3): ");
                tipoEvento = sc.nextInt();
                sc.nextLine();
                boolean social=false,empresarial=false;

                if(tipoEvento>=1 && tipoEvento<=2){
                    System.out.println();
                    eventoSocial(sc, nombreUsuario, telefonoUsuario, correoUsuario, personasUsuario, diasUsuario, tipoEvento);


                }
                else if(tipoEvento==3){
                    System.out.println("\n👋 Adiós!\nNo has elegido ningún evento.");
                    break;
                }
                else{
                    System.out.println("\n❌ Error: Ingresa un número entre (1 - 3).\n");
                }
            } catch (InputMismatchException b) {
                System.out.println("\n❌ Error: No se permiten letras ni caracteres especiales.\n");
                sc.nextLine(); // Limpia el buffer, importante mantenerlo
            }
        } while (tipoEvento != 3);
    }

    public static void eventoSocial(Scanner sc, String nombreUsuario, Long telefonoUsuario, String correoUsuario, int personasUsuario, int diasUsuario, int tipoEvento) {
        int tipoReservacion = 1;
        do {
            System.out.print("""
                +----------------------------------------------------------------+
                | El evento cuenta con los siguientes tipos de reservaciones     |
                +----------------------------------------------------------------+
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
                        montaje_conferencia(sc,tipoEvento );//Aplicar como boleano by: Jose
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
                        eventoBanquete(sc, true, diasUsuario);
                        break;
                    case 5:
                        montajeSalon(sc, nombreUsuario, telefonoUsuario, correoUsuario, personasUsuario, diasUsuario);
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


    /*                                          1 .Conferencia, parte de Jose (yo).                                          */
    public static void montaje_conferencia(Scanner sc, int tipoEvento){
        int opcions;
        System.out.println(); // Salto de linea para mejor apariencia
        do{

            System.out.print("""
            +---------------------------------------------------------------------------------------------+
            |                           Bienvenido/a a la renta de la conferencia                         |
            +---------------------------------------------------------------------------------------------+
            | 1. Equipamientos:                           Precios:                                        |
            |     > Mesas y sillas                        60$                                             |
            |     > Escenario.                            200$                                            |
            |     > Microfonos.                           120$                                            |
            |     > Proyector y pantalla                  65$                                             |
            |     > Sistema de sonido.                    150$                                            |
            |     > Podio.                                140$                                            |
            |     > Pizarra y rotafolios.                 80$                                             |
            |     > Iluminación.                          165$                                            |
            |                                                                                             |
            | 2. Servicios:                                                                               |
            |     > Registro de asistentes.               100$                                            |
            |     > Traducción simultanea.                250$                                            |
            |     > Transmisión en vivo o grabacion.      175$                                            |
            |     > Café o coffe break.                   60$                                             |
            |     > Personal técnico.                     250$                                            |
            |     > Material                              120$                                            |
            |     > Wi-Fi                                 40$                                             |
            |                                                                                             |
            | 3. Para salir.                                                                              |
            +---------------------------------------------------------------------------------------------+
            """);
            System.out.print("Elige el servicio (1 - 3): ");
            opcions=sc.nextInt();
            sc.nextLine();
            try{
                switch (opcions) {
                    case 1:
                        equipamiento_conferencial(sc, tipoEvento);
                        break;
                    case 2:
                        servicio_conferencial(sc,tipoEvento);
                        break;
                    case 3:
                        System.out.println("Saliendo");
                        break;
                    default:
                        System.out.println("Opción no válida. Intenta nuevamente.");
                        break;
                }
            }catch (InputMismatchException a) {
                System.out.println();
                System.out.println("❌ Error, debes ingresar un números 1 y 3 .");
                sc.nextLine();
            }
        }while(opcions!=3);
    }

    public static void equipamiento_conferencial(Scanner sc, int tipoEvento){
        int[] P_equipamiento = new int[]{
                60,  // Sillas
                200, // Escenario
                120,  // Micrófono
                65, // Proyector y pantalla
                150,  // Sistema de sonido
                140,  // Podio
                80,  // Pizarra y rotafolios
                125  // Iluminacion focal
        };
        String[] equipamiento_text = new String[]{
                "Mesas y Sillas","Escenario","Microfonos","Proyector y pantalla","Sistemas de sonido","Podio","Pizarra y rotafolios","iluminacion",
                "Total:"
        };
        int [] cantidad=new int[8], cantidad_f=new int[8];


        for(int i=0;i<8;i++){
            cantidad[i]=sc.nextInt();
            cantidad_f[i]=cantidad[i]*P_equipamiento[i];
            System.out.println(equipamiento_text[i]+":"+cantidad_f[i]);
        }
        if(tipoEvento==2){
            System.out.println("Se agregara un cargo del doble por ser empresarial.");
            for(int i=0;i<8;i++){
                cantidad_f[i]*=2;
                System.out.println(equipamiento_text[i]+":"+cantidad_f[i]);
            }

        }

    }



    public static void servicio_conferencial(Scanner sc, int tipoEvento){
        int[] servicios = new int[]{
                100,
                250,
                175,
                60,
                250,
                120,
                40};
        String[] equipamiento_text = new String[]{
                "Mesas y Sillas","Escenario","Microfonos","Proyector y pantalla","Sistemas de sonido","Podio","Pizarra y rotafolios","iluminacion",
                "Total:"
        };
        if(tipoEvento==2){

        }

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
                precios[i] = (int)(precios[i] * 2);
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
                precios[i] = (int)(precios[i] * 2);
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
                precios[i] = (int)(precios[i] * 2);
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
                precios[i] = (int)(precios[i] * 2);
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



    // AQUI EMPIEZA LO DE JUAN
    /*                                          Juan                                          */
    public static void montajeSalon(
            Scanner sc,
            String nombreUsuario,
            Long telefonoUsuario,
            String correoUsuario,
            int personasUsuario,
            int diasUsuario
    ){
        System.out.println(); // Salto de linea para mejor apariencia
        System.out.print("""
        +----------------------------------------------------------------------------------------------+
        |                          Bienvenido/a a la renta del salón                                   |
        +----------------------------------------------------------------------------------------------+
        | Equipamientos:                    | Precio c/u  | Descripción                                |
        |    > Mesas                        | $50.00      | Mesas plegables de 6 plazas                |
        |    > Sillas                       | $10.00      | Sillas cómodas para eventos                |
        |    > Aires acondicionados         | $80.00      | Control de temperatura                     |
        |    > Pantallas                    | $30.00      | Pantallas LED de 50 pulgadas               |
        |    > Proyectores                  | $40.00      | Proyectores HD                             |
        |    > Focos reflectantes           | $20.00      | Iluminación profesional                    |
        |                                                                                              |
        | Servicios:                        | Precio c/u  | Descripción                                |
        |    > Personal de limpieza         | $100.00     | Limpieza post-evento                       |
        |    > Personal de Soporte técnico  | $70.00      | Asistencia durante el evento               |
        |    > Personal de cocina           | $25.00      | Conexión de alta velocidad                 |
        |    > Personal de decoración       | $150.00     | Arreglos personalizados                    |
        +----------------------------------------------------------------------------------------------+
        """);
        equipamientoServiciosSalon(
                sc,
                nombreUsuario,
                telefonoUsuario,
                correoUsuario,
                personasUsuario,
                diasUsuario
        ); // Llama a la funcion equipamiento y manda los datos necesarios
    }
    public static void equipamientoServiciosSalon(
            Scanner sc,
            String nombreUsuario,
            Long telefonoUsuario,
            String correoUsuario,
            int personasUsuario,
            int diasUsuario
    ){

        double[] totalEquipamiento = new double[6]; // Equipamiento -1 (Se resta -1 para poder acomodar el Total:)
        double sumatotalEquipamiento = 0;

        double[] totalServicio = new double[4];    // Servicio - 1 (Se resta -1 para poder acomodar el Total:)
        double sumatotalServicio = 0;

        String[] equipamiento = new String[]{
                "Mesas",
                "Sillas",
                "Aires acondicionados",
                "Pantallas",
                "Proyectores",
                "Focos reflectantes",
                "Total:"
        };

        double[] preciosEquipamiento = {
                50,    // Precio Mesas
                10,    // Precio Sillas
                80,    // Precio Aires acondicionados
                30,    // Precio Pantallas
                40,    // Precio Proyectores
                20,    // Precio Reflectores
        };

        String[] servicio = new String[]{
                "Personal de limpieza",
                "Personal de soporte técnico",
                "Personal de cocina",
                "Personal de decoración",
                "Total:",
        };

        double[] preciosServicio = {
                100,   // Precio Personal de Limpieza
                70,    // Precio Personal de Soporte Técnico
                25,    // Precio Personal de Cocina
                150,   // Precio Personal de Decoración
        };


        int[] cantidadEquipamiento = new int[6];    // Cantidad de equipamiento -> Ingresado por el usuario
        int[] cantidadServicio = new int[4];        // Cantidad de personal     -> Ingresado por el usuario

        try {
            for (int i = 0; i < equipamiento.length - 1; i++) {
                System.out.print("Cantidad de "  + equipamiento[i] + ": ");
                cantidadEquipamiento[i] = sc.nextInt();
                totalEquipamiento[i] = (cantidadEquipamiento[i] * diasUsuario * preciosEquipamiento[i]);
                sumatotalEquipamiento += totalEquipamiento[i];
            }
            System.out.println(); // Salto de linea para preguntar sobre el personal
            for (int i = 0; i < servicio.length - 1; i++) {
                System.out.print("Cantidad de "  + servicio[i] + ": ");
                cantidadServicio[i] = sc.nextInt();
                totalServicio[i] = (cantidadServicio[i] * diasUsuario * preciosServicio[i]);
                sumatotalServicio += totalServicio[i];
            }
        } catch (InputMismatchException e) {
            System.out.println("\n❌ Error: No se permiten letras ni caracteres especiales.");
            sc.nextLine();
        }

        decFinal(sc,
                diasUsuario,

                equipamiento,
                cantidadEquipamiento,
                preciosEquipamiento,
                totalEquipamiento,
                sumatotalEquipamiento,

                servicio,
                cantidadServicio,
                preciosServicio,
                totalServicio,
                sumatotalServicio
        );
    }

    public static void decFinal(
            Scanner sc,
            int diasUsuario,

            String[] equipamiento,
            int[] cantidadEquipamiento,
            double[] preciosEquipamiento,
            double[] totalEquipamiento,
            double sumatotalEquipamiento,

            String[] servicio,
            int[] cantidadServicio,
            double[] preciosServicio,
            double[] totalServicio,
            double sumatotalServicio
    ) {
        int pasoFinal = 0;
        do {
            try {
                System.out.print("""
                    +--------------------------+
                    | 1. Pagar                 |
                    | 2. Consultar información |
                    | 3. Modificar             |
                    | 4. Salir                 |
                    +--------------------------+
                    Qué desea hacer? (1 - 4):""" + " ");
                pasoFinal = sc.nextInt();

                switch (pasoFinal) {
                    case 1:
                        System.out.println("Realizando pago...");
                        break;
                    case 2:
                        informacion(sc, diasUsuario, equipamiento, cantidadEquipamiento, preciosEquipamiento, totalEquipamiento, sumatotalEquipamiento, servicio, cantidadServicio, preciosServicio, totalServicio, sumatotalServicio);
                        System.out.println("Consultando información...");
                        break;
                    case 3:
                        System.out.println("Modificando datos...");
                        break;
                    case 4:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("\n❌ Error: Debes ingresar un número entre 1 y 4\n");
                }

            } catch (InputMismatchException e) {
                System.out.println("\n❌ Error: No se permiten letras ni caracteres especiales\n");
                sc.nextLine(); // Limpia el buffer
            }

        } while (pasoFinal != 4);
    }

    public static void pago(Scanner sc, int personasUsuario){

    }
    public static void informacion(
            Scanner sc,
            int diasUsuario,

            String[] equipamiento,
            int[] cantidadEquipamiento,
            double[] preciosEquipamiento,
            double[] totalEquipamiento,
            double sumatotalEquipamiento,

            String[] servicio,
            int[] cantidadServicio,
            double[] preciosServicio,
            double[] totalServicio,
            double sumatotalServicio
    ){
        ///* Muestra en pantalla: | Equipamiento | Cantidad | Precio c/u |

        System.out.println("\n+------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("| %-27s | %-5s | %-10s | %-34s |", "Equipamiento", "Cantidad", "Precio c/u", "Cantidad x Precio c/u x (" + diasUsuario + ") día(s) x Tamaño evento x Tipo evento");
        for (int i = 0; i < equipamiento.length - 1; i++) {
            System.out.printf("\n| %-27s | %-8s | $%-9s | $%-63s |", equipamiento[i], cantidadEquipamiento[i], preciosEquipamiento[i], totalEquipamiento[i] );
        }
        System.out.println();
        System.out.printf("| %-27s | %-8s | %-10s | $%-63s |\n",equipamiento[6], "", "", sumatotalEquipamiento);
        ///* Fin equipamiento

        System.out.println("|                                                                                                                        |");

        ///* Muestra en pantalla: | Servicio | Cantidad | Precio c/u
        System.out.printf("| %-27s | %-5s | %-10s | %-34s |", "Servicio", "Cantidad", "Precio c/u", "Cantidad x Precio c/u x (" + diasUsuario + ") día(s) x Tamaño evento x Tipo evento");
        for (int i = 0; i < servicio.length - 1; i++) {
            System.out.printf("\n| %-27s | %-8s | $%-9s | $%-63s |", servicio[i], cantidadServicio[i], preciosServicio[i], totalServicio[i] );
        }
        System.out.println();
        System.out.printf("| %-27s | %-8s | %-10s | $%-63s |\n",servicio[4], "", "", sumatotalServicio);
        System.out.println("+------------------------------------------------------------------------------------------------------------------------+\n");
        /// * Fin Servicio
    }
}