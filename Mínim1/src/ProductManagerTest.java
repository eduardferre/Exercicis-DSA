public class ProductManagerTest {
    public static void main(String[] args) {
        Producto p1 = new Producto();
        Producto p2 = new Producto();
        Producto p3 = new Producto();

        p1.setPrecio(10);
        p1.setNombreProducto("Croissant");
        p2.setPrecio(50);
        p2.setNombreProducto("Café");
        p3.setPrecio(3);
        p3.setNombreProducto("Cacaolat");

        ProductManager manager = new ProductManager();
        manager.listaProductos.add(p1);
        manager.listaProductos.add(p2);
        manager.listaProductos.add(p3);

        //Creamos los dos pedidos, con sus respectivos productos.
        Pedido pedido1 = new Pedido();
        pedido1.addProductoAlPedido(p1);
        pedido1.addProductoAlPedido(p2);
        Pedido pedido2 = new Pedido();
        pedido2.addProductoAlPedido(p3);

        //Realizamos los pedidos en el orden deseado.
        manager.realizarPedido(pedido2);
        manager.realizarPedido(pedido1);


        System.out.println("---PRECIOS SIN ORDENAR---" );
        for (Producto p : manager.listaProductos){
            System.out.println(p.getPrecio());
        }
        manager.ordenarProductos(manager.listaProductos);

        System.out.println("---PRECIOS ORDENADOS---");
        for (Producto p : manager.listaProductos){
            System.out.println(p.getPrecio());
        }
        Pedido primerPedido = manager.listaPedidos.peek();
        System.out.println("Primer servicio efectuado: " );
        for (Producto p : primerPedido.getListaProductosPedido()){
            System.out.println("Nombre producto: " + p.getNombreProducto());
            System.out.println("Precio pedido: " + p.getPrecio());
        }
    }
}
