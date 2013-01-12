package com.wika;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import java.io.IOException;
import java.io.InputStream;

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
import java.util.ArrayList;

/**
 * Portlet implementation class PortletOk
 */
public class PortletOk extends GenericPortlet {

    public void init() {
        viewJSP = getInitParameter("view-template");
        System.out.println("i am init");
        }
    
    public static void main(String argv[]){
    	ClassLoader cl = ClassLoader.class.getClassLoader();
    	System.out.println("i am main");
    }
    
    private static String getTagValue(String sTag, Element eElement) {
    	NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
     
            Node nValue = (Node) nlList.item(0);
     
    	return nValue.getNodeValue();
      }
    
    
    public void getData(String id){
    	int val=0;
    	int ech=0;
    	ArrayList listWp1 = new ArrayList();
    	ArrayList listWp2 = new ArrayList();
    	ArrayList listWp3 = new ArrayList();
    	ArrayList listWp4 = new ArrayList();
    	ArrayList listWp5 = new ArrayList();
    	ArrayList listWp6 = new ArrayList();
    	if(id=="WP1"){
    		
    	}else if(id=="WP2"){
    		
    	}else if(id=="WP3"){
    		
    	}else if(id=="WP4"){
    		
    	}else if(id=="WP5"){
    		
    	}else if(id=="WP6"){
    		
    	}
    	try {
    		File fXmlFile = new File("/Users/ferdianrobianto/Sites/liferay-portal-6.1.1-ce-ga2/tomcat-7.0.27/webapps/portlet-ok-portlet/WEB-INF/src/com/wika/xml_ok.xml");
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
				  //int kdpat=Integer.parseInt(getTagValue("KD_PAT", eElement));
				  //int kdsbu=Integer.parseInt(getTagValue("KD_SBU", eElement));
				  double rip=Double.parseDouble(getTagValue("RI_PEROLEHAN", eElement));
			      switch(getTagValue("KD_PAT", eElement)){
			      case "1A":			    	  
				      	switch(getTagValue("KD_SBU", eElement)){
				      	case "A":
				      		listWp1.add(rip);
				      		break;
				      	case "B":
				      		listWp1.add(rip);
				      		break;
				      	case "C":
				      		listWp1.add(rip);
				      		break;
				      	case "D":
				      		listWp1.add(rip);
				      		break;
				      	case "E":
				      		listWp1.add(rip);
				      		break;
				      	case "F":
				      		listWp1.add(rip);
				      		break;
				      	case "G":
				      		listWp1.add(rip);
				      		break;
				      	case "H":
				      		listWp1.add(rip);
				      		break;
				      	case "I":
				      		listWp1.add(rip);
				      		break;
				      	case "J":
				      		listWp1.add(rip);
				      		break;
				      	}
			    	  //System.out.println("I am 1A");
			      		break;
			      case "1B":
			    	  //System.out.println("I am 1B");	
		      		  	break;
			      case "1C":
			    	  //System.out.println("I am 1C");
		      		  	break;
			      case "1D":
			    	  //System.out.println("I am 1D");
		      		  	break;
			      case "1E":
			    	  //System.out.println("I am 1E");
		      		  	break;
			      case "1F":
			    	  //System.out.println("I am 1F");
		      		  	break;
			      case "WB":
			    	  //System.out.println("I am WB");
		      		  	break;
		      	  default:
		      		  break;
			      }
			    
			      //System.out.println("Kode PAT : " + getTagValue("KD_PAT", eElement));
			      //System.out.println("KD SBU : " + getTagValue("KD_SBU", eElement));
		          //System.out.println("RI Perolehan : " + getTagValue("RI_PEROLEHAN", eElement));
			      
			   }
			}
		  } catch (Exception e) {
			e.printStackTrace();
		  }
    	if(id=="WP1"){
	    	Object ia[] = listWp1.toArray();
	    	double sum = 0; 
	    	// sum the array 
	    	for(int i=0; i<ia.length; i++){
	    	sum += ((double) ia[i]);  
	    	}
	    	int tot = (int)sum;
	    	System.out.println("Total : " + tot);
    	}
    }
    
    public void doView(
            RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {
    	this.getData("WP1");
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
