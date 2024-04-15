package presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class EndGameDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private boolean response;

	
	public EndGameDialog(JFrame owner, String status) {
		super(owner, "End Game", true);
		setResizable(false);
		setAutoRequestFocus(false);
		setBounds(100, 100, 383, 169);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		createPopUp(status);
	
	}
	
	private void createPopUp(String estado){
		if(estado.equals("gano")){
			String txt = "Felicidades, ganaste";
			String txt2 = "¿Quieres seguir jugando?";
			showGameOver(txt, txt2);
		}
		if(estado.equals("perdio")){
			String txt = "Fin del juego";
			String txt2 = "¿Quieres jugar de nuevo?";
			showGameOver(txt, txt2);
		}
		if(estado.equals("ganoyperdio")){
			String txt = "Ganaste y luego perdiste :(";
			String txt2 = "¿Quieres jugar de nuevo?";
			showGameOver(txt, txt2);
		}
	}

	private void showGameOver(String finDeJuego, String pregunta){

		{
			JButton okButton = new JButton("OK");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					response = true;
					dispose();
				}
			});
			okButton.setBounds(113, 96, 52, 27);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					response = false;
					dispose();
				}
			});
			cancelButton.setBounds(212, 96, 74, 27);
			contentPanel.add(cancelButton);
			cancelButton.setActionCommand("Cancel");
		}
		{
			JLabel lblNewLabel = new JLabel(finDeJuego);
			lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
			lblNewLabel.setBounds(100, 22, 205, 25);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblQuieresVolverA = new JLabel(pregunta);
			lblQuieresVolverA.setBounds(123, 62, 174, 17);
			contentPanel.add(lblQuieresVolverA);
		}
	}

	boolean accepted() {
		return response == true;
	}

}

