package lab6;
import java.util.ArrayList;

public class Shelf<T extends Data> {

    private ArrayList<T> list;
    private static ArrayList<Shelf<?>> allShelves = new ArrayList<>();

    public Shelf() {
        list = new ArrayList<>();
        allShelves.add(this);
    }

    public void add(T t) {
        list.add(t);
    }

    public void remove(int index) {
        list.remove(index);
    }

    public void weight() {
        int sumWeight = 0;
        for (T t : list)
            sumWeight += t.getWeight();
        System.out.println("Weight of books on this shelf is: " + sumWeight + "kg");
    }

    public T findMin() {
        if (list.isEmpty()) {
            return null; // Обробка випадку, коли полиця порожня
        }

        T min = list.get(0);
        for (T t : list) {
            if (t.getWeight() < min.getWeight()) {
                min = t;
            }
        }
        return min;
    }

    public static Data findMinAcrossAllShelves() {
        Data min = null;

        for (Shelf<?> shelf : allShelves) {
            Data shelfMin = (Data) shelf.findMin();
            if (shelfMin != null && (min == null || shelfMin.getWeight() < min.getWeight())) {
                min = shelfMin;
            }
        }

        return min;
    }


    public static int countBooksAcrossAllShelvesInRange(int lowerBound, int upperBound) {
        int count = 0;

        for (Shelf<?> shelf : allShelves) {
            for (Data data : shelf.list) {
                if (data.getWeight() >= lowerBound && data.getWeight() <= upperBound) {
                    count++;
                }
            }
        }

        return count;
    }
}
