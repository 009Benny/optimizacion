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
public final class Grafo {
    private Scanner in;
    String[] names;
    int[][] matrizValues;
    int itemsCount;

    public Grafo(boolean random) {
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
    
    public void fillMatrizManually(){
        System.out.println("");
        System.out.println("");
        System.out.println("");
        this.matrizValues = new int[this.itemsCount][this.itemsCount];
        for(int i = 0; i < this.itemsCount; i++){
            for(int j = 0; j < this.itemsCount; j++){
                if (j > i){
                    System.out.println("Ingrese el costo de '" + this.names[i] + " a '" + this.names[j] + "': ");
                    int value = this.in.nextInt();
                    this.matrizValues[i][j] = value;
                }else if (j == i){
                    this.matrizValues[i][j] = 0;
                }else{
                    this.matrizValues[i][j] = this.matrizValues[j][i];
                }
            }
        }
        if (isGrafoValid()){
            System.out.println("Si es Valido");
        }else{
            System.out.println("No es Valido");
        }
        printMatriz();
    }
    
    public void createRandomValues(){
        int min = 0, max = 9;
        this.matrizValues = new int[this.itemsCount][this.itemsCount];
        for(int i = 0; i < this.itemsCount; i++){
            for(int j = 0; j < this.itemsCount; j++){
                int random = ThreadLocalRandom.current().nextInt((max - min) + 1) + min;
                int value = (i == j) ? 0 : random;
                if (j < i){
                    this.matrizValues[i][j] = this.matrizValues[j][i];
                }else{
                    this.matrizValues[i][j] = value;
                }
            }
        }
        printMatriz();
    }
    
    public void printMatriz(){
        System.out.print("  ");
        for(int i = 0; i < this.itemsCount; i++){
            System.out.print(this.names[i] + " ");
        }
        for(int i = 0; i < this.itemsCount; i++){
            System.out.println(" ");
            System.out.print(this.names[i] + " ");
            for(int j = 0; j < this.itemsCount; j++){
                System.out.print(this.matrizValues[i][j] + " ");
            }
        }
    }
    
    public boolean isGrafoValid(){
        // Validar que todos los nodos estan unidos a la matriz
        boolean[] validate = new boolean[this.itemsCount];
        for(int i = 0; i < this.itemsCount; i++){
            validate[i] = false;
            for(int j = 0; j < this.itemsCount; j++){
                if (this.matrizValues[i][j] > 0){
                    validate[i] = true;
                    break;
                }
            }
        }
        
        for(int i = 0; i < this.itemsCount; i++){
            if (!validate[i]){
                System.out.println("Error en grafo " + this.names[i]);
                return false;
            }
        }
        return true;
    }
    
    public int getItemsCount(){
       return this.itemsCount;
    }
    
    public String[] getArrayItems(){
        String[] items = new String[this.itemsCount];
        System.arraycopy(this.names, 0, items, 0, this.itemsCount);
        return items;
    }
}

