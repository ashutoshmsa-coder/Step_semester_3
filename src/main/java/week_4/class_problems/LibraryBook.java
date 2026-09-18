package week_3.class_problems;

public class LibraryBook {

    String title;
    String isbn;

    // Constructor 1
    public LibraryBook(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    // Constructor 2 - uses this()
    public LibraryBook(String title) {
        this(title, "PENDING");
    }

    public static void main(String[] args) {

        String[] titles = {
            "Clean Code",
            "Untitled Draft",
            "1984",
            "Notes"
        };

        String[] isbns = {
            "978-0132350884",
            "",
            "9780451524935",
            ""
        };

        // Process every book in one pass
        for (int i = 0; i < titles.length; i++) {

            LibraryBook book;

            if (isbns[i].isEmpty()) {
                book = new LibraryBook(titles[i]);
            } else {
                book = new LibraryBook(titles[i], isbns[i]);
            }

            System.out.println(
                book.title + " | " +
                book.isbn + " | Catalogued: true"
            );
        }
    }
}