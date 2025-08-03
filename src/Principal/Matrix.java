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
            long telefonoUsuario = sc.nextLong();
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
                Object[] resumen_datos=new Object[]{nombreUsuario,telefonoUsuario,correoUsuario,personasUsuario,diasUsuario};
                opciones(sc, resumen_datos);
                break;
            }
        } while (true);

    }

    public static void opciones(Scanner sc, Object[] resumen_datos){
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

                if(tipoEvento>=1 && tipoEvento<=2){
                    System.out.println();
                    eventoSocial(sc, resumen_datos, tipoEvento);
                    return;
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

    public static void eventoSocial(Scanner sc, Object[] resumen_datos, int tipo_Evento) {
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
                        montaje_conferencia(sc,resumen_datos,tipo_Evento );//Aplicar como boleano by: Jose
                        break;
                    case 2:
                        System.out.println("Iniciando configuración de teatro..");
                        montaje_teatro(sc,resumen_datos,tipo_Evento);
                        break;
                    case 3:
                        System.out.println("Iniciando configuración de recepción...");
                        eventoRecepcion(sc, resumen_datos,tipo_Evento); // ← NUEVA FUNCIÓN RECEPCIÓN
                        break;
                    case 4:
                        System.out.println("Iniciando configuración de banquete...");
                        eventoBanquete(sc, resumen_datos,tipo_Evento);
                        break;
                    case 5:
                        montajeSalon(sc, resumen_datos, tipo_Evento);
                        return;
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
    public static void montaje_conferencia(Scanner sc, Object[] resumen_datos,int tipo_Evento){
        int opcions;
        System.out.println(); // Salto de linea para mejor apariencia
        do{

            System.out.print("""
            +---------------------------------------------------------------------------------------------+\n|                           Bienvenido/a a la renta de la conferencia                         |
            +---------------------------------------------------------------------------------------------+\n| 1. Equipamientos:                           Precios:                                        |
            |     > Mesas y sillas                        60$                                             |\n|     > Escenario.                            200$                                            |
            |     > Microfonos.                           120$                                            |\n|     > Proyector y pantalla                  65$                                             |
            |     > Sistema de sonido.                    150$                                            |\n|     > Podio.                                140$                                            |
            |     > Pizarra y rotafolios.                 80$                                             |\n|     > Iluminación.                          165$                                            |
            |                                                                                             |\n| 2. Servicios:                                                                               |
            |     > Registro de asistentes.               100$                                            |\n|     > Traducción simultanea.                250$                                            |
            |     > Transmisión en vivo o grabacion.      175$                                            |\n|     > Café o coffe break.                   60$                                             |
            |     > Personal técnico.                     250$                                            |\n|     > Material                              120$                                            |
            |     > Wi-Fi                                 40$                                             |\n|                                                                                             |
            | 3. Para salir.                                                                              |\n+---------------------------------------------------------------------------------------------+
            """);
            System.out.print("Elige el servicio (1 - 3): ");
            opcions=sc.nextInt();
            sc.nextLine();
            try{
                switch (opcions) {
                    case 1:
                        equipamiento_conferencial(sc, resumen_datos,tipo_Evento);
                        break;
                    case 2:
                        servicio_conferencial(sc,resumen_datos,tipo_Evento);
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

    public static void equipamiento_conferencial(Scanner sc, Object[] resumen_datos,int tipo_Evento){
        int diasUsuarios=(int)resumen_datos[4]; //Convertor
        int[] P_equipamiento = new int[]{60,200,120,65,150,140,80,125};
        String[] equipamiento_text = new String[]{
                "Mesas y Sillas","Escenario","Microfonos","Proyector y pantalla","Sistemas de sonido","Podio","Pizarra y rotafolios","iluminacion",
                "Total:"
        };
        int [] cantidad=new int[8], cantidad_f=new int[8];

        for(int i=0;i<8;i++){
            System.out.println("La cantidad de "+equipamiento_text[i]+":");
            cantidad[i]=sc.nextInt();
            cantidad_f[i]=cantidad[i]*P_equipamiento[i]*diasUsuarios;
            //System.out.println(equipamiento_text[i]+":"+cantidad_f[i]);
        }
        if(tipo_Evento==2){
            System.out.println("Se agregara un cargo del doble por ser empresarial.");
            for(int i=0;i<8;i++){
                cantidad_f[i]*=2;
                //System.out.println(equipamiento_text[i]+":"+cantidad_f[i]);
            }
        }
        int total=Arrays.stream(cantidad_f).sum();
        System.out.println(total);
    }
    public static void servicio_conferencial(Scanner sc, Object[] resumen_datos,int tipo_Evento){
        int diasUsuario=(int)resumen_datos[4];
        int[] servicios = new int[]{100,250,175,60,250,120,40}, cantidad=new int[7], cantidad_f=new int[7];
        String[] servicios_text = new String[]{"Registro de Asistentes","Traduccion","Transmisión o grabacion","Café o coffe bar.","Personal","Material","Wi-fi"};

        for(int i=0;i<7;i++){
            System.out.println("Cantidad de "+servicios_text[i]+":");
            cantidad[i]=sc.nextInt();
            cantidad_f[i]=cantidad[i]*servicios[i]*diasUsuario;
            //System.out.println(servicios_text[i]+":"+cantidad_f[i]);
        }
        if(tipo_Evento==2){
            System.out.println("Se agregara un cargo del doble por ser empresarial.");
            for(int i=0;i<8;i++){
                cantidad_f[i]*=2;
                //System.out.println(servicios_text[i]+":"+cantidad_f[i]);
            }
        }
        int total=Arrays.stream(cantidad_f).sum();
        System.out.println(total);
    }
    /*                                                           2.Parte del teatro                                                                                                */
    public static void montaje_teatro(Scanner sc,Object[]resumen_datos, int tipo_Evento){
        int opcion;
        do{
            System.out.print("""
            +---------------------------------------------------------------------------------------------+\n|                           Bienvenido/a a la renta de la conferencia                         |
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
            opcion=sc.nextInt();
            sc.nextLine();
            try{
                switch (opcion){
                    case 1:
                        equipamiento_teatro(sc,resumen_datos, tipo_Evento);
                        break;
                    case 2:
                        servicios_teatro(sc,resumen_datos, tipo_Evento);
                        break;
                    case 3:
                        System.out.println("Saliendo");
                        break;
                }
            }catch(InputMismatchException a){
                System.out.println();
                System.out.println("Solo puedes usar numeros del 1 al 3.");
            }
        }while(opcion!=3);
    }
    public static void equipamiento_teatro(Scanner sc,Object[] resumen_datos, int tipo_Evento){
        int diasUsuario=(int)resumen_datos[4];
        int[] equipamiento_precios=new int[]{200,120,70,135,150,240,300},cantidad=new int[7], precio_f=new int[7];
        String[] equipamiento_text=new String[]{"Escenarios","Butacas","Iluminaciónes","Sistemas de sonido","Consolas","Camerinos","Decoraciónes"};

        for(int i=0;i<7;i++){
            System.out.println("Cantidad de "+equipamiento_text[i]+":");
            cantidad[i]=sc.nextInt();
            sc.nextLine();
            precio_f[i]=cantidad[i]*equipamiento_precios[i]*diasUsuario;
            System.out.println(precio_f[i]);
        }
        if(tipo_Evento==2){
            System.out.println("Cargo doble para evento empresarial");
            for(int i=0;i<7;i++){
                precio_f[i]*=2;
            }
        }
        int total=Arrays.stream(precio_f).sum();
        System.out.println(total);
    }
    public static void servicios_teatro(Scanner sc,Object[]resumen_datos, int tipo_Evento){
        int diasUsuario=(int)resumen_datos[4];
        int[] servicio_precios=new int[]{80,350,405,90,250,140,190},cantidad=new int[7], precio_f=new int[7];
        String[] servico_texto=new String[]{"Vendedores","Personal","Seguridad","Servicios de comida","Publicidad","Servicios de limpieza","Técnicos"};

        for(int i=0;i<7;i++){
            System.out.println("Cantidad de "+servico_texto[i]+":");
            cantidad[i]=sc.nextInt();
            sc.nextLine();
            precio_f[i]=cantidad[i]*servicio_precios[i]*diasUsuario;
            System.out.println(precio_f[i]);
        }
        if(tipo_Evento==2){
            System.out.println("Cargo doble para evento empresarial");
            for(int i=0;i<7;i++){
                precio_f[i]*=2;
            }
        }
        int total=Arrays.stream(precio_f).sum();
        System.out.println(total);

    }
    /*                                          ISAAC                                          */
    // EN ESTA FUNCION LLAMO A LAS DEMAS FUNCIONES Y LES ASIGNO VARIABLES.
    public static void eventoRecepcion(Scanner sc, Object[] resumen_datos,int tipo_Evento) {
        int diasUsuario=(int)resumen_datos[4];//Casting good Isaac8)
        int totalEquipamiento = equipamientoRecepcion(sc, resumen_datos,tipo_Evento);
        int totalServicios = serviciosRecepcion(sc,resumen_datos,tipo_Evento);
        int total = totalEquipamiento + totalServicios;

        System.out.println(" Total por el evento Recepción (" + diasUsuario + " días): $" + total);
    }
    // ARRAY PARA NOMBRES DEL EQUIPAMIENTO
    public static int equipamientoRecepcion(Scanner sc,Object[]resumen_datos,int tipo_Evento) {
        int dias=(int)resumen_datos[4];
        System.out.print("""
    +--------------------------------------------------------------------------------------------------+
    |                            Bienvenido/a a la renta del salón                                     |
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

        String[] nombres = {
                "Mesas altas tipo cóctel", "Barra de bebidas", "Sistema de sonido ambiental",
                "Área de bienvenida", "Iluminación decorativa", "Decoración floral"
        };
        //ARRAYS DE PRECIOS DEL EQUIPAMIENTO
        int[] precios = {300, 800, 400, 250, 500, 600};
        // SI EL EVENTO ES EMPRESARAL EL FOR HACE UN AUMENTO DEL 20% A CADA COSTO
        if (tipo_Evento==2) {
            for (int i = 0; i < precios.length; i++) {
                precios[i] = (int)(precios[i] * 2);
            }
        }
        // HACE EL CALCULO DE LOS COSTOS POR LOS DIAS RENTADOS
        System.out.println(" Equipamiento para Recepción:");
        int subtotal = 0;
        int [] cantidades = new int [precios.length];
        System.out.println("Cuanto deseas Agregar?");
        for (int i = 0; i < precios.length; i++) {
            System.out.println(nombres [i]);
            cantidades[i]= sc.nextInt();
            int precioTotal = precios[i] * cantidades [i]* dias;
            subtotal += precioTotal;
            System.out.println(" - " + nombres[i] + ": $" + precioTotal);
        }
        return subtotal;
    }
    // ARRAYS QUE GUARDA LOS NOMBRES DE LOS SERVICIOS DE RECEPCION
    public static int serviciosRecepcion(Scanner sc, Object[] resumen_datos,int tipo_Evento) {
        int dias=(int)resumen_datos[4];
        String[] nombres = {
                "Servicio de catering", "DJ o música en vivo", "Fotografía y video",
                "Guardarropa", "Valet parking", "Seguridad", "Meseros y anfitriones"
        };
        // ESTE ARRAY GUARDA LOS PRECIOS DE CADA SERVICIO
        int[] precios = {1200, 1500, 1000, 300, 400, 350, 500};
        // SI EL EVENTO ES EMPRESARIAL EL FOR AUMENTA EL COSTO DE LOS SERVICIOS
        if (tipo_Evento==2) {
            for (int i = 0; i < precios.length; i++) {
                precios[i] = (int)(precios[i] * 2);
            }
        }
        // ARRAYS SUMA DE COSTOS POR LOS DIAS.
        System.out.println(" Servicios para Recepción:");
        int subtotal = 0;
        int [] cantidades = new int [precios.length];
        System.out.println("Cuanto deseas Agregar?");
        for (int i = 0; i < precios.length; i++) {
            System.out.println(nombres [i]);
            cantidades[i]= sc.nextInt();
            int precioTotal = precios[i] * cantidades [i] * dias;
            subtotal += precioTotal;
            System.out.println(" - " + nombres[i] + ": $" + precioTotal);
        }
        return subtotal;
    }
    // FUNCION DE BANQUETE
    public static void eventoBanquete(Scanner sc, Object[]resumen_datos,int tipo_Evento) {
        int diasUsuario=(int)resumen_datos[4];
        int totalEquipamiento = equipamientoBanquete(sc,resumen_datos,tipo_Evento);
        int totalServicios = serviciosBanquete(sc,resumen_datos,tipo_Evento);
        int total = totalEquipamiento + totalServicios;

        System.out.println(" Total por el evento Banquete (" + diasUsuario + " días): $" + total);
    }
    //ARRAYS PARA GUARDAR LOS NOMBRE DE LOS EQUIPAMENTOS DE BANQUETE
    public static int equipamientoBanquete(Scanner sc,Object[]resumen_datos,int tipo_Evento) {
        int dias=(int)resumen_datos[4];
        System.out.print("""
    +--------------------------------------------------------------------------------------------------+
    |                            Bienvenido/a a la renta del salón                                     |
    +--------------------------------------------------------------------------------------------------+
    | Equipamientos:                       | Precio c/u  | Descripción                                 |
    |    > Mesas redondas o rectangulares  | $700.00     | Mesas para eventos elegantes                |
    |    > Sillas con fundas               | $400.00     | Sillas decoradas con fundas                  |
    |    > Mantelería y vajilla formal     | $650.00     | Manteles y vajilla para eventos formales    |
    |    > Centros de mesa                 | $300.00     | Decoración central para mesas                 |
    |    > Iluminación ambiental           | $500.00     | Luces para crear ambiente cálido              |
    |    > Tarima para discursos           | $350.00     | Plataforma para presentaciones                |
    |                                                                                                  |
    | Servicios:                         | Precio c/u  | Descripción                                   |
    |    > Menú completo                  | $2500.00    | Comida y bebida completa para invitados       |
    |    > Cocineros y meseros           | $1800.00    | Personal para cocina y atención                 |
    |    > Música en vivo o DJ            | $1500.00    | Entretenimiento musical profesional            |
    |    > Pastel formal                 | $500.00     | Pastel especial para eventos                    |
    |    > Fotografía profesional         | $1000.00    | Registro fotográfico del evento                  |
    |    > Brindis y discursos           | $600.00     | Organización de brindis y presentaciones        |
    |    > Estación de bebidas           | $400.00     | Barra de bebidas especializadas                  |
    +--------------------------------------------------------------------------------------------------+
    """);

        String[] nombres = {
                "Mesas redondas o rectangulares", "Sillas con fundas", "Mantelería y vajilla formal",
                "Centros de mesa", "Iluminación ambiental", "Tarima para discursos"
        };
        int[] precios = {700, 400, 650, 300, 500, 350};
        // SI ES EMPRESARIAL LE AUMENTA 20% AL COSTO
        if (tipo_Evento==2) {
            for (int i = 0; i < precios.length; i++) {
                precios[i] = (int)(precios[i] * 2);
            }
        }
        // RECORRE CADA UNO PARA SUMARLOS Y GUARDAR EL PRECIO EN SUBTOTAL
        System.out.println(" Equipamiento para Banquete:");
        int subtotal = 0;
        int [] cantidades = new int[precios.length];
        System.out.println("Cuantos desea agregar?");
        for (int i = 0; i < precios.length; i++) {
            System.out.println( nombres [i]);
            cantidades [i]= sc.nextInt();
            int precioTotal = precios[i] * cantidades [i] * dias;
            subtotal += precioTotal;
            System.out.println(" - " + nombres[i] + ": $" + precioTotal);
        }
        return subtotal;
    }
    // SERVICIOS DE BANQUETE, ARRAY CON  NOMBRES.
    public static int serviciosBanquete(Scanner sc, Object[]resumen_datos,int tipo_Evento) {
        int dias=(int)resumen_datos[4];
        String[] nombres = {
                "Menú completo", "Cocineros y meseros", "Música en vivo o DJ",
                "Pastel formal", "Fotografía profesional", "Brindis y discursos", "Estación de bebidas" };
        int[] precios = {2500, 1800, 1500, 500, 1000, 600, 400};
        // AUMENTA 20% AL SER EMPRESARIAL
        if (tipo_Evento==2) {
            for (int i = 0; i < precios.length; i++) {
                precios[i] = (int)(precios[i] * 2);
            }
        }
        //SUMA LOS PRECIOS MULTIPLICADOS POR LOS DIAS
        System.out.println(" Servicios para Banquete:");
        int subtotal = 0;
        int [] cantidades = new int [precios.length];
        System.out.println("Cuantos deseas Agregar?");
        for (int i = 0; i < precios.length; i++) {
            System.out.println(nombres[i]);
            cantidades [i]= sc.nextInt();
            int precioTotal = precios[i] * cantidades[i] * dias;
            subtotal += precioTotal;
            System.out.println(" - " + nombres[i] + ": $" + precioTotal);
        }
        return subtotal;
    }







    // AQUI EMPIEZA LO DE JUAN
    /*                                          Juan                                          */
    public static void montajeSalon(Scanner sc, Object[]resumen_datos,int tipo_Evento){


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
        equipamientoServiciosSalon(sc,resumen_datos,tipo_Evento); // Llama a la funcion equipamiento y manda los datos necesarios
        return;
    }

    public static void equipamientoServiciosSalon(Scanner sc, Object[]resumen_datos,int tipo_Evento){
        int diasUsuario=(int)resumen_datos[4];

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
        decFinal(
                sc,
                resumen_datos,
                tipo_Evento,

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
            Object[]resumen_datos,
            int tipo_Evento,

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
                    Qué desea hacer? (1 - 4):""" + " ");
                pasoFinal = sc.nextInt();

                switch (pasoFinal) {
                    case 1:
                        pago(sc,
                                resumen_datos,
                                tipo_Evento,
                                equipamiento,
                                cantidadEquipamiento,
                                preciosEquipamiento,
                                totalEquipamiento,
                                sumatotalEquipamiento,
                                servicio,
                                cantidadServicio,
                                preciosServicio,
                                totalServicio,
                                sumatotalServicio);
                        return;
                    case 2:
                        informacion(
                                sc,
                                resumen_datos,
                                tipo_Evento,

                                equipamiento,
                                cantidadEquipamiento,
                                preciosEquipamiento,
                                totalEquipamiento,
                                sumatotalEquipamiento,

                                servicio,
                                cantidadServicio,
                                preciosServicio,
                                totalServicio,
                                sumatotalServicio);
                        break;
                    case 3:
                        montajeSalon(
                                sc,
                                resumen_datos,
                                tipo_Evento);
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

    public static void pago(
            Scanner sc,
            Object[]resumen_datos,
            int tipo_Evento,

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
        double pagoRealizado;
        do {
            try {
                System.out.println(); // Salto para mejor apariencia
                // Evento social
                if(tipo_Evento == 1){
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
                            break;
                        }else if(pagoRealizado > montoPagar){
                            System.out.println("\nSu cambio es de: " + (pagoRealizado - montoPagar));
                            System.out.println("💵 Muchas gracias por su compra, vuelva pronto!\n");
                            break;
                        }else if(pagoRealizado < montoPagar){
                            System.out.println("\n💥 Dinero insuficiente, le hace falta: $" + (montoPagar - pagoRealizado));
                        }else{
                            System.out.println("Qué va aquí?");
                            sc.next();
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
                            break;
                        }else if(pagoRealizado > montoPagar){
                            System.out.println("\nSu cambio es de: " + (pagoRealizado - montoPagar));
                            System.out.println("Muchas gracias por su compra, vuelva pronto!");
                            break;
                        }else if(pagoRealizado < montoPagar){
                            System.out.println("\n💥 Dinero insuficiente, le hace falta: " + (montoPagar - pagoRealizado));

                        }else{
                            System.out.println("Qué va aquí?");
                            sc.next();
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
                            break;
                        }else if(pagoRealizado > montoPagar){
                            System.out.println("\nSu cambio es de: " + (pagoRealizado - montoPagar));
                            System.out.println("Muchas gracias por su compra, vuelva pronto!");
                            break;
                        }else if(pagoRealizado < montoPagar){
                            System.out.println("\n💥 Dinero insuficiente, le hace falta: " + (montoPagar - pagoRealizado));

                        }else{
                            sc.next();
                        }
                    }
                }

                if(tipo_Evento == 2){
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
                            break;
                        }else if(pagoRealizado > montoPagar){
                            System.out.println("\nSu cambio es de: " + (pagoRealizado - montoPagar));
                            System.out.println("💵 Muchas gracias por su compra, vuelva pronto!\n");
                            break;
                        }else if(pagoRealizado < montoPagar){
                            System.out.println("\n💥 Dinero insuficiente, le hace falta: $" + (montoPagar - pagoRealizado));
                        }else{
                            System.out.println("Qué va aquí?");
                            sc.next();
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
                            break;
                        }else if(pagoRealizado > montoPagar){
                            System.out.println("\nSu cambio es de: " + (pagoRealizado - montoPagar));
                            System.out.println("Muchas gracias por su compra, vuelva pronto!");
                            break;
                        }else if(pagoRealizado < montoPagar){
                            System.out.println("\n💥 Dinero insuficiente, le hace falta: " + (montoPagar - pagoRealizado));

                        }else{
                            System.out.println("Qué va aquí?");
                            sc.next();
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

                        }else{
                            sc.next();
                        }
                    }
                }


            } catch (InputMismatchException z) {
                System.out.println("\n❌ Error: No se permiten letras ni caracteres especiales");
                sc.next();
            }
        } while (true);



    }
    public static void informacion(
            Scanner sc,
            Object[]resumen_datos,
            int tipo_Evento,

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
        // Evento Social
        if(tipo_Evento == 1){
            // Tamaño Pequeño, Tipo Social -> Todo x 1 (ó sin multiplicar)
            if((int) resumen_datos[3] >= 1 && (int) resumen_datos[3] <= 50){
                System.out.printf(
                        """
                        \n+-----------------------------------------------------+
                        | Nombre: %-43s |
                        | Número de telefono: %-31s |
                        | Correo: %-43s |
                        | Cantidad de personas que asistiran: %-15s |
                        | Días de renta: %-36s |
                        | Tipo de evento: Social%-30s|
                        | Evento contratado: Salón%-28s|
                        | Tamaño de evento: Pequeño%-27s|
                        +-----------------------------------------------------+------------------------------------------------------------------+
                        """,
                        resumen_datos[0],
                        resumen_datos[1],
                        resumen_datos[2],
                        resumen_datos[3],
                        resumen_datos[4],
                        "",  // Tipo evento
                        "",  // Evento contratado
                        ""); // Tamaño evento
                System.out.printf("| %-27s | %-5s | %-10s | %-34s |", "Equipamiento", "Cantidad", "Precio c/u", "Cantidad x Precio c/u x (" + resumen_datos[4] + ") día(s) x Tamaño evento x Tipo evento");
                for (int i = 0; i < equipamiento.length - 1; i++) {
                    System.out.printf("\n| %-27s | %-8s | $%-9s | $%-63s |", equipamiento[i], cantidadEquipamiento[i], preciosEquipamiento[i], totalEquipamiento[i] );
                }
                System.out.println();
                System.out.printf("| %-27s | %-8s | %-10s | $%-63s |\n",equipamiento[6], "", "", sumatotalEquipamiento);
                ///* Fin equipamiento

                System.out.println("|                                                                                                                        |");

                ///* Muestra en pantalla: | Servicio | Cantidad | Precio c/u
                System.out.printf("| %-27s | %-5s | %-10s | %-34s |", "Servicio", "Cantidad", "Precio c/u", "Cantidad x Precio c/u x (" + resumen_datos[4] + ") día(s) x Tamaño evento x Tipo evento");
                for (int i = 0; i < servicio.length - 1; i++) {
                    System.out.printf("\n| %-27s | %-8s | $%-9s | $%-63s |", servicio[i], cantidadServicio[i], preciosServicio[i], totalServicio[i] );
                }
                System.out.println();
                System.out.printf("| %-27s | %-8s | %-10s | $%-63s |\n",servicio[4], "", "", sumatotalServicio);
                System.out.println("+------------------------------------------------------------------------------------------------------------------------+");
                System.out.printf("| Total final: $%-104s |%n", (sumatotalEquipamiento + sumatotalServicio));
                System.out.println("+------------------------------------------------------------------------------------------------------------------------+");
                /// * Fin Servicio
                sc.nextLine(); // Limpia el buffer
                System.out.print("Presiona enter para volver: ");
                sc.nextLine();


            }
            // Tamaño Mediano, Tipo Social -> Todo x 1.5
            else if((int) resumen_datos[3] >= 51 && (int) resumen_datos[3] <= 100){
                System.out.printf(
                        """
                        \n+-----------------------------------------------------+
                        | Nombre: %-43s |
                        | Número de telefono: %-31s |
                        | Correo: %-43s |
                        | Cantidad de personas que asistiran: %-15s |
                        | Días de renta: %-36s |
                        | Tipo de evento: Social%-30s|
                        | Evento contratado: Salón%-28s|
                        | Tamaño de evento: Mediano%-27s|
                        +-----------------------------------------------------+------------------------------------------------------------------+
                        """,
                        resumen_datos[0],
                        resumen_datos[1],
                        resumen_datos[2],
                        resumen_datos[3],
                        resumen_datos[4],
                        "",  // Tipo evento
                        "",  // Evento contratado
                        ""); // Tamaño evento
                System.out.printf("| %-27s | %-5s | %-10s | %-34s |", "Equipamiento", "Cantidad", "Precio c/u", "Cantidad x Precio c/u x (" + resumen_datos[4] + ") día(s) x Tamaño evento x Tipo evento");
                for (int i = 0; i < equipamiento.length - 1; i++) {
                    System.out.printf("\n| %-27s | %-8s | $%-9s | $%-63s |", equipamiento[i], cantidadEquipamiento[i], preciosEquipamiento[i], (totalEquipamiento[i] * 1.5)); // 1.5 es el tamano del evento: Mediano
                }
                System.out.println();
                System.out.printf("| %-27s | %-8s | %-10s | $%-63s |\n",equipamiento[6], "", "", (sumatotalEquipamiento * 1.5) );
                ///* Fin equipamiento

                System.out.println("|                                                                                                                        |");

                ///* Muestra en pantalla: | Servicio | Cantidad | Precio c/u
                System.out.printf("| %-27s | %-5s | %-10s | %-34s |", "Servicio", "Cantidad", "Precio c/u", "Cantidad x Precio c/u x (" + resumen_datos[4] + ") día(s) x Tamaño evento x Tipo evento");
                for (int i = 0; i < servicio.length - 1; i++) {
                    System.out.printf("\n| %-27s | %-8s | $%-9s | $%-63s |", servicio[i], cantidadServicio[i], preciosServicio[i], (totalServicio[i] * 1.5) );  // 1.5 es el tamano del evento: Mediano
                }
                System.out.println();
                System.out.printf("| %-27s | %-8s | %-10s | $%-63s |\n",servicio[4], "", "", (sumatotalServicio * 1.5)); // 1.5 es el tama;o del evento
                System.out.println("+------------------------------------------------------------------------------------------------------------------------+");
                System.out.printf("| Total a pagar: $%-102s |%n", ((sumatotalEquipamiento + sumatotalServicio) * 1.5));
                System.out.println("+------------------------------------------------------------------------------------------------------------------------+");
                /// * Fin Servicio
                sc.nextLine(); // Limpia el buffer
                System.out.print("Presiona enter para volver: ");
                sc.nextLine();
            }
            // Tamaño Grande, Tipo Social -> todo x 2
            else if((int) resumen_datos[3] >= 101) {
                System.out.printf(
                        """
                        \n+-----------------------------------------------------+
                        | Nombre: %-43s |
                        | Número de telefono: %-31s |
                        | Correo: %-43s |
                        | Cantidad de personas que asistiran: %-15s |
                        | Días de renta: %-36s |
                        | Tipo de evento: Social%-30s|
                        | Evento contratado: Salón%-28s|
                        | Tamaño de evento: Grande%-28s|
                        +-----------------------------------------------------+------------------------------------------------------------------+
                        """,
                        resumen_datos[0],
                        resumen_datos[1],
                        resumen_datos[2],
                        resumen_datos[3],
                        resumen_datos[4],
                        "",  // Tipo evento
                        "",  // Evento contratado
                        ""); // Tamaño evento
                System.out.printf("| %-27s | %-5s | %-10s | %-34s |", "Equipamiento", "Cantidad", "Precio c/u", "Cantidad x Precio c/u x (" + resumen_datos[4] + ") día(s) x Tamaño evento x Tipo evento");
                for (int i = 0; i < equipamiento.length - 1; i++) {
                    System.out.printf("\n| %-27s | %-8s | $%-9s | $%-63s |", equipamiento[i], cantidadEquipamiento[i], preciosEquipamiento[i], (totalEquipamiento[i] * 2)); // 1.5 es el tamano del evento: Mediano
                }
                System.out.println();
                System.out.printf("| %-27s | %-8s | %-10s | $%-63s |\n",equipamiento[6], "", "", (sumatotalEquipamiento * 2));
                ///* Fin equipamiento

                System.out.println("|                                                                                                                        |");

                ///* Muestra en pantalla: | Servicio | Cantidad | Precio c/u
                System.out.printf("| %-27s | %-5s | %-10s | %-34s |", "Servicio", "Cantidad", "Precio c/u", "Cantidad x Precio c/u x (" + resumen_datos[4] + ") día(s) x Tamaño evento x Tipo evento");
                for (int i = 0; i < servicio.length - 1; i++) {
                    System.out.printf("\n| %-27s | %-8s | $%-9s | $%-63s |", servicio[i], cantidadServicio[i], preciosServicio[i], (totalServicio[i] * 2) );  // 1.5 es el tamano del evento: Mediano
                }
                System.out.println();
                System.out.printf("| %-27s | %-8s | %-10s | $%-63s |\n",servicio[4], "", "", (sumatotalServicio * 2)); // 1.5 es el tama;o del evento
                System.out.println("+------------------------------------------------------------------------------------------------------------------------+");
                System.out.printf("| Total a pagar: $%-102s |%n", ((sumatotalEquipamiento + sumatotalServicio) * 2));
                System.out.println("+------------------------------------------------------------------------------------------------------------------------+");
                /// * Fin Servicio
                sc.nextLine(); // Limpia el buffer
                System.out.print("Presiona enter para volver: ");
                sc.nextLine();
            }
        }

        // Evento Empresarial
        else if(tipo_Evento == 2){
            // Tamaño Pequeño, Tipo Empresarial -> Todo x 2
            if((int) resumen_datos[3] >= 1 && (int) resumen_datos[3] <= 50){
                System.out.printf(
                        """
                        \n+-----------------------------------------------------+
                        | Nombre: %-43s |
                        | Número de telefono: %-31s |
                        | Correo: %-43s |
                        | Cantidad de personas que asistiran: %-15s |
                        | Días de renta: %-36s |
                        | Tipo de evento: Empresarial%-25s|
                        | Evento contratado: Salón%-28s|
                        | Tamaño de evento: Pequeño%-27s|
                        +-----------------------------------------------------+------------------------------------------------------------------+
                        """,
                        resumen_datos[0],
                        resumen_datos[1],
                        resumen_datos[2],
                        resumen_datos[3],
                        resumen_datos[4],
                        "",  // Tipo evento
                        "",  // Evento contratado
                        ""); // Tamaño evento
                ///* Muestra en pantalla: | Equipamiento | Cantidad | Precio c/u
                System.out.printf("| %-27s | %-5s | %-10s | %-34s |", "Equipamiento", "Cantidad", "Precio c/u", "Cantidad x Precio c/u x (" + resumen_datos[4] + ") día(s) x Tamaño evento x Tipo evento");
                for (int i = 0; i < equipamiento.length - 1; i++) {
                    System.out.printf("\n| %-27s | %-8s | $%-9s | $%-63s |", equipamiento[i], cantidadEquipamiento[i], preciosEquipamiento[i], (totalEquipamiento[i] * 2) );
                }
                System.out.println();
                System.out.printf("| %-27s | %-8s | %-10s | $%-63s |\n",equipamiento[6], "", "", (sumatotalEquipamiento * 2));
                ///* Fin equipamiento

                System.out.println("|                                                                                                                        |");

                ///* Muestra en pantalla: | Servicio | Cantidad | Precio c/u
                System.out.printf("| %-27s | %-5s | %-10s | %-34s |", "Servicio", "Cantidad", "Precio c/u", "Cantidad x Precio c/u x (" + resumen_datos[4] + ") día(s) x Tamaño evento x Tipo evento");
                for (int i = 0; i < servicio.length - 1; i++) {
                    System.out.printf("\n| %-27s | %-8s | $%-9s | $%-63s |", servicio[i], cantidadServicio[i], preciosServicio[i], (totalServicio[i] * 2));
                }
                System.out.println();
                System.out.printf("| %-27s | %-8s | %-10s | $%-63s |\n",servicio[4], "", "", (sumatotalServicio * 2));
                System.out.println("+------------------------------------------------------------------------------------------------------------------------+");
                System.out.printf("| Total final: $%-104s |%n", ((sumatotalEquipamiento + sumatotalServicio) * 2));
                System.out.println("+------------------------------------------------------------------------------------------------------------------------+");
                /// * Fin Servicio
                sc.nextLine(); // Limpia el buffer
                System.out.print("Presiona enter para volver: ");
                sc.nextLine();
            }
            // Tamaño Mediano, Tipo Empresarial -> Todo x 2.5
            else if((int) resumen_datos[3] >= 51 && (int) resumen_datos[3] <= 100){
                System.out.printf(
                        """
                        \n+-----------------------------------------------------+
                        | Nombre: %-43s |
                        | Número de telefono: %-31s |
                        | Correo: %-43s |
                        | Cantidad de personas que asistiran: %-15s |
                        | Días de renta: %-36s |
                        | Tipo de evento: Empresarial%-25s|
                        | Evento contratado: Salón%-28s|
                        | Tamaño de evento: Mediano%-27s|
                        +-----------------------------------------------------+------------------------------------------------------------------+
                        """,
                        resumen_datos[0],
                        resumen_datos[1],
                        resumen_datos[2],
                        resumen_datos[3],
                        resumen_datos[4],
                        "",  // Tipo evento
                        "",  // Evento contratado
                        ""); // Tamaño evento
                ///* Muestra en pantalla: | Equipamiento | Cantidad | Precio c/u
                System.out.printf("| %-27s | %-5s | %-10s | %-34s |", "Equipamiento", "Cantidad", "Precio c/u", "Cantidad x Precio c/u x (" + resumen_datos[4] + ") día(s) x Tamaño evento x Tipo evento");
                for (int i = 0; i < equipamiento.length - 1; i++) {
                    System.out.printf("\n| %-27s | %-8s | $%-9s | $%-63s |", equipamiento[i], cantidadEquipamiento[i], preciosEquipamiento[i], (totalEquipamiento[i] * 2.5) );
                }
                System.out.println();
                System.out.printf("| %-27s | %-8s | %-10s | $%-63s |\n",equipamiento[6], "", "", (sumatotalEquipamiento * 2.5));
                ///* Fin equipamiento

                System.out.println("|                                                                                                                        |");

                ///* Muestra en pantalla: | Servicio | Cantidad | Precio c/u
                System.out.printf("| %-27s | %-5s | %-10s | %-34s |", "Servicio", "Cantidad", "Precio c/u", "Cantidad x Precio c/u x (" + resumen_datos[4] + ") día(s) x Tamaño evento x Tipo evento");
                for (int i = 0; i < servicio.length - 1; i++) {
                    System.out.printf("\n| %-27s | %-8s | $%-9s | $%-63s |", servicio[i], cantidadServicio[i], preciosServicio[i], (totalServicio[i] * 2.5));
                }
                System.out.println();
                System.out.printf("| %-27s | %-8s | %-10s | $%-63s |\n",servicio[4], "", "", (sumatotalServicio * 2.5));
                System.out.println("+------------------------------------------------------------------------------------------------------------------------+");
                System.out.printf("| Total final: $%-104s |%n", ((sumatotalEquipamiento + sumatotalServicio) * 2.5));
                System.out.println("+------------------------------------------------------------------------------------------------------------------------+");
                /// * Fin Servicio
                sc.nextLine(); // Limpia el buffer
                System.out.print("Presiona enter para volver: ");
                sc.nextLine();
            }
            // Tamaño Grande, Tipo Empresarial -> Todo x 3
            else if((int) resumen_datos[3] >= 101){
                System.out.printf(
                        """
                        \n+-----------------------------------------------------+
                        | Nombre: %-43s |
                        | Número de telefono: %-31s |
                        | Correo: %-43s |
                        | Cantidad de personas que asistiran: %-15s |
                        | Días de renta: %-36s |
                        | Tipo de evento: Empresarial%-25s|
                        | Evento contratado: Salón%-28s|
                        | Tamaño de evento: Grande%-28s|
                        +-----------------------------------------------------+------------------------------------------------------------------+
                        """,
                        resumen_datos[0],
                        resumen_datos[1],
                        resumen_datos[2],
                        resumen_datos[3],
                        resumen_datos[4],
                        "",  // Tipo evento
                        "",  // Evento contratado
                        ""); // Tamaño evento
                ///* Muestra en pantalla: | Equipamiento | Cantidad | Precio c/u
                System.out.printf("| %-27s | %-5s | %-10s | %-34s |", "Equipamiento", "Cantidad", "Precio c/u", "Cantidad x Precio c/u x (" + resumen_datos[4] + ") día(s) x Tamaño evento x Tipo evento");
                for (int i = 0; i < equipamiento.length - 1; i++) {
                    System.out.printf("\n| %-27s | %-8s | $%-9s | $%-63s |", equipamiento[i], cantidadEquipamiento[i], preciosEquipamiento[i], (totalEquipamiento[i] * 3) );
                }
                System.out.println();
                System.out.printf("| %-27s | %-8s | %-10s | $%-63s |\n",equipamiento[6], "", "", (sumatotalEquipamiento * 3));
                ///* Fin equipamiento

                System.out.println("|                                                                                                                        |");

                ///* Muestra en pantalla: | Servicio | Cantidad | Precio c/u
                System.out.printf("| %-27s | %-5s | %-10s | %-34s |", "Servicio", "Cantidad", "Precio c/u", "Cantidad x Precio c/u x (" + resumen_datos[4] + ") día(s) x Tamaño evento x Tipo evento");
                for (int i = 0; i < servicio.length - 1; i++) {
                    System.out.printf("\n| %-27s | %-8s | $%-9s | $%-63s |", servicio[i], cantidadServicio[i], preciosServicio[i], (totalServicio[i] * 3));
                }
                System.out.println();
                System.out.printf("| %-27s | %-8s | %-10s | $%-63s |\n",servicio[4], "", "", (sumatotalServicio * 3));
                System.out.println("+------------------------------------------------------------------------------------------------------------------------+");
                System.out.printf("| Total final: $%-104s |%n", ((sumatotalEquipamiento + sumatotalServicio) * 3));
                System.out.println("+------------------------------------------------------------------------------------------------------------------------+");
                /// * Fin Servicio
                sc.nextLine(); // Limpia el buffer
                System.out.print("Presiona enter para volver: ");
                sc.nextLine();
            }
        }
        System.out.println(); // Salto de linea para mejor apariencia
    }
}