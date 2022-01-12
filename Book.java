package LibraryProject;


public class Book {

    // Data members
    private String title;
    private String author1;
    private String author2;
    private String publisher;
    private int yearPublication;
    private String isbn;
    private long accessionNum;
    private LibMember issuedTo;

    // Default constructor
    public Book () {
        title = "title";
        author1 = "author1";
        author2 = "author2";
        publisher = "publisher";
        isbn = "0";
        yearPublication = 0;
        accessionNum = 0;
        issuedTo = null;
    }

    // Six-Parameter constructor
    public Book (String title, String author1, String author2, String publisher, int yearPublication, String isbn, long accessionNum) {
        // checks whether the isbn and accession number are correct
        if (isbn.length() == 13 && accessionNum > 1000)
        {
            this.title = title;
            this.author1 = author1;
            this.author2 = author2;
            this.publisher = publisher;
            this.isbn = isbn;
            this.yearPublication = yearPublication;
            this.accessionNum = accessionNum;
            issuedTo = null;
        }
        else
            System.out.println("Invalid isbn or accessionNum");
    }

    // Set and Get methods for the data members
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor1() {
        return author1;
    }

    public void setAuthor1(String author1) {
        this.author1 = author1;
    }

    public String getAuthor2() {
        return author2;
    }

    public void setAuthor2(String author2) {
        this.author2 = author2;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYearPublication() {
        return yearPublication;
    }

    public void setYearPublication(int yearPublication) {
        this.yearPublication = yearPublication;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if (isbn.length() == 13)
            this.isbn = isbn;
        else
            System.out.println("Invalid isbn");
    }

    public long getAccessionNum() {
        return accessionNum;
    }

    public void setAccessionNum(long accessionNum) {
        if (accessionNum>1000)
            this.accessionNum = accessionNum;
        else
            System.out.println("Invalid accessionNum");
    }

    public LibMember getIssuedTo() {
        return issuedTo;
    }

    public void setIssuedTo(LibMember issuedTo) {
        this.issuedTo = issuedTo;
    }

    // ToString method: to return string equivalent of the book
    @Override
    public String toString() {
        return ("Title: "+title+"\n " +
                "Author 1: "+ author1+"\n " +
                "Author 2: "+author2 +"\n " +
                "Publisher: "+publisher +"\n " +
                "Publication year: "+ yearPublication+"\n " +
                "ISBN: "+isbn+"\n " +
                "Accession Number: "+accessionNum +"\n " +
                "Issued to: "+issuedTo.getCprNum());
    }

    // Equals method: to return true if this book is the same as the passed book
    public boolean equals (Book b) {
        return (b.accessionNum == accessionNum);
    }
}