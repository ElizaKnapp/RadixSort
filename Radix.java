public class Radix{
  public static int nth(int n, int col) {
    if (n < 0) n = n * -1;
    int div = n / (int)Math.pow(10, col);
    return div % 10;
  }

}
