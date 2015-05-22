import java.awt.Color;
import java.util.ArrayList;

public class LPiece extends Piece
{
	public LPiece(int x, int y)
	{
		super(x, y);
		coords = new int[][] { { 0, 1 }, { 1, 1 }, { 2, 1 }, { 2, 2 } };
		colour = Color.ORANGE;
	}
}
