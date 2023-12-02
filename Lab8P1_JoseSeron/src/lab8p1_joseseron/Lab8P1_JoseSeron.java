package lab8p1_joseseron;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jose Seron
 */
public class Lab8P1_JoseSeron {

    static Game instancia = new Game();
    static Random random = new Random();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int opcion1 = 0;
        boolean bandera1 = true;

        System.out.println("Laboratorio 8 : Juego de Vida");

        while (bandera1) {

            System.out.print("Ingrese la cantidad de rondas: ");
            int rondas1 = input.nextInt();

            //si, ya se que pocisiones se escribe posiciones pero cuando me di cuenta ya era muy tarde para cambiarlo
            ArrayList<String> pocisiones = new ArrayList();
            int[][] tabGenActual = new int[10][10];
            int[][] tabGenNext = new int[10][10];

            instancia.setRondas(rondas1);
            tabGenActual = llenarMatriz(tabGenActual, tabGenNext, pocisiones);
            instancia.setTableroActual(tabGenActual);
            instancia.setTableroSiguiente(tabGenNext);
            instancia.setPocisiones(pocisiones);

            System.out.println(pocisiones);
            imprimirMatriz(tabGenActual);

            instancia.jugar(rondas1);

            ///////////////////////////////////////////////////////////////
            System.out.println("Desea continuar con este programa? (0-SI, 1-NO)");
            opcion1 = input.nextInt();

            while (opcion1 < 0 || opcion1 > 1) {
                System.out.println("Ingrese una opcion valida (0-SI, 1-NO)");
                opcion1 = input.nextInt();
            }

            if (opcion1 == 1) {
                bandera1 = false;
            }
            /////////////////////////////////////////////////////////////////

        }

    }

    //metodo que reciba dos matrices y el arraylist y retorne una matriz
    public static int[][] llenarMatriz(int[][] genActual, int[][] genNext, ArrayList<String> pocisiones) {
        int[][] matrizLlena = new int[10][10];

        for (int i = 0; i < matrizLlena.length; i++) {

            for (int j = 0; j < matrizLlena[i].length; j++) {
                matrizLlena[i][j] = random.nextInt( 2);

                matrizLlena[0][j] = 0;
                matrizLlena[i][0] = 0;
                matrizLlena[9][j] = 0;
                matrizLlena[i][9] = 0;

                if (matrizLlena[i][j] == 1) {
             String elemento = i + ":" + j;
                pocisiones.add(elemento);

                }

            }

        }

        return matrizLlena;
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("[" + matriz[i][j] + "]");
            }
            System.out.println("");
        }
    }

}
