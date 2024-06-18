import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Socio> socios = new ArrayList<>();
    private static List<Pista> pistas = new ArrayList<>();
    private static List<Reserva> reservas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        inicializarDatos();
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    crearInvitado();
                    break;
                case 2:
                    realizarReserva();
                    break;
                case 3:
                    modificarReserva();
                    break;
                case 4:
                    eliminarReserva();
                    break;
                case 5:
                    consultarReservasPorFecha();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);
    }

    private static void inicializarDatos() {
        socios.add(new Socio("12345678A", "Juan Perez", "555-1234", "juan@example.com", "2022-01-01", 50.0, new ArrayList<>()));
        socios.add(new Socio("87654321B", "Maria Gomez", "555-5678", "maria@example.com", "2022-02-01", 60.0, new ArrayList<>()));
        
        pistas.add(new Pista(1, "Pista de Padel", "Pista de padel profesional", "Red y palas", 20));
        pistas.add(new Pista(2, "Pista de Tenis", "Pista de tenis profesional", "Red y raquetas", 30));
    }

    private static void mostrarMenu() {
        System.out.println("MENU:");
        System.out.println("1. Crear Invitado de un Socio");
        System.out.println("2. Realizar Reserva");
        System.out.println("3. Modificar Reserva");
        System.out.println("4. Eliminar Reserva");
        System.out.println("5. Consultar Reservas por Fecha");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void crearInvitado() {
        System.out.println("Ingrese el NIF del socio: ");
        String nifSocio = scanner.nextLine();

        Socio socio = buscarSocioPorNif(nifSocio);

        if (socio != null) {
            if (socio.getInvitados().size() < 5) { // Verificamos como max 5 invitados
                System.out.print("Ingrese NIF del invitado: ");
                String nifInvitado = scanner.nextLine();
                System.out.print("Ingrese Nombre del invitado: ");
                String nombreInvitado = scanner.nextLine();
                System.out.print("Ingrese Teléfono del invitado: ");
                String telefonoInvitado = scanner.nextLine();
                System.out.print("Ingrese Email del invitado: ");
                String emailInvitado = scanner.nextLine();
                System.out.print("Ingrese Relación del invitado (familiar o amistad): ");
                String relacionInvitado = scanner.nextLine();

                Invitado invitado = new Invitado(nifInvitado, nombreInvitado, telefonoInvitado, emailInvitado,
                        relacionInvitado);
                socio.addInvitado(invitado);
            } else {
                System.out.println("Un socio no puede tener más de 5 invitados.");
            }
        } else {
            System.out.println("Socio no encontrado.");
        }

    }

    private static Socio buscarSocioPorNif(String nif) {
        for (int i = 0; i < socios.size(); i++) {
            if (socios.get(i).getNif().equals(nif)) {
                return socios.get(i);
            }
        }
        return null;
    }

    private static boolean reservaConflicto(int idPista, String fechaReserva, int turno) {
        for (int i = 0; i < reservas.size(); i++) {
            Reserva reserva = reservas.get(i);
            if (reserva.getIdPista() == idPista && reserva.getFechaReserva().equals(fechaReserva)
                    && reserva.getTurno() == turno) {
                return true;
            }
        }
        return false;
    }

    private static void realizarReserva() {
        System.out.println("Ingrese el NIF del socio");
        String nifSocio = scanner.nextLine();

        Socio socio = buscarSocioPorNif(nifSocio);
        if (socio == null) {
            System.out.println("Socio no encontrado.");
            return;
        }

        System.out.println("Ingrese el ID de la pista: ");
        int idPista = scanner.nextInt();
        scanner.nextLine();

        Pista pista = buscarPistaPorId(idPista);
        if (pista == null) {
            System.out.println("Pista no encontrada.");
            return;
        }

        System.out.print("Ingrese la fecha de la reserva (yyyy-MM-dd): ");
        String fechaReserva = scanner.nextLine();

        System.out.print("Ingrese el turno (1-12): ");
        int turno = scanner.nextInt();
        scanner.nextLine();

        if (reservaConflicto(idPista, fechaReserva, turno)) {// verificamos que exista una reserva ya
            System.out.println("Ya existe una reserva para esta fecha, turno y pista");
            return;
        }

        int idReserva = reservas.size() + 1;
        Reserva reserva = new Reserva(idReserva, idPista, nifSocio, fechaReserva, turno);
        reservas.add(reserva);
    }

    private static Pista buscarPistaPorId(int idPista) {
        for (int i = 0; i < pistas.size(); i++) {
            if (pistas.get(i).getIdPista() == idPista) {
                return pistas.get(i);
            }
        }
        return null;
    }

    private static void modificarReserva() {
        System.out.println("Ingrese el ID de la pista: ");
        int idReserva = scanner.nextInt();
        scanner.nextLine();

        Reserva reserva = buscarReservaPorId(idReserva);
        if (reserva == null) {
            System.out.println("Reserva no encontrada.");
            return;
        }

        System.out.println("Reserva actual: " + reserva);
        System.out.println("Seleccione el dato a modificar:");
        System.out.println("1. Fecha de Reserva");
        System.out.println("2. Turno");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                System.out.print("Ingrese la nueva fecha de la reserva (yyyy-MM-dd): ");
                String nuevaFechaReserva = scanner.nextLine();
                if (reservaConflicto(reserva.getIdPista(), nuevaFechaReserva, reserva.getTurno())) {
                    System.out.println("Ya existe una reserva para esta pista, fecha y turno.");
                    return;
                }
                reserva.setFechaReserva(nuevaFechaReserva);
                break;
            case 2:
                System.out.print("Ingrese el nuevo turno (1-12): ");
                int nuevoTurno = scanner.nextInt();
                scanner.nextLine();
                if (reservaConflicto(reserva.getIdPista(), reserva.getFechaReserva(), nuevoTurno)) {
                    System.out.println("Ya existe una reserva para esta pista, fecha y turno.");
                    return;
                }
                reserva.setTurno(nuevoTurno);
                break;
            default:
                break;
        }

    }

    private static Reserva buscarReservaPorId(int idReserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getIdReserva() == idReserva) {
                return reservas.get(i);
            }
        }
        return null;
    }

    private static void eliminarReserva() {
        System.out.println("Ingrese el ID de la pista: ");
        int idReserva = scanner.nextInt();
        scanner.nextLine();

        Reserva reserva = buscarReservaPorId(idReserva);
        if (reserva == null) {
            System.out.println("Reserva no encontrada.");
            return;
        }

        reservas.remove(reserva);
        System.out.println("Reserva eliminada exitosamente.");
    }

    private static void consultarReservasPorFecha() {
        System.out.print("Ingrese la fecha para consultar reservas (yyyy-mm-dd): ");
        String fechaConsulta = scanner.nextLine();

        boolean reservasEncontradas = false;

        for(int i = 0; i < reservas.size(); i++){
            Reserva reserva = reservas.get(i);
            if (reserva.getFechaReserva().equals(fechaConsulta)) {
                Socio socio = buscarSocioPorNif(reserva.getNifSocio());
                Pista pista = buscarPistaPorId(reserva.getIdPista());

                System.out.println("ID Reserva: " + reserva.getIdReserva());
                System.out.println("ID Pista: " + reserva.getIdPista());
                System.out.println("Nombre Socio: " + socio.getNombre());
                System.out.println("Teléfono Socio: " + socio.getTelefono());
                System.out.println("Descripción Pista: " + pista.getDescripcion());
                System.out.println("Equipamiento Pista: " + pista.getEquipamiento());
                System.out.println("Turno: " + reserva.getTurno());
                System.out.println("-------------------------");

                reservasEncontradas = true;
            }
        }

        if (!reservasEncontradas) {
            System.out.println("No se encontraron reservas para la fecha proporcionada.");
        }
    }
}
