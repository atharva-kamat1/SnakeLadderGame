package MyProjects;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


class Dice
{
	private int top;
	Random rand;
	
	public Dice()
	{
		rand = new Random();
	}
	int rollDice()
	{
		top = rand.nextInt(1, 7);
		return top;
	}
	int getTop()
	{
		return top;
	}
}

public class SnakeLadder
{
	
	HashMap<Integer, Integer> isSnake = new HashMap<Integer, Integer>(0);
	HashMap<Integer, Integer> isLadder = new HashMap<Integer, Integer>(0);
	private int position;
	private Dice dice;
	
	public SnakeLadder()
	{
		position = 0;
		dice = new Dice();
		
		// initializing Ladder map
			isLadder.put(4, 25);
			isLadder.put(21, 39);
			isLadder.put(29, 74);
			isLadder.put(43, 76);			
			isLadder.put(63, 80);			
			isLadder.put(71, 89);			
			
		// initializing snake map	
			isSnake.put(30, 7);
			isSnake.put(47, 15);
			isSnake.put(56, 19);
			isSnake.put(73, 51);
			isSnake.put(82, 42);
			isSnake.put(92, 75);
			isSnake.put(98, 55);
	}
	
	public boolean won() {
		if (position >= 100) {
			return true;
		}
		return false;
	}
	
	public int getDice()
	{
		return dice.getTop();
	}
	
	public int getPosition() {
		return position;
	}
	
	public void playMove()
	{
		position += dice.rollDice();
	}
	
	public boolean ladderHit()
	{
		if (isLadder.containsKey(position))
		{
			int change = isLadder.get(position);
			position = change;
			return true;
		}
		return false;
	}
	
	public boolean snakeHit()
	{
		if (isSnake.containsKey(position))
		{
			int change = isSnake.get(position);
			position = change;
			return true;
		}
		return false;
	}
	
	public void showSnake()
	{
		System.out.println("snakes = " + isSnake);
	}
	
	public void showLadder()
	{
		System.out.println("ladders = " + isLadder);
	}
	
	public static void main(String[] args)
	{
		SnakeLadder board = new SnakeLadder();
		Scanner sc = new Scanner(System.in);
		int move = 1;
		
		System.out.println("initializing game...\n");
		System.out.println("-----RULES-----");
		System.out.println("type 0 to exit and 1 to roll the dice");
		System.out.println("type 3 to show all the ladders and 6 to show all the snakes");
		System.out.println("each pair is separated with a comma");
		System.out.println("the values will be displayed with '=' sign");
		System.out.println("values to the left of '=' are positions where snake or ladder is located");
		System.out.println("values to the right of '=' are positions where you will land\n");
		
		
		while (true)
		{
			move = sc.nextInt();
			if (move == 0)
			{
				break;
			}
			if (move == 3)
			{
				board.showLadder();
				continue;
			}
			if (move == 6)
			{
				board.showSnake();
				continue;
			}
			else
			{
				board.playMove();
				System.out.println("dice = " + board.getDice());
				System.out.println("new position  " + board.getPosition());	
				if (board.snakeHit())
				{
					System.out.println("oops snake bite you!");
					System.out.println("new position = " + board.getPosition());
				}
				if (board.ladderHit())
				{
					System.out.println("hurray you got ladder!");
					System.out.println("new position = " + board.getPosition());
				}
			}
			if (board.won())
			{
				System.out.println("------  you won  ------");
				break;
			}
		}
		sc.close();
		System.out.println("exit game");
	}
}