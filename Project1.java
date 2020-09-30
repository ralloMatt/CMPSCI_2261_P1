import java.util.Random;// used in order to find a random number 
import java.util.Scanner;

public class Project1 {
	
	 public static void main(String[] args) {
		 
		 String[] words = {"dog", "computer", "games", "java", "sunset", "carpet", "television", "zebra", "cat","pirates" };
		 // List of words to guess by user
		 int total_misses = 0; // Keeps track of total misses of all games played
		 int n = 3; // Used for while loop to see if game will be played again
		 int games = 0; // To see how many games were played by user
		 
		 Scanner scan = new Scanner(System.in); // Making a scanner
		 
		 while (n != 0) {
		 
			 String word_to_guess = Generate_word(words); // generates the word to be guessed
			 String blank_word = Generate_blank_word(word_to_guess); // generates blank word based on word to guess
			 
			 int misses = 0; // number of misses played through each game
			 
			 //Making a character array with max size 100 to keep track of user answers 
			 // Used to make sure user does not guess the same more than once
			 char[] guessed_letters = new char[100]; 
			 int counter = 0; // Counter for character array
			 
			 while(  !word_to_guess.equals(blank_word)  ) // Used to loop through until user guessed right word
			 {
				 int i = 0; // for for loop
				 int letter_truth = 0; // Used to determine if letter was in word or not or already guessed
				 						// 0 means letter was not in word
				 
				
				 
				 char[] word = word_to_guess.toCharArray(); // Making strings to char array for easier looping
				 char[] blank = blank_word.toCharArray();
				 
				 System.out.println("Please guess a letter in the following word " + blank_word);
				 char letter = scan.next().charAt(0); // Scanning user input
				 		 
				 
				 for(i=0; i < word_to_guess.length(); i++)
				 {
					 
					
					 if(letter == word[i]) // Seeing if letter is in the word to be guessed
					 {
						 blank[i] = letter; // If so put letter in blank character array at the same place
						 letter_truth = 1; // 1 means that the letter was in the word
					 }
					 
					
					
					 
				
				 }
				 
				 for(i=0; i< counter; i++) // Used to loop through to see if word was used more than once
				 {
					 if(guessed_letters[i] == letter)
						 letter_truth = 2; // If so letter truth is 2 which means it was
				 }
				 
				// testing System.out.println("Counter is " + counter);
				 
				
				 
			
				 
				 if(letter_truth == 0) // Printing if letter was not there
				 {
					 System.out.println("Sorry " + letter + " is not in the word! Try again.");
					 misses++; // keeping track of misses
				
				 }
				 
				 if(letter_truth == 1) // Printing if letter was guessed right
				 {
					 System.out.println("Congrats you guessed the right letter!");
				 }
				 
				 if(letter_truth == 2) // If letter was already guessed
				 {
					 System.out.println("You have already guessed the letter " + letter + "! Try again.");
					 misses++; // keeping track of misses
					 
				 }
				 
				 
				 blank_word = new String(blank); //Used to replace "*" with letter
				 
				 guessed_letters[counter] = letter; // Putting letters that were guessed in char array
				 counter++;
				
			 } // ends second while 
			 
			 
			 
			 System.out.println("\nCongratulations, the word was: " + word_to_guess);
			 
			 System.out.println("You had " + misses + " misses!");
			 
			 games++;
			 total_misses = total_misses + misses;	
			 
			 
			 double average = Calculate_average(total_misses, games); 
			 System.out.println("\nYour average misses per game is " + average);
			 
			 System.out.println("Do you want to play again? 1= yes 0 = no");
		 
		
			 n = scan.nextInt(); // Seeing if user wants to play another round
			 
			 
			 
			 
			 if(n == 0)
			 {
				 System.out.println("Total Number of Games Played is: " + games);
			 }
			
			
		 } // ends first while 
		 
		 
		 
		 
		 
		 
		  scan.close(); // closes scan
		  
		  
	 } // End main
	
	
	
	public static String Generate_word(String[] array){ // Used to generate a random word from list
		
		int length = array.length; //To get lenght of array of strings
		
		Random num = new Random(); // Getting random number
		
		int random_number = num.nextInt(length); // Length was used as a boundary for random number
		
		String new_word = array[random_number]; // Setting it as the word to guess
		
		
		
		return new_word; 
	} // end generate word method
	
	
	public static String Generate_blank_word(String word){ // Uses word to guess as a way to determine size
		
		int length = word.length(); // find the length
		int i;
		char[] data = word.toCharArray(); // converting string to char array for easier access
		
		
		for( i=0; i<length; i++) // using length to determine how many *'s
		{
			data[i] = '*';
		}
		
		String blank = new String(data); // changing back to string
		
		
		return blank; 
	} // end generate blank word method
	
	public static double Calculate_average(int misses, int games_played){ // takes in total number of misses and games played
		
		double average = 0; // set average to zero
		
		average = misses/games_played; // divides them
		return average; 
	} // end average calculator
	
	
	
	
} //ends class
