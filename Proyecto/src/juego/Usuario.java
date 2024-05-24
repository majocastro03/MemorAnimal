package juego;

public class Usuario {
    String nombre;
    String puntaje;
    public Usuario(String nombre, String puntaje) {
        this.nombre = nombre;
        this.puntaje = puntaje;
    }
    public String getNombre() {
        return nombre;
    }
   
    public String getPuntaje() {
        return puntaje;
    }
    
    
}