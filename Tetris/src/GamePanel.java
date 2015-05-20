import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener
{
	private boolean running;

	private ArrayList<Piece> board;
	private Piece currentPiece;

	public GamePanel()
	{
		setPreferredSize(new Dimension(160, 320));
		addKeyListener(this);
		setFocusable(true);
		board = new ArrayList<Piece>();
		board.add(new SPiece(0, 18));
		
		Thread game = new Thread()
		{
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
			try
			{
				Thread.sleep(Math.max(
						1000 - (System.currentTimeMillis() - lastTick), 0));
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0)
	{
		if (arg0.getKeyCode() == KeyEvent.VK_SPACE)
		{
			boardTick();
		}
		repaint(0);
	}

	@Override
	public void keyReleased(KeyEvent arg0)
	{
	}

	@Override
	public void keyTyped(KeyEvent arg0)
	{
	}
}