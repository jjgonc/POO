package ficha6;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.SQLOutput;

public class DriveItFromFile {
    public static void main (String args[]) {
        ObjectInputStream is = null;
        Driveit d = null;
        try {
            is = new ObjectInputStream(new FileInputStream("driveit_pl1.bin"));
            d = (Driveit) is.readObject();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            d = new Driveit();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        assert d != null;
        System.out.println(d.ordenarVeiculos());
        System.out.println(d.veiculoMenosUtilizado());
    }
}
