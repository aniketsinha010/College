package Exam_DAA;

import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value, weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class Assignment6 {

    // Function to get maximum value
    public static double getMaxValue(Item[] items, int capacity) {
        // Sort items by value/weight ratio in descending order
        Arrays.sort(items, new Comparator<Item>() {
            public int compare(Item a, Item b) {
                double r1 = (double)a.value / a.weight;
                double r2 = (double)b.value / b.weight;
                return Double.compare(r2, r1);
            }
        });

        double totalValue = 0.0;

        for (Item item : items) {
            if (capacity == 0) break;

            if (item.weight <= capacity) {
                // Take the whole item
                totalValue += item.value;
                capacity -= item.weight;
            } else {
                // Take fractional part
                totalValue += item.value * ((double) capacity / item.weight);
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Item[] items = {
                new Item(60, 10),
                new Item(100, 20),
                new Item(120, 30)
        };
        int capacity = 50;

        double maxValue = getMaxValue(items, capacity);
        System.out.println("Maximum value we can obtain = " + maxValue);
    }
}

