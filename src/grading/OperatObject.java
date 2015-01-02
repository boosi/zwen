package grading;

import static java.lang.System.out;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

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


/**
 * 被操作对象，用户输入与正确答案的字符串存储；<br/>
 * 在比较程序启动与运行的过程中，仅可以有一个该对象。<br/>
 * 所有的操作只能针对一个该对象；
 * @author Zhengwen 
 * @date 31 Dec, 2014
 * @version Grading 3.0 Builder	0009
 */
public  class OperatObject implements Document, Node {
	
	private DocumentBuilderFactory 		Factory 	= null;		//文档创建工厂；
	private DocumentBuilder 			Builder		= null;		//文档创建者；
	private InputStream 				inStream	= null;		//输入流；
	
	
	
	protected Document	 	document		= null;		//当前 MathML 文档对象；
	protected Node 			node 			= null;		//当前节点；
	protected Comparer 		comm;						//与主类沟通的通信对象；
	
	
	
	public boolean 			success			= false;	//创建对象成功为 true；否则为 false；
	
	
	
	/** MathML 字符串 **/
	public String 		Xmlstr		= "";
	
	
	
	//{rem 	构造器
	public OperatObject() {
		
	}
	
	public OperatObject(String strMathML) {
		Xmlstr = strMathML;
	}
	//}end
	
	
	
	//{rem 自定义方法；
	/**
	 * 由当前 MathML(Xmlstr) 字串创建文档对象；
	 * @return		org.w3c.dom.Document;
	 */
	protected Document ganerateDocument() {
		inStream 	= new ByteArrayInputStream(Xmlstr.getBytes());
		Factory 	= DocumentBuilderFactory.newInstance();
		try {
			Builder 	= Factory.newDocumentBuilder();
			document 	= Builder.parse(inStream);
			success = true;			//创建对象成功；
			return document;
		} 
		catch (ParserConfigurationException pex) {
			document = null;
			out.println(pex.getMessage());
			new Log().outLog(pex.getMessage());
			success = false;		//创建对象失败；
			return null;
		}
		catch (Exception ex) {
			document = null;
			out.println(ex.getMessage());
			new Log().outLog(ex.getMessage());
			success = false;		//创建对象失败；
			return null;
		}
	}
	
	
	/**
	 * 创建 W3C 节点。<br/>
	 * 仅将给定字符串转换为节点形式，并不是当前文档对象中的节点；
	 * @param strMathML		给定字串；
	 * @return				节点；
	 */
	protected static Node getNode(String strMathML) {
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		InputStream 		   i = new ByteArrayInputStream(strMathML.getBytes());
		try {
			DocumentBuilder b = f.newDocumentBuilder();
			Document d = b.parse(i);
			return  d.getDocumentElement();
		} 
		catch (ParserConfigurationException ex) {
			return null;
		}
		catch (Exception ex) {
			return null;
		}	
	}
	
	
	
	
	
	
	
	
	
	
	
	/**	公开方法	**/
	public Document getDocument() {
		return ganerateDocument();
	}
	
	//}end
	

	
	//{rem 实现接口的方法；凡方法上没有 javadoc文字的，是未实现的虚代码（方法）；
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

	
	public boolean isDefaultNamespace(String namespaceURI) {
		
		return false;
	}

	
	public boolean isEqualNode(Node arg) {
		
		return false;
	}

	
	public boolean isSameNode(Node other) {
		
		return false;
	}

	
	public boolean isSupported(String feature, String version) {
		
		return false;
	}

	
	public String lookupNamespaceURI(String prefix) {
		
		return null;
	}

	
	public String lookupPrefix(String namespaceURI) {
		
		return null;
	}

	
	public void normalize() {
		

	}

	
	public Node removeChild(Node oldChild) throws DOMException {
		
		return null;
	}

	
	public Node replaceChild(Node newChild, Node oldChild) throws DOMException {
		
		return null;
	}

	
	public void setNodeValue(String nodeValue) throws DOMException {
		

	}

	
	public void setPrefix(String prefix) throws DOMException {
		

	}

	
	public void setTextContent(String textContent) throws DOMException {
		

	}

	
	public Object setUserData(String key, Object data, UserDataHandler handler) {
		
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
		
		return null;
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
	
	
	
	//{rem	测试；
	public static void main(String[] args) {

	}
	//}end
	
}
