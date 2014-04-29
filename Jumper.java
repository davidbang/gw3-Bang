/*David Bang
  <https://github.com/davidbang/gw3-Bang>
  APCS pd 8
  HW#33 -- GridWorld, Part 3
  2014-04-28 */

import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.Color;

public class Jumper extends Actor { 
    public Jumper () {
	setColor(Color.BLUE);
    }

    public void act()
    {
	if (canMove())
	    move();
	else
	    turn();
    }

    public void turn()
    {
	setDirection(getDirection() + Location.HALF_RIGHT);
    }

    public void move()
    {
	Grid<Actor> gr = getGrid();
	if (gr == null)
	    return;
	Location loc = getLocation();
	Location next = loc.getAdjacentLocation(getDirection());
	Location twoNext = next.getAdjacentLocation(getDirection());
	if (gr.isValid(twoNext))
	    moveTo(twoNext);
	else
	    removeSelfFromGrid();
    }

    public boolean canMove()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
            return false;
	Location twoNext = next.getAdjacentLocation(getDirection());
	if (!gr.isValid(twoNext))
	    return false;
        Actor neighbor = gr.get(twoNext);
        return (neighbor == null) || (neighbor instanceof Flower);
        // ok to move into empty location or onto flower
        // not ok to move onto any other actor
    }
}

