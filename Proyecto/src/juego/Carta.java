package juego;

import javax.swing.*;
public class Carta {
    protected int posicion = 0;
    protected int valor = 0;
    protected boolean revelado = false;
    
    ImageIcon image; //imagen de la carta
    JButton boton; //interacción con botón 
    ImageIcon fondo;
    public Carta(int valor, String nombre, int posicion) {
        this.valor = valor;
        this.posicion = posicion;
        //objetos tipo carta con 3 argumentos
        try {
            image = new ImageIcon(this.getClass().getResource("/imagenes/"+nombre+""));
            fondo = new ImageIcon(this.getClass().getResource("tarjetaAtras110x110.png"));
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}