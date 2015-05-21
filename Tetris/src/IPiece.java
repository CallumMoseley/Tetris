import java.awt.Color;
import java.util.ArrayList;

public class IPiece extends Piece
{
	public IPiece(int x, int y)
	{
		super(x, y);
		coords = new int[][] { { 0, 2 }, { 1, 2 }, { 2, 2 }, { 3, 2 } };
		kicks = new int[][][] { { { 0, 0 }, { -2, 0 }, {  1, 0 }, { -2, -1 }, {  1,  2 } } ,
				 			    { { 0, 0 }, {  2, 0 }, { -1, 0 }, {  2,  1 }, { -1, -2 } } ,
				 			    { { 0, 0 }, { -1, 0 }, {  2, 0 }, { -1,  2 }, {  2, -1 } } ,
				 			    { { 0, 0 }, {  1, 0 }, { -2, 0 }, {  1, -2 }, { -2,  1 } } ,
				 			    { { 0, 0 }, {  2, 0 }, { -1, 0 }, {  2,  1 }, { -1, -2 } } ,
				 			    { { 0, 0 }, { -2, 0 }, {  1, 0 }, { -2, -1 }, {  1,  2 } } ,
				 			    { { 0, 0 }, {  1, 0 }, { -2, 0 }, {  1, -2 }, { -2,  1 } } ,
				 			    { { 0, 0 }, { -1, 0 }, {  2, 0 }, { -1,  2 }, {  2, -1 } } };
		colour = Color.CYAN;
	}

	public void rotateCW(ArrayList<Piece> board)
	{
		boolean positionFound = false;
		while (!positionFound)
		{
			for (int index = 0; index < 4; index++)
			{
				int temp = coords[index][0];
				coords[index][0] = coords[index][1];
				coords[index][1] = 3 - temp;
			}
			
			for (Piece p : board)
			{
				
			}
		}
	}

	public void rotateCCW(ArrayList<Piece> board)
	{
		for (int index = 0; index < 4; index++)
		{
			int temp = coords[index][0];
			coords[index][0] = 3 - coords[index][1];
			coords[index][1] = temp;
		}
	}
}