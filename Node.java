/*
*	The class creates a node structure to be used for linkedlist
*   @author Tobenna Okunna, Faisal Binateeq
*	04/15/19
*/
public class Node {
	
	//fields
	private String str;
	private int code;
	private Node next;

	/*
	* constructor for item and node
	* @param String newStr, the string to be placed in the node
	* @param int newCode, the code of the string to be placed in the node
	*/
	public Node(String newStr, int newCode)
	{
		str = newStr;
		code = newCode;
		next = null;
	}

	/*
	* constructor for item and node
	* @param String newStr, the string to be placed in the node
	* @param int newCode, the code of the string to be placed in the node
	* @param Node newNode, the node to hold the string and code
	*/
	public Node(String newStr, int newCode, Node newNode)
	{
		 str = newStr;
		code = newCode;
		next = newNode;
	}
	//default constructor for node
	public Node()
	{
		str = null;
		code = 0;
		next = null;
	}

	//@return the current node
	public Node getNode()
	{ 
		return this;
	}

	//@return the code field in the node
	public int getCode()
	{
		return this.code;
	}

	// @return the string field in the node
	public String getString()
	{
		return this.str;
	}

	// @return the next node
	public Node getNext()
	{
		return next;
	}

	/*
	* method to set the next node
	* @param the new node to be added
	*/
	public void setNext(Node newNode)
	{
		next = newNode;
	}

	/*
	* method to set the string in the node
	* @param String newStr, the string to be added
	*/
	public void setString(String newStr) 
	{
		str = newStr;
	}

	/*
	* method to set the code in the node
	* @param int newCode, the code to be added
	*/
	public void setCode(int newCode) {
		code = newCode;
	}

	/*
	* method to set the code in the node and to set the next node
	* @param int newCode, the code to be added
	* @param String newStr, the string to be added
	*/
	public void setBoth(String newStr, int newKey) 
	{
		str = newStr;
		code= newKey;
	}

	/*
	* method to get the char in the node
	* @param int posi, the position of the node
	*/
	public char charAt(int posi)
	{
		return str.charAt(posi);
	}
}