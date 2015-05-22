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
}
