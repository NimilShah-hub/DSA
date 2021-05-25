package project;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;
import project.DLL.Node;
import  java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DLL { 
Node head;// head of list


/* Doubly Linked list Node*/
class Node { 
	long car_price;
	String car_model;
	String car_name;
	 int car_id;
 
 Node prev; 
 Node next;
 public int data; 

 // Constructor to create a new node 
 // next and prev is by default initialized as null 
 Node(long a,String b,String c,int d ) { 
     car_price = a;
     car_model = b;
     car_name = c;
     car_id= d;
 } 
} 



public void append(long  new_data1, String new_data2, String new_data3,int new_data4) 
{ 
    /* 1. allocate node  
     * 2. put in the data */
	
    Node new_node = new Node(new_data1,new_data2,new_data3,new_data4); 
   
    Node last = head; /* used in step 5*/
  
    /* 3. This new node is going to be the last node, so 
     * make next of it as NULL*/
    new_node.next = null; 
  
    /* 4. If the Linked List is empty, then make the new 
     * node as head */
    if (head == null) { 
        new_node.prev = null; 
        head = new_node; 
        return; 
    } 
  
    /* 5. Else traverse till the last node */
    while (last.next != null) 
        last = last.next; 
  
    /* 6. Change the next of last node */
    last.next = new_node; 
  
    /* 7. Make last node as previous of new node */
    new_node.prev = last; 
} 

public void deleteNode(Node head_ref, Node del) { 
	  
	
	
    /* base case */
    if (head == null || del == null) { 
        return; 
    } 

    /* If node to be deleted is head node */
    if (head == del) { 
        head = del.next; 
    } 

    /* Change next only if node to be deleted is NOT the last node */
    if (del.next != null) { 
        del.next.prev = del.prev; 
    } 

    /* Change prev only if node to be deleted is NOT the first node */
   if (del.prev != null) { 
        del.prev.next = del.next; 
   } 

    /* Finally, free the memory occupied by del*/
    return; 
} 

void deleteNodeAtGivenPos(Node head_ref, int n) 
{ 
    /* if list in NULL or invalid position is given */
	    if (head == null || n <= 0) 
        return; 
  
     Node current = head_ref; 
	
  
    /* traverse up to the node at position 'n' from 
       the beginning */
    for (int i = 0; current != null && i < n; i++) 
        current = current.next; 
  
    /* if 'n' is greater than the number of nodes 
       in the doubly linked list */
    if (current == null) 
        return; 
  
    /* delete the node pointed to by 'current' */
    deleteNode(head_ref, current); 
	}


void update_price(int new_price,int id1,String old_name)
{
 
   
   if(head == null) {
      System.out.println("Linked List not initialized");
      return;
   } 

   Node current = head;
   while(current!=null) {
     
      if(current.car_id==id1)
      {
         if(current.car_name.equalsIgnoreCase(old_name))
          {
     
         current.car_price = new_price;
         System.out.println("Price updated successfully!!!");
         return;
      
      }
      }
      else
      {
      System.out.println("Search not found in list:");
      if(current.next != null)
         current = current.next;
      else
         break;
   }
   }
 
 //else
 //{
	// System.out.println("Invalid");
 //}

}
void update_model(String new_model,int id2,String old_name)
{
	
 if(head == null) {
      System.out.println("Linked List not initialized");
      return;
   } 

   Node current = head;
   while(current!=null) {
     
      if(current.car_id==id2)
      {
         if(current.car_name.equalsIgnoreCase(old_name))
          {
              current.car_model=new_model;
              System.out.println("Model updated successfully!!!");
              return;
          }
          
      }
       else
      {
      System.out.println("Search not found in list:");
      if(current.next != null)
         current = current.next;
      else
         break;
   }
   }
     
	
}





 public void printlist(Node node) 
 { 
     Node last = null; 
     
     while (node != null) { 
    	 System.out.println("car_price: " +node.car_price + " ");
    	 System.out.println( "car_model: "+node.car_model +" ");
    	 System.out.println( "car_name: "+node.car_name +" ");
    	 System.out.println( "car_id: "+node.car_id +" ");
    	 last = node; 
         node = node.next; 
     } 
     System.out.println(); 
  
 } 
 
 Node split(Node head) { 
     Node fast = head, slow = head; 
     while (fast.next != null && fast.next.next != null) { 
         fast = fast.next.next; 
         slow = slow.next; 
     } 
     Node temp = slow.next; 
     slow.next = null; 
     return temp; 
 } 

 Node mergeSort(Node node) { 
     if (node == null || node.next == null) { 
         return node; 
     } 
     Node second = split(node); 

     // Recur for left and right halves 
     node = mergeSort(node); 
     second = mergeSort(second); 

     // Merge the two sorted halves 
     return merge(node, second); 
 } 

 // Function to merge two linked lists 
 Node merge(Node first, Node second) { 
     // If first linked list is empty 
     if (first == null) { 
         return second; 
     } 

     // If second linked list is empty 
     if (second == null) { 
         return first; 
     } 

     // Pick the smaller value 
     if (first.car_price < second.car_price) { 
         first.next = merge(first.next, second); 
         first.next.prev = first; 
         first.prev = null; 
         return first; 
     } else { 
         second.next = merge(first, second.next); 
         second.next.prev = second; 
         second.prev = null; 
         return second; 
     } 
 } 


 public int findposition(Node node,String s2) 
 { 
	 int pos=0;
     Node last = null; 
     while (node != null) { 
    	
    	 if(node.car_name.equals(s2))
    	 {
    		
    		 
    		break; 
    		
    	 }
     pos++;
    	 
    
    	 last = node; 
         node = node.next; 
         
     } 
     System.out.println();
     
    
	return pos; 
  
 } 

 public void Search(Node node,int p)
 {
	 Node last = null;
	 while(node != null)
	 {
		 if(node.car_price<=p)
		 {
			 System.out.println("car_price: " +node.car_price + " ");
	    	 System.out.println( "car_model: "+node.car_model +" ");
	    	 System.out.println( "car_name: "+node.car_name +" ");
	    	 System.out.println( "car_id: "+node.car_id +" ");
	    	 
		 }
		 
		 last = node; 
         node = node.next; 
	 }
	 System.out.println();
 }
// System.out.println("Traversal in forward Direction"); 
// while (node != null) { 
//  System.out.println("car_price: " +node.car_price + " ");
//  System.out.println( "car_model: "+node.car_model +" ");
//  System.out.println( "car_name: "+node.car_name +" ");
//  System.out.println( "car_id: "+node.car_id +" ");
//  
//  last = node; 
//  node = node.next; 
// } 
// System.out.println(); 
  // System.out.println("Traversal in reverse direction"); 
   //while (last != null) { 
    //System.out.print("car_price:"+node.car_price + " ");
    //System.out.print("car_model: "+node.car_model + " ");
    //System.out.print("car_name: "+node.car_name + " ");
    //last = last.prev; 
  //} 
//} 

/* Drier program to test above functions*/
public static void main(String[] args) throws Exception
{ 
  
	DLL dll = new DLL(); 
	
	//File Out = new java.io.File("Car.txt");
    //Out.createNewFile();
    //FileOutputStream fOut = new FileOutputStream(Out);
    //DataOutputStream dOut = new DataOutputStream(fOut);
    
	Scanner sc = new Scanner(System.in);
	System.out.println("Welcome To Honda");
	int c;
	do
	{
	System.out.println("Enter 1 for admin \nEnter 2 for customer \nEnter 3 for Exit");
	 c=sc.nextInt();
	String Username = "Honda";
	int Password=123;
	
	int password = 0;
	String username = null;
        if(c==1)
	{
				
	  System.out.println("Enter username");
	  username = sc.next();
          System.out.println("Enter password");
          password = sc.nextInt();
          
          if(Username.equalsIgnoreCase(username)&& Password==password)
	{
  	  System.out.println("Welcome admin");
	
			
								int choice ;
		
								do
									{
										System.out.println("Enter your choice 1.Add Data:\n2.Delete data\n3.Edit data\n4.Display data\n5.EXIT\n");
										System.out.println("Select an option");
			
										choice = sc.nextInt();
										switch(choice)
											{
												case 1:
												
												System.out.println("Enter car name:");
												String name=sc.next();
												//dOut.writeUTF(name);
												System.out.println("Enter model :");
												String model=sc.next();
												//dOut.writeUTF(model);
												System.out.println("Enter car price");
												long price=sc.nextLong();
												System.out.println("Enter car id");
												int id=sc.nextInt();
												
												dll.append(price,model,name,id);
				
				
												break;
			
												case 2:	
			
													
													
													System.out.println("Enter the car name you want to delete");
													String s2=sc.next();
													int position;
													position = dll.findposition(dll.head, s2);
												    System.out.println(position);
												
											      	dll.deleteNodeAtGivenPos(dll.head,position);
													
												
													
													break;
													
												case 3:
													System.out.println("Select 1 to update price and 2 to update model:");
										              int sel=sc.nextInt();
										              System.out.println("Enter the id of car you want to update:");
										              
										              int id1=sc.nextInt();
										              System.out.println("Enter car name:");
										              String old_name=sc.next();

										              if(sel==1)
										              {
										              System.out.println("Enter new price of car ");
										              int new_price=sc.nextInt();
										              dll.update_price(new_price,id1,old_name);
										              }
										              else if(sel==2)
										              {
										                  System.out.println("Enter new model of car:");
										                  String new_model=sc.next();
										                  dll.update_model(new_model, id1, old_name);
										              }
													
												case 4:

													 System.out.println("Created DLL is: "); 
													 dll.printlist(dll.head);
													 Node n= dll.mergeSort(dll.head);
										             System.out.println("Sorted list is:");
										             dll.printlist(n);
													
													 break;
													 
												case 5:
													break;
													 	
												default:
													System.out.println("Incorrect choice");
												}
									}
								
								while(choice!=5);
								
	}
          else
          {
              System.out.println("Incorrect Username or Password");
          }
	}
		
        else if(c==2)
        {
            int c1;
            
          System.out.println("Welcome to honda");
          System.out.println("Kindly enter your username:");
          String user=sc.next();
          if(Username.equalsIgnoreCase(user))
          {
              System.out.println("Welcome user");
              do{
              System.out.println("Select an option from the following:");
              System.out.println("1.View cars:2.View from a specific range:3.Exit");
              c1=sc.nextInt();
              switch(c1){
              
                  case 1:
                	  dll.printlist(dll.head);
                      break;
                      
                  case 2:
                	  System.out.println("Enter the car price of the car you wish to search");
                	  int p=sc.nextInt();
                	  dll.Search(dll.head, p);
                	
                      break;
                      
                  case 3:
                	  break;
                	  
                 default:
                	 System.out.println("Incorrect choice");
              }
          }
              while(c1!=3);
              sc.close();
        }
        }
        else
        {
		while(c!=3);
		sc.close();	
        }
    
	}

while(c!=3);
sc.close();
	
	


}

		
}

 // Insert 6. So linked list becomes 6->NULL 
//   dll.append(6); 

 // Insert 7 at the beginning. So linked list becomes 7->6->NULL 
 

 // Insert 1 at the beginning. So linked list becomes 1->7->6->NULL 
 //dll.push(1,"BMW","X1"); 

 // Insert 4 at the end. So linked list becomes 1->7->6->4->NULL 
//   dll.append(4); 

 // Insert 8, after 7. So linked list becomes 1->7->8->6->4->NULL 
//   dll.InsertAfter(dll.head.next, 8); 
 

