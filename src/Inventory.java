public class Inventory
{
  public static String[] names;
  public static boolean[] have;

  public Inventory(String[] items, boolean[] status)
  {
    names = items;
    have = status;
  }

  public static int howMany()
  {
    int howmany = 0;
    for (int i = 0; i < have.length; i++)
    {
      if (have[i] == true)
      {
        howmany++;
      }
    }
    return howmany;
  }

  public static String outputinv()
  {
    String finished = "You have in your inventory:\n\n";
    for (int i = 0; i < 10; i++)
    {
      if ((have[i] == true) && ((have[(i + 1)] == true) || (have[(i + 2)] == true) || (have[(i + 3)] == true) || (have[(i + 4)] == true) || (have[(i + 5)] == true) || (have[(i + 6)] == true) || (have[(i + 7)] == true) || (have[(i + 8)] == true) || (have[(i + 9)] == true)))
      {
        finished = finished + names[i] + "\n";
      }
      else if (have[i] == true)
      {
        finished = finished + names[i];
      }
    }
    if (finished.equals("You have in your inventory:\n\n"))
    {
      finished = "You don't have a bag to put things in!";
    }
    return finished;
  }

  public static void updateinv(int i)
  {
    have[i] = true;
  }
}