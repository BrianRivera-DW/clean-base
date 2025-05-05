package curso.repositorio;

import curso.modelo.Curso;

public interface ICrearCursoRepositorio {
    boolean existe(Curso miCurso);

    boolean guardarCurso(Curso miCurso);
}
