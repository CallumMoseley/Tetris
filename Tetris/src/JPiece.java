import java.awt.Color;
import java.util.ArrayList;

public class JPiece extends Piece
{
	public JPiece(int x, int y)
	{
		super(x, y);
		coords = new int[][] {{0, 1}, {0, 2}, {1, 1}, {2, 1}};
		colour = Color.BLUE;
	}
}
