package br.com.joaonaif.naif_code.exceptions;

public class TaskAlreadyExistException extends RuntimeException {
    public TaskAlreadyExistException() { super("Curso já existe"); }
}
