
package act2_2_xsd;

/*
    Alumno: Ari Santiago Piceno Rodríguez
    Registro:23300223
    Grado y Grupo: 4C1
    
    Materia: POO 2 (Programación Orientada a Objetos 2)
    Carrera: Desarrollo de Software
    Producto: Act4 Practica de Validacion XSD
    Profe: ROA
    
    Fecha: 15/mayo/2025
    
    */

public class Personas {
    private String nombre;
    private String app;
    private String apm;

    public Personas() {
        nombre="";
        app="";
        apm="";      
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getApm() {
        return apm;
    }

    public void setApm(String apm) {
        this.apm = apm;
    }
}
