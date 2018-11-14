import java.util.Random;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintStream;
 /*
  * Juan Molina Calderon
  * Due May 14, 2017
  * For Mr. D. Cheeseman
  * */

public class CulminatingAssignment 
{
  
  public static void main(String[] args) throws FileNotFoundException
  { 
    System.out.println ("                             Welcome to You Only Have Juan Chance!");
    System.out.println();
    System.out.println("In this game you will have to go through three rounds of challenges in order to become a millionare");
    System.out.println("For the first stage you will have to answer 5 trivia questions");
    System.out.println("For the second stage you will have to answer 5 math questiions involving adding/subtracting/multiplying");
    System.out.println("For the third stage you will have to beat the machine at a game of blackjack");
    System.out.println("You will gain money for each question you get right");
    System.out.println("If you miss a question, you will lose all your money");
    System.out.println("You can decide to stop playing at any point and retrieve your money");
    System.out.println("Keep in mind that the last round is a bonus round as you will have a chance to double your money if you win the blackjack game");
    System.out.println("To answer the trivia questions simply type the letter of your answer, and for math questions just type your answer");
    System.out.println("Please increase your console size in order to have a better experience!!!!");
    System.out.println();
    System.out.println("                                             Good Luck!");
    
    
    PrintStream diskWriter = new PrintStream ("Wallet.txt");
    int balance = 0;
    
    FillArray myArray = new FillArray ();
    int [] numberArray = new int [10];
    numberArray = myArray.GetArray(numberArray); // Gets the randomized array
    
    balance = FirstStage (balance); // Calls for the first stage
    System.out.println("You have finished the first stage with $" + balance);
    System.out.println();
    System.out.println("            Get ready for the second stage!!!");
    System.out.println();
    
    balance = SecondStage (balance, numberArray); // Calls for the second stage
    System.out.println("You have finished the second stage with $" + balance);
    System.out.println();
    System.out.println("            Get ready for the last stage!!!");
    System.out.println();
    
    balance = LastStage (balance); // Calls for the last stage
    System.out.println("You won the game!!! Congratulations!!!");
    System.out.println("You have won the grand total of $" + balance);
    diskWriter.println("You have added $" + balance + " to your bank account"); // Will create a file called Wallet that will display the amount of money the user left with
    diskWriter.close();
    
    
  }
  
