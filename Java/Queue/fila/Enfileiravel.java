public interface Enfileiravel {
    
    /*
    Fila              / Queue
    Enfileiravel      / Queueable
    c = enfileirar    / enqueue
    r = espiar        / peek
    u = ------------------------
    d = densefileirar / dequeue
    ----
    Metodos auxiliares:

    imprimir = print
    esta vazio = isEmpty
    esta cheio = isFull
    */

    public void enqueue(Object dado);

    public Object peek();

    public Object dequeue();

    public String print();

    public boolean isEmpty();

    public boolean isFull();

}
