/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Benny Reyes Sosa
 */
public final class BusquedaTabu {
    public Grafo myGrafo;
    private Scanner in;
    private int nodoInicial;
    private int nodoFinal;
    
    public BusquedaTabu(Grafo obj){
        this.myGrafo = obj;
        this.in = new Scanner(System.in);
        System.out.println("");
        System.out.println("Busqueda Tabu");
        System.out.println("");
        System.out.println("");
        int aux = 0;
        do{
            if(aux != 0){
                System.out.println("Favor de ingresar un numero valido");
            }
            System.out.println("Ingresa el nodo de inicio: ");
            aux = in.nextInt();
        }while(aux < 0 && aux > this.myGrafo.matrizValues.length - 1);
        this.nodoInicial = aux;
//        do{
//            if(aux != 0){
//                System.out.println("Favor de ingresar un numero valido");
//            }
//            System.out.println("Ingresa el nodo destino: ");
//            aux = in.nextInt();
//        }while(aux < 0 && aux > this.myGrafo.matrizValues.length - 1);
//        this.nodoFinal = aux;
        Calcular();
    }
    
    public void Calcular(){
        System.out.println("Calculo:");
        int[][] matriz = this.myGrafo.matrizValues;
        int suma = 0;
        int mejorIndex = 0;
        int actual = this.nodoInicial;
        int[] visitados = new int[matriz.length + 1];
        for (int i = 0; i < visitados.length; i++) {
            visitados[i] = visitados.length;
        }
        for (int i = 0; i < matriz.length - 1; i++) {
            int[] opciones = matriz[actual];
            int mejor = 0;
            mejorIndex = 0;
            visitados[i] = actual;
            for (int j = 0; j < opciones.length; j++){
                int value = opciones[j];
                if (!contains(visitados, j) && j != this.nodoInicial && value > 0){
                    if (mejor == 0 || value < mejor ){
                        mejor = value;
                        mejorIndex = j;
                        System.out.println("Entro ---> " + mejorIndex);
                    }
                }   
            }
            System.out.println("Visitados " + Arrays.toString(visitados));
            System.out.println("El mejor en " + Arrays.toString(opciones) + " es ---> " + mejorIndex);
            suma = suma + mejor;
            actual = mejorIndex;
        }
        visitados[visitados.length - 2] = actual;
        visitados[visitados.length -1] = this.nodoInicial;
        System.out.println("Ultimo movimiento en " + Arrays.toString(matriz[mejorIndex]) + " es ---> " + this.nodoInicial);
        suma += matriz[mejorIndex][this.nodoInicial];
        
        System.out.println("Suma Final: " + suma);
        System.out.println("Visitaos: " + Arrays.toString(visitados) );
        System.out.println("Inicio: " + this.nodoInicial);
        System.out.println("");
        this.myGrafo.printMatriz();
    }
    
    public static boolean contains(final int[] arr, final int key) {
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }
    
}
