package ficha2;

public class Ficha2_ex1 {

    public int minimo (int[] a) {
        int min = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }

    public int[] valoresEntre (int []a, int i, int f) {
        if (i>f || f > a.length) {
            return null;
        }
        int size = f-i+1;
        int [] res = new int [size];
        System.arraycopy(a, i, res,0, size);
        return res;
    }

    public int[] comuns(int [] a, int [] b) {
        int [] res = new int [a.length];
        int ind=0;
        for (int i=0; i<a.length; i++) {
            for (int j=0; j<b.length; j++) {
                if (a[i] == b[j]) {
                    boolean found = false; //para entrar no ciclo
                    for (int k=0; k<ind && !found; k++) {
                        if (res[k] == a[i]) found = true;
                    }
                    if (!found) {
                        res[ind] = a[i];
                        ind++;
                    }
                }
            }
        }
        int [] resultado = new int[ind];
        System.arraycopy (res, 0, resultado, 0, ind);
        return resultado;
    }




}
