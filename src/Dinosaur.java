import java.util.ArrayList;
import java.util.Random;
/**
 * @author Nitya Pendkar
 * The Turtle class extends from the Animal class
 */
public class Dinosaur extends Animal{

		private Tuple c = new Tuple(0,0);
		Dinosaur (int x, int y) {
			c.update(x, y);
		}
		/* (non-Javadoc)
		 * @see Animal#move(Tuple, char[][])
		 */
		public Tuple move(Tuple c, char [][] forest) {
			int initialX=c.getX();
			int initialY=c.getY();
			int newX=initialX;
			int newY=initialY;
			
			Random r = new Random();
			int a =r.nextInt(2 - 0) + 0;
			int b=0;
			//x-coordinate remains unchanged
			if (a==0) {
				b=super.coordinateGenerator(2 ,1 );
				if (b==0) {
					
					newY=initialY +3;
					while(newY>14 || newY<0 || newY==initialY) {
						newY=initialY -3;
					}
				}
				if (b==1) {
					newY=initialY -3;
					while(newY>14 || newY<0 || newY==initialY) {
						newY=initialY +3;
					}
				}
				
			}
			//y-coordinate remains unchanged
			else if(a==1) {
				b=super.coordinateGenerator(2 ,1 );
				if(b==0) {
					newX=initialX +3;
					while(newX>14 || newX<0 || newX==initialX) {
						newX=initialX -3;
						}
				}
				if(b==1) {
					newX=initialX -3;
					while(newX>14 || newX<0 || newX==initialX) {
						newX=initialX +3;
						}
				}
			}
			Tuple d =new Tuple(newX, newY);
			
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
		 * @see Animal#fight(Tuple, Tuple, Tuple, char[][], java.util.ArrayList, java.util.ArrayList, java.util.ArrayList)
		 */
		public String fight ( Tuple victim_position, Tuple attacker_initial, Tuple attacker_if_wins,
				char[][] forest,ArrayList <Tuple> l,ArrayList <Tuple>  dead, ArrayList <String>  deadAnimals) {
			String result="";
		String victim="";
		if (forest[victim_position.getX()][victim_position.getY()] == 'u') {
			victim= "Turtle";
		}
		if (forest[victim_position.getX()][victim_position.getY()] == 'd') {
			victim= "Dog";
		}
		if (forest[victim_position.getX()][victim_position.getY()] == 'w') {
			victim= "Wolf";
		}
		if (forest[victim_position.getX()][victim_position.getY()] == 'f') {
			victim= "Fox";
		}
		if (forest[victim_position.getX()][victim_position.getY()] == 'c') {
			victim= "Cat";
		}
		if (forest[victim_position.getX()][victim_position.getY()] == 'l') {
			victim= "Lion";
		}
		if (forest[victim_position.getX()][victim_position.getY()] == 'i') {
			victim= "Dinosaur";
		}
		if (forest[victim_position.getX()][victim_position.getY()] == 'k') {
			victim= "Kitten";
		}
		if (forest[victim_position.getX()][victim_position.getY()] == 'j') {
			victim= "Jaguar";
		}
				

		System.out.println("Dinosaur from ("+ attacker_initial.getX() + ", " + 
			    attacker_initial.getY() +") attacks "+victim+" at ("+  victim_position.getX() + ", " 
				+ victim_position.getY() +") and wins");
				System.out.println(victim+" dies at (" + victim_position.getX() + ", " + victim_position.getY() +
				")");
				System.out.println("Dinosaur moved from (" + attacker_initial.getX() + ", "
				+ attacker_initial.getY() + ") to (" + attacker_if_wins.getX() + ", "
				+ attacker_if_wins.getY() + ")" );
				result = "wins";
				
				for(int start=0;start<l.size();start++) {
					if ((l.get(start).getX()==victim_position.getX()) 
							&& (l.get(start).getY()==victim_position.getY())) {
						l.get(start).update(-1, -1);
						//l.remove(start);
						dead.add(new Tuple (victim_position.getX(), victim_position.getY()));
						deadAnimals.add(victim);
		
	}}
			return result;
     }
	}