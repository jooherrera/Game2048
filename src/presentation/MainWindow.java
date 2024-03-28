package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainWindow {

	private JFrame frmProg;

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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProg = new JFrame();
		frmProg.setTitle("prog");
		frmProg.setResizable(false);
		frmProg.setBounds(100, 100, 450, 300);
		frmProg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProg.getContentPane().setLayout(null);
		
		JLabel lblHolaMundo = new JLabel("Hola mundo!!");
		lblHolaMundo.setBounds(46, 42, 89, 17);
		frmProg.getContentPane().add(lblHolaMundo);
	}
}
