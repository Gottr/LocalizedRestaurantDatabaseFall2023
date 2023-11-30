package com.example.majorprogrammingproject;

// I chose to use quicksort as it's a more efficient means of sorting the string array.
// The time formula is T(n) = O(nlogn)

public class QuickSort {

    public static void QuickSort(String[] restaurants) { //Initial call that leads to Overloaded method.
        QuickSort(restaurants, 0, restaurants.length - 1);
    }

    private static void QuickSort(String[] restaurants, int begin, int end) {
        if (end > begin) {
            int pivot = Partition(restaurants, begin, end);
            QuickSort(restaurants, begin, pivot - 1);
            QuickSort(restaurants, pivot + 1, end);
        }
    }

    protected static int Partition(String[] restaurants, int begin, int end) {
        String pivot = restaurants[begin];
        int low = begin + 1;
        int high = end;

        // Complete sort
        while (low < high) {
            // Begin by sorting from forward to left
            while (low <= high && restaurants[low].compareTo(pivot) <= 0) {
                low++;
            }
            // Continue by sorting back to right
            while (low <= high && restaurants[high].compareTo(pivot) > 0) {
                high--;
            }
            // Swap the elements if high > low
            if (high > low) {
                String tempString = restaurants[high]; //Temporary string to hold the value of high
                restaurants[high] = restaurants[low];
                restaurants[low] = tempString;
            }
        }
        while (high > begin && restaurants[high].compareTo(pivot) >= 0) {
            high--;
        }

        if (pivot.compareTo(restaurants[high]) > 0) {
            restaurants[begin] = restaurants[high];
            restaurants[high] = pivot;
            return high;
        } else {
            return begin;
        }
    }
}
