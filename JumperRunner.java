import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;

public class JumperRunner
{
    public static void main(String[] args)
    {
	ActorWorld world = new ActorWorld();
	Jumper j = new Jumper();
	world.add(j);
	Rock r = new Rock();
	world.add(r);
	Flower f = new Flower();
	world.add(f);
	world.show();
    }
}
