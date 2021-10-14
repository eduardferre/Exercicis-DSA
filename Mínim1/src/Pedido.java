import java.util.ArrayList;
import java.util.List;

public class Pedido {
    //En la siguiente lista se van a encontrar los diferentes profuctos que conforman un determinado profucto;
    public List <Producto> listaProductosPedido = new ArrayList<Producto>();

    public void setListaProductosPedido(List<Producto> listaProductosPedido) {
        this.listaProductosPedido = listaProductosPedido;
    }

    public List<Producto> getListaProductosPedido() {
        return listaProductosPedido;
    }


    public void addProductoAlPedido (Producto p){
        listaProductosPedido.add(p);
    }
};


