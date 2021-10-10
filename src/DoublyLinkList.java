/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 

/**
 *
 * @author Daniyal Hussain Shah
 */

/*
line#36 insertAtfirst
line#58 show
line#82 insertBetween
line#103 insertAtLast
line#130 deleteBetween
line#196 deleteLast
line#225 deleteFromFirst
line#244 search
*/
public class DoublyLinkList {
    
    Node first;
    
    
    //Constructor
    public DoublyLinkList()
    {
        first=new Node();
        
    }
  
    //Methods
  
    public void insertAtFirst(String name,int duration)
    {
        
        if(first.next==null) //if there is no data in the list
        {
            first.data.name=name;
            first.data.duration=duration;
            first.next=first;
            first.previous=first;
        }
        else{
        Node newNode=new Node();
        newNode.data.name=name;
        newNode.data.duration=duration;
        newNode.previous=first.previous;
        newNode.next=first;
        first.previous.next=newNode;
        first.previous=newNode;
        first=newNode;
        
    }}
    
    public void show()
    {
        if(first.next==null) {
            
            System.out.println("No songs in the playlist");
            
        }
        else{
        Node node=first;
        while(node.next!=first)
        {
            
            System.out.println("Song Name: "+node.data.name);
            System.out.println("Song Duration: "+node.data.duration+" secs");
            System.out.println("");
            node=node.next;
        }
        
         System.out.println("Song Name: "+node.data.name);//because in while loop it only prints till second last value
         System.out.println("Song Duration: "+node.data.duration + " secs");
        }
    }
    
    
    public void insertBetween(String name,int duration,int pos)
    {
        Node p=first;
        Node newNode=new Node();
        newNode.data.name=name;
        newNode.data.duration=duration;
        int counter=1;
        while(counter<pos-1)
        {
            p=p.next;
            counter++;
        }
        p.next.previous=newNode;
        newNode.next=p.next;
        newNode.previous=p;
        p.next=newNode;
        
        
        
    }
    
    public void insertAtLast(String name,int duration)
    {
         
        if(first.next==null) // if there are no songs in the playlist
        {
            first.data.name=name;
            first.data.duration=duration;
            first.next=first;
            first.previous=first;
        }
        else{
        Node p=first;
        Node newNode=new Node();
        newNode.data.name=name;
        newNode.data.duration=duration;
        while(p.next!=first)
        {
            p=p.next;
        }
        p.next.previous=newNode;
        newNode.previous=p;
        newNode.next=p.next;
        p.next=newNode;
        
        }
    }
    
    public void deleteBetween(String name)
    {
        if(first.next==null){
            System.out.println("no song available in the playlist to delete");
        }
        else if(first.next==first&&first.previous==first){//when there is only one song in the playlist
            
            if(first.data.name.equalsIgnoreCase(name)){
                
                first.next=null;
                first.previous=null;
                System.out.println(name+" has been deleted successfully");
            
        }
            else{
                
                System.out.println("No such song has been found to delete");
                
            }
        
        }
        
        else{
            
            Node p=first;
            boolean condition=false;//to check if song we want to delete exists
            int counter=1;//to check if we are deleting first song
            
            while(p.next!=first){
                
                if(p.data.name.equalsIgnoreCase(name)){
                    
                condition=true;
                break;
            }
                else{
                    p=p.next;
                    counter++;
                }
            
          }
           
            if(p.data.name.equalsIgnoreCase(name)){//in while it only checks till second last value
                    
                condition=true;
            }
            
            if(condition){
                
                p.next.previous=p.previous;
                p.previous.next=p.next;
                System.out.println(name+" has been deleted successfully");
                
                if(counter==1){//if we are deleting first song
                    
                    first=first.next;
                    
                }
            }
            else{
                
                System.out.println("No such song has been found to delete");
            }
        }
    }       
    
    public void deleteLast(){
        
        if(first.next==null){
            
            System.out.println("no song available in the playlist to delete");
            
        }
        else{
            
            Node p=first;
        
        while(p.next!=first){
            
            p=p.next;
            
        }
        if(p.previous==p&&p.next==p){ //if we are deleting in a list that contains only one song
            p.previous=null;
            p.next=null;
            System.out.println("Last Song has been successfully deleted");
        }
        else{
        p.previous.next=p.next;
        p.next.previous=p.previous;
        System.out.println("Last song has been successfully deleted");
        }
        }
    }
    
    public void deleteFromFirst()
    {
    if(first.next==null){
        System.out.println("no Song available in the playlist to delete");
    }
    else  if(first.previous==first&&first.next==first){ //if we are deleting in a list that contains only one song
            first.previous=null;
            first.next=null;
            System.out.println("First song has been successfully deleted");
        }
    else {
    first.previous.next=first.next;
    first.next.previous=first.previous;
    first=first.next;
    System.out.println("First song has been successfully deleted");
    }  
    
    }
    
    public void search(String name){
        
        if(first.next==null){ //when there are no songs in the playlist
            
            System.out.println("There are no songs in the playlist");
            
        }
        else if(first.next==first&&first.previous==first){ //when there is only one song in the playlist
            
            if(first.data.name.equalsIgnoreCase(name)){
                System.out.println("Song has been found at position 1 ");
            }
            else{
                System.out.println("Song has not been found in the playlist");
            }
        }
        else{
            
        boolean condition=false;
        Node node=first;
        int counter=1;//to check position of the song
        
        while(node.next!=first){
            
            if(node.data.name.equalsIgnoreCase(name)){
                
                condition=true;
                break;
            }
            counter++;
            node=node.next;
        }
        
        if(node.data.name.equalsIgnoreCase(name)){//in while it only checks till last value
                
                condition=true;
            }
        if(condition){
            
            System.out.println("Song has been found at position "+counter);
            
        }
        else{
            
            System.out.println("Song has not been found in the playlist");
            
        }
       }
        
    }
    
    
 }
