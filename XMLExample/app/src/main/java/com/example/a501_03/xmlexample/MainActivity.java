package com.example.a501_03.xmlexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView=(TextView)findViewById(R.id.textview_main);

        //xml 데이터 (평소에는 인터넷 혹은 파일로부터 읽어옴)
        String xml_str = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<root>\n" +
                "\t<item Maker=\"청주\">사과</item>\n" +
                "\t<item Maker=\"대전\">배</item>\n" +
                "\t<item Maker=\"제주도\">귤</item>\n" +
                "</root>";

        try{
            // xml을 다루기 위한 DocumentBuilderFactory, DocumentBuilder 객체 생성
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=factory.newDocumentBuilder();

            // xml 데이터를 바이트 형태로 바꿈
            InputStream input=new ByteArrayInputStream(xml_str.getBytes("utf-8"));

            // 바이트 형태의 xml 데이터에서 root 태그 안의 자료를 가져옴
            Document document=builder.parse(input);
            Element root=document.getDocumentElement();

            // root 태그 안의 item들을 분리
            NodeList items=root.getElementsByTagName("item");
            String buf="";
            for(int i=0;i<items.getLength();i++){
                // item 태그 안의 데이터를 읽어옴
                Node item=items.item(i);
                String value=item.getFirstChild().getNodeValue();

                //item 태그 안의 속성 값을 읽어옴
                //해당속성 그룹만 빼옴
                NamedNodeMap attr=item.getAttributes();
                for(int j=0;j<attr.getLength();j++){
                    Node attr_node=attr.item(j);
                    buf+=attr_node.getNodeValue()+"\n";
                }

                buf+=value+"\n";
            }
            textView.setText(buf);
        }catch (Exception e){

        }
    }
}
