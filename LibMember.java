/**
 * @author 
 * @author 
 * @author 
 */
import java.util.*;
public class LibMember
{
    /**
     * Attributes
     */
    /** First name of the member. */
    private String firstName;
    /** Last name of the member. */
    private String lastName;
    /** Gender of the member. */
    private char gender;
    /** CPR Number of the member. */
    private long cprNum;
    /** Telephone Number of the member. */
    private String teleNum;
    /** Array containing all books issued to this member.*/
    private Book []  booksIssued = new Book [10];
    /** Number of books issued to the member. */
    private int numBooksIssued;

    /**
     * Constructor without parameters.
     */
    public LibMember()
    {
        this.setFirstName("Unknown");
        this.setLastName("Unknown");
        this.setGender('U');
        this.setCprNum(111111111);
        this.setTeleNum("00000000");
        this.setNumBooksIssued(0);
    }

    /**
     * Constructor with parameters.
     * @param f for FirstName
     * @param l for LastName
     * @param g for gender
     * @param c for CprNum
     * @param t for TeleNum
     */
    public LibMember(String f, String l, char g, long c, String t)
    {
        this.setFirstName(f);
        this.setLastName(l);
        this.setGender(g);
        this.setCprNum(c);
        this.setTeleNum(t);
        this.setNumBooksIssued(0);
    }

    /**
     * Set method for FirstName,LastName,Gender,CprNum,TeleNum,BooksIssued,NumBooksIssued.
     */
    /**
     * Replaces first name with a new first name.
     * @param f  First Name of the member.
     */
    public void setFirstName(String f)
    {firstName=f;}
    /**
     * Replaces the last name of the member with a new last name.
     * @param l New last name.
     */
    public void setLastName(String l)
    {lastName=l;}
    /**
     * Replaces gender of the member with a nee gender.
     * @param g New gender of the member.
     */
    public void setGender(char g)
    {gender=g;}
    /**
     * Replaces CPR number of the member with new CPR.
     * @param c New CPR of the member.
     */
    public void setCprNum(long c)
    {cprNum=c;}
    /**
     * Replaces telephone number of the member with new Telephone Number.
     * @param t New Telephone number of the member.
     */
    public void setTeleNum(String t)
    {teleNum=t;}
    /**
     * Replaces books issued to a member with a new array of issued books.
     * @param b New array of issued books.
     */
    public void setBooksIssued(Book [] b)
    {
        System.arraycopy(b,0,booksIssued,0,10);
    }
    /**
     * Replaces the number of books issued by new number of books issued.
     * @param n New Number of books issued to a member.
     */
    public void setNumBooksIssued(int n)
    {numBooksIssued=n;}

    /**
     * Get method for FirstName,LastName,Gender,CprNum,TeleNum,BooksIssued,NumBooksIssued.
     */
    /**
     * Returns the first name of the member
     * @return First name of the member.
     */
    public String getFirstName()
    {return firstName;}
    /**
     * Returns the last name of the members
     * @return Last name of the member.
     */
    public String getLastName()
    {return lastName;}
    /**
     * Returns the gender of the member.
     * @return Gender of the member.
     */
    public char getGender()
    {return gender;}
    /**
     * Returns CPR Number of the member.
     * @return CPR Number of the member.
     */
    public long getCprNum()
    {return cprNum;}
    /**
     * Returns the Telephone number of the member.
     * @return Telephone number of the member.
     */
    public String getTeleNum()
    {return teleNum;}
    /**
     * Returns the books issued to the member.
     * @return Books issued to the member.
     */
    public Book [] getBooksIssued()
    {return booksIssued;}
    /**
     * Returns number of books issued to the member.
     * @return Number of books issued to the member.
     */
    public int getNumBooksIssued()
    {return numBooksIssued;}

    /**
     * Method returns true if two objects are equal.
     * @param e Object to be compared with this object.
     * @return False if this object and e are not equal otherwise true.
     */
    public boolean equals(Object e)
    {
        if(this == e){ return true; }   // if this object is e
        if(!(e instanceof LibMember)){return false; } //if e is not of type LibMember

        LibMember member = (LibMember) e;
        if(!(this.firstName.equals(member.firstName) && this.lastName.equals(member.lastName) && this.gender==member.gender && this.cprNum==member.cprNum && this.teleNum.equals(member.teleNum) && this.booksIssued.equals(member.booksIssued) && this.numBooksIssued==member.numBooksIssued)){ return false; }
        return true;
    }

    /**
     * Method to return the string representation of the object.
     * @return String of all attributes of this object.
     */
    public String toString()
    {
        return ("First Name: " + firstName + " \nLast Name: " + lastName + " \nGender: " +
                gender + " \nCPR Num: " + cprNum + " \nTele Num: " + teleNum +
                " \nBooks Issued: " + booksIssued + " \nNumber of books Issued: " + numBooksIssued);
    }
}//End of LibMember class


