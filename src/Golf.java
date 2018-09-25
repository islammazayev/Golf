import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import islam.libs.ConsoleScann;


public class Golf {
	public static Scanner sc 				= new Scanner(System.in);
	static Random random 					= new Random();
	static ConsoleScann cscann 				= new ConsoleScann();
	static ArrayList<Shot> shotList 		= new ArrayList<Shot>();


	static public Double distanceToHole;
	public static int shotCountMax = 3;
	public static Double startVelocity;
	public static Double startAngle;
	public String statistics;
	static Double ballPosition = 0.0; 
	public Double tolerance = 0.1;
	public static String playAgain ;
	

	
	public static void main(String[] args) {
		
		
		
		
		DistanceToHole distToHole = new DistanceToHole();
		Double shotDistance = null;
			
		boolean stop = true;
		System.out.println("\t\tWelcome to the golf");
	
		while(stop) {
			
			distanceToHole = random.nextInt(200) + 200.0;
			shotCountMax = 7;
			ballPosition = 0.0;
			
			System.out.println("====================================================");
			boolean run = true;
			
			while(run) {
				
				
				System.out.println("Distance to hole is: " + distanceToHole);
				
				System.out.print("Input shot velocity between 1 - 55: ");
				startVelocity 													= cscann.inputNumber(1.0, 55.0);
				System.out.print("Input shot angle between 7 - 64: ");
				startAngle 														= cscann.inputNumber(7.0, 64.0);
				
				Shot shot 														= new Shot(startVelocity, startAngle);
				Double distance 												= shot.getDistance();	
				shotCountMax--;
				distanceToHole 													= DistanceToHole.newDistance(distance, distanceToHole);
				shotList.add(shot);

				System.out.println("Your ball bounce: "  + distance + " m " );
				System.out.println("Ball position to hole after shot is " + distanceToHole + " m ");
				System.out.println("You have " + shotCountMax + " shot left");
				
				if(distanceToHole < 0) {
					distanceToHole = (0 - distanceToHole);
				}

				if (shotCountMax == 0) {
					System.out.println("Game over!!! you have taken to many shots on this course");
					run = false;
				} else if (distanceToHole < - 200) {
					System.out.println("Game over");
					run = false;
				} else if(distanceToHole <= 0.1 && distanceToHole >= -0.1) {
					System.out.println("You won");
					run = false;
				} 
				
				System.out.println("-----------------------------------------------------");
			}
			
			int index = 0;

			for (Shot shot : shotList) {
				index++;
				System.out.println("Shot number: "+ index + " Shot length: "+ shot.getDistance());
			}
			
			System.out.println("Would you like to continue (yes/no)?");

			stop = false;
			playAgain 					= sc.nextLine().toLowerCase();
			if(playAgain.equals("yes")) {
				stop = true;
			} else {
				System.out.println("Program is close");
			}
		}
	}

	public String getStatistics() {
		statistics = ballPosition.toString();
		return statistics;
	}
	public Double getTolerance() {
		return tolerance;
	}
	public void setTolerance(Double tolerance) {
		this.tolerance = tolerance;
	}
	public Double getStartVelocity() {
		return startVelocity;
	}
	public void setStartVelocity(Double startVelocity) {
		this.startVelocity = startVelocity;
	}
	public Double getStartAngle() {
		return startAngle;
	}
	public void setStartAngle(Double startAngle) {
		this.startAngle = startAngle;
	}

}
