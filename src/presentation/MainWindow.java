package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Component;
import java.awt.Panel;
import javax.swing.JEditorPane;
import java.awt.Button;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import game.Board;
import game.Cell;
import game.Game;
import game.Game2048;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow {

	private JFrame frmProg;
	private JTextField txtMejor;
	private JTextField textField;
	private JTextField textField_0;
	private JLabel label_cell;
	private JPanel panel;
	private Button button;
	private Game game;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmProg.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		game = new Game2048();
		initialize(game);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Game game) {
		
		
		frmProg = new JFrame();
		frmProg.setAutoRequestFocus(false);

		panel = updateBoard(game.getBoard());
		frmProg.getContentPane().add(panel);
	
		
		frmProg.getContentPane().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 39) {		
					frmProg.remove(panel);
					game.moveToRight();
					repaint();
					System.out.println("flecha derecha");
				}

				if (e.getKeyCode() == 40) {
					frmProg.remove(panel);
					game.moveToDwn();
					repaint();
					System.out.println("flecha abajo");
				}


				if (e.getKeyCode() == 37) {
					frmProg.remove(panel);
					game.moveToLeft();
					repaint();
					System.out.println("flecha izquierda");

				}

				if (e.getKeyCode() == 38) {
					frmProg.remove(panel);
					game.moveToUp();
					repaint();
					System.out.println("flecha up");

				}
				
				if(game.hasPlayerLose()) {
					System.out.println("Juego finalizado");
				}
			}
		});

		frmProg.getContentPane().setBackground(new Color(128, 128, 0));
		frmProg.setTitle("prog");
		frmProg.setResizable(false);
		frmProg.setBounds(00, 00, 800, 600);
		frmProg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProg.getContentPane().setLayout(null);

		
		frmProg.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { frmProg.getContentPane(), panel }));

		

		JTextField txtPuntos = new JTextField();
		txtPuntos.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPuntos.setBackground(new Color(192, 192, 192));
		txtPuntos.setText("    Puntos");
		txtPuntos.setBounds(663, 60, 86, 20);
		frmProg.getContentPane().add(txtPuntos);
		txtPuntos.setColumns(10);

		JLabel lblNewLabel = new JLabel(String.valueOf(game.getScore()));
		lblNewLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(98, 160, 234));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(663, 84, 86, 48);
		frmProg.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("2048");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblNewLabel_2.setBounds(310, 32, 143, 56);
		frmProg.getContentPane().add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBackground(new Color(64, 128, 128));
		textField.setBounds(663, 60, 86, 72);
		frmProg.getContentPane().add(textField);
		textField.setColumns(10);

		button = new Button("Nueva Partida");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				game.newGame();
				frmProg.remove(panel);
				repaint();
				

			}
		});
		button.setBackground(new Color(192, 192, 192));
		button.setFont(new Font("Dialog", Font.BOLD, 25));
		button.setActionCommand("Nueva Partida");
		button.setBounds(535, 17, 214, 37);
		frmProg.getContentPane().add(button);

	}
	
	
	void repaint(){

		panel = updateBoard(game.getBoard());
		frmProg.getContentPane().add(panel);
		frmProg.repaint();
		frmProg.getContentPane().requestFocus();

		System.out.println(game.getBoard());
	}
	
	JPanel updateBoard(List<List<Integer>> matriz){
		

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

				label_cell = new JLabel(String.valueOf(cellValue));
				label_cell.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				label_cell.setBounds(positionX, positionY, 75, 75);
				label_cell.setFont(new Font("Tahoma", Font.BOLD, 40));
				label_cell.setOpaque(true);
				label_cell.setBackground(new Color(98, 160, 234));
				label_cell.setHorizontalAlignment(SwingConstants.CENTER);

				panel.add(label_cell);
			}
		}
		
		return panel;
	}
	
	
}
