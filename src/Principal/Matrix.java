import java.util.InputMismatchException;
import java.util.Scanner;

//import javax.lang.model.type.PrimitiveType;

import java.io.*;
//import java.rmi.server.ExportException;

public class Matrix {
    public static void main(String[] args) throws Exception{
        try (Scanner sc = new Scanner(System.in)) {
            int registro = 1;// Se inicializa porque si no da error en el do-while
            System.out.print("""
            ---------------------------------------------------------------
            |             Universidad Tecnológica de Tijuana              |
            |                                                             |
            |                           Matrix                            |
            |                                                             |
            |               Heredia Avalos Jose Angel                     |
            |               Montaño López Ángel Isaac                     |
            |               Romero Hernández Juan José                    |
            |                                                             |
            ---------------------------------------------------------------
            """);
            System.out.print("\uD83E\uDD0D Welcome, press enter to continue: ");
            sc.nextLine();
            do {
                System.out.println(); // -> Apariencia
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
                \uD83D\uDCCD Decisión (1 - 2):""" + " ");
                try {
                    registro = sc.nextInt();
                    switch (registro) {
                        case 1:
                            System.out.println(); // -> Apariencia
                            sc.nextLine(); // -> Buffer
                            datosUsuarios(sc);
                            break;
                        case 2:
                            System.out.println(); // -> Apariencia
                            System.out.println("\uD83E\uDD1AVUELVA PRONTO\u270B"); // -> Será el único que saldrá del programa
                            break;
                        default:
                            System.out.println("\n\u274CError: Ingresa un número entre (1 - 2).");
                            sc.nextLine();
                    }
                }
                catch (InputMismatchException a) {
                    System.out.println("\n\u274CError: No se permiten letras ni caracteres especiales.");
                    sc.nextLine();
                }
            } while (registro != 2);
        }
    }
    public static void datosUsuarios(Scanner sc) throws Exception{
        do {
            try {
                System.out.println("+---------------------------------------------------------------------------------------");
                System.out.print("| Ingrese su nombre completo (Empezando por apellidos): ");
                String nombreUsuario = sc.nextLine();

                System.out.print("| \uD83D\uDCF2 Ingrese su número de teléfono: ");
                long telefonoUsuario = sc.nextLong();
                sc.nextLine();

                System.out.print("| \uD83D\uDCE7 Ingrese su correo electrónico: ");
                String correoUsuario = sc.nextLine();

                System.out.print("| \uD83D\uDC65 Cantidad de personas a asistir al evento: ");
                int personasUsuario = sc.nextInt();

                if(personasUsuario <= 0){
                    System.out.println(); // Salto de línea para mejor apariencia
                    System.out.println("\u274C Error: Cantidad inválida");
                    sc.nextLine(); // Limpia buffer
                    System.out.println(); // Salto de línea para mejor apariencia
                }
                else{
                    int tipo_Evento= 2;
                    System.out.print("| \u2600\uFE0F  Cantidad de días que reservará el evento: ");
                    int diasUsuario = sc.nextInt();
                    System.out.println("+---------------------------------------------------------------------------------------");
                    System.out.println(); // -> Apariencia
                    Object[] resumen_datos = new Object[]{nombreUsuario, telefonoUsuario, correoUsuario, personasUsuario, diasUsuario, tipo_Evento, "titulo", "tamanoEvento"}; // <- Nada más se está utilizando aquí
                    opciones(sc, resumen_datos);
                    break;
                }

            } catch (InputMismatchException e) {
                
                System.out.println("\n\u274C Error: Solo números, no espacios ni letras\n");
                sc.nextLine(); //
            }
        } while (true);
    }
    public static void opciones(Scanner sc, Object[] resumen_datos) throws Exception{
        do {
            System.out.print("""
                +----------------------------------------+
                | Qué tipo de evento deseas contratar?   |
                +----------------------------------------+
                | 1. Social                              |
                | 2. Empresarial                         |
                | 3. Salir                               |
                +----------------------------------------+
                \uD83D\uDCCD Decisión (1 - 3):""" + " ");
            try {
                resumen_datos[5] = sc.nextInt();
                sc.nextLine();
                if((int) resumen_datos[5] >= 1 && (int) resumen_datos[5] <= 2){
                    System.out.println();
                    eventoSocial(sc, resumen_datos);
                    return;
                }
                else if((int) resumen_datos[5] == 3){
                    System.out.println(); // Apariencia
                    main(null);
                    break;
                }
                else{
                    System.out.println("\n\u274C Error: Ingresa un número entre (1 - 3).\n");
                }
            } catch (InputMismatchException b) {
                System.out.println("\n\u274C Error: No se permiten letras ni caracteres especiales\n");
                sc.nextLine(); // Limpia el buffer, importante mantenerlo
            }
        } while ((int) resumen_datos[5] != 3);
    }
    public static void eventoSocial(Scanner sc, Object[] resumen_datos) throws Exception{
        int tipoReservacion = 1;
        String[] equipamientoUniversal = new String[]{};
        double[] precios_equipamientoUniversal = new double[]{};

        String[] servicioUniversal = new String[]{};
        double[] precios_servicioUniversal = new double[]{};
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
                | 7. Regresar                                                    |
                | 8. Salir                                                       |
                +----------------------------------------------------------------+
                \uD83D\uDCCD Decisión (1 - 8):""" + " ");
            try {
                tipoReservacion = sc.nextInt();
                sc.nextLine();

                switch (tipoReservacion) {
                    case 1:
                        System.out.println(); // -> Apariencia 
//                  equipamientos                        
                        equipamientoUniversal = new String[]{
                            "Mesas y Sillas",
                            "Escenario",
                            "Micrófonos",
                            "Proyector y pantalla",
                            "Sistemas de sonido",
                            "Podio",
                            "Pizarra y rotafolios",
                            "Iluminación",
                            "Total:"
                        };
//  precios         equipamientos                        
                        precios_equipamientoUniversal = new double[]{
                            60,
                            200,
                            120,
                            65,
                            150,
                            140,
                            80,
                            125
                        };
//                  servicios
                        servicioUniversal = new String[]{
                            "Registro de Asistentes",
                            "Traducción",
                            "Transmisión o grabación",
                            "Café o coffee bar",
                            "Personal",
                            "Material",
                            "Wi-fi",
                            "Total:"
                        };
//  precios         servicios                        
                        precios_servicioUniversal = new double[]{
                            100,
                            250,
                            175,
                            60,
                            250,
                            120,
                            40
                        };
                        resumen_datos[6] = "Conferencia";
                        eventoConferencia(sc, resumen_datos, equipamientoUniversal, precios_equipamientoUniversal, servicioUniversal, precios_servicioUniversal);
                        return;
                    case 2:
                        System.out.println(); // -> Apariencia
//                  equipamientos
                        equipamientoUniversal = new String[]{
                            "Escenarios",
                            "Butacas",
                            "Iluminaciónes",
                            "Sistemas de sonido",
                            "Consolas",
                            "Camerinos",
                            "Decoraciónes",
                            "Total:"
                        };
//  precios         equipamientos
                        precios_equipamientoUniversal = new double[]{
                            200,
                            120,
                            70,
                            135,
                            150,
                            240,
                            300
                        };
//                  servicios
                        servicioUniversal = new String[]{
                            "Vendedores",
                            "Personal",
                            "Seguridad",
                            "Servicios de comida",
                            "Publicidad",
                            "Servicios de limpieza",
                            "Técnicos",
                            "Total:"
                        };
//  precios         servicios
                        precios_servicioUniversal = new double[]{
                            80,
                            350,
                            405,
                            90,
                            250,
                            140,
                            190
                        };
                        resumen_datos[6] = "Teatro";
                        eventoTeatro(sc, resumen_datos, equipamientoUniversal, precios_equipamientoUniversal, servicioUniversal, precios_servicioUniversal);
                        return;
                    case 3:
                        System.out.println(); // -> Apariencia 
//                  equipamientos
                        equipamientoUniversal = new String[]{
                            "Mesas altas tipo cóctel",
                            "Barra de bebidas",
                            "Sistema de sonido ambiental",
                            "Área de bienvenida",
                            "Iluminación decorativa",
                            "Decoración floral",
                            "Total:"
                        };
//  precios         equipamientos
                        precios_equipamientoUniversal = new double[]{
                            300,
                            800,
                            400,
                            250,
                            500,
                            600
                        };
//                  servicios
                        servicioUniversal = new String[]{
                            "Servicio de catering",
                            "DJ o música en vivo",
                            "Fotografía y video",
                            "Guardarropa",
                            "Valet parking",
                            "Seguridad",
                            "Meseros y anfitriones",
                            "Total:"
                        };
//  precios         servicios
                        precios_servicioUniversal = new double[]{
                            1200,
                            1500,
                            1000,
                            300,
                            400,
                            350,
                            500
                        };
                        resumen_datos[6] = "Recepción";
                        eventoRecepcion(sc, resumen_datos, equipamientoUniversal, precios_equipamientoUniversal, servicioUniversal, precios_servicioUniversal);
                        return;
                    case 4:
                        System.out.println(); // Apariencia -> Borrar si no es necesario o si hace doble (alt + tab)
//                  equipamientos
                        equipamientoUniversal = new String[]{
                            "Mesas redondas o rectangulares",
                            "Sillas con fundas",
                            "Mantelería y vajilla formal",
                            "Centros de mesa",
                            "Iluminación ambiental",
                            "Tarima para discursos",
                            "Total:"
                        };
//  precios         equipamientos
                        precios_equipamientoUniversal = new double[]{
                            700,
                            400,
                            650,
                            300,
                            500,
                            350
                        };
//                  servicios
                        servicioUniversal = new String[]{
                            "Menú completo",
                            "Cocineros y meseros",
                            "Música en vivo o DJ",
                            "Pastel formal",
                            "Fotografía profesional",
                            "Brindis y discursos",
                            "Estación de bebidas",
                            "Total:"
                        };
//  precios         servicios
                        precios_servicioUniversal = new double[]{
                            2500,
                            1800,
                            1500,
                            500,
                            1000,
                            600,
                            400
                        };
                        resumen_datos[6] = "Banquete";
                        eventoBanquete(sc, resumen_datos, equipamientoUniversal, precios_equipamientoUniversal, servicioUniversal, precios_servicioUniversal);
                        return;
                    case 5:
//                  equipamientos                   
                        equipamientoUniversal = new String[]{
                            "Mesas",
                            "Sillas",
                            "Aires acondicionados",
                            "Pantallas",
                            "Proyectores",
                            "Focos reflectantes",
                            "Total:"
                        };
//  precios         equipamientos
                        precios_equipamientoUniversal = new double[]{
                            50,    // Precio Mesas
                            10,    // Precio Sillas
                            80,    // Precio Aires acondicionados
                            30,    // Precio Pantallas
                            40,    // Precio Proyectores
                            20,    // Precio Reflectores
                        };
//                  servicios                    
                        servicioUniversal = new String[]{
                            "Personal de limpieza",
                            "Personal de soporte técnico",
                            "Personal de cocina",
                            "Personal de decoración",
                            "Total:"
                        };
//  precios         servicios                   
                        precios_servicioUniversal = new double[]{
                            100,   // Precio Personal de Limpieza
                            70,    // Precio Personal de Soporte Técnico
                            25,    // Precio Personal de Cocina
                            150,   // Precio Personal de Decoración
                        };                        
                        resumen_datos[6] = "Salón";
                        eventoSalon(sc, resumen_datos, equipamientoUniversal, precios_equipamientoUniversal, servicioUniversal, precios_servicioUniversal);
                        return;
                    case 6:
//                  equipamientos                       
                        equipamientoUniversal = new String[]{
                            "Mesas en forma de U",      // 400
                            "Sillas",                   // 100
                            "Pantallas",                // 600
                            "Proyectores",              // 600
                            "Micrófonos",               // 300
                            "Pizarras o rotafolios",    // 200
                            "Paquetes de oficina",      // 150
                            "Total:"
                        };
//  precios         equipamientos
                        precios_equipamientoUniversal = new double[]{
                            400,    // Mesas en forma de U
                            100,    // Sillas
                            600,    // Pantallas
                            600,    // Proyectores
                            300,    // Micrófonos
                            200,    // Pizarras
                            150,    // Paquetes de oficina
                        };
//                  servicios
                        servicioUniversal = new String[]{
                            "Paquetes Coffee Break",     // 350
                            "Repetidores Wi-Fi",        // 100
                            "Personal Soporte Técnico", // 500
                            "Moderadores",              // 800
                            "Traductores",              // 1200
                            "Personal de Apoyo",        // 400
                            "Paquetes de Impresión",    // 250
                            "Total:"
                        };
//  precios         servicios
                        precios_servicioUniversal = new double[]{
                            350,
                            100,
                            500,
                            800,
                            1200,
                            400,
                            250,
                        };
                        resumen_datos[6] = "Disposición en forma de U";
                        eventoU(sc, resumen_datos, equipamientoUniversal, precios_equipamientoUniversal, servicioUniversal, precios_servicioUniversal);
                        return;
                    case 7:
                        System.out.println(); // Apariencia
                        opciones(sc, resumen_datos);
                        return;
                    case 8:
                        main(null);
                    default:
                        System.out.println("\n\u274C Error: Ingresar un número entre (1 - 8)\n");
                }
            } catch (InputMismatchException c) {
                System.out.println("\n\u274C Error: No se permiten letras ni caracteres especiales\n");
                sc.nextLine();
            }
        } while (tipoReservacion != 7);
    }
////    H E R E D I A    
    public static void eventoConferencia(Scanner sc, Object[]resumen_datos, String[] equipamientoUniversal, double[] precios_equipamientoUniversal, String[] servicioUniversal, double[] precios_servicioUniversal) throws Exception{
        System.out.println(); // Apariencia
        System.out.print("""
            +---------------------------------------------------------------------------------------------+\n|                           Bienvenido/a a la renta de la conferencia                         |
            +---------------------------------------------------------------------------------------------+\n|  Equipamientos:                           Precios:                                          |
            |     > Mesas y sillas                        60$                                             |\n|     > Escenario.                            200$                                            |
            |     > Microfonos.                           120$                                            |\n|     > Proyector y pantalla                  65$                                             |
            |     > Sistema de sonido.                    150$                                            |\n|     > Podio.                                140$                                            |
            |     > Pizarra y rotafolios.                 80$                                             |\n|     > Iluminación.                          125$                                            |
            |                                                                                             |\n|  Servicios:                                                                                 |
            |     > Registro de asistentes.               100$                                            |\n|     > Traducción simultanea.                250$                                            |
            |     > Transmisión en vivo o grabacion.      175$                                            |\n|     > Café o coffe break.                   60$                                             |
            |     > Personal técnico.                     250$                                            |\n|     > Material                              120$                                            |
            |     > Wi-Fi                                 40$                                             |
            +---------------------------------------------------------------------------------------------+
            """);
            montajeUniversal(sc, resumen_datos, equipamientoUniversal, precios_equipamientoUniversal, servicioUniversal, precios_servicioUniversal);
        }
    public static void eventoTeatro( Scanner sc, Object[]resumen_datos, String[] equipamientoUniversal, double[] precios_equipamientoUniversal, String[] servicioUniversal, double[] precios_servicioUniversal) throws Exception{
        System.out.println(); // -> Apariencia
        System.out.print("""
            +---------------------------------------------------------------------------------------------+\n|                           Bienvenido/a a la renta del teatro                                |
            +---------------------------------------------------------------------------------------------+\n| Equipamientos:                           Precios:                                           |
            |     > Escenarios con telón                  200$                                            |\n|     > Butacas fijas o móviles               120$                                            |
            |     > Iluminaciónes teatral                  70$                                            |\n|     > Sistemas de sonido envolvente         135$                                            |
            |     > Consolas de audio/luces               150$                                            |\n|     > Camerinos o vestidores                240$                                            |
            |     > Decoración y escenografía             300$                                            |
            |                                                                                             |\n| Servicios:                                                                                  |
            |     > Vendedores de boletos                  80$                                            |\n|     > Personal de taquilla y acomodadores.  350$                                            |
            |     > Seguridad y control de acceso         405$                                            |\n|     > Servicios de cafetería o snacks        90$                                            |
            |     > Publicidad y promoción                250$                                            |\n|     > Servicios de limpieza                 140$                                            |
            |     > Asistencia técnica en luces/sonido    190$                                            |
            +---------------------------------------------------------------------------------------------+
            """);
            montajeUniversal(sc, resumen_datos, equipamientoUniversal, precios_equipamientoUniversal, servicioUniversal, precios_servicioUniversal);
    }
////    I S A A C    
    public static void eventoRecepcion( Scanner sc, Object[]resumen_datos, String[] equipamientoUniversal, double[] precios_equipamientoUniversal, String[] servicioUniversal, double[] precios_servicioUniversal) throws Exception{
        System.out.println(); // -> Apariencia
        System.out.print("""
            +--------------------------------------------------------------------------------------------------+
            |                            Bienvenido/a a la renta de recepción                                  |
            +--------------------------------------------------------------------------------------------------+
            | Equipamientos:                       | Precio c/u  | Descripción                                 |
            |    > Mesas altas tipo cóctel         | $300.00     | Mesas para eventos tipo cóctel              |
            |    > Barra de bebidas                | $800.00     | Mueble para servicio de bebidas             |
            |    > Sistema de sonido ambiental     | $400.00     | Audio de ambientación                       |
            |    > Área de bienvenida              | $250.00     | Espacio decorado para recepción             |
            |    > Iluminación decorativa          | $500.00     | Ambientación especial                       |
            |    > Decoración floral               | $600.00     | Arreglos florales                           |
            |                                                                                                  |
            | Servicios:                           | Precio c/u  | Descripción                                 |
            |    > Servicio de catering            | $1200.00    | Alimentos y bebidas para el evento          |
            |    > DJ o música en vivo             | $1500.00    | Música en vivo o DJ                         |
            |    > Fotografía y video              | $1000.00    | Captura y grabación del evento              |
            |    > Guardarropa                     | $300.00     | Servicio para guardar pertenencias          |
            |    > Valet parking                   | $400.00     | Servicio de Estacionamiento                 |
            |    > Seguridad                       | $350.00     | Personal profesional de seguridad           |
            |    > Meseros y anfitriones           | $500.00     | Atención  a los invitados                   |
            +--------------------------------------------------------------------------------------------------+
            """);
            montajeUniversal(sc, resumen_datos, equipamientoUniversal, precios_equipamientoUniversal, servicioUniversal, precios_servicioUniversal);
    }
    public static void eventoBanquete( Scanner sc, Object[]resumen_datos, String[] equipamientoUniversal, double[] precios_equipamientoUniversal, String[] servicioUniversal, double[] precios_servicioUniversal ) throws Exception{ 
        System.out.println(); // -> Apariencia
        System.out.print("""
            +--------------------------------------------------------------------------------------------------+
            |                            Bienvenido/a a evento Banquete                                        |
            +--------------------------------------------------------------------------------------------------+
            | Equipamientos:                       | Precio c/u  | Descripción                                 |
            |    > Mesas redondas o rectangulares  | $700.00     | Mesas para eventos elegantes                |
            |    > Sillas con fundas               | $400.00     | Sillas decoradas con fundas                 |
            |    > Mantelería y vajilla formal     | $650.00     | Manteles y vajilla para eventos formales    |
            |    > Centros de mesa                 | $300.00     | Decoración central para mesas               |
            |    > Iluminación ambiental           | $500.00     | Luces para crear ambiente cálido            |
            |    > Tarima para discursos           | $350.00     | Plataforma para presentaciones              |
            |                                                                                                  |
            | Servicios:                           | Precio c/u  | Descripción                                 |
            |    > Menú completo                   | $2500.00    | Comida y bebida completa para invitados     |
            |    > Cocineros y meseros             | $1800.00    | Personal para cocina y atención             |
            |    > Música en vivo o DJ             | $1500.00    | Entretenimiento musical profesional         |
            |    > Pastel formal                   | $500.00     | Pastel especial para eventos                |
            |    > Fotografía profesional          | $1000.00    | Registro fotográfico del evento             |
            |    > Brindis y discursos             | $600.00     | Organización de brindis y presentaciones    |
            |    > Estación de bebidas             | $400.00     | Barra de bebidas especializadas             |
            +--------------------------------------------------------------------------------------------------+
            """);
            montajeUniversal(sc, resumen_datos, equipamientoUniversal, precios_equipamientoUniversal, servicioUniversal, precios_servicioUniversal);
    }
////    J U A N
    public static void eventoSalon( Scanner sc, Object[]resumen_datos, String[] equipamientoUniversal, double[] precios_equipamientoUniversal, String[] servicioUniversal, double[] precios_servicioUniversal) throws Exception{
        System.out.println(); // -> Apariencia
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
        montajeUniversal(sc, resumen_datos, equipamientoUniversal, precios_equipamientoUniversal, servicioUniversal, precios_servicioUniversal); // Llama a la función equipamiento y manda los datos necesarios
    }
    public static void eventoU( Scanner sc, Object[]resumen_datos, String[] equipamientoUniversal, double[] precios_equipamientoUniversal, String[] servicioUniversal, double[] precios_servicioUniversal) throws Exception{
        System.out.println(); // Salto de línea para mejor apariencia
        System.out.print("""
                +--------------------------------------------------------------------------------------------------+
                |                             Bienvenido/a a la Disposición en forma de U                          |
                +--------------------------------------------------------------------------------------------------+
                | Equipamientos:                       | Precio c/u  | Descripción                                 |
                |    > Mesas en forma de U             | $400.00     | Para reuniones tipo conferencia             |
                |    > Sillas alrededor                | $100.00     | Asientos para asistentes                    |
                |    > Pantalla o proyector al frente  | $600.00     | Proyección de presentaciones                |
                |    > Micrófonos (inalámbricos/mesa)  | $300.00     | Audio para presentadores o participantes    |
                |    > Pizarra blanca o rotafolio      | $200.00     | Herramienta para exposiciones o notas       |
                |    > Material de oficina             | $150.00     | Hojas, bolígrafos y otros insumos básicos   |
                |                                                                                                  |
                | Servicios:                           | Precio c/u  | Descripción                                 |
                |    > Coffee break                    | $350.00     | Café, snacks y bebidas ligeras              |
                |    > Wi-Fi                           | $100.00     | Conectividad para asistentes                |
                |    > Soporte técnico                 | $500.00     | Asistencia con tecnología y personal        |
                |    > Moderadores                     | $800.00     | Profesional para guiar la reunión           |
                |    > Traducción simultánea           | $1200.00    | Intérpretes para distintos idiomas          |
                |    > Personal de apoyo               | $400.00     | Anfitriones para atención y logística       |
                |    > Paquetes de impresión           | $250.00     | Documentos impresos para participantes      |
                +--------------------------------------------------------------------------------------------------+
                """);
        montajeUniversal(sc, resumen_datos, equipamientoUniversal, precios_equipamientoUniversal, servicioUniversal, precios_servicioUniversal);
        return;
    }
////    P A R T E   F I N A L   
    public static void montajeUniversal( Scanner sc, Object[]resumen_datos, String[] equipamientoUniversal, double[] precios_equipamientoUniversal, String[] servicioUniversal, double[] precios_servicioUniversal) throws Exception{
        do {
            double[] totalEquipamiento = new double[equipamientoUniversal.length - 1]; // Equipamiento -1 (Se resta -1 para poder acomodar el Total:) 
            double sumatotalEquipamiento = 0;

            double[] totalServicio = new double[servicioUniversal.length - 1];    // Servicio - 1 (Se resta -1 para poder acomodar el Total:)
            double sumatotalServicio = 0;

            int[] cantidadEquipamiento = new int[equipamientoUniversal.length - 1];    // Cantidad de equipamiento -> Ingresado por el usuario
            int[] cantidadServicio = new int[servicioUniversal.length - 1];        // Cantidad de personal     -> Ingresado por el usuario

            try {
                for (int i = 0; i < equipamientoUniversal.length - 1; i++) {
                    System.out.print("⭐ Cantidad de "  + equipamientoUniversal[i] + ": ");
                    cantidadEquipamiento[i] = sc.nextInt();
                    totalEquipamiento[i] = (cantidadEquipamiento[i] * (int) resumen_datos[4] * precios_equipamientoUniversal[i]);
                    sumatotalEquipamiento += totalEquipamiento[i];
                }
                System.out.println(); // Salto de línea para preguntar sobre el personal
                for (int i = 0; i < servicioUniversal.length - 1; i++) {
                    System.out.print("⭐ Cantidad de "  + servicioUniversal[i] + ": ");
                    cantidadServicio[i] = sc.nextInt();
                    totalServicio[i] = (cantidadServicio[i] * (int) resumen_datos[4] * precios_servicioUniversal[i]);
                    sumatotalServicio += totalServicio[i];
                }
                Object[] resumen_equipo = new Object[]{equipamientoUniversal, cantidadEquipamiento, precios_equipamientoUniversal, totalEquipamiento, sumatotalEquipamiento};
                Object[] resumen_servicios = new Object[]{servicioUniversal, cantidadServicio, precios_servicioUniversal, totalServicio, sumatotalServicio};
                decFinal(sc, resumen_datos, resumen_equipo, resumen_servicios);

            } catch (InputMismatchException e) {
                System.out.println("\n\u274C Error: No se permiten letras ni caracteres especiales\n");
                sc.nextLine();
            }
            return;
            } while (true);
    }
    public static void decFinal(Scanner sc,Object[]resumen_datos,Object[] datos_equipamiento, Object[]datos_servicio) throws Exception{
        System.out.println();
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
                    📍 Decisión (1 - 4):""" + " ");
                pasoFinal = sc.nextInt();
                switch (pasoFinal) {
                    case 1:
                        pago(sc,resumen_datos,datos_equipamiento,datos_servicio);
                        return;
                    case 2:
                        informacion(sc,resumen_datos,datos_equipamiento,datos_servicio);
                        break;
                    case 3:
                        eventoSocial(sc, resumen_datos);
                        break;
                    case 4:
                        System.out.println(); // Apariencia
                        main(null);
                        break;
                    default:
                        System.out.println("\n\u274C Error: Debes ingresar un número entre 1 y 4\n");
                }

            } catch (InputMismatchException e) {
                System.out.println("\n\u274C Error: No se permiten letras ni caracteres especiales\n");
                sc.nextLine(); // Limpia el buffer
            }
        } while (pasoFinal != 4);
    }
    public static void pago(Scanner sc, Object[]resumen_datos, Object[]datos_equipamiento, Object[]datos_servicio) throws Exception{

        double pagoRealizado, montoPagar = 0;
        double sumatotalEquipamiento = (double)datos_equipamiento[4], sumatotalServicio = (double)datos_servicio[4];
        do {
            try {
                System.out.println(); // Salto para mejor apariencia
                // Evento social
                if((int)resumen_datos[5] == 1){
                    // Tamaño Pequeño, Tipo Social -> (sumatotalEquipamiento + sumatotalServicio) * 1 (ó dejar asi sin modificar)
                    if((int) resumen_datos[3] >= 1 && (int) resumen_datos[3] <= 50){
                        montoPagar = (sumatotalEquipamiento + sumatotalServicio);
                    }
                    // Tamaño Mediano, Tipo Social -> (sumatotalEquipamiento + sumatotalServicio) * 1.5
                    else if((int) resumen_datos[3] >= 51 && (int) resumen_datos[3] <= 100){
                        montoPagar = (sumatotalEquipamiento + sumatotalServicio) * 1.5;
                    }
                    // Tamaño Grande, Tipo Social -> (sumatotalEquipamiento + sumatotalServicio) * 2
                    else if((int) resumen_datos[3] >= 101){
                        montoPagar = (sumatotalEquipamiento + sumatotalServicio) * 2;
                    }
                }
                else if((int)resumen_datos[5] == 2){
                    // Tamaño Pequeño, Tipo Empresarial -> (sumatotalEquipamiento + sumatotalServicio) * 1 (ó dejar asi sin modificar)
                    if((int) resumen_datos[3] >= 1 && (int) resumen_datos[3] <= 50){
                        montoPagar = ((sumatotalEquipamiento + sumatotalServicio) * 2);
                    }
                    // Tamaño Mediano, Tipo Empresarial -> (sumatotalEquipamiento + sumatotalServicio) * 2.5
                    else if((int) resumen_datos[3] >= 51 && (int) resumen_datos[3] <= 100){
                        montoPagar = ((sumatotalEquipamiento + sumatotalServicio) * 2.5);
                        }
                    // Tamaño Grande, Tipo Empresarial -> (sumatotalEquipamiento + sumatotalServicio) * 2
                    else if((int) resumen_datos[3] >= 101){
                        montoPagar = ((sumatotalEquipamiento + sumatotalServicio) * 3);
                    }
                }
                System.out.printf("""
                +----------------------------+
                | Monto a pagar: $%-10s |
                +----------------------------+
                Ingrese el monto total: $""",
                montoPagar);
                pagoRealizado = sc.nextDouble();

                if(pagoRealizado == montoPagar){
                    System.out.println("\n💵 Muchas gracias por su compra, vuelva pronto!\n");
                    tickets(sc, resumen_datos, datos_equipamiento, datos_servicio);
                    break;
                }else if(pagoRealizado > montoPagar){
                    System.out.println("\nSu cambio es de: " + (pagoRealizado - montoPagar));
                    System.out.println("\n💵 Muchas gracias por su compra, vuelva pronto!");
                    tickets(sc, resumen_datos, datos_equipamiento, datos_servicio);
                    break;
                }else if(pagoRealizado < montoPagar){
                    System.out.println("\n💥 Dinero insuficiente, le hace falta: " + (montoPagar - pagoRealizado));
                    decFinal(sc,resumen_datos,datos_equipamiento,datos_servicio);
                    return;
                }else{
                    sc.next(); // Limpia el buffer
                }
            } catch (InputMismatchException z) {
                System.out.println("\n❌ Error: No se permiten letras ni caracteres especiales");
                sc.next(); // Limpia el buffer
            }
        } while (true);
    }
    public static void informacion(Scanner sc,Object[]resumen_datos,Object[]datos_equipamiento,Object[]datos_servicio){
        String[] equipamiento = (String[])datos_equipamiento[0];
        int[] cantidadEquipamiento = (int[])datos_equipamiento[1];
        double[] preciosEquipamiento = (double[])datos_equipamiento[2];
        double[] totalEquipamiento = (double[])datos_equipamiento[3];
        double sumatotalEquipamiento = (double)datos_equipamiento[4];

        String[] servicio = (String[])datos_servicio[0];
        int[] cantidadServicio = (int[])datos_servicio[1];
        double[] preciosServicio = (double[])datos_servicio[2];
        double[] totalServicio = (double[])datos_servicio[3];
        double sumatotalServicio = (double)datos_servicio[4];
        double porcentaje = 0;
        String typeEvent = "";

        if((int) resumen_datos[5] == 1){
            typeEvent = "Social";
            // Tamaño Pequeño, Tipo Social -> Todo x 1 (ó sin multiplicar)
            if((int) resumen_datos[3] >= 1 && (int) resumen_datos[3] <= 50){
                porcentaje = 1;
                resumen_datos[7] = "Pequeño";
            } 
            else if((int) resumen_datos[3] >= 51 && (int) resumen_datos[3] <= 100) {
                porcentaje = 1.5;
                resumen_datos[7] = "Mediano";
            }        
            else if((int) resumen_datos[3] >= 101) {
                porcentaje = 2;
                resumen_datos[7] = "Grande";
        }
    }
        else if((int)resumen_datos[5] == 2) {
        typeEvent = "Empresarial";
            if((int) resumen_datos[3] >= 1 && (int) resumen_datos[3] <= 50) {
                porcentaje = 2;
                resumen_datos[7] = "Pequeño";
            }
            else if((int) resumen_datos[3] >= 51 && (int) resumen_datos[3] <= 100) {
                porcentaje = 2.5;
                resumen_datos[7] = "Mediano";
            }
            else if((int) resumen_datos[3] >= 101) {
                porcentaje = 3;
                resumen_datos[7] = "Grande";
            }
        }
                
        System.out.printf("""
                                \n----------------------------------------------------------------------
                                | Nombre:                   %-40s |
                                | Número de teléfono:       %-40s |
                                | Correo:                   %-40s |
                                | Cantidad de personas:     %-40s |
                                | Días de renta:            %-40s |
                                | Tipo de evento:           %-40s |
                                | Evento contratado:        %-40s |
                                | Tamaño del evento:        %-40s |
                                +-------------------------------------------------------------------------------------------------------------------------+
                                """,
                        resumen_datos[0],  // Nombre
                        resumen_datos[1],  // Teléfono
                        resumen_datos[2],  // Correo
                        resumen_datos[3],  // Personas
                        resumen_datos[4],  // Días
                        typeEvent,         // Tipo de evento
                        resumen_datos[6], // Evento contratado
                        resumen_datos[7]          // Tamaño del evento
                );
                System.out.printf("| %-27s | %-5s | %-10s | %-65s |", "Equipamiento", "Cantidad", "Precio c/u", "Cantidad x Precio c/u x (" + resumen_datos[4] + ") día(s) x Tamaño evento x Tipo evento");
                for (int i = 0; i < equipamiento.length - 1; i++) {
                    System.out.printf("\n| %-27s | %-8s | $%-9s | $%-64s |", equipamiento[i], cantidadEquipamiento[i], preciosEquipamiento[i], (totalEquipamiento[i] * porcentaje));
                }
                System.out.println();
                System.out.printf("| %-27s | %-8s | %-10s | $%-64s |\n", equipamiento[equipamiento.length-1], "", "", (sumatotalEquipamiento * porcentaje));
                ///* Fin equipamiento

                System.out.println("|                                                                                                                         |");

                ///* Muestra en pantalla: | Servicio | Cantidad | Precio c/u
                System.out.printf("| %-27s | %-5s | %-10s | %-65s |", "Servicio", "Cantidad", "Precio c/u", "Cantidad x Precio c/u x (" + resumen_datos[4] + ") día(s) x Tamaño evento x Tipo evento");
                for (int i = 0; i < servicio.length - 1; i++) {
                    System.out.printf("\n| %-27s | %-8s | $%-9s | $%-64s |", servicio[i], cantidadServicio[i], preciosServicio[i], (totalServicio[i] * porcentaje));
                }
                System.out.println();
                System.out.printf("| %-27s | %-8s | %-10s | $%-64s |\n", servicio[servicio.length-1], "", "", (sumatotalServicio * porcentaje));
                System.out.println("+-------------------------------------------------------------------------------------------------------------------------+");
                System.out.printf("| Total a pagar: $%-103s |%n", (sumatotalEquipamiento + sumatotalServicio) * porcentaje);
                System.out.println("+-------------------------------------------------------------------------------------------------------------------------+");
                /// * Fin Servicio
                sc.nextLine(); // Limpia el buffer
                System.out.print("\uD83D\uDC46 Presiona enter para volver: ");
                sc.nextLine(); // Limpia el buffer
            
        System.out.println(); // Salto de línea para mejor apariencia
    }











    public static void tickets(Scanner sc,Object[]resumen_datos,Object[]datos_equipamiento,Object[]datos_servicio) throws Exception{
        String[] equipamiento = (String[])datos_equipamiento[0];
        int[] cantidadEquipamiento = (int[])datos_equipamiento[1];
        double[] preciosEquipamiento = (double[])datos_equipamiento[2];
        double[] totalEquipamiento = (double[])datos_equipamiento[3];
        double sumatotalEquipamiento = (double)datos_equipamiento[4];

        String[] servicio = (String[])datos_servicio[0];
        int[] cantidadServicio = (int[])datos_servicio[1];
        double[] preciosServicio = (double[])datos_servicio[2];
        double[] totalServicio = (double[])datos_servicio[3];
        double sumatotalServicio = (double)datos_servicio[4];
        double porcentaje = 0;
        String typeEvent = "";

        FileWriter archivo = new FileWriter("TicketsPago.txt", true);
        PrintWriter escritor = new PrintWriter(archivo);
        if((int) resumen_datos[5] == 1){
            typeEvent = "Social";
            // Tamaño Pequeño, Tipo Social -> Todo x 1 (ó sin multiplicar)
            if((int) resumen_datos[3] >= 1 && (int) resumen_datos[3] <= 50){
                porcentaje = 1;
                resumen_datos[7] = "Pequeño";
            } 
            else if((int) resumen_datos[3] >= 51 && (int) resumen_datos[3] <= 100) {
                porcentaje = 1.5;
                resumen_datos[7] = "Mediano";
            }        
            else if((int) resumen_datos[3] >= 101) {
                porcentaje = 2;
                resumen_datos[7] = "Grande";
        }
    }
        else if((int)resumen_datos[5] == 2) {
        typeEvent = "Empresarial";
            if((int) resumen_datos[3] >= 1 && (int) resumen_datos[3] <= 50) {
                porcentaje = 2;
                resumen_datos[7] = "Pequeño";
            }
            else if((int) resumen_datos[3] >= 51 && (int) resumen_datos[3] <= 100) {
                porcentaje = 2.5;
                resumen_datos[7] = "Mediano";
            }
            else if((int) resumen_datos[3] >= 101) {
                porcentaje = 3;
                resumen_datos[7] = "Grande";
            }
        }
                
        escritor.printf("""
                                \n----------------------------------------------------------------------
                                | Nombre:                   %-40s |
                                | Número de teléfono:       %-40s |
                                | Correo:                   %-40s |
                                | Cantidad de personas:     %-40s |
                                | Días de renta:            %-40s |
                                | Tipo de evento:           %-40s |
                                | Evento contratado:        %-40s |
                                | Tamaño del evento:        %-40s |
                                +-------------------------------------------------------------------------------------------------------------------------+
                                """,
                        resumen_datos[0],  // Nombre
                        resumen_datos[1],  // Teléfono
                        resumen_datos[2],  // Correo
                        resumen_datos[3],  // Personas
                        resumen_datos[4],  // Días
                        typeEvent,         // Tipo de evento
                        resumen_datos[6], // Evento contratado
                        resumen_datos[7]          // Tamaño del evento
                );

                ///* Muestra en pantalla: | Equipamiento ...
                escritor.printf("| %-27s | %-5s | %-10s | %-65s |", "Equipamiento", "Cantidad", "Precio c/u", "Cantidad x Precio c/u x (" + resumen_datos[4] + ") día(s) x Tamaño evento x Tipo evento");
                for (int i = 0; i < equipamiento.length - 1; i++) {
                    escritor.printf("\n| %-27s | %-8s | $%-9s | $%-64s |", equipamiento[i], cantidadEquipamiento[i], preciosEquipamiento[i], (totalEquipamiento[i] * porcentaje));
                }
                escritor.println();
                escritor.printf("| %-27s | %-8s | %-10s | $%-64s |\n", equipamiento[equipamiento.length-1], "", "", (sumatotalEquipamiento * porcentaje));
                ///* Fin equipamiento

                escritor.println("|                                                                                                                         |");

                ///* Muestra en pantalla: | Servicio | Cantidad | Precio c/u
                escritor.printf("| %-27s | %-5s | %-10s | %-65s |", "Servicio", "Cantidad", "Precio c/u", "Cantidad x Precio c/u x (" + resumen_datos[4] + ") día(s) x Tamaño evento x Tipo evento");
                for (int i = 0; i < servicio.length - 1; i++) {
                    escritor.printf("\n| %-27s | %-8s | $%-9s | $%-64s |", servicio[i], cantidadServicio[i], preciosServicio[i], (totalServicio[i] * porcentaje));
                }
                escritor.println();
                escritor.printf("| %-27s | %-8s | %-10s | $%-64s |\n", servicio[servicio.length-1], "", "", (sumatotalServicio * porcentaje));
                escritor.println("+-------------------------------------------------------------------------------------------------------------------------+");
                escritor.printf("| Total a pagar: $%-103s |%n", (sumatotalEquipamiento + sumatotalServicio) * porcentaje);
                escritor.println("+-------------------------------------------------------------------------------------------------------------------------+");
                /// * Fin Servicio
                //sc.nextLine(); // Limpia el buffer
                escritor.print("\uD83D\uDC46 Presiona enter para volver: ");
                //sc.nextLine(); // Limpia el buffer
            escritor.close();
        System.out.println(); // Salto de línea para mejor apariencia
    }
}