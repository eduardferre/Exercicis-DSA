public class StackImpl<E> implements Stack<E> {
    E[] data;
    private int p;

    public StackImpl(int len) {
        data = (E[]) new Object[len];
    }

    @Override
    public void push(E e) throws FullStackException {
        if (this.p > data.length) throw new FullStackException();

        this.data[this.p++] = e;
    }


    @Override
    public E pop() throws EmptyStackException {
        if (this.p==0) throw new EmptyStackException();

        this.p--;
        E ret = this.data[this.p];
        this.data[this.p] = null;
        return ret;
    }

    @Override
    public int size() {
        return this.p;
    }
}
