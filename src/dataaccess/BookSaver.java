package dataaccess;

import org.json.simple.JSONObject;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import business.Book;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class BookSaver {

	@SuppressWarnings("unchecked")
	public void saverJson(Book book) {
		
		JSONObject books = new JSONObject();
		
		books.put("id", book.getItemNo());
		books.put("name", book.getName());
		books.put("author", book.getAuthor());
		books.put("publisher", book.getPublisher());
		
		try {

			FileWriter file = new FileWriter(book.getItemNo()+".json");
			file.write(books.toJSONString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void saverXml(Book book) {
		try {
			
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

			Document document = documentBuilder.newDocument();

			Element root = document.createElement("item");
			document.appendChild(root);

			Element bookItem = document.createElement("book");

			root.appendChild(bookItem);

			Attr attr = document.createAttribute("id");
			attr.setValue(book.getItemNo() + "");
			bookItem.setAttributeNode(attr);

			Element name = document.createElement("name");
			name.appendChild(document.createTextNode(book.getName()));
			bookItem.appendChild(name);

			Element author = document.createElement("author");
			author.appendChild(document.createTextNode(book.getAuthor()));
			bookItem.appendChild(author);

			Element publisher = document.createElement("publisher");
			publisher.appendChild(document.createTextNode(book.getPublisher()));
			bookItem.appendChild(publisher);


			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File(book.getItemNo() + ".xml"));

			transformer.transform(domSource, streamResult);

			System.out.println("Done creating XML File");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}
	
}
