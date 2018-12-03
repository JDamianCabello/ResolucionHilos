package es.jdamiancabello;

import java.io.*;
import java.util.Scanner;

public class Maraton {

    public static void main(String[] args) {
        if (args.length != 2)
            System.out.println("Este programa necesita dos argumentos para funcionar.");
        else{
            InputStream in;
            Process hijo;
            Runtime rt = Runtime.getRuntime();
            String line;
            Writer out;

            try{
                System.out.println("Bienvenido al generador de carreras. Llamando al .jar...");


                hijo = rt.exec("java -jar Carrera.jar ".concat(args[0] + " " + args[1]));
                out = new BufferedWriter(new OutputStreamWriter(hijo.getOutputStream()));


                //Ahora leemos la salida del proceso hijo.
                in = hijo.getInputStream();
                BufferedReader brHijo = new BufferedReader(new InputStreamReader(in));

                while((line = brHijo.readLine()) != null)
                    System.out.println(line);

                BufferedReader brError = new BufferedReader(new InputStreamReader(hijo.getErrorStream()));
                while ((line = brError.readLine()) != null)
                    System.out.println(line);

                in.close();
                brError.close();

                System.err.println("El padre finaliza la ejecución. Se cierra el programa.");
            }
            catch (Exception e){}
        }
    }
}
