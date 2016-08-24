package link;

public class Liner {
	class Node {
		int value;
		Node next;
		
		Node (int value) {
			this.value = value;
		}
	}
	
	
	public Node createNode() {
		Node first = new Node(1);
		first.next = new Node (3);
		first.next.next = new Node(7);
		return first;
	}
	
	public void PrintNode (Node node) {
		while (node != null) {
			System.out.println("value:" + node.value);
			node = node.next;
		}
	}
	
	public static void main(String[] args) {
		Liner link = new Liner();
		link.PrintNode(link.createNode());
	}
}
