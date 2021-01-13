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

  public static void merge(MyLinkedList original, MyLinkedList[] buckets) {
    for (int i = 0; i < buckets.length; i++) {
      original.extend(i);
    }
  }

}
