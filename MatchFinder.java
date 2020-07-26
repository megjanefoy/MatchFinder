/**************************************************************
  * Purpose: This program takes in a sorted array of integers
    and finds the number of matches for a given value.
 **************************************************************/

public class MatchFinder{
 
 public static void main(String[] args){ 
   int arrayA[] = {-1, 2, 3, 5, 6, 6, 6, 9, 10}; 
   int listLength = arrayA.length; 
   int findNum = 6; 
   int occurances = numMatches(arrayA, listLength, findNum);
   System.out.print("The number " + findNum + " was found " + occurances + " times."); 
 } 
  
 /*
  * This method counts the number of occurances of 
  * the number to find within arrayA[0 .. n-1].
  * 
  * @param arrayA[]   ,the array of integers to be searched.
  * @param listLength ,the length of the list to be searched.
  * @param findNum    ,the integer to be found.
  * @return ,returns the number of occurances as an int.
  */
 public static int numMatches(int arrayA[], int listLength, int findNum){ 
   int index = binarySearch(arrayA, 0, listLength - 1, findNum); 
     
   if (index == -1){ // If element is not present
     return 0; 
   }
         
   int occurance = 1; 
   int leftSide = index - 1; 
   while ((leftSide >= 0) && (arrayA[leftSide] == findNum)){   // Count elements on left side.
     ++occurance; 
     --leftSide; 
   } 
      
   int rightSide = index + 1; 
   while ((rightSide < listLength) && (arrayA[rightSide] == findNum)) { // Count elements on right side.
     ++occurance; 
     ++rightSide; 
   } 
   return occurance; 
 }  
  
 
 /*
  * This is a recursive method to complete a binary search to locate a number.
  * 
  * @param arrayA[] ,the array of integers to be searched.
  * @param begin    ,the starting index.
  * @param end      ,the ending index.
  * @param findNum  ,the integer to be found.
  * @return ,returns the index location of the first occurance.
  */
 public static int binarySearch(int arrayA[], int begin, int end, int findNum) { 
   if (end < begin){
     return -1; 
   } 
   
   int mid = begin + (end - begin) / 2;    
   if (arrayA[mid] == findNum){  // If the element is present at the middle itself
     return mid; 
   }  
   if (arrayA[mid] > findNum){ // If element is smaller than  mid, then it can only be present in left subarray
     return binarySearch(arrayA, begin, mid - 1, findNum);
   }          
   else{      // Else the element can only be present in right subarray
     return binarySearch(arrayA, mid + 1, end, findNum); 
   } 
 }
}

