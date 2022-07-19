import java.util.*;
import java.io.*;

class Node {
	public int value;
	public Node next;

    public Node(){
    	this.value = -1;
    }

	public Node(int value){
		this.value = value;
		this.next = null;
	}
}

class list {
	public Node head;

	public list(){
		head = new Node();
	}

	public void insertBegin(int value){
		if(head.value==-1) {
			head.value = value;
		} else {
			Node temp = new Node(value);
			temp.next = head;
			head = temp;
		}
		
	}

    public void insertEnd(int value){
    	Node temp = new Node(value);
    	Node curr = head;
    	while(curr.next!=null){
    		curr = curr.next;
    	}
    	curr.next = temp;
    }

    public void insertAfter(int after, int value){
    	Node temp = new Node(value);
    	Node curr = head, prev=null;
    	while(curr!=null){
    		if(curr.value==after) {
    			temp.next = curr.next;
    			curr.next = temp;
    		}
    		curr = curr.next;
    	}
    }

    public void deleteBegin(){
    	Node temp = head;
		head = head.next;
		temp.next = null;
	}

    public void deleteEnd(){
    	Node curr = head, prev=null;
    	while(curr.next!=null){
    		prev = curr;
    		curr = curr.next;
    	}
    	prev.next = null;
    }

    public void deleteKey(int key){
    	Node curr = head, prev=null;
    	if(curr!=null && curr.value==key){
    		head = curr.next;
    	}
    	while(curr!=null && curr.value!=key){
    		prev = curr;
       		curr = curr.next;
    	}
    	if(curr==null) return;
    	prev.next = curr.next;
    }

    public boolean searchKey(int key){
    	Node curr = head;
    	while(curr!=null){
    		if(curr.value==key) return true;
    	}
    	return false;
    }

    public void printList(){
    	Node curr = head;
    	while(curr!=null){
    		System.out.println(curr.value);
    		curr = curr.next;
    	}
    }
}

class DSA{
	public static void main(String[] args) {
		list l = new list();
		l.insertBegin(1);
		l.insertEnd(2);
		l.insertBegin(4);
		l.insertAfter(4,3);
		//l.printList();
		l.insertEnd(5);
		l.insertEnd(6);
		l.insertBegin(7);
		System.out.println("printing list");
		l.printList();
		l.deleteBegin();
		l.deleteEnd();
		l.deleteKey(1);
		System.out.println("printing list");
		l.printList();
	}
}
