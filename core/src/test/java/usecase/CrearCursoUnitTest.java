package usecase;

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
    public void crearCurso_CursoNoExistente_CursoCreada() {
        Curso miCurso= Curso.Instancia("Programacion Anvanzada I", LocalDate.of(2025,7,3), Nivel.INICIAL);
        CrearCursoUseCase crearCursoUseCase = new CrearCursoUseCase(crearCursoRepositorio);

        when(crearCursoRepositorio.exits(miCurso)).thenReturn(false);
        when(crearCursoRepositorio.guardarCurso(miCurso)).thenReturn(true);

        boolean resultado=crearCursoUseCase.crearCurso(miCurso);

        Assertions.assertTrue(resultado);
    }

    @Test
    public void crearCurso_CamposIncompletos_ExcepcionCampos() {
        Curso miCurso= Curso.Instancia(null,null,null);
        CrearCursoUseCase crearCursoUseCase = new CrearCursoUseCase(crearCursoRepositorio);
        //Test para el nombre null  o vasio
        Assertions.assertThrows(RuntimeException.class, () -> {crearCursoUseCase.crearCurso(miCurso);});
    }

    @Test
    public void crearCurso_FechaCierre_ExcepcionFecha() {
        Curso miCurso= Curso.Instancia("Programacion Anvanzada I", LocalDate.of(2024,7,3),Nivel.INICIAL);
        CrearCursoUseCase crearCursoUseCase = new CrearCursoUseCase(crearCursoRepositorio);
        //Test evaluar si la fecha de cierre no es anterior a la fecha actual
        Assertions.assertThrows(RuntimeException.class, () -> {crearCursoUseCase.crearCurso(miCurso);});
    }
}
