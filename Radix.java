public class Radix{
  public static int nth(int n, int col) {
    if (n < 0) n = n * -1;
    int div = n / (int)Math.pow(10, col);
    return div % 10;
  }

  public static int length(int n) {
    if (n < 0) n = n * -1;
    if (n == 0) return 1;
    return (int) Math.log10(n) + 1;
  }

  public static void merge(SortableLinkedList original, SortableLinkedList[] buckets) {
    for (int i = 0; i < buckets.length; i++) {
      original.extend(buckets[i]);
    }
  }

  public static void radixSortSimple(SortableLinkedList data) {
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    for (int i = 0; i < 10; i ++) {
      buckets[i] = new SortableLinkedList();
    }

    //least significant pass- also here calc the largest number
    int maxPlace = 0;
    while (data.size() != 0) {
      int holder = data.get(0);
      if (length(holder) > maxPlace) maxPlace = length(holder);
      buckets[nth(holder, 0)].add(holder);
      data.remove(0);
    }

    merge(data, buckets);

    for (int i = 0; i < maxPlace; i++) {
      //empty the buckets
      buckets = new SortableLinkedList[10];
      for (int j = 0; j < 10; j++) {
        buckets[i] = new SortableLinkedList();
      }
      //add the terms by place value of i
      while (data.size() != 0) {
        int holder = data.get(0);
        buckets[nth(holder, i)].add(holder);
        data.remove(0);
      }
      merge(data, buckets);
    }

  }



}
