package planning.vue.reservation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import planning.metier.Creneau;
import planning.metier.TrancheHoraire;

public class CreneauJPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private TrancheHoraire heure;
	private List<Creneau> listCreneau;
	private ReservationJoueurFrame mainFrame;
	private Connection connection;
	
	public CreneauJPanel(TrancheHoraire heure, List<Creneau> listCreneau, Connection connection, ReservationJoueurFrame mainFrame) {
		this.heure = heure;
		this.listCreneau = listCreneau;
		this.connection = connection;
		this.mainFrame = mainFrame;
		this.createPanel();
	}
	
	public void updatePanel() {
		this.removeAll();
		this.revalidate();
		this.repaint();
		this.createPanel();
		System.out.println("refresh");
	}
	
	private void createPanel() {
		if (listCreneau.size() == 0) {
			setMinimumSize(new Dimension(500, 0));
			setMaximumSize(new Dimension(500, 0));
		} else {
			setMinimumSize(new Dimension(500, 120));
			setMaximumSize(new Dimension(500, 120));
			setBorder(new LineBorder(new Color(0, 0, 0)));
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
			Component verticalStrut_1 = Box.createVerticalStrut(20);
			add(verticalStrut_1);
			
			String label = this.heure.getHeureDebut() + "H - " + (this.heure.getHeureDebut() + 2) + "H";
			JLabel lblNewLabel = new JLabel(label);
			lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			add(lblNewLabel);
			
			Component verticalStrut = Box.createVerticalStrut(20);
			add(verticalStrut);
			
			JPanel ButtonPanel = new JPanel();		
			for (Creneau creneau : listCreneau) {
				ReservationJButton button = new ReservationJButton(creneau, connection, mainFrame);
				
				ButtonPanel.add(button);
			}
			add(ButtonPanel);
		}
		

	}
}
