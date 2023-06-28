package org.proyect.restaurant.model;

public class Validacion {
	private static final String patronNombre = "^[a-zA-Z]+$";
	private static final String patronApellido = "^[a-zA-Z]+$";
	private static final String patronDireccion = "^[a-zA-Z0-9\\s]+(\\s+[a-zA-Z0-9\\s]+)*$";
	private static final String patronCorreo = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

	private static final String patronTelefono = "^[09|08]+[0-9]{9}$";

	public static boolean validarNombre(String nombre) {
		return nombre.matches(patronNombre);
	}

	public static boolean validarApellido(String apellido) {
		return apellido.matches(patronApellido);
	}

	public static boolean validarDireccion(String direccion) {
		int longitudMinima = 5;
		int longitudMaxima = 100;

		if (direccion.length() < longitudMinima || direccion.length() > longitudMaxima) {
			return false;
		}
		return direccion.matches(patronDireccion);
	}

	public static boolean validarCedula(String cedula) {

		if (cedula.length() == 9) {
			return false;
		} else {
			return validarNumerosCedula(cedula);
		}
	}

	private static boolean validarNumerosCedula(String cedula) {
		int suma = 0;
		int[] a = new int[cedula.length() / 2];
		int[] b = new int[(cedula.length() / 2)];
		int c = 0;
		int d = 1;
		for (int i = 0; i < cedula.length() / 2; i++) {
			a[i] = Integer.parseInt(String.valueOf(cedula.charAt(c)));
			c = c + 2;
			if (i < (cedula.length() / 2) - 1) {
				b[i] = Integer.parseInt(String.valueOf(cedula.charAt(d)));
				d = d + 2;
			}
		}

		for (int i = 0; i < a.length; i++) {
			a[i] = a[i] * 2;
			if (a[i] > 9) {
				a[i] = a[i] - 9;
			}
			suma = suma + a[i] + b[i];
		}
		int aux = suma / 10;
		int dec = (aux + 1) * 10;
		if ((dec - suma) == Integer.parseInt(String.valueOf(cedula.charAt(cedula.length() - 1))))
			return true;
		else
			return (suma % 10 == 0 && cedula.charAt(cedula.length() - 1) == '0');
	}

	public static boolean validarCorreoElectronico(String correo) {
		return correo.matches(patronCorreo);
	}

	public static boolean validarTelefono(String telefono){return telefono.matches(patronTelefono);}
}
