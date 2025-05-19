package curso.repositorio;

import java.time.LocalDate;

public interface IBuscarCursoRepositorio {
    boolean buscarXnombre(String parametroNombre);
    boolean buscarXNivel(String parametroNivel);
    boolean buscarXFecha(LocalDate parametroFecha);
}
