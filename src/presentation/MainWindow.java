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
import java.awt.Component;
import java.awt.Panel;
import javax.swing.JEditorPane;
import java.awt.Button;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.eclipse.wb.swing.FocusTraversalOnArray;

public class MainWindow {

	private JFrame frmProg;
	private JTextField txtMejor;
	private JTextField textField;
	private JTextField textField_0;
	private JTextField textField_celda_11;
	private JTextField textField_celda_13;
	private JTextField textField_celda_14;
	private JTextField textField_celda_21;
	private JTextField textField_celda_22;
	private JTextField textField_celda_23;
	private JTextField textField_celda_12;
	private JTextField textField_celda_24;
	private JTextField textField_celda_31;
	private JTextField textField_celda_32;
	private JTextField textField_celda_33;
	private JTextField textField_celda_34;
	private JTextField textField_celda_44;
	private JTextField textField_celda_43;
	private JTextField textField_celda_42;
	private JTextField textField_celda_41;

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
		frmProg.setAutoRequestFocus(false);
		frmProg.getContentPane().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == 39)
				     System.out.println("flecha derecha");
				    
				    if(e.getKeyCode() == 40)
				     System.out.println("flecha abajo");
				    
				    if(e.getKeyCode() == 37)
				     System.out.println("flecha izquierda");

				    if(e.getKeyCode() == 38)
				     System.out.println("flecha up");
			}
		});

		frmProg.getContentPane().setBackground(new Color(128, 128, 0));
		frmProg.setTitle("prog");
		frmProg.setResizable(false);
		frmProg.setBounds(00, 00, 1300, 700);
		frmProg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProg.getContentPane().setLayout(null);
		
		JLayeredPane panel = new JLayeredPane();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBackground(new Color(64, 128, 128));
		panel.setBounds(317, 156, 452, 465);
		frmProg.getContentPane().add(panel);
		
		textField_celda_11 = new JTextField();
		textField_celda_11.setBounds(38, 32, 75, 75);
		panel.add(textField_celda_11);
		textField_celda_11.setFont(new Font("Tahoma", Font.BOLD, 40));
		textField_celda_11.setText(" 11");
		textField_celda_11.setBackground(new Color(192, 192, 192));
		textField_celda_11.setColumns(10);
		
		textField_celda_12 = new JTextField();
		textField_celda_12.setBounds(141, 32, 75, 75);
		panel.add(textField_celda_12);
		textField_celda_12.setText(" 12");
		textField_celda_12.setFont(new Font("Tahoma", Font.BOLD, 40));
		textField_celda_12.setColumns(10);
		textField_celda_12.setBackground(Color.LIGHT_GRAY);
		
		textField_celda_13 = new JTextField();
		textField_celda_13.setBounds(242, 32, 75, 75);
		panel.add(textField_celda_13);
		textField_celda_13.setText(" 13");
		textField_celda_13.setFont(new Font("Tahoma", Font.BOLD, 40));
		textField_celda_13.setColumns(10);
		textField_celda_13.setBackground(Color.LIGHT_GRAY);
		
		textField_celda_14 = new JTextField();
		textField_celda_14.setBounds(346, 32, 75, 75);
		panel.add(textField_celda_14);
		textField_celda_14.setText(" 14");
		textField_celda_14.setFont(new Font("Tahoma", Font.BOLD, 40));
		textField_celda_14.setColumns(10);
		textField_celda_14.setBackground(Color.LIGHT_GRAY);
		
		textField_celda_21 = new JTextField();
		textField_celda_21.setBounds(38, 140, 75, 75);
		panel.add(textField_celda_21);
		textField_celda_21.setText(" 21");
		textField_celda_21.setFont(new Font("Tahoma", Font.BOLD, 40));
		textField_celda_21.setColumns(10);
		textField_celda_21.setBackground(Color.LIGHT_GRAY);
		
		textField_celda_22 = new JTextField();
		textField_celda_22.setBounds(141, 140, 75, 75);
		panel.add(textField_celda_22);
		textField_celda_22.setText(" 22");
		textField_celda_22.setFont(new Font("Tahoma", Font.BOLD, 40));
		textField_celda_22.setColumns(10);
		textField_celda_22.setBackground(Color.LIGHT_GRAY);
		
		textField_celda_23 = new JTextField();
		textField_celda_23.setBounds(242, 140, 75, 75);
		panel.add(textField_celda_23);
		textField_celda_23.setText(" 23");
		textField_celda_23.setFont(new Font("Tahoma", Font.BOLD, 40));
		textField_celda_23.setColumns(10);
		textField_celda_23.setBackground(Color.LIGHT_GRAY);
		
		textField_celda_24 = new JTextField();
		textField_celda_24.setBounds(346, 140, 75, 75);
		panel.add(textField_celda_24);
		textField_celda_24.setText(" 24");
		textField_celda_24.setFont(new Font("Tahoma", Font.BOLD, 40));
		textField_celda_24.setColumns(10);
		textField_celda_24.setBackground(Color.LIGHT_GRAY);
		
		textField_celda_31 = new JTextField();
		textField_celda_31.setBounds(38, 249, 75, 75);
		panel.add(textField_celda_31);
		textField_celda_31.setText(" 31");
		textField_celda_31.setFont(new Font("Tahoma", Font.BOLD, 40));
		textField_celda_31.setColumns(10);
		textField_celda_31.setBackground(Color.LIGHT_GRAY);
		
		textField_celda_32 = new JTextField();
		textField_celda_32.setBounds(141, 249, 75, 75);
		panel.add(textField_celda_32);
		textField_celda_32.setText(" 32");
		textField_celda_32.setFont(new Font("Tahoma", Font.BOLD, 40));
		textField_celda_32.setColumns(10);
		textField_celda_32.setBackground(Color.LIGHT_GRAY);
		
		textField_celda_33 = new JTextField();
		textField_celda_33.setBounds(242, 249, 75, 75);
		panel.add(textField_celda_33);
		textField_celda_33.setText(" 33");
		textField_celda_33.setFont(new Font("Tahoma", Font.BOLD, 40));
		textField_celda_33.setColumns(10);
		textField_celda_33.setBackground(Color.LIGHT_GRAY);
		
		textField_celda_34 = new JTextField();
		textField_celda_34.setBounds(346, 249, 75, 75);
		panel.add(textField_celda_34);
		textField_celda_34.setText(" 34");
		textField_celda_34.setFont(new Font("Tahoma", Font.BOLD, 40));
		textField_celda_34.setColumns(10);
		textField_celda_34.setBackground(Color.LIGHT_GRAY);
		
		textField_celda_41 = new JTextField();
		textField_celda_41.setBounds(38, 356, 75, 75);
		panel.add(textField_celda_41);
		textField_celda_41.setText(" 41");
		textField_celda_41.setFont(new Font("Tahoma", Font.BOLD, 40));
		textField_celda_41.setColumns(10);
		textField_celda_41.setBackground(Color.LIGHT_GRAY);
		
		textField_celda_42 = new JTextField();
		textField_celda_42.setBounds(141, 356, 75, 75);
		panel.add(textField_celda_42);
		textField_celda_42.setText(" 42");
		textField_celda_42.setFont(new Font("Tahoma", Font.BOLD, 40));
		textField_celda_42.setColumns(10);
		textField_celda_42.setBackground(Color.LIGHT_GRAY);
		
		textField_celda_43 = new JTextField();
		textField_celda_43.setBounds(242, 356, 75, 75);
		panel.add(textField_celda_43);
		textField_celda_43.setText(" 43");
		textField_celda_43.setFont(new Font("Tahoma", Font.BOLD, 40));
		textField_celda_43.setColumns(10);
		textField_celda_43.setBackground(Color.LIGHT_GRAY);
		
		textField_celda_44 = new JTextField();
		textField_celda_44.setBounds(346, 356, 75, 75);
		panel.add(textField_celda_44);
		textField_celda_44.setText(" 44");
		textField_celda_44.setFont(new Font("Tahoma", Font.BOLD, 40));
		textField_celda_44.setColumns(10);
		textField_celda_44.setBackground(Color.LIGHT_GRAY);
		
		JTextField txtPuntos = new JTextField();
		txtPuntos.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPuntos.setBackground(new Color(192, 192, 192));
		txtPuntos.setText("    Puntos");
		txtPuntos.setBounds(663, 60, 86, 20);
		frmProg.getContentPane().add(txtPuntos);
		txtPuntos.setColumns(10);
		/*
		txtMejor = new JTextField();
		txtMejor.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtMejor.setBackground(new Color(192, 192, 192));
		txtMejor.setText("      Mejor");
		txtMejor.setBounds(788, 60, 86, 20);
		frmProg.getContentPane().add(txtMejor);
		txtMejor.setColumns(10);
		*/
		JLabel lblNewLabel = new JLabel("   320");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(663, 84, 86, 48);
		frmProg.getContentPane().add(lblNewLabel);
		/*
		JLabel lblNewLabel_1 = new JLabel("   320");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(788, 84, 86, 37);
		frmProg.getContentPane().add(lblNewLabel_1);
		*/
		JLabel lblNewLabel_2 = new JLabel("   2048");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblNewLabel_2.setBounds(317, 60, 256, 56);
		frmProg.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBackground(new Color(64, 128, 128));
		textField.setBounds(663, 60, 86, 72);
		frmProg.getContentPane().add(textField);
		textField.setColumns(10);
		/*
		textField_0 = new JTextField();
		textField_0.setBackground(new Color(64, 128, 128));
		textField_0.setBounds(788, 60, 86, 74);
		frmProg.getContentPane().add(textField_0);
		textField_0.setColumns(10);
		*/
		Button button = new Button("Nueva Partida");
		button.setBackground(new Color(192, 192, 192));
		button.setFont(new Font("Dialog", Font.BOLD, 25));
		button.setActionCommand("Nueva Partida");
		button.setBounds(660, 10, 214, 37);
		frmProg.getContentPane().add(button);
		frmProg.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{frmProg.getContentPane()}));
		
	}
}
