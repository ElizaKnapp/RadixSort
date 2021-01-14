public class Radix{
  public static int nth(int n, int col) {
    if (n < 0) n = n * -1;
    n = n / (int)Math.pow(10, col);
    return n % 10;
  }

  public static int length(int n) {
    if (n == 0) return 1;
    if (n < 0) n = n * -1;
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
      //add the terms by place value of i
      while (data.size() != 0) {
        int holder = data.get(0);
        buckets[nth(holder, i)].add(holder);
        data.remove(0);
      }
      merge(data, buckets);
    }

  }

  public static void radixSort(SortableLinkedList data) {
    SortableLinkedList positiveData = new SortableLinkedList();
    SortableLinkedList negativeData = new SortableLinkedList();
    while (data.size() != 0) {
      int toRemove = data.remove(0);
      if (toRemove >= 0) positiveData.add(toRemove);
      else negativeData.add(toRemove * -1);
    }

    radixSortSimple(negativeData);
    radixSortSimple(positiveData);

    while (negativeData.size() > 0) {
      data.add(negativeData.remove(negativeData.size() - 1) * -1);
    }

    data.extend(positiveData);

  }















}
