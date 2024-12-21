class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }


    public void printBookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
    }

    public static void main(String[] args) {
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 10.99);
        Book book2 = new Book("1984", "George Orwell", 8.99);
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee", 12.50);

        book1.printBookInfo();
        System.out.println();
        book2.printBookInfo();
        System.out.println();
        book3.printBookInfo();
    }
}
