public class Producto implements Comparable<Producto>{
    private String nombreProducto;
    private int precio;
    private int numVentas;

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public String getNombreProducto() {
        return nombreProducto;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setNumVentas(int numVentas) {
        this.numVentas = numVentas;
    }

    public int getPrecio() {
        return precio;
    }

    public int getNumVentas() {
        return numVentas;
    }

    public int compareTo (Producto p){
        return (int) (this.precio - p.precio);
    }
}

