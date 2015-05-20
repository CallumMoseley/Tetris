import javax.swing.JFrame;

public class TetrisFrame extends JFrame
{
	private GamePanel game;
	
	public TetrisFrame()
	{
		super("Tetris");
		game = new GamePanel();
		setContentPane(game);
	}
	
	public static void main(String[] args)
	{
		TetrisFrame frame = new TetrisFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}
}
