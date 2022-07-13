/**
 * @author 
 * @author 
 * @author 
 */
import java.util.*;
public class Book
{
    /**
     * Attributes
     */
    /** Title of the book. */
    private String title;
    /** First Author of the book */
    private String author1;
    /** Second Author of the book. */
    private String author2;
    /** Publisher of the book. */
    private String publisher;
    /** Publication year of the book. */
    private int yearPublication;
    /** A unique 13 digit barcode for each book. */
    private String isbn;
    /** A unique number to every book to keep in track of the books in the library. */
    private long accessionNum;
    /** member that this book is issued to. */
    private LibMember issuedTo;

    /**
     * Constructor without parameters.
     */
    public Book ()
    {
        this.setTitle("Unknown");
        this.setAuthor1("Unknown");
        this.setAuthor2("Unknown");
        this.setPublisher("Unknown");
        this.setYearPublication(0000);
        this.setIsbn("0000000000000");
        this.setAccessionNum(1001);
        issuedTo=null;
    }

    /**
     * Constructor with parameter.
     * @param t for title.
     * @param a1 for author1.
     * @param a2 for author2.
     * @param p for publisher.
     * @param y for year of publication.
     * @param i for ISBN.
     * @param a for AccessionNum.
     */
    public Book (String t, String a1, String a2, String p, int y, String i, long a)
    {
        this.setTitle(t);
        this.setAuthor1(a1);
        this.setAuthor2(a2);
        this.setPublisher(p);
        this.setYearPublication(y);
        this.setIsbn(i);
        this.setAccessionNum(a);
        issuedTo=null;
    }

    /**
     * Set methods for title,author1,author2,publisher,yearPublications,ISBN,AccessionNum,IssuedTo.
     */
    /** Replaces Title with a new value.
     *  @param t New value of Title.
     */
    public void setTitle(String t)
    {title=t;}
    /** Replaces Author1 with a new value.
     *  @param a1 New value of Author1.
     */
    public void setAuthor1(String a1)
    {author1=a1;}
    /** Replace Author2 with a new value.
     *  @param a2 New value of Author2.
     */
    public void setAuthor2(String a2)
    {author2=a2;}
    /** Replaces publisher with a new value.
     *  @param p New value of publisher.
     */
    public void setPublisher(String p)
    {publisher=p;}
    /** Replaces yearPublication with a new value.
     *  @param y New value of yearPublication.
     */
    public void setYearPublication(int y)
    {yearPublication=y;}
    /** Replaces Isbn with a new value
     *  @param i New value of Isbn
     * Prints an invalid message if Isbn is not a 13 digit string.
     */
    public void setIsbn(String i)
    {
        if (i.length()!=13) {
            System.out.println("Invalid ISBN");
            System.exit(0);
        }
        else
            isbn=i;
    }
    /**
     * Replaces accessionNum with a new value
     *  @param a New value of accessionNum.
     *  prints an invalid message if accessionNum is less than 1001
     */
    public void setAccessionNum(long a)
    {
        if (a<1001)
        {
            System.out.println("Invalid Accession Number");
            System.exit(0);
        }
        else
            accessionNum=a;
    }
    /** Replaces IssuedTo with a new value
     *  @param it New value of IssuedTo.
     */
    public void setIssuedTo(LibMember it)
    {issuedTo=it;}

    /**
     *Get methods for title,author1,author2,publisher,yearPublications,ISBN,AccessionNum,IssuedTo.
     */
    /**
     * Returns the title of the book.
     * @return The title of the book.
     */
    public String getTitle()
    {return title;}
    /**
     * Returns the first Author of the book.
     * @return The first author of the book.
     */
    public String getAuthor1()
    {return author1;}
    /**
     * Returns the second author of the book.
     * @return The second author of the book.
     */
    public String getAuthor2()
    {return author2;}
    /**
     * Returns the publisher of the book.
     * @return The publisher of the book.
     */
    public String getPublisher()
    {return publisher;}
    /**
     * Returns the publication year of the book.
     * @return Publication year of the book.
     */
    public int getYearPublication()
    {return yearPublication;}
    /**
     * Returns the Isbn of the book.
     * @return the isbn of the book.
     */
    public String getIsbn()
    {return isbn;}
    /**
     * Returns the accession number of the book.
     * @return Accession number of the book.
     */
    public long getAccessionNum()
    {return accessionNum;}
    /**
     * Returns Member the book is issued to.
     * @return Member the book is issued to.
     */
    public LibMember getIssuedTo()
    {return issuedTo;}

    /**
     * Method returns true if two objects are equal.
     * @param e Object to be compared to this object.
     * @return False if this object and e are not equal otherwise true.
     */
    public boolean equals (Object e)
    {
        if(this == e){ return true; }   // if this object is e
        if(!(e instanceof Book)){return false; } //if e is not of type Book

        Book book = (Book) e;
        if(!(this.title.equals(book.title) && this.author1.equals(book.author1) &&
             this.author2.equals(book.author2) && this.publisher.equals(book.publisher) &&
             this.yearPublication==book.yearPublication && this.isbn.equals(book.isbn) &&
             this.accessionNum==book.accessionNum && this.issuedTo.equals(book.issuedTo))){ return false; }
        return true;
    }

    /**
     * Method to return the string representation of the object.
     * @return String of all attributes of this object.
     */
    public String toString()
    {
        if (issuedTo!=null)
        return ("Title: " + title + " \nAuthor 1: " + author1 + " \nAuthor 2: " + author2 +
                " \nPublisher: " + publisher + " \nYear of Pubilcation: " + yearPublication +
                " \nISBN: " + isbn + " \nAccession Number: " + accessionNum + " \nIssued to: \t Name: " +
                issuedTo.getFirstName() + " " + issuedTo.getLastName() + "\t CPR: "+issuedTo.getCprNum());

        return ("Title: " + title + " \nAuthor 1: " + author1 + " \nAuthor 2: " + author2 +
                " \nPublisher: " + publisher + " \nYear of Pubilcation: " + yearPublication +
                " \nISBN: " + isbn + " \nAccession Number: " + accessionNum + "Issued to: - ");
    }
}//End of Book class

