import java.awt.Color;

public class TPiece extends Piece
{
	public TPiece(int x, int y)
	{
		super(x, y);
		coords = new int[][] {{0, 1}, {1, 1}, {1, 2}, {2, 1}};
		colour = Color.MAGENTA;
	}
	
	public void rotateCW()
	{
		for (int index = 0; index < 4; index++)
		{
			int temp = coords[index][0];
			coords[index][0] = coords[index][1];
			coords[index][1] = 2 - temp;
		}
	}

	public void rotateCCW()
	{
		for (int index = 0; index < 4; index++)
		{
			int temp = coords[index][0];
			coords[index][0] = 2 - coords[index][1];
			coords[index][1] = temp;
		}
	}
}
