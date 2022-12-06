import java.util.*;

public class rockPaperScissors {

    public static int playerPoint = 0;
    public static int compPoint = 0;
    public static void main(String[] args) {

        char playStatus = 'y';

        Scanner console = new Scanner(System.in);

        while (playStatus == 'y') {

            System.out.println("Hello! Welcome to Rock Paper Scissors!");
            System.out.println();
            System.out.println("What would you like your name to be?");
           
            String name = console.next();
            
            System.out.println("Alrighty " + name + " lets choose how many round you want to play!");
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
                System.out.println("You won!");
            } else if(compPoint > playerPoint) {
                System.out.println("Too bad, better luck next time...");
            } else {
                System.out.println("The game tied...");
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

        int response = console.nextInt();
        
        if (response == 1) {
            System.out.println(name + " chose Rock");
        } else { if (response == 2) {
            System.out.println(name + " chose Paper");
        } else {
            System.out.println(name + " chose Scissors");
        }

        System.out.println(name + " chose: " + response);

        Random rand = new Random();

        int compMove = rand.nextInt(3) - 1;

        if (compMove == 1) {
            System.out.println("The computer chose Rock");
        } else if (compMove == 2) {
            System.out.println("The computer chose Paper");
        } else {
            System.out.println("The computer chose Scissors");
        }
        //int compMove = rand.nextInt(2) + 1  ;
        System.out.println("The computer chose: " + compMove);

        System.out.println();
        //System.out.println(determineRoundWinner(compMove, playerMove)); 
        System.out.println("player point: " + playerPoint);
        System.out.println("computer point: " + compPoint);
    }
    }

        public String determineRoundWinner (String compMove, String playerMove) {

            String statement = "";

            if (compMove.equals(playerMove)) {
                statement = "There was a tie.";
            } //Tie statement =

            if (compMove.equals("Rock") && playerMove.equals("Scissors")) {
                statement = "Better luck next time, the computer won...";
            } //Computer winner statement =
            if (compMove.equals("Paper") && playerMove.equals("Rock")) {
                statement = "Better luck next time, the computer won...";
            }
            if (compMove.equals("Scissors") && playerMove.equals("Paper")) {
                statement = "Better luck next time, the computer won...";
            }

            if (compMove.equals("Scissors") && playerMove.equals("Rock")) {
                statement = "Nice job, you won!";
            } //User winners statement =
            if (compMove.equals("Rock") && playerMove.equals("Paper")) {
                statement = "Nice job, you won!";
            }
            if (compMove.equals("Paper") && playerMove.equals("Scissors")) {
                statement = "Nice job, you won!";
            }

            return statement;
        }
    }


