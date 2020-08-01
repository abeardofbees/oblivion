package oblivion;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CheckIn {


	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		Random dice = new Random();
		int roll = 0;
	

		boolean running = true;
		boolean token = true;
		boolean businessdecision = false;

		GAME:
			while (running == true) {
				
				
				openCrawl(in);
				
				Player main = new Player();
				
				System.out.println("\n	" + main.getName() + ", huh? Well, howdy. Name's Poppy.");
				in.nextLine();
				System.out.println("	Come on and hop in. It's just down the road.\n");	
				in.nextLine();
				
				while (token == true) {
				
					System.out.println("1 - ride shotgun");
					System.out.println("2 - rude gesture\n");
				
					int a = in.nextInt();
				
					if (a == 1) {
						
						System.out.println("\nYou enter Poppy's pickup truck.");
						
						in.nextLine();
						
						token = false;
					}
					
					else if (a == 2) {
						
			//ENDGAME 1: DIE IN THE EVERGLADES
						
						noStart(in);						
						
						running = false;
						addBeat(30);
						System.exit(0);

					}
					
					else {
						System.out.println("You got two choices, kid. Make one.");
					}
				}
				
				System.out.println("\nDown the road, you see the neon glow of a motel sign in the fading daylight.\n\n");
				in.nextLine();
				System.out.println("POPPY:\n	There she is, partner. Blushin' like a bride on 'er weddin' night.\n\n");
				
				titles(in);
			
				
				System.out.println("\n\nPoppy stops in front of the check-in office.");
				in.nextLine();
				System.out.println("Looks like it's time to mosey.\n");
				in.nextLine();
				
				System.out.println("POPPY:\n	This'll be you. Terry will get you set up.");
				System.out.println("	Trust your gut, partner. Might save your ass sometime.\n");
				in.nextLine();
				System.out.println("You get out of the car and lock eyes with Poppy.");
				in.nextLine();
				
				while (token == false) {
				
					System.out.println("\n1 - express gratitude\n2 - hop back inside\n");
				
					int b = in.nextInt();
				
					if (b == 2) {
						
			//ENDGAME 2: RIDE OFF WITH POPPY
						
						poppyEnd(main, in);
						
						
						addBeat(30);
						System.exit(0);		
						
					}
					
					else if (b == 1) {
			
						System.out.println("\nYou give Poppy the proverbial tip of the hat.");
						in.nextLine();
						System.out.println("He returns a nod. You close the car door and head to the office.\n\n");
						
						officeGraphic();
						
						System.out.println("Inside the office, a tall, lanky man in a Pantera T-shirt rests behind the check-in counter.");
						in.nextLine();
						System.out.println("He's watching a Marlins game on mute. He doesn't pay you any mind.\n");
						in.nextLine();
						
						boolean confirm = false;
						
						int c = 0;
						
						while (confirm == false) {
						
							System.out.println("1 - ask about a room");
							System.out.println("2 - ask about the game\n");
						
							c = in.nextInt();
							
							if (c == 1) {
								
								System.out.println("\n" + main.getName().toUpperCase() + ":");
								System.out.println("	Poppy said I could get a room.\n");
								in.nextLine();
								System.out.println("TERRY:");
								System.out.println("	40 for the night. We're vacating tomorrow.");
								System.out.println("	You're welcome to stay until 11. After that you're trespassin'.\n");
								in.nextLine();
								
								confirm = true;
							}
							else if (c == 2) {
								
								System.out.println("\n" + main.getName().toUpperCase() + ":");
								System.out.println("	I thought baseball was done.\n");
								in.nextLine();
								System.out.println("TERRY:");
								System.out.println("	I thought assholes couldn't talk.");
								System.out.println("	The fuck do you want?\n");
								in.nextLine();
								System.out.println("\n" + main.getName().toUpperCase() + ":");
								System.out.println("	Poppy said I could get a room.\n");
								in.nextLine();
								System.out.println("TERRY:");
								System.out.println("	80 bucks. If you're not out by 11 tomorrow, well, check the sign outside.");
								in.nextLine();
								
								confirm = true;
							}
							else {
								System.out.println("That ain't an option.");
							}
						}
						
						boolean checkin = false;
						
						while (checkin == false) {
							
							System.out.println("1 - pay up");
							System.out.println("2 - leave");
							System.out.println("3 - check wallet");
							System.out.println("4 - check inventory\n");
						
							int d = in.nextInt();
							
							System.out.println();
							
							if (d == 1 && c == 1) {
								
								System.out.println("You pay the man 40 dollars. He hands you the key to room 101.\n");
								in.nextLine();
								
								main.payOut(40, main.canIAfford(40));
								main.addItem("Room key");
								
								checkin = true;
							}
							else if (d == 1 && c == 2) {
								
								System.out.println("You pay the man 80 dollars. He throws down the key to room 101.\n");
								in.nextLine();
								
								main.payOut(80, main.canIAfford(80));
								main.addItem("Room key");
								
								checkin = true;
								
							}
							else if (d == 2) {
								
								System.out.println(main.getName().toUpperCase() + ":");
								System.out.println("	Nevermind.\n");
								in.nextLine();
								System.out.println("TERRY:\n");
								System.out.println("	Whatever, pal.");
								in.nextLine();
								
								checkin = true;
							}
							else if (d == 3) {
								
								main.checkWallet();
								
							}
							else if (d == 4) {
								
								main.checkInventory();
								
							}
							else {
								System.out.println("That ain't an option.");
							}
						}
						
						token = true;
						
						
						
					}
					
					else {
						
						System.out.println("You gonna pick one for real now?\n");
						
					}
				}
				
				System.out.println("\nHe turns back to the Marlins game. You leave.\n");
				
				in.nextLine();
				
		//BRANCH PATH - NO CHECK-IN
				
				if (main.onHand("Room key") == false) {
					
					System.out.println("Welp, you're effectively homeless for the evening.");
					in.nextLine();
					System.out.println("You could always try making friends.\n");
					in.nextLine();
					
					System.out.println("You can hear someone setting off mortars behind the motel.");
					in.nextLine();
					System.out.println("You could also go back into the office and get a room.\n\n");
					in.nextLine();
					
					boolean crossroad = false;
					
					while (crossroad == false) {
						
						System.out.println("1 - check behind motel");
						System.out.println("2 - go back into office");
						System.out.println("3 - check wallet");
						System.out.println("4 - check inventory\n");
						
						int d = in.nextInt();
						
						if (d == 1) {
							
							//GATOR BOYS BACHELOR FEST
							
						}
						else if (d == 2) {
							
							//
							
						}
						else if (d == 3) {
							
							main.checkWallet();
							
						}
						else if (d == 4) {
							
							main.checkInventory();
							
						}
						else {
							
							System.out.println("Quit dickin' around.");
							
						}
					}
					
					
					}
				
			
				else	
					
		//BRANCH PATH - CHECKED IN
					
				System.out.println("You spot your room across the parking lot.\n");
				
				roomGraphic();
				
				addBeat(2);
					
					while (token == true) {
					
						
						
						System.out.println("1 - go to room");
						System.out.println("2 - check wallet");
						System.out.println("3 - check inventory\n");
					
						int c = in.nextInt();
					
						System.out.println();
					
						if (c == 1) {
						
							token = false;
						
						}
						else if (c == 2) {
							
							main.checkWallet();
							addBeat(3);
							
						}
						else if (c == 3) {
							
							main.removeItem(2);
							main.checkInventory();
							addBeat(3);
							System.out.println("It seems you're missing your room key...\n");
							in.nextLine();
							System.out.println("TANNY:");
							System.out.println("	Hey! You! With the fuckin' hair!\n");
							in.nextLine();
							System.out.println("You turn around to see a man clad in a tan leather vest and Balenciaga swim trunks.");
							in.nextLine();
							System.out.println("He's holding up your room key and smells like curdled Drakkar Noir.\n");
							in.nextLine();
							System.out.println("TANNY:");
							System.out.println("	Name's Tanny, Tanny Business, local entrepreneuer. I think you dropped this.\n");
							in.nextLine();
							System.out.println("You reach out to grab it. He pulls it back and begins to laugh, which turns into a sickly hacking.\n");
							in.nextLine();
							System.out.println("TANNY:");
							System.out.println("	Not so fast, Dale Gordon Jr. What's it to me that you get this back?");
							System.out.println("	The name is Tanny BUSINESS, not Tanny Tand-outs.\n");
							in.nextLine();
							System.out.println("You're too tired to fight and would probably get stabbed for the effort.\n");
							
							boolean tanny = false;
							
							while (tanny == false) {
							
								System.out.println("1 - offer cash");
								System.out.println("2 - offer favor\n");
								
								int e = in.nextInt();
								addBeat(1);
								
								if (e == 1 && main.canIAfford(25)== true) {
									
									System.out.println("You offer him 25 dollars.\n");
									in.nextLine();
									System.out.println("TANNY:");
									System.out.println("	Hot damn, that's a 2 porno parlay!\n");
									in.nextLine();
									System.out.println("You pay the man 25 dollars and get the room key back.");
									System.out.println("He walks away laughing and hacking. You might want to sanitize the key.");
									in.nextLine();
									main.payOut(25, true);
									main.addItem("Room key");
									
									tanny = true;
									
								}
								else if (e == 1 && main.canIAfford(25) == false) {
									
									System.out.println("\nYou don't have enough to bribe him sufficiently. Maybe offer a favor.");
									
								}
								else if (e == 2) {
									
									System.out.println("\nYou offer a favor.\n");
									in.nextLine();
									System.out.println("TANNY:");
									System.out.println("	Heh, you're lucky I'm outta my cock pills. My cousin Darril won't leave my friggin' bathroom.");
									System.out.println("	You can have the key but you gotta take Darril.\n");
									in.nextLine();
									System.out.println("You're not in a position to argue. Tanny leaves with the key and returns with his cousin, Darril.");
									in.nextLine();
									System.out.println("Darril is a massive man holding a massive bag of Sun Chips. He doesn't make eye contact.");
									in.nextLine();
									System.out.println("\nTANNY:");
									System.out.println("	Have fun, you two.");
									in.nextLine();
									System.out.println("\nTanny hands the room key to Darril and coughs out a laugh.\n");
									in.nextLine();
									
									tanny = true;
									businessdecision = true;
									main.addItem("Room key");
									
								}
								else {
									System.out.println("One or the other, Dale Gordons!");
								}
							}
							token = false;
						}
						
						else {
							
							System.out.println("\nMake a choice, " + main.getName() + ".");
							
						}
					
					}
					
					if (main.onHand("Room key") == true && businessdecision == false) {
						
						System.out.println("You head to your room.\n");
						
						doorGraphic();
						
						System.out.println("You pop in the keycard and enter.");
						
						addBeat(6);
						
					}
					
					else if (main.onHand("Room key") == true && businessdecision == true) {
						
						System.out.println("You follow Darril to your room.\n\n");

						doorGraphic();
						
						System.out.println("DARRIL:\n");
						System.out.println("	That bathroom Darril's bathroom.");
						System.out.println("	I better not catch you in there.");	
						in.nextLine();
						
						addBeat(6);
						
					}
					
					
				System.out.println("\nYou enter Room 101.");
				addBeat(2);
				System.out.println("It's sparsely decorated. There's a queen-sized bed, a small nightstand with a phone, and a dresser with an old CRT television on it.");
				
				if (businessdecision == true) {
					System.out.println("\nWithout a word, Darril grabs the phone and enters the bathroom.");
				}
				
				in.nextLine();
				
				boolean waitingRoom = false;
				
				while (waitingRoom == false) {
					
					System.out.println("\n1 - watch some TV\n2 - go to bed\n3 - check the nightstand drawer");
					
					int f = in.nextInt();
					
					if (f == 1 && businessdecision == false) {
						
						televisionRulesTheNation(in);
						
						System.out.println("BRRRRRRRRRRRRING");
						addBeat(3);
						System.out.println("BRRRRRRRRRRRRING");
						addBeat(5);
						System.out.println("Gonna answer that? (Press enter to answer.)");
						in.nextLine();
						
						scamTango(main, dice, in);
						
						//SCAMMER CALL
						
					}
					else if (f == 1 && businessdecision == true) {
						
						televisionRulesTheNation(in);
						
						System.out.println("Knock knock");
						addBeat(7);
						System.out.println("Knock knock knock");
						addBeat(3);
						System.out.println("Knock");
						addBeat(1);
						System.out.println("Knock");
						addBeat(1);
						System.out.println("Knock");
						addBeat(1);
						System.out.println("Knock");
						addBeat(1);
						System.out.println("Knock");
						addBeat(1);
						System.out.println("Knock");
						addBeat(1);
						System.out.println("Knock");
						addBeat(1);
						System.out.println("Knock");
						addBeat(1);
						System.out.println("Knock");
						addBeat(3);
						
						System.out.println("Who the hell is it? (Press enter to answer.)");
						in.nextLine();
												
						//REDEMPTION BRAWL
						
					}
					else if (f == 2) {
						
						//HOWLIN JENKINS DREAM
						
					}
					else if (f == 3) {
						
						//FIND BIBLE
						
						main.addItem("Gideon bible");
						
					}
					else {
						
						System.out.println("Better do something with your time.");
						
					}
					
					
				}
				
				
				

				
				
				
				
				
				
				
				running = false;
			}
	
		}
	
		public static void addBeat(int a) {
			
			try {
			    Thread.sleep(a * 400);
			} catch (InterruptedException ie) {
			    Thread.currentThread().interrupt();
			}
			
		}
		
		public static void openCrawl(Scanner in) {
			
			System.out.println("\n\n	It seems like your luck's run dry, partner.");
			in.nextLine();
			System.out.println("	Your car is kaputt - and in south Florida, of all places.");
			in.nextLine();
			System.out.println("	Not many places for a fella like yourself to cool your heels.");
			in.nextLine();
			System.out.println("	'Specially not in the middle of a dang pandemic.");
			in.nextLine();
			System.out.println("\n	There's a bit of silver curlin' round this dark cloud, amigo.");
			in.nextLine();
			System.out.println("	Right up the road is a place for folks like us to rest and reside.");
			in.nextLine();
			System.out.println("	Sadly, they're vacatin' the joint tomorrow, but they ain't known for turning folks away.");
			in.nextLine();
			System.out.println("\n	Say, what's your name, anyhow?\n");
			in.nextLine();
			
		}
		
		public static void noStart(Scanner a) {
			
			System.out.println("\nYou flip Poppy off.");
			a.nextLine();
			System.out.println("He gives you a look. It breaks into a smile and he shakes his head.");
			a.nextLine();
			System.out.println("\n	Suit yourself, partner. Happy trails.");
			a.nextLine();
			System.out.println("\nPoppy drives off into the the sunset. You are stuck on a shitty stretch of road.");
			a.nextLine();
			System.out.println("You're too exhausted to hoof it to somewhere safe.");
			a.nextLine();
			System.out.println("If you didn't want to go to the motel, why are you even playing this?");
			addBeat(5);
			System.out.println("\n\nFuck it. You got ate by a gator.");
			System.out.println("You don't even get a game over screen.");
			
		}
		
		public static void titles(Scanner a) {
			
			System.out.println("	  	 _________________________________ ");
			addBeat(1);
			System.out.println("		| _______________________________ |");
			addBeat(1);
			System.out.println("		|| _    _   __   _____ ____ _ 	 ||");
			addBeat(1);
			System.out.println("		|| |\\  /|  /  \\    |   |    |    ||");
			addBeat(1);
			System.out.println("		|| | \\/ | |    |   |   |___ |	 ||");
			addBeat(1);
			System.out.println("		|| |    | |    |   |   |    |	 ||");
			addBeat(1);
			System.out.println("		|| |    |  \\__/    |   |___ |___ ||");
			addBeat(1);
			System.out.println("		|| ============================= ||");
			addBeat(1);
			System.out.println("		||__________ o B L I V I O N ____||");
			addBeat(1);
			System.out.println("		|_________________________________|");
			addBeat(1);
			System.out.println("		   ||=========================||   ");
			addBeat(1);
			System.out.println("		   ||V|A|C|A|N|C|Y|_|D|A|Y|_|_|| ");
			addBeat(1);
			System.out.println("		   ||_|S|Q|U|A|T|T|R|S|_|_|_|_||");
			addBeat(1);
			System.out.println("		   ||W|I|L|L|_|_|B|_|_|S|H|O|T||");
			addBeat(1);
			System.out.println("		   ||=========================||");
			addBeat(1);
			System.out.println("		   ||                         ||");
			addBeat(1);
			System.out.println("		   ||                         ||");
			addBeat(2);
			System.out.println("\n		 VACANCY DAY AT THE MOTEL OBLIVION\n		-----------------------------------");
			addBeat(1);
			System.out.println("			a text adventure");
			addBeat(1);
			System.out.println("	  	     based on the writing of\n");
			addBeat(1);
			System.out.println("			maxwell donaldson");
			addBeat(1);
			System.out.println("			 steven grise");
			addBeat(1);
			System.out.println("			  nick ray mccann");
			addBeat(1);
			System.out.println("			   ryan mcdaid");
			addBeat(1);
			System.out.println("			    joshua mozes");
			addBeat(1);
			System.out.println("			     adam pruss");
			addBeat(1);
			System.out.println("			      mae ryan\n\n");
			System.out.println("Hit enter to play.");
			a.nextLine();
						
		}
		
		public static void poppyEnd(Player main, Scanner a) {
			
			System.out.println("\n" + main.getName().toUpperCase() + ":");
			System.out.println("\n	I can't do it, Poppy.");
			System.out.println("	I owe you one. Let me pay you back.");
			a.nextLine();
			System.out.println("\nPoppy's eyes wrinkle into a smile.\n");
			a.nextLine();
			System.out.println("POPPY:\n	Have it your way, partner.");
			a.nextLine();
			System.out.println("\nThe engine starts. Poppy shifts the truck into drive.\n");
			a.nextLine();
			System.out.println("You peel off into the sunset, towards what will probably be a fine adventure for a spin-off or expansion.\n\n");
			addBeat(3);
			
			System.out.println("	      | |                 ||                  | |");
			addBeat(1);
			System.out.println("	    __|_|_________________||__________________|_|__");
			addBeat(1);
			System.out.println("	   /_________________   (_____)    _______________ \\ ");
			addBeat(1);
			System.out.println("	  |_   ___   _   __  _  ___    _____   _____ ___   _|");
			addBeat(1);
			System.out.println("	 [__] / __| /_\\ |  \\/  | __|  / _ \\ \\ / / __| _ \\ [__]");
			addBeat(1);
			System.out.println("	 |  || (_ |/ _ \\| |\\/| | _|  | (_) \\ V /| _||   / |  |");
			addBeat(1);
			System.out.println("	 |__|_\\___/_/ \\_\\_|  |_|___|__\\___/ \\_/ |___|_|_\\ |__|");
			addBeat(1);
			System.out.println("	 [ _]_____________________________________________[__]");
			addBeat(1);
			System.out.println("	 |                    | FLORIDA |                    |");
			addBeat(1);
			System.out.println("	 |____________________|_053_GB2_|____________________|"); 
			addBeat(1);
			System.out.println("	  |~~~~\\((_))_____________________________((_))/~~~~|");
			addBeat(1);
			System.out.println("	  | ~~~~|                                     |~~~~ |");
			addBeat(1);
			System.out.println("	  |  ~~~|                                     |~~~  |");
			addBeat(1);
			System.out.println("	  |_____|                                     |_____|");
			
		}
		
		public static void officeGraphic() {
			
			System.out.println("	___|_____|_____|_____|___");
			addBeat(1);
			System.out.println("	iiiiiiiiiiiiiiiiiiiiiiiii");
			addBeat(1);
			System.out.println("                             ");
			addBeat(1);
			System.out.println("	_________      ______    ");
			addBeat(1);
			System.out.println("	XXXXXXXXX| |O|| ____ |   ");
			addBeat(1);
			System.out.println("	XXXXXXXXX| |F|||    ||   ");
			addBeat(1);
			System.out.println("	XXXXXXXXX| |F|||====||   ");
			addBeat(1);
			System.out.println("	XXXXXXXXX| |I|||    ||   ");
			addBeat(1);
			System.out.println("	========== |C|||====}|   ");
			addBeat(1);
			System.out.println("	           |E|||____||   "); 
			addBeat(1);
			System.out.println("	              |      |   ");
			addBeat(1);
			System.out.println("	______________|______|___\n\n");
			addBeat(1);
			
		}
		
		public static void roomGraphic() {
			
			System.out.println(" 	\\_______\\_______| ______/__"); 
			addBeat(1);
			System.out.println(" 	 __________  _____ ________"); 
			addBeat(1);
			System.out.println(" 	 |==|==|==|  |   | |__|__| "); 
			addBeat(1);
			System.out.println(" 	 |__|__|__|  | * | |__|__|_");   
			addBeat(1);
			System.out.println(" 	IIIIIIIIIIIIIIIIIIIIIIIIIII"); 
			addBeat(1);
			System.out.println(" 	| | | | | | ||| ||| | | | |"); 
			addBeat(1);
			System.out.println(" 	TTTTTTTTTTTTTTTTTTTTTTTTTTT"); 
			addBeat(1);
			System.out.println(" 	___________________________"); 
			addBeat(1);
			System.out.println(" 	 __________  _____ ________"); 
			addBeat(1);
			System.out.println(" 	 |__|__|__|  |   | |__|__|_"); 
			addBeat(1);
			System.out.println(" 	 |__|__|__|  | * | |__|__|_");   
			addBeat(1);
			System.out.println(" 	  Y O U R  > |   |         "); 
			addBeat(1);
			System.out.println(" 	___R O O M___|___|_________"); 
			addBeat(1);
			System.out.println("	______/_________________\\__");     
			addBeat(1);
			System.out.println("	  /      /      /      /   "); 
			addBeat(1);
			System.out.println("	 /      /      /      /    \n\n");
			addBeat(1);
			
		}
		
		public static void doorGraphic() {
			

			System.out.println("     	 ___________________");
			addBeat(1);
			System.out.println("	[___________________]");
			addBeat(1);
			System.out.println(" 	 ||   __     __   ||");
			addBeat(1);
			System.out.println("	 ||  |  |   |  |  ||	");
			addBeat(1);
			System.out.println("	 ||  |  |   |  |  ||	");
			addBeat(1);
			System.out.println("	 ||  |__[101]__|  || ");
			addBeat(1);
			System.out.println("	 ||   __  o  __   ||");
			addBeat(1);
			System.out.println("	 ||  |  |   |  |  || ");
			addBeat(1);
			System.out.println("	 ||  |  |   |  |  || ");
			addBeat(1);
			System.out.println("	 ||  |  |   |  |  ||");
			addBeat(1);
			System.out.println("	 ||  |  |   | ____||");
			addBeat(1);
			System.out.println("	 ||  |  |   | |==|||    ");
			addBeat(1);
			System.out.println("    	 ||  |        |  |||\n\n");
			addBeat(1);
			
		}
		
		public static void churchGraphic() {
			
			addBeat(1);
			System.out.println("     R E D E M P T I O N          /     ///| |\\\\\\   ");
			addBeat(1);
			System.out.println("      __ _M_E_G_A_C_H_U_R_C_H___ /     ///|| ||\\\\\\  ");
			addBeat(1);
			System.out.println("     /  /  /  /  /  /  /  /  /  /     ///|_   _|\\\\\\");
			addBeat(1);
			System.out.println("       /  /  /  /  /  /  /  /  /     ///|||| ||||\\\\\\");
			addBeat(1);
			System.out.println("      /  /  /  /  /  /  /  /  /     ///||||| |||||\\\\");
			addBeat(1);
			System.out.println("     ________________________/     ///|||||| ||||||\\");
			addBeat(1);
			System.out.println("     _______________________ |____///|||||||_|||||||");
			addBeat(1);
			System.out.println("     C|H|R|I|S|T|_|I|S|_|_|_||======================");
			addBeat(1);
			System.out.println("     _|_|_|_|T|H|E|_|C|U|R|E||o   o    o   |+|   o");
			addBeat(1);
			System.out.println("     _|_|_|_|_|_|_|_|_|_|_|_||=============! !======");
			addBeat(1);
			System.out.println("     J|B|J|_|L|I|V|E|_|4|/|7||___________||_M_||____");
			addBeat(1);
			System.out.println("     ________________________|           //   \\\\");
			addBeat(1);
			System.out.println("     ||                   ||            //     \\\\");
			addBeat(1);
			System.out.println("     ||                   ||           //       \\\\");
			addBeat(1);
		}
		
		
		public void poppyRidesAgain() {
			
			//ADVENTURE WITH POPPY
			//ENDGAME
			
		}
		
		
		
		public void mortarBoys() {
			
		}
		
		public boolean russianRoulette(Random n, int a) {
			
			int chamber = n.nextInt(6);	
		
			if (a == chamber) {
				return true;
				}
				else
				return false;	
	
		}
		
		public static void war(Random a) {
			
			String[] deck = {"empty", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
			int[] value = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
			
			String yourcard = deck[a.nextInt(13)];
			String hiscard = deck[a.nextInt(13)];
			
			System.out.println("Your card: " + yourcard + "/nHis card: " + hiscard);
					
		}
		
		public static void televisionRulesTheNation(Scanner a) {
			
			System.out.println("Press enter to turn on the TV.\n");
			a.nextLine();
			
			System.out.println("        ____________________");
			addBeat(1);
	        System.out.println("       | ================== |"); 
	        addBeat(1);
	        System.out.println("       ||                  ||");  
	        addBeat(1);
	        System.out.println("       ||  AMERICA'S       ||"); 
	        addBeat(1);
	        System.out.println("       ||       NEWSROOM   ||");
	        addBeat(1);
	        System.out.println("       ||  -------------   ||");
	        addBeat(1);
	        System.out.println("       ||           with   ||");
	        addBeat(1);
	        System.out.println("       ||     CHUCK TAGGER ||");
	        addBeat(1);
	        System.out.println("       |_==================_|\n\n");
			
	        addBeat(3);
	        
	        System.out.println("TV:\n");
	        System.out.println("	We are back in America's Newsroom, Chuck Tagger here reporting live from the ONN's Virus Command Center.");
	        System.out.println("	Stay tuned for breaking news from Ol' Nebraska about the virus response.\n");
	        a.nextLine();
	        System.out.println("	In the meantime, we have expert Jordan Sugarman on what to expect in the coming weeks as the country-\n");
	        addBeat(7);
			System.out.println("Click.");
			a.nextLine();
	    	System.out.println("\nThis seems better:\nA one-armed man with a braided goatee and an iguana on his shoulder is kneeling over a gator.");
	    	a.nextLine();
	    	System.out.println("It quickly cuts to a reality show confessional. His name is D-Ruck.\n");
	    	a.nextLine();
	    	System.out.println("D-RUCK:");
	    	System.out.println("	Gator boys don't play when it come to these scaly wenches.");
	    	a.nextLine();
	    	System.out.println("	I knew I was gonna have to call Francisco to come by with the bear mace.");
	    	a.nextLine();
	    	System.out.println("\nThe frame cuts to D-Ruck driving an ATV on a highway; he's got a headset on to call this Francisco.\n");
	    	a.nextLine();
	    	System.out.println("D-RUCK:");
	    	System.out.println("	Yo Frisco, we got a Green Gibson down at the Shaw Gardens Park and Sip, we still got that bear juice?\n");
	    	a.nextLine();
	    	System.out.println("Francisco is in the confessional booth now. He has more teeth than his friend.\n");
	    	a.nextLine();
	    	System.out.println("FRANCISCO:");
	    	System.out.println("	I was very nervous when Darius called me about the bear juice.");
	    	a.nextLine();
	    	System.out.println("	I had not spoken to him about it but I had usen the juice on the wild hog that attacked my picnic.\n");
	    	a.nextLine();
	    	System.out.println("Back to D-Ruck in the ATV. He will not be pleased.\n");
	    	a.nextLine();
	    	System.out.println("D-RUCK:");
	    	System.out.println("	Yo, we got that bear juice or what?");
	    	a.nextLine();
	    	System.out.println("\nMusic swells dramatically in the background as they cut to commercial.\n\n");
	    	
		}
		
		public static void scamTango(Player play, Random dice, Scanner in) {
			
			
			
		}
		
	}


