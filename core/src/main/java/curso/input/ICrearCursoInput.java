package curso.input;

import curso.exception.ExceptionErrorAlGuardarCurso;
import curso.exception.ExceptionExisteCurso;
import curso.modelo.Curso;

public interface ICrearCursoInput {
    boolean crearCurso(Curso curso) throws ExceptionExisteCurso, ExceptionErrorAlGuardarCurso;
}
