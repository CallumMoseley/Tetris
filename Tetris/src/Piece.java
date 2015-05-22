import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public abstract class Piece
{
	protected int x;
	protected int y;

	protected int[][] coords;
	protected int[][][] kicks;
	protected int turnVar;
	
	protected int rotation;

	protected Color colour;

	public Piece(int x, int y)
	{
		this.x = x;
		this.y = y;
		rotation = 0;

		kicks = new int[][][] { { { 0, 0 }, { -1, 0 }, { -1,  1 }, { 0, -2 }, { -1, -2 } } ,
				 			    { { 0, 0 }, {  1, 0 }, {  1, -1 }, { 0,  2 }, {  1,  2 } } ,
				 			    { { 0, 0 }, {  1, 0 }, {  1, -1 }, { 0,  2 }, {  1,  2 } } ,
				 			    { { 0, 0 }, { -1, 0 }, { -1,  1 }, { 0, -2 }, { -1, -2 } } ,
				 			    { { 0, 0 }, {  1, 0 }, {  1,  1 }, { 0, -2 }, {  1, -2 } } ,
				 			    { { 0, 0 }, { -1, 0 }, { -1, -1 }, { 0,  2 }, { -1,  2 } } ,
				 			    { { 0, 0 }, { -1, 0 }, { -1, -1 }, { 0,  2 }, { -1,  2 } } ,
				 			    { { 0, 0 }, {  1, 0 }, {  1,  1 }, { 0, -2 }, {  1, -2 } }};
		turnVar = 2;
	}

	public void fall()
	{
		y--;
	}

	public void drop(ArrayList<Piece> pieces)
	{
		while (!onGround(pieces))
		{
			fall();
		}
	}

	public boolean onGround(ArrayList<Piece> pieces)
	{
		for (int index = 0; index < 4; index++)
		{
			int[] blockPos = new int[] { coords[index][0] + x,
					coords[index][1] + y };

			if (blockPos[1] <= 1)
				return true;

			for (Piece p : pieces)
			{
				if (p != this)
				{
					for (int index2 = 0; index2 < 4; index2++)
					{
						int[][] coords2 = p.getCoords();
						int[] block2Pos = new int[] { coords2[index2][0],
								coords2[index2][1] };

						if (blockPos[0] == block2Pos[0]
								&& blockPos[1] - 1 == block2Pos[1])
						{
							return true;
						}
					}
				}
			}
		}

		return false;
	}
	
	public boolean coincides(int x, int y)
	{
		for (int i = 0; i < 4; i++)
		{
			int[] blockPos = new int[] { coords[i][0] + x, coords[i][1] + y };
			if (blockPos[0] == x && blockPos[1] == y)
			{
				return true;
			}
		}
		return false;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public int[][] getCoords()
	{
		return coords;
	}

	public void draw(Graphics g)
	{
		for (int index = 0; index < 4; index++)
		{
			int[] blockPos = new int[] { coords[index][0] + x,
					coords[index][1] + y };

			g.setColor(colour);
			g.fillRect(blockPos[0] * 16, 320 - blockPos[1] * 16, 16, 16);
		}
	}
	
	public void moveRight(ArrayList<Piece> board)
	{
		x++;
		if (checkCollision(board))
		{
			x--;
		}
	}
	
	public void moveLeft(ArrayList<Piece> board)
	{
		x--;
		if (checkCollision(board))
		{
			x++;
		}
	}

	public void rotateCW(ArrayList<Piece> board)
	{
		boolean positionFound = false;
		int kickIndex = Piece.kickIndex(rotation, (rotation + 1) % 4);
		int kickI = 0;
		for (int index = 0; index < 4; index++)
		{
			int temp = coords[index][0];
			coords[index][0] = coords[index][1];
			coords[index][1] = turnVar - temp;
		}
		while (!positionFound)
		{
			boolean collision = false;
			for (Piece p : board)
			{
				for (int i = 0; i < 4; i++)
				{
					int blockX = coords[i][0] + x + kicks[kickIndex][kickI][0];
					int blockY = coords[i][1] + y + kicks[kickIndex][kickI][1];
					
					if ((p != this && p.coincides(blockX, blockY)) || blockX < 0 || blockY < 1 || blockX > 9)
					{
						collision = true;
					}
				}
			}
			
			if (!collision)
			{
				x += kicks[kickIndex][kickI][0];
				y += kicks[kickIndex][kickI][1];
				positionFound = true;
			}
			else
			{
				kickI++;
			}
			if (kickI >= 5)
			{
				break;
			}
		}
		if (positionFound)
		{
			rotation = (rotation + 1) % 4;
		}
		else
		{
			for (int index = 0; index < 4; index++)
			{
				int temp = coords[index][0];
				coords[index][0] = turnVar - coords[index][1];
				coords[index][1] = temp;
			}
		}
	}

	public void rotateCCW(ArrayList<Piece> board)
	{
		boolean positionFound = false;
		int kickIndex = Piece.kickIndex(rotation, (rotation + 3) % 4);
		int kickI = 0;
		for (int index = 0; index < 4; index++)
		{
			int temp = coords[index][0];
			coords[index][0] = turnVar - coords[index][1];
			coords[index][1] = temp;
		}
		while (!positionFound)
		{
			boolean collision = false;
			for (Piece p : board)
			{
				for (int i = 0; i < 4; i++)
				{
					int blockX = coords[i][0] + x + kicks[kickIndex][kickI][0];
					int blockY = coords[i][1] + y + kicks[kickIndex][kickI][1];
					
					if ((p != this && p.coincides(blockX, blockY)) || blockX < 0 || blockY < 1 || blockX > 9)
					{
						collision = true;
					}
				}
			}
			
			if (!collision)
			{
				x += kicks[kickIndex][kickI][0];
				y += kicks[kickIndex][kickI][1];
				positionFound = true;
			}
			else
			{
				kickI++;
			}
			if (kickI >= 5)
			{
				break;
			}
		}
		if (positionFound)
		{
			rotation = (rotation + 3) % 4;
		}
		else
		{
			for (int index = 0; index < 4; index++)
			{
				int temp = coords[index][0];
				coords[index][0] = coords[index][1];
				coords[index][1] = turnVar - temp;
			}
		}
	}
	
	public boolean checkCollision(ArrayList<Piece> board)
	{
		for (int i = 0; i < 4; i++)
		{
			int blockX = coords[i][0] + x;
			int blockY = coords[i][1] + y;
			if (blockX < 0 || blockX > 9 || blockY < 1)
			{
				return true;
			}
			for (Piece p : board)
			{
				if (p != this && p.coincides(blockX, blockY))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public static int kickIndex(int from, int to)
	{
		if (from == 0)
		{
			return (to == 1) ? 0 : 7;
		}
		if (from == 1)
		{
			return (to == 0) ? 1 : 2;
		}
		if (from == 2)
		{
			return (to == 1) ? 3 : 4;
		}
		if (from == 3)
		{
			return (to == 2) ? 5 : 6;
		}
		return 0;
	}
}
