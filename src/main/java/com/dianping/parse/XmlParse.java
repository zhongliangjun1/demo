package com.dianping.parse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ClassRelativeResourceLoader;
import org.springframework.core.io.Resource;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-3-29
 * Time: AM8:37
 * To change this template use File | Settings | File Templates.
 */
public class XmlParse {


    public static void processWithWoodstox() throws XMLStreamException, IOException {
        XMLInputFactory xmlif = XMLInputFactory.newInstance();
        xmlif.setProperty(
                XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES,
                Boolean.TRUE);
        xmlif.setProperty(
                XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES,
                Boolean.FALSE);
        //set the IS_COALESCING property to true to get whole text data as one event.
        xmlif.setProperty(XMLInputFactory.IS_COALESCING, Boolean.TRUE);

        XMLEventReader r = xmlif.createXMLEventReader(getXmlFileInputStream("/config/spring/aspectj-aop.xml"));

        while (r.hasNext()) {
            XMLEvent e = r.nextEvent();
            if (e.isStartElement()) {
                System.out.println(e.toString());
                System.out.println(e.isStartElement());
            }
        }
    }

    private static InputStream getXmlFileInputStream(String path) throws IOException {
        ClassPathResource loader = new ClassPathResource(path, XmlParse.class.getClassLoader());
        return loader.getInputStream();
    }

    public static void main(String[] args) throws  Exception{
        ClassPathResource loader = new ClassPathResource("/config/spring/aspectj-aop.xml", XmlParse.class.getClassLoader());
        System.out.println(loader.getURL());
        System.out.println(loader.getPath());
        processWithWoodstox();
    }


}
