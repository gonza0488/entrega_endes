package proyecto_Reto_Java;

import java.util.Scanner;

public class reto {

	// clase Scanner
	static Scanner sc = new Scanner(System.in);

	// arrays necesarios donde almacenar los Nombres Usuarios y las contraseñas
	static String[] nombres = new String[100];
	static String[] usuarios = new String[100];
	static String[] contraseñas = new String[100];
	static int contadorUsuarios = 0;

	// arrays para los eventos
	static String[] nombresEventos = new String[100];
	static String[] fechasEventos = new String[100];
	static String[] ubicacionesEventos = new String[100];
	static int contadorEventos = 0;

	// array para las inscripciones
	static int[][] inscripciones = new int[100][2]; // [usuario, evento]
	static int contadorInscripciones = 0;

	// main
	public static void main(String[] args) {
		int opcion;
		do {
			opcion = menu();
			sc.nextLine();

			switch (opcion) {
			case 1:
				if (!registrarUsuario()) {
					System.out.println("no se ha podido registrar el usuario");
				}
				break;
			case 2:
				if (!registrarEvento()) {
					System.out.println("No se ha podido completar el registro del evento");
				}
				break;
			case 3:
				if (!realizarInscripcion()) {
					System.out.println("No se ha podido completar la inscripción al evento");
				}
				break;
			case 4:
				System.out.println("El total de usuarios es: " + mostrarUsuarios());
				break;
			case 5:
				System.out.println("El total de eventos es : " + mostrarEventos());
				break;
			case 6:
				System.out.println("El total de inscripciones es : " + mostrarInscripciones());
				break;
			case 0:
				System.out.println("Gracias por usar");
				break;
			default:
				System.out.println("Introduce otra opcion, la introducida no es valida");
			}
		} while (opcion != 0);
	}

	public static int menu() {
		System.out.println("GESTION DE EVENTOS SOSTENIBLES");
		System.out.println("1 - Registrar usuario");
		System.out.println("2 - Registrar evento");
		System.out.println("3 - Realizar inscripcion");
		System.out.println("4 - Mostrar usuarios");
		System.out.println("5 - Mostrar eventos");
		System.out.println("6 - Mostrar inscripciones");
		System.out.println("0 - Salir");
		System.out.print("¿Que opción vas a elegir?: ");
		return sc.nextInt();
	}

	public static int buscarUsuario(String usuario) {
		for (int i = 0; i < contadorUsuarios; i++) {
			if (usuarios[i].equals(usuario)) {
				return i;
			}
		}
		return -1;
	}

	// funcion para comprobar si se ha hecho ya una inscripcion
	public static boolean comprobarIncripcion(int indiceUsuario, int indiceEvento) {
		for (int i = 0; i < contadorInscripciones; i++) {
			if (inscripciones[i][0] == indiceUsuario && inscripciones[i][1] == indiceEvento) {
				return true;
			}
		}
		return false;
	}

	// funciones mostrar
	public static int mostrarUsuarios() {
		System.out.println("USUARIOS REGISTRADOS");
		for (int i = 0; i < contadorUsuarios; i++) {
			System.out.println("Usuario " + i + ": " + nombres[i] + " " + usuarios[i]);
		}
		return contadorUsuarios;
	}

	public static int mostrarEventos() {
		System.out.println("EVENTOS REGISTRADOS");
		for (int i = 0; i < contadorEventos; i++) {
			System.out.println("Evento " + i + ": " + nombresEventos[i]);
			System.out.println("  Fecha: " + fechasEventos[i]);
			System.out.println("  Ubicacion: " + ubicacionesEventos[i]);
		}
		return contadorEventos;
	}

	public static int mostrarInscripciones() {
		System.out.println("INSCRIPCIONES HECHAS");
		for (int i = 0; i < contadorInscripciones; i++) {
			System.out.println("Inscripcion " + i + ":");
			System.out.println("  Usuario: " + nombres[inscripciones[i][0]]);
			System.out.println("  Evento: " + nombresEventos[inscripciones[i][1]]);
		}
		return contadorInscripciones;
	}
}