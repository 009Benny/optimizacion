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
public class BarridoClass {
    private Scanner in;
    private float maxCosto;
    private GrafoCoordenadas myGrafo;
    private NodoXY[] arrayNodos;
    private Recorrido[] recorridos;
    
    public BarridoClass(GrafoCoordenadas object) {
        this.myGrafo = object;
        this.arrayNodos = this.myGrafo.getArrayNodos();
        this.in = new Scanner(System.in);
        System.out.println("");
        System.out.println("");
        float max = this.getMaxCost();
        do{
            System.out.println("Ingresa el numero maximo del costo en cada recorrido: ");
            this.maxCosto = this.in.nextInt();
            if(max > this.maxCosto){
                System.out.println("El costo maximo(" + this.maxCosto + ") por recorrido debe ser mayor al mayor costo en el grafo (" + max + ")");
            }
        }while(max > this.maxCosto);
        calcular();
    }
    
    private float getMaxCost(){
        float max = 0;
        for(int i=0; i<this.arrayNodos.length; i++){
            if (this.arrayNodos[i].costo > max){
                max = this.arrayNodos[i].costo;
            }
        }
        return max;
    }
    
    private void calcular(){
        ordenarDistancias();
        this.createNewRecorrido();
        for(int i=0; i<this.arrayNodos.length; i++){
            NodoXY nodo = this.arrayNodos[i];
            if ( !this.recorridos[this.recorridos.length - 1].puedeAgregarNodo(this.arrayNodos[i]) ){
                this.createNewRecorrido();
            }
            this.recorridos[this.recorridos.length -1].agregaNodo(this.arrayNodos[i]);
        }
        this.imprimirResultados();
    }
    
    private void createNewRecorrido(){
        if (this.recorridos == null){
            this.recorridos = new Recorrido[1];
            this.recorridos[0] = new Recorrido(this.maxCosto);
        }else{
            Recorrido[] aux = new Recorrido[this.recorridos.length + 1];
            System.arraycopy(this.recorridos, 0, aux, 0, this.recorridos.length);
            aux[this.recorridos.length] = new Recorrido(this.maxCosto);
            this.recorridos = aux;
        }
    }
    
    private void ordenarDistancias(){
        for(int i = 0; i < this.arrayNodos.length; i++){
            for(int j = i+1; j < this.arrayNodos.length; j++){
                if (this.arrayNodos[i].angulo > this.arrayNodos[j].angulo) {
                    NodoXY temp = this.arrayNodos[i];
                    this.arrayNodos[i] = this.arrayNodos[j];
                    this.arrayNodos[j] = temp;
                }
            }
        }
    }
    
    private void imprimirResultados(){
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("Se necesitan " + this.recorridos.length + " recorridos:");
        System.out.println("");
        for(int i=0; i<this.recorridos.length; i++){
            Recorrido obj = this.recorridos[i];
            System.out.println("Recorrido " + i + "=> costoTotal:" + obj.costoActual);
            System.out.print("[");
            for(int j=0; j < obj.nodosRecorrido.length; j++){
                System.out.print(obj.nodosRecorrido[j].name );
                if (j != obj.nodosRecorrido.length - 1){
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

}
