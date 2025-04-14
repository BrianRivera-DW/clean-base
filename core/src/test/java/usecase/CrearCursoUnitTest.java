package usecase;

import curso.modelo.Curso;
import curso.modelo.Nivel;
import curso.repositorio.ICrearCursoRepositorio;
import curso.usecase.CrearCursoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

public class CrearCursoUnitTest {

    @Mock
    ICrearCursoRepositorio crearCursoRepositorio;

    @Test
    public void crearCurso_CursoNoExistente_CursoCreada() {
        Curso miCurso= Curso.Instancia("Programacion Anvanzada I", LocalDate.of(2025,3,3), Nivel.INICIAL);
        CrearCursoUseCase crearCursoUseCase = new CrearCursoUseCase(crearCursoRepositorio);

        when(crearCursoRepositorio.exits(miCurso)).thenReturn(false);
        when(crearCursoRepositorio.guardarCurso(miCurso)).thenReturn(true);

        boolean resultado=crearCursoUseCase.crearCurso(miCurso);

        Assertions.assertTrue(resultado);
    }
}
