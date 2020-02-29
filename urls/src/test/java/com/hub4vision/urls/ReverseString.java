package com.hub4vision.urls;

import java.sql.Driver;


public class ReverseString {

	public static void main(String[] arg){
		
		String str = "I have twenty years of experiance";
		String[] words = str.split(" ");
		String reverseString = "";
		
		for (int i=0 ; i < words.length; i++){
			
			String word = words[i];
			String reverseWord = "";
			
			for (int j = word.length()- 1; j >= 0; j--){
				
				reverseWord = reverseWord + word.charAt(j);

			}
			
			reverseString=reverseString + reverseWord + " ";
		}
		System.out.println(str);
		
		System.out.println(reverseString);
		
		
	}
	
}

/*


		
		
		String str = "I have twenty years of experiance";
		String[] words = str.split(" ");
		String reserverString = "";
		
		for(int i=0 ; i < words.length; i++){
			
			String word = words[i];
			String reverseWord = "";
			
			for (int j=word.length()-1;j >=0; j-- ){
				
				reverseWord = reverseWord + word.charAt(j);
				
			}
			reserverString = reserverString +  reverseWord + " ";
			
		}
				
		System.out.println(str);
		System.out.println(reserverString);
	
		
		StringBuilder strRev = new StringBuilder();
		strRev.append(str).reverse();
		System.out.println(strRev);
		
		StringBuilder strRev1 = new StringBuilder();
		strRev1.append(str).replace(0, str.length(), " ");
		System.out.println(strRev1);
        
*/