package juego;

import java.io.File;

import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;


public class Fichero {
    
    public void leerXML() {
        try {
            File archivo = new File("usuarios");
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(archivo);
            
            document.getDocumentElement().normalize();
            
            System.out.println("Elemento raiz: " + document.getDocumentElement().getNodeName());
            
            NodeList listaUsuarios = document.getElementsByTagName("USUARIO");
            
            for(int i = 0 ; i < listaUsuarios.getLength() ; i++) {
                Node nodo = listaUsuarios.item(i);
                System.out.println("Elemento: " + nodo.getNodeName());
                
                if(nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;
                    System.out.println("ID: " + element.getElementsByTagName("ID").item(0).getTextContent());
                    System.out.println("Nombre: " + element.getElementsByTagName("NOMBRE").item(0).getTextContent());
                    System.out.println("Telefono: " + element.getElementsByTagName("TELEFONO").item(0).getTextContent());
                    
                    System.out.println("");
                }
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void crearXML(String nomArchivo, List<Usuario> listaUsuarios) throws ParserConfigurationException, TransformerConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, nomArchivo, null);
            document.setXmlVersion("1.0");
            
            // NODO RAIZ
            Element raiz = document.getDocumentElement();
            
            for(int i = 0 ; i <listaUsuarios.size() ; i++) {
                Element itemNode = document.createElement("USUARIO");
                
                Element idNode = document.createElement("NOMBRE");
                Text nodeIdValue =document.createTextNode("" +  listaUsuarios.get(i).getNombre());
                idNode.appendChild(nodeIdValue);
                
                Element nombreNode = document.createElement("PUNTAJE");
                Text nodeNombreValue =document.createTextNode(listaUsuarios.get(i).getPuntaje());
                nombreNode.appendChild(nodeNombreValue);
                
                itemNode.appendChild(idNode);
                itemNode.appendChild(nombreNode);
                
                raiz.appendChild(itemNode);
            }
            
            // GENERA XML
            Source source = new DOMSource(document);
            
            // DONDE SE GUARDARA
            Result result = new StreamResult(new java.io.File(nomArchivo + ".xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
        
        } catch(ParserConfigurationException e) {
            
        }
    }
    
}