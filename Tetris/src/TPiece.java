import java.awt.Color;
import java.util.ArrayList;

public class TPiece extends Piece
{
	public TPiece(int x, int y)
	{
		super(x, y);
		coords = new int[][] {{0, 1}, {1, 1}, {1, 2}, {2, 1}};
		colour = Color.MAGENTA.darker().darker();
	}
}
