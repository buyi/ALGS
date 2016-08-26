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
//		while (node != null) {
//			if (node.next == null) {
//				previous.next = null;
//			} else {
//				previous = node;
//			}
//			node = node.next;
//		}
		
		while (node.next != null) {
			previous = node;
			node = node.next;
		}
		previous.next = null;
		return head;
	}
	
	private boolean find (int value, Node node) {
		while (node.next != null) {
			if (value == node.value) {
				return true;
			}
			node = node.next;
		}
		if (value == node.value) {
			return true;
		}
		return false;
	}
	
	private Node getSpecified (int index, Node node) {
		int i = 0;
		while (node.next != null) {
			
			if (i == index) 
				break;
			node = node.next;
			i++;
		
		}
		return node;
	}
	
	private Node deleteSpecified (int index, Node node) {
		Node previous = null;
		Node head = node;
		int i = 0;
		while (node.next != null) {
			if (i == index)
				break;
			previous = node;
			node = node.next;
			i++;
		}
		
		if (previous != null) {
			if (index <= i) { // 只在index小于等于整体链表的时候做操作
				previous.next = node.next;
			}
		} else {
			head = node.next;
		}
		return head;
	}
	
	
	public Node removeAfter (Node node) {
		return null;
	}
	public static void main(String[] args) {
		Liner link = new Liner();
		//link.deleteLast(link.deleteFirst(link.addFirst(link.createNode())))
//		link.PrintNode(link.deleteSpecified(4, link.addFirst(link.createNode())));
		
//		System.out.println(link.find(1, link.addFirst(link.createNode())));
	}
}
