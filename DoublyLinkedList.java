import java.io.*;
import java.util.*;
class DoublyLinkedList {
	int length = 0;
	class Node{
		int data;
		Node next;
		Node previous;
		public Node(int data){
		    this.data = data; 
			this.next=null;
			this.previous=null;
		}
	}
	Node head = null;
	Node tail = null;
	
	public void insert(int data){
		Node newNode = new Node(data);
		if(head == null){
			head = tail = newNode;
			length++;
		}
		else {
			tail.next = newNode;
			newNode.previous = tail;
			tail = newNode;
			length++;
		}
	}
	
	public void insertAt(int data,int pos){
		Node newNode = new Node(data);
		Node currNode = head;
		Node nextNode = currNode.next;
		int count = 0;
		try{
		if(pos == 1){
			newNode.next = head;
			head.previous = newNode;
			head = newNode;
			length++;
		}
		else if(pos == length+1){
			tail.next = newNode;
	        newNode.previous = tail;
			tail = newNode;
			length++;
		}
			
		else {
			while(count<pos-2){
				currNode = currNode.next;
				nextNode = nextNode.next;
				count++;
			}
			currNode.next = newNode;
			newNode.previous = currNode;
			newNode.next = nextNode;
			nextNode.previous = newNode;
			length++;
		}
		}catch(Exception e){System.out.println("Wrong position"); }
		
	}
	
			
	public void delete(int pos){
		int count = 0;
		Node currNode = head;
		Node nextNode = currNode.next;
		if(pos == 1){
			head = head.next;
		}
		else if(pos == length){
			Node prev = tail.previous;
			prev.next = null;
			tail = prev;
		}
		else {
			while(count<pos-2){
				currNode = currNode.next;
				nextNode = nextNode.next;
				count++;
			}
			currNode.next = nextNode.next;
			nextNode.next.previous = currNode;
		}
		length--;
	}
	
	public void deleteBy(int data){
		Node currNode = head;
		Node nextNode = currNode.next;
		try{
		if(currNode.data == data){
			head = head.next;
			length--;
		}
		else if(currNode.data == tail.data){
			Node prev = tail.previous;
			prev.next = null;
			length--;
		}

		else {
			while(nextNode.data != data){
				currNode = currNode.next;
				nextNode = nextNode.next;
			}
			currNode.next = nextNode.next;
			nextNode.previous = currNode;
			length--;
		}
		}catch(Exception e){System.out.println("No data"); }
	}
	
				
	public void display(){
		Node currNode = head;
		if(currNode == null)
			System.out.println("List is empty");
		else {
			while(currNode != null){
				System.out.print(currNode.data+" ");
				currNode = currNode.next;
			}
			System.out.println("\nlength of list "+length);
		}
	}
	
	public static void main(String[] args){
		DoublyLinkedList list = new DoublyLinkedList();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		list.display();
		list.delete(6);
		System.out.println("Deleted sixth element");
		list.display();
		System.out.println("Inserting 10 at pos 6");
		list.insertAt(10,7);
		list.display();
		System.out.println("delete 10 using data");
		list.deleteBy(10);
		list.display();
	}
}