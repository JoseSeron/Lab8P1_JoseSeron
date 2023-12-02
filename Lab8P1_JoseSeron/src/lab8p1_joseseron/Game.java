package lab8p1_joseseron;

import java.util.ArrayList;

/**
 *
 * @author Jose Seron
 */
public class Game {

    ArrayList<String> pocisiones = new ArrayList();
    int[][] tableroActual;
    int[][] tableroSiguiente;
    int rondas = 0;

    public void jugar(int rondas) {
        int contRondas = 1;

        for (int i = 0; i < rondas; i++) {
            nextGen();
            System.out.println("Ronda " + contRondas);

            if (pocisiones.isEmpty()) {
                System.out.println("Todas las celdas han muerto antes de terminar las partidas \nEl Juego de la Vida ha terminado");
                break;
            }

            System.out.println("Coordenadas de Celdas Vivas:");
            System.out.println(pocisiones);
            Print(pocisiones);
            System.out.println("");

            contRondas++;
        }
    }

    public void nextGen() {

        int[][] tableroProvisional = new int[10][10];
        ArrayList<String> posiciones = new ArrayList();

        for (int i = 0; i < tableroActual.length; i++) {

            for (int j = 0; j < tableroActual[i].length; j++) {

                int contVivos = 0;
                //validaciones que las celdas no se salgan de los fokin bounds y que esten vivitas y coleando
                // der
                if (j + 1 < tableroActual[i].length && tableroActual[i][j + 1] == 1) {
                    contVivos++;
                }
                //izq
                if (j - 1 >= 0 && tableroActual[i][j - 1] == 1) {
                    contVivos++;
                }
                // arriba
                if (i - 1 >= 0 && tableroActual[i - 1][j] == 1) {
                    contVivos++;
                }
                // abajo
                if (i + 1 < tableroActual.length && tableroActual[i + 1][j] == 1) {
                    contVivos++;
                }
                // arriba izq
                if (i - 1 >= 0 && j - 1 >= 0 && tableroActual[i - 1][j - 1] == 1) {
                    contVivos++;
                }
                // arriba der
                if (i - 1 >= 0 && j + 1 < tableroActual[i].length && tableroActual[i - 1][j + 1] == 1) {
                    contVivos++;
                }
                // abajo izq
                if (i + 1 < tableroActual.length && j - 1 >= 0 && tableroActual[i + 1][j - 1] == 1) {
                    contVivos++;
                }
                // abajo der
                if (i + 1 < tableroActual.length && j + 1 < tableroActual[i].length && tableroActual[i + 1][j + 1] == 1) {
                    contVivos++;
                }

                if (tableroActual[i][j] == 1) {
                    if ((contVivos > 2) || (contVivos < 2)) {
                        tableroProvisional[i][j] = 0;

                    } else {
                        tableroProvisional[i][j] = 1;
                        posiciones.add(i + ":" + j);
                    }

                } else if ((tableroActual[i][j] == 0) && (contVivos == 3)) {
                    tableroProvisional[i][j] = 1;
                    posiciones.add(i + ":" + j);
                }

            }

        }
        tableroActual = tableroProvisional;
        pocisiones = posiciones;

    }

    public void Print(ArrayList<String> lista) {

   
        int[][] matriz = new int[10][10];

        for (int i = 0; i < lista.size(); i++) {
            String posicion = lista.get(i);

            int posX = posicion.charAt(0) - '0';
            int posY = posicion.charAt(2) - '0';
            matriz[posX][posY] = 1;
        }
        imprimirMatriz(matriz);
    }

    public void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("[" + matriz[i][j] + "]");
            }
            System.out.println("");
        }
    }

    //constructor vacio????
    public Game() {
    }

    public ArrayList<String> getPocisiones() {
        return pocisiones;
    }

    public void setPocisiones(ArrayList<String> pocisiones) {
        this.pocisiones = pocisiones;
    }

    public int[][] getTableroActual() {
        return tableroActual;
    }

    public void setTableroActual(int[][] tableroActual) {
        this.tableroActual = tableroActual;
    }

    public int[][] getTableroSiguiente() {
        return tableroSiguiente;
    }

    public void setTableroSiguiente(int[][] tableroSiguiente) {
        this.tableroSiguiente = tableroSiguiente;
    }

    public int getRondas() {
        return rondas;
    }

    public void setRondas(int rondas) {
        this.rondas = rondas;
    }

}
