// -*- Mode: Java -*- 
// Queue.java --- Queue interface
// Author          : Marcel Turcotte
// Created On      : Sat Mar  3 07:59:16 2007
// Last Modified By: Marcel Turcotte
// Last Modified On: Sat Mar  3 07:59:28 2007
// ITI 1121/1521. Introduction to Computer Science II

public interface Queue<E> {

    public abstract void enqueue( E obj );
    public abstract E dequeue();
    public abstract boolean isEmpty();
    public abstract int size();

}