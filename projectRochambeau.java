//gijsie 1
//December 5 2022

import java.util.*;

public class projectRochambeau {

    public enum GameMove {
        Rock,
        Paper,
        Scissors
    }

    public static int playerPoint = 0;
    public static int compPoint = 0;
    public static int tie = 0;
    public static int gameNum = 0;

    public static void main(String[] args) {

        char playStatus = 'y';

        while(playStatus == 'y') {

        Scanner console = new Scanner(System.in);

        playerPoint = 0;
        compPoint = 0;

            System.out.println("Hello! Welcome to Rock Paper Scissors!");

            gameNum++;
            System.out.println("This is game number " + gameNum);
            System.out.println();
            System.out.println("What would you like your name to be?");
           
            String name = console.next();
            
            System.out.println("That's a great name, " + name + ". Now lets choose how many rounds you want to play!");
            System.out.println();

            int round = getRounds(console);
            
            while(round == -1) {
                round = getRounds(console);
            }
            
            System.out.println();

            for (int i = 0; i < round; i++) {
                games (name, console);
            }
        
            if(playerPoint > compPoint) {
                System.out.println("\nYou won!");
            } else if(compPoint > playerPoint) {
                System.out.println("\nToo bad, better luck next time...");
            } else {
                System.out.println("\nThe game tied...");
            }

            System.out.println();
            System.out.println("Would you like to play again? (y/n)");
            
            String response = console.next();
        
            if(response.equals("yes") || response.equals("y")) {
                playStatus = 'y';
            } else {playStatus = 'n';
        }
        
    }  
}
    
    public static int getRounds(Scanner console){
        
        System.out.println("How many round do you want to play? 3 or 5");
        
        String rounds = console.next();
        
        int round = 0;
        
        //I was testing with a try/catch loop so if the input does not match the given options, the program will ask the user to input the correct value.
        try {
            round = Integer.parseInt(rounds);
            if(round !=3 && round != 5) {
                throw new Exception();
            }
        }
        
        catch (Exception e) {
            System.out.println("Incorrect input, please enter the value again");
            round = -1;
        }

        return round;
    }

    public static void games(String name, Scanner console) {
        
        System.out.println("Lets Play");
        System.out.println();
        System.out.println(name + " please remember that Rock is 1, Paper is 2, and Scissors is 3.");
        System.out.println();
        System.out.println(name + " choose your move: [1]  [2]  [3]");

        GameMove response = GameMove.values()[console.nextInt() - 1];

        System.out.println(name + " chose: " + response.toString());

        Random rand = new Random();

        GameMove compMove = GameMove.values()[rand.nextInt(3)];

        System.out.println("The computer chose: " + compMove.toString());

        System.out.println();
        System.out.println(determineRoundWinner(compMove, response)); 
        System.out.println("player point: " + playerPoint);
        System.out.println("computer point: " + compPoint);
        System.out.println("ties: " + tie);
    }
    
    public static String determineRoundWinner (GameMove compMove, GameMove playerMove) {

        String statement = "";

        if (compMove == playerMove) {
            statement = "There was a tie.\n";
            tie++;
        } 
        if(compMove == GameMove.Scissors && playerMove == GameMove.Rock) {
            statement = "Nice job, you won!\n";
            playerPoint++;
        } 
        else if(playerMove == GameMove.Scissors && compMove == GameMove.Rock) {
            statement = "Better luck next time, the computer won...\n";
            compPoint++;
        }
        else if(compMove.compareTo(playerMove) > 0) {
            statement = "Better luck next time, the computer won...\n";
            compPoint++;            
        }                   
        else if(playerMove.compareTo(compMove) > 0) {
            statement = "Nice job, you won!\n";
            playerPoint++;
            }            
        return statement;
    }
}


