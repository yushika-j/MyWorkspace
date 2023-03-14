public interface Map< K, V> {

    /* Make the necessary abstract method definitions */
    V get(K key);

      boolean contains(K key);

      void put(K key, V value);

      void replace(K key, V value);

      V remove(K key);
    // public abstract Integer get();
    // public abstract void put();
    // public abstract boolean contains();
    // public abstract void replace();
    // public abstract Integer remove();
    // public abstract String toString();
}