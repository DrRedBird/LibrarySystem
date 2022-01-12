package LibraryProject;

import java.util.Arrays;

public class LibMember {

    // data members
    private String firstName;
    private String lastName;
    private char gender;
    private long cprNum;
    private String teleNum;
    private Book[] booksIssued;
    private  int numBooksIssued;

    // default constructor
    public LibMember () {
        firstName = "firstName";
        lastName = "lastName";
        gender = 'N';
        cprNum = 0;
        teleNum = "teleNum";
        booksIssued = new Book[10];
        numBooksIssued = 0;
    }

    // 5-parameter constructor
    public LibMember (String firstName, String lastName, char gender, long cprNum, String teleNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.cprNum = cprNum;
        this.teleNum = teleNum;
        booksIssued = new Book[10];
        numBooksIssued = 0;
    }

    // set and get methods for the data members
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public long getCprNum() {
        return cprNum;
    }

    public void setCprNum(long cprNum) {
        this.cprNum = cprNum;
    }

    public String getTeleNum() {
        return teleNum;
    }

    public void setTeleNum(String teleNum) {
        this.teleNum = teleNum;
    }

    public Book[] getBooksIssued() {
        return booksIssued;
    }

    public void setBooksIssued(Book[] booksIssued) {
        this.booksIssued = booksIssued;
    }

    public int getNumBooksIssued() {
        return numBooksIssued;
    }

    public void setNumBooksIssued(int numBooksIssued) {
        if(numBooksIssued >= 0)
            this.numBooksIssued = numBooksIssued;
    }

    // toString method: to return string representation of a member
    @Override
    public String toString() {
        return ("First Name: " + firstName + "\n" +
                "Last Name: " + lastName + "\n" +
                "Gender: " + gender + "\n" +
                "CPR Number: " + cprNum + "\n" +
                "Telephone Number: " + teleNum + "\n" +
                "Books Issued: " + Arrays.toString(booksIssued) + "\n" +
                "Number of Books Issued: " + numBooksIssued + "\n");
    }

    // equals method: returns true if this member is the same as the passed member else returns false
    public boolean equals (LibMember m1) {
        return (cprNum == m1.cprNum);
    }

}