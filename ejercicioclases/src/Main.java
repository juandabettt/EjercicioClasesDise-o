import Model.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Publicacion publicacion = null;

        System.out.println("=== SISTEMA DE REGISTRO DE PUBLICACIONES ===");

        try {
            System.out.println("Seleccione el tipo de publicación a registrar:");
            System.out.println("1. Libro");
            System.out.println("2. Video");
            System.out.println("3. Disco");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea residual

            System.out.print("\nIngrese el título: ");
            String titulo = scanner.nextLine();

            System.out.print("Ingrese el precio: ");
            double precio = scanner.nextDouble();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el número de páginas: ");
                    int paginas = scanner.nextInt();
                    System.out.print("Ingrese el año de publicación: ");
                    int anio = scanner.nextInt();

                    publicacion = new Libro(titulo, precio, paginas, anio);
                    break;

                case 2:
                    System.out.println("Seleccione el idioma (1. Español, 2. Inglés, 3. Portugués): ");
                    int optIdioma = scanner.nextInt();
                    Idioma idiomaSeleccionado;
                    switch (optIdioma) {
                        case 1: idiomaSeleccionado = Idioma.ESPANOL; break;
                        case 2: idiomaSeleccionado = Idioma.INGLES; break;
                        case 3: idiomaSeleccionado = Idioma.PORTUGUES; break;
                        default:
                            System.out.println("Opción inválida. Asignando Inglés por defecto.");
                            idiomaSeleccionado = Idioma.INGLES;
                    }

                    System.out.print("Ingrese la duración en horas (ej. 1,5): ");
                    float horas = scanner.nextFloat();

                    publicacion = new Video(titulo, precio, idiomaSeleccionado, horas);
                    break;

                case 3:
                    System.out.print("Ingrese la duración en minutos (ej. 45,5): ");
                    float minutos = scanner.nextFloat();

                    publicacion = new Disco(titulo, precio, minutos);
                    break;

                default:
                    System.out.println("Opción no válida. Ejecución terminada.");
                    return; // Sale del main
            }

            System.out.println("\n=== REGISTRO EXITOSO ===");
            System.out.println(publicacion.toString());

        } catch (InputMismatchException e) {
            System.out.println("\n[ERROR] Entrada inválida. Se esperaba un formato numérico. Verifique el uso de comas o puntos para decimales según su configuración regional.");
        } finally {
            scanner.close(); // Garantiza el cierre del recurso
        }
    }
}