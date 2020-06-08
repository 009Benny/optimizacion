/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimizacion;

import Classes.BarridoClass;
import Classes.BusquedaTabu;
import Classes.Grafo;
import Classes.GrafoCoordenadas;
import Classes.GrafoVector;
import Classes.RutaMasCorta;
import java.util.Scanner;

/**
 *
 * @author Benny Reyes Sosa
 */
public class Menu {
    private Grafo myGrafo;
    private GrafoCoordenadas myGrafoXY;
    
    public Menu() {
        int option = 0;
        do{
            option = this.printMenu();
            this.selectorAction(option);
        }while(option != 0);
    }
    
    private int printMenu(){
        int option = 0;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("Selecciona el la acción a realizar");
            System.out.println("0.-Salir");
            System.out.println("1.-Crear Grafo Manual");
            System.out.println("2.-Crear Grafo Random");
            System.out.println("3.-Crear Grafo Coordenadas");
            System.out.println("4.-Crear Grafo Coordenadas Random");
            System.out.println("5.-Ruta mas corta");
            System.out.println("6.-Problema de barrido");
            System.out.println("7.-Busqueda Tabu");
            System.out.println("");
            System.out.println("Ingresa tu opción: ");
            option = in.nextInt();
        }while(option > 7 || option < 0);
        return option;
    }
    
    private void selectorAction(int option){
        switch(option){
            case 1:
                this.myGrafo = new Grafo(false);
                break;
            case 2:
                this.myGrafo = new Grafo(true);
                break;
            case 3:
                this.myGrafoXY = new GrafoCoordenadas(false);
                break;
            case 4:
                this.myGrafoXY = new GrafoCoordenadas(true);
                break;
            case 5:
                GrafoVector grafo = new GrafoVector();
                RutaMasCorta ruta = new RutaMasCorta(grafo);
                break;
            case 6:
                if(this.myGrafoXY != null){
                    BarridoClass obj = new BarridoClass(this.myGrafoXY);
                }else{
                    System.out.println("");
                    System.out.println("Necesitas crear un grafo coordenadas");
                }
                break;
            case 7:
                if(this.myGrafo != null){
                    BusquedaTabu obj = new BusquedaTabu(this.myGrafo);
                }else{
                    System.out.println("");
                    System.out.println("Necesitas crear un grafo normal");
                }
                break;
        }
    }
    
}
