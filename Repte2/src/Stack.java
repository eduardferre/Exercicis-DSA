public interface Stack<E> {
    public void push(E e) throws  FullStackException;
    public E pop () throws EmptyStackException;
    public int size();
}