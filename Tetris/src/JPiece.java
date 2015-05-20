import java.awt.Color;

public class JPiece extends Piece
{
	public JPiece(int x, int y)
	{
		super(x, y);
		coords = new int[][] {{0, 1}, {0, 2}, {1, 1}, {2, 1}};
		colour = Color.BLUE;
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
