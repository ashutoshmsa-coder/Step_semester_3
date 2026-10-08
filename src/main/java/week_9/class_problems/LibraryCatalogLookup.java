package week_9.class_problems;

import java.util.Arrays;
import java.util.List;

public class LibraryCatalogLookup {

    static class Book {
        String isbn;
        String title;

        Book(String isbn, String title) {
            this.isbn = isbn;
            this.title = title;
        }
    }

    public static String findBook(List<Book> catalog, String targetIsbn) {

        int left = 0;
        int right = catalog.size() - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            String currentIsbn = catalog.get(mid).isbn;

            int comparison = currentIsbn.compareTo(targetIsbn);

            if (comparison == 0) {
                return catalog.get(mid).title;
            }

            if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {

        List<Book> catalog = Arrays.asList(
                new Book("0001112223", "Java Basics"),
                new Book("0002223334", "Data Structures"),
                new Book("0003334445", "Classic Mythology"),
                new Book("0004445556", "Computer Networks"),
                new Book("0005556667", "Operating Systems")
        );

        System.out.println("Search Result 1: "
                + findBook(catalog, "0003334445"));

        System.out.println("Search Result 2: "
                + findBook(catalog, "0009998887"));
    }
}