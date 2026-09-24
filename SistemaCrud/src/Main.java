
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GestorProductos gestor = new GestorProductos();

        int opcion;

        do {
            System.out.println("\n===== SISTEMA DE GESTION DE PRODUCTOS =====");
            System.out.println("1. Crear producto");
            System.out.println("2. Leer productos");
            System.out.println("3. Actualizar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese el ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Ingrese el nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Ingrese el precio: ");
                    double precio = sc.nextDouble();

                    Producto producto = new Producto(id, nombre, precio);
                    gestor.agregarProducto(producto);

                    System.out.println("Producto agregado correctamente.");
                    break;

                case 2:
                    System.out.println("\n===== LISTA DE PRODUCTOS =====");
                    gestor.mostrarProductos();
                    break;

                case 3:
                    System.out.print("Ingrese el ID del producto: ");
                    int idActualizar = sc.nextInt();

                    System.out.print("Ingrese el nuevo precio: ");
                    double nuevoPrecio = sc.nextDouble();

                    if (gestor.actualizarProducto(idActualizar, nuevoPrecio)) {
                        System.out.println("Producto actualizado correctamente.");
                    } else {
                        System.out.println("El producto no existe.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el ID del producto: ");
                    int idEliminar = sc.nextInt();

                    if (gestor.eliminarProducto(idEliminar)) {
                        System.out.println("Producto eliminado correctamente.");
                    } else {
                        System.out.println("El producto no existe.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 5);

        sc.close();
    }
}
