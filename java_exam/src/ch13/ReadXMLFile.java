package ch13;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ReadXMLFile {
    public static void main(String[] args){
        try{
            File fXmlFile = new File("company.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root element :"+doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("emp");
            System.out.println("---------------");

            for(int temp=0;temp<nList.getLength();temp++){
                Node nNode = nList.item(temp);
                if(nNode.getNodeType()==Node.ELEMENT_NODE){
                    Element eElement = (Element)nNode;
                    System.out.println("First Name : "+getTagValue("firstname",eElement));
                    System.out.println("Last Name : "+getTagValue("lastname",eElement));
                    System.out.println("Nick Name : "+getTagValue("nickname",eElement));
                    System.out.println("Salary : "+getTagValue("salary",eElement));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static String getTagValue(String firstname, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(firstname).item(0).getChildNodes();
        Node nValue = (Node)nlList.item(0);
        return nValue.getNodeValue();
    }
}
