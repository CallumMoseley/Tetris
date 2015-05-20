import java.awt.Color;

public class OPiece extends Piece
{
	public OPiece(int x, int y)
	{
		super(x, y);
		coords = new int[][] {{1, 1}, {1, 2}, {2, 2}, {2, 1}};
		colour = Color.YELLOW;
	}
	
	public void rotateCW()
	{
		return;
	}

	public void rotateCCW()
	{
		return;
	}
}
