package dataaccess;
import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


import business.Book;


public class BookSaverXml {
	
	
	public BookSaverXml(Book book) {
		
		try {

			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

			Document document = documentBuilder.newDocument();

			// root element
			Element root = document.createElement("item");
			document.appendChild(root);

			// employee element
			Element employee = document.createElement("book");

			root.appendChild(employee);

			// set an attribute to staff element
			Attr attr = document.createAttribute("id");
			attr.setValue(book.getItemNo() + "");
			employee.setAttributeNode(attr);

			//you can also use staff.setAttribute("id", "1") for this

			// firstname element
			Element name = document.createElement("name");
			name.appendChild(document.createTextNode(book.getName()));
			employee.appendChild(name);

			// email element
			Element author = document.createElement("author");
			author.appendChild(document.createTextNode(book.getAuthor()));
			employee.appendChild(author);

			// department elements
			Element publisher = document.createElement("publisher");
			publisher.appendChild(document.createTextNode(book.getPublisher()));
			employee.appendChild(publisher);

			// create the xml file
			//transform the DOM Object to an XML File
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(System.out);

			// If you use
			// StreamResult result = new StreamResult(System.out);
			// the output will be pushed to the standard output ...
			// You can use that for debugging 

			transformer.transform(domSource, streamResult);

			System.out.println("Done creating XML File");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}
}

