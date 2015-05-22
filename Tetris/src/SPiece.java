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
}
