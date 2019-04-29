import java.util.Scanner;


public class AddressBook {

    /*
    *   Method to verify command/ parameter input 
    *
    */
    public static String verInput(String command){
        String temp = null;
        char start ='<', end = '>';

        if(command.charAt(0) == start && command.charAt(command.length()-1) == end){
            for(int i = 0; i < command.length(); i++){
                if(command.charAt(i) != start || command.charAt(i) != end){
                    temp += command.charAt(i);
                }
            }
        }
        else{
            throw new IllegalArgumentException("Invalid command");        
        }
        if(temp.length() > 6){  throw new IllegalArgumentException("Invalid command"); }
        return temp;
    }
    public boolean verPass(String pass){
        ///verify the password,
        //run hash on pass
        //if it mathces the previously hashed password, that is owned by the user
        // pass == true
        return true;
    }
    public static String verNum(String num){
        String temp = null;
        char start ='<', end = '>';
        if(num.charAt(0) == start && num.charAt(num.length()-1) == end ){
            for(int i = 0; i < num.length(); i++){
                if(num.charAt(i) != start || num.charAt(i) != end){
                    temp += num.charAt(i);
                }
            }
        }
        else{
            throw new IllegalArgumentException("Invalid command");        
    
        }
        if(temp.length() > 14){  throw new IllegalArgumentException("Invalid command"); }
        return temp;
    }
    

    public static void main(String[] args){
        Boolean runAgian = true;
        String in = null;
        Scanner input = new Scanner(System.in);// remember to close scanner
        System.out.println("*******************************\n" +
                            "Welcome to the Address Book\n" + 
       
                            "****************************");
        do{
        try {
            System.out.println("PLease input operation in the following format\n" + 
                                " <command>     <parameter>");
            System.out.println("Enter the operation you wish to run\n" + 
                                " <ADD>, <DELETE>, <GET>");
            in = verInput(input.nextLine()); // command input
            switch (in) {
                case "ADD":
                    System.out.println("Enter the foillowing parameter\n" + 
                                    " <name>");
                    in =  verInput(input.nextLine());
                    System.out.println("Enter the foillowing parameter\n" + 
                                    " <zip_code>");
                    in =  verInput(input.nextLine());
                    System.out.println("Enter the foillowing parameter\n" + 
                                    " <email_address>");
                    in =  verInput(input.nextLine());
                    System.out.println("Enter the foillowing parameter\n" + 
                                    " <phone_number>");
                    in =  verNum(input.nextLine());  
                break;

                case "DELETE":
                    System.out.println("Enter your password to proceed");
                    in = input.nextLine(); //should be passwrds entry
                    //verPassword, if true process, else throw mismatch error

                    System.out.println("Enter the foillowing parameter\n" + 
                    "<name>");
                    in =  verInput(input.nextLine());
                    break;
                
                case "GET":
                    System.out.println("Enter the foillowing parameter\n" + 
                    "<name>");
                    in =  verInput(input.nextLine());
                    break;
                
                case "SET":
                     System.out.println("Enter your password to proceed");
                    in = input.nextLine(); //should be passwrds entry
                      //verPassword, if true process, else throw mismatch error

                    System.out.println("Enter the foillowing parameter\n" + 
                                    " <name>");
                    in =  verInput(input.nextLine());
                    System.out.println("Enter the foillowing parameter\n" + 
                                    " <zip_code>");
                    in =  verInput(input.nextLine());
                    System.out.println("Enter the foillowing parameter\n" + 
                                    " <email_address>");
                    in =  verInput(input.nextLine());  
                    System.out.println("Enter the foillowing parameter\n" + 
                                    " <phone_number>");
                    in =  verNum(input.nextLine());     
                default:
                    break;
                }
                
                System.out.println("Do you wish to run again, enter yes or no");
                in = input.nextLine();
                if(in.equalsIgnoreCase("yes")){runAgian = true; break;}
                else{ runAgian = false; break;}
            }            
            catch (Exception e) {
                System.out.println("incorrect input");
                break;
            }
          }while(runAgian == true);
          input.close();
          System.exit(0);
            

    }
}