package assignment3;
/**
*
* @author Hypnocode
*/
public class Match
{
    private Human human = new Human();
    private Computer computer = new Computer();
    private int round;
    RequestType type = RequestType.TEXTREQUEST;
    
    public Match(int round)
    {
        this.round = round;
    }
    
    private void displayScores()
    {
        System.out.printf(""
                    + "%10s: %d\n"
                    + "%10s: %d\n"
                    , "You", human.getScore()
                    , "Computer", computer.getScore());
    }
    
    public void makeThrows()
    {
        CommandRequestor cr = CommandRequestor.makeRequestor(type);
        
        switch (cr.requestCommand())
        {
            case THROWROCK:
                human.setThrow(Throw.ROCK);
                break;
            case THROWPAPER:
                human.setThrow(Throw.PAPER);
                break;
            case THROWSCISSORS:
                human.setThrow(Throw.SCISSORS);
                break;
            case HELP:
                Help.displayHelp();
            case SCORE:
                displayScores();
                break;
            case QUIT:
                round = 0;
                break;
        }
        
        if (round > 0)
        {
            computer.makeThrow();
            human.compareThrows((Player) computer);
            round--;
        }
    }
    
    public void declareWinner()
    {
        System.out.println("Player 1 score = " + human.getScore());
        System.out.println("Player 2 score = " + computer.getScore());
        if(human.getScore() < computer.getScore())
        {
            System.out.println("The winner is Computer");
        }
        else if (human.getScore() > computer.getScore())
        {
            System.out.println("The winner is Player");
        }
        else
        {
            System.out.println("This game is tie");
        }
    }
    
    public boolean isMatchOver()
    {
        if(round < 1)
            return true;
        else
            return false;
    }
}

