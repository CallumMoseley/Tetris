import java.awt.Color;
import java.util.ArrayList;

public class ZPiece extends Piece
{
	public ZPiece(int x, int y)
	{
		super(x, y);
		coords = new int[][] {{0, 2}, {1, 2}, {1, 1}, {2, 1}};
		colour = Color.RED;
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
