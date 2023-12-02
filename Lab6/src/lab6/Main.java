package lab6;

public class Main {
    private static Data minBook;

    public static void main(String[] args) {
        Shelf<Data> shelf = new Shelf<>();
        shelf.add(new Books(8));
        shelf.add(new Books(4));
        shelf.add(new Books(2));
        shelf.add(new Books(6));
        shelf.weight();
        Data book = shelf.findMin();
        main1();
        int countInRange = Shelf.countBooksAcrossAllShelvesInRange(4, 6);
        System.out.println("Number of books in the specified range across all shelves: " + countInRange);
    }
    public static void main1() {
        Shelf<Data> shelf = new Shelf<>();
        shelf.add(new Books(4));
        shelf.add(new Books(9));
    }
}
