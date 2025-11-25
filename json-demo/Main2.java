import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {//creating main method
    public static void main(String[] args) throws Exception {
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	DocumentBuilder builder = factory.newDocumentBuilder();
	Document doc = builder.parse("books.xml");
	doc.normalize();
	NodeList list = doc.getElementsByTagName("book");
	for(int i =0;i<list.getLength();i++)
	{
		Node node = list.item(i);
		if(node.getNodeType()== doc.ELEMENT_NODE)//check if node is element
		{
			Element book = (Element) node;
			String id = book.getAttribute("id");
			String title = book.getElementsByTagName("title").item(0).getTextContent();
			String author = book.getElementsByTagName("author").item(0).getTextContent();
			System.out.println(id);
			System.out.println(title);
			System.out.println(author);
		}
	}
	
	SAXParserFactory saxBuilder = SAXParserFactory.newInstance();
	SAXParser parser = saxBuilder.newSAXParser();
	
	DefaultHandler handler = new DefaultHandler() {//handler for the parser
		boolean btitle = false;
		boolean bgenre = false;
		int count = 0;
		List<String> list = new ArrayList<>();
		String bookName="";
		@Override
		public void startElement(String uri , String localname , String qname , Attributes attributes) throws SAXException
		{
			if(qname.equalsIgnoreCase("book")) {
				count++;}
			else if(qname.equalsIgnoreCase("title")) {
				btitle = true;
			}
			else if(qname.equalsIgnoreCase("genre")) {
				bgenre = true ;
			}
		}
		@Override//override character method
		public void characters(char[] ch , int start , int length) throws SAXException{
			if(btitle) {
				bookName = new String(ch,start,length);
				btitle = false;
				}
			if(bgenre) {
				String bookGenre = new String(ch,start,length);
				if(bookGenre.equalsIgnoreCase("fantasy"))
				{
					list.add(bookName);
				}
				bgenre=false;
			}
		}
		
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException{
			
				}
			
		@Override
        public void endDocument() throws SAXException {//printing final count here instead of endElement
            System.out.println("Total number of books: " + count);
            System.out.println("Fantasy Books:");
            for (String s : list) {
                System.out.println("   - " + s);
            }
        }

		
	}
	parser.parse("books.xml",handler);
	
    }
	
	
	
}	
