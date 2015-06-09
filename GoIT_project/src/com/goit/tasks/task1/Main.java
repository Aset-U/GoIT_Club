package com.goit.tasks.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
       
        new Anagram(text);
    }
}
