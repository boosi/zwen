package autogrd;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.EntityReference;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;
import org.w3c.dom.UserDataHandler;

public class OptDocumt implements Document {

	private Document doc;
	
	
	public OptDocumt(String instr) {
		InputStream				ins	= new ByteArrayInputStream(instr.getBytes());
		DocumentBuilderFactory	fct = DocumentBuilderFactory.newInstance();
		DocumentBuilder			bud; 
		try {
			bud = fct.newDocumentBuilder();
			doc = bud.parse(ins);
		}
		catch (Exception ex) {
			System.out.println("ERROR:\n\t"+ex.getMessage());
			doc = null;
		}
	}
	
	
	
	
	public static Document generatDocument(String instr) {
		InputStream				ins	= new ByteArrayInputStream(instr.getBytes());
		DocumentBuilderFactory	fct = DocumentBuilderFactory.newInstance();
		DocumentBuilder			bud; 
		Document				doc;
		try {
			bud = fct.newDocumentBuilder();
			doc = bud.parse(ins);
		}
		catch (Exception ex) {
			try {
				new EventLog().outLog(ex.getMessage());
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
			return null;
		}
		return doc;
	}
	
	
	public Document getDocument() {
		
		
		
		return this;
	}
	
	
	
	//{bgn 	实现继承的接口方法；已实现代码的都会有说明文字；凡是在方法上没有说明文字的，都是没有实现的代码的方法；
	public Node appendChild(Node arg0) throws DOMException {
		
		return null;
	}

	public Node cloneNode(boolean arg0) {
		
		return null;
	}

	public short compareDocumentPosition(Node arg0) throws DOMException {
		
		return 0;
	}

	public NamedNodeMap getAttributes() {
		
		return null;
	}

	public String getBaseURI() {
		
		return null;
	}

	public NodeList getChildNodes() {
		
		return null;
	}

	public Object getFeature(String arg0, String arg1) {
		
		return null;
	}

	public Node getFirstChild() {
		
		return null;
	}

	public Node getLastChild() {
		
		return null;
	}

	public String getLocalName() {
		
		return null;
	}

	public String getNamespaceURI() {
		
		return null;
	}

	public Node getNextSibling() {
		
		return null;
	}

	public String getNodeName() {
		
		return null;
	}

	public short getNodeType() {
		
		return 0;
	}

	public String getNodeValue() throws DOMException {
		
		return null;
	}

	public Document getOwnerDocument() {
		
		return null;
	}

	public Node getParentNode() {
		
		return null;
	}

	public String getPrefix() {
		
		return null;
	}

	public Node getPreviousSibling() {
		
		return null;
	}

	public String getTextContent() throws DOMException {
		
		return null;
	}

	public Object getUserData(String arg0) {
		
		return null;
	}

	public boolean hasAttributes() {
		
		return false;
	}

	public boolean hasChildNodes() {
		
		return false;
	}

	public Node insertBefore(Node arg0, Node arg1) throws DOMException {
		
		return null;
	}

	public boolean isDefaultNamespace(String arg0) {
		
		return false;
	}

	public boolean isEqualNode(Node arg0) {
		
		return false;
	}

	public boolean isSameNode(Node arg0) {
		
		return false;
	}

	public boolean isSupported(String arg0, String arg1) {
		
		return false;
	}

	public String lookupNamespaceURI(String arg0) {
		
		return null;
	}

	public String lookupPrefix(String arg0) {
		
		return null;
	}

	public void normalize() {
		
		
	}

	public Node removeChild(Node arg0) throws DOMException {
		
		return null;
	}

	public Node replaceChild(Node arg0, Node arg1) throws DOMException {
		
		return null;
	}

	public void setNodeValue(String arg0) throws DOMException {
		
		
	}

	public void setPrefix(String arg0) throws DOMException {
		
		
	}

	public void setTextContent(String arg0) throws DOMException {
		
		
	}

	public Object setUserData(String arg0, Object arg1, UserDataHandler arg2) {
		
		return null;
	}

	public Node adoptNode(Node source) throws DOMException {
		
		return null;
	}

	public Attr createAttribute(String name) throws DOMException {
		
		return null;
	}

	public Attr createAttributeNS(String namespaceURI, String qualifiedName) throws DOMException {
		
		return null;
	}

	public CDATASection createCDATASection(String data) throws DOMException {
		
		return null;
	}

	public Comment createComment(String data) {
		
		return null;
	}

	public DocumentFragment createDocumentFragment() {
		
		return null;
	}

	public Element createElement(String tagName) throws DOMException {
		
		return null;
	}

	public Element createElementNS(String namespaceURI, String qualifiedName) throws DOMException {
		
		return null;
	}

	public EntityReference createEntityReference(String name) throws DOMException {
		
		return null;
	}

	public ProcessingInstruction createProcessingInstruction(String target, String data) throws DOMException {
		
		return null;
	}

	public Text createTextNode(String data) {
		
		return null;
	}

	public DocumentType getDoctype() {
		
		return null;
	}

	public Element getDocumentElement() {
		
		return doc.getDocumentElement();
	}

	public String getDocumentURI() {
		
		return null;
	}

	public DOMConfiguration getDomConfig() {
		
		return null;
	}

	public Element getElementById(String elementId) {
		
		return null;
	}

	public NodeList getElementsByTagName(String tagname) {
		
		return null;
	}

	public NodeList getElementsByTagNameNS(String namespaceURI, String localName) {
		
		return null;
	}

	public DOMImplementation getImplementation() {
		
		return null;
	}

	public String getInputEncoding() {
		
		return null;
	}

	public boolean getStrictErrorChecking() {
		
		return false;
	}

	public String getXmlEncoding() {
		
		return null;
	}

	public boolean getXmlStandalone() {
		
		return false;
	}

	public String getXmlVersion() {
		
		return null;
	}

	public Node importNode(Node importedNode, boolean deep) throws DOMException {
		
		return null;
	}

	public void normalizeDocument() {
		
		
	}

	public Node renameNode(Node n, String namespaceURI, String qualifiedName) throws DOMException {
		
		return null;
	}

	public void setDocumentURI(String documentURI) {
		
		
	}

	public void setStrictErrorChecking(boolean strictErrorChecking) {
		
		
	}

	public void setXmlStandalone(boolean xmlStandalone) throws DOMException {
		
		
	}
	
	public void setXmlVersion(String xmlVersion) throws DOMException {
		
		
	}
	//}end
	

	
	
	//** For Tesr!
	public static void main(String[] args) {
		OptDocumt optDocumt = new OptDocumt("<math xmlns=\"http://www.w3.org/1998/Math/MathML\"><mn>65</mn><mi>x</mi></math>");
		System.out.println(optDocumt.getDocumentElement());

	}

}
