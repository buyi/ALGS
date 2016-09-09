package link;

import java.util.Random;


//struct Node{
//    int data;
//    Node* next;
//};

class Node {
	int data;
	Node next;
	
	Node (int data) {
		this.data = data;
	}
}
public class LinkSample {

	//O(1)时间删除链表节点，从无头单链表中删除节点
	public void deleteRandomNode(Node cur)
	{
	    assert(cur != null);
	    assert(cur.next != null);    //不能是尾节点
	    
	    
	    Node pNext = cur.next;
	    cur.data = pNext.data;
	    cur.next = pNext.next;
	}
	
	//单链表的转置,循环方法
	Node reverseByLoop(Node head)
	{
	    if(head == null || head.next == null)
	        return head;
	    
	    // head 永远指向未调整next引用的结点
	    // pre 永远指向head
	    // next 永远储存下个结点
	    // pre head next 依次指向头三个元素
	    Node pre = null;
	    Node next = null;
	    while(head != null)
	    {
	    	// 指向下个结点
	        next = head.next;
	        //  调整head的指向 
	        head.next = pre;
	        // 调整pre的指向
	        pre = head;
	        // 调整head的指向
	        head = next;
	    }
	    return pre;
	}

	//单链表的转置,递归方法
	Node reverseByRecursion(Node head)
	{
	    //第一个条件是判断异常，第二个条件是结束判断
	    if(head == null || head.next == null) 
	        return head;

	    Node newHead = reverseByRecursion(head.next);

	    head.next.next = head;
	    head.next = null;

	    return newHead;    //返回新链表的头指针
	}
	
	Node getSpecified (int index, Node node) {
		int i = 0;
		// 如果一个链表不是最后一个 则进去更新当前引用
		while (node.next != null) {
			if (i == index) 
				break;
			node = node.next;
			i++;
		}
		return node;
	}
	
	//倒数第k个节点
	Node theKthNode(Node head,int k)
	{
	    if(k < 0) return null;    //异常判断

	    Node slow, fast;
	    slow = fast = head;
	    int i = k;
	    for(;i>0 && fast!=null;i--)
	    {
	        fast = fast.next;
	    }

	    if(i > 0)    return null;    //考虑k大于链表长度的case

	    while(fast != null)
	    {
	        slow = slow.next;
	        fast = fast.next;
	    }

	    return slow;
	}
	
	//求链表的中间节点
	Node theMiddleNode(Node head)
	{
	    if(head == null)
	        return null;
	    Node slow,fast;
	    slow = fast = head;
	    //如果要求在链表长度为偶数的情况下，返回中间两个节点的第一个，可以用下面的循环条件
	    //while(fast && fast->next != NULL && fast->next->next != NULL)  
	    while(fast != null && fast.next != null)
	    {
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	    return slow;
	}
	
	//判断单链表是否存在环,参数circleNode是环内节点，后面的题目会用到
	boolean hasCircle(Node head,Node circleNode)
	{
	    Node slow,fast;
	    slow = fast = head;
	    while(fast != null && fast.next != null)
	    {
	        fast = fast.next.next;
	        slow = slow.next;
	        if(fast == slow)
	        {
	            circleNode = fast;
	            return true;
	        }
	    }

	    return false;
	}
	
	//判断两个链表是否相交
	boolean isIntersect(Node h1,Node h2)
	{
	    if(h1 == null || h2 == null) return false;    //异常判断
	    while(h1.next != null)
	    {
	        h1 = h1.next;
	    }

	    while(h2.next != null)
	    {
	        h2 = h2.next;
	    }

	    if(h1 == h2) return true;        //尾节点是否相同
	    else return false;
	}
	
	
	public Node createNode() {
		
		Node first = new Node(8);
		Node header = first;
		for (int i = 0; i <= 5; i++) {
			Node newNode = new Node(random.nextInt(100));
			first.next = newNode;
			first = first.next;
		}
		return header;
	}
	
	public void PrintNode (Node node) {
		while (node != null) {
			System.out.println("value:" + node.data);
			node = node.next;
		}
		System.out.println("----------");
	}
	
	Node header = null;
	Random random = new Random();
	public static void main(String[] args) {
		LinkSample s = new LinkSample();
		
		
//		Node header = s.createNode();
//		s.PrintNode (header);
//		s.deleteRandomNode(s.getSpecified(7, header));;
//		s.PrintNode (header);
		
		
//		Node head1 = s.createNode();
//		s.PrintNode (head1);
//		
//		Node back1 = s.reverseByRecursion (head1);
////		Node back1 = s.reverseByLoop (head1);
//		s.PrintNode (back1);
		
		
		
		Node head2 = s.createNode();
		s.PrintNode (head2);
		
		Node back2 = s.theKthNode(head2, 2);
		s.PrintNode (back2);
	}
	
	
}
