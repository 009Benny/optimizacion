/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Scanner;

/**
 *
 * @author 52812
 */
public class RutaMasCorta {
    private Scanner in;
    public Grafo myGrafo;
    public String[] visitados;
    public int inicio, fin;
    public int itemsCount;
    
    public RutaMasCorta(Grafo obj) {
        char aux;
        this.myGrafo = obj;
        this.in = new Scanner(System.in);
        this.itemsCount =  obj.itemsCount;
        String[] items = this.myGrafo.getArrayItems();
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println(items);
        System.out.println("Seleccione el nodo de origen del conjunto: ");
        aux = in.next().charAt(0);
        
        this.inicio = in.nextInt();
        do{
            System.out.println("Seleccione el nodo de destino del conjunto: ");
            this.fin = in.nextInt();
            if(this.inicio == this.fin){
                System.out.println("El nodo destino no puede ser el mismo que el nodo origen");
            }
        }while(this.fin != this.inicio);
        calcular();
    }
    
    public void calcular(){
        
    }
    
}
