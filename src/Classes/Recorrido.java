/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Benny Reyes Sosa
 */
public class Recorrido {
    public float max;
    public NodoXY[] nodosRecorrido;
    public float costoActual;
    
    public Recorrido(float max) {
        this.max = max;
        this.costoActual = 0;
    }    

    public boolean puedeAgregarNodo(NodoXY nodo){
        float aux = this.costoActual + nodo.costo;
        return (aux <= this.max);
    }

    public void agregaNodo(NodoXY nodo){
        if(this.nodosRecorrido == null){
            this.nodosRecorrido = new NodoXY[1];
            this.nodosRecorrido[0] = nodo;
            this.costoActual = nodo.costo;
        }else{
            NodoXY[] aux = new NodoXY[this.nodosRecorrido.length + 1];
            System.arraycopy(this.nodosRecorrido, 0, aux, 0, this.nodosRecorrido.length);
            aux[this.nodosRecorrido.length] = nodo;
            this.nodosRecorrido = aux;
            this.costoActual += nodo.costo;
        }
        
    }
}
