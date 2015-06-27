package com.it_project.tasks.task3;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Divider {
	
	private List<Integer> multiplicationProducts = new ArrayList<Integer>();
	private List<Integer> periodProducts = new ArrayList<Integer>();
	private List<Integer> interimResults = new ArrayList<Integer>();
	private List<Integer> particles = new ArrayList<Integer>(); 
	private String drawing;
	
	public Divider(){}
	
	public String getResult(double d) {
		List<Character> list = new LinkedList<Character>();
		int indexPoint = String.valueOf(d).indexOf(".");
		char[] beforePoint = String.valueOf(d).substring(0, indexPoint).toCharArray(); 
		char[] afterPoint = String.valueOf(d).substring(indexPoint+1).toCharArray();
		char[]result = null;
		
		if (afterPoint.length > 10) {
			afterPoint = String.valueOf(d).substring(indexPoint+1, 11).toCharArray();
			
			int index = -1;
			if (afterPoint[0] == '0') {
				for (int i = 0; i<afterPoint.length; i++) {
					if (afterPoint[i] == '0') {
						index ++;
						}
					else break;
					}
				}
			else {
				index = 0;
				}
			
		char ch = afterPoint[index];
		int rIndex = String.valueOf(afterPoint).indexOf(ch, index+1);
		while (rIndex == -1) {
			ch = afterPoint[++index];
			rIndex = String.valueOf(afterPoint).indexOf(ch, index+1);
			}
		
		result = String.valueOf(afterPoint).substring(0, rIndex).toCharArray();
		}
		else {
			result = afterPoint;
			}
		
		for (char c : beforePoint) {
			list.add(c);
			}
		
		list.add('.');
		
		for (char c : result) {
			list.add(c);
			}
		
		result = new char[list.size()];
		
		for (int i=0; i<result.length; i++) {
			result[i] = list.get(i);
		}
		
		return String.valueOf(result);
	}
	
	public String getLongDivision (String number1, String number2)  {
		
		
		double divisible = Double.parseDouble(number1.toString());
		double divisor = Double.parseDouble(number2.toString());
		double didvisionResult = divisible/divisor;
		String dResult = getResult(didvisionResult);
		didvisionResult = Double.parseDouble(dResult);
		int indexPoint = String.valueOf(didvisionResult).indexOf(".");
		
		char[] res1 = String.valueOf(didvisionResult).substring(0, indexPoint).toCharArray(); 
		char[] res2 = String.valueOf(didvisionResult).substring(indexPoint+1).toCharArray();
		
		for (char c : res1) {
			int n = (int) ((c-'0')*divisor);
			multiplicationProducts.add(n); 
			}
		
		
		for (char c : res2) {
			int n = (int) ((c-'0')*divisor);
			if (n != 0){
				multiplicationProducts.add(n);
			}
			periodProducts.add(0);
		}

		char numbers[] = number1.toCharArray();
				
		for (char ch : numbers){
			int n = ch-'0';
			particles.add(n);
			}
		
		
		for ( int p : periodProducts) {
			particles.add(p);
			}
		particles.add(0); 
		
		runDivision();
		createDrawing(divisible, divisor, didvisionResult); 
		
		return drawing;
		}
	
	private void runDivision() {
		
		for (int i = 0; i<getMultiplicationProducts().size(); i++) {
			
			String interimResult = "";
			int product = getMultiplicationProducts().get(i);
			int size = String.valueOf(product).length();
			
			if (i == 0) {
				for (int j = 0; j<size; j++) {
					interimResult += particles.get(0);
					particles.remove(0);
					} 
				
				int number = Integer.parseInt(interimResult);
				
				if (number < product) {
					interimResult += particles.get(0);
					particles.remove(0);
					number = Integer.parseInt(interimResult);
				}
				
				int resultNumber = number - product;
				
				if (resultNumber > 0) {
					StringBuilder builder = new StringBuilder();
					builder.append(resultNumber);
					char[] resNum = builder.reverse().toString().toCharArray();
					
					for (char ch : resNum) {
						int c = ch-'0';
						particles.add(0, c);
						}
					}
				}
			else {
				for	(int j = 0; j<size; j++) {
					interimResult += particles.get(0);
					particles.remove(0);
					} 
				int number = Integer.parseInt(interimResult);
				
				if (number < product){
					interimResult += particles.get(0);
					particles.remove(0);
					number = Integer.parseInt(interimResult);
				}
				
				interimResults.add(number);
				int resultNumber = number - product;
				
				if (resultNumber > 0) {
					StringBuilder builder = new StringBuilder();
					builder.append(resultNumber);
					char[] resNum = builder.reverse().toString().toCharArray();
					
					for (char ch : resNum) {
						int c = ch-'0';
						particles.add(0, c);
						}
					}
				}
			}
	}
	
	private void createDrawing(double divisible, double divisor, double result) throws IndexOutOfBoundsException{
		
		int n1 = (int) divisible;
		int n2 = (int) divisor;
		
		int divisibleLength = String.valueOf(n1).length();
		int particleLength =  String.valueOf(getMultiplicationProducts().get(0)).length(); 
		int length = divisibleLength - particleLength;
		
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("  " + n1 + " | " + n2 + "\n");
		
		builder.append(" ");
		
		for (int i = 1; i <= divisibleLength; i++) {
			builder.append(" ");
		}
		
		builder.append("  |--------- \n");
		builder.append(" -" + getMultiplicationProducts().get(0));
		
		for (int i = 1; i <= length; i++) {
			builder.append(" ");
			}
		
		builder.append(" | " + result + "\n");
		builder.append(" ----" + "\n");
		
		String t = " ";
		
		for (int i = 1; i<getMultiplicationProducts().size(); i++) {
			if (getMultiplicationProducts().get(i) != 0) {
				try {
				builder.append(t + " " + getInterimResults().get(i-1) + "\n");
				builder.append(t + "-" + getMultiplicationProducts().get(i) + "\n");
				builder.append(t + "---- \n");
				t += " ";
				} catch (IndexOutOfBoundsException e) {
					builder.append(t + " " + getInterimResults().get(interimResults.size()-1) + "\n");
					builder.append(t + "-" + getMultiplicationProducts().get(i) + "\n");
					builder.append(t + "---- \n");
					t += " ";
					}
			  }
			}
			
		
		builder.append(" " + t + 0);
		drawing = builder.toString();
	}
	
	public List<Integer> getMultiplicationProducts() {
		return multiplicationProducts;
	}
	
	public List<Integer> getInterimResults() {
		return interimResults;
	}

}