  public static int FirstStage (int balance) throws FileNotFoundException
  {                                         // ^^ Needs this in case the user decides to drop out and cash out. The money won will
    String userInput = "";                  //    be added to a file called wallet.
    Scanner input = new Scanner(System.in);
    
   while (true)
   {
     while (true)
     {
       System.out.println("Get ready for your first question!"); // First Question
       System.out.println();
       System.out.println("1) The US declared war on which coutnry after the bombing of Pearl Harbor?");
       System.out.println("A.Japan");
       System.out.println("B.China");
       System.out.println("C.Vietnam");
       System.out.println("D.Germany");
       
       userInput = InputChecker(userInput); // Checks for a valid input
       
       if (userInput.equalsIgnoreCase ("a"))
       {
         balance += 500;
         System.out.println("You are correct!");
         System.out.println("Your balance is $" + balance);
         break;
       }
       
       else 
       {
         System.out.println("WRONG!");
         System.out.println("You failed the first question!You walk away with $0!");
         Fail(); // Redirects the user to quit the game
         break;
       }
     }     
     
     System.out.println();
     System.out.println("Do you want to keep playing? Or quit and keep all your money!");
     System.out.println("Press enter if you want to continue or type quit to leave the game");
     userInput = input.nextLine();
     // If user just hits enter, then the code will keep running
        if (userInput.equalsIgnoreCase ("quit"))
        {
          End (balance); // If the player quits, he will leave with all his money
          break;
        }  
       
     while(true)
     {
       System.out.println("Get ready for your second question!"); // Second Question
       System.out.println();
       System.out.println("2) Which state in the US is called the Golden state?");
       System.out.println("A.Texas");
       System.out.println("B.Florida");
       System.out.println("C.California");
       System.out.println("D.Tennessee");

       userInput = InputChecker(userInput); // Checks for valid input
       
       if (userInput.equalsIgnoreCase ("c"))
       {
         balance += 500;
         System.out.println("You are correct!");
         System.out.println("Your balance is $" + balance);
         System.out.println();
         break;
       }
       
       else 
       {
         System.out.println("WRONG!");  
         balance -= balance;
         System.out.println("You lose and you walk away with $" + balance);
         Fail ();// Redirects the user to quit the game
         break;
       }
     }
     
     System.out.println("Do you want to keep playing? Or quit and keep all your money!");
     System.out.println("Press enter if you want to continue or type quit to leave the game");
     userInput = input.nextLine();
     // If user just hits enter, then the code will keep running
      if (userInput.equalsIgnoreCase ("quit"))
        {
          End (balance);// If the player quits, he will leave with all his money
          break;
        } 
     
     while (true)
     {
       System.out.println("Get ready for your third question!"); // Third Question
       System.out.println();
       System.out.println("3) What is the most popular drink in the world that does not contain alcohol?");
       System.out.println("A.Coffee");
       System.out.println("B.Orange Juice");
       System.out.println("C.Tea");
       System.out.println("D.Gatorade");
       
       userInput = InputChecker(userInput);
       
       if (userInput.equalsIgnoreCase ("a"))
       {
         balance += 1000;
         System.out.println("You are correct!");
         System.out.println("Your balance is $" + balance);
         System.out.println();
         break;
       }
       
       else 
       {
         System.out.println("WRONG!");
         balance -= balance;
         System.out.println("You lose and you walk away with $" + balance);
         Fail ();// Redirects the user to quit the game
         break;
       }
     }
     
     System.out.println("Do you want to keep playing? Or quit and keep all your money!");
     System.out.println("Press enter if you want to continue or type quit to leave the game");
     userInput = input.nextLine();
     // If user just hits enter, then the code will keep running
      if (userInput.equalsIgnoreCase ("quit"))
       {
         End (balance); // If the player quits, he will leave with all his money
         break;
       }  
       
     while (true)
     {
       System.out.println("Get ready for your fourth question!");  // Fourth Question
       System.out.println();
       System.out.println("4) Which is the only vowel on a standard keyboard that is not on the top line of letters?");
       System.out.println("A.The letter U");
       System.out.println("B.The letter A");
       System.out.println("C.The letter E");
       System.out.println("D.The letter I");
       
       userInput = InputChecker(userInput);
       
       if (userInput.equalsIgnoreCase ("b"))
       {
         balance += 2000;
         System.out.println("You are correct!");
         System.out.println("Your balance is $" + balance);
         System.out.println();
         break;
       }
       
       else 
       {
         System.out.println("WRONG!");
         balance -= balance;
         System.out.println("You lose and you walk away with $" + balance);
         Fail (); // Redirects the user to quit the game
         break;
       }
     }
     
     System.out.println("Do you want to keep playing? Or quit and keep all your money!");
     System.out.println("Press enter if you want to continue or type quit to leave the game");
     userInput = input.nextLine();
     // If user just hits enter, then the code will keep running
      if (userInput.equalsIgnoreCase ("quit"))
       {
         End (balance);// If the player quits, he will leave with all his money
         break;
       }  
     
     while(true)
     {
       System.out.println("Get ready for your last question!"); // Fifth Question
       System.out.println();
       System.out.println("5) How many children does Obama have?");
       System.out.println("A.0");
       System.out.println("B.1");
       System.out.println("C.2");
       System.out.println("D.3");
       
       userInput = InputChecker(userInput);
       
       if (userInput.equalsIgnoreCase ("c"))
       {
         balance += 6000;
         System.out.println("You are correct! You will go to the next stage!");
         System.out.println("Your balance is $" + balance);
         System.out.println();
         System.out.println("                    Congratulations!!");
         System.out.println();
         break;
       }
       
       else 
       {
         System.out.println("WRONG!");
         balance -= balance;
         System.out.println("You lose and you walk away with $" + balance);
         Fail(); // Redirects the user to quit the game
         break;
       }
     }
     
     System.out.println("Do you want to keep playing? Or quit and keep all your money before moving on to the next stage");
     System.out.println("Press enter if you want to continue or type quit to leave the game");
     userInput = input.nextLine();
     // If user just hits enter, then the code will keep running
      if (userInput.equalsIgnoreCase ("quit"))
        {
          End (balance);// If the player quits, he will leave with all his money
          break;
        }  
     
      else
      {
        break;
      }
   }
    input.close();
    return balance;
  }
  
