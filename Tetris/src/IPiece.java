import java.awt.Color;

public class IPiece extends Piece
{
	public IPiece(int x, int y)
	{
		super(x, y);
		coords = new int[][] { { 0, 2 }, { 1, 2 }, { 2, 2 }, { 3, 2 } };
		colour = Color.CYAN;
	}

	public void rotateCW()
	{
		for (int index = 0; index < 4; index++)
		{
			int temp = coords[index][0];
			coords[index][0] = coords[index][1];
			coords[index][1] = 3 - temp;
		}
	}

	public void rotateCCW()
	{
		for (int index = 0; index < 4; index++)
		{
			int temp = coords[index][0];
			coords[index][0] = 3 - coords[index][1];
			coords[index][1] = temp;
		}
	}
}