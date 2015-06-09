package com.goit.tasks.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
    	String wellcom = "Please enter your text";
    	System.out.println(wellcom);
    	Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
       
        AnagramAction myAnagram = new AnagramAction();
        String anagram = myAnagram.getAnagram(text);
        
        System.out.println(anagram);
    }
}
