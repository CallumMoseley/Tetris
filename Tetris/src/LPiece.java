import java.awt.Color;

public class LPiece extends Piece
{
	public LPiece(int x, int y)
	{
		super(x, y);
		coords = new int[][] { { 0, 1 }, { 1, 1 }, { 2, 1 }, { 2, 2 } };
		colour = Color.ORANGE;
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
