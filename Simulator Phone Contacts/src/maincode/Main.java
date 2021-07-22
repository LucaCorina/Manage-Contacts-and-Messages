package maincode;


import java.util.Scanner;
import java.util.ArrayList;


public class Main {

    private static ArrayList<Contact> contacts;
    private static Scanner scanner;
    private static int id=0;

    public static void main(String[] args){
        contacts=new ArrayList<Contact>();
        System.out.println("Welcome to my world");
        showOp();

    }
    private static void showOp(){
        System.out.println("Select one"+
                "\n\t1 Manage Contacts"+
                "\n\t2 Messages :)"+
                "\n\t3 Quit");
        scanner=new Scanner(System.in);
        int ch=scanner.nextInt();
        switch (ch){
            case 1:
                manageC();
                break;
            case 2:
                manageM();
                break;
            default:
                break;

        }
    }

    private static void manageM() {
        System.out.println("Select one"+
                "\n\t1 Show all"+
                "\n\t2 Send a message :)"+
                "\n\t3 Go Back");
        int ch=scanner.nextInt();
      switch (ch){
            case 1:
                showAllM();
                break;

            case 2:
                sendM();
                break;

            default:
                showOp();
                break;

        }

    }

    private static void sendM() {
        System.out.println("Who are u sending?");
        String name=scanner.next();
        if(name.equals("")){
            System.out.println("Please enter the name of the contact");
            sendM();
        }else{
            boolean ok=false;
            for(Contact c:contacts){
                if(c.getName().equals(name)){
                    ok=true;
                }
            }
            if(ok){
                System.out.println("What are u going to say");
                String text=scanner.next();
                if(text.equals("")){
                    System.out.println("Please enter message");
                    sendM();
                }else{
                    id++;//e static si o sa fie unic pt fiecare mesaj
                    Message newm=new Message(text,name,id);
                    for(Contact c:contacts){
                        if(c.getName().equals(name)){
                            ArrayList<Message>newMs=c.getMessages();
                            newMs.add(newm);
                            c.setMessages(newMs);
                        }
                    }
                }

            }else{
                System.out.println("There is no such contact");
            }
        }
showOp();
    }

    private static void showAllM() {
        ArrayList<Message> allM=new ArrayList<>();
        for(Contact c:contacts){
            allM.addAll(c.getMessages());
        }
        if(allM.size()>0){
            for(Message m:allM){
                m.getDetails();
                System.out.println("************");
            }
        }else{
            System.out.println("You don't have messages");
        }
        showAllC();
    }

    private static void manageC(){
        System.out.println("Select one"+
        "\n\t1 Show all"+
                "\n\t2 Add one Contact :)"+
                "\n\t3 Search"+
                "\n\t4 Delete "+
                "\n\t5 Go Back");
        int ch=scanner.nextInt();
        switch (ch){
            case 1:
                showAllC();
                break;

            case 2:
                addNewC();
                break;

            case 3:
                searchC();
                break;

            case 4:
                DeleteC();
                break;

            default:
                showOp();
                break;

        }
    }

    private static void DeleteC() {

        System.out.println("Please enter the contact name:");
        String name=scanner.next();
        if(name.equals("")){
            System.out.println("Please enter the contact name:");
            DeleteC();
        }else {
            boolean ok=false;
            for(Contact c:contacts){
                if(c.getName().equals(name)){
                    ok=true;
                    contacts.remove(c);
                }
            }
            if(!ok){
                System.out.println("Does not exist");
            }
            showOp();
        }

    }

    private static void searchC() {
        System.out.println("Please enter the contact name:");
        String name=scanner.next();
        if(name.equals("")){
            System.out.println("Please enter the contact name:");
searchC();

        }else {
            boolean ok=false;
            for(Contact c:contacts){
                if(c.getName().equals(name)){
                    ok=true;
                    c.getD();
                }
            }
            if(!ok){
                System.out.println("Does not exist");
            }
            showOp();
        }
    }

    private static void addNewC() {
        System.out.println("Adding a new contact..."+
                "\nPlease enter a name");
        String name=scanner.next();
        System.out.println("Please enter a number");
        String nr=scanner.next();
        System.out.println("Please enter a email");
        String email=scanner.next();

        if(name.equals("")||nr.equals("")||email.equals("")){
            System.out.println("Please enter all the info");
            addNewC();//reapelam fct
        }else {

            boolean ok=false;
            for(Contact c:contacts){
                if(c.getName().equals(name)){
                    ok=true;
                }

            }
            if(ok){
                System.out.println("We have a contact "+ name+" saved");
                addNewC();
            }else{
                Contact contact=new Contact(name,nr,email);
                contacts.add(contact);
                System.out.println(name+" added!!");
            }

            Contact con=new Contact(name,nr,email);
            contacts.add(con);
        }
        showOp();

    }

    private static void showAllC() {
        for(Contact c:contacts){
            c.getD();
        }
        showOp();
        System.out.println("************");
    }


}
