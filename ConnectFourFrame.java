import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConnectFourFrame extends JPanel {

	Board board = new Board();
	int startX = 125;
	int startY = 100;
	int width = 61;
	int turn = board.getMovesMade();
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int temp = startX;
		for(int row = 0; row < board.getROWS(); row++) {
			for(int column = 0; column < board.getCOLUMNS(); column++) {
				if(board.getBoard()[row][column] == ' ') {
					g.setColor(Color.BLACK);
					g.fillOval(startX, startY, width, width);		
				}
				if(board.getBoard()[row][column] == 'r') {
					g.setColor(Color.RED);
					g.fillOval(startX, startY, width, width);		
				}
				if(board.getBoard()[row][column] == 'y') {
					g.setColor(Color.YELLOW);
					g.fillOval(startX, startY, width, width);		
				}
				
				 startX += width;
			}
			startX = temp;
			startY += width;
		}
		g.setColor(Color.BLACK);
		if(board.isWinningBoard()) {
			if(board.getMoves()%2 == 0)
				g.drawString("Player " + 2 + "Wins!", 10, 500);
			else
				g.drawString("Player " + 1 + "Wins!", 10, 500);
		}
		startY = 100;
		
		
		
		if(board.getMoves()%2==0) {
			g.drawString("Red's Turn", 600, 100);
		}else {
			g.drawString("Yellow's Turn", 600, 100);
		}
		
	}
	
	
	
	public ConnectFourFrame() {
		setLayout(null);
		
		JButton btnHi = new JButton("1");
		btnHi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(board.getMovesMade()%2==0) {
					board.makeMove('r', 0);
				} else {
					board.makeMove('y', 0);
				}
				
				repaint();
				
			}
		});
		btnHi.setBounds(130, 52, 59, 21);
		add(btnHi);
		
		JButton button = new JButton("2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(board.getMovesMade()%2==0) {
					board.makeMove('r', 1);
				} else {
					board.makeMove('y', 1);
				}
				
				repaint();
			}
		});
		button.setBounds(189, 52, 59, 21);
		add(button);
		
		JButton button_1 = new JButton("3");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(board.getMovesMade()%2==0) {
					board.makeMove('r', 2);
				} else {
					board.makeMove('y', 2);
				}
				
				repaint();
			}
		});
		button_1.setBounds(249, 52, 59, 21);
		add(button_1);
		
		JButton button_2 = new JButton("4");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(board.getMovesMade()%2==0) {
					board.makeMove('r', 3);
				} else {
					board.makeMove('y', 3);
				}
				
				repaint();
			}
		});
		button_2.setBounds(309, 52, 59, 21);
		add(button_2);
		
		JButton button_3 = new JButton("5");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(board.getMovesMade()%2==0) {
					board.makeMove('r', 4);
				} else {
					board.makeMove('y', 4);
				}
				
				repaint();
			}
		});
		button_3.setBounds(369, 52, 59, 21);
		add(button_3);
		
		JButton button_4 = new JButton("6");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(board.getMovesMade()%2==0) {
					board.makeMove('r', 5);
				} else {
					board.makeMove('y', 5);
				}
				
				repaint();
			}
		});
		button_4.setBounds(428, 52, 59, 21);
		add(button_4);
		
		JButton button_5 = new JButton("7");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(board.getMovesMade()%2==0) {
					board.makeMove('r', 6);
				} else {
					board.makeMove('y', 6);
				}
				
				repaint();
			}
		});
		button_5.setBounds(486, 52, 59, 21);
		add(button_5);

		
	}
}
