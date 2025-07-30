/*

Leer el README.md

*/


import java.util.InputMismatchException;
import java.util.Scanner;
public class Matrix {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            int tipoEvento = 1;
    System.out.println("Bienvenidos");
            do {
                System.out.print("""
                        |----------------------------------------|
                        | Qué tipo de evento deseas contratar?   |
                        |----------------------------------------|
                        | 1. Social                              |
                        | 2. Empresarial                         |
                        | 3. Ninguno                             |
                        |----------------------------------------|
                        """);
                System.out.print("Ingresa una opción (1 - 3): ");
                try {
                    tipoEvento = sc.nextInt();
                    sc.nextLine();  // Importante, impide un ciclo fallido

                    switch (tipoEvento) {
                        case 1: // Adjuntar función para el evento social
                            System.out.println();
                            eventoSocial(sc);
                            System.out.println("Evento social en mantenimiento.");
                            break;
                        case 2: // Adjuntar función para el evento empresarial
                            System.out.println();
                            System.out.println("Evento empresarial en mantenimiento.");
                            break;
                        case 3: // El usuario no eligió ninguna opción 
                            System.out.println();
                            System.out.println("Adios!\nNo has elegiste ningún evento.");
                            break;
                        default:
                            System.out.println();
                            System.out.println("Error: Ingresa un número entre 1 y 3.");
                            continue;
                    }

                    
                } catch (InputMismatchException e) {
                    System.out.println();
                    System.out.println("Error: Debes ingresar un número entero.");
                    sc.nextLine(); // Importante, impide un ciclo infinito
                }
            } while (tipoEvento != 3);
        }
        

        
    }
/* En esta parte irá el evento social */
    public static void eventoSocial(Scanner sc){
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
            sc.nextLine(); // 

            switch(tipoReservacion){
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
        } catch (InputMismatchException e) {
            System.out.println();
            System.out.println("Error, debes ingresar un número entre 1 y 7.");
            sc.nextLine(); // Impide un ciclo infinito
        }

    } while (tipoReservacion != 7);
}


/* En esta parte irá el evento empresarial */
    public static void eventoEmpresarial(Scanner sc){

    }
}
