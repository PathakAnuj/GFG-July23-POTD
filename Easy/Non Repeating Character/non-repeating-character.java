//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            
            char ans=new Solution().nonrepeatingCharacter(st);
            
            if(ans!='$')
            System.out.println(ans);
            else
            System.out.println(-1);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    // Function to find the first non-repeating character in a string.
    static char nonrepeatingCharacter(String S) {
        // Create a frequency array to store the count of each character.
        int[] frequency = new int[256]; // Assuming ASCII characters.

        // Traverse the string and count the occurrences of each character.
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            frequency[ch]++;
        }

        // Traverse the string again and return the first non-repeating character.
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (frequency[ch] == 1) {
                return ch;
            }
        }

        return '$'; // If no non-repeating character is found, return '$'.
    }
}



