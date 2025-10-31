
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
public class Clientes extends Personas {
    private int numCliente;
    private String rfc;
    private char tipo;
    private double salarioMensual;
    private String direccion;

    public Clientes() {
       super();
       rfc="";
       tipo='N';
       salarioMensual=0;
       direccion="";
    }

    public int getNumCliente() {
        return numCliente;
    }

    public void setNumCliente(int numCliente) {
        this.numCliente = numCliente;
    }
    
    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        tipo=Character.toUpperCase(tipo);
        if (tipo=='V'||tipo=='N'||tipo=='P')
            this.tipo = tipo;
    }

    public double getSalarioMensual() {
        return salarioMensual;
    }

    public void setSalarioMensual(double salarioMensual) {
        this.salarioMensual = salarioMensual;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public boolean depositar (double cantidad)
    {
        return true;
    }
    
    public boolean retirar (double cantidad)
    {
        return true;
    }
    
    
}
