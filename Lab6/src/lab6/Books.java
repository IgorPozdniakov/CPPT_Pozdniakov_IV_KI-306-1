package lab6;

public class Books implements Data {
    public Books() {
        this.weight = 20;
    }
    public Books(int weight) {
        this.weight = weight;
    }
    private int weight;
    @Override
    public void print() {
        System.out.println( weight );
    }
    @Override
    public int getWeight() {
        return weight;
    }
    @Override
    public int compareTo(Data d) {
        if (this.weight < d.getWeight())
            return 1;
        if (this.weight == d.getWeight())
            return 0;
        return -1;
    }
}
