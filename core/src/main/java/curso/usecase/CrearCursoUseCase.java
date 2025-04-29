package curso.usecase;

import curso.exception.ExceptionErrorAlGuardarCurso;
import curso.exception.ExceptionExisteCurso;
import curso.modelo.Curso;
import curso.input.ICrearCursoInput;
import curso.repositorio.ICrearCursoRepositorio;

public class CrearCursoUseCase implements ICrearCursoInput {

    private final ICrearCursoRepositorio crearCursoRepositorio;

    public CrearCursoUseCase(ICrearCursoRepositorio crearCursoRepositorio) {
        this.crearCursoRepositorio = crearCursoRepositorio;
    }

    @Override
    public boolean crearCurso(Curso curso) throws ExceptionExisteCurso, ExceptionErrorAlGuardarCurso {

        if(crearCursoRepositorio.existe(curso)){
            throw new ExceptionExisteCurso();
        }
        if(!crearCursoRepositorio.guardarCurso(curso)){
            throw new ExceptionErrorAlGuardarCurso();
        }else{
            return true;
        }
    }
}
