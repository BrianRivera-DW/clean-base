package curso.modelo;

import curso.exception.ExceptionCamposObligatorios;
import curso.exception.ExceptionFechaCierreIncorrecta;

import java.time.LocalDate;

public class Curso {
    private String nombre;
    private LocalDate fechaInicio;
    private Nivel nivel;

    private Curso(String nombre, LocalDate fechaInicio, Nivel nivel) {
        LocalDate fechaActual = LocalDate.now();
        if(nombre==null || nombre.trim().isEmpty() || fechaInicio==null || nivel==null){
            throw new ExceptionCamposObligatorios("Error ,los campos no puede estar vacio");
        }
        if(fechaInicio.isBefore(fechaActual)){
            throw new ExceptionFechaCierreIncorrecta("Error ,la fecha de cierre no puede ser anterior a la fecha Actual");
        }
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.nivel = nivel;
    }

    public static Curso Instancia(String nombre, LocalDate fechaInicio, Nivel nivel) {
    return new Curso(nombre,fechaInicio,nivel);
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public Nivel getNivel() {
        return nivel;
    }
}
