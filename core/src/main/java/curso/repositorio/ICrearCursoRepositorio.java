package curso.repositorio;

import curso.modelo.Curso;

public interface ICrearCursoRepositorio {
    boolean exits(Curso miCurso);

    boolean guardarCurso(Curso miCurso);
}
