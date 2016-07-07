/**
 * Created by Lawrence Huang on 1/21/2016.
 */
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;
import java.time.Instant;
import java.time.Duration;

public class InsertionSort {
  static final int ARR_LENGTH=16;
  
  public static void printArr(int[] arr)
  {
    //Displays Array
    for(int i = 0;i < arr.length;i++) {
      System.out.print(arr[i]);
      if(i<arr.length-1)
        System.out.print(" | ");
    }
    System.out.println();
  }
  
  public static void main(String[] args) {
    int[] nums = new int[ARR_LENGTH];
    Calendar cal = Calendar.getInstance();
    Random rand = new Random(cal.getTimeInMillis());
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Select method of integer input:\n(1) Random\n(2) User Input");
    int userChoice = sc.nextInt();
    if(userChoice==1) {
      System.out.println("Select maximum value possible in the array: ");
      int maxVal=sc.nextInt();
      //Random Ints in the Array
      for (int i = 0; i < nums.length; i++)
        nums[i] = rand.nextInt(ARR_LENGTH-1) + 1;
    }
    else if(userChoice==2){
      System.out.println("Enter numbers: ");
      for(int a=0;a<nums.length;a++){
        nums[a]=sc.nextInt();
      }
    }
    
    System.out.println("This array has " + ARR_LENGTH + " elements");
    
    //Print Array before sort
    //printArr(nums);
    
    //Insertion Sort from smallest to largest
    int currentNumIndex=1;
    int replacement1,replacement2;
    Instant t1=Instant.now();
    while(currentNumIndex<nums.length) {
      for(int i=0;i<currentNumIndex;i++)
        if(nums[currentNumIndex]<nums[i]) {
        replacement1=nums[i]; //replacement1 stores original value at insertion point
        nums[i]=nums[currentNumIndex]; //inserts value at currentNum
        for(int insertionPoint=i+1;insertionPoint<=currentNumIndex;insertionPoint++) { //loop to shift all other values
          replacement2=nums[insertionPoint]; //replacement2 stores original value at one right of insertion point
          nums[insertionPoint]=replacement1; //insertionPoint replaced by replacement1 (one left of insertion point)
          replacement1=replacement2; //replacement2 value passed to replacement 1
        }
      }
      currentNumIndex++;
    }
    Instant t2=Instant.now();
    System.out.println("This sort took " + Duration.between(t1,t2).toMillis()/1000.0 + " s");
    
    //Print array after sort
    printArr(nums);
    sc.close();
  }
}
