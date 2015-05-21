import java.awt.Color;
import java.util.ArrayList;

public class SPiece extends Piece
{
	public SPiece(int x, int y)
	{
		super(x, y);
		coords = new int[][] {{0, 1}, {1, 2}, {1, 1}, {2, 2}};
		colour = Color.GREEN;
	}
	
	public void rotateCW(ArrayList<Piece> board)
	{
		for (int index = 0; index < 4; index++)
		{
			int temp = coords[index][0];
			coords[index][0] = coords[index][1];
			coords[index][1] = 2 - temp;
		}
	}

	public void rotateCCW(ArrayList<Piece> board)
	{
		for (int index = 0; index < 4; index++)
		{
			int temp = coords[index][0];
			coords[index][0] = 2 - coords[index][1];
			coords[index][1] = temp;
		}
	}
}
