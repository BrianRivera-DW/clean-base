package usecase;

import curso.exception.ExceptionErrorAlGuardarCurso;
import curso.exception.ExceptionExisteCurso;
import curso.modelo.Curso;
import curso.modelo.Nivel;
import curso.repositorio.ICrearCursoRepositorio;
import curso.usecase.CrearCursoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CrearCursoUnitTest {

    @Mock
    ICrearCursoRepositorio crearCursoRepositorio;

    @Test
    public void crearCurso_CursoNoExistente_CursoCreado() throws ExceptionExisteCurso, ExceptionErrorAlGuardarCurso {
        Curso miCurso= Curso.Instancia("Programacion Anvanzada I", LocalDate.of(2030,7,3), Nivel.INICIAL);
        CrearCursoUseCase crearCursoUseCase = new CrearCursoUseCase(crearCursoRepositorio);


        when(crearCursoRepositorio.existe(miCurso)).thenReturn(false);
        when(crearCursoRepositorio.guardarCurso(miCurso)).thenReturn(true);

        boolean resultado=crearCursoUseCase.crearCurso(miCurso);

        Assertions.assertTrue(resultado);
    }

    @Test
    public void crearCurso_CursoExistente_CursoExisteExcetion() {
        Curso miCurso= Curso.Instancia("Progamacion Avanzada I",LocalDate.of(2030,7,3), Nivel.INICIAL);
        CrearCursoUseCase crearCursoUseCase = new CrearCursoUseCase(crearCursoRepositorio);

        when(crearCursoRepositorio.existe(miCurso)).thenReturn(true);

        Assertions.assertThrows(ExceptionExisteCurso.class,()->{crearCursoUseCase.crearCurso(miCurso);});
    }

    @Test
    public void crearCurso_ErrorAlGuardarCurso_CursoGuardadoExcetion() {
        Curso miCurso= Curso.Instancia("Progamacion Avanzada I",LocalDate.of(2030,7,3), Nivel.INICIAL);
        CrearCursoUseCase crearCursoUseCase = new CrearCursoUseCase(crearCursoRepositorio);

        when(crearCursoRepositorio.existe(miCurso)).thenReturn(false);
        when(crearCursoRepositorio.guardarCurso(miCurso)).thenReturn(false);

        Assertions.assertThrows(ExceptionErrorAlGuardarCurso.class,()->{crearCursoUseCase.crearCurso(miCurso);});
    }

}
