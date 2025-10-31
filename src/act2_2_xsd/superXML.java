
package act2_2_xsd;

import java.io.File;
import java.io.IOException;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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

public class superXML {
    private File archClientes;
    private File archCajeros;
    private File datos;
    private DocumentBuilderFactory dbFactory;
    private DocumentBuilder dBuilder;
    private Document doc;
    private HashMap<Integer, Clientes> diccioCL;
    private HashMap<Integer, Cajeros> diccioCJ; 


    public superXML(File archClientes, File archCajeros, File datos) {
     
        this.archClientes=archClientes;
        this.archCajeros=archCajeros;
        this.datos = datos;
        diccioCL = new HashMap();
        diccioCJ = new HashMap();
    }
    
    public HashMap<Integer, Clientes> leeXMLClientes() throws NullPointerException
    {
        try{
            dbFactory=DocumentBuilderFactory.newInstance();
            dBuilder=dbFactory.newDocumentBuilder();
            doc=dBuilder.parse(archClientes);
        }catch (Exception e)
        {
             JOptionPane.showMessageDialog(null,"Error al abrir el archivo XML","Banco Internacional de Hyrule (BIH)",JOptionPane.ERROR_MESSAGE);
             throw new NullPointerException(); 
        }
        //Eliminar nodos vacios
        doc.getDocumentElement().normalize();
        
        NodeList nList = doc.getElementsByTagName("Cliente");
        
        for (int i=0;i<nList.getLength();i++)
        {
            Clientes c=new Clientes();
            Node nodo=nList.item(i);
            if (nodo.getNodeType()==Node.ELEMENT_NODE)
            {
                Element elemento =(Element) nodo;
                c.setNumCliente(Integer.parseInt(elemento.getAttribute("numCliente")));
                c.setNombre(elemento.getElementsByTagName("Nombre").item(0).getTextContent());
                c.setApp(elemento.getElementsByTagName("App").item(0).getTextContent());
                c.setApm(elemento.getElementsByTagName("Apm").item(0).getTextContent());
                c.setRfc(elemento.getElementsByTagName("RFC").item(0).getTextContent());
                c.setTipo(elemento.getElementsByTagName("Tipo").item(0).getTextContent().charAt(0));
                c.setSalarioMensual(Double.parseDouble(elemento.getElementsByTagName("Salario_Mensual").item(0).getTextContent()));
                c.setDireccion(elemento.getElementsByTagName("Direccion").item(0).getTextContent());
                diccioCL.put(c.getNumCliente(), c);
              }
        }
        return diccioCL;
    }
    
    public HashMap<Integer, Cajeros> leeXMLCajeros() throws NullPointerException
    {
        try{
            dbFactory=DocumentBuilderFactory.newInstance();
            dBuilder=dbFactory.newDocumentBuilder();
            doc=dBuilder.parse(archCajeros);
        }catch (Exception e)
        {
             JOptionPane.showMessageDialog(null,"Error al abrir el archivo XML","Banco Internacional de Hyrule (BIH)",JOptionPane.ERROR_MESSAGE);
             throw new NullPointerException(); 
        }
        //Eliminar nodos vacios
        doc.getDocumentElement().normalize();
        
        NodeList nList = doc.getElementsByTagName("Cajero");
        
        for (int i=0;i<nList.getLength();i++)
        {
            Cajeros c=new Cajeros();
            Node nodo=nList.item(i);
            if (nodo.getNodeType()==Node.ELEMENT_NODE)
            {
                Element elemento =(Element) nodo;
                c.setNumEmpleado(Integer.parseInt(elemento.getAttribute("numEmpleado")));
                c.setNombre(elemento.getElementsByTagName("Nombre").item(0).getTextContent());
                c.setApp(elemento.getElementsByTagName("App").item(0).getTextContent());
                c.setApm(elemento.getElementsByTagName("Apm").item(0).getTextContent());
                c.setFondoInicial(Double.parseDouble(elemento.getElementsByTagName("FondoInicial").item(0).getTextContent()));
                c.setFondoFinal(Double.parseDouble(elemento.getElementsByTagName("FondoFinal").item(0).getTextContent()));
                
                diccioCJ.put(c.getNumEmpleado(), c);
              }
        }
        return diccioCJ;
    }
    
