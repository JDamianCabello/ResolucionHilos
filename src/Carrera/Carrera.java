package Carrera;

import java.util.Random;

public class Carrera {
    public static void main(String[] args) {
        for (int i = 0; i < Integer.valueOf(args[0]); i++) {
            new CarreraMalaga2018(i+1,Integer.valueOf(args[1])).start();
        }
    }
}

    class CarreraMalaga2018 extends Thread {

    private int distancia;
    private int nCorredor;
    private int velocidad;

    public CarreraMalaga2018(int nCorredor, int distancia) {

        Random rnd = new Random();
        velocidad = ((rnd.nextInt(6) - 3) + 3) * 100;
        this.distancia = distancia;
        this.nCorredor = nCorredor;
    }

    @Override
    public void run() {
        int i = 1;
        System.out.println("El corredor nº " + nCorredor + " correrá "+distancia +" km's" +"a una velocidad de: "+velocidad+" ms/Vuelta.");

        while (i <= distancia) {
            try {
                Thread.sleep(velocidad);
                System.out.println("El corredor nº " + nCorredor + " corrió 1km. Le quedan: [" + (distancia - (i)) + "] Km's.");
                i++;
            }catch (Exception e){}
        }
        System.out.println("El corredor nº " + nCorredor + " acabó la carrera.");
    }
}
