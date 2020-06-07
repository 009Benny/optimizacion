/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Benny Reyes Sosa
 */
public class GrafoCoordenadas {
    private Scanner in;
    private String[] names;
    public int itemsCount;
    private NodoXY[] arrayNodos;
    
    public GrafoCoordenadas(boolean random) {
        this.in = new Scanner(System.in);
        this.names = new String[] {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        System.out.println("");
        System.out.println("");
        System.out.println("Ingresa el numero de items en el grafo");
        System.out.println("numero : ");
        this.itemsCount = this.in.nextInt();
        if (random){
            createRandomValues();
        }else{
            fillMatrizManually();
        }
    }
    
    private void createRandomValues(){
        int min = -100, max = 100;
        int minCosto = 5, maxCosto = 50;
        this.arrayNodos = new NodoXY[this.itemsCount];
        System.out.println("");
        System.out.println("");
        System.out.println("");
        for(int i = 0; i < this.itemsCount; i++){
            int x = ThreadLocalRandom.current().nextInt((max - min) + 1) + min;
            int y = ThreadLocalRandom.current().nextInt((max - min) + 1) + min;
            int costo = ThreadLocalRandom.current().nextInt((maxCosto - minCosto) + 1) + minCosto;
            NodoXY nodo = new NodoXY(x, y, costo);
            nodo.setName(this.names[i]);
            this.arrayNodos[i] = nodo;
;       }
        printMatriz();
    }
    
    private void fillMatrizManually(){
        this.arrayNodos = new NodoXY[this.itemsCount];
        System.out.println("");
        System.out.println("");
        System.out.println("");
        for(int i = 0; i < this.itemsCount; i++){
            System.out.println("Ingrese los siguientes datos para el nodo " + this.names[i] + ": ");
            System.out.println("x: ");
            float x = this.in.nextFloat();
            System.out.println("y: ");
            float y = this.in.nextFloat();
            System.out.println("costo: ");
            float costo = this.in.nextFloat();
            NodoXY nodo = new NodoXY(x, y, costo);
            nodo.setName(this.names[i]);
            this.arrayNodos[i] = nodo;
;       }
        printMatriz();
    }
    
    private void printMatriz(){
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("Array de Nodos: ");
        for(int i = 0; i < this.itemsCount; i++){
            NodoXY nodo = this.arrayNodos[i];
            System.out.println("Nodo " + nodo.name + " ---> x:" + nodo.x + ", y:" + nodo.y + ", costo:" + nodo.costo + ", angulo: " + nodo.angulo);
        }
    }
    
    public NodoXY[] getArrayNodos(){
        return this.arrayNodos;
    }
    
}
