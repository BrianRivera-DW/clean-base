package curso.usecase;

import curso.exception.NoExisteCursoBuscado;
import curso.input.IbuscarCursoInput;
import curso.repositorio.IBuscarCursoRepositorio;

import java.time.LocalDate;

public class BuscarCursoUsecase implements IbuscarCursoInput {

    private final IBuscarCursoRepositorio buscarCursoRepositorio;

    public BuscarCursoUsecase(IBuscarCursoRepositorio buscarCursoRepositorio) {
        this.buscarCursoRepositorio = buscarCursoRepositorio;
    }

    @Override
    public boolean buscarXNombre(String parametroNombre) {
        if(!buscarCursoRepositorio.buscarXnombre(parametroNombre)){
            throw new NoExisteCursoBuscado("Error, No se encontro el curso con el nombre ingresado");
        }
        return true;
    }

    @Override
    public boolean buscarXNivel(String parametroNivel) {
        if(!buscarCursoRepositorio.buscarXNivel(parametroNivel)){
            throw new NoExisteCursoBuscado("Error, No se encontro el curso con el nivel ingresado");
        }
        return true;
    }

    @Override
    public boolean buscarXFecha(LocalDate parametroFecha) {
        if(!buscarCursoRepositorio.buscarXFecha(parametroFecha)){
            throw new NoExisteCursoBuscado("Error, No se encontro el curso con la fecha ingresada");
        }
        return true;
    }

}
