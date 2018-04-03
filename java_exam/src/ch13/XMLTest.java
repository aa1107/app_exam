package ch13;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class XMLTest {
    public static void main(String[] args){
        try{
            URL url=new URL("http://openapi.seoul.go.kr:8088/sample/xml/ListCulturalAssetsInfo/1/5");
            InputStream stream=url.openStream();
            InputStreamReader reader=new InputStreamReader(stream);
            char ch=0;
            DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
            org.w3c.dom.Document doc=dBuilder.parse(stream);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :"+doc.getDocumentElement().getNodeName());
            NodeList nList =doc.getElementsByTagName("row");
            System.out.println("-----------------------");

            for(int temp=0;temp<nList.getLength();temp++){
                Node nNode = nList.item(temp);
                if(nNode.getNodeType()==Node.ELEMENT_NODE){
                    org.w3c.dom.Element eElement = (org.w3c.dom.Element)nNode;
                    System.out.println("문화재 번호: "+getTagValue("MANAGE_NUM",eElement));
                    System.out.println("문화재 이름: "+getTagValue("NAME_KOR",eElement));
                    System.out.println("문화재 한자명: "+getTagValue("NAME_CNI",eElement));
                    System.out.println("문화재 크기: "+getTagValue("SCALE",eElement));
                    System.out.println();
                }
            } //end for문

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getTagValue(String sTag, org.w3c.dom.Element eElement){
        NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
        Node nValue = (Node)nlList.item(0);
        return nValue.getNodeValue();
    }
}
