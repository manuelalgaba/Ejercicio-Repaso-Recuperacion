import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Empleado> empleados = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    altaEmpleado();
                    break;
                case 2:
                    bajaEmpleado();
                    break;
                case 3:
                    modificacionEmpleado();
                    break;
                case 4:
                    consultaDatosEmpleado();
                    break;
                case 5:
                    ordenarListaEmpleados();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);
    }

    private static void mostrarMenu() {
        System.out.println("MENU:");
        System.out.println("1. ALTA EMPLEADO");
        System.out.println("2. BAJA EMPLEADO");
        System.out.println("3. MODIFICACIÓN EMPLEADO");
        System.out.println("4. CONSULTA DATOS EMPLEADO");
        System.out.println("5. ORDENAR ALFABÉTICAMENTE LISTA EMPLEADOS");
        System.out.println("6. SALIR");
        System.out.print("Seleccione una opción: ");
    }

    public static void altaEmpleado() {
        System.out.println("Seleccione el tipo de empleado:");
        System.out.println("1. Programador");
        System.out.println("2. Administrativo");
        System.out.println("3. Profesor");
        int tipoEmpleado = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese DNI: ");
        String dni = scanner.nextLine();
        System.out.println("Ingrese Nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese Dirección: ");
        String direccion = scanner.nextLine();
        System.out.println("Ingrese Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.println("Ingrese fecha de contrato: ");
        String fechaContrato = scanner.nextLine();

        switch (tipoEmpleado) {
            case 1:
                System.out.println("Ingrese Nivel (Programador, Analista, Jefe de proyecto): ");
                String nivel = scanner.nextLine();
                System.out.println("Ingrese Teconologias (Separadas por coma): ");
                String tecnologiasInput = scanner.nextLine();
                List<String> tecnologias = List.of(tecnologiasInput.split(","));

                Empleado programador = new Programador(dni, nombre, direccion, telefono, fechaContrato, nivel,
                        tecnologias);
                empleados.add(programador);

                scanner.nextLine();
                break;
            case 2:
                System.out.println("Ingrese Puesto: ");
                String puesto = scanner.nextLine();
                System.out.print("Ingrese Categoría (A, B, C, D, E): "); // Es un ENUM
                String categoriaInput = scanner.nextLine();
                Categoria categoria = Categoria.valueOf(categoriaInput.toUpperCase());

                Empleado administrativo = new Administrativo(dni, nombre, direccion, telefono, fechaContrato, puesto,
                        categoria);
                empleados.add(administrativo);

                scanner.nextLine();
                break;
            case 3:
                System.out.println("Ingrese Tiempo de Experiencia (en años): ");
                int tiempoExperiencia = scanner.nextInt();
                System.out.println("Ingrese Cursos (Separados por coma): ");
                String cursosInput = scanner.nextLine();
                List<String> cursos = List.of(cursosInput.split(","));

                Empleado profesor = new Profesor(dni, nombre, direccion, telefono, fechaContrato, tiempoExperiencia,
                        cursos);
                empleados.add(profesor);

                scanner.nextLine();
                break;
            default:
                System.out.println("Tipo de empleado no válido.");
                break;
        }

        System.out.println("Empleado dado de alta exitosamente.");
    }

    private static Empleado buscarEmpleadoPorDni(String dni) {
        for (int i = 0; i < empleados.size(); i++) {
            Empleado empleado = empleados.get(i);
            if (empleado.getDni().equals(dni)) {
                return empleado;
            }
        }
        return null;
    }

    public static void consultaDatosEmpleado() {
        System.out.println("Ingrese el DNI del empleado a consultar: ");
        String dni = scanner.nextLine();

        Empleado empleado = buscarEmpleadoPorDni(dni);

        if (empleado != null) {
            System.out.println(empleado);
        } else {
            System.out.println("Empleado no encontrado");
        }
    }

    public static void bajaEmpleado() {
        System.out.println("Ingrese el DNI del empleado a consultar: ");
        String dni = scanner.nextLine();

        Empleado empleado = buscarEmpleadoPorDni(dni);

        if (empleado != null) {
            empleados.remove(empleado);
            System.out.println("Empleado borrado exitosamente");
        } else {
            System.out.println("Empleado no encontrado");
        }
    }

    public static void modificacionEmpleado() {
        System.out.print("Ingrese el DNI del empleado a modificar: ");
        String dni = scanner.nextLine();

        Empleado empleado = buscarEmpleadoPorDni(dni);

        if (empleado != null) {
            System.out.println("Seleccione el dato a modificar");
            System.out.println("1. Nombre");
            System.out.println("2. Dirección");
            System.out.println("3. Teléfono");
            System.out.println("4. Fecha de Contrato");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nuevo Nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    empleado.setNombre(nuevoNombre);
                    break;
                case 2:
                    System.out.println("Ingrese la nueva dirección");
                    String nuevaDireccion = scanner.nextLine();
                    empleado.setDireccion(nuevaDireccion);
                    break;
                case 3:
                    System.out.print("Ingrese el nuevo teléfono: ");
                    String nuevoTelefono = scanner.nextLine();
                    empleado.setTelefono(nuevoTelefono);
                    break;
                case 4:
                    System.out.print("Ingrese la nueva fecha de contrato: ");
                    String nuevaFechaContrato = scanner.nextLine();
                    empleado.setFechaContrato(nuevaFechaContrato);
                    break;
                default:
                    break;
            }

            // Esto es para modificar los atributos específicos
            if (empleado instanceof Programador) {
                Programador programador = (Programador) empleado;
                System.out.println("Seleccione el dato específico a modificar:");
                System.out.println("1. Nivel");
                System.out.println("2. Tecnologías");
                int opcionEspecifica = scanner.nextInt();
                scanner.nextLine();

                switch (opcionEspecifica) {
                    case 1:
                        System.out.print("Ingrese el nuevo nivel: ");
                        String nuevoNivel = scanner.nextLine();
                        programador.setNivel(nuevoNivel);
                        break;
                    case 2:
                        System.out.print("Ingrese las nuevas tecnologías (separadas por coma): ");
                        String nuevasTecnologiasInput = scanner.nextLine();
                        List<String> nuevasTecnologias = List.of(nuevasTecnologiasInput.split(","));
                        programador.setTecnologias(nuevasTecnologias);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } else if (empleado instanceof Administrativo) {
                Administrativo administrativo = (Administrativo) empleado;
                System.out.println("Seleccione el dato específico a modificar:");
                System.out.println("1. Puesto");
                System.out.println("2. Categoría");
                int opcionEspecifica = scanner.nextInt();
                scanner.nextLine();

                switch (opcionEspecifica) {
                    case 1:
                        System.out.print("Ingrese el nuevo puesto: ");
                        String nuevoPuesto = scanner.nextLine();
                        administrativo.setPuesto(nuevoPuesto);
                        break;
                    case 2:
                        System.out.print("Ingrese la nueva categoría: ");
                        String nuevaCategoriaInput = scanner.nextLine();
                        Categoria nuevaCategoria = Categoria.valueOf(nuevaCategoriaInput.toUpperCase());
                        administrativo.setCategoria(nuevaCategoria);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } else if (empleado instanceof Profesor) {
                Profesor profesor = (Profesor) empleado;
                System.out.println("Seleccione el dato específico a modificar:");
                System.out.println("1. Tiempo de Experiencia");
                System.out.println("2. Cursos");
                int opcionEspecifica = scanner.nextInt();
                scanner.nextLine();

                switch (opcionEspecifica) {
                    case 1:
                        System.out.print("Ingrese el nuevo tiempo de experiencia: ");
                        int nuevoTiempoExperiencia = scanner.nextInt();
                        scanner.nextLine();
                        profesor.setTiempoExperiencia(nuevoTiempoExperiencia);
                        break;
                    case 2:
                        System.out.print("Ingrese los nuevos cursos (separados por coma): ");
                        String nuevosCursosInput = scanner.nextLine();
                        List<String> nuevosCursos = List.of(nuevosCursosInput.split(","));
                        profesor.setCursos(nuevosCursos);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            }

            System.out.println("Datos del empleado actualizados exitosamente.");
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private static void ordenarListaEmpleados() {
        Collections.sort(empleados, new Comparator<Empleado>() {
            @Override
            public int compare(Empleado e1, Empleado e2) {
                return e1.getNombre().compareTo(e2.getNombre());
            }
        });

        System.out.println("Lista de empleados ordenada alfabéticamente por nombre:");
        for (int i = 0; i < empleados.size(); i++) {
            System.out.println(empleados.get(i));
        }
    }

}
