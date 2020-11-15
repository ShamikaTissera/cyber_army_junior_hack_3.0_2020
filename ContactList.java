
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.util.Scanner;

public class ContactList {
    private String name;
    private String phoneNumber;
  public static ArrayList<Contact> contact = new ArrayList<Contact>(); 
  Scanner scan = new Scanner(System.in);
  File file = new File ("F:\\Programming Workspaces\\Hackathon\\Junior Hack\\Java\\contacts.txt"); // change path here as you prefered
  
  public void addContact() {
      System.out.println("Please enter name: ");
      name = scan.nextLine();
      System.out.println("Please enter phone number: ");
      phoneNumber = scan.nextLine();
      while(phoneNumber.length() > 10 || phoneNumber.length() < 10){
        System.out.println("Error... Please enter valid phone number -> Must be 10 digits");  
      System.out.println("Please enter phone number: ");
      phoneNumber = scan.nextLine();
      }
      Contact newContact = new Contact(name, phoneNumber);
      contact.add(newContact);
  } 
  public void editContact(){
      System.out.println(" Please enter name of the contact that you want to change");
      String temp = scan.nextLine();
      System.out.println("Please enter the new phone number");
      phoneNumber = scan.nextLine();
      while(phoneNumber.length() > 10 || phoneNumber.length() < 10){
        System.out.println("Error... Please enter valid phone number -> Must be 10 digits");  
      System.out.println("Please enter phone number: ");
      phoneNumber = scan.nextLine();
      }
      int req_index = 0;
     try {
          req_index = 0;
        for (int i = 0; i < contact.size(); i++) {
            if(temp == contact.get(i).getName()){
                req_index = i;
                break;
            }
        }
    }
     catch (Exception e){
         System.out.println("Error");
     }
        
        contact.get(req_index).setPhoneNumber(phoneNumber);
  }

   public void deleteContact(){
       String temp;
       try{
           System.out.println("Please enter name of the contact that you want to delete");
        temp = scan.nextLine();
        int req_index = 0;
        for (int i = 0; i < contact.size(); i++) {
            if(temp == contact.get(i).getName()){
                req_index = i;
                break;
            }
        }
        contact.remove(req_index);
       }

       catch (Exception e)  {
           System.out.println("\n\nError, contact not found!!!\n");
       }

   }

   public void loadContact(){

    try {
        File myObj = new File("filename.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
          String data = myReader.nextLine();
          System.out.println(data);
        }
        myReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();}
      }

    public static void displayContact(){
        for (int i = 0; i < contact.size(); i++) {
            System.out.println(contact.get(i).getName() + "    " + contact.get(i).getPhoneNumber());
        }
        
    }



   public void saveContact(){ //Saves data to file
    try {
        File myObj = new File("filename.txt");
        if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
         } 
        else {
        System.out.println("File already exists.");
        }
    } 
    catch (IOException e) {
        System.out.println("An error occurred.");
    e.printStackTrace();
    }


    try {
        FileWriter myWriter = new FileWriter("filename.txt");
        for(Contact inst : contact){
            myWriter.write(inst.getName() + "     " + inst.getPhoneNumber() + "\n");
        }
        
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
    } 
    catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
}}
