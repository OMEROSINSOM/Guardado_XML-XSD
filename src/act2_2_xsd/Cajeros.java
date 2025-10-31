
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

public class Cajeros extends Personas {
   private double fondoInicial;
   private double fondoFinal;
   private int numEmpleado;

    public Cajeros() {
        super ();
        fondoInicial=1000;
        fondoFinal=1000;
        numEmpleado = 0;
    }

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }
    
    public double getFondoInicial() {
        return fondoInicial;
    }

    public void setFondoInicial(double fondoInicial) {
        this.fondoInicial = fondoInicial;
    }

    public double getFondoFinal() {
        return fondoFinal;
    }

    public void setFondoFinal(double fondoFinal) {
        this.fondoFinal = fondoFinal;
    }
  
   
   
    
}
