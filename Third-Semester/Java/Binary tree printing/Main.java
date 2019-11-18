import java.util.Scanner;
import java.io.*;
import java.awt.GraphicsEnvironment;

public class Main {

    public static void main(String[] args) {
        Console console = System.console();
        if(console == null && !GraphicsEnvironment.isHeadless()){
            //String filename = Main.class.getProtectionDomain().getCodeSource().getLocation().toString().substring(6);
            try {
                File batch = new File("Launcher.bat");
                if(!batch.exists()){
                    batch.createNewFile();
                    PrintWriter writer = new PrintWriter(batch);
                    writer.println("@echo off");
                    //writer.println("cd " + filename);
                    writer.println("java -jar Arbol.jar");
                    writer.println("pause");
                    writer.println("exit");
                    writer.flush();
                    writer.close();
                }
                Runtime.getRuntime().exec("cmd /c start \"\" "+ batch.getPath());
            }catch(IOException e) {
                e.printStackTrace();
            }
        }else{
            int cantidadDeNodos;
            Arbol<Integer> arbol = new Arbol<>();
            Scanner sc = new Scanner(System.in);
            System.out.print("Numero de nodos a insertar: ");
            cantidadDeNodos = Integer.parseInt(sc.nextLine());
            for (int i = 0; i <cantidadDeNodos ; i++) {
                System.out.print("Nodo " + (i+1) + ": ");
                arbol.insertarNodo(sc.nextInt());
            }
            System.out.println();
            arbol.imprimirPorNiveles();

            sc.close();
        }
        
    }
}
