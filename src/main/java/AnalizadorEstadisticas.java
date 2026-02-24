import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

public class AnalizadorEstadisticas {
    public void contarReservasPorDia(String fechaBusqueda) {
        try {
            Document doc = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder().parse("reservas.xml");
            XPath xpath = XPathFactory.newInstance().newXPath();
            
            // Consulta para contar nodos que contienen la fecha específica
            String expresion = "count(//reserva[contains(fecha, '" + fechaBusqueda + "')])";
            Double count = (Double) xpath.evaluate(expresion, doc, XPathConstants.NUMBER);
            
            System.out.println("Reservas encontradas para el día " + fechaBusqueda + ": " + count.intValue());
        } catch (Exception e) {
            System.err.println("Error al procesar XPath: " + e.getMessage());
        }
    }
}