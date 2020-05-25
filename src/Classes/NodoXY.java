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
public class NodoXY {
    public float x;
    public float y;
    public float costo;
    public float angulo;
    public String name;
    
    public NodoXY(float x, float y, float costo){
        this.x = x;
        this.y = y;
        this.costo = costo;
        this.angulo = this.calcularAngulo();
    }
    
    private float calcularAngulo(){
        if (x == 0){
            return (y > 0) ? 90 : (y < 0) ? 270 : 0;
        }else if (y == 0){
            return (x > 0) ? 0 : (x < 0) ? 180 : 0;
        }
        double angulo = 0;
        double aux = Math.toDegrees(Math.atan(y/x));
        if ((x < 0 && y > 0) || (x < 0 && y < 0)){
            aux += 180;
        }else if ((x > 0 && y < 0)){
            System.out.println(aux);
            aux += 360;
        }
        return (float) aux;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }

}
