public class Radix{
  public static int nth(int n, int col) {
    int div = n / Math.pow(10, col);
    return div % 10;
  }

}
