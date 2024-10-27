package br.com.joaonaif.naif_code.exceptions;

public class TaskAlreadyExist extends RuntimeException {
    public TaskAlreadyExist() { super("Curso já existe"); }
}
