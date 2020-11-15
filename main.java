import java.util.Scanner;

public class main{
    public static void main(String [] args){

        int x = 9;
        boolean exit = false;
        while(!exit){
            System.out.println("-----------------------------------Main Menu-----------------------------------");
            System.out.println("Select an Option "+"\n"+"\t"+"*Enter 1 to display all contacts"+"\n"+"\t"
            +"*Enter 2 to add contact"+ "\n" + "\t"+"*Enter 3 to remove contact"+"\n"+"\t"+"*Enter 4 to edit a contact"+"\n"
            +"\t"+"*Enter 5 to load contacts from a text file" + "\n"+"\t"+
            "*Enter 6 to save contacts to the text file"+"\n"
            +"\t"+"*Enter 7 to exit from the program");


            System.out.println("-------------------------------------------------------------------------------");
            System.out.print("Your response: ");
            Scanner scan = new Scanner(System.in);
    String line = scan.nextLine();
            try {
                x = Integer.parseInt(line);
            } catch (Exception e) {
                System.out.println("Error, please try again...");
            } 


   if(x == 1){
     ContactList cn = new ContactList();
     cn.displayContact();   // calling displayContact method


    }else if(x == 2){
        
            ContactList cn=new ContactList();
          cn.addContact();      // calling addContact method


    }else if(x == 3){

          ContactList cn=new ContactList();
          cn.deleteContact();              // calling deleteContact method



    }else if(x == 4){

            ContactList cn= new ContactList();
            cn.editContact();                  // calling editContact method


    }else if(x == 5){

            ContactList cn= new ContactList();
            cn.loadContact();                    // calling loadContact method

    }else if(x == 6){

            ContactList cn= new ContactList();
            cn.saveContact();                     // calling saveContact method

    }else if(x == 7){
        exit = true;                             // program termination
         break;

        }

    }


}
}