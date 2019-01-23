package spring.certification.ioc.q013.example;

/**
 * A person who lays thoughts on the paper.
 */
public class Writer {

    private Notebook notebook;
    private Inspiration inspiration;

    public Writer(Notebook notebook, Inspiration inspiration) {
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
