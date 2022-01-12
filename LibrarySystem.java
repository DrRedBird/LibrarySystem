package LibraryProject;

import java.util.LinkedList;
import java.util.ListIterator;

public class LibrarySystem {

    // data members
    private LinkedList<Book> booksList;
    private LinkedList<LibMember> memberList;
    private int bookListSize;
    private int membersListSize;

    // default constructor
    public LibrarySystem () {
        booksList = new LinkedList<Book>();
        memberList = new LinkedList<LibMember>();
        bookListSize = 0;
        membersListSize = 0;
    }

    // add book method: adds a book to the end of bookList
    public boolean addBook (Book book) {
        if(searchBook(book.getAccessionNum()) != -1) {
            System.out.println("Book already exists.");
            return false;
        }
        booksList.add(book);
        bookListSize++;
        System.out.println("Book added successfully.");
        return true;
    }

    // delete book method: deletes the book from bookList
    public boolean deleteBook (long accNum) {
        int bookIndex = searchBook(accNum);
        if (bookIndex == -1 || isBookIssued(accNum)) {
            System.out.println("Cannot delete book.");
            return false;
        }

        booksList.remove(bookIndex);
        bookListSize--;
        System.out.println("Book successfully deleted");
        return true;
    }

    // add member method: adds a member to the end of memberList
    public boolean addMember (LibMember member) {
        if(searchMember(member.getCprNum()) != -1) {
            System.out.println("Member already exists.");
            return false;
        }

        memberList.add(member);
        membersListSize++;
        System.out.println("Member added successfully.");
        return true;
    }

    // delete member method: deleted a member from memberList
    public boolean deleteMember (long cpr) {
        int index = searchMember(cpr);

        if(index != -1)
        {
            LibMember member1 = memberList.get(index);

            if(member1.getNumBooksIssued() == 0)
            {
                memberList.remove(index);
                membersListSize--;
                System.out.println("Member successfully removed.");
                return true;
            }
        }
        System.out.println("Cannot remove member.");
        return false;
    }

    // search book method: returns the index of the book in bookList. if not found returns -1
    public int searchBook (long accNum) {
        if (booksList.isEmpty())
            return -1;

        ListIterator<Book> iter = booksList.listIterator();
        int index = 0;

        while (iter.hasNext())
        {
            Book book = iter.next();
            if (book.getAccessionNum() == accNum)
                return index;
            index++;
        }
        return -1;
    }

    // search member method: returns the index of the member in memberList. if not found returns -1
    public int searchMember (long cpr) {
        if (memberList.isEmpty())
            return -1;

        ListIterator<LibMember> iter = memberList.listIterator();
        int index = 0;

        while (iter.hasNext())
        {
            LibMember member = iter.next();
            if (member.getCprNum() == cpr)
                return index;
            index++;
        }
        return -1;
    }

    // empty methods: returns true if the list is empty else returns fasle
    public boolean isEmptyBooksList () {
        return booksList.isEmpty();
    }

    public boolean isEmptyMembersList () {
        return memberList.isEmpty();
    }

    // size methods: returns the data member size for bookList and memberList, respectively
    public int sizeBooksList () {
        return bookListSize;
    }

    public int sizeMembersList () {
        return membersListSize;
    }

    // issue book method: issues a book to a member if the book exists and the member satisfies the conditions
    public boolean issueBook (long accNum, long cpr) {
        int bookIndex = searchBook(accNum);
        int memberIndex = searchMember(cpr);

        if (bookIndex == -1 || memberIndex == -1 || isBookIssued(accNum) || memberList.get(memberIndex).getNumBooksIssued() >= 10) {
            System.out.println("Book cannot be issued");
            return false;
        }
        LibMember member = memberList.get(memberIndex);
        Book book = booksList.get(bookIndex);
        member.getBooksIssued()[member.getNumBooksIssued()] = book;
        member.setNumBooksIssued(member.getNumBooksIssued() + 1);
        book.setIssuedTo(member);
        System.out.println("Book successfully issued.");
        return true;
    }

    // return book method: the method returns an already issued book back to the library
    public boolean returnBook (long accNum) {
        int bookIndex = searchBook(accNum);

        if (bookIndex == -1 || !isBookIssued(accNum)) {
            System.out.println("Book cannot be returned");
            return false;
        }

        LibMember member = booksList.get(bookIndex).getIssuedTo();
        Book[] booksIssued = member.getBooksIssued();
        int issuedSize = member.getNumBooksIssued();
        int removeIndex = 0;
        for (int i = 0; i < issuedSize; i++)
        {
            if (booksIssued[i].equals(booksList.get(bookIndex)))
            {
                for (int j = removeIndex; j < issuedSize - 1; j++)
                    booksIssued[j] = booksIssued[j+1];

                member.setNumBooksIssued(member.getNumBooksIssued() - 1);
                member.setBooksIssued(booksIssued);
                booksList.get(bookIndex).setIssuedTo(null);
                System.out.println("Book successfully returned.");
                return true;
            }
            removeIndex++;
        }
        return false;
    }

    // print books issued: prints all the books issued to a certain member
    public void printBooksIssued(long cpr)
    {
        int memberIndex = searchMember(cpr);

        if(memberIndex != -1)
        {
            LibMember member = memberList.get(memberIndex);
            Book[] books = member.getBooksIssued();
            int booksNum = member.getNumBooksIssued();

            if (booksNum == 0)
                System.out.println("There are no books issued for this member.");
            else {
                for (int i = 0; i < booksNum; i++)
                    System.out.println(books[i]);
            }
        }
        else
            System.out.println("Member not found.");
    }

    // Is book issued method: returns true if a book is already issued to a member else returns false
    public boolean isBookIssued (long accessionNum) {
        int index = searchBook(accessionNum);

        if(index == -1)
            return false;

        LibMember issued = booksList.get(index).getIssuedTo();
        if (issued == null)
            return false;

        return true;
    }

}
