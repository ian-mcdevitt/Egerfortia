public class RoomHandler
{
  public static Room[][] rooms;
  public static String[] ev = { "", "", "" };
  public static String[] key = { "", "", "" };

  public RoomHandler(Room[][] Rooms)
  {
    rooms = Rooms;
  }

  public static Room handling(int x, int y)
  {
    return rooms[x][y];
  }
}