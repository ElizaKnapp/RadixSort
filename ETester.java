import java.util.*;
import java.io.*;

public class ETester {
  public static void main(String[] args) {
    int n = Radix.nth(-123, 2);
    System.out.println(n);

    int a = Radix.length(0);
    System.out.println(a);

    SortableLinkedList l = new SortableLinkedList();
    ArrayList<Integer> al = new ArrayList();
    int[] values = {-5, -329, -38, -823, -49, -32829, -328, -32, -32829};
    for (int i = 0; i < 9; i++) {
      l.add(values[i]);
      al.add(values[i]);
    }
    Radix.radixSort(l);
    Collections.sort(al);
    System.out.println(l);
    System.out.println(al);

  }
}
