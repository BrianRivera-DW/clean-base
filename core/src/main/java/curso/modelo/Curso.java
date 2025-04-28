package curso.modelo;

import curso.exception.ExceptionCamposObligatorios;
import curso.exception.ExceptionFechaCierreIncorrecta;

import java.time.LocalDate;

public class Curso {
    private String nombre;
    private LocalDate fechaCierreInscripcion;
    private Nivel nivel;

    private Curso(String nombre, LocalDate fechaCierreInscripcion, Nivel nivel) {
        LocalDate fechaActual = LocalDate.now();
        if(nombre==null || nombre.trim().isEmpty() || fechaCierreInscripcion==null || nivel==null){
            throw new ExceptionCamposObligatorios("Error, los campos no puede estar vacio");
        }
        if(fechaCierreInscripcion.isBefore(fechaActual)){
            throw new ExceptionFechaCierreIncorrecta("Error, la fecha de cierre no puede ser anterior a la fecha Actual");
        }
        this.nombre = nombre;
        this.fechaCierreInscripcion = fechaCierreInscripcion;
        this.nivel = nivel;
    }

    public static Curso Instancia(String nombre, LocalDate fechaInicio, Nivel nivel) {
    return new Curso(nombre,fechaInicio,nivel);
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaCierreInscripcion;
    }

    public Nivel getNivel() {
        return nivel;
    }
}
