import java.util.*;

public class ProductManager implements Pedidos<Pedido> {

    public Queue<Pedido> listaPedidos = new LinkedList<Pedido>();
    public List<Producto> listaProductos = new ArrayList<Producto>();

    //Este método añade el pedido a la lista/cola de pedidos.
    public void realizarPedido (Pedido p){
        this.listaPedidos.add(p);
    }

    //Este método eliminia el pedido de la lista/cola de pedidos y devuelve el pedido.
    public Pedido servirPedido(){
        return this.listaPedidos.peek();
    }

    public void ordenarProductos(List<Producto> p) {
        Collections.sort(p);
    }
}
