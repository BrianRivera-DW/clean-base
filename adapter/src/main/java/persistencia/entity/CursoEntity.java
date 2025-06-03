package persistencia.entity;

import curso.modelo.Nivel;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name="Cursos")

public class CursoEntity {

    @Id
    @Column(name="idcurso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto incremental en mysql
    private Integer idCurso;

    @Column(name="nombre")
    private String nombre;
    @Column(name="fechacierreinscripcion")
    private LocalDate fechaCierreInscripcion;
    @Column(name="nivel")
    private Nivel nivel;

    public CursoEntity() {
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaCierreInscripcion() {
        return fechaCierreInscripcion;
    }

    public void setFechaCierreInscripcion(LocalDate fechaCierreInscripcion) {
        this.fechaCierreInscripcion = fechaCierreInscripcion;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }
}
