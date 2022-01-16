package assignment;

import java.util.Scanner;

public class MultipleChoice {

	public static void main(String[] args) {
		
		String question = "What is the Capital of Pakistan?";
		String answer1 = "Karachi";
		String answer2 = "Lahor";
		String answer3 = "Islamabad";
		
		String correctAnswer = answer3;
		
		System.out.println(question);
		
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.next();
		//System.out.println(userInput);
		
		if(userInput.equalsIgnoreCase(correctAnswer)) {
			System.out.println("Congrats!");
		} else {
			System.out.println("Incorrect! The correct answer is " + correctAnswer);
				
			}
			
		

}
}

