package curso.usecase;

import curso.modelo.Curso;
import curso.output.ICrearCursoInput;
import curso.repositorio.ICrearCursoRepositorio;

public class CrearCursoUseCase implements ICrearCursoInput {

    private final ICrearCursoRepositorio crearCursoRepositorio;

    public CrearCursoUseCase(ICrearCursoRepositorio crearCursoRepositorio) {
        this.crearCursoRepositorio = crearCursoRepositorio;
    }

    @Override
    public boolean crearCurso(Curso curso) {
        if(!crearCursoRepositorio.exits(curso)){
            crearCursoRepositorio.guardarCurso(curso);
        }
        return false;
    }
}
