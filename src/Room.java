public class Room
{
  String name;
  boolean seen;
  String[] Description;
  String[] ShortDescription;
  String[][] Events;
  String[][] Keys;
  int roomstate;

  public Room(String nomen, String[] descrip, String[] shortdescrip, String[][] events, String[][] keys)
  {
    this.roomstate = 0;
    this.name = nomen;
    this.Description = descrip;
    this.ShortDescription = shortdescrip;
    this.Events = events;
    this.Keys = keys;
  }

  public String getName()
  {
    return this.name;
  }

  public int getState() {
    return this.roomstate;
  }

  public String description()
  {
    if (!this.seen)
    {
      this.seen = true;
      return this.Description[this.roomstate];
    }

    return this.ShortDescription[this.roomstate];
  }

  public String description(boolean check)
  {
    this.seen = check;
    if (!this.seen)
    {
      this.seen = true;
      return this.Description[this.roomstate];
    }

    return this.ShortDescription[this.roomstate];
  }

  public String outputroom(String in)
  {
    for (int i = 0; i < this.Keys[this.roomstate].length; i++)
    {
      if (in.equals(this.Keys[this.roomstate][i]))
      {
        return this.Events[this.roomstate][i];
      }
    }
    return "You can't do that.";
  }

  public void roomstateplus()
  {
    this.roomstate += 1;
  }

  public void roomstatechange(int newstate)
  {
    this.roomstate = newstate;
  }

  public int getroomstate()
  {
    return this.roomstate;
  }
}