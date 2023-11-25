import java.util.ArrayList;
/**
   The DriverExam class stores data about a driver's license exam
   for the Driver�s License Exam programming challenge.
*/
public class DriverExam
{
   //variables 
  private int numCorrect;
  private int numIncorrect;
  private int[] missed;
  private char[] studentAnswers;
  private static final char[] CORRECT = {'B', 'D', 'A', 'A', 'C', 'A', 'B', 'A', 'C', 'D', 'B', 'C', 'D', 'A', 'D', 'C', 'C', 'B', 'D', 'A'};

   /**
      The constructor copies an array of answers
      to the student field.
      @param s The array of answers to copy.
   */
   
   public DriverExam(char[] s)
   {
     studentAnswers = s;
     gradeExam();
   }
   
   /**
      The gradeExam method determines the number of
      correct and incorrect answers. It calls the
      makeMissedArray method.
   */
   
   private void gradeExam()
   {
      numCorrect = 0;
      numIncorrect = 0;
      for(int index = 0; index < CORRECT.length; index++)
        {
          if(studentAnswers[index] == CORRECT[index])
          {
            numCorrect++;
          }
          else
          {
            numIncorrect++;
          }
        }
     makeMissedArray();
   }  
   
   /**
      The makeMissedArray method makes the missed array and
      stores the numbers of all the questions that the
      student missed in it.
   */
   
   private void makeMissedArray()
   {
      ArrayList<Integer> missedList = new ArrayList<>();
     for(int index = 0; index < CORRECT.length; index++)
       {
         if(studentAnswers[index] != CORRECT[index])
         {
           missedList.add(index + 1);
         }
       }
     
     if(!missedList.isEmpty())
     {
       missed = new int[missedList.size()];
       for(int index = 0; index < missedList.size(); index++)
         {
           missed[index] = missedList.get(index);
         }
     }
       else
     {
       missed = null;
     }
  }
   
   /**
      The passed method determines whether the student
      passed or failed the exam.
      @return true if the student passed, false otherwise.
   */
   
   public boolean passed()
   {
     return numCorrect >= 15;
   }
   
   /**
      The totalCorrect method returns the number of
      questions correctly answered.
      @return The number of questions correctly answered.
   */
   public int totalCorrect()
   {
      return numCorrect;
   }

   /**
      The totalInCorrect method returns the number of
      questions incorrectly answered.
      @return The number of questions incorrectly answered.
   */

   public int totalIncorrect()
   {
     return numIncorrect;
   }

   /**
      The questionsMissed method returns an array containing
      the numbers of the missed questions. 
      @return An array containing the numbers of the missed
              questions.If no questions were missed, returns null.
   */

   public int[] questionsMissed()
   {
      int[] temp = null;
      
      if (missed != null)
      {
         // First, make a copy of the array.
         temp = new int[missed.length];
         System.arraycopy(missed, 0, temp, 0, missed.length);
      }
      
      // Return the copy.
      return temp;
   }
}