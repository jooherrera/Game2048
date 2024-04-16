package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Component;

import java.awt.Button;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import game.Game;
import game.Game2048;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow {

	private JFrame mainFrame;
	private JPanel panel;
	private JLabel label_score;
	private Game game;
	private boolean showedLoseWindow;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainWindow() {
		game = new Game2048();
		showedLoseWindow = false;
		initialize(game);
	}

	private void initialize(Game game) {
		loadMainFrame();
		loadBoard();
		loadPointsLabel();
		loadLabelScore();
		loadTitle();
		loadNewGameButton();
	}

	void repaint() {
		mainFrame.remove(panel);
		loadBoard();
		mainFrame.repaint();
		mainFrame.getContentPane().requestFocus();
		label_score.setText(String.valueOf(game.getScore()));
	}

	Component updateBoard(List<List<Integer>> matriz) {
		JPanel panel = new JPanel();
		panel.setBounds(100, 100, 500, 450);
		panel.setLayout(null);

		int positionY = -50;

		for (int i = 0; i < matriz.size(); i++) {

			positionY += 100;
			int positionX = -40;

			for (int j = 0; j < matriz.get(i).size(); j++) {
				int cellValue = matriz.get(i).get(j);

				positionX += 103;

				JLabel label_cell = getLabelComponent();

				if (cellValue != 0) {
					label_cell.setText(String.valueOf(cellValue));
					label_cell.setBounds(positionX, positionY, 75, 75);
					label_cell.setFont(generateCellFont(cellValue));
					label_cell.setBackground(generateCellColor(cellValue));
					label_cell.setHorizontalAlignment(SwingConstants.CENTER);
					panel.add(label_cell);
				} else {
					label_cell.setBounds(positionX, positionY, 75, 75);
					label_cell.setBackground(new Color(98, 160, 234));
					panel.add(label_cell);
				}
			}
		}

		return panel;
	}

	private Font generateCellFont(int cellValue) {
		return new Font("Tahoma", Font.BOLD, 50 - (String.valueOf(cellValue).length() * 6));
	}

	private Color generateCellColor(int cellValue) {
		Color cellColor = null;

		if (cellValue <= 16) {
			cellColor = new Color(Math.min(98 + (cellValue * 10), 255), Math.max(160 - (cellValue * 4), 0),
					Math.max(234 - (cellValue * 8), 0)); // de azul a rojo
		} else if (cellValue <= 512) {
			cellColor = new Color(255 - (cellValue / 8), Math.min(cellValue * 2, 255), 0); // de rojo a amarillo
		} else {
			cellColor = new Color(Math.max(212 - (cellValue / 16), 0), 255, 0); // de amarillo a verde
		}

		return cellColor;
	}

	private void newGame() {
		game.newGame();
		showedLoseWindow = false;
		repaint();
	}

	private JLabel getLabelComponent() {
		JLabel label = new JLabel();
		label.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		label.setOpaque(true);
		return label;
	}

	private void checkGameStatus() {

		if (game.hasPlayerLose() && !game.hasPlayerWon()) {
			showedLoseWindow = true;
			EndGameDialog dialog = new EndGameDialog(mainFrame, "perdio");
			dialog.setLocationRelativeTo(mainFrame);
			dialog.setVisible(true);

			if (!dialog.accepted()) {
				return;
			}
			newGame();
			return;
		}

		if (game.hasPlayerWon() && !game.hasPlayerLose()) {
			if (game.wantPlayerContinue()) {
				return;
			}
			showedLoseWindow = true;
			EndGameDialog dialog = new EndGameDialog(mainFrame, "gano");
			dialog.setLocationRelativeTo(mainFrame);
			dialog.setVisible(true);

			if (!dialog.accepted()) {
				return;
			}

			game.continueGaming();
			showedLoseWindow = false;
			return;
		}

		if (game.hasPlayerWon() && game.hasPlayerLose()) {
			showedLoseWindow = true;
			EndGameDialog dialog = new EndGameDialog(mainFrame, "ganoyperdio");
			dialog.setLocationRelativeTo(mainFrame);
			dialog.setVisible(true);

			if (!dialog.accepted()) {
				return;
			}

			newGame();
			return;
		}

	}

	void loadMainFrame() {
		mainFrame = new JFrame();
		mainFrame.setAutoRequestFocus(false);
		mainFrame.getContentPane().setBackground(new Color(128, 128, 0));
		mainFrame.setTitle("Game 2048");
		mainFrame.setResizable(false);
		mainFrame.setBounds(00, 00, 800, 600);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		mainFrame.setFocusTraversalPolicy(
				new FocusTraversalOnArray(new Component[] { mainFrame.getContentPane(), panel }));
		mainFrame.getContentPane().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (showedLoseWindow) {
					return;
				}

				if (e.getKeyCode() == 39) {
					game.moveToRight();
				}

				if (e.getKeyCode() == 40) {
					game.moveToDwn();
				}

				if (e.getKeyCode() == 37) {
					game.moveToLeft();
				}

				if (e.getKeyCode() == 38) {
					game.moveToUp();
				}

				repaint();
				checkGameStatus();
			}
		});
	}

	void loadPointsLabel() {
		JTextField txtPuntos = new JTextField();
		txtPuntos.setHorizontalAlignment(SwingConstants.CENTER);
		txtPuntos.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPuntos.setBackground(new Color(192, 192, 192));
		txtPuntos.setText("Puntos");
		txtPuntos.setBounds(663, 66, 86, 20);
		txtPuntos.setColumns(10);
		mainFrame.getContentPane().add(txtPuntos);
	}

	void loadTitle() {
		JLabel title = new JLabel("2048");
		title.setFont(new Font("Tahoma", Font.BOLD, 55));
		title.setBounds(282, 32, 143, 56);
		mainFrame.getContentPane().add(title);
	}

	void loadBoard() {
		panel = (JPanel) updateBoard(game.getBoard());
		mainFrame.getContentPane().add(panel);
	}

	void loadNewGameButton() {
		Button button = new Button("Nueva Partida");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				newGame();
			}
		});
		button.setBackground(new Color(192, 192, 192));
		button.setFont(new Font("Dialog", Font.BOLD, 25));
		button.setActionCommand("Nueva Partida");
		button.setBounds(535, 17, 214, 37);
		mainFrame.getContentPane().add(button);
	}

	void loadLabelScore() {
		label_score = new JLabel("0");
		label_score.setOpaque(true);
		label_score.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		label_score.setHorizontalAlignment(SwingConstants.CENTER);
		label_score.setBackground(new Color(222, 221, 218));
		label_score.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_score.setBounds(663, 84, 86, 48);
		mainFrame.getContentPane().add(label_score);
	}
}
