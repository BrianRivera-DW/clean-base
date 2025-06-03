package persistencia;

import curso.modelo.Curso;
import curso.repositorio.ICrearCursoRepositorio;

public class CrearCursoImplRepo implements ICrearCursoRepositorio {

    @Override
    public boolean existe(Curso miCurso) {
        return false;
    }

    @Override
    public boolean guardarCurso(Curso miCurso) {
        return false;
    }
}