  public static int SecondStage (int balance, int [] array) throws FileNotFoundException
  {
    int userInput;
    String stringInput;
    int power = 6; // For recursion question
    int base = 2; // For recursion question
    Scanner input = new Scanner(System.in);
    
    int first = array [0] + array [1];
    int second = RecursionQuestion(base , power); // Calls the recursive method to give a value to the answer of the second question
    int third = array [7] + array [9];
    int fourth = array [6] * 4;
    int fifth = array [8] * 5;
                                   
    while (true)
    {
      while (true)
      {
        System.out.println("Get ready for your first question!"); // First Question
       System.out.println();
       System.out.println("1) What is " + array [0] + " + " + array [1] + " ?");
       userInput = input.nextInt();
       input.nextLine();
       
       if (userInput == first)
       {
         balance += 5000;
         System.out.println("You are correct!");
         System.out.println("Your balance is $" + balance);
         break;
       }
       
       else 
       {
         System.out.println("WRONG!");
         System.out.println("You failed the first question!You walk away with $0!");
         Fail ();// Redirects the user to quit the game
         break;
       }
      }
      
     System.out.println();
     System.out.println("Do you want to keep playing? Or quit and keep all your money!");
     System.out.println("Press enter if you want to continue or type quit to leave the game");
     stringInput = input.nextLine();
     // If user just hits enter, then the code will keep running
      if (stringInput.equalsIgnoreCase ("quit"))
        {
          End (balance);// If the player quits, he will leave with all his money
          break;
        }  
      
      while (true)
      {
        System.out.println("Get ready for your second question!"); // Second Question
       System.out.println();
       System.out.println("2) What is 2^6 or 2 to the power of 6?");
       userInput = input.nextInt();
       input.nextLine();
       
       if (userInput == second)
       {
         balance += 10000;
         System.out.println("You are correct!");
         System.out.println("Your balance is $" + balance);
         break;
       }
       
       else 
       {
         System.out.println("WRONG!");
         balance -= balance;
         System.out.println("You lose and you walk away with $" + balance);
         Fail ();// Redirects the user to quit the game
         break;
       }
      }
      
     System.out.println(); 
     System.out.println("Do you want to keep playing? Or quit and keep all your money!");
     System.out.println("Press enter if you want to continue or type quit to leave the game");
     stringInput = input.nextLine();
     // If user just hits enter, then the code will keep running
      if (stringInput.equalsIgnoreCase ("quit"))
        {
          End (balance);// If the player quits, he will leave with all his money
          break;
        }  
      
       while (true)
      {
        System.out.println("Get ready for your third question!"); // Third Question
       System.out.println();
       System.out.println("3) What is " + array [7] + " + " + array [9] + " ?");
       userInput = input.nextInt();
       input.nextLine();
       
       if (userInput == third)
       {
         balance += 25000;
         System.out.println("You are correct!");
         System.out.println("Your balance is $" + balance);
         break;
       }
       
       else 
       {
         System.out.println("WRONG!");
         balance -= balance;
         System.out.println("You lose and you walk away with $" + balance);
         Fail ();// Redirects the user to quit the game
         break;
       }
      }
      
     System.out.println();  
     System.out.println("Do you want to keep playing? Or quit and keep all your money!");
     System.out.println("Press enter if you want to continue or type quit to leave the game");
     stringInput = input.nextLine();
     // If user just hits enter, then the code will keep running
      if (stringInput.equalsIgnoreCase ("quit"))
        {
          End (balance);// If the player quits, he will leave with all his money
          break;
        }
      
       while (true)
      {
        System.out.println("Get ready for your fourth question!"); // Fourth Question
       System.out.println();
       System.out.println("4) What is " + array [6] + " * 4 ?");
       userInput = input.nextInt();
       input.nextLine();
       
       if (userInput == fourth)
       {
         balance += 50000;
         System.out.println("You are correct!");
         System.out.println("Your balance is $" + balance);
         break;
       }
       
       else 
       {
         System.out.println("WRONG!");
         balance -= balance;
         System.out.println("You lose and you walk away with $" + balance);
         Fail ();// Redirects the user to quit the game
         break;
       }
      }
     
     System.out.println();  
     System.out.println("Do you want to keep playing? Or quit and keep all your money!");
     System.out.println("Press enter if you want to continue or type quit to leave the game");
     stringInput = input.nextLine();
     // If user just hits enter, then the code will keep running
      if (stringInput.equalsIgnoreCase ("quit"))
        {
          End (balance);// If the player quits, he will leave with all his money
          break;
        }  
      
       while (true)
      {
        System.out.println("Get ready for your fifth question!"); // Fifth Question
       System.out.println();
       System.out.println("5) What is " + array [8] + " *  5 ?");
       userInput = input.nextInt();
       input.nextLine();
       
       if (userInput == fifth)
       {
         balance += 
         400000;
         System.out.println("You are correct!");
         System.out.println("Your balance is $" + balance);
         break;
       }
       
       else 
       {
         System.out.println("WRONG!");
         balance -= balance;
         System.out.println("You lose and you walk away with $" + balance);
         Fail ();// Redirects the user to quit the game
         break;
       }
      }
       
     System.out.println(); 
     System.out.println("Do you want to keep playing? Or quit and keep all your money! Remember that if you win the last round your money will double");
     System.out.println("Press enter if you want to continue or type quit to leave the game");
     stringInput = input.nextLine();
     // If user just hits enter, then the code will keep running
      if (stringInput.equalsIgnoreCase ("quit"))
        {
          End (balance);// If the player quits, he will leave with all his money
          break;
        }  
      
       else
      {
        break;
      }
    }   
    
    input.close();
    return balance;
  }
  
