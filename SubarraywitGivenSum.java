
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;

class GFG {
	public static void main (String[] args) {
		Scanner inp = new Scanner(System.in); 
        String numOfTests = inp.nextLine();
        int T = Integer.parseInt(numOfTests);
        for (int i=0; i<T;i++){
           String[] firstLine = inp.nextLine().split(" ");
           String[] secondLine = inp.nextLine().split(" ");
           int N = Integer.parseInt(firstLine[0]);
           int S =  Integer.parseInt(firstLine[1]);
           int[] A = new int[N];
           for (int j=0; j<N; j++){
               A[j] = Integer.parseInt(secondLine[j]);
           }
           int[] locations = arrayLocations(N, S, A);
           if (locations[0] == -1){
               System.out.println(-1);
           }
           else{
           System.out.println(locations[0]+" "+locations[1]);
           }
        }
    }
	
	public static int[] arrayLocations(int N, int S, int A[]){
	    int[] locations = new int [2];
	    boolean found = false;
	    for (int i = 0; i < N; i++){
	        int sum = 0;
	        for (int j = i; j < N; j++){
	           sum+=A[j];
	           if (sum>S){
	               break;
	           }
	           if (sum==S){
	               locations[1] = j+1;
	               found = true;
	               break;
	           }
	        }
	        if (found){
	            locations[0] = i+1;
	            break;
	        }
	    }
	    
	    if (!found){
	        locations[0] = -1;
	    }
	    return locations;
	}
}