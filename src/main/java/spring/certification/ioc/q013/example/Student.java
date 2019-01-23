package spring.certification.ioc.q013.example;

/**
 * A person enrolled in educational processes.
 */
public class Student {

    private Notebook notebook;
    private Inspiration inspiration;

    public Student(Notebook notebook, Inspiration inspiration) {
        this.notebook = notebook;
        this.inspiration = inspiration;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public Inspiration getInspiration() {
        return inspiration;
    }
}
