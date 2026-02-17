import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ExportadorXML {
    public void generarXMLReservas() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element root = doc.createElement("reservas");
            doc.appendChild(root);

            Connection conn = ConexionDB.conectar();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM RESERVAS");

            while (rs.next()) {
                Element reserva = doc.createElement("reserva");
                reserva.setAttribute("id", String.valueOf(rs.getInt("idReserva")));
                
                Element fecha = doc.createElement("fecha");
                fecha.appendChild(doc.createTextNode(rs.getString("fecha")));
                reserva.appendChild(fecha);

                root.appendChild(reserva);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("reservas.xml"));
            transformer.transform(source, result);

            System.out.println("Archivo reservas.xml generado con éxito.");
        } catch (Exception e) {
            System.out.println("Error al exportar XML: " + e.getMessage());
        }
    }
}