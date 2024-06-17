package Tiendas;

import java.io.*;
import java.util.*;

public class gestionMain implements Serializable {
    static final Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        final Map<String, List<Producto>> listadotiendas = new TreeMap<>();
        try (ObjectInputStream ios = new ObjectInputStream(new FileInputStream("producto.dat"))) {
            Map<String, List<Producto>> mapaRecuperado = (Map<String, List<Producto>>) ios.readObject();
            listadotiendas.putAll(mapaRecuperado);
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean salir = false;
        while (!salir) {
            switch (dibujarMenutiendas()) {
                case 1:
                    crearTienda(listadotiendas);
                    break;
                case 2:
                    listartiendas(listadotiendas);
                    break;
                case 3:
                    eliminartienda(listadotiendas);
                    break;
                case 4:
                    seleccionartienda(listadotiendas);
                    break;
                case 0:
                    salir = true;
                    break;
            }
        }

        entrada.close();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("producto.dat"))) {
            oos.writeObject(listadotiendas);
        }
    }
    public static int dibujarMenutiendas() {
        System.out.println();
        System.out.println("Elige una opción:");
        System.out.println("1. Crear una tienda");
        System.out.println("2. Listar Tiendas");
        System.out.println("3. Eliminar tienda");
        System.out.println("4. Seleccionar una tienda");
        System.out.println("0. Salir");

        int opcion = entrada.nextInt();
        entrada.nextLine();

        return opcion;
    }
    private static void crearTienda(Map<String, List<Producto>> listadotTiendas) {
        String grupo = leerTienda();
        if (listadotTiendas.containsKey(grupo)) {
            System.out.println("la tienda ya existe");
        } else {
            listadotTiendas.put(grupo, new ArrayList<>());
            System.out.println("tienda creada con éxito");
        }
    }
    public static String leerTienda() {
        System.out.print("Tienda: ");
        return entrada.nextLine();
    }
    public static void listartiendas(Map<String, List<Producto>> listado) {
        for (String grupo : listado.keySet()) {
            System.out.println("> " + grupo);
        }
    }
    private static void eliminartienda(Map<String, List<Producto>> listadoTiendas) {
        String grupo = leerTienda();
        if (!listadoTiendas.containsKey(grupo)) {
            System.out.println("la tienda no existe");
        } else {
            listadoTiendas.remove(grupo);
            System.out.println("tienda eliminado con éxito");
        }
    }
    private static void seleccionartienda(Map<String, List<Producto>> listadoTiendas) {
        String grupo = leerTienda();
        List<Producto> listadoEstudiantes = listadoTiendas.get(grupo);

        if (null == listadoEstudiantes) {
            System.out.println("la tienda no existe");
        } else {
            mainEstudiantes(listadoEstudiantes);
        }
    }
    private static void mainEstudiantes(List<Producto> listadoProductos) {
        boolean salir = false;
        while (!salir) {
            switch (dibujarMenuProductos()) {
                case 1:
                    listarProductos(listadoProductos);
                    break;
                case 2:
                    anyadirProductos(listadoProductos);
                    break;
                case 3:
                    insertarProductos(listadoProductos);
                    break;
                case 4:
                    ordenarProductosPorPrecio(listadoProductos);
                    break;
                case 5:
                    eliminarProducto(listadoProductos);
                    break;
                case 6:
                    eliminarProductos(listadoProductos);
                    break;
                case 0:
                    salir = true;
            }
        }
    }
    private static int dibujarMenuProductos() {
        System.out.println();
        System.out.println("Elige una opción:");
        System.out.println("1. Listar Producto");
        System.out.println("2. Añadir un producto al final de la tienda ");
        System.out.println("3. Insertar un producto en la posición indicada");
        System.out.println("4. Ordenar el listado por precio");
        System.out.println("5. Eliminar el producto de la posición indicada");
        System.out.println("6. Eliminar todos los productos de la clase");
        System.out.println("0. Salir");

        int opcion = entrada.nextInt();
        entrada.nextLine();

        return opcion;
    }
    private static void listarProductos(List<Producto> listadoProductos) {
        for (int i = 0; i < listadoProductos.size(); i++) {
            System.out.printf("%02d: %s\n", i + 1, listadoProductos.get(i));
        }
    }
    private static void anyadirProductos(List<Producto> listadoProductos) {
        Producto p = leerProducto();
        listadoProductos.add(p);
        System.out.println("Producto añadido");
    }
    private static void insertarProductos(List<Producto> listadoEstudiantes) {
        int pos = leerPosicion(listadoEstudiantes.size() + 1);
        Producto p = leerProducto();
        listadoEstudiantes.add(pos, p);
        System.out.println("Producto insertado");
    }
    private static void ordenarProductosPorPrecio(List<Producto> listadoProductos) {
        listadoProductos.sort(new Comparator<Producto>() {
            @Override
            public int compare(Producto o1, Producto o2) {
                return (int) (o1.getPrecio() - o2.getPrecio());
            }
        });
    }
    private static void eliminarProducto(List<Producto> listadoProductos) {
        int pos = leerPosicion(listadoProductos.size());
        Producto p = listadoProductos.remove(pos);
        System.out.println("Estudiante eliminado: " + p);
    }
    private static void eliminarProductos(List<Producto> listadoProductos) {
        listadoProductos.clear();
        System.out.println("Estudiantes del grupo eliminados");
    }
    public static Producto leerProducto() {
        String marca;
        String descripcion;
        float precio;

        System.out.print("Marca: ");
        marca = entrada.nextLine();
        System.out.print("Descripcion: ");
        descripcion = entrada.nextLine();
        System.out.print("Precio: ");
        precio = entrada.nextInt();
        entrada.nextLine();

        return new Producto(marca,descripcion,precio);
    }
    public static int leerPosicion(int max) {
        int num;

        do {
            System.out.printf("Posición [1-%d]: ", max);
            num = entrada.nextInt();
        } while (num < 1 || num > max);
        entrada.nextLine();


        return num - 1;
    }
}
