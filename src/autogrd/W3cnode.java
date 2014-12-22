package autogrd;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;
import static java.lang.System.*;




/**
 * 实现了 W3C 标准的 DOM 节点；<br/>
 * 用于处理单个的节点对象；
 * @author Zhengwen 
 * @date 19 Dec, 2014
 * @version Grading 3.0 Builder 008
 */
public class W3cnode implements Node {

	private Node wnode		= null;					//当前实时节点；
	
	private DocumentBuilderFactory 		Factory 	= null;		//文档创建工厂；
	private DocumentBuilder 			Builder		= null;		//文档创建者；
	private InputStream 				inStream	= null;		//输入流；
	private Document	 				document	= null;		//MathML 文档对象；
	
	
	
	
	
	/**
	 * 构造器；
	 */
	public W3cnode() {
		super();
	}
	
	/**
	 * 构造器，以给定的字符串构造一个 W3C 节点；<br />
	 * 参数 MathNL 字符串必须是单节点；
	 * @param xmlstr		MathNL 字符串；
	 * @exception	ParserConfigurationException	配置不正确，不能创建节点时抛出此异常；
	 * @exception	Exception						所有未知的异常；
	 */
	public W3cnode(String xmlstr) {
		inStream	= new ByteArrayInputStream(xmlstr.getBytes());
		Factory 	= DocumentBuilderFactory.newInstance();
		try {
			Builder 	= Factory.newDocumentBuilder();
			document 	= Builder.parse(inStream);
			wnode		= document.getDocumentElement();
		} 
		catch (ParserConfigurationException pex) {
			out.println(pex.getMessage());
			new EventLog().outLog(pex.getMessage());
		}
		catch (Exception ex) {
			out.println(ex.getMessage());
			new EventLog().outLog(ex.getMessage());
		}	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//{bgn 实现接口定义方法；【已实现的代码的都会给出方法说明；故：凡方法上没有说明文字的，是未实现的虚代码（方法）；
	public Node appendChild(Node newChild) throws DOMException {
		return wnode.appendChild(newChild);
	}

	public Node cloneNode(boolean deep) {
		return wnode.cloneNode(deep);
	}

	public short compareDocumentPosition(Node other) throws DOMException {
		return wnode.compareDocumentPosition(other);
	}

	public NamedNodeMap getAttributes() {
		return wnode.getAttributes();
	}

	public String getBaseURI() {
		return wnode.getBaseURI();
	}

	public NodeList getChildNodes() {
		return wnode.getChildNodes();
	}

	public Object getFeature(String feature, String version) {
		return wnode.getFeature(feature, version);
	}

	public Node getFirstChild() {
		return wnode.getFirstChild();
	}

	public Node getLastChild() {
		return wnode.getLastChild();
	}

	public String getLocalName() {
		return wnode.getLocalName();
	}

	public String getNamespaceURI() {
		return wnode.getNamespaceURI();
	}

	public Node getNextSibling() {
		return wnode.getNextSibling();
	}

	public String getNodeName() {
		return wnode.getNodeName();
	}

	public short getNodeType() {
		return wnode.getNodeType();
	}

	public String getNodeValue() throws DOMException {
		return wnode.getNodeValue();
	}

	public Document getOwnerDocument() {
		return wnode.getOwnerDocument();
	}

	public Node getParentNode() {
		return wnode.getParentNode();
	}

	public String getPrefix() {
		return wnode.getPrefix();
	}

	public Node getPreviousSibling() {
		return wnode.getPreviousSibling();
	}

	public String getTextContent() throws DOMException {
		return wnode.getTextContent();
	}

	public Object getUserData(String key) {
		return wnode.getUserData(key);
	}

	public boolean hasAttributes() {
		return wnode.hasAttributes();
	}

	public boolean hasChildNodes() {
		return wnode.hasChildNodes();
	}

	public Node insertBefore(Node newChild, Node refChild) throws DOMException {
		return wnode.insertBefore(newChild, refChild);
	}

	public boolean isDefaultNamespace(String namespaceURI) {
		return wnode.isDefaultNamespace(namespaceURI);
	}

	public boolean isEqualNode(Node arg) {
		return wnode.isEqualNode(arg);
	}

	public boolean isSameNode(Node other) {
		return wnode.isSameNode(other);
	}

	public boolean isSupported(String feature, String version) {
		return wnode.isSupported(feature, version);
	}

	public String lookupNamespaceURI(String prefix) {
		return wnode.lookupNamespaceURI(prefix);
	}

	public String lookupPrefix(String namespaceURI) {
		return wnode.lookupPrefix(namespaceURI);
	}

	public void normalize() {
		wnode.normalize();
	}

	public Node removeChild(Node oldChild) throws DOMException {
		return wnode.removeChild(oldChild);
	}

	public Node replaceChild(Node newChild, Node oldChild) throws DOMException {
		return wnode.replaceChild(newChild, oldChild);
	}

	public void setNodeValue(String nodeValue) throws DOMException {
		wnode.setNodeValue(nodeValue);
	}

	public void setPrefix(String prefix) throws DOMException {
		wnode.setPrefix(prefix);
	}

	public void setTextContent(String textContent) throws DOMException {
		wnode.setTextContent(textContent);
	}

	public Object setUserData(String key, Object data, UserDataHandler handler) {
		return wnode.setUserData(key, data, handler);
	}
	//}end
	

	
	
	// For test!!
	public static void main(String[] args) {
		
	}
	
	
}
