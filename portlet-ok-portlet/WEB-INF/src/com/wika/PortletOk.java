package com.wika;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import java.io.IOException;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

/**
 * Portlet implementation class PortletOk
 */
public class PortletOk extends GenericPortlet {

    public void init() {
        viewJSP = getInitParameter("view-template");
    }
    
    public static void main(String argv[]){
    	try {
    		 
			File fXmlFile = new File("../../../../assets/doc/xml_ok.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
	 
			//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("DATA_RECORD");
			//System.out.println("-----------------------");
	 
			for (int temp = 0; temp < nList.getLength(); temp++) {
	 
			   Node nNode = nList.item(temp);
			   if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	 
			      Element eElement = (Element) nNode;
	 
			      System.out.println("Kode PAT : " + getTagValue("KD_PAT", eElement));
			      System.out.println("KD SBU : " + getTagValue("KD_SBU", eElement));
		          System.out.println("RI Perolehan : " + getTagValue("RI_Perolehan", eElement));
			      //System.out.println("Salary : " + getTagValue("salary", eElement));
			   }
			}
		  } catch (Exception e) {
			e.printStackTrace();
		  }
    }
    
    private static String getTagValue(String sTag, Element eElement) {
    	NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
     
            Node nValue = (Node) nlList.item(0);
     
    	return nValue.getNodeValue();
      }
    
    
    
    public void doView(
            RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {
        include(viewJSP, renderRequest, renderResponse);
    }

    protected void include(
            String path, RenderRequest renderRequest,
            RenderResponse renderResponse)
        throws IOException, PortletException {

        PortletRequestDispatcher portletRequestDispatcher =
            getPortletContext().getRequestDispatcher(path);

        if (portletRequestDispatcher == null) {
            _log.error(path + " is not a valid include");
        }
        else {
            portletRequestDispatcher.include(renderRequest, renderResponse);
        }
    }
 
    protected String viewJSP;		

    private static Log _log = LogFactoryUtil.getLog(PortletOk.class);

}
