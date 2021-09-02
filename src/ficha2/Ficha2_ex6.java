package ficha2;

import java.util.Arrays;

public class Ficha2_ex6 {

    //alinea a vai estar na main para passar a matriz e usar nos outros exercicios


    //alinea b
    public String matrix_Sum (int [] [] matrix1, int [] [] matrix2) {
        int [] [] res = new int[matrix1.length] [matrix1[0].length];
        for (int line=0; line < matrix1.length; line++) {
            for (int column = 0; column < matrix1[0].length; column++) {
                res[line] [column] = (matrix1 [line] [column] ) + (matrix2 [line] [column] );
            }
        }
        return (Arrays.deepToString(res));
    }

    //alinea c
    public boolean isEq_Matrix (int [] [] matrix1, int [] [] matrix2) {
        boolean res = Arrays.deepEquals(matrix1, matrix2);

        return res;
    }

    //alinea d
    public static String oppositeMat(int[][] mat){
        int[][] res = new int[mat.length][mat[0].length];
        for(int i = 0; i < mat.length; i++)
            for(int j = 0; j < mat[0].length; j++)
                res[i][j] = (mat[i][j]) * (-1);
        return (Arrays.deepToString(res));
    }
}
