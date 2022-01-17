package planning.vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import planning.dao.ReservationDaoSql;
import planning.dao.interfacedao.IReservationDAO;
import planning.metier.Creneau;
import planning.metier.Reservation;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class NomReservation extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNom;
	private Creneau creneau;
	private IReservationDAO reservationDAO;
	private ReservationJoueur mainFrame;

	public NomReservation(Creneau creneau, Connection connection, ReservationJoueur mainFrame) {
		this.creneau = creneau;
		this.mainFrame = mainFrame;
		this.reservationDAO = new ReservationDaoSql();
		this.reservationDAO.setConnection(connection);
		createPanel();
	}

	private void createPanel() {
		setTitle("R\u00E9server un entrainement");
		setBounds(100, 100, 477, 215);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		String label = creneau.getJour() + " - " + creneau.getTranche() + " - " + creneau.getCourt();
		JLabel lblEntrezUnNom = new JLabel(label);
		lblEntrezUnNom.setBounds(10, 11, 441, 34);
		lblEntrezUnNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrezUnNom.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPanel.add(lblEntrezUnNom);

		txtNom = new JTextField();
		txtNom.setToolTipText(creneau.toString());
		txtNom.setBounds(75, 90, 304, 28);
		contentPanel.add(txtNom);
		txtNom.setColumns(10);

		JLabel lblNewLabel = new JLabel("Entrez un nom pour la r\u00E9servation :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(75, 62, 252, 17);
		contentPanel.add(lblNewLabel);

		JPanel buttonPane = new JPanel();
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton okButton = new JButton("Valider");
		okButton.setActionCommand("Valider");
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nomJoueur = txtNom.getText();
				Reservation reservation = new Reservation(creneau, nomJoueur);
				reservationDAO.addReservation(reservation);
				// mettre � jour l'affichage de la page principale
				mainFrame.updatePanel();
				
				
				
				dispose();
			}
		});
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Annuler");
		cancelButton.setActionCommand("Annuler");
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		buttonPane.add(cancelButton);
	}
}
