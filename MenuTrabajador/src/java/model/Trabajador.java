package model;
import java.io.Serializable;

public class Trabajador implements Serializable {
    private String nomina, nombre, mac;
        
    public Trabajador(String nomina, String nombre, String mac){
        this.nomina = nomina;
        this.nombre = nombre;
        this.mac = mac;
    }

    public Trabajador() {
    }

    public String getNomina() {
        return nomina;
    }

    public void setNomina(String nomina) {
        this.nomina = nomina;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }
}
