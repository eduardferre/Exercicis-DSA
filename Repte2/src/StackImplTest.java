public class StackImplTest {
    public static void main(String[] args) {
        System.out.println("TEST");

        Stack<Integer> s = new StackImpl<Integer>(5);

        try {

            s.push(12);
            System.out.println((s.size()));
            s.push(16);
            System.out.println((s.size()));
            s.push(20);
            System.out.println((s.size()));
            s.push(30);
            System.out.println((s.size()));
            s.push(40);
            System.out.println((s.size()));


            System.out.println(s.pop());
            System.out.println(s.pop());
            System.out.println(s.pop());
            System.out.println(s.pop());
            System.out.println(s.pop());
            System.out.println(s.pop());

        }
        catch (EmptyStackException empty) {
            System.out.println("LA PILA ESTÁ VACÍA");
        }
        catch (FullStackException full) {
            System.out.println("LA PILA ESTÁ LLENA");
        }

    }
}
