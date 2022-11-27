
public class SingleLinkList {
    public Node head = null;    
    public Node tail = null;    
    
    
    public int addNode(int data) {    
        //Create a new node    
        Node newNode = new Node(data);    
            
        //Checks if the list is empty    
        if(head == null) {    
            //If list is empty, both head and tail will point to new node    
            head = newNode;    
            tail = newNode;    
        }    
        else {    
            //newNode will be added after tail such that tail's next will point to newNode    
            tail.next = newNode;    
            //newNode will become new tail of the list    
            tail = newNode;    
        }    
        return this.head.data;
    }    
    
    public void display() {    
        //Node current will point to head    
        Node current = head;    
            
        if(head == null) {    
            System.out.println("List is empty");    
            return;    
        }    
        System.out.println("Nodes of singly linked list: ");    
        while(current != null) {    
            //Prints each node by incrementing pointer    
            System.out.print(current.data + " ");    
            current = current.next;    
        }    
        System.out.println();    
    }    
        
	
    public void removeFront() {
    	Node newNode;
    	newNode = this.head;
    	this.head = newNode.next;
    	newNode=null;
    }

}
class Node{    
    int data;    
    Node next;    
        
    public Node(int data) {    
        this.data = data;    
        this.next = null;    
    }    
}    
 