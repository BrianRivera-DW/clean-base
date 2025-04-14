package curso.modelo;

import java.time.LocalDate;

public class Curso {
    private String nombre;
    private LocalDate fechaInicio;
    private Nivel nivel;

    private Curso(String nombre, LocalDate fechaInicio, Nivel nivel) {
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

    public Nivel getNivel() {
        return nivel;
    }
}
