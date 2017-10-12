import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Hangman {

    public static void main (String[]args) throws IOException
    {
    	Scanner kb=new Scanner (System.in);
    	Scanner f = new Scanner (new File("hangmanwords.txt"));
    	boolean win = false;
    	boolean loss = false;
    	int wins = 0;
		int losses=0;
		int x=0;
		ArrayList<String> hangman = new ArrayList<String>();
			while (f.hasNext())
				hangman.add(f.next());

		while (hangman.size()!=0)
		{
			x++;
			System.out.println("\n\nROUND " +x);
			win=false;
			loss=false;

		ArrayList<String> alpha = new ArrayList<String>();
		alpha.clear();
			alpha.add("A"); alpha.add("B");
			alpha.add("C"); alpha.add("D");
			alpha.add("E"); alpha.add("F");
			alpha.add("G"); alpha.add("H");
			alpha.add("I"); alpha.add("J");
			alpha.add("K"); alpha.add("L");
			alpha.add("M"); alpha.add("N");
			alpha.add("O"); alpha.add("P");
			alpha.add("Q"); alpha.add("R");
			alpha.add("S"); alpha.add("T");
			alpha.add("U"); alpha.add("V");
			alpha.add("W"); alpha.add("X");
			alpha.add("Y"); alpha.add("Z");
		int rand = (int)(Math.random()*(hangman.size()));
		String word = hangman.get(rand);
		hangman.remove(rand);
		String line = "";
		for (int i=0; i<word.length(); i++)
			line = line+"_";
		int wrong = 0;

		do
		{
			if (wrong==0)
				zero();
			else if (wrong==1)
				one();
			else if (wrong==2)
				two();
			else if (wrong==3)
				three();
			else if (wrong==4)
				four();
			else if (wrong==5)
				five();
			else if (wrong==6)
				six();
			System.out.println("\n");
			for (int spacing = 0; spacing<line.length(); spacing++)
				System.out.print(line.substring(spacing,spacing+1)+" ");
			System.out.println("\n");
			System.out.println("Guess a word or one of the following letters:");
			System.out.println (alpha);
				String g = kb.next().toUpperCase();
			if (g.length()>1)
			{
				if (g.equals(word))
					win=true;
				else
				{
					loss=true;
					System.out.println("Nope");
				}
			}
			else if (g.length()==1)
			{
				if (!(alpha.contains(g)))
					System.out.println("Invalid guess.");
				else if (word.contains(g))
				{
					String temp=word;
					while (true)
					{
						int n = temp.indexOf(g);
						if (n==-1)
							break;
						line=line.substring(0,n)+g+line.substring(n+1);
						temp=temp.substring(n+1);
						for (int q=0; q<=n; q++)
							temp= " " +temp;
					}
					alpha.remove(g);
				}
				else
				{
					System.out.println("Nope");
					wrong++;
					alpha.remove(g);
				}
			if (!line.contains("_"))
				win=true;
			if (wrong==6)
				loss=true;
			}

		} while (!win && !loss);

		if (win)
		{
			System.out.println("You win! The word was " +word +"!");
			wins++;
		}
		else if (loss)
		{
			six();
			System.out.println("You lose! The word was " +word+"!");
			losses++;
		}


		}
		System.out.println("\nYAY you have completed the game! You have " +wins +" wins and " +losses +" losses.");

    }

    public static void zero ()
    {
    	System.out.println(" ______");
    	System.out.println(" |    |");
    	System.out.println("      |");
    	System.out.println("      |");
    	System.out.println("      |");
    	System.out.println("      |");
    	System.out.println("========");
    }

    public static void one ()
    {
    	System.out.println(" ______");
    	System.out.println(" |    |");
    	System.out.println(" O    |");
    	System.out.println("      |");
    	System.out.println("      |");
    	System.out.println("      |");
    	System.out.println("========");
    }

    public static void two ()
    {
    	System.out.println(" ______");
    	System.out.println(" |    |");
    	System.out.println(" O    |");
    	System.out.println(" |    |");
    	System.out.println("      |");
    	System.out.println("      |");
    	System.out.println("========");
    }

    public static void three ()
    {
    	System.out.println(" ______");
    	System.out.println(" |    |");
    	System.out.println(" O    |");
    	System.out.println("-|    |");
    	System.out.println("      |");
    	System.out.println("      |");
    	System.out.println("========");
    }

    public static void four ()
    {
    	System.out.println(" ______");
    	System.out.println(" |    |");
    	System.out.println(" O    |");
    	System.out.println("-|-   |");
    	System.out.println("      |");
    	System.out.println("      |");
    	System.out.println("========");
    }

    public static void five ()
    {
    	System.out.println(" ______");
    	System.out.println(" |    |");
    	System.out.println(" O    |");
    	System.out.println("-|-   |");
    	System.out.println("/     |");
    	System.out.println("      |");
    	System.out.println("========");
    }

    public static void six ()
    {
    	System.out.println(" ______");
    	System.out.println(" |    |");
    	System.out.println(" O    |");
    	System.out.println("-|-   |");
    	System.out.println(" /\\   |");
    	System.out.println("      |");
    	System.out.println("========");
    }



}