
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * The class forest allows the creation of the empty forest, allows addition of animals, printing the forest
 * and the actions that take place in every iteration.
 * @author Nitya Pendkar
 *
 */
public class ForestNew {
	
	/**
	 * This function generates a random integer between 0 and 14(inclusive) to generate random co-ordinates 
	 * while adding a new animal to the forest.
	 * @return returns the random integer value which is between 0 and 14(inclusive)
	 */
	public static int numberGenerator() {
		Random r = new Random();
		//Change the MAXIMUM to 15 before submitting!!!
		int a =r.nextInt(2 - 0) + 0;
		return a;
	}
	
	/**
	 * Assigns a value of precedence to each animal. Animals are moved in the iteration step following an order
	 * of alphabetical order precedence.
	 * @param animal: it is the character indicating an animal in the forest
	 * @return the numerical value to indicate precedence of animal in the iterate step
	 */
	static int precedence(char animal)
	{
		if (animal == 'c')
			return 9;
		else if (animal == 'i')
			return 8;
		else if (animal == 'd')
			return 7;
		else if (animal == 'f')
			return 6;
		else if (animal == 'j')
			return 5;
		else if (animal == 'k')
			return 4;
		else if (animal == 'l')
			return 3;
		else if (animal == 'u')
			return 2;
		else if (animal == 'w')
			return 1;
		else return 0;
	}
	
	/**
	 * Prints the statement to indicate when an animal has been added at the particular location while creating the forest.
	 * @param c number to indicate which animal has been added. Each integer used corresponds to a particular animal.
	 * @param a X co-ordinate of the location when animal is added
	 * @param b Y co-ordinate of the location when animal is added
	 */
	static void animalAdded(int c, int a , int b) {
		//System.out.println();
		String printString="";
		switch (c) {
		case 1: printString = "Added Dog at ("+a +", "+b+") "+": Dog is Canine, Canine moves in four directions, one or two steps a time.";
				System.out.println(printString);
				break;
		case 2: printString = "Added Fox at ("+a +", "+b+") "+": Fox is Canine, Canine moves in four directions, one or two steps a time.";
				System.out.println(printString);
		        break;
		case 3: printString = "Added Wolf at ("+a +", "+b+") "+": Wolf is Canine, Canine moves in four directions, one or two steps a time.";
				System.out.println(printString);
		        break;
		case 4: printString = "Added Jaguar at ("+a +", "+b+") "+": Jaguar is Feline, Feline moves in all eight directions, one step a time.";
				System.out.println(printString);
		        break;
		case 5: printString = "Added Lion at ("+a +", "+b+") "+": Lion is Feline, Feline moves in all eight directions, one step a time.";
		System.out.println(printString);
		        break;
		case 6:  printString = "Added Cat at ("+a +", "+b+") "+": Cat is Feline, Feline moves in all eight directions, one step a time.";
		System.out.println(printString);
		        break;
		case 7: printString = "Added Kitten at ("+a +", "+b+") "+": Kitten has 30% chance stay in the same position, and 70% chance move in eight directions, one step at a time.";
		System.out.println(printString);
		        break;
		case 8: printString = "Added Dinosaur at ("+a +", "+b+") "+": Dinosaur moves in four directions, three steps a time.";
		System.out.println(printString);	
		        break;
		case 9: printString = "Added Turtle at ("+a +", "+b+") "+": Turtle has 50% chance stay in the same position, and 50% chance move in four directions, one step at a time.";
		System.out.println(printString);	
		        break;
		default: ;
        break;        
		}
	}
	
	/**
	 * It is a check to make sure that the location in the forest is not occupied by any other animal
	 * @param num1 The generated x-coordinate for the animal to be added 
	 * @param num2The generated y-coordinate for the animal to be added 
	 * @param l The arraylist of tuples with all the co-ordinates of the animals which have already  been added to the forest.
	 * @return
	 */
	public static boolean check (int num1, int num2,ArrayList <Tuple>  l) {
		for(int i=0;i<l.size();i++) {	
			//System.out.println(l.get(i));
			if (num1==l.get(i).getX() && num2==l.get(i).getY() ) {
				return true;
			}
			
		}
		return false;
	}
    
