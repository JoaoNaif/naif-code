package br.com.joaonaif.naif_code.exceptions;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException() { super("Curso não econtrado"); }
}
