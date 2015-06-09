package com.it_project.tasks.task1;

import java.util.ArrayList;

public class AnagramActor {
	
	private ArrayList<Character> alphabet = new ArrayList<Character>();
	private String error = "Sorry...try again!";	
	
	public AnagramActor() { 
		
	}
		
	private void alphabetInit() {
		char INITIAL_LETTER_UPPER_CASE = 'A';
		char INITIAL_LETTER_LOWER_CASE = 'a';
		
		for ( int i = 1; i<=26; i++) {
        	alphabet.add(INITIAL_LETTER_UPPER_CASE);
        	alphabet.add(INITIAL_LETTER_LOWER_CASE);
        	INITIAL_LETTER_UPPER_CASE++; 
        	INITIAL_LETTER_LOWER_CASE++;
        	}
		}
	
	public String getAnagram(String text) {
		
		alphabetInit();
		
		if (text.isEmpty()) {
			return error;
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
		
		for (int i=0; i<strArray.length; i++) {
			flag = false;
			
			for (char ch : alphabet) {
				if(strArray[i] == ch) {
					flag = true;
					}
				}
			
			if (!flag) {
				newStr[i] = strArray[i];
				}
			else {
				if (strArray[i]!='\0') {
					setOfCharacters[lastIndex] = strArray[i];
					lastIndex--;
					}
				}
			}
		
		for	(char t: setOfCharacters) {
			if (t != '\0') {
				array.add(t);
				}
			}
		
		int index = 0;
		
		for (int i = 0; i<newStr.length; i++) {
			if (newStr[i] == '\0') {
				newStr[i] = array.get(index);
				index++;
				}
			}
		
		return String.valueOf(newStr);
		}
	}
