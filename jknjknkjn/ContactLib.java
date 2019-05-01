import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.lang.NullPointerException;
/**
 *
 * @Diego
 * @8-14-18
 */
public class ContactLib
{
    //creates the arrays that will later be used
    private static List<String> contact;
    private static List<String> hmmm;
    private static List<String> fort;
    //must exit program probably by typing e
    public static void main()
    {
        hmmm = new ArrayList<>();
        fort = new ArrayList<>();
        int random = 0;
        int random2 = 0;
        int check1 = 0;
        String check2 = "";
        String check = MediaFile.readString();
        //if there is a number at the front change it to an int which is used to keep track of how many past contacts were created
        try
        {
            check1 = Integer.parseInt(check);
        }
        catch (NumberFormatException nfe)
        {
            random++;
        }
        //if there were previous contacts before closing bluej it knows how many and writes them
        for (int om = 0; om < check1; om++)
        {
            for (int i = 0; i < 8; i++)
            {
                MediaFile.writeString(MediaFile.readString());
            }
        }
        MediaFile.saveAndClose();
        //it reads through the written old contacts and adds them to an array
        for (int om = 0; om < check1; om++)
        {
            for (int i = 0; i < 8; i++)
            {
                hmmm.add(MediaFile.readString());
            }
        }
        //it gets rid of all the checks put in the file that were used to see how many and where the end of the file was
        check2 = Integer.toString(check1);
        for (String b : hmmm)
        {
            if ((!(b.equals("null"))) && !(b.equals(check2)))
            {
                fort.add(b);
            }
        }
        int numContacts = 0;
        int numContacts2 = 0;
        contact = new ArrayList<>();
        String action = "";
        //it adds all the old contacts to the current blue j and counts them as contacts in the contact counter and makes them the correct formatting
        for (String c : fort)
        {
            random2++;
            numContacts++;
            numContacts2++;
            if (random2 % 4 == 0)
            {
                contact.add(c + "\n");
            }
            else
            {
                contact.add(c);
            }
        }
        System.out.println("Welcome to your Contact List");
        //e is the exit action
        while (!(action.equals("e")))
        {
            System.out.println("What would you like to do?");
            System.out.println("View All Your Contacts(type v), Add A Contact(type a), Delete A Contact(type d), Search For A Contact(type s), Exit(e)");
            action = UserInput.getString();
            int y = -1;
            if (action.equals("resetFile"))
            {
                MediaFile.writeString("");
                MediaFile.saveAndClose();
            }
            while (!(action.equals("v") || action.equals("a") || action.equals("d") || action.equals("s") || action.equals("e")))
            {
                System.out.println("Plase use the formatting requested");
                action = UserInput.getString();
            }
            if (action.equals("a"))
            {
                System.out.println("New Contact Name: ");
                String newContact = UserInput.getString();
                System.out.println("New Contact Phone Number: ");
                String newContactPhoneNumber = UserInput.getString();
                System.out.println("New Contact Occupation: ");
                String newContactOccupation = UserInput.getString();
                System.out.println("New Contact Address: ");
                String newContactAddress = UserInput.getString();
                Contact contact1 = new Contact(newContact,newContactPhoneNumber, newContactOccupation, newContactAddress);
                contact.add("Contact name: " + contact1.getName() + "\n" + "Contact phone number: " + contact1.getPhoneNumber() + "\n" + "Contact Occupation: " + contact1.getOccupation() + "\n" + "Contact address: " + contact1.getAddress() + "\n");
                for (int om = 0; om < check1; om++)
                {
                    for (int i = 0; i < 8; i++)
                    {
                        MediaFile.writeString(MediaFile.readString());
                    }
                }
                for (int tx = 0; tx < numContacts; tx++)
                {
                    for (int i = 0; i < 4; i++)
                    {
                        MediaFile.writeString(MediaFile.readString());
                    }
                }
                MediaFile.writeString("Contact name: " + contact1.getName() + "\n" + "Contact phone number: " + contact1.getPhoneNumber() + "\n" + "Contact Occupation: " + contact1.getOccupation() + "\n" + "Contact address: " + contact1.getAddress() + "\n");
                MediaFile.saveAndClose();
                numContacts ++;
            }
            if (action.equals("d") && numContacts != 0)
            {
                System.out.println("Type the fist name of the contact you would like to remove");
                for (String a : contact)
                {
                    System.out.println(a);
                }
                String deleteContact = UserInput.getString();
                for (String b : contact)
                {
                    y++;
                    int z = b.indexOf(":");
                    int p = b.indexOf("phone");
                    String k = b.substring(z + 2, p - 9);
                    if (deleteContact.equals(k))
                    {
                        contact.remove(y);
                        break;
                    }
                }
                numContacts--;
            }
            if (action.equals("d") && numContacts == 0)
            {
                System.out.println("You have no contacts");
            }
            //goes through array and prints your contacts
            if (action.equals("v"))
            {
                if (numContacts > 0)
                {
                    System.out.println("Here are all of your contacts");
                    for (String b : contact)
                    {
                        System.out.println(b);
                    }
                }
                else
                {
                    System.out.println("You have no contacts");
                }
            }
            if (action.equals("s"))
            {
                PdfViewer.main();
            }
        }
        String number = Integer.toString(numContacts);
        for (int tx = 0; tx < numContacts; tx++)
        {
            for (int i = 0; i < 4; i++)
            {
                MediaFile.writeString(number + "\n" + MediaFile.readString());
            }
        }
        MediaFile.saveAndClose();
    }

    public static List<String> getArray()
    {
        return contact;
    }
}