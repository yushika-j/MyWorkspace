/**
 * COPYRIGHT MATERIAL -- DO NOT DISTRIBUTE
 *
 * @author Mehrdad Sabetzadeh 
 */
public interface Queue<E> {
    boolean isEmpty();
    void enqueue(E newElement);
    E dequeue();
}

