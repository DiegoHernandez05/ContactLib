
/**
 * Write a description of class Song here.
 *
 * @Diego
 * @8-14-18
 */
public class Contact
{
    private String name;
    private String phoneNumber;
    private String occupation;
    private String address;
    public int numContacts;
    public Contact()
    {
        //'initialise instance variables
        name = "";
        phoneNumber = "";
        occupation = "";
        address = "";
        numContacts = 0;
    }

    public Contact(String name, String phoneNumber, String occupation, String address, int numContacts) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.numContacts = numContacts;
        this.occupation = occupation;
        this.address = address;
    }

    public Contact(String name, String phoneNumber, String occupation, String address)
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.occupation = occupation;
        this.address = address;
    }

    public Contact(String name) {
        this.name = name;
    }

    public Contact(int numSongs) {
        this.numContacts = numContacts;
    }

    public String getName() {
        return name;
    }

    public void setName(String t) {
        name = t;
    }
    
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String r)
    {
        phoneNumber = r;
    }

    public String getOccupation()
    {
        return occupation;
    }

    public void setOccupation(String l)
    {
        occupation = l;
    }

    public String getAddress()
    {
        return address;
    }
    
    public void setAddress(String g)
    {
        address = g;
    }

    public int getContacts() {
        return numContacts;
    }
}
