package blackjack_haofu;

import java.util.*;

public class Blackjack 
{
	public static void main(String[] args) throws InterruptedException 
	{
		//initialize variables
		Scanner myInput = new Scanner (System.in);
		int numOfPlayers = 0;
		String [] names = new String[4];
		int menuChoice = 0;
		String cardChoice = "";
		int i = 0;//number of cards the player has
		int c = 0;//represents the index of the card being drawn from the cards array
		
		int player0Total = 0;
		int player1Total = 0;
		int player2Total = 0;
		int player3Total = 0;
		
		//the mathematical maximum for each player to hit is 11
		int [] player0Cards = new int[11];
		int [] player1Cards = new int[11];
		int [] player2Cards = new int[11];
		int [] player3Cards = new int[11];
		String [] player0Suits = new String[11];
		String [] player1Suits = new String[11];
		String [] player2Suits = new String[11];
		String [] player3Suits = new String[11];
		
		int [] cards = {1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
		
		String club = "\u2663";
		String spades = "\u2660";
		String diamond = "\u2666";
		String heart = "\u2665";
		String [] suits = {club,spades,diamond,heart,club,spades,diamond,heart,club,spades,diamond,heart,club,spades,diamond,heart,club,spades,diamond,
				heart,club,spades,diamond,heart,club,spades,diamond,heart,club,spades,diamond,heart,club,spades,diamond,heart,club,spades,diamond,heart,
				club,spades,diamond,heart,club,spades,diamond,heart,club,spades,diamond,heart,};
		
		names[0] = "Dealer";
		
		//print welcome
		slowPrint("Welcome to Blackjack");
		
		//ask and collect number of players
		Thread.sleep(300);
		slowPrint("\nPlease enter the number of people playing (up to 3): ");
		numOfPlayers = collectInt();
		while (numOfPlayers<1 || numOfPlayers>3)//ask user to re-enter when it's invalid
		{
			slowPrint("Please enter number from 1 to 3");
			numOfPlayers = collectInt();
		}
		
		//ask and collect player(s) name
		slowPrint("Please enter the name(s): ");
		names[1] = myInput.next();
		if (numOfPlayers>1)
		{
			names[2] = myInput.next();
		}
		if (numOfPlayers>2)
		{
			names[3] = myInput.next();
		}
		
		
		while (true)
		{
			showMenu();
			//collect player’s choice
			slowPrint("\nPlease enter your choice: ");
			menuChoice = collectInt();
			while (menuChoice<1 || menuChoice>3)//ask user to re-enter when it's invalid
			{
				slowPrint("\nPlease enter number from 1 to 3");
				menuChoice = collectInt();
			}
			
			switch (menuChoice)
			{
			//new game
			case 1:
				i=0;
				c=0;
				//shuffle and deal cards
				shuffle(cards, suits);
				//for loop to deal cards
				for (int temp=0; temp<2; temp++)
				{
					player0Cards[i] = cards[c];
					player0Suits[i] = suits[c];
					c = c+1;
					player1Cards[i] = cards[c];
					player1Suits[i] = suits[c];
					c = c+1;
					if (numOfPlayers>1)
					{
						player2Cards[i] = cards[c];
						player2Suits[i] = suits[c];
						c = c+1;
					}
					if (numOfPlayers>2)
					{
						player3Cards[i] = cards[c];
						player3Suits[i] = suits[c];
						c = c+1;
					}
					i = i+1;
				}//end for loop
				
				//display cards
				Thread.sleep(300);
				slowPrint("\nHere are your cards:\n");
				displayDealerCards(player0Cards, player0Suits);
				displayCards(names[1], player1Cards, player1Suits, i);
				if (numOfPlayers>1)
				{
					displayCards(names[2], player2Cards, player2Suits, i);
				}
				if (numOfPlayers>2)
				{
					displayCards(names[3], player3Cards, player3Suits, i);
				}
				
				
				//player1's turn
				i=2;
				while(true)
				{
					//ask the first player hit or stand and collect the choice
					Thread.sleep(500);
					slowPrint("\n\n"+names[1]+ ", hit or stand? ");
					cardChoice = collectHitOrStand();
					//if hit, draw another card and display cards
					if (cardChoice.equals("hit"))
					{
						player1Cards[i] = cards[c];
						player1Suits[i] = suits[c];
						i = i+1;
						c = c+1;
						System.out.println();
						Thread.sleep(300);
						displayDealerCards(player0Cards, player0Suits);
						Thread.sleep(300);
						displayCards(names[1], player1Cards, player1Suits, i);
						if(checkIfBust(player1Cards)==true)
						{
							break;
						}
					}
					//if stand, break
					if (cardChoice.equals("stand"))
					{
						break;
					}
				}//end while
				
				//player2's turn
				//display player2's cards
				if(numOfPlayers>1)
				{
					i=2;
					Thread.sleep(500);
					System.out.println("----------------------------------");
					Thread.sleep(300);
					displayDealerCards(player0Cards, player0Suits);
					Thread.sleep(300);
					displayCards(names[2], player2Cards, player2Suits, i);
				}
				//hit or stand
				while(numOfPlayers>1)
				{
					//ask the first player hit or stand and collect
					Thread.sleep(500); 
					slowPrint("\n\n"+names[2]+ ", hit or stand? ");
					cardChoice = collectHitOrStand();
					//if hit, draw another card and display cards
					if (cardChoice.equals("hit"))
					{
						player2Cards[i] = cards[c];
						player2Suits[i] = suits[c];
						i = i+1;
						c = c+1;
						System.out.println();
						Thread.sleep(300);
						displayDealerCards(player0Cards, player0Suits);
						Thread.sleep(300);
						displayCards(names[2], player2Cards, player2Suits, i);
						if(checkIfBust(player2Cards)==true)
						{
							break;
						}
					}
					//if stand, break
					if (cardChoice.equals("stand"))
					{
						break;
					}
				}//end while
				
				//player3's turn
				if(numOfPlayers>2)
				{
					i=2;
					Thread.sleep(500);
					System.out.println("----------------------------------");
					Thread.sleep(300);
					displayDealerCards(player0Cards, player0Suits);
					Thread.sleep(300);
					displayCards(names[3], player3Cards, player3Suits, i);
				}
				while(numOfPlayers>2)
				{
					//ask the first player hit or stand and collect
					slowPrint("\n\n"+names[3]+ ", hit or stand? ");
					cardChoice = collectHitOrStand();
					//if hit, draw another card and display cards
					if (cardChoice.equals("hit"))
					{
						player3Cards[i] = cards[c];
						player3Suits[i] = suits[c];
						i = i+1;
						c = c+1;
						System.out.println();
						Thread.sleep(300);
						displayDealerCards(player0Cards, player0Suits);
						Thread.sleep(300);
						displayCards(names[3], player3Cards, player3Suits, i);
						if(checkIfBust(player3Cards)==true)
						{
							break;
						}
					}
					//if stand, break
					if (cardChoice.equals("stand"))
					{
						break;
					}
				}//end while
				
				//Dealer's turn
				i=2;
				Thread.sleep(500);
				System.out.println("----------------------------------");
				Thread.sleep(300);
				slowPrint("My turn!\n");
				//display dealer's cards and each player's total
				Thread.sleep(500);
				displayCards(names[0], player0Cards, player0Suits, i);
				slowPrint("\n"+names[1] + ": " + calculateTotal(player1Cards));
				if(numOfPlayers>1)
				{
					slowPrint("\n"+names[2] + ": " + calculateTotal(player2Cards));
				}
				if(numOfPlayers>2)
				{
					slowPrint("\n"+names[3] + ": " + calculateTotal(player3Cards));
				}
				//dealer's hit or stand algorithm
				player0Total = calculateTotal(player0Cards);
				while(player0Total<17)//dealer has to hit when the toal value is under 17
				{
					Thread.sleep(1000);
					slowPrint("\nhit");
					player0Cards[i] = cards[c];//draw a card
					player0Suits[i] = suits[c];
					i = i+1;
					c = c+1;
					Thread.sleep(500);
					System.out.println();
					displayCards(names[0], player0Cards, player0Suits, i);//display dealer's cards
					if(checkIfBust(player0Cards)==true)//if dealer bust, then break
					{
						break;
					}
					//display player1's total
					slowPrint("\n"+names[1] + ": " + calculateTotal(player1Cards));
					//display player2's total
					if(numOfPlayers>1)
					{
						slowPrint("\n"+names[2] + ": " + calculateTotal(player2Cards));
					}
					//display player3's total
					if(numOfPlayers>2)
					{
						slowPrint("\n"+names[3] + ": " + calculateTotal(player3Cards));
					}
					player0Total = calculateTotal(player0Cards);//update dealer's total
				}
				if (player0Total>=17)
				{
					Thread.sleep(1500);
					slowPrint("\nstand");
				}
				
				
				//Calculate win or lose and display results
				player0Total = calculateTotal(player0Cards);
				player1Total = calculateTotal(player1Cards);
				if(numOfPlayers>1)
				{
					player2Total = calculateTotal(player2Cards);
				}
				if(numOfPlayers>2)
				{
					player3Total = calculateTotal(player3Cards);
				}
				
				Thread.sleep(1000);
				slowPrint("\n\nHere are the results: ");
				Thread.sleep(500);
				
				//calculate player1
				if (player0Total>player1Total)
				{
					slowPrint("\n"+names[1] + ", you loser!");
				}
				else if (player0Total==0 && player1Total==0)
				{
					slowPrint("\n"+names[1] + ", you loser!");
				}
				else if (player0Total<player1Total)
				{
					slowPrint("\n"+names[1] + ", congrats, you won!");
				}
				else
				{
					slowPrint("\n"+names[1] + ", it's a tie...");
				}
				
				//calculate player2
				if(numOfPlayers>1)
				{
					Thread.sleep(300);
					if (player0Total>player2Total)
					{
						slowPrint("\n"+names[2] + ", you loser!");
					}
					else if (player0Total==0 && player2Total==0)
					{
						slowPrint("\n"+names[2] + ", you loser!");
					}
					else if (player0Total<player2Total)
					{
						slowPrint("\n"+names[2] + ", congrats, you won!");
					}
					else
					{
						slowPrint("\n"+names[2] + ", it's a tie...");
					}
				}
				
				//calculate player3
				if(numOfPlayers>2)
				{
					Thread.sleep(300);
					if (player0Total>player3Total)
					{
						slowPrint("\n"+names[3] + ", you loser!");
					}
					else if (player0Total==0 && player3Total==0)
					{
						slowPrint("\n"+names[3] + ", you loser!");
					}
					else if (player0Total<player3Total)
					{
						slowPrint("\n"+names[3] + ", congrats, you won!");
					}
					else
					{
						slowPrint("\n"+names[3] + ", it's a tie...");
					}
				}
				System.out.println();
				break;
				
				
			//print rule
			case 2:
				printRule();
				break;
				
				
			//close program
			case 3:
				//print good-bye
				Thread.sleep(300);
				slowPrint("\nThank you for playing!");
				Thread.sleep(300);
				slowPrint("\nHope you enjoy gambling.");
				System.exit(0);
				
			}//end switch
			
		}//end while
	}//end main
	
	
	/*Method Name: slowPrint()
	 * from: https://stackoverflow.com/questions/58089090/creating-a-custom-method-to-slowly-print-text-in-java
	 * Parameters: String strMessage
	 * Returns: n/a
	 */
    public static void slowPrint(String strMessage) throws InterruptedException
    {
        char[] chars = strMessage.toCharArray();

        for (int i = 0; i < chars.length; i++)
        {
            System.out.print(chars[i]);
            Thread.sleep(20);
        }
    }//end slowPrint
    
    
	
	/*Method Name: showMenu()
	 * Description: print menu
	 * Parameters: n/a
	 * Returns: n/a
	 */
	private static void showMenu() throws InterruptedException 
	{
		Thread.sleep(300);
		slowPrint("\nMenu:");
		slowPrint("\n1) New Game");
		slowPrint("\n2) Rule");
		slowPrint("\n3) Exit Program");
	}//end showMenu


	/*Method Name: printRule
	 * Description: print rule for blackjack and collect enter at the end
	 * Parameters: n/a
	 * Returns: n/a
	 */
	private static void printRule() throws InterruptedException
	{
		Scanner myInput = new Scanner (System.in);
		
		slowPrint("Rules: ");
		Thread.sleep(500);
		System.out.println("\n\tIn Blackjack, everyone plays against the dealer (the computer). Players receive all cards face up (visible to everyone) and the dealer’s first card \nis f"
				+ "ace up and the second is face down (only the dealer knows). The object of the game is to get closer to 21 than the dealer without going over"
				+ " 21. You \ncan choose to “stand” (not drawing any additional cards) or “hit” (receive another card) after you receive your first two cards.");
		Thread.sleep(500);
		System.out.println("\tIf a hand goes over 21, it is called a “bust” and the person loses. If you are closer to 21 than the dealer, you win, otherwise "
				+ "you lose. If the \ndealer’s hand “busts” or “breaks,” you win as well.");
		Thread.sleep(500);
		System.out.println("\tIn Blackjack, Jacks, Queens, Kings and 10s count as 10. An Ace may be played as a one or an 11. All other cards are played at face value.");
		slowPrint("\n(click enter to return to main menu)");
		myInput.nextLine();
	}//end printRule



	/*Method Name: calculateTotal
	 * Description: calculate the total value (choose the higher value if there is Ace)
	 * Parameters: int array playerCards
	 * Returns: int sum
	 */
	private static int calculateTotal(int[] playerCards) 
	{
		//initialize variable
		int sum = 0;
		//add up all the cards
		for (int temp=0; temp<playerCards.length; temp++)
		{
			sum = sum + playerCards[temp];
		}//end for loop
		
		//if there are Ace
		int numOfA = Array.countElements(1, playerCards);
		if (numOfA > 0)
		{
			sum = sum+10*numOfA;//count Ace as 11
			if(sum>21)//if bust
			{
				sum = sum-10*numOfA;//count Ace as 1 by subtracting 10
			}
		}
		
		return sum;
	}//end calculateTotal


	/*Method Name: checkIfBust
	 * Description: check if the total value is over 21 and return true or false
	 * Parameters: int array playerCards
	 * Returns: boolean bust
	 */
	private static boolean checkIfBust(int[] playerCards) throws InterruptedException 
	{
		//initialize variables
		boolean bust = false;
		int playerTotal = calculateTotal(playerCards);
		
		//if bust
		if(playerTotal>21)
		{
			bust = true;
			slowPrint(" Bust!\n");
			//empty player's cards
			for (int temp=0; temp<playerCards.length; temp++)
			{
				playerCards[temp] = 0;
			}//end for loop
		}//end if
		
		return bust;
	}//end checkIfBust


	/*Method Name: collectHitOrStand
	 * Description: collect user's input and ask user to enter again if the user does not enter valid interger
	 * Parameters: n/a
	 * Returns: string input
	 */
	private static String collectHitOrStand() throws InterruptedException
	{
		Scanner myInput = new Scanner (System.in);
		//convert input into lower case
		String input = myInput.nextLine().trim().toLowerCase();
				//when input is invalid
				while(input.equals("hit")==false && input.equals("stand")==false)
				{
					slowPrint("invalid input, please enter again");
					input = myInput.nextLine().trim().toLowerCase();
				}//end while
		
		return input;
	}//end collectHitOrStand


	/*Method Name: displayTotal
	 * Description: display player's total value (display both result if there is an Ace)
	 * Parameters: int array playerCards
	 * Returns: n/a
	 */
	private static void displayTotal(int[] playerCards) throws InterruptedException 
	{
		//initialize variable
		int sum = 0;
		
		//if blackjack, only print "blackjack" instead of total value
		if(playerCards[0]==1 && playerCards[1]==10)
		{
			slowPrint("Blackjack!");
			return;
		}
		if(playerCards[0]==10 && playerCards[1]==1)
		{
			slowPrint("Blackjack!");
			return;
		}
		
		//add up all the cards
		for (int temp=0; temp<playerCards.length; temp++)
			{
				sum = sum + playerCards[temp];
			}
			//end for loop
		System.out.print(sum);
		
		//if there is Ace
		int numOfA = Array.countElements(1, playerCards);
		if (numOfA>0)
		{
			sum = sum+10*numOfA;
			if(sum<22)
			{
				System.out.print(" or "+ sum);
			}
		}
	}//end displayTotal
	
	
	/*Method Name: displayCards
	 * Description: display player's cards and the total
	 * Parameters: string name, int array playerCards, int i
	 * Returns: n/a
	 */
	private static void displayCards(String name, int[] playerCards, String[] playerSuits, int i) throws InterruptedException 
	{
		slowPrint("\n" + name + ": " + playerCards[0] + playerSuits[0]);
		for (int temp=1; temp<i; temp++)
		{
			slowPrint(" " + playerCards[temp] + playerSuits[temp]);
		}//end for loop
		System.out.print(" = ");
		displayTotal(playerCards);
	}//end displayCards
	
	
	/*Method Name: displayDealerCards
	 * Description: display dealer's cards (hide the first card, display as X)
	 * Parameters: int array playerCards
	 * Returns: n/a
	 */
	private static void displayDealerCards(int[] playerCards, String[] playerSuits) throws InterruptedException 
	{
		slowPrint("Dealer: X " + playerCards[1] + playerSuits[1]);
	}//end displayDealerCards
	
	
	/*Method Name: shuffle
	 * Description: shuffle the deck of cards randomly
	 * Parameters: int array cards
	 * Returns: n/a
	 */
	private static void shuffle(int[] cards, String []suits)
	{
		int shuffleTimes = (int) (Math.random()*100)+20;

		for (int temp=0; temp<shuffleTimes; temp++)
		{
			int shuffleIndex1 =  (int) (Math.random()*52)+0;
			int shuffleIndex2 =  (int) (Math.random()*52)+0;
		Array.swapElements(cards, shuffleIndex1, shuffleIndex2);
		Array.swapElements(suits, shuffleIndex1, shuffleIndex2);
		}//end for loop
		
	}//end shuffle
	
	
	/*Method Name: collectInt
	 * Description: coolect interger and ask user to enter again if the user does not enter valid interger
	 * Parameters: n/a
	 * Returns: n/a
	 */
	public static int collectInt() throws InterruptedException
	{
		//initial setup
		Scanner myInput = new Scanner (System.in);
		int userValue = 0;
		//loops until valid integer is entered (breaks after collected)
		do
		{
				try {
					//piece of code that could potentially crash the program
					userValue = myInput.nextInt();
					myInput.nextLine();//collects the enter at the end of the line
					break;
				} catch (Exception e) 
				{
					//when a invalid data type entered
					myInput.nextLine();//collects the enter at the end of the line
					slowPrint("Invalid input, please try again");
				}
		}while(true);
		return userValue;
	}//end collectInt
	
}//end class