  public static int LastStage (int balance) throws FileNotFoundException
  {
    Random myRandom = new Random();
    Scanner input = new Scanner(System.in);
    
    String stringInput;
    int randomNumber;
    int randomNumberComp;
    int count = 0;
    int computerCount = 0;
    
    System.out.println("Get Ready!! Computer has to stand at 17! You loose if you go over 21 or if the machine has a higher score than you!");
    System.out.println("                                      Good Luck!!");
    
    while (true) //Will loop until player types stand
    { 
      System.out.println("Press enter to get a card, or type stand to stand");
      stringInput = input.nextLine();
      
      if (stringInput.equalsIgnoreCase ("stand"))  // If the user just hits enter, then a card will be added to his count
        {
          break;
        }  

      randomNumber = myRandom.nextInt(11) + 1;
      count = count + randomNumber;
      
      System.out.println("Your current Count is " + count); //Will print out the current count until the player types stand
      System.out.println();
      
       if (count > 21)
      {
        System.out.println("You lost and leave with $0");
        Fail(); // Will redirect the user to quit the game
      }
      
    }
    
    while(true)
    {
       if (computerCount < 17) // Computer will keep adding cards until the current count is more than 17 or 17 exact
        {
          randomNumberComp = myRandom.nextInt(11) + 1;
          computerCount = computerCount + randomNumberComp;
        }
       
        System.out.println("Computer's Count is: " + computerCount);
       
        if (computerCount > 21)
       {
         Win(balance); //User is redirected to a method that will tell him he won since the computer lost
         break;
       }
       
       else if (computerCount >= 17 && computerCount <=21) // If the computer is in between these numbers, the loop will stop running
       {
         break;
       }
    }
    
    System.out.println("You finished with a count of " + count);
    System.out.println("The computer finished with a count of " + computerCount);
    System.out.println();
    
    if (count > computerCount)
    {
      System.out.println("You Won!!!"); //User wins if he stands with a higher count than the computer
      balance *= 2;
    }
    
    else
    {
      System.out.println("You lost all your money $$!!");
      Fail(); // Redirects user to quit the game
    }
    input.close();
    return balance;
  }
  
