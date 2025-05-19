package curso.input;

import java.time.LocalDate;

public interface IbuscarCursoInput {
    boolean buscarXNombre(String parametroNombre);
    boolean buscarXNivel(String parametroNivel);
    boolean buscarXFecha(LocalDate parametroFecha);
}
