package curso.usecase;

import curso.modelo.Curso;
import curso.output.ICrearCursoInput;
import curso.repositorio.ICrearCursoRepositorio;

import java.time.LocalDate;

public class CrearCursoUseCase implements ICrearCursoInput {

    private final ICrearCursoRepositorio crearCursoRepositorio;

    public CrearCursoUseCase(ICrearCursoRepositorio crearCursoRepositorio) {
        this.crearCursoRepositorio = crearCursoRepositorio;
    }

    @Override
    public boolean crearCurso(Curso curso) {
        LocalDate fechaActual = LocalDate.now();
        if(curso.getNombre()==null || curso.getNombre().trim().isEmpty() || curso.getFechaInicio()==null || curso.getNivel()==null){
            throw new RuntimeException("Error ,los campos no puede estar vacio");
        }
        if(curso.getFechaInicio().isBefore(fechaActual)){
            throw new RuntimeException("Error ,la fecha de cierre no puede ser anterior");
        }
        if(!crearCursoRepositorio.exits(curso)){
            return crearCursoRepositorio.guardarCurso(curso);

        }
        return false;
    }
}
