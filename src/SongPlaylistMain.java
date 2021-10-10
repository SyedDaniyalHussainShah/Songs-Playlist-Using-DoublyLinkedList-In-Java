/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author Daniyal Hussain Shah
 */
public class SongPlaylistMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        DoublyLinkList playlist=new DoublyLinkList();
        Scanner input=new Scanner(System.in);
        Scanner inputS=new Scanner(System.in);// this will be used for String
        int selection,duration,choice;
        String name;
        
        while(true){
        System.out.println("Please select one option");
        System.out.println("1.Add a song to the playlist");
        System.out.println("2.Remove a song from the playlist");
        System.out.println("3.Show all songs in the playlist");
        System.out.println("4.Search a song in the playlist");
        System.out.println("5.Play songs from the playlist");
        System.out.println("6.Exit");
        System.out.println("");
        
        selection=input.nextInt();
        
        switch(selection){
            
            case 1:
                              
                System.out.println("Please enter your choice");
                System.out.println("1.add song at the last positiion");
                System.out.println("2.add song at the first position");
                System.out.println("3.add song by entering specific position");
                System.out.println("");
                
                choice=input.nextInt();
                
                switch(choice){
                    
                    case 1:
                        System.out.println("Enter song name");
                        name=inputS.nextLine();
                        System.out.println("Enter song duration in seconds");
                        duration=input.nextInt();
                        playlist.insertAtLast(name, duration);
                        System.out.println(name+" has been successfully added");
                        System.out.println("");
                        break;
                    
                    case 2:
                        System.out.println("Enter song name");
                        name=inputS.nextLine();
                        System.out.println("Enter song duration in seconds");
                        duration=input.nextInt();
                        playlist.insertAtFirst(name, duration);
                        System.out.println(name+" has been successfully added");
                        System.out.println("");
                        break;
                        
                     case 3:
                        int position;
                        
                        System.out.println("Enter song name");
                        name=inputS.nextLine();
                        System.out.println("Enter song duration in seconds");
                        duration=input.nextInt();
                        System.out.println("Enter position");
                        position=input.nextInt();
                        
                        playlist.insertBetween(name, duration, position);
                        System.out.println(name+" has been successfully added");
                        System.out.println("");
                        break;
                        
                     default:
                         
                         System.out.println("You entered wrong choice");
                         System.out.println("");
                         break;
                        
                }
                break;
                
            case 2:
                                
                System.out.println("Please enter your choice");
                System.out.println("1.Remove last song in the playlist");
                System.out.println("2.Remove first song in the playlist");
                System.out.println("3.Remove song by entering song name");
                System.out.println("");
                
                choice=input.nextInt();
                
                switch(choice){
                    
                    case 1:
                        
                        playlist.deleteLast();
                        System.out.println("");
                        break;
                        
                    case 2:
                        
                        playlist.deleteFromFirst();
                        System.out.println("");
                        break;
                        
                    case 3:
                        
                        System.out.println("Enter song name to be deleted");
                        name=inputS.nextLine();
                        
                        playlist.deleteBetween(name);
                        System.out.println("");
                        break;
                        
                    default:
                        
                        System.out.println("You entered wrong choice");
                        System.out.println("");
                        break;
                }
                break;
            
            case 3:
                
                playlist.show();
                System.out.println("");
                break;
                
            case 4:
                
                System.out.println("Enter name of the song");
                name=inputS.nextLine();
                
                playlist.search(name);
                System.out.println("");
                break;
                
            case 5:
                
                Node song=playlist.first;
                
                while(true){
                    
                    System.out.println(song.data.name+" is being played");
                    System.out.println("");
                    System.out.println("Enter 1 to play previous song");
                    System.out.println("Enter 2 to play next song");
                    System.out.println("Enter any number other than 1 and 2 to stop");
                    System.out.println("");
                    
                    choice=input.nextInt();
                    
                    if(choice==1){
                        
                        song=song.previous;
                        
                    }
                    
                    else if(choice==2){
                        
                        song=song.next;
                        
                    }
                    else{
                        break;
                    }
                }
                break;
                
            case 6:
                
                System.exit(0);
                break;
                
            default:
                
                System.out.println("You entered wrong selection");
                break;
                
        }
      }
    }
    
}
