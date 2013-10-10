public class Location
{
  public static int x;
  public static int y;

  public Location(int numx, int numy)
  {
    x = numx - 1;
    y = numy - 1;
  }

  public static int getX()
  {
    return x;
  }

  public static int getY()
  {
    return y;
  }

  public static void translate(int horiz, int vert)
  {
    x += horiz;
    y += vert;
  }
}