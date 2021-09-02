package ficha6;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DriveitApp {
    private Driveit model;
    private Menu menu;

    public DriveitApp () {
        String [] opcoes = {
                "Get Nome",
                "Set Nome",
                "Carrega",
                "Grava",
                "Grava como",
                "Adiciona Veiculo",
                "Viaturas"
        };
        menu = new Menu(opcoes);
        try {
            ObjectInputStream is = new ObjectInputStream(
                    new FileInputStream("driveit.bin"));
            model = (Driveit) is.readObject();
        } catch (ClassNotFoundException | FileNotFoundException e){
            e.printStackTrace();
            model = new Driveit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Driveit load_file (String fname) throws IOException, ClassNotFoundException {
        Driveit m;
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(fname));
        m = (Driveit) is.readObject();
        return m;
    }

    private void save_file(String fname) throws IOException, ClassNotFoundException {
        java.io.ObjectOutputStream os = new ObjectOutputStream(
                new FileOutputStream(fname));
        os.writeObject(model);
    }

    public void run () throws IOException, ClassNotFoundException {
        int op = -1;
        Scanner s = new Scanner(System.in);
        while (op != 0) {
            String nome;
            menu.executa();
            op = menu.getOpcao();
            switch (op) {
                case 1:
                    model.getNome();
                    break;
                case 2:
                    nome = s.nextLine();
                    model.setNome(nome);
                    break;
                case 3:
                    System.out.println("Nome do ficheiro");
                    nome = s.nextLine();
                    try {
                        model = load_file(nome);
                    }catch (IOException e) {
                        e.printStackTrace();
                    }catch (ClassNotFoundException c) {
                        c.printStackTrace();
                    }
                    break;
                case 4:
                    try {
                        save_file("driveit.bin");
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                case 5:
                    System.out.println("Qual o nome?");
                    nome = s.nextLine();
                    try {
                        save_file(nome);
                    }catch (IOException e) {
                        e.printStackTrace();
                    }catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                case 6:
                    System.out.println("Esta por fazer");
                case 7:
                    System.out.println("Esta por fazer");
                case 8:
                    List <Veiculo> veiculos = model.getVeiculos();
                    for (Veiculo v : veiculos) System.out.println(v.getMatricula() + ";");
            }
        }
    }
}
