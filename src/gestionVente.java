import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.List;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class gestionVente extends JFrame {

	private JPanel contentPane;
	private JTextField txtprix;
	private JTextField txtnombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestionVente frame = new gestionVente();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
// variable total contient la somme du tous le produit 
	Double total = 0.0;
	public gestionVente() {
		// icon du page
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\saif\\Downloads\\download.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//taille du page 
		setBounds(100, 100, 676, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 // title du page
		JLabel lblNewLabel = new JLabel("   Gestion de Vente du Materiel Informatique");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setAutoscrolls(true);
		lblNewLabel.setBackground(new Color(0, 128, 128));
		lblNewLabel.setBounds(5, 5, 650, 49);
		lblNewLabel.setForeground(new Color(51, 204, 255));
		// disposition du titre
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(null);
		// font et taille d'ecriture
		lblNewLabel.setFont(new Font("Calibri Light", Font.BOLD, 24));
		contentPane.add(lblNewLabel);
		// label produit
		JLabel lblNewLabel_1 = new JLabel("Produit :");
		lblNewLabel_1.setFont(new Font("Calibri Light", Font.BOLD, 12));
		lblNewLabel_1.setBounds(32, 147, 79, 17);
		contentPane.add(lblNewLabel_1);
		// label prix
		JLabel lblNewLabel_2 = new JLabel("Prix :");
		lblNewLabel_2.setFont(new Font("Calibri Light", Font.BOLD, 12));
		lblNewLabel_2.setBounds(32, 194, 61, 14);
		contentPane.add(lblNewLabel_2);
		// label nombre
		JLabel lblNewLabel_3 = new JLabel("Nombre");
		lblNewLabel_3.setFont(new Font("Calibri Light", Font.BOLD, 12));
		lblNewLabel_3.setBounds(32, 254, 46, 14);
		contentPane.add(lblNewLabel_3);
		// name of label prix
		txtprix = new JTextField();
		txtprix.setBounds(139, 191, 86, 20);
		contentPane.add(txtprix);
		txtprix.setColumns(10);
		// name of label noombre
		txtnombre = new JTextField();
		txtnombre.setColumns(10);
		txtnombre.setBounds(139, 248, 86, 20);
		contentPane.add(txtnombre);
		 // liste du produit
		JComboBox cmbproduit = new JComboBox();
		cmbproduit.setModel(new DefaultComboBoxModel(new String[] {"Pc", "Clavier", "Souris", "Casque", "Ecran", "Carte Mere", "Carte Graphique ", "Carte Sons ", "Disque Dur", "USB", "Charguer HP"}));
		cmbproduit.setBounds(139, 144, 141, 20);
		contentPane.add(cmbproduit);
		txtprix.requestFocus();
		
		JLabel lblNewLabel_4 = new JLabel("Liste D'achats");
		lblNewLabel_4.setFont(new Font("Calibri Light", Font.BOLD, 13));
		lblNewLabel_4.setBounds(346, 77, 132, 17);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Montants");
		lblNewLabel_4_1.setFont(new Font("Calibri Light", Font.BOLD, 13));
		lblNewLabel_4_1.setBounds(520, 74, 94, 20);
		contentPane.add(lblNewLabel_4_1);
		
		List lstachat = new List();
		lstachat.setBounds(346, 100, 132, 233);
		contentPane.add(lstachat);
		
		List lstprix = new List();
		lstprix.setBounds(507, 100, 132, 233);
		contentPane.add(lstprix);
		
		JLabel lblnombre = new JLabel("");
		lblnombre.setOpaque(true);
		lblnombre.setForeground(new Color(0, 0, 0));
		lblnombre.setBackground(Color.WHITE);
		lblnombre.setBounds(346, 339, 132, 20);
		contentPane.add(lblnombre);
		
		JLabel lbltotal = new JLabel("");
		lbltotal.setOpaque(true);
		lbltotal.setBackground(Color.WHITE);
		lbltotal.setBounds(507, 339, 132, 20);
		contentPane.add(lbltotal);
		
		JButton btnajouter = new JButton("Ajouter");
		btnajouter.setIcon(new ImageIcon("C:\\Users\\saif\\Downloads\\icons8-add-32.png"));
		btnajouter.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnajouter.setBorder(new EmptyBorder(0,5,0,5));
		btnajouter.addActionListener(new ActionListener() {
			// function ajouter un produit et calculet le montant et add dans la liste d'achat et montant
			public void actionPerformed(ActionEvent e) {
				String produit ;
				double prix ,montant ;
				int nombre , nombreproduit;
				produit =cmbproduit.getSelectedItem().toString();
				prix = Double.parseDouble(txtprix.getText());
				nombre = Integer.parseInt(txtnombre.getText());
				montant = prix *nombre ;
				lstachat.add(produit);
				lstprix.add(String.valueOf(montant));
				nombreproduit =lstachat.getItemCount();
				lblnombre.setText(String.valueOf(nombreproduit));
				total =total+ montant ;
				lbltotal.setText(String.valueOf(total));
			}
		});
		btnajouter.setBounds(61, 387, 123, 30);
		contentPane.add(btnajouter);
		// suprimer un produit
		JButton btnsupprimer = new JButton("Supprimer");
		btnsupprimer.setIcon(new ImageIcon("C:\\Users\\saif\\Downloads\\icons8-remove-24 (1).png"));
		btnsupprimer.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnsupprimer.setBorder(new EmptyBorder(0,5,0,5));
		btnsupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index ,nombre;
				double montant,total ;
				nombre =Integer.parseInt(lblnombre.getText());
				total =Double.parseDouble(lbltotal.getText());
				index= lstachat.getSelectedIndex();
				montant = Double.parseDouble(lstprix.getItem(index));
		         nombre =nombre-1;
		         lstachat.remove(index);
		         lstprix.remove(index);
				total =total - montant;
		        lbltotal.setText(String.valueOf(total));
	            lblnombre.setText(String.valueOf(nombre));
			}
		});
		btnsupprimer.setBounds(208, 387, 123, 30);
		contentPane.add(btnsupprimer);
		// vider le systeme
		JButton btneffacer = new JButton("Effacer");
		btneffacer.setIcon(new ImageIcon("C:\\Users\\saif\\Downloads\\icons8-video-trimming-26.png"));
		btneffacer.setFont(new Font("Tahoma", Font.BOLD, 15));
		btneffacer.setBorder(new EmptyBorder(0,5,0,5));
		btneffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtprix.setText("");
				txtnombre.setText("");
				lstachat.removeAll();
				lstprix.removeAll();
				lblnombre.setText("");
				lbltotal.setText("");
			}
		});
		btneffacer.setBounds(361, 387, 123, 30);
		contentPane.add(btneffacer);
		// quiter frame when clique su button  quitte
		JButton btnquitter = new JButton("Quitter");
		btnquitter.setIcon(new ImageIcon("C:\\Users\\saif\\Downloads\\icons8-export-24.png"));
		btnquitter.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnquitter.setBorder(UIManager.getBorder("Button.border"));
		btnquitter.setBorder(new EmptyBorder(0,5,0,5));
		btnquitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnquitter.setBounds(491, 387, 123, 30);
		contentPane.add(btnquitter);
	}
}
