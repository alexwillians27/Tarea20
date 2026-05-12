import java.util.ArrayList;
import java.util.Scanner;

/**
 * Proyecto: Gestor de Tareas Asistido por IA
 * Objetivo: Demostrar el flujo de trabajo con Git y Java.
 */
public class GestorTareas {
    public static void main(String[] args) {
        ArrayList<String> tareas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        System.out.println("=== Bienvenido a tu Gestor de Tareas ===");

        while (opcion != 4) {
            System.out.println("\n1. Añadir tarea");
            System.out.println("2. Listar tareas");
            System.out.println("3. Eliminar tarea");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Escribe la descripción de la tarea: ");
                    String nuevaTarea = scanner.nextLine();
                    tareas.add(nuevaTarea);
                    System.out.println("Tarea añadida correctamente.");
                    break;
                case 2:
                    System.out.println("\n--- Lista de Tareas ---");
                    if (tareas.isEmpty()) {
                        System.out.println("No hay tareas pendientes.");
                    } else {
                        for (int i = 0; i < tareas.size(); i++) {
                            System.out.println((i + 1) + ". " + tareas.get(i));
                        }
                    }
                    break;
                case 3:
                    System.out.print("Introduce el numero a eliminar: ");
                    int indice = Integer.parseInt(scanner.nextLine()) - 1;
                    if (indice >= 0 && indice < tareas.size()) {
                        tareas.remove(indice);
                        System.out.println("Tarea eliminada.");
                    } else {
                        System.out.println("Número no válido.");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no reconocida.");
            }
        }
        scanner.close();
    }
}