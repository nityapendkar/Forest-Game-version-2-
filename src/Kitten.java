import java.util.ArrayList;
import java.util.Random;

public class Kitten extends Cat{
	
	private Tuple c = new Tuple(0,0);
	
	Kitten(int x, int y) {
		super(x, y);
	}
	
	/* (non-Javadoc)
	 * @see Canine#move(Tuple, char[][])
	 */
	public Tuple move(Tuple d, char[][] forest) {
		int initialX=d.getX();
		int initialY=d.getY();
		int newX=initialX;
		int newY=initialY;
		
		Random r = new Random();
		int b =r.nextInt(10 - 0) + 0;
		if (b==0 || b==1 || b==2) {
			newX=initialX;
			newY=initialY;
		}
		else {

			int a =super.coordinateGenerator(8 ,0 );
			if(a==0) {
				newX=(initialX);
				newY=(initialY+1);
				while(newY>14 || newY<0 || newY==initialY) {
					newY=super.coordinateGenerator((initialY +2) ,(initialY -1) );
				}
			}
			if(a==1) {
				newX=(initialX);
				newY=(initialY-1);
				while(newY>14 || newY<0 || newY==initialY) {
					newY=super.coordinateGenerator((initialY +2) ,(initialY -1) );
				}
			}
			if(a==2) {
				newX=(initialX+1);
				newY=(initialY);
				while(newX>14 || newX<0 || newX==initialX) {
					newX=super.coordinateGenerator((initialX +2) ,(initialX -1) );
				}
			}
			if(a==3) {
				newX=(initialX-1);
				newY=(initialY);
				while(newX>14 || newX<0 || newX==initialX) {
					newX=super.coordinateGenerator((initialX +2) ,(initialX -1) );
				}
			}
			if(a==4) {
				newX=(initialX+1);
				newY=(initialY+1);
				while(newX>14 || newX<0 || newX==initialX || newY>14 || newY<0 || newY==initialY ) {
					newX=super.coordinateGenerator((initialX +2) ,(initialX -1) );
					newY=super.coordinateGenerator((initialY +2) ,(initialY -1) );
				}
			}
			if(a==5) {
				newX=(initialX-1);
				newY=(initialY-1);
				while(newX>14 || newX<0 || newX==initialX || newY>14 || newY<0 || newY==initialY ) {
					newX=super.coordinateGenerator((initialX +2) ,(initialX -1) );
					newY=super.coordinateGenerator((initialY +2) ,(initialY -1) );
				}
			}
			if(a==6) {
				newX=(initialX-1);
				newY=(initialY+1);
				while(newX>14 || newX<0 || newX==initialX || newY>14 || newY<0 || newY==initialY ) {
					newX=super.coordinateGenerator((initialX +2) ,(initialX -1) );
					newY=super.coordinateGenerator((initialY +2) ,(initialY -1) );
				}
			}
			if(a==7) {
				newX=(initialX+1);
				newY=(initialY-1);
				while(newX>14 || newX<0 || newX==initialX || newY>14 || newY<0 || newY==initialY ) {
					newX=super.coordinateGenerator((initialX +2) ,(initialX -1) );
					newY=super.coordinateGenerator((initialY +2) ,(initialY -1) );
				}
			}
			
			
		}
		Tuple c =new Tuple(newX, newY);
		return c;

	}
	/**
	 * Returns the tuple
	 * @return Returns the tuple
	 */
	public Tuple getTuple() {
		return c;
	}
	public String fight ( Tuple victim_position, Tuple attacker_initial, Tuple attacker_if_wins, char[][] forest,ArrayList <Tuple> l,ArrayList <Tuple>  dead, ArrayList <String>  deadAnimals) {
String result="";
if (forest[victim_position.getX()][victim_position.getY()]=='k') {
	//System.out.println("check if 0 Dog" );
	Random r = new Random();
int a =r.nextInt(2 - 0) + 0;
//attacker wins

if(a==0) {
	//System.out.println("check if 1 Dog" );
	System.out.println("Kitten from ("+ attacker_initial.getX() + ", " + 
    attacker_initial.getY() +") attacks Kitten at ("+  victim_position.getX() + ", " 
	+ victim_position.getY() +") and wins");
	System.out.println("Kitten dies at (" + victim_position.getX() + ", " + victim_position.getY() +
	")");
	System.out.println("Kitten moved from (" + attacker_initial.getX() + ", "
	+ attacker_initial.getY() + ") to (" + attacker_if_wins.getX() + ", "
	+ attacker_if_wins.getY() + ")" );

	result = "wins";
	
}
//attacker loses
if(a==1) {
	//System.out.println("check if 2 Dog" );
	System.out.println("Kitten from ("+ attacker_initial.getX() + ", " + attacker_initial.getY() +") attacks Kitten at ("+  victim_position.getX() + ", " 
			+ victim_position.getY() +") and loses");
	System.out.println("Kitten dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
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
				deadAnimals.add("Kitten");
			
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
			deadAnimals.add("Kitten");
		
	}
}
}
//}

}
else if (forest[victim_position.getX()][victim_position.getY()]=='c') {
	Random r = new Random();
	int b =r.nextInt(10 - 0) + 0;
	if(b<3) {
		System.out.println("Kitten from ("+ attacker_initial.getX() + ", " + 
			    attacker_initial.getY() +") attacks Cat at ("+  victim_position.getX() + ", " 
				+ victim_position.getY() +") and wins");
				System.out.println("Cat dies at (" + victim_position.getX() + ", " + victim_position.getY() +
				")");
				System.out.println("Kitten moved from (" + attacker_initial.getX() + ", "
				+ attacker_initial.getY() + ") to (" + attacker_if_wins.getX() + ", "
				+ attacker_if_wins.getY() + ")" );

				result = "wins";
	}
	else {
		System.out.println("Kitten from ("+ attacker_initial.getX() + ", " + attacker_initial.getY() +") attacks Cat at ("+  victim_position.getX() + ", " 
				+ victim_position.getY() +") and loses");
		System.out.println("Kitten dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
				")");
		
		result = "loses";
	}
	if(result.equals("wins")) {
		for(int start=0;start<l.size();start++) {
			if ((l.get(start).getX()==victim_position.getX()) 
					&& (l.get(start).getY()==victim_position.getY())) {
				l.get(start).update(-1, -1);
				//l.remove(start);
				dead.add(new Tuple (victim_position.getX(), victim_position.getY()));
				deadAnimals.add("Cat");
			
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
			deadAnimals.add("Kitten");
		
	}
}
}
}
else {
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
	if (forest[victim_position.getX()][victim_position.getY()] == 'j') {
		victim= "Jaguar";
	}
	if (forest[victim_position.getX()][victim_position.getY()] == 'h') {
		victim= "Dinosaur";
	}
	System.out.println("Kitten from ("+ attacker_initial.getX() + ", " + 
		    attacker_initial.getY() +") attacks " + victim + " at ("+  victim_position.getX() + ", " 
			+ victim_position.getY() +") and loses");
	System.out.println( "Kitten dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
			")");
	//forest[attacker_if_wins.getX()][attacker_if_wins.getY()]='.';
	result = "loses";
	for(int start=0;start<l.size();start++) {
		if ((l.get(start).getX()==attacker_initial.getX()) 
				&& (l.get(start).getY()==attacker_initial.getY())) {
			//l.remove(start);
			l.get(start).update(-1, -1);
			dead.add(new Tuple (attacker_initial.getX(), attacker_initial.getY()));
			deadAnimals.add("Kitten");
			
		
	}
}
}
		return result;	
	}
}