	/**
	 * prints the current forest when "print" is called by the user. Also indicates which animals have died at
	 * which locations.
	 * @param forest the 2D array of the current forest (with animals and empty spaces.)
	 * @param dead The arrayList of the tuples of the locations of all the dead animals
	 * @param deadAnimals The arrayList of all the animals which have died.
	 */
	public static void printCurrentForest(char [][] forest, ArrayList <Tuple> dead,ArrayList <String>  deadAnimals) {
		//System.out.println("Reached print");
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j<15; j++) {
				System.out.print(forest[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		//System.out.println(deadAnimals.get(0) + " died at location (" + dead.get(0).getX() + ", " + dead.get(0).getY() + ")" );
		for(int j=0;j<dead.size();j++) {
			System.out.println(deadAnimals.get(j) + " died at location (" + dead.get(j).getX() + ", " + dead.get(j).getY() + ")" );
		}
		System.out.println();
	}
	
	/**
	 * Iterates (moves) each animal in the forest when the user presses "enter" and also makes animals fight if they come in each other's path.
	 * @param l  The arraylist of tuples with all the co-ordinates of the animals which have already  been added to the forest. 
	 * @param forest the 2D array of the current forest (with animals and empty spaces.)
	 * @param dead The arrayList of the tuples of the locations of all the dead animals
	 * @param deadAnimals The arrayList of all the animals which have died.
	*/
	public static void iterate(ArrayList <Tuple>  l, char [][]forest,ArrayList <Tuple>  dead,
			ArrayList <String>  deadAnimals) {
		
		
		for (int precedence=9; precedence>0;precedence--) {
		for(int i=0; i<l.size();i++) {
			
			int x=l.get(i).getX();
			int y=l.get(i).getY();
			if(l.get(i).getX() > -1 && l.get(i).getY() > -1 ) {
			char animalLetter = forest [x][y];
			if(animalLetter=='d' && precedence==7) {
				//forest[x][y]='.';
				Dog d = new Dog(x,y);
				Tuple new_location = d.move(d.getTuple(),forest);
				//l.get(i).update(new_location.getX(), new_location.getY());
				boolean check_in_path=false;
				int victim_X=0;
				int victim_Y=0;
				String result="";
				if(x==new_location.getX()){
					if(new_location.getY() > y) {
						for (int path = (y+1); path <= new_location.getY(); path++ ) {
							if(forest[x][path] != '.') {
								check_in_path=true;
								Tuple victim_position =new Tuple(x, path);
						    	Tuple attacker_initial =new Tuple(x, y);
								Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
								if(forest[new_location.getX()][new_location.getY()] == 'i') {
									
									System.out.println("Dog from ("+ attacker_initial.getX() + ", " + 
										    attacker_initial.getY() +") attacks Dinosaur at ("+  victim_position.getX() + ", " 
											+ victim_position.getY() +") and loses");
									System.out.println("Dog dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
											")");
									result = "loses";
									for(int start=0;start<l.size();start++) {
										if ((l.get(start).getX()==attacker_initial.getX()) 
												&& (l.get(start).getY()==attacker_initial.getY())) {
											//l.remove(start);
											l.get(start).update(-1, -1);
											dead.add(new Tuple (attacker_initial.getX(), attacker_initial.getY()));
											deadAnimals.add("Dog");
											
										
									}
								}
								}
								else if (forest[x][path] == 'j') {
									Random r = new Random();
									int a =r.nextInt(2 - 0) + 0;
									//attacker wins
									if(a==0) {
										//System.out.println("check if 1 Dog" );
										System.out.println("Dog from ("+ attacker_initial.getX() + ", " + 
									    attacker_initial.getY() +") attacks Jaguar at ("+  victim_position.getX() + ", " 
										+ victim_position.getY() +") and wins");
										System.out.println("Jaguar dies at (" + victim_position.getX() + ", " + victim_position.getY() +
										")");
										System.out.println(  "Dog moved from (" + attacker_initial.getX() + ", "
										+ attacker_initial.getY() + ") to (" + attacker_if_wins.getX() + ", "
										+ attacker_if_wins.getY() + ")" );

										result = "wins";
										
									}
									//attacker loses
									if(a==1) {
										//System.out.println("check if 2 Dog" );
										System.out.println( "Dog from ("+ attacker_initial.getX() + ", " + attacker_initial.getY() +") attacks Jaguar at ("+  victim_position.getX() + ", " 
												+ victim_position.getY() +") and loses");
										System.out.println("Dog dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
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
												deadAnimals.add("Dog");
											
										}
									}
									}
								}
								else if(forest[x][path] == 'k') {
									System.out.println("Dog from ("+ attacker_initial.getX() + ", " + 
										    attacker_initial.getY() +") attacks Kitten at ("+  victim_position.getX() + ", " 
											+ victim_position.getY() +") and loses");
									System.out.println("Dog dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
											")");
									//forest[attacker_if_wins.getX()][attacker_if_wins.getY()]='.';
									result = "loses";
									for(int start=0;start<l.size();start++) {
										if ((l.get(start).getX()==attacker_initial.getX()) 
												&& (l.get(start).getY()==attacker_initial.getY())) {
											//l.remove(start);
											l.get(start).update(-1, -1);
											dead.add(new Tuple (attacker_initial.getX(), attacker_initial.getY()));
											deadAnimals.add("Dog");
											
										
									}
								}
								}
								else{result=d.fight(victim_position, attacker_initial, attacker_if_wins,forest, l,dead, deadAnimals);}
								victim_X= x;
								victim_Y= path;
							}
						}
					}
					else if(new_location.getY() < y) {
							for (int path = (y-1); path >= new_location.getY(); path-- ) {
								if(forest[x][path] != '.') {
									check_in_path=true;
									Tuple victim_position =new Tuple(x, path);
									Tuple attacker_initial =new Tuple(x, y);
									Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
									if (forest[x][path] == 'j') {
										Random r = new Random();
										int a =r.nextInt(2 - 0) + 0;
										//attacker wins
										if(a==0) {
											//System.out.println("check if 1 Dog" );
											System.out.println("Dog from ("+ attacker_initial.getX() + ", " + 
										    attacker_initial.getY() +") attacks Jaguar at ("+  victim_position.getX() + ", " 
											+ victim_position.getY() +") and wins");
											System.out.println("Jaguar dies at (" + victim_position.getX() + ", " + victim_position.getY() +
											")");
											System.out.println(  "Dog moved from (" + attacker_initial.getX() + ", "
											+ attacker_initial.getY() + ") to (" + attacker_if_wins.getX() + ", "
											+ attacker_if_wins.getY() + ")" );

											result = "wins";
											
										}
										//attacker loses
										if(a==1) {
											//System.out.println("check if 2 Dog" );
											System.out.println( "Dog from ("+ attacker_initial.getX() + ", " + attacker_initial.getY() +") attacks Jaguar at ("+  victim_position.getX() + ", " 
													+ victim_position.getY() +") and loses");
											System.out.println("Dog dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
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
													deadAnimals.add("Dog");
												
											}
										}
										}
									}
									else if(forest[x][path] == 'k') {
										System.out.println("Dog from ("+ attacker_initial.getX() + ", " + 
											    attacker_initial.getY() +") attacks Kitten at ("+  victim_position.getX() + ", " 
												+ victim_position.getY() +") and loses");
										System.out.println("Dog dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
												")");
										//forest[attacker_if_wins.getX()][attacker_if_wins.getY()]='.';
										result = "loses";
										for(int start=0;start<l.size();start++) {
											if ((l.get(start).getX()==attacker_initial.getX()) 
													&& (l.get(start).getY()==attacker_initial.getY())) {
												//l.remove(start);
												l.get(start).update(-1, -1);
												dead.add(new Tuple (attacker_initial.getX(), attacker_initial.getY()));
												deadAnimals.add("Dog");
												
											
										}
									}
									}
									else{result=d.fight(victim_position, attacker_initial, attacker_if_wins,forest, l,dead, deadAnimals);}
									victim_X= x;
									victim_Y= path;
								}
						}
					}
				}

				if(y==new_location.getY()){
					if(new_location.getX() > x) {
						for (int path = (x+1); path <= new_location.getX(); path++ ) {
							if(forest[path][y] != '.') {
								check_in_path=true;
								Tuple victim_position =new Tuple(path, y);
						    	Tuple attacker_initial =new Tuple(x, y);
								Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
								if (forest[path][y] == 'j') {
									Random r = new Random();
									int a =r.nextInt(2 - 0) + 0;
									//attacker wins
									if(a==0) {
										//System.out.println("check if 1 Dog" );
										System.out.println("Dog from ("+ attacker_initial.getX() + ", " + 
									    attacker_initial.getY() +") attacks Jaguar at ("+  victim_position.getX() + ", " 
										+ victim_position.getY() +") and wins");
										System.out.println("Jaguar dies at (" + victim_position.getX() + ", " + victim_position.getY() +
										")");
										System.out.println(  "Dog moved from (" + attacker_initial.getX() + ", "
										+ attacker_initial.getY() + ") to (" + attacker_if_wins.getX() + ", "
										+ attacker_if_wins.getY() + ")" );

										result = "wins";
										
									}
									//attacker loses
									if(a==1) {
										//System.out.println("check if 2 Dog" );
										System.out.println( "Dog from ("+ attacker_initial.getX() + ", " + attacker_initial.getY() +") attacks Jaguar at ("+  victim_position.getX() + ", " 
												+ victim_position.getY() +") and loses");
										System.out.println("Dog dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
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
												deadAnimals.add("Dog");
											
										}
									}
									}
								}
								else if(forest[path][y] == 'k') {
									System.out.println("Dog from ("+ attacker_initial.getX() + ", " + 
										    attacker_initial.getY() +") attacks Kitten at ("+  victim_position.getX() + ", " 
											+ victim_position.getY() +") and loses");
									System.out.println("Dog dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
											")");
									//forest[attacker_if_wins.getX()][attacker_if_wins.getY()]='.';
									result = "loses";
									for(int start=0;start<l.size();start++) {
										if ((l.get(start).getX()==attacker_initial.getX()) 
												&& (l.get(start).getY()==attacker_initial.getY())) {
											//l.remove(start);
											l.get(start).update(-1, -1);
											dead.add(new Tuple (attacker_initial.getX(), attacker_initial.getY()));
											deadAnimals.add("Dog");
											
										
									}
								}
								}
								else{result=d.fight(victim_position, attacker_initial, attacker_if_wins,forest, l,dead, deadAnimals);}
								victim_X= path;
								victim_Y= y;
							}
						}
					}
					else if(new_location.getX() < x) {
							for (int path = (x-1); path >= new_location.getX(); path-- ) {
								if(forest[path][y] != '.') {
									check_in_path=true;
									Tuple victim_position =new Tuple(path, y);
							    	Tuple attacker_initial =new Tuple(x, y);
									Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
									if (forest[path][y] == 'j') {
										Random r = new Random();
										int a =r.nextInt(2 - 0) + 0;
										//attacker wins
										if(a==0) {
											//System.out.println("check if 1 Dog" );
											System.out.println("Dog from ("+ attacker_initial.getX() + ", " + 
										    attacker_initial.getY() +") attacks Jaguar at ("+  victim_position.getX() + ", " 
											+ victim_position.getY() +") and wins");
											System.out.println("Jaguar dies at (" + victim_position.getX() + ", " + victim_position.getY() +
											")");
											System.out.println(  "Dog moved from (" + attacker_initial.getX() + ", "
											+ attacker_initial.getY() + ") to (" + attacker_if_wins.getX() + ", "
											+ attacker_if_wins.getY() + ")" );

											result = "wins";
											
										}
										//attacker loses
										if(a==1) {
											//System.out.println("check if 2 Dog" );
											System.out.println( "Dog from ("+ attacker_initial.getX() + ", " + attacker_initial.getY() +") attacks Jaguar at ("+  victim_position.getX() + ", " 
													+ victim_position.getY() +") and loses");
											System.out.println("Dog dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
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
													deadAnimals.add("Dog");
												
											}
										}
										}
									}
									else if(forest[path][y] == 'k') {
										System.out.println("Dog from ("+ attacker_initial.getX() + ", " + 
											    attacker_initial.getY() +") attacks Kitten at ("+  victim_position.getX() + ", " 
												+ victim_position.getY() +") and loses");
										System.out.println("Dog dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
												")");
										//forest[attacker_if_wins.getX()][attacker_if_wins.getY()]='.';
										result = "loses";
										for(int start=0;start<l.size();start++) {
											if ((l.get(start).getX()==attacker_initial.getX()) 
													&& (l.get(start).getY()==attacker_initial.getY())) {
												//l.remove(start);
												l.get(start).update(-1, -1);
												dead.add(new Tuple (attacker_initial.getX(), attacker_initial.getY()));
												deadAnimals.add("Dog");
												
											
										}
									}
									}
									else{result=d.fight(victim_position, attacker_initial, attacker_if_wins,forest, l,dead, deadAnimals);}
									victim_X= path;
									victim_Y= y;
								}
						}
					}
				}
				if(check_in_path == false) {
					System.out.println("Dog moved from ("+ x +", "+ y +") to ("+ new_location.getX() +", "+
							new_location.getY() +")");
					forest[new_location.getX()][new_location.getY()] ='d';
					l.get(i).update(new_location.getX(), new_location.getY());
				}	
				else if(check_in_path == true) {
					if(result.equals("wins")) {
						forest[victim_X][victim_Y]='.';
						forest[new_location.getX()][new_location.getY()]='d';
					
						l.get(i).update(new_location.getX(), new_location.getY());
					}
				}
				forest[x][y] = '.';

			}
			if(animalLetter=='f' && precedence==6) {
				//forest[x][y]='.';
				Fox f = new Fox(x,y);
				Tuple new_location = f.move(f.getTuple(),forest);
				//l.get(i).update(new_location.getX(), new_location.getY());
				boolean check_in_path=false;
				int victim_X=0;
				int victim_Y=0;
				String result="";
				if(x==new_location.getX()){
					if(new_location.getY() > y) {
						for (int path = (y+1); path <= new_location.getY(); path++ ) {
							if(forest[x][path] != '.') {
								check_in_path=true;
								Tuple victim_position =new Tuple(x, path);
						    	Tuple attacker_initial =new Tuple(x, y);
								Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
if(forest[new_location.getX()][new_location.getY()] == 'i') {
									
									System.out.println("Fox from ("+ attacker_initial.getX() + ", " + 
										    attacker_initial.getY() +") attacks Dinosaur at ("+  victim_position.getX() + ", " 
											+ victim_position.getY() +") and loses");
									System.out.println("Fox dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
											")");
									result = "loses";
									for(int start=0;start<l.size();start++) {
										if ((l.get(start).getX()==attacker_initial.getX()) 
												&& (l.get(start).getY()==attacker_initial.getY())) {
											//l.remove(start);
											l.get(start).update(-1, -1);
											dead.add(new Tuple (attacker_initial.getX(), attacker_initial.getY()));
											deadAnimals.add("Fox");
											
										
									}
								}
								}
								else if (forest[x][path] == 'j') {
									Random r = new Random();
									int a =r.nextInt(2 - 0) + 0;
									//attacker wins
									if(a==0) {
										//System.out.println("check if 1 Dog" );
										System.out.println("Fox from ("+ attacker_initial.getX() + ", " + 
									    attacker_initial.getY() +") attacks Jaguar at ("+  victim_position.getX() + ", " 
										+ victim_position.getY() +") and wins");
										System.out.println("Jaguar dies at (" + victim_position.getX() + ", " + victim_position.getY() +
										")");
										System.out.println(  "Fox moved from (" + attacker_initial.getX() + ", "
										+ attacker_initial.getY() + ") to (" + attacker_if_wins.getX() + ", "
										+ attacker_if_wins.getY() + ")" );

										result = "wins";
										
									}
									//attacker loses
									if(a==1) {
										//System.out.println("check if 2 Dog" );
										System.out.println( "Fox from ("+ attacker_initial.getX() + ", " + attacker_initial.getY() +") attacks Jaguar at ("+  victim_position.getX() + ", " 
												+ victim_position.getY() +") and loses");
										System.out.println("Fox dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
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
												deadAnimals.add("Fox");
											
										}
									}
									}
								}
								else if(forest[x][path] == 'k') {
									System.out.println("Fox from ("+ attacker_initial.getX() + ", " + 
										    attacker_initial.getY() +") attacks Kitten at ("+  victim_position.getX() + ", " 
											+ victim_position.getY() +") and loses");
									System.out.println("Fox dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
											")");
									//forest[attacker_if_wins.getX()][attacker_if_wins.getY()]='.';
									result = "loses";
									for(int start=0;start<l.size();start++) {
										if ((l.get(start).getX()==attacker_initial.getX()) 
												&& (l.get(start).getY()==attacker_initial.getY())) {
											//l.remove(start);
											l.get(start).update(-1, -1);
											dead.add(new Tuple (attacker_initial.getX(), attacker_initial.getY()));
											deadAnimals.add("Fox");
											
										
									}
								}
								}
								else{result=f.fight(victim_position, attacker_initial, attacker_if_wins,forest, l,dead, deadAnimals);}
								victim_X= x;
								victim_Y= path;
							}
						}
					}
					else if(new_location.getY() < y) {
							for (int path = (y-1); path >= new_location.getY(); path-- ) {
								if(forest[x][path] != '.') {
									check_in_path=true;
									Tuple victim_position =new Tuple(x, path);
									Tuple attacker_initial =new Tuple(x, y);
									Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
									if (forest[x][path] == 'j') {
										Random r = new Random();
										int a =r.nextInt(2 - 0) + 0;
										//attacker wins
										if(a==0) {
											//System.out.println("check if 1 Dog" );
											System.out.println("Fox from ("+ attacker_initial.getX() + ", " + 
										    attacker_initial.getY() +") attacks Jaguar at ("+  victim_position.getX() + ", " 
											+ victim_position.getY() +") and wins");
											System.out.println("Jaguar dies at (" + victim_position.getX() + ", " + victim_position.getY() +
											")");
											System.out.println(  "Fox moved from (" + attacker_initial.getX() + ", "
											+ attacker_initial.getY() + ") to (" + attacker_if_wins.getX() + ", "
											+ attacker_if_wins.getY() + ")" );

											result = "wins";
											
										}
										//attacker loses
										if(a==1) {
											//System.out.println("check if 2 Dog" );
											System.out.println( "Fox from ("+ attacker_initial.getX() + ", " + attacker_initial.getY() +") attacks Jaguar at ("+  victim_position.getX() + ", " 
													+ victim_position.getY() +") and loses");
											System.out.println("Fox dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
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
													deadAnimals.add("Fox");
												
											}
										}
										}
									}
									else if(forest[x][path] == 'k') {
										System.out.println("Fox from ("+ attacker_initial.getX() + ", " + 
											    attacker_initial.getY() +") attacks Kitten at ("+  victim_position.getX() + ", " 
												+ victim_position.getY() +") and loses");
										System.out.println("Fox dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
												")");
										//forest[attacker_if_wins.getX()][attacker_if_wins.getY()]='.';
										result = "loses";
										for(int start=0;start<l.size();start++) {
											if ((l.get(start).getX()==attacker_initial.getX()) 
													&& (l.get(start).getY()==attacker_initial.getY())) {
												//l.remove(start);
												l.get(start).update(-1, -1);
												dead.add(new Tuple (attacker_initial.getX(), attacker_initial.getY()));
												deadAnimals.add("Fox");
												
											
										}
									}
									}
									else{result=f.fight(victim_position, attacker_initial, attacker_if_wins,forest, l,dead, deadAnimals);}
									victim_X= x;
									victim_Y= path;
								}
						}
					}
				}

				if(y==new_location.getY()){
					if(new_location.getX() > x) {
						for (int path = (x+1); path <= new_location.getX(); path++ ) {
							if(forest[path][y] != '.') {
								check_in_path=true;
								Tuple victim_position =new Tuple(path, y);
						    	Tuple attacker_initial =new Tuple(x, y);
								Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
								if (forest[path][y] == 'j') {
									Random r = new Random();
									int a =r.nextInt(2 - 0) + 0;
									//attacker wins
									if(a==0) {
										//System.out.println("check if 1 Dog" );
										System.out.println("Fox from ("+ attacker_initial.getX() + ", " + 
									    attacker_initial.getY() +") attacks Jaguar at ("+  victim_position.getX() + ", " 
										+ victim_position.getY() +") and wins");
										System.out.println("Jaguar dies at (" + victim_position.getX() + ", " + victim_position.getY() +
										")");
										System.out.println(  "Fox moved from (" + attacker_initial.getX() + ", "
										+ attacker_initial.getY() + ") to (" + attacker_if_wins.getX() + ", "
										+ attacker_if_wins.getY() + ")" );

										result = "wins";
										
									}
									//attacker loses
									if(a==1) {
										//System.out.println("check if 2 Dog" );
										System.out.println( "Fox from ("+ attacker_initial.getX() + ", " + attacker_initial.getY() +") attacks Jaguar at ("+  victim_position.getX() + ", " 
												+ victim_position.getY() +") and loses");
										System.out.println("Fox dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
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
												deadAnimals.add("Dog");
											
										}
									}
									}
								}
								else if(forest[path][y] == 'k') {
									System.out.println("Fox from ("+ attacker_initial.getX() + ", " + 
										    attacker_initial.getY() +") attacks Kitten at ("+  victim_position.getX() + ", " 
											+ victim_position.getY() +") and loses");
									System.out.println("Fox dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
											")");
									//forest[attacker_if_wins.getX()][attacker_if_wins.getY()]='.';
									result = "loses";
									for(int start=0;start<l.size();start++) {
										if ((l.get(start).getX()==attacker_initial.getX()) 
												&& (l.get(start).getY()==attacker_initial.getY())) {
											//l.remove(start);
											l.get(start).update(-1, -1);
											dead.add(new Tuple (attacker_initial.getX(), attacker_initial.getY()));
											deadAnimals.add("Fox");
											
										
									}
								}
								}
								else{result=f.fight(victim_position, attacker_initial, attacker_if_wins,forest, l,dead, deadAnimals);}
								victim_X= path;
								victim_Y= y;
							}
						}
					}
					else if(new_location.getX() < x) {
							for (int path = (x-1); path >= new_location.getX(); path-- ) {
								if(forest[path][y] != '.') {
									check_in_path=true;
									Tuple victim_position =new Tuple(path, y);
							    	Tuple attacker_initial =new Tuple(x, y);
									Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
									if (forest[path][y] == 'j') {
										Random r = new Random();
										int a =r.nextInt(2 - 0) + 0;
										//attacker wins
										if(a==0) {
											//System.out.println("check if 1 Dog" );
											System.out.println("Fox from ("+ attacker_initial.getX() + ", " + 
										    attacker_initial.getY() +") attacks Jaguar at ("+  victim_position.getX() + ", " 
											+ victim_position.getY() +") and wins");
											System.out.println("Jaguar dies at (" + victim_position.getX() + ", " + victim_position.getY() +
											")");
											System.out.println(  "Fox moved from (" + attacker_initial.getX() + ", "
											+ attacker_initial.getY() + ") to (" + attacker_if_wins.getX() + ", "
											+ attacker_if_wins.getY() + ")" );

											result = "wins";
											
										}
										//attacker loses
										if(a==1) {
											//System.out.println("check if 2 Dog" );
											System.out.println( "Fox from ("+ attacker_initial.getX() + ", " + attacker_initial.getY() +") attacks Jaguar at ("+  victim_position.getX() + ", " 
													+ victim_position.getY() +") and loses");
											System.out.println("Fox dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
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
													deadAnimals.add("Fox");
												
											}
										}
										}
									}
									else if(forest[path][y] == 'k') {
										System.out.println("Fox from ("+ attacker_initial.getX() + ", " + 
											    attacker_initial.getY() +") attacks Kitten at ("+  victim_position.getX() + ", " 
												+ victim_position.getY() +") and loses");
										System.out.println("Fox dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
												")");
										//forest[attacker_if_wins.getX()][attacker_if_wins.getY()]='.';
										result = "loses";
										for(int start=0;start<l.size();start++) {
											if ((l.get(start).getX()==attacker_initial.getX()) 
													&& (l.get(start).getY()==attacker_initial.getY())) {
												//l.remove(start);
												l.get(start).update(-1, -1);
												dead.add(new Tuple (attacker_initial.getX(), attacker_initial.getY()));
												deadAnimals.add("Fox");
												
											
										}
									}
									}
									else{result=f.fight(victim_position, attacker_initial, attacker_if_wins,forest, l,dead, deadAnimals);}
									victim_X= path;
									victim_Y= y;
								}
						}
					}
				}
				if(check_in_path == false) {
					System.out.println("Fox moved from ("+ x +", "+ y +") to ("+ new_location.getX() +", "+
							new_location.getY() +")");
					forest[new_location.getX()][new_location.getY()] ='f';
					l.get(i).update(new_location.getX(), new_location.getY());
				}	
				else if(check_in_path == true) {
					if(result.equals("wins")) {
						forest[victim_X][victim_Y]='.';
						forest[new_location.getX()][new_location.getY()]='f';
					
						l.get(i).update(new_location.getX(), new_location.getY());
					}
				}
				forest[x][y] = '.';

			}
			if(animalLetter=='w' && precedence==1) {


				//forest[x][y]='.';
				Wolf d = new Wolf(x,y);
				Tuple new_location = d.move(d.getTuple(),forest);
				//l.get(i).update(new_location.getX(), new_location.getY());
				boolean check_in_path=false;
				int victim_X=0;
				int victim_Y=0;
				String result="";
				if(x==new_location.getX()){
					if(new_location.getY() > y) {
						for (int path = (y+1); path <= new_location.getY(); path++ ) {
							if(forest[x][path] != '.') {
								check_in_path=true;
								Tuple victim_position =new Tuple(x, path);
						    	Tuple attacker_initial =new Tuple(x, y);
								Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
if(forest[new_location.getX()][new_location.getY()] == 'i') {
									
									System.out.println("Wolf from ("+ attacker_initial.getX() + ", " + 
										    attacker_initial.getY() +") attacks Dinosaur at ("+  victim_position.getX() + ", " 
											+ victim_position.getY() +") and loses");
									System.out.println("Wolf dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
											")");
									result = "loses";
									for(int start=0;start<l.size();start++) {
										if ((l.get(start).getX()==attacker_initial.getX()) 
												&& (l.get(start).getY()==attacker_initial.getY())) {
											//l.remove(start);
											l.get(start).update(-1, -1);
											dead.add(new Tuple (attacker_initial.getX(), attacker_initial.getY()));
											deadAnimals.add("Wolf");
											
										
									}
								}
								}
								else if (forest[x][path] == 'j') {
									Random r = new Random();
									int a =r.nextInt(2 - 0) + 0;
									//attacker wins
									if(a==0) {
										//System.out.println("check if 1 Dog" );
										System.out.println("Wolf from ("+ attacker_initial.getX() + ", " + 
									    attacker_initial.getY() +") attacks Jaguar at ("+  victim_position.getX() + ", " 
										+ victim_position.getY() +") and wins");
										System.out.println("Jaguar dies at (" + victim_position.getX() + ", " + victim_position.getY() +
										")");
										System.out.println(  "Wolf moved from (" + attacker_initial.getX() + ", "
										+ attacker_initial.getY() + ") to (" + attacker_if_wins.getX() + ", "
										+ attacker_if_wins.getY() + ")" );

										result = "wins";
										
									}
									//attacker loses
									if(a==1) {
										//System.out.println("check if 2 Dog" );
										System.out.println( "Wolf from ("+ attacker_initial.getX() + ", " + attacker_initial.getY() +") attacks Jaguar at ("+  victim_position.getX() + ", " 
												+ victim_position.getY() +") and loses");
										System.out.println("Wolf dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
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
												deadAnimals.add("Wolf");
											
										}
									}
									}
								}
								else if(forest[x][path] == 'k') {
									System.out.println("Wolf from ("+ attacker_initial.getX() + ", " + 
										    attacker_initial.getY() +") attacks Kitten at ("+  victim_position.getX() + ", " 
											+ victim_position.getY() +") and loses");
									System.out.println("Wolf dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
											")");
									//forest[attacker_if_wins.getX()][attacker_if_wins.getY()]='.';
									result = "loses";
									for(int start=0;start<l.size();start++) {
										if ((l.get(start).getX()==attacker_initial.getX()) 
												&& (l.get(start).getY()==attacker_initial.getY())) {
											//l.remove(start);
											l.get(start).update(-1, -1);
											dead.add(new Tuple (attacker_initial.getX(), attacker_initial.getY()));
											deadAnimals.add("Wolf");
											
										
									}
								}
								}
								else{result=d.fight(victim_position, attacker_initial, attacker_if_wins,forest, l,dead, deadAnimals);}
								victim_X= x;
								victim_Y= path;
							}
						}
					}
					else if(new_location.getY() < y) {
							for (int path = (y-1); path >= new_location.getY(); path-- ) {
								if(forest[x][path] != '.') {
									check_in_path=true;
									Tuple victim_position =new Tuple(x, path);
									Tuple attacker_initial =new Tuple(x, y);
									Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
									if (forest[x][path] == 'j') {
										Random r = new Random();
										int a =r.nextInt(2 - 0) + 0;
										//attacker wins
										if(a==0) {
											//System.out.println("check if 1 Dog" );
											System.out.println("Wolf from ("+ attacker_initial.getX() + ", " + 
										    attacker_initial.getY() +") attacks Jaguar at ("+  victim_position.getX() + ", " 
											+ victim_position.getY() +") and wins");
											System.out.println("Jaguar dies at (" + victim_position.getX() + ", " + victim_position.getY() +
											")");
											System.out.println(  "Wolf moved from (" + attacker_initial.getX() + ", "
											+ attacker_initial.getY() + ") to (" + attacker_if_wins.getX() + ", "
											+ attacker_if_wins.getY() + ")" );

											result = "wins";
											
										}
										//attacker loses
										if(a==1) {
											//System.out.println("check if 2 Dog" );
											System.out.println( "Wolf from ("+ attacker_initial.getX() + ", " + attacker_initial.getY() +") attacks Jaguar at ("+  victim_position.getX() + ", " 
													+ victim_position.getY() +") and loses");
											System.out.println("Wolf dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
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
													deadAnimals.add("Wolf");
												
											}
										}
										}
									}
									else if(forest[x][path] == 'k') {
										System.out.println("Wolf from ("+ attacker_initial.getX() + ", " + 
											    attacker_initial.getY() +") attacks Kitten at ("+  victim_position.getX() + ", " 
												+ victim_position.getY() +") and loses");
										System.out.println("Wolf dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
												")");
										//forest[attacker_if_wins.getX()][attacker_if_wins.getY()]='.';
										result = "loses";
										for(int start=0;start<l.size();start++) {
											if ((l.get(start).getX()==attacker_initial.getX()) 
													&& (l.get(start).getY()==attacker_initial.getY())) {
												//l.remove(start);
												l.get(start).update(-1, -1);
												dead.add(new Tuple (attacker_initial.getX(), attacker_initial.getY()));
												deadAnimals.add("Wolf");
												
											
										}
									}
									}
									else{result=d.fight(victim_position, attacker_initial, attacker_if_wins,forest, l,dead, deadAnimals);}
									victim_X= x;
									victim_Y= path;
								}
						}
					}
				}

				if(y==new_location.getY()){
					if(new_location.getX() > x) {
						for (int path = (x+1); path <= new_location.getX(); path++ ) {
							if(forest[path][y] != '.') {
								check_in_path=true;
								Tuple victim_position =new Tuple(path, y);
						    	Tuple attacker_initial =new Tuple(x, y);
								Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
								if (forest[path][y] == 'j') {
									Random r = new Random();
									int a =r.nextInt(2 - 0) + 0;
									//attacker wins
									if(a==0) {
										//System.out.println("check if 1 Dog" );
										System.out.println("Wolf from ("+ attacker_initial.getX() + ", " + 
									    attacker_initial.getY() +") attacks Jaguar at ("+  victim_position.getX() + ", " 
										+ victim_position.getY() +") and wins");
										System.out.println("Jaguar dies at (" + victim_position.getX() + ", " + victim_position.getY() +
										")");
										System.out.println(  "Wolf moved from (" + attacker_initial.getX() + ", "
										+ attacker_initial.getY() + ") to (" + attacker_if_wins.getX() + ", "
										+ attacker_if_wins.getY() + ")" );

										result = "wins";
										
									}
									//attacker loses
									if(a==1) {
										//System.out.println("check if 2 Dog" );
										System.out.println( "Wolf from ("+ attacker_initial.getX() + ", " + attacker_initial.getY() +") attacks Jaguar at ("+  victim_position.getX() + ", " 
												+ victim_position.getY() +") and loses");
										System.out.println("Wolf dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
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
												deadAnimals.add("Wolf");
											
										}
									}
									}
								}
								else if(forest[path][y] == 'k') {
									System.out.println("Wolf from ("+ attacker_initial.getX() + ", " + 
										    attacker_initial.getY() +") attacks Kitten at ("+  victim_position.getX() + ", " 
											+ victim_position.getY() +") and loses");
									System.out.println("Wolf dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
											")");
									//forest[attacker_if_wins.getX()][attacker_if_wins.getY()]='.';
									result = "loses";
									for(int start=0;start<l.size();start++) {
										if ((l.get(start).getX()==attacker_initial.getX()) 
												&& (l.get(start).getY()==attacker_initial.getY())) {
											//l.remove(start);
											l.get(start).update(-1, -1);
											dead.add(new Tuple (attacker_initial.getX(), attacker_initial.getY()));
											deadAnimals.add("Wolf");
											
										
									}
								}
								}
								else{result=d.fight(victim_position, attacker_initial, attacker_if_wins,forest, l,dead, deadAnimals);}
								victim_X= path;
								victim_Y= y;
							}
						}
					}
					else if(new_location.getX() < x) {
							for (int path = (x-1); path >= new_location.getX(); path-- ) {
								if(forest[path][y] != '.') {
									check_in_path=true;
									Tuple victim_position =new Tuple(path, y);
							    	Tuple attacker_initial =new Tuple(x, y);
									Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
									if (forest[path][y] == 'j') {
										Random r = new Random();
										int a =r.nextInt(2 - 0) + 0;
										//attacker wins
										if(a==0) {
											//System.out.println("check if 1 Dog" );
											System.out.println("Wolf from ("+ attacker_initial.getX() + ", " + 
										    attacker_initial.getY() +") attacks Jaguar at ("+  victim_position.getX() + ", " 
											+ victim_position.getY() +") and wins");
											System.out.println("Jaguar dies at (" + victim_position.getX() + ", " + victim_position.getY() +
											")");
											System.out.println(  "Wolf moved from (" + attacker_initial.getX() + ", "
											+ attacker_initial.getY() + ") to (" + attacker_if_wins.getX() + ", "
											+ attacker_if_wins.getY() + ")" );

											result = "wins";
											
										}
										//attacker loses
										if(a==1) {
											//System.out.println("check if 2 Dog" );
											System.out.println( "Wolf from ("+ attacker_initial.getX() + ", " + attacker_initial.getY() +") attacks Jaguar at ("+  victim_position.getX() + ", " 
													+ victim_position.getY() +") and loses");
											System.out.println("Wolf dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
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
													deadAnimals.add("Wolf");
												
											}
										}
										}
									}
									else if(forest[path][y] == 'k') {
										System.out.println("Wolf from ("+ attacker_initial.getX() + ", " + 
											    attacker_initial.getY() +") attacks Kitten at ("+  victim_position.getX() + ", " 
												+ victim_position.getY() +") and loses");
										System.out.println("Wolf dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
												")");
										//forest[attacker_if_wins.getX()][attacker_if_wins.getY()]='.';
										result = "loses";
										for(int start=0;start<l.size();start++) {
											if ((l.get(start).getX()==attacker_initial.getX()) 
													&& (l.get(start).getY()==attacker_initial.getY())) {
												//l.remove(start);
												l.get(start).update(-1, -1);
												dead.add(new Tuple (attacker_initial.getX(), attacker_initial.getY()));
												deadAnimals.add("Wolf");
												
											
										}
									}
									}
									else{result=d.fight(victim_position, attacker_initial, attacker_if_wins,forest, l,dead, deadAnimals);}
									victim_X= path;
									victim_Y= y;
								}
						}
					}
				}
				if(check_in_path == false) {
					System.out.println("Wolf moved from ("+ x +", "+ y +") to ("+ new_location.getX() +", "+
							new_location.getY() +")");
					forest[new_location.getX()][new_location.getY()] ='w';
					l.get(i).update(new_location.getX(), new_location.getY());
				}	
				else if(check_in_path == true) {
					if(result.equals("wins")) {
						forest[victim_X][victim_Y]='.';
						forest[new_location.getX()][new_location.getY()]='w';
					
						l.get(i).update(new_location.getX(), new_location.getY());
					}
				}
				forest[x][y] = '.';

			}
			if(animalLetter=='c' && precedence==9) {
				Cat c = new Cat(x,y);
				Tuple new_location = c.move(c.getTuple(),forest);
				//l.get(i).update(new_location.getX(), new_location.getY());
				boolean check_in_path=false;
				int victim_X=0;
				int victim_Y=0;
				String result="";
				if(forest[new_location.getX()][new_location.getY()] != '.') {
					check_in_path=true;
					Tuple victim_position =new Tuple(new_location.getX(),new_location.getY());
			    	Tuple attacker_initial =new Tuple(x, y);
					Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
					if(forest[new_location.getX()][new_location.getY()] == 'i') {
						
						System.out.println("Cat from ("+ attacker_initial.getX() + ", " + 
							    attacker_initial.getY() +") attacks Dinosaur at ("+  victim_position.getX() + ", " 
								+ victim_position.getY() +") and loses");
						System.out.println("Cat dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
								")");
						result = "loses";
						for(int start=0;start<l.size();start++) {
							if ((l.get(start).getX()==attacker_initial.getX()) 
									&& (l.get(start).getY()==attacker_initial.getY())) {
								//l.remove(start);
								l.get(start).update(-1, -1);
								dead.add(new Tuple (attacker_initial.getX(), attacker_initial.getY()));
								deadAnimals.add("Cat");
								
							
						}
					}
					}
					else if(forest[new_location.getX()][new_location.getY()] == 'j') {
						
						System.out.println("Cat from ("+ attacker_initial.getX() + ", " + 
							    attacker_initial.getY() +") attacks Jaguar at ("+  victim_position.getX() + ", " 
								+ victim_position.getY() +") and loses");
						System.out.println("Cat dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
								")");
						result = "loses";
						for(int start=0;start<l.size();start++) {
							if ((l.get(start).getX()==attacker_initial.getX()) 
									&& (l.get(start).getY()==attacker_initial.getY())) {
								//l.remove(start);
								l.get(start).update(-1, -1);
								dead.add(new Tuple (attacker_initial.getX(), attacker_initial.getY()));
								deadAnimals.add("Cat");
								
							
						}
					}
					}
					else if(forest[new_location.getX()][new_location.getY()] == 'k') {
						System.out.println("Cat from ("+ attacker_initial.getX() + ", " + 
							    attacker_initial.getY() +") attacks Kitten at ("+  victim_position.getX() + ", " 
								+ victim_position.getY() +") and loses");
						System.out.println("Cat dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
								")");
						//forest[attacker_if_wins.getX()][attacker_if_wins.getY()]='.';
						result = "loses";
						for(int start=0;start<l.size();start++) {
							if ((l.get(start).getX()==attacker_initial.getX()) 
									&& (l.get(start).getY()==attacker_initial.getY())) {
								//l.remove(start);
								l.get(start).update(-1, -1);
								dead.add(new Tuple (attacker_initial.getX(), attacker_initial.getY()));
								deadAnimals.add("Cat");
								
							
						}
					}
					}
					else{result=c.fight(victim_position, attacker_initial, attacker_if_wins,forest, l,dead,deadAnimals);
					}
				}
				//System.out.println("forest check 413" + check_in_path);
				//System.out.println("forest check 414" + result);

				if(check_in_path == false) {
					System.out.println("Cat moved from ("+ x +", "+ y +") to ("+ new_location.getX() +", "+
							new_location.getY() +")");
					forest[new_location.getX()][new_location.getY()] ='c';
					l.get(i).update(new_location.getX(), new_location.getY());
				}	
				else if(check_in_path == true) {
					if(result.equals("wins")) {
	
						forest[new_location.getX()][new_location.getY()]='c';
						//System.out.println("check forest 422");
						l.get(i).update(new_location.getX(), new_location.getY());
					}
				}
				forest[x][y] = '.';
			}
			if(animalLetter=='l' && precedence==3) {
				Lion lion = new Lion(x,y);
				Tuple new_location = lion.move(lion.getTuple(),forest);
				//l.get(i).update(new_location.getX(), new_location.getY());
				boolean check_in_path=false;
				int victim_X=0;
				int victim_Y=0;
				String result="";
				if(forest[new_location.getX()][new_location.getY()] != '.') {
					check_in_path=true;
					Tuple victim_position =new Tuple(new_location.getX(),new_location.getY());
			    	Tuple attacker_initial =new Tuple(x, y);
					Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
					if(forest[new_location.getX()][new_location.getY()] == 'i') {
						
						System.out.println("Lion from ("+ attacker_initial.getX() + ", " + 
							    attacker_initial.getY() +") attacks Dinosaur at ("+  victim_position.getX() + ", " 
								+ victim_position.getY() +") and loses");
						System.out.println("Lion dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
								")");
						result = "loses";
						for(int start=0;start<l.size();start++) {
							if ((l.get(start).getX()==attacker_initial.getX()) 
									&& (l.get(start).getY()==attacker_initial.getY())) {
								//l.remove(start);
								l.get(start).update(-1, -1);
								dead.add(new Tuple (attacker_initial.getX(), attacker_initial.getY()));
								deadAnimals.add("Lion");
								
							
						}
					}
					}
					else if(forest[new_location.getX()][new_location.getY()] == 'k') {
						System.out.println("Lion from ("+ attacker_initial.getX() + ", " + 
							    attacker_initial.getY() +") attacks Kitten at ("+  victim_position.getX() + ", " 
								+ victim_position.getY() +") and loses");
						System.out.println("Lion dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
								")");
						//forest[attacker_if_wins.getX()][attacker_if_wins.getY()]='.';
						result = "loses";
						for(int start=0;start<l.size();start++) {
							if ((l.get(start).getX()==attacker_initial.getX()) 
									&& (l.get(start).getY()==attacker_initial.getY())) {
								//l.remove(start);
								l.get(start).update(-1, -1);
								dead.add(new Tuple (attacker_initial.getX(), attacker_initial.getY()));
								deadAnimals.add("Lion");
								
							
						}
					}
					}
					
					else if(forest[new_location.getX()][new_location.getY()] == 'j') {
						
						System.out.println("Lion from ("+ attacker_initial.getX() + ", " + 
							    attacker_initial.getY() +") attacks Jaguar at ("+  victim_position.getX() + ", " 
								+ victim_position.getY() +") and loses");
						System.out.println("Lion dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
								")");
						result = "loses";
						for(int start=0;start<l.size();start++) {
							if ((l.get(start).getX()==attacker_initial.getX()) 
									&& (l.get(start).getY()==attacker_initial.getY())) {
								//l.remove(start);
								l.get(start).update(-1, -1);
								dead.add(new Tuple (attacker_initial.getX(), attacker_initial.getY()));
								deadAnimals.add("Lion");
								
							
						}
					}
					}
					else{result=lion.fight(victim_position, attacker_initial, attacker_if_wins,forest, l,dead,deadAnimals);
					}
				}

				if(check_in_path == false) {
					System.out.println("Lion moved from ("+ x +", "+ y +") to ("+ new_location.getX() +", "+
							new_location.getY() +")");
					forest[new_location.getX()][new_location.getY()] ='l';
					l.get(i).update(new_location.getX(), new_location.getY());
				}	
				else if(check_in_path == true) {
					if(result.equals("wins")) {
	
						forest[new_location.getX()][new_location.getY()]='l';
					
						l.get(i).update(new_location.getX(), new_location.getY());
					}
				}
				forest[x][y] = '.';
			}
	
			if(animalLetter=='u' && precedence==2) {
				Turtle u = new Turtle(x,y);
				Tuple new_location = u.move(u.getTuple(),forest);
				forest[x][y] = '.';
				//l.get(i).update(new_location.getX(), new_location.getY());
				boolean check_in_path=false;
				int victim_X=0;
				int victim_Y=0;
				String result="";
				if(forest[new_location.getX()][new_location.getY()] != '.') {
					check_in_path=true;
					Tuple victim_position =new Tuple(new_location.getX(),new_location.getY());
			    	Tuple attacker_initial =new Tuple(x, y);
					Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
					if(forest[new_location.getX()][new_location.getY()] == 'i') {
						
						System.out.println("Turtle from ("+ attacker_initial.getX() + ", " + 
							    attacker_initial.getY() +") attacks Dinosaur at ("+  victim_position.getX() + ", " 
								+ victim_position.getY() +") and loses");
						System.out.println("Turtle dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
								")");
						result = "loses";
						for(int start=0;start<l.size();start++) {
							if ((l.get(start).getX()==attacker_initial.getX()) 
									&& (l.get(start).getY()==attacker_initial.getY())) {
								//l.remove(start);
								l.get(start).update(-1, -1);
								dead.add(new Tuple (attacker_initial.getX(), attacker_initial.getY()));
								deadAnimals.add("Turtle");
								
							
						}
					}
					}
					else if(forest[new_location.getX()][new_location.getY()] == 'k') {
						System.out.println("Turtle from ("+ attacker_initial.getX() + ", " + 
							    attacker_initial.getY() +") attacks Kitten at ("+  victim_position.getX() + ", " 
								+ victim_position.getY() +") and loses");
						System.out.println("Turtle dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
								")");
						//forest[attacker_if_wins.getX()][attacker_if_wins.getY()]='.';
						result = "loses";
						for(int start=0;start<l.size();start++) {
							if ((l.get(start).getX()==attacker_initial.getX()) 
									&& (l.get(start).getY()==attacker_initial.getY())) {
								//l.remove(start);
								l.get(start).update(-1, -1);
								dead.add(new Tuple (attacker_initial.getX(), attacker_initial.getY()));
								deadAnimals.add("Turtle");
								
							
						}
					}
					}
					else if(forest[new_location.getX()][new_location.getY()] == 'j') {
							Random r = new Random();
						int a =r.nextInt(2 - 0) + 0;
						//attacker wins
						
						if(a==0) {
							//System.out.println("check if 1 Dog" );
							System.out.println("Turtle from ("+ attacker_initial.getX() + ", " + 
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
							System.out.println("Turtle from ("+ attacker_initial.getX() + ", " + attacker_initial.getY() +") attacks Jaguar at ("+  victim_position.getX() + ", " 
									+ victim_position.getY() +") and loses");
							System.out.println("Turtle dies at (" + attacker_initial.getX() + ", " + attacker_initial.getY() +
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
									deadAnimals.add("Turtle");
								
							}
						}
						}
						
					}
					else
					{result=u.fight(victim_position, attacker_initial, attacker_if_wins,forest, l,dead,deadAnimals);
					}
				}

				if(check_in_path == false) {
					if(new_location.getX()==x && new_location.getY()==y) {
						System.out.println("Turtle stayed in (" + x +", " + y +")");					
					}
						else{
						System.out.println("Turtle moved from ("+ x +", "+ y +") to ("+ new_location.getX() +", "+
								new_location.getY() +")");
						}
					forest[new_location.getX()][new_location.getY()] ='u';

					l.get(i).update(new_location.getX(), new_location.getY());
				}	
				else if(check_in_path == true) {
					if(result.equals("wins")) {
	
						forest[new_location.getX()][new_location.getY()]='u';
					
						l.get(i).update(new_location.getX(), new_location.getY());
					}
				}
				//forest[x][y] = '.';
			}
			if(animalLetter=='i' && precedence==8) {
				//forest[x][y]='.';
				Dinosaur d = new Dinosaur(x,y);
				Tuple new_location = d.move(d.getTuple(),forest);
				//l.get(i).update(new_location.getX(), new_location.getY());
				boolean check_in_path=false;
				int victim_X=0;
				int victim_Y=0;
				String result="";
				if(x==new_location.getX()){
					if(new_location.getY() > y) {
						for (int path = (y+1); path <= new_location.getY(); path++ ) {
							if(forest[x][path] != '.') {
								check_in_path=true;
								Tuple victim_position =new Tuple(x, path);
						    	Tuple attacker_initial =new Tuple(x, y);
								Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
								result=d.fight(victim_position, attacker_initial, attacker_if_wins,forest, l,dead,deadAnimals);
								victim_X= x;
								victim_Y= path;
							}
						}
					}
					else if(new_location.getY() < y) {
							for (int path = (y-1); path >= new_location.getY(); path-- ) {
								if(forest[x][path] != '.') {
									check_in_path=true;
									Tuple victim_position =new Tuple(x, path);
									Tuple attacker_initial =new Tuple(x, y);
									Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
									result=d.fight(victim_position, attacker_initial, attacker_if_wins,forest, l,dead, deadAnimals);
									victim_X= x;
									victim_Y= path;
								}
						}
					}
				}

				if(y==new_location.getY()){
					if(new_location.getX() > x) {
						for (int path = (x+1); path <= new_location.getX(); path++ ) {
							if(forest[path][y] != '.') {
								check_in_path=true;
								Tuple victim_position =new Tuple(path, y);
						    	Tuple attacker_initial =new Tuple(x, y);
								Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
								result=d.fight(victim_position, attacker_initial, attacker_if_wins,forest,l,dead,deadAnimals);
								victim_X= path;
								victim_Y= y;
							}
						}
					}
					else if(new_location.getX() < x) {
							for (int path = (x-1); path >= new_location.getX(); path-- ) {
								if(forest[path][y] != '.') {
									check_in_path=true;
									Tuple victim_position =new Tuple(path, y);
							    	Tuple attacker_initial =new Tuple(x, y);
									Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
									result=d.fight(victim_position, attacker_initial, attacker_if_wins,forest,l,dead,deadAnimals);
									victim_X= path;
									victim_Y= y;
								}
						}
					}
				}
				if(check_in_path == false) {
					System.out.println("Dinosaur moved from ("+ x +", "+ y +") to ("+ new_location.getX() +", "+
							new_location.getY() +")");
					forest[new_location.getX()][new_location.getY()] ='i';
					l.get(i).update(new_location.getX(), new_location.getY());
				}	
				else if(check_in_path == true) {
					if(result.equals("wins")) {
						forest[victim_X][victim_Y]='.';
						forest[new_location.getX()][new_location.getY()]='i';
					
						l.get(i).update(new_location.getX(), new_location.getY());
					}
				}
				forest[x][y] = '.';
			}
			if(animalLetter=='j' && precedence==5) {
				Jaguar j = new Jaguar(x,y);
				Tuple new_location = j.move(j.getTuple(),forest);
				//l.get(i).update(new_location.getX(), new_location.getY());
				boolean check_in_path=false;
				int victim_X=0;
				int victim_Y=0;
				String result="";
				if(forest[new_location.getX()][new_location.getY()] != '.') {
					check_in_path=true;
					Tuple victim_position =new Tuple(new_location.getX(),new_location.getY());
			    	Tuple attacker_initial =new Tuple(x, y);
					Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
					result=j.fight(victim_position, attacker_initial, attacker_if_wins,forest, l,dead,deadAnimals);
					
				}
				//System.out.println("forest check 413" + check_in_path);
				//System.out.println("forest check 414" + result);

				if(check_in_path == false) {
					System.out.println("Jaguar moved from ("+ x +", "+ y +") to ("+ new_location.getX() +", "+
							new_location.getY() +")");
					forest[new_location.getX()][new_location.getY()] ='j';
					l.get(i).update(new_location.getX(), new_location.getY());
				}	
				else if(check_in_path == true) {
					if(result.equals("wins")) {
	
						forest[new_location.getX()][new_location.getY()]='j';
						//System.out.println("check forest 422");
						l.get(i).update(new_location.getX(), new_location.getY());
					}
				}
				forest[x][y] = '.';
			}
			if(animalLetter=='k' && precedence==4) {
				Kitten k = new Kitten(x,y);
				Tuple new_location = k.move(k.getTuple(),forest);
				//l.get(i).update(new_location.getX(), new_location.getY());
				boolean check_in_path=false;
				int victim_X=0;
				int victim_Y=0;
				String result="";
				if(new_location.getX() != x || new_location.getY() != y ) {
				if(forest[new_location.getX()][new_location.getY()] != '.' ) {
					check_in_path=true;
					Tuple victim_position =new Tuple(new_location.getX(),new_location.getY());
			    	Tuple attacker_initial =new Tuple(x, y);
					Tuple attacker_if_wins =new Tuple(new_location.getX(), new_location.getY());
					result=k.fight(victim_position, attacker_initial, attacker_if_wins,forest, l,dead,deadAnimals);
					
				}}

				if(check_in_path == false) {
					if(new_location.getX()==x && new_location.getY()==y) {
						System.out.println("Kitten stayed in (" + x +", " + y +")");					
					}
						else{
						System.out.println("Kitten moved from ("+ x +", "+ y +") to ("+ new_location.getX() +", "+
								new_location.getY() +")");
						forest[x][y]='.';
						}
					forest[new_location.getX()][new_location.getY()] ='k';

					l.get(i).update(new_location.getX(), new_location.getY());
				}	
				else if(check_in_path == true) {
					if(result.equals("wins")) {
	
						forest[new_location.getX()][new_location.getY()]='k';
						forest[x][y]='.';
						l.get(i).update(new_location.getX(), new_location.getY());
					}
					else {
						forest[x][y]='.';
					}
				}
				//forest[x][y] = '.';
			}
		}
		}
	}
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j<15; j++) {
				System.out.print(forest[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
	}
	/**
	 * This is the main function where the program starts to execute.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] forest = new char[15][15];
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j<15; j++) {
				forest[i][j]='.';
			}
		}
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j<15; j++) {
				System.out.print(forest[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("1.	Dog (d)");
		System.out.println("2.	Fox (f)");
		System.out.println("3. 	Wolf (w)");
		System.out.println("4. 	Jaguar (j)");
		System.out.println("5. 	Lion (l)");
		System.out.println("6. 	Cat (c)");
		System.out.println("7. 	Kitten (k)");
		System.out.println("8. 	Dinosaur (i)");
		System.out.println("9. 	Turtle (u)");
		System.out.println("What would you like to add to the Forest?");
		
		System.out.print("Please enter your choice (1-9, or 0 to finish the animal input):");
		
		Scanner in = new Scanner(System.in);
		
		int c = in.nextInt(); 	
		ArrayList <Tuple>  l =  new ArrayList <Tuple> ();
		ArrayList <Tuple>  dead =  new ArrayList <Tuple> ();
		ArrayList <String>  deadAnimals =  new ArrayList <String> ();
		char symbol='.';
		while(c!=0) {
		//if (c>8 || c<0) {
				//c = in.nextInt();
				//continue;
			//}
			int a = numberGenerator();
			int b = numberGenerator();
			//System.out.println(a + " " + b);
			//boolean mycheck = check(a,b,l);
			//System.out.println(mycheck);
			while(check(a,b, l)) {
				//System.out.print("Hey");
				a = numberGenerator();
				b = numberGenerator();
			}
			l.add(new Tuple (a, b));
			//l.get(0).printTuple();

			animalAdded(c,a,b);
			//printForest(c,a,b,forest);
			switch (c) {
			case 1: symbol='d'; break;
			case 2: symbol='f'; break;
			case 3: symbol='w'; break;
			case 4: symbol='j'; break;
			case 5: symbol='l'; break;
			case 6: symbol='c'; break;
			case 7: symbol='k'; break;
			case 8: symbol='i'; break;
			case 9: symbol='u'; break;
			}
			forest[a][b]=symbol;
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j<15; j++) {
					System.out.print(forest[i][j]);
				}
				System.out.println();
			}
			
			System.out.println();
			System.out.println("1.	Dog (d)");
			System.out.println("2.	Fox (f)");
			System.out.println("3. 	Wolf (w)");
			System.out.println("4. 	Jaguar (j)");
			System.out.println("5. 	Lion (l)");
			System.out.println("6. 	Cat (c)");
			System.out.println("7. 	Kitten (k)");
			System.out.println("8. 	Dinosaur (i)");
			System.out.println("9. 	Turtle (u)");
			System.out.println("What would you like to add to the Forest?");
			System.out.print("Please enter your choice (1-9, or 0 to finish the animal input):");
			c = in.nextInt();
		}
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j<15; j++) {
				System.out.print(forest[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		//System.out.println("Press enter to iterate, type 'print' to print the Forest or 'exit' to quit:");
		String s=in.nextLine(); 
		s = "initial";
		while(!s.equals("exit")) {
		if (s.equals("print")){
			printCurrentForest(forest,dead, deadAnimals);
		}
		else if (s.isEmpty()){
			iterate(l, forest,dead, deadAnimals);
		}
		System.out.print("Press enter to iterate, type 'print' to print the Forest or 'exit' to quit:");
		
		s = in.nextLine();
	}
		in.close();
		System.exit(0);
}
}


