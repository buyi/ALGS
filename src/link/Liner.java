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
	
	private Node addFirst (Node node) {
		Node oldfirst = node;
		Node first = new Node(9);
		first.next = oldfirst;
		return first;
	}
	
	private Node deleteFirst (Node node) {
		node = node.next;
		return node;
	}
	
	private Node deleteLast (Node node) {
		Node previous = null;
		Node head = node;
		while (node != null) {
			if (node.next == null) {
				previous.next = null;
			} else {
				previous = node;
			}
			node = node.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		Liner link = new Liner();
		link.PrintNode(link.deleteLast(link.deleteFirst(link.addFirst(link.createNode()))));
	}
}
