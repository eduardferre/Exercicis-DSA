import java.io.*;
import java.lang.*;
import java.util.*;

public class GestorFiguras {

    public static double suma (Figura[] figuras) {
        double res = 0;

        for (Figura f : figuras) {
            res += f.area();
        }

        return res;
    }

    public static void Sort (Figura[] figuras, Figura[] lista) {
        double res;
        int num;
        int i = 0;

        while (i < figuras.length) {
            num = 0;

            for (Figura f : figuras) {
                res = f.compareTo(figuras[i]);

                if (res < 0) {
                    num++;
                }
            }

            lista[num] = figuras[i];
            i++;
        }
    }

    public static void main(String[] args) {
        Triangle t = new Triangle(90, 7);
        Cercle c = new Cercle(5);
        Rectangle r = new Rectangle(67 , 5);
        Quadrat q = new Quadrat(6);
        Figura [] figuras = new Figura[4];
        Figura [] lista = new Figura[figuras.length];
        figuras[0] = q;
        figuras[1] = r;
        figuras[2] = t;
        figuras[3] = c;

        System.out.println("Suma de las áreas: " + GestorFiguras.suma(figuras));
        GestorFiguras.Sort(figuras, lista);
        System.out.println("Lista de Figuras (ordenadas en orden descendente):");

        for (Figura f : lista) {
            System.out.println(f.area());
        }
    }
}
