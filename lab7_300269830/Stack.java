public interface Stack<E> {

    public abstract boolean isEmpty();
    public abstract E peek();
    public abstract E pop();
    public abstract void push( E element) throws FullStackException;
    /* Add clear */
    public abstract void clear();
}