package ficha2;

import java.util.Arrays;

public class Ficha2_ex4 {
    private int[] inteiros;

    public Ficha2_ex4 (int [] inteiros) {
        this.inteiros = new int[inteiros.length];
        System.arraycopy(inteiros, 0, this.inteiros, 0, inteiros.length);
    }

    public int[] ordena() {
        int [] res = new int[inteiros.length];
        System.arraycopy(inteiros,0,res,0,inteiros.length);
        Arrays.sort(res);
        return res;
    }

    public int binarySearch (int elem) {
        return Arrays.binarySearch(inteiros, elem);
    }
}
