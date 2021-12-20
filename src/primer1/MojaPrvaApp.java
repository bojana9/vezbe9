package primer1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MojaPrvaApp extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIme;
	private JTextField txtPrezime;
	private JTextField txtMail;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxPol;
	private JPanel pnlKredencijali;
	private ButtonGroup group;
	private JRadioButton rdbtnGuest;
	private JRadioButton rdbtnUser;
	private JRadioButton rdbtnAdmin;
	private JRadioButton rdbtnSysAdmin;
	private JComboBox comboBoxZemlja;
	private JLabel lblZemlja;
	private JLabel lblPass;
	private JPasswordField passwordField;
	private JCheckBox chckbxKolacici;
	private JButton btnNewButton;
	private JCheckBox chckbxPrijava;
	private JPanel pnlKorisnici;
	DefaultListModel<String> dlm = new DefaultListModel<>();
	public JList list;
	private JLabel lblDodatiKorisnici;
	private User createUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MojaPrvaApp frame = new MojaPrvaApp();
					frame.setVisible(true);
					frame.setTitle("Moja prva aplikacija");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MojaPrvaApp() {
		getContentPane().setBackground(new Color(218, 112, 214));
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel pnlNaslov = new JPanel();
		pnlNaslov.setBackground(new Color(138, 43, 226));

		getContentPane().add(pnlNaslov, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel("LogIn Example");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Arial", Font.BOLD, 14));
		pnlNaslov.add(lblTitle);

		pnlKredencijali = new JPanel();
		pnlKredencijali.setBackground(new Color(65, 105, 225));
		getContentPane().add(pnlKredencijali, BorderLayout.WEST);
		pnlKredencijali.setLayout(new MigLayout("", "[grow][grow][][][][][74px,grow]", "[19px][][][][][][][][][]"));

		JLabel lblIme = new JLabel("Unesi ime:");
		pnlKredencijali.add(lblIme, "cell 0 3,alignx left,aligny center");

		txtIme = new JTextField();
		txtIme.setHorizontalAlignment(SwingConstants.LEFT);
		pnlKredencijali.add(txtIme, "cell 1 3,growx,aligny top");
		txtIme.setColumns(10);

		JLabel lblPrezime = new JLabel("Unesi prezime:");
		pnlKredencijali.add(lblPrezime, "cell 0 4,alignx left");

		txtPrezime = new JTextField();
		txtPrezime.setText("");
		pnlKredencijali.add(txtPrezime, "cell 1 4,growx");
		txtPrezime.setColumns(10);

		JLabel lblPol = new JLabel("Odaberi pol:");
		pnlKredencijali.add(lblPol, "cell 0 5,alignx left,aligny baseline");

		comboBoxPol = new JComboBox();
		pnlKredencijali.add(comboBoxPol, "cell 1 5,growx");
		comboBoxPol.addItem("Male");
		comboBoxPol.addItem("Female");

		JLabel lblMail = new JLabel("Mail adrress:");
		pnlKredencijali.add(lblMail, "cell 0 6,alignx left");

		txtMail = new JTextField();
		pnlKredencijali.add(txtMail, "cell 1 6,growx");
		txtMail.setColumns(10);

		lblPass = new JLabel("Unesi lozinku:");
		pnlKredencijali.add(lblPass, "cell 0 7,alignx left");

		passwordField = new JPasswordField();
		pnlKredencijali.add(passwordField, "cell 1 7,growx");

		JLabel lblRoles = new JLabel("Odaberi ulogu:");
		pnlKredencijali.add(lblRoles, "cell 0 8");

		rdbtnGuest = new JRadioButton("Guest");
		pnlKredencijali.add(rdbtnGuest, "cell 0 9,growx"); // dodavanje dugmadi u JPanel
		rdbtnUser = new JRadioButton("User");
		pnlKredencijali.add(rdbtnUser, "cell 1 9,growx,aligny baseline");
		rdbtnAdmin = new JRadioButton("Admin");
		pnlKredencijali.add(rdbtnAdmin, "cell 0 10,growx");
		rdbtnSysAdmin = new JRadioButton("SysAdmin");
		pnlKredencijali.add(rdbtnSysAdmin, "cell 1 10,growx");

		group = new ButtonGroup(); // Grupisanje radio buttons, radi omogucavanja selekcije samo jednog dugmeta
		group.add(rdbtnGuest);
		group.add(rdbtnUser);
		group.add(rdbtnAdmin);
		group.add(rdbtnSysAdmin);

		String[] zemlje = { "Srbija", "Bosna i Hercegovina", "Hrvatska", "Crna Gora", "Makedonija", "Slovenija" };

		lblZemlja = new JLabel("Odaberi zemlju");
		pnlKredencijali.add(lblZemlja, "cell 0 11,aligny baseline");
		comboBoxZemlja = new JComboBox(zemlje); // Prosledjujemo padajucoj listi niz String-ova - zemlje
		pnlKredencijali.add(comboBoxZemlja, "cell 1 11,growx");

		chckbxKolacici = new JCheckBox("Prihvati kolacice");
		chckbxKolacici.setBackground(new Color(135, 206, 250));
		pnlKredencijali.add(chckbxKolacici, "cell 0 12,alignx right");

		btnNewButton = new JButton("Prijavi se");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtIme.getText().trim().isEmpty() || txtPrezime.getText().trim().isEmpty()
						|| txtMail.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Popunite sva polja!", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (passwordField.getText().length() < 8) {
					JOptionPane.showMessageDialog(null, "Lozinka mora imati najmanje 8 karaktera!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else if (getSelectedButton(group) == false) {
					JOptionPane.showMessageDialog(null, "Odaberite ulogu korisnika!", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

				else {
					String ime = txtIme.getText().trim();
					String prezime = txtPrezime.getText().trim();
					String role = getSelectedButtonText(group);
					String country = comboBoxZemlja.getSelectedItem().toString();
					createUser = new User(ime, prezime, role, country);

					dlm.add(0, createUser.toString());

				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setForeground(new Color(240, 255, 240));
		btnNewButton.setBackground(new Color(25, 25, 112));
		pnlKredencijali.add(btnNewButton, "cell 0 13,growx");

		chckbxPrijava = new JCheckBox("Ostani prijavljen/a");
		chckbxPrijava.setBackground(new Color(135, 206, 250));
		pnlKredencijali.add(chckbxPrijava, "cell 1 13,growx");
		chckbxPrijava.setToolTipText("Zapamti kredencijale");

		pnlKorisnici = new JPanel();
		getContentPane().add(pnlKorisnici, BorderLayout.CENTER);
		comboBoxZemlja.addActionListener(this);
		pnlKorisnici.setLayout(new BoxLayout(pnlKorisnici, BoxLayout.X_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		pnlKorisnici.add(scrollPane);
		list = new JList();
		scrollPane.setViewportView(list);
		list.setModel(dlm);

		lblDodatiKorisnici = new JLabel("Poslednje dodati korisnici:");
		lblDodatiKorisnici.setBackground(Color.WHITE);
		lblDodatiKorisnici.setFont(new Font("Arial", Font.BOLD, 15));
		scrollPane.setColumnHeaderView(lblDodatiKorisnici);

		rdbtnGuest.addActionListener(this); // dodavanje osluskivaca za action performed metod
		rdbtnUser.addActionListener(this);
		rdbtnAdmin.addActionListener(this);
		rdbtnSysAdmin.addActionListener(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 816, 382);
		setResizable(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == rdbtnGuest) {
			System.out.println("You choose guest role!");
		} else if (e.getSource() == rdbtnUser) {
			System.out.println("You choose user role!");
		} else if (e.getSource() == rdbtnAdmin) {
			System.out.println("You choose admin role!");
		} else if (e.getSource() == rdbtnSysAdmin) {
			System.out.println("You choose system admin role!");
		} else if (e.getSource() == comboBoxZemlja) {
			System.out.println("Odabrana zemlja je: " + comboBoxZemlja.getSelectedItem());
		}
	}

	public boolean getSelectedButton(ButtonGroup buttonGroup) {
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();

			if (button.isSelected()) {
				return true;
			}
		}

		return false;
	}

	public String getSelectedButtonText(ButtonGroup buttonGroup) {
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();

			if (button.isSelected()) {
				return button.getText();
			}
		}

		return null;
	}

}
