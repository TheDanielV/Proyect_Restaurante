package org.proyect.restaurant.model;


import org.junit.Assert;
import org.junit.Test;

public class ValidacionTest{
    public ValidacionTest() {
    }

    @Test
    public void give_cedula_when_validate_correct_then() {
        Validacion validacion = new Validacion();
        Assert.assertFalse(Validacion.validarCedula("0192"));
    }

    @Test
    public void give_cedula_when_validate_incorrect_then() {
        Validacion validacion = new Validacion();
        String numCedula = "1726004615";
        boolean asignado = Validacion.validarCedula(numCedula);
        Assert.assertTrue(asignado);
    }

    @Test
    public void give_name_when_validate_correct_then() {
        Validacion validacion = new Validacion();
        String nombre = "Daniel";
        boolean asignado = Validacion.validarNombre(nombre);
        Assert.assertTrue(asignado);
    }

    @Test
    public void give_lastname_when_validate_correct_then() {
        Validacion validacion = new Validacion();
        String apellido = "Vargas";
        boolean asignado = Validacion.validarApellido(apellido);
        Assert.assertTrue(asignado);
    }

    @Test
    public void give_address_lenght_when_validate_incorrect_then() {
        Validacion validacion = new Validacion();
        String address = "casa";
        boolean asignado = Validacion.validarDireccion(address);
        Assert.assertFalse(asignado);
    }

    @Test
    public void give_email_when_validate_correct_then() {
        Validacion validacion = new Validacion();
        String correo = "theadmin@gmail.com";
        boolean asignado = Validacion.validarCorreoElectronico(correo);
        Assert.assertTrue(asignado);
    }
}
