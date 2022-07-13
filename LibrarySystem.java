/**
 * @author 
 * @author 
 * @author 
 */
import java.util.*;
public class LibrarySystem
{
    /**
     * Attributes
     */
    /** List of books in the system.*/
    private LinkedList <Book> booksList;
    /** List of members in the system.*/
    private LinkedList <LibMember> membersList;
    /** The size of booksList.*/
    private int booksListSize;
    /** Size of the membersList. */
    private int membersListSize;

    /**
     * Constructors without parameters.
     */
    public LibrarySystem()
    {
        booksList=  new LinkedList<>();
        membersList= new LinkedList<>();
        booksListSize= 0;
        membersListSize= 0;
    }

    /**
     * Inserts a new Book object 'b' at the end of the booksList.
     * @param b of type Book.
     * @return Returns false if book already exists otherwise adds it and returns true.
     */
    public boolean addBook (Book b)
    {
        for (int i = 0; i<booksListSize; i++)
        {
        if (b.equals(booksList.get(i)))
            return false;
        }
        booksList.addLast(b);
        booksListSize++;
        return true;
    }

    /**
     * Deletes a Book object according to AccessionNum from booksList.
     * @param a for AccessionNum of the book.
     * @return Returns false if book doesn't exist or is issued to a member otherwise deletes the book and returns true.
     */
    public boolean deleteBook (long a)
    {
        if (searchBook(a)==-1)
            return false;
        for (int i = 0; i<booksListSize; i++)
        {
            Book b = booksList.get(i);
            if(b.getAccessionNum()==a && b.getIssuedTo()==null)
            {
                booksList.remove(b);
                booksListSize--;
                return true;
            }
        }
        return false;
    }

    /**
     * Inserts a new LibMember object 'm' at the end of the membersList.
     * @param m of type LibMember.
     * @return Returns false if member already exists otherwise adds them and returns true.
     */
    public boolean addMember (LibMember m)
    {
        for (int i = 0; i<membersListSize; i++)
        {
            if (m.equals(membersList.get(i)))
                return false;
        }
        membersList.addLast(m);
        membersListSize++;
        return true;
    }

    /**
     * Deletes a LibMember object according to CprNum from membersList.
     * @param c for CprNum of LibMember
     * @return Returns false if member wasn't found or if a book is issued to them otherwise deletes them and returns true.
     */
    public boolean deleteMember (long c)
    {
        if (searchMember(c)==-1)
        {
            System.out.println("Member was not found.");
            return false;
        }

        for (int i = 0; i<membersListSize; i++)
        {
            LibMember m = membersList.get(i);
            if (m.getCprNum()==c && m.getNumBooksIssued()==0)
            {
                membersList.remove(m);
                membersListSize--;
                return true;
            }
        }
        System.out.println("Member could not be deleted because a book is issued to them.");
        return false;
    }

    /**
     * Searches the booksList for a book by AccessionNum.
     * @param a for AccessionNum
     * @return Index of book in List booksList.
     */
    public int searchBook (long a)
    {
        for (int i = 0; i<booksListSize; i++)
        {
            Book b = booksList.get(i);
            if (b.getAccessionNum()==a)
                return i;
        }
        return -1;
    }

    /**
     * Searches the membersList for a member by cprNum.
     * @param c for CprNum
     * @return Index of member in List membersList.
     */
    public int searchMember (long c)
    {
        for (int i = 0; i<membersListSize; i++)
        {
            LibMember m = membersList.get(i);
            if(m.getCprNum()==c)
                return i;
        }
        return -1;
    }

    /**
     * Returns true if the booksList is empty.
     * @return True if booksList is empty otherwise false.
     */
    public boolean isEmptyBookList ()
    {
        return booksList.isEmpty();
    }

    /**
     * Returns true if the membersList is empty.
     * @return True if membersList is empty otherwise false.
     */
    public boolean isEmptyMembersList ()
    {
        return membersList.isEmpty();
    }

    /**
     * Returns instance variable booksListSize.
     * @return Size of booksList.
     */
    public int sizeBooksList ()
    {
        return booksListSize;
    }

