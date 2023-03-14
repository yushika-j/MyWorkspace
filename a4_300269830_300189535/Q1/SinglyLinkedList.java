/**
* An implementation of the interface List using
* linked elements.
*
* @author Guy-Vincent Jourdan and Marcel Turcotte
*/

import java.util.*;

public class SinglyLinkedList<E> implements List<E>, Iterable<E> {

    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

   private class LinkedListIterator implements Iterator<E> {

        private Node<E> currentIterator;

        public LinkedListIterator() {
            currentIterator = null;
        }

        public E next() {
            if(currentIterator == null) {
                currentIterator = head;
            } else {
                currentIterator = currentIterator.next;
            }
            if (currentIterator == null) {
                throw new NoSuchElementException("Iterator at the end or list empty");
            }

            return currentIterator.value;
        }

        public boolean hasNext() {
            if (currentIterator == null) {
                return !isEmpty();
            } else {
                return (currentIterator.next != null);
            }
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private Node<E> head;
    private int size;
    private Node<E> tail;

    public SinglyLinkedList() {
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E elem) {

        if(elem == null) {
            throw new NullPointerException("Can't add null reference to the list");
        }
        Node<E> newNode = new Node<E>(elem, null);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void add(E elem) {

        if(elem == null) {
            throw new NullPointerException("Can't add null reference to the list");
        }
        Node<E> newNode = new Node<E>(elem, null);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void add(int pos, E elem) {

        if(elem == null) {
            throw new NullPointerException("Can't add null reference to the list");
        }
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException(Integer.toString(pos));
        }


        if(pos == 0) {
            addFirst(elem);
        } else if (pos == size) {
            add(elem);
        } else {

            Node<E> p = head;
            for (int i = 0; i < pos-1; i++) {
                p = p.next;
            }

            p.next = new Node<E>(elem, p.next);
            size++;
        }
    }

    public E removeFirst() {

        if (isEmpty()) {
            throw new IllegalStateException("Empty list!");
        }

        E savedValue = head.value;
        size--;
        if (size > 0) {
            head = head.next;
        } else {
            head = tail = null;
        }
        return savedValue;
    }

    public E removeLast() {

        if (isEmpty()) {
            throw new IllegalStateException("Empty list!");
        }

        E savedValue= tail.value;

        if (head.next == null) {
            head = tail = null;
        } else {
            Node<E> p = head;
            while (p.next != tail) {
                p = p.next;
            }
            tail = p;
            tail.next = null;
        }
        size--;
        return savedValue;
    }


    public boolean remove(E elem) {

        if (elem == null) {
            throw new NullPointerException();
        }

        if (head == null) {
            return false;
        }

        if (head.value.equals(elem)) {
            removeFirst();
            return true;
        } else {
            Node<E> p = head;
            while (p.next != null && ! p.next.value.equals(elem)) {
                p = p.next;
            }
            if (p.next == null) {
                return false;
            } else {
                p.next = p.next.next;
                if(p.next == null) {
                    tail = p;
                }
                size--;
                return true;
            }
        }
    }

    public E get(int pos) {

        if(isEmpty()) {
            throw new IllegalStateException("Empty list!");
        }

        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(pos));
        }

        Node<E> p = head;

        for (int i=0; i<pos; i++) {
            p = p.next;
        }

        return p.value;
    }

    public E remove(int pos) {

        if (isEmpty()) {
            throw new IllegalStateException("Empty list!");
        }

        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(pos));
        }

        Node<E> toBeRemoved;

        if (pos == 0) {
            return removeFirst();
        } else if (pos == size-1) {
            return removeLast();
        } else {
            Node<E> p = head;

            for (int i=0; i<( pos-1); i++) {
                p = p.next;
            }
            toBeRemoved = p.next;
            p.next = p.next.next;
        }
        size--;
        return toBeRemoved.value;
    }

    public boolean equals(SinglyLinkedList<E> otherList){

        if((otherList == null) || (size != otherList.size()))
            return false;

        Node<E> thisCursor = head;
        Node<E> otherCursor = otherList.head;

        for(int i = 0; i < size; i++){
            if(!thisCursor.value.equals(otherCursor.value))
                return false;
            thisCursor = thisCursor.next;
            otherCursor = otherCursor.next;
        }

        return true;
    }

    public String toString(){
        StringBuffer res = new StringBuffer();
        res.append("[");
        if (!isEmpty()) {
            Node<E> cursor = head;
            res.append(cursor.value);
            while (cursor.next != null) {
                cursor = cursor.next;
                res.append(" " + cursor.value);
            }
        }
        res.append("]");
        return res.toString();
    }
}