  public static void Win (int balance) throws FileNotFoundException // Only for the blackjack game, in case the computer goes over 21
  {
    Scanner input = new Scanner(System.in);
    PrintStream diskWriter = new PrintStream ("Wallet.txt");
    balance *= 2;
    
    System.out.println("The computer went over 21");
    System.out.println("You WIN the game!!!! And you leave with a total of $" + balance);
    diskWriter.println("You have added $" + balance + " to your bank account"); // Prints to a separate file
    System.out.println("Press enter to quit!");
    input.nextLine();
    
    input.close();
    diskWriter.close();
    System.exit(10000);
  }
  
  public static String InputChecker (String userInput) // This method checks for a valid input on the first stage
  {
    Scanner input = new Scanner (System.in);
    
    while (true)
       {
         try
         {
           userInput = input.nextLine(); // It tries checking the input
         }
         
         catch (Exception ex)
         {
         }
         
         finally
         {
           if (userInput.equalsIgnoreCase ("a") || userInput.equalsIgnoreCase ("b") ||userInput.equalsIgnoreCase ("c")||userInput.equalsIgnoreCase ("d"))
           {
             break; // If the input is one of the answers (a,b,c,or d) the code breaks and returns the answer
           }
           
           else // If the user types a number or something like a word, it will require another input.
           {
             System.out.println("You did not type a valid answer. Try again!");
           }
         }
       }
    input.close();
    return userInput;
  }
  
  public static int [] GetNumber (int [] array) // Will get random numbers for each math question so they are never the same
  {
      Random random = new Random();
      final int MAX_INT = 10;
      final int MAX_INTT= 50;
      
      for (int i = 0; i <= 5; i++) // Numbers in the array with indexes, 0,1,2,3,4, and 5 are filled with easy numbers
      {
        array [i] = random.nextInt(MAX_INT) + 10;
      }
      
      for (int i = 6; i <= 9; i++) // Numbers in the array with indexes, 6, 7, 8, and 9 are filled with harder numbers
      {
        array [i] = random.nextInt(MAX_INTT) + 20;
      }
      
      return array; // Randomized array is returned
  }
  
  public static void End (int balance)throws FileNotFoundException
  {
    Scanner input = new Scanner(System.in);
    PrintStream diskWriter = new PrintStream ("Wallet.txt");
    
    System.out.println("You left with a balance of $" + balance);
    diskWriter.println("You have added $" + balance + " to your bank account"); // Will create a file called Wallet that will display the amount of money the user left with
    System.out.println("Press enter to quit!");
    input.nextLine(); // When the user inputs anything, the program will quit without moving on to other stages
    
    input.close();
    diskWriter.close();
    System.exit(10000);
  }
  
  public static void Fail () // If the player misses a question he will be redirected here. This method quits the program to prevent any other stages from running
  {
    Scanner input = new Scanner (System.in);
    
    System.out.println("Press enter to quit!");
    input.nextLine();
    
    input.close();
    System.exit(10000);
  }
  
  public static int RecursionQuestion (int base, int power)
  { 
    if (power == 1) //base case
    {
      return base;
    }
    
    else // recursive case
    {
      return base * RecursionQuestion(base, power - 1);
    }
  }
}