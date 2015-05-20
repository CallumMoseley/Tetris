import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public abstract class Piece
{
	protected int x;
	protected int y;

	protected int[][] coords;

	protected Color colour;

	public Piece(int x, int y)
	{
		this.x = x;
		this.y = y;
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

			if (blockPos[1] == 0)
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
			int[] blockPos = new int[] { coords[index][0] + x, coords[index][1] + y };
			
			g.setColor(colour);
			g.fillRect(blockPos[0] * 16, 320 - blockPos[1] * 16, 16, 16);
		}
	}

	public abstract void rotateCW();

	public abstract void rotateCCW();
}