    public int[] leeDatosXML() throws NullPointerException
    {
        int[] dat = new int[2];
        try{
            dbFactory=DocumentBuilderFactory.newInstance();
            dBuilder=dbFactory.newDocumentBuilder();
            doc=dBuilder.parse(datos);
        }catch (Exception e)
        {
             JOptionPane.showMessageDialog(null,"Error al abrir el archivo XML","Banco Internacional de Hyrule (BIH)",JOptionPane.ERROR_MESSAGE);
             throw new NullPointerException(); 
        }
        //Eliminar nodos vacios
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("Dato");
            
        Node nodo=nList.item(0);
        if (nodo.getNodeType()==Node.ELEMENT_NODE)
        {
            Element elemento =(Element) nodo;
            dat[0] = Integer.parseInt(elemento.getElementsByTagName("numClientes").item(0).getTextContent());
            dat[1] = Integer.parseInt(elemento.getElementsByTagName("numCajeros").item(0).getTextContent());
        }
        return dat;
    }

    public void escribirXMLClientes(HashMap<Integer, Clientes> diccioCL, int numCL)
    {
         try{
           
            
            dbFactory=DocumentBuilderFactory.newInstance();
            dBuilder=dbFactory.newDocumentBuilder();
            doc=dBuilder.newDocument();
            
            Element raiz = doc.createElement("Clientes");
            doc.appendChild(raiz);
            
            for (int i=1;i<=numCL;i++)
            {
                if (diccioCL.get(i) != null){
                    Clientes tmp=(Clientes)diccioCL.get(i);
                    Element cliente=doc.createElement("Cliente");
                    raiz.appendChild(cliente);
                    Attr atributo=doc.createAttribute("numCliente");
                    atributo.setValue(String.valueOf(tmp.getNumCliente()));
                    cliente.setAttributeNode(atributo);

                    Element nombreCliente=doc.createElement("Nombre");
                    nombreCliente.appendChild(doc.createTextNode(tmp.getNombre()));
                    cliente.appendChild(nombreCliente);

                    Element appCliente=doc.createElement("App");
                    appCliente.appendChild(doc.createTextNode(tmp.getApp()));
                    cliente.appendChild(appCliente);

                    Element apmCliente=doc.createElement("Apm");
                    apmCliente.appendChild(doc.createTextNode(tmp.getApm()));
                    cliente.appendChild(apmCliente);

                    Element rfcCliente=doc.createElement("RFC");
                    rfcCliente.appendChild(doc.createTextNode(tmp.getRfc()));
                    cliente.appendChild(rfcCliente);

                    Element tipoCliente=doc.createElement("Tipo");
                    tipoCliente.appendChild(doc.createTextNode(String.valueOf(tmp.getTipo())));
                    cliente.appendChild(tipoCliente);

                    Element salarioCliente=doc.createElement("Salario_Mensual");
                    salarioCliente.appendChild(doc.createTextNode(String.valueOf(tmp.getSalarioMensual())));
                    cliente.appendChild(salarioCliente);

                    Element direccionCliente=doc.createElement("Direccion");
                    direccionCliente.appendChild(doc.createTextNode(tmp.getDireccion()));
                    cliente.appendChild(direccionCliente);
                }
            }
            
            TransformerFactory tFactory=TransformerFactory.newInstance();
                Transformer optimusPrime=null;
                    try {
                        optimusPrime = tFactory.newTransformer();
                    } catch (TransformerConfigurationException ex) {
                    }
                DOMSource source = new DOMSource(doc);
                StreamResult resultado=new StreamResult (new File("XML/clientes.xml"));
                    try {
                        optimusPrime.transform(source, resultado);
                    } catch (TransformerException ex) {
                    }
            
        } catch (Exception e){
                JOptionPane.showMessageDialog(null,e.getCause());
        }
    }
    
