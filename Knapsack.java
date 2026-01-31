import java.util.Arrays;

class Item implements Comparable<Item> {
    int profit;
    int weight;
    double ratio;

    Item(int profit, int weight) {
        this.profit = profit;
        this.weight = weight;
        this.ratio = (double) profit / weight;
    }

    @Override
    public int compareTo(Item other) {
        return Double.compare(other.ratio, this.ratio); // Descending order
    }
}

public class Knapsack {
    public static double fractionalKnapsack(int capacity, Item[] items) {
        Arrays.sort(items);
        double totalProfit = 0;

        for (Item item : items) {
            if (capacity >= item.weight) {
                capacity -= item.weight;
                totalProfit += item.profit;
            } else {
                totalProfit += item.ratio * capacity;
                break;
            }
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        Item[] items = {
                new Item(60, 10),
                new Item(100, 20),
                new Item(120, 30)
        };
        int capacity = 50;

        double maxProfit = fractionalKnapsack(capacity, items);
        System.out.println("Maximum Profit: " + maxProfit);
    }
}