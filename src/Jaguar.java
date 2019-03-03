import java.util.ArrayList;
import java.util.Random;
public class Jaguar extends Feline {
	private Tuple c = new Tuple(0,0);
	Jaguar (int x, int y) {
		c.update(x, y);
	}
	
	/* (non-Javadoc)
	 * @see Feline#move(Tuple, char[][])
	 */
	public Tuple move(Tuple d, char[][] forest) {
		d = super.move(d, forest);
		return d;

	}
	/**
	 * Returns the tuple
	 * @return Returns the tuple
	 */
	public Tuple getTuple() {
		return c;
	}
	/* (non-Javadoc)
	 * @see Feline#fight(Tuple, Tuple, Tuple, char[][], java.util.ArrayList, java.util.ArrayList, java.util.ArrayList)
	 */
	public String fight ( Tuple victim_position, Tuple attacker_initial, Tuple attacker_if_wins, char[][] forest,ArrayList <Tuple> l,ArrayList <Tuple>  dead, ArrayList <String>  deadAnimals) {
		String result="";
		if (forest[victim_position.getX()][victim_position.getY()]=='j') {
			//System.out.println("check if 0 Dog" );
			Random r = new Random();
		int a =r.nextInt(2 - 0) + 0;
		//attacker wins
		
		if(a==0) {
			//System.out.println("check if 1 Dog" );
			System.out.println("Jaguar from ("+ attacker_initial.getX() + ", " + 
		    attacker_initial.getY() +") attacks Jaguar at ("+  victim_position.getX() + ", " 
			+ victim_position.getY() +") and wins");
			System.out.println("Jaguar dies at (" + victim_position.getX() + ", " + victim_position.getY() +
			")");
			System.out.println("Jaguar moved from (" + attacker_initial.getX() + ", "
			+ attacker_initial.getY() + ") to (" + attacker_if_wins.getX() + ", "
			+ attacker_if_wins.getY() + ")" );

			result = "wins";
			
		}
		//attacker loses
		if(a==1) {
			//System.out.println("check if 2 Dog" );
			System.out.println("Jaguar from ("+ attacker_initial.getX() + ", " + attacker_initial.getY() +") attacks Jaguar at ("+  victim_position.getX() + ", " 
					+ victim_position.getY() +") and loses");
			System.out.println("Jaguar dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
					")");
			
			result = "loses";
		}
		//if(attacker_initial.getX()==attacker_if_wins.getX() || attacker_initial.getY()==attacker_if_wins.getY()) {
		if(result.equals("wins")) {
				for(int start=0;start<l.size();start++) {
					if ((l.get(start).getX()==victim_position.getX()) 
							&& (l.get(start).getY()==victim_position.getY())) {
						l.get(start).update(-1, -1);
						//l.remove(start);
						dead.add(new Tuple (victim_position.getX(), victim_position.getY()));
						deadAnimals.add("Jaguar");
					
				}
			}
		}
		else {
			for(int start=0;start<l.size();start++) {
				if ((l.get(start).getX()==attacker_initial.getX()) 
						&& (l.get(start).getY()==attacker_initial.getY())) {
					l.get(start).update(-1, -1);
					//l.remove(start);
					dead.add(new Tuple (attacker_initial.getX(), attacker_initial.getY()));
					deadAnimals.add("Jaguar");
				
			}
		}
		}
		//}
		
		}
		return result;
	}
}
