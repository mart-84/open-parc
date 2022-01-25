package planning.vue.organisation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import planning.dao.interfacedao.IEquipeDAO;
import planning.dao.sql.EquipeDaoSql;
import planning.metier.Equipe;

public class MatchDoubleComponent extends MatchComponent {

	private List<Equipe> listEquipeMatch;
	private IEquipeDAO equipeDAO;

	public MatchDoubleComponent(Connection connection, PlanningOrga mainFrame) {
		super(connection, mainFrame);
		this.equipeDAO = new EquipeDaoSql();
		equipeDAO.setConnection(connection);
	}

	protected void setData() {
		match = matchDAO.getById(this.idMatch);
		listArbitres = arbitreDAO.getArbitres();

		listEquipeMatch = equipeDAO.getByMatch(match);
		arbitre = arbitreDAO.getByMatch(this.match);

		createPanel();
	}

	protected void addOnClickListener(Connection connection, PlanningOrga mainFrame) {
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (!matchDAO.isTermine(match)) {
					FormulaireInfosMatch form;
					if (matchDAO.isPremierTour(match)) {
						form = new FormulaireMatchDoubleAvecJoueurJFrame(match, joueursMatch, arbitre, listJoueurs,
								listArbitres, connection, mainFrame);
					} else {
						form = new FormulaireMatchDoubleJFrame(match, joueursMatch, arbitre, listJoueurs, listArbitres,
								connection, mainFrame);
					}
					form.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(MatchDoubleComponent.this,
							"Vous ne pouvez plus modifier les informations d'un match déjà terminé",
							"Action Impossible", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}

	public void createPanel() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);

		String joueur1 = "Equipe 1";
		String joueur2 = "Equipe 2";

		int style1 = Font.PLAIN, style2 = Font.PLAIN;
		if (listEquipeMatch.size() > 0) {
			joueur1 = listEquipeMatch.get(0) + "";
			if (equipeDAO.isGagnant(listEquipeMatch.get(0), match)) {
				style1 = Font.BOLD;
			}
		} else {
			style1 = Font.ITALIC;
		}
		if (listEquipeMatch.size() > 1) {
			joueur2 = listEquipeMatch.get(1) + "";
			if (equipeDAO.isGagnant(listEquipeMatch.get(1), match)) {
				style2 = Font.BOLD;
			}
		} else {
			style2 = Font.ITALIC;
		}

		JLabel Joueur1Label = new JLabel(joueur1);
		Joueur1Label.setFont(new Font("Tahoma", style1, 12));
		Joueur1Label.setBounds(5, 0, 200, 21);
		add(Joueur1Label);

		JLabel Joueur2Label = new JLabel(joueur2);
		Joueur2Label.setFont(new Font("Tahoma", style2, 12));
		Joueur2Label.setBounds(5, 20, 200, 21);
		add(Joueur2Label);

		addJourHeure(137);
	}

}
