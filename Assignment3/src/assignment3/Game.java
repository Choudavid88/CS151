package assignment3;

import java.util.Scanner;

/**
*
* @author Hypnocode
* 3/8/2012
* this is a test
*/
public class Game
{
    
    private static Match aMatch;
    private static int rounds = 0;
    private static int calcType;
    
    public static void MainMenu()
    {
        Scanner scan = new Scanner(System.in);
        
        //Display logo and prompt for number of throws
        System.out.println("************************************");
        System.out.println("*    Rock Paper Scissors 2012      *");
        System.out.println("*            Hypnocode             *");
        System.out.println("************************************");
        System.out.println("\n\n\n\n\n");
        //System.out.println("Please enter the number of throws");
        //rounds = scan.nextInt();
        
        System.out.println("\033");
    }
    
    public static void main(String[] args)
    {
        MainMenu();

        try
        {
            rounds = Integer.parseInt(args[0]);
            //System.out.println(rounds + " = rounds");
        }
        catch (NumberFormatException expr)
        {
            System.out.println("Argument is not an integer.");
            System.out.println("One round selected.");
            rounds = 1;
        }
        
        try
        {
            calcType = Integer.parseInt(args[1]);
            //System.out.println(calcType + " = calcType");
        }
        catch (NumberFormatException expr)
        {
            System.out.println("Argument is not an integer.");
            System.out.println("Random Calculator selected");
            calcType = 0;
        }
        
        
        aMatch = new Match(rounds, calcType);
        
        while(!aMatch.isMatchOver())
        {
            aMatch.makeThrows();
        }
        
        aMatch.declareWinner();
    }

}

