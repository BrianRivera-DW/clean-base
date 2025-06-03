package curso.exception;

public class NoExisteCursoBuscado extends RuntimeException {
    public NoExisteCursoBuscado(String msj) {super(msj);}
}
