import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener
{
	private static final int MOVE_DELAY = 10000000;
	
	private boolean running;
	private ArrayList<Piece> board;
	private Piece currentPiece;
	private boolean[] keys;
	
	private int moveDelay;

	public GamePanel()
	{
		setPreferredSize(new Dimension(160, 320));
		addKeyListener(this);
		setFocusable(true);

		keys = new boolean[KeyEvent.KEY_LAST + 1];
		moveDelay = 0;
		
		board = new ArrayList<Piece>();
		Piece p = new LPiece(0, 10);
		currentPiece = p;
		board.add(p);
		
		Thread game = new Thread() {
			@Override
			public void run()
			{
				gameLoop();
			}
		};
		game.start();
	}

	public void boardTick()
	{
		for (Piece p : board)
		{
			if (!p.onGround(board))
			{
				p.fall();
			}
		}
	}

	public void paintComponent(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 160, 320);
		for (Piece p : board)
		{
			p.draw(g);
		}
	}

	public void gameLoop()
	{
		long lastTick = System.currentTimeMillis();
		while (true)
		{
			if (keys[KeyEvent.VK_UP])
			{
				currentPiece.drop(board);
			}
			if (keys[KeyEvent.VK_DOWN])
			{
				boardTick();
			}
			if (keys[KeyEvent.VK_RIGHT] && moveDelay == 0)
			{
				currentPiece.moveRight(board);
				moveDelay = MOVE_DELAY;
			}
			if (keys[KeyEvent.VK_LEFT] && moveDelay == 0)
			{
				currentPiece.moveLeft(board);
				moveDelay = MOVE_DELAY;
			}
			if (keys[KeyEvent.VK_Z])
			{
				currentPiece.rotateCW(board);
			}
			if (keys[KeyEvent.VK_X])
			{
				currentPiece.rotateCCW(board);
			}
			
			if (moveDelay > 0)
			{
				moveDelay--;
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0)
	{
		keys[arg0.getKeyCode()] = true;
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0)
	{
		keys[arg0.getKeyCode()] = false;
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent arg0)
	{
	}
}