import java.util.Scanner;
import java.util.HashMap;

class RegistroVehicular {
    private int id;
    private String marca;
    private String modelo;
    private int año;
    private String tipo;
    private String numeroChasis;
    private String color;

    // Constructor
    public RegistroVehicular(int id, String marca, String modelo, int año, String tipo, String numeroChasis, String color) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.tipo = tipo;
        this.numeroChasis = numeroChasis;
        this.color = color;
    }

    // Getters and setters (omit for brevity)

    @Override
    public String toString() {
        return "RegistroVehicular{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", año=" + año +
                ", tipo='" + tipo + '\'' +
                ", numeroChasis='" + numeroChasis + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

public class Main {
    private static HashMap<Integer, RegistroVehicular> registros = new HashMap<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú Principal:");
            System.out.println("1. Crear un Registro");
            System.out.println("2. Buscar un Registro");
            System.out.println("3. Editar un Registro");
            System.out.println("4. Mostrar todos los Registros");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Aqui se Consume el salto de línea después de nextInt()

            switch (opcion) {
                case 1:
                    crearRegistro(scanner);
                    break;
                case 2:
                    buscarRegistro(scanner);
                    break;
                case 3:
                    editarRegistro(scanner);
                    break;
                case 4:
                    mostrarRegistros();
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Inténtelo nuevamente.");
            }
        }
    }

    private static void crearRegistro(Scanner scanner) {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de nextInt()

        if (registros.containsKey(id)) {
            System.out.println("El ID ya está en uso. Por favor, elige otro.");
            return;
        }

        System.out.print("Marca: ");
        String marca = scanner.nextLine();

        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();

        System.out.print("Año: ");
        int año = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de nextInt()

        System.out.print("Tipo: ");
        String tipo = scanner.nextLine();

        System.out.print("Número de Chasis: ");
        String numeroChasis = scanner.nextLine();

        System.out.print("Color: ");
        String color = scanner.nextLine();

        RegistroVehicular registro = new RegistroVehicular(id, marca, modelo, año, tipo, numeroChasis, color);
        registros.put(id, registro);
        System.out.println("Registro creado exitosamente.");
    }

    private static void buscarRegistro(Scanner scanner) {
        System.out.print("Ingresa el ID del registro a buscar: ");
        int idBuscado = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de nextInt()

        if (registros.containsKey(idBuscado)) {
            RegistroVehicular registro = registros.get(idBuscado);
            System.out.println("Registro encontrado:");
            System.out.println(registro);
        } else {
            System.out.println("Registro no encontrado.");
        }
    }

    private static void editarRegistro(Scanner scanner) {
        System.out.print("Ingresa el ID del registro a editar: ");
        int idEditar = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de nextInt()

        if (registros.containsKey(idEditar)) {
           
            System.out.println("Editar registro no implementado aún.");
        } else {
            System.out.println("Registro no encontrado.");
        }
    }

    private static void mostrarRegistros() {
        if (registros.isEmpty()) {
            System.out.println("No hay registros para mostrar.");
            return;
        }

        System.out.println("Registros existentes:");
        for (RegistroVehicular registro : registros.values()) {
            System.out.println(registro);
        }
    }
}
