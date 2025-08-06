import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

public class a {
    public static void main(String[] args) {
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
    // ->
    public static void datosUsuarios(Scanner sc){
        System.out.println("+---------------------------------------------------------------------------------------");
        do {
            try {
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
                    String titulo = "";
                    System.out.print("| \u2600\uFE0F Cantidad de días que reservará el evento: ");
                    int diasUsuario = sc.nextInt();
                    System.out.println("+---------------------------------------------------------------------------------------");
                    System.out.println(); // -> Apariencia
                    Object[] resumen_datos = new Object[]{nombreUsuario, telefonoUsuario, correoUsuario, personasUsuario, diasUsuario, tipo_Evento, titulo};
                    opciones(sc, resumen_datos);
                    break;
                }

            } catch (InputMismatchException e) {
                sc.nextLine(); //
                System.out.println(); // -> Apariencia
                System.out.println("\u274C Error: Solo números, no espacios ni letras");
            }
        } while (true);
    }
    // ->
    public static void opciones(Scanner sc, Object[] resumen_datos){
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
    // ->
    public static void eventoSocial(Scanner sc, Object[] resumen_datos) {
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
                | 7. Regresar                                                    |
                | 8. Salir                                                       |
                +----------------------------------------------------------------+
                \uD83D\uDCCD Decisión (1 - 8):""" + " ");
            try {
                tipoReservacion = sc.nextInt();
                sc.nextLine();

                switch (tipoReservacion) {
                    case 1:
                        System.out.println(); // Apariencia -> Borrar si no es necesario o si hace doble (alt + tab)
                        resumen_datos[6] = "Conferencia";
                        montaje_conferencia(sc, resumen_datos); // Aplicar como booleano by: Jose
                        return;
                    case 2:
                        System.out.println(); // Apariencia -> Borrar si no es necesario o si hace doble (alt + tab)
                        resumen_datos[6] = "Teatro";
                        montaje_teatro(sc, resumen_datos);
                        return;
                    case 3:
                        System.out.println(); // Apariencia -> Borrar si no es necesario o si hace doble (alt + tab)
                        resumen_datos[6] = "Recepción";
                        eventoRecepcion(sc, resumen_datos); // ← NUEVA FUNCIÓN RECEPCIÓN
                        return;
                    case 4:
                        System.out.println(); // Apariencia -> Borrar si no es necesario o si hace doble (alt + tab)
                        resumen_datos[6] = "Banquete";
                        eventoBanquete(sc, resumen_datos);
                        return;
                    case 5:
                        resumen_datos[6] = "Salón";
                        montajeSalon(sc, resumen_datos);
                        return;
                    case 6:
                        resumen_datos[6] = "Disposición en forma de U";
                        montajeU(sc, resumen_datos);
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
    // ->
    /*                                          1. Conferencia, parte de Jose (yo).                                          */
    public static void montaje_conferencia(Scanner sc, Object[] resumen_datos){
        Object[] datos_equipamiento = null, datos_servicio = null;
        System.out.println(); // Apariencia

        System.out.print("""
            +---------------------------------------------------------------------------------------------+\n|                           Bienvenido/a a la renta de la conferencia                         |
            +---------------------------------------------------------------------------------------------+\n| 1. Equipamientos:                           Precios:                                        |
            |     > Mesas y sillas                        60$                                             |\n|     > Escenario.                            200$                                            |
            |     > Microfonos.                           120$                                            |\n|     > Proyector y pantalla                  65$                                             |
            |     > Sistema de sonido.                    150$                                            |\n|     > Podio.                                140$                                            |
            |     > Pizarra y rotafolios.                 80$                                             |\n|     > Iluminación.                          125$                                            |
            |                                                                                             |\n| 2. Servicios:                                                                               |
            |     > Registro de asistentes.               100$                                            |\n|     > Traducción simultanea.                250$                                            |
            |     > Transmisión en vivo o grabacion.      175$                                            |\n|     > Café o coffe break.                   60$                                             |
            |     > Personal técnico.                     250$                                            |\n|     > Material                              120$                                            |
            |     > Wi-Fi                                 40$                                             |\n|                                                                                             |
            | 3. Para salir.                                                                              |\n+---------------------------------------------------------------------------------------------+
            """);
        // System.out.print("\uD83D\uDCCD Decisión (1 - 3): ");
        // sc.nextLine();
        datos_equipamiento = equipamiento_conferencial(sc, resumen_datos);
        //System.out.println(Arrays.deepToString(datos_equipamiento));
        datos_servicio = servicio_conferencial(sc, resumen_datos);
        //System.out.println(Arrays.deepToString(datos_servicio));
        Union_General(sc, resumen_datos, datos_equipamiento, datos_servicio);
    }
    // ->
    public static Object[] equipamiento_conferencial(Scanner sc, Object[] resumen_datos){
        Object[] datos_equipamiento = new Object[]{null};
        int diasUsuarios = (int)resumen_datos[4]; //Convertor
        double[] P_equipamiento = new double[]{
                60,
                200,
                120,
                65,
                150,
                140,
                80,
                125}, cantidad_f = new double[8];;
        String[] equipamiento_text = new String[]{
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
        int[] cantidad = new int[8];
        try{
            for(int i = 0; i < (equipamiento_text.length - 1); i++){
                System.out.print("⭐ Cantidad de " + equipamiento_text[i] + ": ");
                cantidad[i] = sc.nextInt();
                cantidad_f[i] = cantidad[i] * P_equipamiento[i] * diasUsuarios;
                //System.out.println(equipamiento_text[i]+":"+cantidad_f[i]);
            }
            double total = Arrays.stream(cantidad_f).sum();
            System.out.println(); // Apariencia
            // System.out.println(total);
            datos_equipamiento = new Object[]{equipamiento_text, cantidad, P_equipamiento, cantidad_f, total};
            return datos_equipamiento;
        } catch (InputMismatchException e){
            System.out.println();
            System.out.println("\u274C Error: Solo números enteros.");
            sc.nextLine();
        }
        return datos_equipamiento;
    }
    // ->
    public static Object[] servicio_conferencial(Scanner sc, Object[] resumen_datos){
        Object[] datos_servicio = new Object[]{null};
        int diasUsuario = (int)resumen_datos[4];
        double[] servicios = new double[]{
                100,
                250,
                175,
                60,
                250,
                120,
                40}, cantidad_f = new double[7];
        int[] cantidad = new int[7];
        String[] servicios_text = new String[]{
                "Registro de Asistentes",
                "Traducción",
                "Transmisión o grabación",
                "Café o coffee bar",
                "Personal",
                "Material",
                "Wi-fi",
                "Total:"};
        try{
            for(int i = 0; i < (servicios_text.length - 1); i++){
                System.out.print("⭐ Cantidad de " + servicios_text[i] + ": ");
                cantidad[i] = sc.nextInt();
                cantidad_f[i] = cantidad[i] * servicios[i] * diasUsuario;
                //System.out.println(servicios_text[i]+":"+cantidad_f[i]);
            }
            double total=Arrays.stream(cantidad_f).sum();
            //System.out.println(); // Apariencia
            //System.out.println(total);
            datos_servicio = new Object[]{servicios_text, cantidad, servicios, cantidad_f, total};
            return datos_servicio;
        }catch(InputMismatchException w){
            System.out.println();
            System.out.println("\u274C Error: Solo números enteros.");
            sc.nextLine();
        }
        return datos_servicio;
    }
    // ->
    /*                                                           2. Parte del teatro                                                                                                */
    public static void montaje_teatro(Scanner sc,Object[]resumen_datos){
        Object[] datos_equipamiento = null, datos_servicio = null;
        System.out.print("""
            +---------------------------------------------------------------------------------------------+\n|                           Bienvenido/a a la renta del teatro                                |
            +---------------------------------------------------------------------------------------------+\n| 1. Equipamientos:                           Precios:                                        |
            |     > Escenarios con telón                  200$                                            |\n|     > Butacas fijas o móviles               120$                                            |
            |     > Iluminaciónes teatral                  70$                                            |\n|     > Sistemas de sonido envolvente         135$                                            |
            |     > Consolas de audio/luces               150$                                            |\n|     > Camerinos o vestidores                240$                                            |
            |     > Decoración y escenografía             300$                                            |
            |                                                                                             |\n| 2. Servicios:                                                                               |
            |     > Vendedores de boletos                  80$                                            |\n|     > Personal de taquilla y acomodadores.  350$                                            |
            |     > Seguridad y control de acceso         405$                                            |\n|     > Servicios de cafetería o snacks        90$                                            |
            |     > Publicidad y promoción                250$                                            |\n|     > Servicios de limpieza                 140$                                            |
            |     > Asistencia técnica en luces/sonido    190$                                            |\n|                                                                                             |
            | 3. Para salir.                                                                              |\n+---------------------------------------------------------------------------------------------+
            """);
        //System.out.print("\uD83D\uDCCD Decisión (1 - 3): ");
        // sc.nextLine();
        datos_equipamiento = equipamiento_teatro(sc, resumen_datos);
        datos_servicio = servicios_teatro(sc, resumen_datos);
        Union_General(sc, resumen_datos, datos_equipamiento, datos_servicio);
    }
    // ->
    public static Object[] equipamiento_teatro(Scanner sc, Object[] resumen_datos){
        Object[] datos_equipamiento = new Object[]{null};
        int diasUsuario = (int)resumen_datos[4];
        double[] equipamiento_precios = new double[]{
                200,
                120,
                70,
                135,
                150,
                240,
                300}, precio_f = new double[7];
        int[] cantidad = new int[7];
        String[] equipamiento_text = new String[]{
                "Escenarios",
                "Butacas",
                "Iluminaciónes",
                "Sistemas de sonido",
                "Consolas",
                "Camerinos",
                "Decoraciónes",
                "Total:"};
        try{
            for(int i = 0; i < (equipamiento_text.length - 1); i++){
                System.out.print("⭐ Cantidad de " + equipamiento_text[i] + ": ");
                cantidad[i] = sc.nextInt();
                sc.nextLine();
                precio_f[i] = cantidad[i] * equipamiento_precios[i] * diasUsuario;
                // System.out.println(precio_f[i]);
            }
            double total = Arrays.stream(precio_f).sum();
            System.out.println(); // Apariencia
            // System.out.println(total); // Lo mostrará en la información
            datos_equipamiento = new Object[]{equipamiento_text, cantidad, equipamiento_precios, precio_f, total};
            return datos_equipamiento;
        }catch(InputMismatchException a){
            System.out.println();
            System.out.println("\u274C Error: Solo números enteros.");
            sc.nextLine();
        }
        return datos_equipamiento;
    }
    public static Object[] servicios_teatro(Scanner sc, Object[]resumen_datos){
        Object[] datos_servicio = new Object[]{null};
        int diasUsuario = (int)resumen_datos[4];
        double[] servicio_precios = new double[]{
                80,
                350,
                405,
                90,
                250,
                140,
                190}, precio_f = new double[7];
        int[] cantidad = new int[7];
        String[] servico_texto = new String[]{
                "Vendedores",
                "Personal",
                "Seguridad",
                "Servicios de comida",
                "Publicidad",
                "Servicios de limpieza",
                "Técnicos",
                "Total:"};

        try{
            for(int i = 0; i< (servico_texto.length - 1); i++){
                System.out.print("⭐ Cantidad de " + servico_texto[i] + ": ");
                cantidad[i] = sc.nextInt();
                sc.nextLine();
                precio_f[i] = cantidad[i] * servicio_precios[i] * diasUsuario;
                // System.out.println(precio_f[i]);
            }
            double total = Arrays.stream(precio_f).sum();
            // System.out.println(); // Apariencia
            // System.out.println(total);
            datos_servicio = new Object[]{servico_texto, cantidad, servicio_precios, precio_f, total};
            return datos_servicio;
        }catch(InputMismatchException a){
            System.out.println();
            System.out.println("\u274C Error: Solo números enteros.");
            sc.nextLine();
        }
        return datos_servicio;
    }
    // ->
    /*                                          ISAAC                                          */
    // EN ESTA FUNCION LLAMO A LAS DEMAS FUNCIONES Y LES ASIGNO VARIABLES.
    public static void eventoRecepcion(Scanner sc, Object[] resumen_datos) {
        int diasUsuario =(int)resumen_datos[4];//Casting good Isaac8)
        Object[] resumen_equipamiento = equipamientoRecepcion(sc, resumen_datos);
        Object[] resumen_servicios = serviciosRecepcion(sc, resumen_datos);
        Union_General(sc, resumen_datos, resumen_equipamiento, resumen_servicios);

    }
    // ->
    // ARRAY PARA NOMBRES DEL EQUIPAMIENTO
    public static Object[] equipamientoRecepcion(Scanner sc,Object[]resumen_datos) {
        int dias=(int)resumen_datos[4];
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
        String[] nombres = new String[] {
                "Mesas altas tipo cóctel",
                "Barra de bebidas",
                "Sistema de sonido ambiental",
                "Área de bienvenida",
                "Iluminación decorativa",
                "Decoración floral",
                "Total:"
        };
        //ARRAYS DE PRECIOS DEL EQUIPAMIENTO
        double[] precios = new double[]{
                300,
                800,
                400,
                250,
                500,
                600};
        double[] precioTotal = new double[precios.length];
        // SI EL EVENTO ES EMPRESARAL EL FOR HACE UN AUMENTO DEL 200% A CADA COSTO
        if ((int)resumen_datos[5] == 2) {
            for (int i = 0; i < precios.length; i++) {
                precios[i] = (int)(precios[i] * 2);
            }
        }
        // HACE EL CALCULO DE LOS COSTOS POR LOS DIAS RENTADOS
        // System.out.println(" Equipamiento para Recepción:"); // -> Opino borrarlo
        double subtotal = 0;
        int [] cantidades = new int [precios.length];
        for (int i = 0; i < precios.length; i++) {
            System.out.print("⭐ Cantidad de " + nombres[i] + ": ");
            cantidades[i]= sc.nextInt();
            precioTotal[i] = precios[i] * cantidades [i]* dias;
            subtotal += precioTotal[i];
            //System.out.println(" - " + nombres[i] + ": $" + precioTotal[i]); // -> Opino borrarlo
        }
        Object[] resumen_equipo = new Object[]{nombres, cantidades, precios, precioTotal, subtotal};
        return resumen_equipo;
    }
    // ->
    // ARRAYS QUE GUARDA LOS NOMBRES DE LOS SERVICIOS DE RECEPCION
    public static Object[] serviciosRecepcion(Scanner sc, Object[] resumen_datos) {
        System.out.println(); // Apariencia
        int dias = (int)resumen_datos[4];
        String[] nombres = new String[]{
                "Servicio de catering",
                "DJ o música en vivo",
                "Fotografía y video",
                "Guardarropa",
                "Valet parking",
                "Seguridad",
                "Meseros y anfitriones",
                "Total:"
        };
        // ESTE ARRAY GUARDA LOS PRECIOS DE CADA SERVICIO
        double[] precios = new double[]{
                1200,
                1500,
                1000,
                300,
                400,
                350,
                500};
        double[] precioTotal = new double[precios.length];
        // SI EL EVENTO ES EMPRESARIAL EL FOR AUMENTA EL COSTO DE LOS SERVICIOS
        if ((int)resumen_datos[5] == 2) {
            for (int i = 0; i < precios.length; i++) {
                precios[i] = (int)(precios[i] * 2);
            }
        }
        // ARRAYS SUMA DE COSTOS POR LOS DIAS.
        // System.out.println(" Servicios para Recepción:"); // -> Opino borrar
        double subtotal = 0;
        int [] cantidades = new int [precios.length];
        // System.out.println("Cuanto deseas Agregar?"); // -> Opino borrar
        for (int i = 0; i < precios.length; i++) {
            System.out.print("⭐ Cantidad de " + nombres[i] + ": ");
            cantidades[i]= sc.nextInt();
            precioTotal [i]= precios[i] * cantidades [i] * dias;
            subtotal += precioTotal[i];
            // System.out.println(" - " + nombres[i] + ": $" + precioTotal[i]); // -> Opino borrar
        }
        Object[] resumen_servicio = new Object[]{nombres, cantidades, precios, precioTotal, subtotal};
        return resumen_servicio;
    }
    // ->
    // FUNCION DE BANQUETE
    public static void eventoBanquete(Scanner sc, Object[]resumen_datos) {
        int diasUsuario = (int)resumen_datos[4];
        Object[] resumen_equipamiento = equipamientoBanquete(sc, resumen_datos);
        Object[] resumen_servicios = serviciosBanquete(sc, resumen_datos);

        Union_General(sc, resumen_datos, resumen_equipamiento, resumen_servicios);
    }
    // ->
    //ARRAYS PARA GUARDAR LOS NOMBRE DE LOS EQUIPAMENTOS DE BANQUETE
    public static Object[] equipamientoBanquete(Scanner sc, Object[]resumen_datos) {
        int dias = (int)resumen_datos[4];
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
        String[] nombres = new String[] {
                "Mesas redondas o rectangulares",
                "Sillas con fundas",
                "Mantelería y vajilla formal",
                "Centros de mesa",
                "Iluminación ambiental",
                "Tarima para discursos",
                "Total:"
        };
        double[] precios = new double[] {
                700,
                400,
                650,
                300,
                500,
                350}, precioTotal = new double[precios.length];
        // SI ES EMPRESARIAL LE AUMENTA 20% AL COSTO
        if ((int)resumen_datos[5] == 2) {
            for (int i = 0; i < precios.length; i++) {
                precios[i] = (int)(precios[i] * 2);
            }
        }
        // RECORRE CADA UNO PARA SUMARLOS Y GUARDAR EL PRECIO EN SUBTOTAL
        double subtotal = 0;
        int [] cantidades = new int[precios.length];
        for (int i = 0; i < precios.length; i++) {
            System.out.print("⭐ Cantidad de " + nombres[i] + ": ");
            cantidades [i] = sc.nextInt();
            precioTotal[i] = precios[i] * cantidades [i] * dias;
            subtotal += precioTotal[i];
        }
        // System.out.println("Subtotal: $" + subtotal);
        Object[]resumen_equipo=new Object[]{nombres,cantidades,precios,precioTotal,subtotal};

        return resumen_equipo;
    }
    // ->
    // SERVICIOS DE BANQUETE, ARRAY CON  NOMBRES.
    public static Object[] serviciosBanquete(Scanner sc, Object[]resumen_datos) {
        int dias = (int)resumen_datos[4];
        String[] nombres = new String[] {
                "Menú completo",
                "Cocineros y meseros",
                "Música en vivo o DJ",
                "Pastel formal",
                "Fotografía profesional",
                "Brindis y discursos",
                "Estación de bebidas",
                "Total:" };
        double[] precios = new double[] {
                2500,
                1800,
                1500,
                500,
                1000,
                600,
                400}, precioTotal = new double[precios.length];
        // AUMENTA 20% AL SER EMPRESARIAL
        if ((int)resumen_datos[5] == 2) {
            for (int i = 0; i < precios.length; i++) {
                precios[i] = (int)(precios[i] * 2);
            }
        }
        //SUMA LOS PRECIOS MULTIPLICADOS POR LOS DIAS
        // System.out.println(" Servicios para Banquete:"); // -> Opino borrar
        double subtotal = 0;
        int [] cantidades = new int [precios.length];
        for (int i = 0; i < precios.length; i++) {
            System.out.print("⭐ Cantidad de "  + nombres [i] + ": ");
            cantidades [i]= sc.nextInt();
            precioTotal[i] = precios[i] * cantidades[i] * dias;
            subtotal += precioTotal[i];
        }
        // System.out.println("Subtotal: $" + subtotal); // -> Opino borrar
        Object[] resumen_servicios = new Object[]{nombres, cantidades, precios, precioTotal, subtotal};
        return resumen_servicios;
    }
    // ->
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*                                          Juan                                          */
    /* #5 -> Salón */
    public static void montajeSalon(
            Scanner sc,
            Object[]resumen_datos
    ){

        System.out.println(); // Salto de línea para mejor apariencia
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
        equipamientoServiciosSalon(sc, resumen_datos); // Llama a la función equipamiento y manda los datos necesarios
        return;
    }
    public static void equipamientoServiciosSalon(
            Scanner sc,
            Object[]resumen_datos
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
                System.out.print("⭐ Cantidad de "  + equipamiento[i] + ": ");
                cantidadEquipamiento[i] = sc.nextInt();
                totalEquipamiento[i] = (cantidadEquipamiento[i] * (int) resumen_datos[4] * preciosEquipamiento[i]);
                sumatotalEquipamiento += totalEquipamiento[i];
            }
            System.out.println(); // Salto de línea para preguntar sobre el personal
            for (int i = 0; i < servicio.length - 1; i++) {
                System.out.print("⭐ Cantidad de "  + servicio[i] + ": ");
                cantidadServicio[i] = sc.nextInt();
                totalServicio[i] = (cantidadServicio[i] * (int) resumen_datos[4] * preciosServicio[i]);
                sumatotalServicio += totalServicio[i];
            }
            Object[] resumen_equipo = new Object[]{equipamiento, cantidadEquipamiento, preciosEquipamiento, totalEquipamiento, sumatotalEquipamiento};
            Object[] resumen_servicios = new Object[]{servicio, cantidadServicio, preciosServicio, totalServicio, sumatotalServicio};
            Union_General(sc, resumen_datos, resumen_equipo, resumen_servicios);

        } catch (InputMismatchException e) {
            System.out.println("\n\u274C Error: No se permiten letras ni caracteres especiales.");
            sc.nextLine();
        }
    }
    /* #6 */
    public static void montajeU(
            Scanner sc,
            Object[]resumen_datos
    ){
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

        equipamientoServiciosU(sc,resumen_datos); // Llama a la funcion equipamiento y manda los datos necesarios
        return;
    }
    // ->
    public static void equipamientoServiciosU(
            Scanner sc,
            Object[]resumen_datos
    ){
        double[] totalEquipamientoU = new double[7]; // EquipamientoU -1 (Se resta -1 para poder acomodar el Total:)
        double sumatotalEquipamientoU = 0;

        double[] totalServicioU = new double[7];    // ServicioU - 1 (Se resta -1 para poder acomodar el Total:)
        double sumatotalServicioU = 0;

        String[] equipamientoU = new String[]{
                "Mesas en forma de U",      // 400
                "Sillas",                   // 100
                "Pantallas",                // 600
                "Proyectores",              // 600
                "Micrófonos",               // 300
                "Pizarras o rotafolios",    // 200
                "Paquetes de oficina",      // 150
                "Total:",
        };

        double[] preciosEquipamientoU = {
                400,    // Mesas en forma de U
                100,    // Sillas
                600,    // Pantallas
                600,    // Proyectores
                300,    // Micrófonos
                200,    // Pizarras
                150,    // Paquetes de oficina
        };

        String[] servicioU = new String[]{
                "Paquetes Coffee Break",     // 350
                "Repetidores Wi-Fi",        // 100
                "Personal Soporte Técnico", // 500
                "Moderadores",              // 800
                "Traductores",              // 1200
                "Personal de Apoyo",        // 400
                "Paquetes de Impresión",    // 250
                "Total:"
        };

        double[] preciosServicioU = {
                350,
                100,
                500,
                800,
                1200,
                400,
                250,
        };

        int[] cantidadEquipamientoU = new int[7];    // Cantidad de equipamiento -> Ingresado por el usuario
        int[] cantidadServicioU = new int[7];        // Cantidad de personal     -> Ingresado por el usuario

        try {
            for (int i = 0; i < equipamientoU.length - 1; i++) {
                System.out.print("⭐ Cantidad de "  + equipamientoU[i] + ": ");
                cantidadEquipamientoU[i] = sc.nextInt();
                totalEquipamientoU[i] = (cantidadEquipamientoU[i] * (int) resumen_datos[4] * preciosEquipamientoU[i]);
                sumatotalEquipamientoU += totalEquipamientoU[i];
            }
            System.out.println(); // Salto de línea para preguntar sobre el personal
            for (int i = 0; i < servicioU.length - 1; i++) {
                System.out.print("⭐ Cantidad de "  + servicioU[i] + ": ");
                cantidadServicioU[i] = sc.nextInt();
                totalServicioU[i] = (cantidadServicioU[i] * (int) resumen_datos[4] * preciosServicioU[i]);
                sumatotalServicioU += totalServicioU[i];
            }
            Object[]resumen_equipo = new Object[]{equipamientoU, cantidadEquipamientoU, preciosEquipamientoU, totalEquipamientoU, sumatotalEquipamientoU};
            Object[]resumen_servicio=new Object[]{servicioU, cantidadServicioU, preciosServicioU, totalServicioU, sumatotalServicioU};
            Union_General(sc, resumen_datos, resumen_equipo, resumen_servicio);
        } catch (InputMismatchException e) {
            System.out.println("\n\u274C Error: No se permiten letras ni caracteres especiales.");
            sc.nextLine();
        }
    }
    // ->
    /*                                                                       Parte final en general                                                    */
    public static void Union_General(Scanner sc,Object[]resumen_datos,Object[] datos_equipamiento, Object[]datos_servicio){  //Union de datos para tranfromarlo en a terminos de juan
            /*
            resumen datos= [0]nombreUsuario,[1]telefonoUsuario,[2]correoUsuario,[3]personasUsuario,
            [4]diasUsuario,[5]tipo_Evento

            String[] equipamientoStrings=(String[])datos_equipamiento[0], servicioStrings=(String[])datos_servicio[0];
            int [] cantidad_equipamiento=(int[])datos_equipamiento[1], cantidadServicio=(int[])datos_servicio[1];
            double[] preciosEquipamiento=(double[])datos_equipamiento[2],totalEquipamiento=(double[])datos_equipamiento[3],
            preciosServicio=(double[])datos_servicio[2], totalServicio=(double[])datos_servicio[3];

            double sumatotalEquipamiento=(double)datos_equipamiento[4], sumatotalServicio=(double) datos_servicio[4];

            System.out.println(sumatotalServicio);
            /*Object[] suma=new Object[a.length+b.length];
            System.arraycopy(a, 0, suma, 0, a.length);              Si quisira unirlos sumarlos
            System.arraycopy(b, 0, suma, a.length, b.length);
            System.out.println(Arrays.deepToString(suma));
            decFinal(sc, resumen_datos, equipamientoStrings, cantidad_equipamiento, preciosEquipamiento, totalEquipamiento,
            sumatotalEquipamiento, servicioStrings, cantidadServicio, preciosServicio, totalServicio, sumatotalServicio);*/

        decFinal(sc, resumen_datos, datos_equipamiento, datos_servicio);

    }
    // ->
    public static void decFinal(Scanner sc,Object[]resumen_datos,Object[] datos_equipamiento, Object[]datos_servicio){
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
    // ->
    public static void pago(Scanner sc, Object[]resumen_datos, Object[]datos_equipamiento, Object[]datos_servicio){
        double pagoRealizado;
        double sumatotalEquipamiento=(double)datos_equipamiento[4],sumatotalServicio=(double)datos_servicio[4];
        do {
            try {
                System.out.println(); // Salto para mejor apariencia
                // Evento social
                if((int)resumen_datos[5] == 1){
                    // Tamaño Pequeño, Tipo Social -> (sumatotalEquipamiento + sumatotalServicio) * 1 (ó dejar asi sin modificar)
                    if((int) resumen_datos[3] >= 1 && (int) resumen_datos[3] <= 50){
                        double montoPagar = (sumatotalEquipamiento + sumatotalServicio);
                        System.out.printf("""
                        +----------------------------+
                        | Monto a pagar: $%-10s |
                        +----------------------------+
                        Ingrese el monto total: $""",
                                montoPagar);
                        pagoRealizado = sc.nextDouble();

                        if(pagoRealizado == montoPagar){
                            System.out.println("\n💵 Muchas gracias por su compra, vuelva pronto!\n");
                            return;
                        }else if(pagoRealizado > montoPagar){
                            System.out.println("\nSu cambio es de: " + (pagoRealizado - montoPagar));
                            System.out.println("💵 Muchas gracias por su compra, vuelva pronto!\n");
                            return;
                        }else if(pagoRealizado < montoPagar){
                            System.out.println("\n💥 Dinero insuficiente, le hace falta: $" + (montoPagar - pagoRealizado));
                            decFinal(sc,resumen_datos,datos_equipamiento,datos_servicio);
                            return;

                        }else{
                            sc.next(); // Limpia el buffer
                        }
                    }

                    // Tamaño Mediano, Tipo Social -> (sumatotalEquipamiento + sumatotalServicio) * 1.5
                    else if((int) resumen_datos[3] >= 51 && (int) resumen_datos[3] <= 100){
                        double montoPagar = (sumatotalEquipamiento + sumatotalServicio) * 1.5;
                        System.out.printf("""
                        +----------------------------+
                        | Monto a pagar: $%-10s |
                        +----------------------------+
                        Ingrese el monto: $""",
                                montoPagar);
                        pagoRealizado = sc.nextDouble();

                        if(pagoRealizado == montoPagar){
                            System.out.println("\nMuchas gracias por su compra, vuelva pronto!");
                            return;
                        }else if(pagoRealizado > montoPagar){
                            System.out.println("\nSu cambio es de: " + (pagoRealizado - montoPagar));
                            System.out.println("Muchas gracias por su compra, vuelva pronto!");
                            return;
                        }else if(pagoRealizado < montoPagar){
                            System.out.println("\n💥 Dinero insuficiente, le hace falta: " + (montoPagar - pagoRealizado));
                            decFinal(sc,resumen_datos,datos_equipamiento,datos_servicio);
                            return;

                        }else{
                            sc.next(); // Limpia el buffer
                        }
                    }

                    // Tamaño Grande, Tipo Social -> (sumatotalEquipamiento + sumatotalServicio) * 2
                    else if((int) resumen_datos[3] >= 101){
                        double montoPagar = (sumatotalEquipamiento + sumatotalServicio) * 2;
                        System.out.printf("""
                        +----------------------------+
                        | Monto a pagar: $%-10s |
                        +----------------------------+
                        Ingrese el monto: $""",
                                montoPagar);
                        pagoRealizado = sc.nextDouble();

                        if(pagoRealizado == montoPagar){
                            System.out.println("\nMuchas gracias por su compra, vuelva pronto!");
                            return;
                        }else if(pagoRealizado > montoPagar){
                            System.out.println("\nSu cambio es de: " + (pagoRealizado - montoPagar));
                            System.out.println("Muchas gracias por su compra, vuelva pronto!");
                            return;
                        }else if(pagoRealizado < montoPagar){
                            System.out.println("\n💥 Dinero insuficiente, le hace falta: " + (montoPagar - pagoRealizado));
                            decFinal(sc,resumen_datos,datos_equipamiento,datos_servicio);
                            return;

                        }else{
                            sc.next();
                        }
                    }
                }

                if((int)resumen_datos[5] == 2){
                    // Tamaño Pequeño, Tipo Empresarial -> (sumatotalEquipamiento + sumatotalServicio) * 1 (ó dejar asi sin modificar)
                    if((int) resumen_datos[3] >= 1 && (int) resumen_datos[3] <= 50){
                        double montoPagar = ((sumatotalEquipamiento + sumatotalServicio) * 2);
                        System.out.printf("""
                        +----------------------------+
                        | Monto a pagar: $%-10s |
                        +----------------------------+
                        Ingrese el monto total: $""",
                                montoPagar);
                        pagoRealizado = sc.nextDouble();

                        if(pagoRealizado == montoPagar){
                            System.out.println("\n💵 Muchas gracias por su compra, vuelva pronto!\n");
                            return;
                        }else if(pagoRealizado > montoPagar){
                            System.out.println("\nSu cambio es de: " + (pagoRealizado - montoPagar));
                            System.out.println("💵 Muchas gracias por su compra, vuelva pronto!\n");
                            return;
                        }else if(pagoRealizado < montoPagar){
                            System.out.println("\n💥 Dinero insuficiente, le hace falta: $" + (montoPagar - pagoRealizado));
                            decFinal(sc,resumen_datos,datos_equipamiento,datos_servicio);
                            return;

                        }else{
                            sc.next(); // Limpia el buffer
                        }
                    }

                    // Tamaño Mediano, Tipo Empresarial -> (sumatotalEquipamiento + sumatotalServicio) * 2.5
                    else if((int) resumen_datos[3] >= 51 && (int) resumen_datos[3] <= 100){
                        double montoPagar = ((sumatotalEquipamiento + sumatotalServicio) * 2.5);
                        System.out.printf("""
                        +----------------------------+
                        | Monto a pagar: $%-10s |
                        +----------------------------+
                        Ingrese el monto: $""",
                                montoPagar);
                        pagoRealizado = sc.nextDouble();

                        if(pagoRealizado == montoPagar){
                            System.out.println("\nMuchas gracias por su compra, vuelva pronto!");
                            return;
                        }else if(pagoRealizado > montoPagar){
                            System.out.println("\nSu cambio es de: " + (pagoRealizado - montoPagar));
                            System.out.println("Muchas gracias por su compra, vuelva pronto!");
                            return;
                        }else if(pagoRealizado < montoPagar){
                            System.out.println("\n💥 Dinero insuficiente, le hace falta: " + (montoPagar - pagoRealizado));
                            decFinal(sc,resumen_datos,datos_equipamiento,datos_servicio);
                            return;

                        }else{
                            sc.next(); // Limpia el buffer
                        }
                    }

                    // Tamaño Grande, Tipo Empresarial -> (sumatotalEquipamiento + sumatotalServicio) * 2
                    else if((int) resumen_datos[3] >= 101){
                        double montoPagar = ((sumatotalEquipamiento + sumatotalServicio) * 3);
                        System.out.printf("""
                        +----------------------------+
                        | Monto a pagar: $%-10s |
                        +----------------------------+
                        Ingrese el monto: $""",
                                montoPagar);
                        pagoRealizado = sc.nextDouble();

                        if(pagoRealizado == montoPagar){
                            System.out.println("\nMuchas gracias por su compra, vuelva pronto!");
                            break;
                        }else if(pagoRealizado > montoPagar){
                            System.out.println("\nSu cambio es de: " + (pagoRealizado - montoPagar));
                            System.out.println("Muchas gracias por su compra, vuelva pronto!");
                            break;
                        }else if(pagoRealizado < montoPagar){
                            System.out.println("\n💥 Dinero insuficiente, le hace falta: " + (montoPagar - pagoRealizado));
                            decFinal(sc,resumen_datos,datos_equipamiento,datos_servicio);
                            return;

                        }else{
                            sc.next(); // Limpia el buffer
                        }
                    }
                }


            } catch (InputMismatchException z) {
                System.out.println("\n❌ Error: No se permiten letras ni caracteres especiales");
                sc.next(); // Limpia el buffer
            }
        } while (true);



    }
    // ->
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

        // Evento Social
        if((int)resumen_datos[5] == 1) {
            // Tamaño Pequeño, Tipo Social -> Todo x 1 (ó sin multiplicar)
            if ((int) resumen_datos[3] >= 1 && (int) resumen_datos[3] <= 50) {
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
                        "Social",          // Tipo de evento
                        resumen_datos[6],           // Evento contratado
                        "Pequeño"          // Tamaño del evento
                );
                System.out.printf("| %-27s | %-5s | %-10s | %-65s |", "Equipamiento", "Cantidad", "Precio c/u", "Cantidad x Precio c/u x (" + resumen_datos[4] + ") día(s) x Tamaño evento x Tipo evento");
                for (int i = 0; i < equipamiento.length - 1; i++) {
                    System.out.printf("\n| %-27s | %-8s | $%-9s | $%-64s |", equipamiento[i], cantidadEquipamiento[i], preciosEquipamiento[i], totalEquipamiento[i]);
                }
                System.out.println();
                System.out.printf("| %-27s | %-8s | %-10s | $%-64s |\n", equipamiento[equipamiento.length-1], "", "", sumatotalEquipamiento);
                ///* Fin equipamiento

                System.out.println("|                                                                                                                         |");

                ///* Muestra en pantalla: | Servicio | Cantidad | Precio c/u
                System.out.printf("| %-27s | %-5s | %-10s | %-65s |", "Servicio", "Cantidad", "Precio c/u", "Cantidad x Precio c/u x (" + resumen_datos[4] + ") día(s) x Tamaño evento x Tipo evento");
                for (int i = 0; i < servicio.length - 1; i++) {
                    System.out.printf("\n| %-27s | %-8s | $%-9s | $%-64s |", servicio[i], cantidadServicio[i], preciosServicio[i], totalServicio[i]);
                }
                System.out.println();
                System.out.printf("| %-27s | %-8s | %-10s | $%-64s |\n", servicio[servicio.length-1], "", "", sumatotalServicio);
                System.out.println("+-------------------------------------------------------------------------------------------------------------------------+");
                System.out.printf("| Total a pagar: $%-103s |%n", (sumatotalEquipamiento + sumatotalServicio));
                System.out.println("+-------------------------------------------------------------------------------------------------------------------------+");
                /// * Fin Servicio
                sc.nextLine(); // Limpia el buffer
                System.out.print("\uD83D\uDC46 Presiona enter para volver: ");
                sc.nextLine(); // Limpia el buffer
            }
            // Tamaño Mediano, Tipo Social -> Todo x 1.5
            else if ((int) resumen_datos[3] >= 51 && (int) resumen_datos[3] <= 100) {
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
                        "Social",          // Tipo de evento
                        resumen_datos[6],           // Evento contratado
                        "Mediano"          // Tamaño del evento
                );
                System.out.printf("| %-27s | %-5s | %-10s | %-65s |", "Equipamiento", "Cantidad", "Precio c/u", "Cantidad x Precio c/u x (" + resumen_datos[4] + ") día(s) x Tamaño evento x Tipo evento");
                for (int i = 0; i < equipamiento.length - 1; i++) {
                    System.out.printf("\n| %-27s | %-8s | $%-9s | $%-64s |", equipamiento[i], cantidadEquipamiento[i], preciosEquipamiento[i], (totalEquipamiento[i] * 1.5));
                }
                System.out.println();
                System.out.printf("| %-27s | %-8s | %-10s | $%-64s |\n", equipamiento[equipamiento.length-1], "", "", (sumatotalEquipamiento * 1.5));
                ///* Fin equipamiento

                System.out.println("|                                                                                                                         |");

                ///* Muestra en pantalla: | Servicio | Cantidad | Precio c/u
                System.out.printf("| %-27s | %-5s | %-10s | %-65s |", "Servicio", "Cantidad", "Precio c/u", "Cantidad x Precio c/u x (" + resumen_datos[4] + ") día(s) x Tamaño evento x Tipo evento");
                for (int i = 0; i < servicio.length - 1; i++) {
                    System.out.printf("\n| %-27s | %-8s | $%-9s | $%-64s |", servicio[i], cantidadServicio[i], preciosServicio[i], (totalServicio[i] * 1.5));
                }
                System.out.println();
                System.out.printf("| %-27s | %-8s | %-10s | $%-64s |\n", servicio[servicio.length-1], "", "", (sumatotalServicio * 1.5));
                System.out.println("+-------------------------------------------------------------------------------------------------------------------------+");
                System.out.printf("| Total a pagar: $%-103s |%n", (sumatotalEquipamiento + sumatotalServicio) * 1.5);
                System.out.println("+-------------------------------------------------------------------------------------------------------------------------+");
                /// * Fin Servicio
                sc.nextLine(); // Limpia el buffer
                System.out.print("\uD83D\uDC46 Presiona enter para volver: ");
                sc.nextLine(); // Limpia el buffer
            }
            // Tamaño Grande, Tipo Social -> todo x 2
            else if ((int) resumen_datos[3] >= 101) {
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
                        "Social",          // Tipo de evento
                        resumen_datos[6],           // Evento contratado
                        "Grande "          // Tamaño del evento
                );
                System.out.printf("| %-27s | %-5s | %-10s | %-65s |", "Equipamiento", "Cantidad", "Precio c/u", "Cantidad x Precio c/u x (" + resumen_datos[4] + ") día(s) x Tamaño evento x Tipo evento");
                for (int i = 0; i < equipamiento.length - 1; i++) {
                    System.out.printf("\n| %-27s | %-8s | $%-9s | $%-64s |", equipamiento[i], cantidadEquipamiento[i], preciosEquipamiento[i], (totalEquipamiento[i] * 2));
                }
                System.out.println();
                System.out.printf("| %-27s | %-8s | %-10s | $%-64s |\n", equipamiento[equipamiento.length-1], "", "", (sumatotalEquipamiento * 2));
                ///* Fin equipamiento

                System.out.println("|                                                                                                                         |");

                ///* Muestra en pantalla: | Servicio | Cantidad | Precio c/u
                System.out.printf("| %-27s | %-5s | %-10s | %-65s |", "Servicio", "Cantidad", "Precio c/u", "Cantidad x Precio c/u x (" + resumen_datos[4] + ") día(s) x Tamaño evento x Tipo evento");
                for (int i = 0; i < servicio.length - 1; i++) {
                    System.out.printf("\n| %-27s | %-8s | $%-9s | $%-64s |", servicio[i], cantidadServicio[i], preciosServicio[i], (totalServicio[i] * 2));
                }
                System.out.println();
                System.out.printf("| %-27s | %-8s | %-10s | $%-64s |\n", servicio[servicio.length-1], "", "", (sumatotalServicio * 2));
                System.out.println("+-------------------------------------------------------------------------------------------------------------------------+");
                System.out.printf("| Total a pagar: $%-103s |%n", ((sumatotalEquipamiento + sumatotalServicio) * 2));
                System.out.println("+-------------------------------------------------------------------------------------------------------------------------+");
                /// * Fin Servicio
                sc.nextLine(); // Limpia el buffer
                System.out.print("\uD83D\uDC46 Presiona enter para volver: ");
                sc.nextLine(); // Limpia el buffer
            }
        }
        // Evento Empresarial
        else if((int)resumen_datos[5] == 2) {
            // Tamaño Pequeño, Tipo Empresarial -> Todo x 2
            if ((int) resumen_datos[3] >= 1 && (int) resumen_datos[3] <= 50) {
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
                        "Empresarial",          // Tipo de evento
                        resumen_datos[6],           // Evento contratado
                        "Pequeño"          // Tamaño del evento
                );
                System.out.printf("| %-27s | %-5s | %-10s | %-65s |", "Equipamiento", "Cantidad", "Precio c/u", "Cantidad x Precio c/u x (" + resumen_datos[4] + ") día(s) x Tamaño evento x Tipo evento");
                for (int i = 0; i < equipamiento.length - 1; i++) {
                    System.out.printf("\n| %-27s | %-8s | $%-9s | $%-64s |", equipamiento[i], cantidadEquipamiento[i], preciosEquipamiento[i], (totalEquipamiento[i] * 2));
                }
                System.out.println();
                System.out.printf("| %-27s | %-8s | %-10s | $%-64s |\n", equipamiento[equipamiento.length-1], "", "", (sumatotalEquipamiento * 2));
                ///* Fin equipamiento

                System.out.println("|                                                                                                                         |");

                ///* Muestra en pantalla: | Servicio | Cantidad | Precio c/u
                System.out.printf("| %-27s | %-5s | %-10s | %-65s |", "Servicio", "Cantidad", "Precio c/u", "Cantidad x Precio c/u x (" + resumen_datos[4] + ") día(s) x Tamaño evento x Tipo evento");
                for (int i = 0; i < servicio.length - 1; i++) {
                    System.out.printf("\n| %-27s | %-8s | $%-9s | $%-64s |", servicio[i], cantidadServicio[i], preciosServicio[i], (totalServicio[i] * 2));
                }
                System.out.println();
                System.out.printf("| %-27s | %-8s | %-10s | $%-64s |\n", servicio[servicio.length-1], "", "", (sumatotalServicio * 2));
                System.out.println("+-------------------------------------------------------------------------------------------------------------------------+");
                System.out.printf("| Total a pagar: $%-103s |%n", (sumatotalEquipamiento + sumatotalServicio) * 2);
                System.out.println("+-------------------------------------------------------------------------------------------------------------------------+");
                /// * Fin Servicio
                sc.nextLine(); // Limpia el buffer
                System.out.print("\uD83D\uDC46 Presiona enter para volver: ");
                sc.nextLine(); // Limpia el buffer
            }

            // Tamaño Mediano, Tipo Empresarial -> Todo x 2.5
            else if ((int) resumen_datos[3] >= 51 && (int) resumen_datos[3] <= 100) {
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
                        "Empresarial",          // Tipo de evento
                        resumen_datos[6],           // Evento contratado
                        "Mediano"          // Tamaño del evento
                );
                System.out.printf("| %-27s | %-5s | %-10s | %-65s |", "Equipamiento", "Cantidad", "Precio c/u", "Cantidad x Precio c/u x (" + resumen_datos[4] + ") día(s) x Tamaño evento x Tipo evento");
                for (int i = 0; i < equipamiento.length - 1; i++) {
                    System.out.printf("\n| %-27s | %-8s | $%-9s | $%-64s |", equipamiento[i], cantidadEquipamiento[i], preciosEquipamiento[i], (totalEquipamiento[i] * 2.5));
                }
                System.out.println();
                System.out.printf("| %-27s | %-8s | %-10s | $%-64s |\n",equipamiento[equipamiento.length-1], "", "", (sumatotalEquipamiento * 2.5));
                ///* Fin equipamiento

                System.out.println("|                                                                                                                         |");

                ///* Muestra en pantalla: | Servicio | Cantidad | Precio c/u
                System.out.printf("| %-27s | %-5s | %-10s | %-65s |", "Servicio", "Cantidad", "Precio c/u", "Cantidad x Precio c/u x (" + resumen_datos[4] + ") día(s) x Tamaño evento x Tipo evento");
                for (int i = 0; i < servicio.length - 1; i++) {
                    System.out.printf("\n| %-27s | %-8s | $%-9s | $%-64s |", servicio[i], cantidadServicio[i], preciosServicio[i], (totalServicio[i] * 2.5));
                }
                System.out.println();
                System.out.printf("| %-27s | %-8s | %-10s | $%-64s |\n",servicio[servicio.length-1], "", "", (sumatotalServicio * 2.5));
                System.out.println("+-------------------------------------------------------------------------------------------------------------------------+");
                System.out.printf("| Total a pagar: $%-103s |%n", (sumatotalEquipamiento + sumatotalServicio) * 2.5);
                System.out.println("+-------------------------------------------------------------------------------------------------------------------------+");
                /// * Fin Servicio
                sc.nextLine(); // Limpia el buffer
                System.out.print("\uD83D\uDC46 Presiona enter para volver: ");
                sc.nextLine(); // Limpia el buffer
            }
            // Tamaño Grande, Tipo Empresarial -> Todo x 3
            else if ((int) resumen_datos[3] >= 101) {
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
                        "Social",          // Tipo de evento
                        resumen_datos[6],           // Evento contratado
                        "Mediano"          // Tamaño del evento
                );
                System.out.printf("| %-27s | %-5s | %-10s | %-65s |", "Equipamiento", "Cantidad", "Precio c/u", "Cantidad x Precio c/u x (" + resumen_datos[4] + ") día(s) x Tamaño evento x Tipo evento");
                for (int i = 0; i < equipamiento.length - 1; i++) {
                    System.out.printf("\n| %-27s | %-8s | $%-9s | $%-64s |", equipamiento[i], cantidadEquipamiento[i], preciosEquipamiento[i], (totalEquipamiento[i] * 3));
                }
                System.out.println();
                System.out.printf("| %-27s | %-8s | %-10s | $%-64s |\n",equipamiento[equipamiento.length-1], "", "", (sumatotalEquipamiento * 3));
                ///* Fin equipamiento

                System.out.println("|                                                                                                                         |");

                ///* Muestra en pantalla: | Servicio | Cantidad | Precio c/u
                System.out.printf("| %-27s | %-5s | %-10s | %-65s |", "Servicio", "Cantidad", "Precio c/u", "Cantidad x Precio c/u x (" + resumen_datos[4] + ") día(s) x Tamaño evento x Tipo evento");
                for (int i = 0; i < servicio.length - 1; i++) {
                    System.out.printf("\n| %-27s | %-8s | $%-9s | $%-64s |", servicio[i], cantidadServicio[i], preciosServicio[i], (totalServicio[i] * 3));
                }
                System.out.println();
                System.out.printf("| %-27s | %-8s | %-10s | $%-64s |\n",servicio[servicio.length-1], "", "", (sumatotalServicio * 3));
                System.out.println("+-------------------------------------------------------------------------------------------------------------------------+");
                System.out.printf("| Total a pagar: $%-103s |%n", (sumatotalEquipamiento + sumatotalServicio) * 3);
                System.out.println("+-------------------------------------------------------------------------------------------------------------------------+");
                /// * Fin Servicio
                sc.nextLine(); // Limpia el buffer
                System.out.print("\uD83D\uDC46 Presiona enter para volver: ");
                sc.nextLine(); // Limpia el buffer
            }
        }
        System.out.println(); // Salto de línea para mejor apariencia
    }
}