    public void escribirXMLCajeros(HashMap<Integer, Cajeros> diccioCJ, int numCJ)
    {
         try{
           
            dbFactory=DocumentBuilderFactory.newInstance();
            dBuilder=dbFactory.newDocumentBuilder();
            doc=dBuilder.newDocument();
            
            Element raiz = doc.createElement("Cajeros");
            doc.appendChild(raiz);
            
            for (int i=1;i<=numCJ;i++)
            {
                if (diccioCJ.get(i) != null){
                    Cajeros tmp = (Cajeros) diccioCJ.get(i);
                    Element empleado=doc.createElement("Cajero");
                    raiz.appendChild(empleado);
                    Attr atributo=doc.createAttribute("numEmpleado");
                    atributo.setValue(String.valueOf(tmp.getNumEmpleado()));
                    empleado.setAttributeNode(atributo);

                    Element nombreEmpleado=doc.createElement("Nombre");
                    nombreEmpleado.appendChild(doc.createTextNode(tmp.getNombre()));
                    empleado.appendChild(nombreEmpleado);

                    Element appEmpleado=doc.createElement("App");
                    appEmpleado.appendChild(doc.createTextNode(tmp.getApp()));
                    empleado.appendChild(appEmpleado);

                    Element apmEmpleado=doc.createElement("Apm");
                    apmEmpleado.appendChild(doc.createTextNode(tmp.getApm()));
                    empleado.appendChild(apmEmpleado);

                    Element F_InicialeEmpleado=doc.createElement("FondoInicial");
                    F_InicialeEmpleado.appendChild(doc.createTextNode(String.valueOf(tmp.getFondoInicial())));
                    empleado.appendChild(F_InicialeEmpleado);

                    Element F_FinalEmpleado=doc.createElement("FondoFinal");
                    F_FinalEmpleado.appendChild(doc.createTextNode(String.valueOf(tmp.getFondoFinal())));
                    empleado.appendChild(F_FinalEmpleado);
                } 
            }
            
            TransformerFactory tFactory=TransformerFactory.newInstance();
                Transformer optimusPrime=null;
                    try {
                        optimusPrime = tFactory.newTransformer();
                    } catch (TransformerConfigurationException ex) {
                    }
                DOMSource source = new DOMSource(doc);
                StreamResult resultado=new StreamResult (new File("XML/cajeros.xml"));
                    try {
                        optimusPrime.transform(source, resultado);
                    } catch (TransformerException ex) {
                    }
            
        } catch (Exception e){
                JOptionPane.showMessageDialog(null,e.getCause());
        }
    }
    
    public void escribeDatosXML(int numClientes, int numCajeros)
    {
         try{
           
            dbFactory=DocumentBuilderFactory.newInstance();
            dBuilder=dbFactory.newDocumentBuilder();
            doc=dBuilder.newDocument();
            
            Element raiz = doc.createElement("Datos");
            doc.appendChild(raiz);
            
            Element datos=doc.createElement("Dato");
            raiz.appendChild(datos);
            
            Element numCL=doc.createElement("numClientes");
            numCL.appendChild(doc.createTextNode(String.valueOf(numClientes)));
            datos.appendChild(numCL);
            
            Element numCJ=doc.createElement("numCajeros");
            numCJ.appendChild(doc.createTextNode(String.valueOf(numCajeros)));
            datos.appendChild(numCJ);
            
            TransformerFactory tFactory=TransformerFactory.newInstance();
            Transformer optimusPrime=null;
                try {
                    optimusPrime = tFactory.newTransformer();
                } catch (TransformerConfigurationException ex) {
                }
            DOMSource source = new DOMSource(doc);
            StreamResult resultado=new StreamResult (new File("XML/datos.xml"));
                try {
                    optimusPrime.transform(source, resultado);
                } catch (TransformerException ex) {
                }
            
        } catch (Exception e){
                JOptionPane.showMessageDialog(null,e.getStackTrace());
        }
    }
    
    public boolean validaXML()
    {
        SchemaFactory factory =
                SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schemaCL=null;
        Schema schemaCJ=null;
        Schema schemaDat=null;
        try {
            schemaCL = factory.newSchema(new File("XSD/clientes.xsd"));
            schemaCJ = factory.newSchema(new File("XSD/cajeros.xsd"));
            schemaDat = factory.newSchema(new File("XSD/datos.xsd"));
        } catch (org.xml.sax.SAXException ex) {
            return false;
        }
        Validator validatorCL = schemaCL.newValidator();
        Validator validatorCJ = schemaCJ.newValidator();
        Validator validatorDat = schemaDat.newValidator();
        try {
            validatorCL.validate(new StreamSource(new File("XML/clientes.xml")));
            validatorCJ.validate(new StreamSource(new File("XML/cajeros.xml")));
            validatorDat.validate(new StreamSource(new File("XML/datos.xml")));
        } catch (IOException ex) {
            return false;
        } catch (org.xml.sax.SAXException ex) {
            return false;
         }
        return true;
    }
}