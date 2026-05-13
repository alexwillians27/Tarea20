import java.util.ArrayList;
import java.util.Scanner;

/**
 * Proyecto: Gestor de Tareas Asistido por IA
 */
public class GestorTareas {
    public static void main(String[] args) {
        // Creo un ArrayList dinámico para ir guardando mis tareas
        ArrayList<String> tareas = new ArrayList<>();
        // Preparo el Scanner para leer lo que escriba el usuario por teclado
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        System.out.println("=== Bienvenido a tu Gestor de Tareas ===");

        // Bucle principal: el menú se repite mientras no elija la opción 4 (Salir)
        while (opcion != 4) {
            System.out.println("\n1. Añadir tarea");
            System.out.println("2. Listar tareas");
            System.out.println("3. Eliminar tarea");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");

            // Utilizo un try-catch que me sugirió la IA para que el programa
            // no se rompa si alguien escribe una letra en vez de un número.
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número válido.");
                continue; // Vuelve al inicio del bucle para pedir la opción de nuevo
            }

            switch (opcion) {
                case 1:
                    // Pido la tarea y la añado directamente al ArrayList
                    System.out.print("Escribe la descripción de la tarea: ");
                    String nuevaTarea = scanner.nextLine();
                    tareas.add(nuevaTarea);
                    System.out.println("Tarea añadida correctamente.");
                    break;
                case 2:
                    System.out.println("\n--- Lista de Tareas ---");
                    // Compruebo si la lista está vacía. Si hay cosas, las recorro con un bucle for
                    if (tareas.isEmpty()) {
                        System.out.println("No hay tareas pendientes.");
                    } else {
                        for (int i = 0; i < tareas.size(); i++) {
                            // Le sumo 1 a la 'i' para que en pantalla la lista empiece en 1 y no en 0
                            System.out.println((i + 1) + ". " + tareas.get(i));
                        }
                    }
                    break;
                case 3:
                    System.out.print("Introduce el numero a eliminar: ");
                    // Le resto 1 al número que mete el usuario porque los índices del ArrayList empiezan en 0
                    int indice = Integer.parseInt(scanner.nextLine()) - 1;

                    // Compruebo que el número de tarea que quiere borrar existe de verdad
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
        // Cierro el scanner al terminar para liberar recursos
        scanner.close();
    }
}