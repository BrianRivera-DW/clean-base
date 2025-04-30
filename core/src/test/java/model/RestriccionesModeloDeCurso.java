package model;

import curso.modelo.Curso;
import curso.modelo.Nivel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class RestriccionesModeloDeCurso {


    @Test
    public void crearCurso_CamposIncompletosNull_ExcepcionCampos() {

        //Test para el nombre null  o vació
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {Curso miCurso= Curso.Instancia(null,null,null);});
        Assertions.assertEquals("Error, los campos no puede estar vacio", exception.getMessage());

    }

    @Test
    public void crearCurso_CamposNombreStringEnBlanco_ExcepcionCampos() {

        //Cadenas de string en blanco
        RuntimeException exception= Assertions.assertThrows(RuntimeException.class, () -> {Curso miCurso= Curso.Instancia(" ",null,null);});
        Assertions.assertEquals("Error, los campos no puede estar vacio", exception.getMessage());
    }

    @Test
    public void crearCurso_FechaCierre_ExcepcionFecha() {

        //Test evaluar si la fecha de cierre no es anterior a la fecha actual
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {Curso miCurso= Curso.Instancia("Programacion Anvanzada I", LocalDate.of(2024,7,3), Nivel.INICIAL);});
        Assertions.assertEquals("Error, la fecha de cierre no puede ser anterior a la fecha Actual",exception.getMessage());

    }
}
