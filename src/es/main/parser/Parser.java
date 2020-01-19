package es.main.parser;

import java.io.File;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Parser {

   private final static String PATH_TO_XML = "C:\\Users\\manue\\Desktop\\animelist.xml";
   private final static String OUTPUT_NAME = "animes.txt";
	
   public static void main(String[] args) {

      try {
    	  
    	 // INPUT
         File in = new File(PATH_TO_XML);
         
         // OUTPUT
         PrintWriter out = new PrintWriter(OUTPUT_NAME);
         
         // TO DOCUMENT
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         DocumentBuilder builder = factory.newDocumentBuilder();
         Document document = builder.parse(in);
         
         // GETTING ANIME LIST
         document.getDocumentElement().normalize();
         NodeList nList = document.getElementsByTagName("anime");
         
         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               out.println(eElement
                       .getElementsByTagName("series_title")
                       .item(0)
                       .getTextContent());
            }
         }
         
         //SAVING
         out.flush();

      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}