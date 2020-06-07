/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author 52812
 */
public class GrafoVector {
    private int[][] matriz = {
//       S   A   B   C   D   E   F   T
        {0, 13, 10, 10,  0,  0,  0,  0},//S
        {0,  0,  0,  0, 24,  0,  0,  0},//A
        {0,  5,  0, 15,  0,  0,  7,  0},//B
        {0,  0,  0,  0,  0,  0, 15,  0},//C
        {0,  0,  0,  0,  0,  4,  0,  9},//D
        {0,  0,  0,  0,  0,  0,  6, 13},//E
        {0,  0,  0,  0,  0,  0,  0, 16},//F
        {0,  0,  0,  0,  0,  0,  0,  0}//T
    };

    
    public GrafoVector() {
        //Validar grafo
        int filas, columnas;
        boolean validacion = true;
        // validar que todos tengan el mismo tamaño
        filas = matriz.length;
        for (int i = 0; i < filas; i++) {
            int[] fila = this.matriz[i];
            if (fila.length != filas){
                validacion = false;
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("Error la fila: " + i);
                break;
            }
        }
        if (!validacion){
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("Error la matriz debe tener las mismas filas y colunas");
            this.matriz = new int[0][0];
        }else{
            validacion = true;
            //validar que no haya ningun 
            boolean[] validaciones = new boolean[filas];
            for (int i = 0; i < filas; i++) {
                validaciones[i] = false;
            }
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < filas; j++) {
                    int value = this.matriz[i][j];
                    if (value > 0){
                        validaciones[i] = true;
                        validaciones[j] = true;
                    }
                }
            }
            for (int i = 0; i < filas; i++) {
                if (!validaciones[i]){
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("El objeto " + i + " no esta conectado.");
                    validacion = false;
                    break;
                }
            }
            if (!validacion){
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("Error la matriz no debe tener puntos que no esten conectado con otro punto de la matriz");
                this.matriz = new int[0][0];
            }
        }
    }
}
