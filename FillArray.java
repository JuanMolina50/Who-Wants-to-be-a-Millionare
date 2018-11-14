import java.util.Random;

public class FillArray 
{ 
  public int [] GetArray  (int [] numberArray)
  {
    Random random = new Random();
      final int MAX_INT = 10;
      final int MAX_INTT= 50;
      
      for (int i = 0; i <= 5; i++) // Numbers in the array with indexes, 0,1,2,3,4, and 5 are filled with easy numbers
      {
        numberArray [i] = random.nextInt(MAX_INT) + 10;
      }
      
      for (int i = 6; i <= 9; i++) // Numbers in the array with indexes, 6, 7, 8, and 9 are filled with harder numbers
      {
        numberArray [i] = random.nextInt(MAX_INTT) + 20;
      }
      
      return numberArray; // Randomized array is returned
  }
}

