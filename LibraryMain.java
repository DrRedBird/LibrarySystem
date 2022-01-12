package LibraryProject;


import java.util.*;

public class LibraryMain {
    public static void main(String[] args) {

        // creates a Scanner object
        Scanner keyboard = new Scanner(System.in);

        // creates a LibrarySystem object
        LibrarySystem libSystem = new LibrarySystem();

        // variable to choose an operation
        int i = 0;

        while(i != 15) {
            // prompts the user to enter the operation
            System.out.println();
            System.out.println("Please choose an operation");
            System.out.println("0) Exit");
            System.out.println("1) Add a Book");
            System.out.println("2) Delete a Book");
            System.out.println("3) Add a Member");
            System.out.println("4) Delete a Member");
            System.out.println("5) Search for a Book");
            System.out.println("6) Search for a Member");
            System.out.println("7) BooksList size");
            System.out.println("8) MembersList size");
            System.out.println("9) Issue a book");
            System.out.println("10) Return a book");
            System.out.println("11) Print books issued by a member");
            System.out.println("12) Is the book issued");
            System.out.print("Operation: ");
            i = keyboard.nextInt();
            System.out.println("---------------------------------------");

            switch (i) {

                // exits the program
                case 0:
                    System.exit(0);
                    break;

                // adds a book
                case 1:
                    keyboard.nextLine();
                    System.out.print("Enter Title: ");
                    String Title = keyboard.nextLine();

                    System.out.print("Enter Author 1: ");
                    String A1 = keyboard.nextLine();

                    System.out.print("Enter Author 2: ");
                    String A2 = keyboard.nextLine();

                    System.out.print("Enter Publisher: ");
                    String pub = keyboard.nextLine();

                    System.out.print("Enter Year of Publication: ");
                    int publication = keyboard.nextInt();

                    System.out.print("Enter ISBN: ");
                    String ISBN = keyboard.next();

                    System.out.print("Enter Accession Number: ");
                    long accNum = keyboard.nextLong();

                    Book book = new Book(Title, A1, A2, pub, publication, ISBN, accNum);
                    libSystem.addBook(book);
                    break;

                // deleted a book
                case 2:
                    System.out.print("Enter Accession Number:");
                    long AccNum2 = keyboard.nextLong();
                    libSystem.deleteBook(AccNum2);
                    break;

                // adds a member
                case 3:
                    System.out.print("Enter First Name: ");
                    String firstName = keyboard.next();

                    System.out.print("Enter Last Name: ");
                    String lastName = keyboard.next();

                    System.out.print("Enter Gender");
                    char gender = keyboard.next().charAt(0);

                    System.out.print("Enter CPR Number: ");
                    long cpr = keyboard.nextLong();

                    System.out.print("Enter Telephone Number: ");
                    String teleNum = keyboard.next();

                    LibMember libMember = new LibMember(firstName, lastName, gender, cpr, teleNum);
                    libSystem.addMember(libMember);
                    break;

                // deletes a member
                case 4:
                    System.out.print("Enter CPR Number: ");
                    long CPR2 = keyboard.nextLong();
                    libSystem.deleteMember(CPR2);
                    break;

                // searches for a book
                case 5:
                    System.out.print("Enter Accession Number: ");
                    long AccNum3 = keyboard.nextLong();
                    libSystem.searchBook(AccNum3);
                    break;

                // searches for a member
                case 6:
                    System.out.print("Enter CPR: ");
                    long CPR3 = keyboard.nextLong();
                    libSystem.searchMember(CPR3);
                    break;

                // number of books in bookList
                case 7:
                    System.out.print("Size Book: " + libSystem.sizeBooksList());
                    break;

                // number of books in memberList
                case 8:
                    System.out.print("Size Member: " + libSystem.sizeMembersList());
                    break;

                // issues a book to a member
                case 9:
                    System.out.print("Enter Accession Number: ");
                    long AccNum4= keyboard.nextLong();
                    System.out.print("Enter CPR Number: ");
                    long CPR4 = keyboard.nextLong();
                    libSystem.issueBook(AccNum4, CPR4);
                    break;

                // returns a book back to the library
                case 10:
                    System.out.print("Enter Accession Number: ");
                    long AccNum5 = keyboard.nextLong();
                    libSystem.returnBook(AccNum5);
                    break;

                // prints the books issued by a member
                case 11:
                    System.out.print("Enter CPR Number: ");
                    long cp = keyboard.nextLong();
                    libSystem.printBooksIssued(cp);

                    break;

                // checks whether a book is issued or not
                case 12:
                    System.out.print("Enter Accession Number of Book: ");
                    long AccNum6 = keyboard.nextLong();
                    if (libSystem.isBookIssued(AccNum6)) {
                        System.out.println("Book is Issued");
                        break;
                    }
                    System.out.println("Book is Not Issued");
                    break;

                // default statement: if operation number is invalid
                default:
                    System.out.println("Invalid");
                    break;
            }
        }

    }
}
