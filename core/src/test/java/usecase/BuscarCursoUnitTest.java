package usecase;


import curso.repositorio.IBuscarCursoRepositorio;
import curso.usecase.BuscarCursoUsecase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.time.LocalDate;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BuscarCursoUnitTest {

    @Mock
    IBuscarCursoRepositorio buscarCursoRepositorio;
    @Test
    public void buscarCursoXNombre_CursoExiste_BuscarCurso(){
        BuscarCursoUsecase buscarCursoUsecase = new BuscarCursoUsecase(buscarCursoRepositorio);
        String nombreCurso = "ProgramacionAvanzada I";
        when(buscarCursoRepositorio.buscarXnombre(nombreCurso)).thenReturn(true);

        boolean resultado=buscarCursoUsecase.buscarXNombre(nombreCurso);

        Assertions.assertTrue(resultado);
    }

    @Test
    public void buscarCursoXNivel_CursoExiste_BuscarCurso(){
        BuscarCursoUsecase buscarCursoUsecase = new BuscarCursoUsecase(buscarCursoRepositorio);
        String nivelCurso = "Medio";

        when(buscarCursoRepositorio.buscarXNivel(nivelCurso)).thenReturn(true);

        boolean resultado=buscarCursoUsecase.buscarXNivel(nivelCurso);

        Assertions.assertTrue(resultado);
    }

    @Test
    public void buscarCursoXFecha_CursoExiste_BuscarCurso(){
        BuscarCursoUsecase buscarCursoUsecase = new BuscarCursoUsecase(buscarCursoRepositorio);
        LocalDate fechaCurso = LocalDate.of(2020, 1, 1);

        when(buscarCursoRepositorio.buscarXFecha(fechaCurso)).thenReturn(true);

        boolean resultado=buscarCursoUsecase.buscarXFecha(fechaCurso);

        Assertions.assertTrue(resultado);
    }

    @Test
    public void buscarCurso_NoExiste_NoExisteCurso(){
        BuscarCursoUsecase buscarCursoUsecase = new BuscarCursoUsecase(buscarCursoRepositorio);
        String nombreCurso = "ProgramacionAvanzada uno";
        String nivelCurso = "Medio";
        LocalDate fechaCurso = LocalDate.of(2020, 1, 1);

        when(buscarCursoRepositorio.buscarXnombre(nombreCurso)).thenReturn(false);
        when(buscarCursoRepositorio.buscarXNivel(nivelCurso)).thenReturn(false);
        when(buscarCursoRepositorio.buscarXFecha(fechaCurso)).thenReturn(false);


        RuntimeException exceptionNombre = Assertions.assertThrows(RuntimeException.class,()->buscarCursoUsecase.buscarXNombre(nombreCurso));
        RuntimeException exceptionNivel = Assertions.assertThrows(RuntimeException.class,()->{buscarCursoUsecase.buscarXNivel(nivelCurso);});
        RuntimeException exceptionFecha = Assertions.assertThrows(RuntimeException.class,()->{buscarCursoUsecase.buscarXFecha(fechaCurso);});

        Assertions.assertEquals("Error, No se encontro el curso con el nombre ingresado", exceptionNombre.getMessage());
        Assertions.assertEquals("Error, No se encontro el curso con el nivel ingresado",exceptionNivel.getMessage());
        Assertions.assertEquals("Error, No se encontro el curso con la fecha ingresada",exceptionFecha.getMessage());
    }
}
