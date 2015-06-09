package com.goit.tasks.task1;

import java.util.ArrayList;

public class AnagramAction {
	private ArrayList<Character> alphabet = new ArrayList<Character>();
		
	public AnagramAction() { 
		alphabetInit();
	}
		
	private void alphabetInit(){
		char c1 = 'A';
        char c2 = 'a';
        
        while (true) {
            if (c1 != '[') {
            	alphabet.add(c1);
            } else {
                break;
            }
            c1++;
        }
        while (true) {
            if (c2 != '{') {
            	alphabet.add(c2);
            } else {
                break;
            }
            c2++;
        }
	}
	
	public String getAnagram(String text) {
		
		if (text.isEmpty()){
			System.out.println("Sorry...try again!");
		}
        	
		   String finishText = "";
		   String parts[] = text.split(" ");
		   
		   for (String str : parts) {
			   finishText += turningString(str) + " ";
		   }
			   
		   
		   return finishText;
		   
	}
	
	private String turningString(String s) {
		
		ArrayList<Character> array = new ArrayList<Character>();
		char[] strArray = s.toCharArray(); 
		char[] newStr = new char[strArray.length];
	    char[] setOfCharacters = new char[strArray.length];
	    int lastIndex = strArray.length-1;
	    boolean flag;
        
        for	(int i=0; i<strArray.length; i++) {
        	
        	flag = false;
        	
        	for(char ch : alphabet) {
        		if(strArray[i] == ch){
        			flag = true;
        		}

        	}
        	if(!flag){
        		newStr[i] = strArray[i];
        	}
        	else{
        		if(strArray[i]!='\0'){
        			setOfCharacters[lastIndex] = strArray[i];
        			lastIndex--;
        		}
        	}
        		
        }
        for	(char t: setOfCharacters){
        	if (t != '\0'){
        		array.add(t);
        	}
        		
        }
        int index = 0;
        for(int i = 0; i<newStr.length; i++) {
        	if (newStr[i] == '\0'){
        		newStr[i] = array.get(index);
        		index++;
        	}
        }
	    
		return String.valueOf(newStr);
	}
	
}