    /**
     * Returns instance variable membersListSize.
     * @return Size of membersList.
     */
    public int sizeMembersList ()
    {
        return membersListSize;
    }

    /**
     * Issues book according to AccessionNum to a member according to CprNum.
     * @param a for AccessionNum of a book.
     * @param c for CprNum of a member.
     * @return False if no members exist, no books exist, book doesn't exist, member doesn't exist, book already issued
     * to a member, or member already has 10 books issued to them otherwise returns true after issuing the book.
     */
    public boolean issueBook (long a, long c)
    {
        if (membersList.isEmpty())
        {
            System.out.println("Member list is empty.");
            return false;
        }
        if (booksList.isEmpty())
        {
            System.out.println("Book list is empty.");
            return false;
        }
        if (searchBook(a)==-1)
        {
            System.out.println("Book cannot be found.");
            return false;
        }
        if (searchMember(c)==-1)
        {
            System.out.println("Member cannot be found.");
            return false;
        }
        if(isBookIssued(a))
        {
            System.out.println("Book already issued to a member.");
            return false;
        }

        Book book= booksList.get(searchBook(a)); // the book to be issued
        LibMember Mem = membersList.get(searchMember(c));// the member person
        int noOfBook = Mem.getNumBooksIssued(); // no of books the member has already issued

        if( noOfBook < 10 )
        {
            Book[] b = Mem.getBooksIssued(); // save bookissued array
            b[noOfBook] = book;// issue the book to member
            book.setIssuedTo(Mem);
            noOfBook++;
            Mem.setNumBooksIssued(noOfBook); // increment n update numBooksIssuedby 1
            System.out.println("Book issued successfully.");
            return true;
        }
        else
            {
            System.out.println("Issue failed. Member already has 10 books.");
            return false;
            }

    }

    /**
     * Returns a book according to AccessionNum back to the library.
     * @param aNum for AccessionNum of a book.
     * @return False if no books/members exist, book doesn't exist, or book is not issued, otherwise returns true(after returning the book).
     */
    public boolean returnBook(long aNum)
    {
        if(isEmptyBookList() || isEmptyMembersList())
            return false;

        if( (searchBook(aNum)!=-1) &&(isBookIssued(aNum)) )
        {
            Book book= booksList.get(searchBook(aNum));
            LibMember Mem= book.getIssuedTo();

            Book [] b=  Mem.getBooksIssued();
            int noOfBook = Mem.getNumBooksIssued();
            for( int i=0; i< b.length ;i++)
            {
                if(book.equals(b[i]))
                {
                    for(int j = i+1 ; j < b.length; j++)
                    {
                        b[j-1]= b[j];
                    }
                    b[b.length-1] = null;
                    noOfBook--;
                    Mem.setNumBooksIssued(noOfBook);
                }
            }

            book.setIssuedTo(null);
            return true;
        }
        return false;
    }

    /**
     * Prints details of all the books issued to the member according to CprNum.
     * @param c for CprNum of a member.
     */
    public void printBooksIssued (long c)
    {
        int index = 0;
        if (searchMember(c) == -1)
            System.out.println("The member was not found.");
        LibMember m = membersList.get(index);
        while (index < sizeMembersList() ){
            if (m.getCprNum() == c){
                System.out.println(Arrays.toString(m.getBooksIssued()));
                return;
            }
            index++;
            if (index < sizeMembersList())
                m = membersList.get(index);
        }
    }

    /**
     * Returns true if the Book object exists in the bookList and is issued to a member.
     * @param a for AccessionNum of a book.
     * @return False if book doesn't exist, book isn't issued to a member, or no members exist, otherwise returns true.
     */
    public boolean isBookIssued (long a)
    {
        int index = 0;
        if(isEmptyMembersList())return false;
        if (searchBook(a) == -1)return false;

        while (index < sizeBooksList()){
            Book b = booksList.get(index);
            if (b.getAccessionNum()== a && b.getIssuedTo()!= null)
                return true;
            index++;
            if (index < sizeBooksList())
                b = booksList.get(index);
        }
        return false;
    }
}//End of LibrarySystem class
