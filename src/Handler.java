public class Handler
{
  public static String in;
  public static String out;
  public static String loc = "loc";
  public static String location = "location";

  public static int getyeflask = 0;
  public static int idle = 0;

  public static String input(String i)
  {
    in = i.toLowerCase();
    if ((in.equals("inv")) || (in.equals("inventory")))
    {
      return Inventory.outputinv();
    }

    if ((in.equals("north")) || (in.equals("move north")))
    {
      if (Location.getY() == 0)
      {
        return "You can't go that way!";
      }

      Location.translate(0, -1);
      return RoomHandler.handling(Location.getX(), Location.getY()).description();
    }

    if ((in.equals("south")) || (in.equals("move south")))
    {
      if (Location.getY() == 3)
      {
        return "You can't go that way!";
      }

      Location.translate(0, 1);
      return RoomHandler.handling(Location.getX(), Location.getY()).description();
    }

    if ((in.equals("west")) || (in.equals("move west")))
    {
      if (Location.getX() == 0)
      {
        return "You can't go that way!";
      }

      Location.translate(-1, 0);
      return RoomHandler.handling(Location.getX(), Location.getY()).description();
    }

    if ((in.equals("east")) || (in.equals("move east")))
    {
      if (Location.getX() == 3)
      {
        return "You can't go that way!";
      }

      Location.translate(1, 0);
      return RoomHandler.handling(Location.getX(), Location.getY()).description();
    }

    if (in.equals("move"))
    {
      return "Move which way?";
    }
    if ((in.equals("desc")) || (in.equals("describe")) || (in.equals("description")) || (in.equals("see")) || (in.equals("inspect")))
    {
      return RoomHandler.handling(Location.getX(), Location.getY()).description(false);
    }
    if ((in.equals("")) || (in.equals(" ")) || (in.equals("  ")) || (in.equals("   ")) || (in.equals("    ")) || (in.equals("     ")) || (in.equals("      ")) || (in.equals("       ")) || (in.equals("        ")) || (in.equals("         ")) || (in.equals("          ")) || (in.equals("           ")))
    {
      if (idle == 0)
      {
        idle += 1;
        return "Doing nothing won't get you much of anywhere.";
      }
      if (idle == 1)
      {
        idle += 1;
        return "Well, get moving!";
      }
      if (idle == 2)
      {
        idle += 1;
        return "The Constitution of Bacrum isn't going to find itself!";
      }
      if (idle == 3)
      {
        idle += 1;
        return "Come on, get moving!";
      }
      if (idle == 4)
      {
        idle += 1;
        return "Why are you just standing there?";
      }
      if (idle == 5)
      {
        idle += 1;
        return "Well, are you going to do something?";
      }
      if (idle == 6)
      {
        idle += 1;
        return "Get to it! You've got a lot to do!";
      }
      if (idle == 7)
      {
        idle += 1;
        return "It really is baffling how often you sit around.";
      }
      if (idle == 8)
      {
        idle += 1;
        return "The world depends on your success! DO SOMETHING!";
      }
      if (idle == 9)
      {
        idle += 1;
        return "You've gone and done it. You'd better get moving before something bad happens.";
      }
      if (idle == 10)
      {
        return "You have been eaten by a grue; it has been following you for some time now, waiting for you to stand still.";
      }
    } else {
      if ((in.equals("quit")) || (in.equals("exit")))
      {
        return "Are you sure? Y/N";
      }

      out = RoomHandler.handling(Location.getX(), Location.getY()).outputroom(in);

      if (out.equals(RoomHandler.handling(Location.getX(), Location.getY()).getName()))
      {
        RoomHandler.handling(Location.getX(), Location.getY()).roomstateplus();
        out = RoomHandler.handling(Location.getX(), Location.getY()).outputroom(out);
      }
      else if (out.equals("deceptionwin"))
      {
        RoomHandler.handling(Location.getX(), Location.getY()).roomstatechange(15);
        out = RoomHandler.handling(Location.getX(), Location.getY()).outputroom("deceptionroom");
      }
      else if ((out.equals("unitydeception")) || (out.equals("unitypassion")) || (out.equals("unityrestraint")) || (out.equals("unityforesight")) || (out.equals("unityblindness")) || (out.equals("unitydiscovery")) || (out.equals("unitystagnancy")) || (out.equals("unityelegance")) || (out.equals("unitybureaucracy")))
      {
        RoomHandler.handling(Location.getX(), Location.getY()).roomstateplus();
        out = RoomHandler.handling(Location.getX(), Location.getY()).outputroom(out);
      }
      else if ((RoomHandler.handling(Location.getX(), Location.getY()).getName().equals("stagnancyroom")) && (RoomHandler.handling(Location.getX(), Location.getY()).getroomstate() == 2))
      {
        RoomHandler.handling(Location.getX(), Location.getY()).roomstatechange(0);
        out = RoomHandler.handling(Location.getX(), Location.getY()).outputroom("stagnancyfail");
      }
      else if (out.equals("stagnancylever2"))
      {
        RoomHandler.handling(Location.getX(), Location.getY()).roomstatechange(2);
        out = RoomHandler.handling(Location.getX(), Location.getY()).outputroom("stagnancyroom");
      }
      else if (out.equals("stagnancyfail"))
      {
        RoomHandler.handling(Location.getX(), Location.getY()).roomstatechange(0);
        out = RoomHandler.handling(Location.getX(), Location.getY()).outputroom("stagnancyfail");
      }

      if (out.equals("You received the Book of Unity! It says to you, \"While in this room, speak the name of one of the other books, and I will guide you in finding it. They are: Deception, Passion, Restraint, Foresight, Blindness, Discovery, Stagnancy, Elegance, and Bureaucracy.\""))
      {
        Inventory.updateinv(0);
      }
      else if (out.equals("As you lift the book, every other book in the room crumbles to dust, and all of the green mist disappears, though the gloom hanging over the room remains. You received the Book of Deception!"))
      {
        Inventory.updateinv(1);
      }
      else if (out.equals("You received the Book of Passion!"))
      {
        Inventory.updateinv(2);
      }
      else if (out.equals("You received the Book of Restraint!"))
      {
        Inventory.updateinv(3);
      }
      else if (out.equals("As you approach, he thanks you for your trust. \"It is not often that one wanders in here, willing to trust me. In exchange for your assistance, I offer you mine. I have divined the secrets of the Constitution of Bacrum, but I am far too old to act upon them. I have been trapped in here for fifty years by the library's magic, but you are my ticket out.\" He hands you a tattered old bag. \"You will need this. It is a special bag of holding, which you will use to carry very special objects. You see, the Constitution is not here. It is not anywhere. Instead, it is everywhere. Well, not quite. But the Constitution's writers put ten ideas into it when they devised it:\n\n\"Unity, Deception, Passion, Restraint, Foresight, Blindness, Discovery, Stagnancy, Elegance, and Bureaucracy.\n\n\"The Constitution's magic has caused it to split into ten personified books, each in its own room in this library. Finding them will not be easy, but I did manage to find one before my strength waned to nothingness. In that bag, you will find the Book of Foresight.\n\n\"Type \"inv\" or \"inventory\" to look in your bag. A few more pointers: type \"move\" and then a cardinal direction to move between rooms - or you can drop the \"move\" entirely. If you want to see more of a room, type \"desc\" or \"describe\". If you want to exit this game, type \"exit\" or \"quit\" at any time. But be warned, you cannot save your progress! When you find all ten books, come back here, and say, \"Cthulhu fhtagn\", and I will appear.\n\n\"...oh, and no more ALL CAPS to tell you what to do.\""))
      {
        Inventory.updateinv(4);
      }
      else if (out.equals("You received the Book of Blindness!"))
      {
        Inventory.updateinv(5);
      }
      else if (out.equals("You received the Book of Discovery!"))
      {
        Inventory.updateinv(6);
      }
      else if (out.equals("You received the Book of Stagnancy!"))
      {
        Inventory.updateinv(7);
      }
      else if (out.equals("You received the Book of Elegance!"))
      {
        Inventory.updateinv(8);
      }
      else if (out.equals("You received the Book of Bureaucracy!"))
      {
        Inventory.updateinv(9);
      }
      else if (out.equals("oldmancheck"))
      {
        if (Inventory.howMany() == 1)
        {
          out = "The old man says from nowhere, \"Get moving, you've got a lot to get!\"";
        }
        else if (Inventory.howMany() == 2)
        {
          out = "The old man says from nowhere, \"That's two, Chaxvor. Keep moving!\"";
        }
        else if (Inventory.howMany() == 3)
        {
          out = "The old man says from nowhere, \"Well, you've got three. Why are you back here already?\"";
        }
        else if (Inventory.howMany() == 4)
        {
          out = "The old man says from nowhere, \"Okay, so you've got four. That's not bad. But you need more!\"";
        }
        else if (Inventory.howMany() == 5)
        {
          out = "The old man says from nowhere, \"Five of the ten is nice, but we need them all!\"";
        }
        else if (Inventory.howMany() == 6)
        {
          out = "The old man says from nowhere, \"Six doesn't do us any more good than one; keep collecting!\"";
        }
        else if (Inventory.howMany() == 7)
        {
          out = "The old man says from nowhere, \"Chaxvor Bellus Drael, do you know the difference between 7 and 10? IT'S THREE.\"";
        }
        else if (Inventory.howMany() == 8)
        {
          out = "The old man says from nowhere, \"Eight books!? Nobody's ever gotten that many!\"";
        }
        else if (Inventory.howMany() == 9)
        {
          out = "The old man says from nowhere, \"Holy mother of Avandra, Chaxvor! I can't believe you've got nine! Just one more!\"";
        }
        else if (Inventory.howMany() == 10)
        {
          out = "The old man appears out of nowhere.";
        }
      }
      return out;
    }
    return "There's an error here. Fix it!";
  }
}