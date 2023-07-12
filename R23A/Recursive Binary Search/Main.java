/******************************************************************************
/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
// Abhay Iyer (AXI210015)
public class Main
{
    public static int FindLowAdjacent(int []  nums,int x){ //Recursively finds the lowest possible adjacent value equalling the key value
        if(x <= 0){
            return x;
        }
        if(nums[x - 1] == nums[x]){
           x = FindLowAdjacent(nums, x-1);
        }
        return x;
    }
    
    public static int FindHighAdjacent(int [] nums, int x){ //Recursively finds the highest possible adjacent value equalling the key value
        if(x >= nums.length - 1){
            return x;
        }
        if (nums[x+1] == nums[x]){
            x = FindHighAdjacent(nums, x+1);
        }
        return x;
    }
    
    public static int loMein(int[] nums, int key, int low, int high){ //Recursive Binary Search
        if (low > high){ //Base Case
            return -1;
        }
        int mid = (low + high) / 2 ; 
        //System.out.println(mid);
        if (nums[mid] == key){
            
            return mid; // IF we find the element return the index it was found at
        }
        if(nums[mid] > key){
           return loMein(nums, key, low, mid - 1); //If its too great re adjust the parameters
        }
        else{
           return loMein(nums, key, mid + 1, high); //if its to small re adjust the parameters
        }
    }
    public static int[] binarySearch(int[] nums, int key){
      int index = loMein(nums, key, 0, nums.length - 1); // Assign the binary search to the index value
      int [] ans = new int [2]; //Answer to return later
      if (index == -1){ // if we got -1 return a -1 array
          ans[0] = -1;
          ans[1] = -1;  
          return ans;
    }
    else {
        int lowindex = FindLowAdjacent(nums,index); //Find the low index and the high index for us to plugin to the 0 and 1 index of the answer array
        int highindex = FindHighAdjacent(nums, index);
     /*
        while(nums[lowindex] == nums[index] && lowindex > 0){ // find the low index
            if(nums[lowindex - 1] == nums[index]){
                lowindex--;
            }
            else{
                break;
            }
        }
        */
        /*
          while(nums[highindex] == nums[index] && highindex < nums.length - 1){ // find the high indx
            if(nums[highindex + 1] == nums[index]){
                highindex++;
            }
            else{
                break;
            }
        }
        */
        ans[0] = lowindex;
        ans[1] = highindex;
        return ans;
    }
    }
    

	public static void main(String[] args) {
		int [] nums = {3,5,5,11,21,35,36,41,41,47,52,53,72,72,83,92,95,97,99};
		int key = 99;
		int [] ans = new int[2];
		ans = binarySearch(nums, key);
		for(int x : ans){
		    System.out.println(x);
		}
	}
}

