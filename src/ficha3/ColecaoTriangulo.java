package ficha3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ColecaoTriangulo {
    private List<Triangulo> triangulos;

    public ColecaoTriangulo () {
        triangulos = new ArrayList<>();
    }

    //aula 24-03 (segunda aula a pegar neste ex
    public void AddTriangulo (Triangulo t) {
        this.triangulos.add(t.clone());
    }

    public List<Triangulo> getTriangulos() {
        //return triangulos.stream().map(t->t.clone()).collect(Collectors.toList());
        return triangulos.stream().map(Triangulo::clone).collect(Collectors.toList());
    }

    public void setTriangulos(List<Triangulo> triangulos) {
        this.triangulos = new ArrayList<>();
        /*  Outro modo:
        for (Triangulo t: triangulos) {
            this.triangulos.add(t.clone());
           }
         */
        for (Iterator <Triangulo> it = triangulos.iterator(); it.hasNext();) {
            Triangulo t = it.next();
            this.triangulos.add(t.clone());
        }
    }

    public double somaAreas () {
        return this.triangulos.stream().mapToDouble(Triangulo::area).sum();
    }

    public Triangulo maiorDasAreas() {
        if (this.triangulos.isEmpty()) return null;
        //nota que tivvemos que fazer -int... para dar o maior deles!!
        return this.triangulos.stream()
                .sorted((t1,t2)-> -(int)(t1.area()-t2.area()))
                .findFirst().get().clone();
    }

    public List<Triangulo> ordenadoPorArea() {
        return triangulos.stream()
                .map(Triangulo::clone)
                .sorted((t1,t2)->(int)(t1.area()-t2.area()))
                .collect(Collectors.toList());
    }

    //ate aqui na aula 24-03

    public Triangulo encontrarTriangulo (Triangulo t) {
        for (Triangulo triang : triangulos) {
            if (triang.equals(t)) {
                return triang.clone();
            }
        }
        return null;
    }

    public Triangulo encontraTriangulo2 (Triangulo t) {
        if (this.triangulos.contains(t)) {
            int i = triangulos.indexOf(t);
            return triangulos.get(i).clone();
        }
        return null;
    }

    public Triangulo maiorArea () {
        double maxA = Double.MAX_VALUE;
        Triangulo t = null; //inicializar a variavel triangulo
        for (Triangulo triang: triangulos) {
            if (triang.area() > maxA) {
                maxA = triang.area();
                t = triang;
            }
        }
        if (t!=null) {
            t=t.clone();
        }
        return t;
    }
}
