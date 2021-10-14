import java.util.List;
public interface Pedidos <Pedido>{
    public void realizarPedido (Pedido p); //Añade el pedido a la lista de pedidos.
    public Pedido servirPedido (); //Extrae el pedido de la lista de pedidos y devuelve el pedido.
    public void ordenarProductos (List<Producto> p); //Ordena los productos de menor a mayor precio.
}
