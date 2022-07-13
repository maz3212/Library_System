/**
 * @author 
 * @author 
 * @author 
 */
import java.util.*;
public class LibraryMain
{
    public static void main (String [] args)
    {
        Scanner kb = new Scanner (System.in);

        /**
         * Create a new Library System.
         */
        LibrarySystem LB1 = new LibrarySystem();

        System.out.println("Welcome to the Library!");

        /**
         * Loop for the user to choose a letter within a switch statement, where each letter calls and tests methods from the LibrarySystem class.
         */
        while (true)
        {
                //Menu
                System.out.println("Please type in the letter that corresponds to your desired function: + " +
                        "\n 'A' : Add a new member" +
                        "\n 'B' : Add a new book" +
                        "\n 'C' : Delete a member" +
                        "\n 'D' : Delete a book" +
                        "\n 'E' : Search for a book" +
                        "\n 'F' : Issue a book" +
                        "\n 'G' : Return a book" +
                        "\n 'H' : Print details of all books issued to a member" +
                        "\n 'X' : Exit");

                char input = kb.next().charAt(0);
                long a, c;
                input = Character.toUpperCase(input);

                switch(input) {

                    /**
                     *  Asks the user to input member information and creates a new object 'newMmeber' of type LibMember which is
                     *passed as a parameter in the method addMember to add the member.
                     * @param F First Name
                     * @param L Last Name
                     * @param G Gender
                     * @param CPR CPR number
                     * @param T Telephone number
                     */
                    case 'A':
                        System.out.println("Enter first and last name: ");
                        String F = kb.next();
                        String L = kb.next();
                        System.out.println("Enter gender: ");
                        char G = kb.next().charAt(0);
                        System.out.println("Enter CPR number: ");
                        long CPR = kb.nextLong();
                        System.out.println("Enter telephone number: ");
                        String T = kb.next();

                        LibMember newMember = new LibMember(F, L, G, CPR, T);
                        if (LB1.addMember(newMember))
                            System.out.println("Member added successfully.");
                        else
                            System.out.println("Member already exists.");
                        break;

                    /**
                     * Asks the user to input book information and creates a new object 'newBook' of type Book which is
                     *passed as a parameter in the method addBook to add the book.
                     * @param title Book's Title
                     * @param A1 First Author
                     * @param A2 Second Author
                     * @param P Publisher's name
                     * @param Y Year of publication
                     * @param I ISBN number
                     * @param AC Accession number
                     */
                    case 'B':
                        System.out.println("Enter the title: ");
                        String title = kb.next();
                        System.out.println("Enter the first and second authors names: ");
                        String A1 = kb.next();
                        String A2 = kb.next();
                        System.out.println("Enter publisher: ");
                        String P = kb.next();
                        System.out.println("Enter year of publication: ");
                        int Y = kb.nextInt();
                        System.out.println("Enter ISBN number: ");
                        String I = kb.next();
                        System.out.println("Enter accession number: ");
                        long AC = kb.nextLong();

                        Book newBook = new Book(title, A1, A2, P, Y, I, AC);
                        if (LB1.addBook(newBook))
                            System.out.println("Book added successfully.");
                        else
                            System.out.println("Book already exists.");
                        break;

                    /**
                     * Asks the user to enter CprNum of member to be deleted which is passed as a parameter in
                     *deleteMember method to delete the member.
                     *@param c CPR number of the member to be deleted.
                     */
                    case 'C':
                        System.out.println("Enter the CPR number of the member to be deleted: ");
                        c = kb.nextLong();
                        LB1.deleteMember(c);
                        break;

                    /**
                     * Asks the user to input AccessionNum of the book to be deleted which is passed as a parameter in the deleteBook method
                     * @param a Accession number of the book to be deleted.
                     */
                    case 'D':
                        System.out.println("Enter the Accession number of the book to be deleted: ");
                        a = kb.nextLong();

                        //Deleting book
                        if (LB1.deleteBook(a))
                            System.out.println("Book deleted successfully.");
                        else
                            System.out.println("Book could not be deleted.");
                        break;

                    /**
                     * Asks the user to input AccessionNum of the book they're searching for which is passed as a parameter
                     *in both searchBook and isBookIssued methods.
                     * @param a Accession number of the book.
                     */
                    case 'E':
                        System.out.println("Enter the Accession number of the book: ");
                        a = kb.nextLong();

                        //Search for book and display details
                        if (LB1.searchBook(a) == -1)
                            System.out.println("The book was not found.");
                        else if(LB1.isBookIssued(a))
                            System.out.println("The book is already issued to a member.");
                        else
                            System.out.println("The book is available.");
                        break;

                    /**
                     * Asks the user to input AccessionNum of a book to be issued to a member using the CPR input.
                     * @param c CPR number of the member.
                     * @param a Accession number of the book.
                     */
                    case 'F':
                        System.out.println("Enter the CPR number of the member: ");
                        c = kb.nextLong();
                        System.out.println("Enter the Accession number of the book: ");
                        a = kb.nextLong();

                        if(LB1.isBookIssued(a))
                            System.out.println("The book is already issued to a member.");
                        else
                            if(LB1.issueBook(a,c))
                                System.out.println("The book was successfully issued to the member.");
                            else
                                System.out.println("The book could not be issued.");
                        break;

                    /**
                     * Asks the user to input AccessionNum of the book to be returned which is passed as a parameter in returnBook method.
                     * @param a Accession number of the book to be returned.
                      */
                    case 'G':
                        System.out.println("Enter the Accession number of the book to be returned: ");
                        a = kb.nextLong();

                        if(LB1.returnBook(a))
                            System.out.println("Book successfully returned.");
                        else
                            System.out.println("Book could not be returned.");
                        break;

                    /**
                     * Asks the user to input CPR of a member which is passed as a parameter in printBooksIssued which displays
                     *all books issued to that member.
                     * @param c CPR number of the member.
                     */
                    case 'H':
                        //CPR input
                        System.out.println("Enter the CPR number of the member: ");
                        c = kb.nextLong();

                        LB1.printBooksIssued(c);
                        break;

                    /**
                     * Exits the program.
                     */
                    case 'X':
                        System.out.println("Exiting.");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("This option does not exist. Please select another option.");
                }
        }
    }//End of main method
}//End of LibraryMain class


