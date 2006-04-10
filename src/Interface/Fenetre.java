package Interface;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.border.Border;

import ZoneDessin.ZoneDessin;

public class Fenetre extends JFrame 
{
	private JMenuBar menuBar = new JMenuBar();
    private ZoneDessin mZoneDessin = new ZoneDessin();	
    private Color couleur = Color.white;
	JScrollPane scrollPane = new JScrollPane(mZoneDessin);
	JPanel mCentralZone = new JPanel();
	
	// Elements dans la bare du menu++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 
	JMenu mnFichier = new JMenu("   Fichier   ");
	JMenuItem mntmNouveau = new JMenuItem("Nouveau",new ImageIcon("images/document.png"));
	
	JMenuItem mntmOuvrir = new JMenuItem("Ouvrir",new ImageIcon("images/folder_32.png"));
	
	JMenuItem mntmEnregistrer = new JMenuItem("Enregistrer Sous",new ImageIcon("images/save.png"));
	
	JMenuItem mntmQuiter = new JMenuItem("Quitter",new ImageIcon("images/effacer.png"));
	
	JMenu mnEdit = new JMenu("    Edit   ");
	
	JMenuItem mntmEffacer = new JMenuItem("Effacer Tout ",new ImageIcon("images/gom.png"));
	
	JMenu mnOutils = new JMenu("   Outils   ");
	
	JMenu mnElment = new JMenu("Elément");
	
	JMenuItem mntmTousLesElment1 = new JMenuItem("Crayon");
	JMenuItem mntmTousLesElment2 = new JMenuItem("Pinceau");
	JMenuItem mntmTousLesElment3 = new JMenuItem("Ligne");
	JMenuItem mntmTousLesElment4 = new JMenuItem("Rectangle Plaine");
	JMenuItem mntmTousLesElment5 = new JMenuItem("Rectangle Vide");
	JMenuItem mntmTousLesElment6 = new JMenuItem("Cercle Plain");
	JMenuItem mntmTousLesElment7 = new JMenuItem("Cercle Vide");
	
	JMenu mnAPropos = new JMenu("   A Propos   ");
	JMenuItem mtmApropos = new JMenuItem(" A Propos de Super Paint",new ImageIcon("images/info.png"));
	
	// Creation  des  boutons et des labels
	JButton btngomme = new JButton(new ImageIcon("images/gommage.png"));
	
	JLabel lblStyle1 = new JLabel("Gomme  Pinceau    Ligne");

	JButton btnpinceau = new JButton(new ImageIcon("images/paint.png"));
	
	JButton btnligne = new JButton(new ImageIcon("images/line.png"));
	
	JButton btnrectV = new JButton(new ImageIcon("images/rectV.png"));
	JButton btnrectP = new JButton(new ImageIcon("images/rectP.png"));
	
	JButton btncercleV = new JButton(new ImageIcon("images/cercv2.png"));
	
	JButton btncercleP = new JButton(new ImageIcon("images/cercP1.png"));
	
	JLabel lblCouleurs = new JLabel("    Couleurs");
	
	JButton btnNewButton_5_1c1 = new JButton(new ImageIcon("images/blanc.png"));
	JButton btnNewButton_5_1c2 = new JButton(new ImageIcon("images/blue.png"));
	JButton btnNewButton_5_1c3 = new JButton(new ImageIcon("images/verte.png"));
	JButton btnNewButton_5_1c4 = new JButton(new ImageIcon("images/violet.png"));

	JButton btnNewButton_5_2c1 = new JButton(new ImageIcon("images/orange.png"));
	JButton btnNewButton_5_2c2 = new JButton(new ImageIcon("images/rouge.png"));
	JButton btnNewButton_5_2c3 = new JButton(new ImageIcon("images/rose.png"));
	JButton btnNewButton_5_2c4 = new JButton(new ImageIcon("images/chocolat.png"));
	
	JButton btnNewButton_5_3c1 = new JButton(new ImageIcon("images/noire.png"));
	JButton btnNewButton_5_3c2 = new JButton(new ImageIcon("images/gray.png"));
	JButton btnNewButton_5_3c3 = new JButton(new ImageIcon("images/pink.png"));
	JButton btnNewButton_5_3c4 = new JButton(new ImageIcon("images/jaune.png"));
	
	JLabel lblFond = new JLabel("+Couleurs         Fond");
	
	JButton btnPcouleur = new JButton(new ImageIcon("images/colors.png"));
	
	JButton btnBgcolor = new JButton(new ImageIcon("images/bgcolor.png"));
	
	JLabel lblGomme = new JLabel("    Gomme");
	
	JButton btnpencile = new JButton(new ImageIcon("images/pencile.png"));
	
	JLabel lblFormes = new JLabel("  Formes  du trace");
	
	JButton btnpoint = new JButton(new ImageIcon("images/1.png"));
	
	JButton btnpoint2 = new JButton(new ImageIcon("images/2.png"));
	
	JLabel lblGometriques = new JLabel("Formes  Géometriques");
	JLabel lblFormes1 = new JLabel("    Formes");
	
	
	public Fenetre()
	{
		this.setSize(900, 610);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.element_du_Fenetre();
		this.reglage_Elements();
		this.getContentPane().setBackground(new Color(47,79,79));
		mCentralZone.add(scrollPane, BorderLayout.CENTER);
		this.getContentPane().add(mCentralZone, BorderLayout.EAST);
		this.setVisible(true);
		this.getContentPane().setLayout(null);
	}
	// Ajout des elements dans cette fenetre+++++++++++++++++++++++++++++++++++++++++++++
	private void element_du_Fenetre() {
		
		// Ajout des elements dans cette fenetre-----------------------------------------
		
		JLabel SuperPaint=new JLabel(" SUPER	   PAINT");
		SuperPaint.setBounds(420,513,320,50);
		SuperPaint.setForeground(Color.blue);
		SuperPaint.setFont(new Font("Georgia", Font.BOLD, 28));
		btnPcouleur.setBounds(5,390, 70, 43);
		this.getContentPane().add(SuperPaint);
		
		    lblFond.setBounds(1, 370,200, 14);
			lblFond.setForeground(Color.WHITE);
			lblFond.setFont(new Font("Georgia", Font.BOLD, 14));
			this.getContentPane().add(lblFond);	
			
			lblFormes.setBounds(20, 455, 200, 14);
			lblFormes.setForeground(Color.WHITE);
			lblFormes.setFont(new Font("Georgia", Font.BOLD, 14));
			this.getContentPane().add(lblFormes);
		
			menuBar.add(mnFichier);
			mnFichier.add(mntmNouveau);
			mnFichier.add(mntmEnregistrer);
			mnFichier.add(mntmQuiter);
			menuBar.add(mnEdit);
			mnEdit.add(mntmEffacer);
			menuBar.add(mnOutils);
			mnOutils.add(mnElment);
			mnElment.add(mntmTousLesElment1);
			mnElment.add(mntmTousLesElment2);
			mnElment.add(mntmTousLesElment3);
			mnElment.add(mntmTousLesElment4);
			mnElment.add(mntmTousLesElment5);
			mnElment.add(mntmTousLesElment6);
			mnElment.add(mntmTousLesElment7);
		
		//ECOUTEURS DE TOUS LES ELEMENTS+++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		mntmTousLesElment1.addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent arg0) 
			{
				mZoneDessin.setmFormeType("Style");
				mZoneDessin.setmPointerTaille(2);
				mZoneDessin.repaint();
			}
		});
		
		mntmTousLesElment2.addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent arg0) 
			{
				mZoneDessin.setmFormeType("Style");
				mZoneDessin.setmPointerTaille(12);	
				mZoneDessin.repaint();
			}
		});

		mntmTousLesElment3.addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent arg0) 
			{	
				mZoneDessin.setmFormeType("Ligne");
				mZoneDessin.repaint();		
			}
		});
		
		mntmTousLesElment4.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{		
				mZoneDessin.setmFormeType("RectangleP");
				mZoneDessin.repaint();
			}
		});
		mntmTousLesElment5.addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent arg0) 
			{			
				mZoneDessin.setmFormeType("Rectangle");
				mZoneDessin.repaint();
			}
		});
		
		mntmTousLesElment6.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				mZoneDessin.setmFormeType("OvaleP");
				mZoneDessin.repaint();
			}
		});
		mntmTousLesElment7.addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent arg0) 
			{
				mZoneDessin.setmFormeType("Ovale");
				mZoneDessin.repaint();	
			}
		});
				
		menuBar.add(mnAPropos);
		mnAPropos.add(mtmApropos);
		this.setJMenuBar(menuBar);
		mntmNouveau.addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent arg0) 
			{	
				int option = JOptionPane.showConfirmDialog(null," Votre dessin  sera effacé ","Nouvel Zone du dessin",JOptionPane.YES_NO_OPTION);
					
				if(option == JOptionPane.OK_OPTION)
				{
						mZoneDessin.setmCouleurBackground(Color.WHITE);
						Color newColor = Color.black;
						mZoneDessin.setmCouleurPointer(newColor);
						mZoneDessin.clear();
						mZoneDessin.repaint();					
				}
			}
		});
		mntmNouveau.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
		
   		mntmEnregistrer.addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent arg0) 
			{
				int sauvegarde = JOptionPane.showConfirmDialog(null,"VOULEZ VOUS  SAUVEGARDER CE DESSIN ?","SAUVEGARDER",JOptionPane.YES_NO_OPTION);
		         if(sauvegarde==0){
		        BufferedImage image = new BufferedImage(mZoneDessin.getWidth(), mZoneDessin.getHeight(), BufferedImage.TYPE_INT_ARGB);
		        mZoneDessin.paint(image.getGraphics());
		        try {
			        	JFileChooser fileChooser = new JFileChooser();
						int result = fileChooser.showSaveDialog(null);
						if (result == JFileChooser.APPROVE_OPTION) {
							
						File fichier = fileChooser.getSelectedFile();	
			            ImageIO.write(image, "PNG",fichier);
					    }
			        } catch (IOException ex) {
			            Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
			        }
		         }
			}
		});
   		mntmEnregistrer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
		mntmQuiter.addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent arg0) 
			{
				int option = JOptionPane.showConfirmDialog(null, "Voulez vous fermez cette Application ?",
						"Quitter", JOptionPane.YES_NO_OPTION);
				
				if(option == JOptionPane.OK_OPTION)
				{
					System.exit(0);
				}				
			}
		});
		mntmQuiter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK));
		
		mntmEffacer.addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent arg0) 
			{
				int option = JOptionPane.showConfirmDialog(null, "Voulez vous effacer ce dessin","Suppression du dessin", JOptionPane.YES_NO_OPTION);
				
				if(option == JOptionPane.OK_OPTION)
				{
					mZoneDessin.clear();
					mZoneDessin.repaint();
				}
			}	
		});
		mntmEffacer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK));
		mtmApropos.addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent arg0) 
			{
				JOptionPane apropos;
				apropos = new JOptionPane();
				ImageIcon img = new ImageIcon("images/capture.png");
				apropos.showMessageDialog(null, "","A Propos du Super Paint", JOptionPane.INFORMATION_MESSAGE, img);
			}
		});
		
		btngomme.addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent arg0) 
			{
				
				mZoneDessin.setmFormeType("Style");
				mZoneDessin.setmCouleurPointer(couleur);
				mZoneDessin.repaint();
				mZoneDessin.setmPointerTaille(8);
			}
		});
		
		btnpinceau.addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent arg0) 
			{
				mZoneDessin.setmFormeType("Style");
				mZoneDessin.setmPointerTaille(16);	
				mZoneDessin.repaint();
			}
		});
			
		btnligne.addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent arg0) 
			{	
				mZoneDessin.setmFormeType("Ligne");
				mZoneDessin.repaint();	
			}
		});
		
		btnrectV.addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent arg0) 
			{
				mZoneDessin.setmPointerTaille(12);	
				mZoneDessin.setmFormeType("Rectangle");	
			}
		});
		btnrectP.addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent arg0) 
			{
				mZoneDessin.setmPointerTaille(12);	
				mZoneDessin.setmFormeType("RectangleP");
				mZoneDessin.repaint();	
			}
		});
		
		btncercleV.addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent arg0) 
			{
				mZoneDessin.setmPointerTaille(12);	
				mZoneDessin.setmFormeType("Ovale");
				mZoneDessin.repaint();	
			}
		});
		btncercleP.addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent arg0) 
			{
				mZoneDessin.setmPointerTaille(12);	
				mZoneDessin.setmFormeType("OvaleP");
				mZoneDessin.repaint();
			}
		});
       //******************************
		btnNewButton_5_1c1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				Color newColor = Color.white;
				mZoneDessin.setmCouleurPointer(newColor);
			}
		});
	
		btnNewButton_5_1c2.addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent arg0) 
			{
				Color newColor = Color.blue;
				mZoneDessin.setmCouleurPointer(newColor);
			}
		});
		
		btnNewButton_5_1c3.addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent arg0) 
			{
				Color newColor = Color.green;
				mZoneDessin.setmCouleurPointer(newColor);
			}
		});
		
		btnNewButton_5_1c4.addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent arg0) 
			{
				Color newColor = new Color(148,0,211);
				mZoneDessin.setmCouleurPointer(newColor);
			}
		});
		
		btnNewButton_5_2c1.addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent arg0) 
			{
				Color newColor = Color.orange;
				mZoneDessin.setmCouleurPointer(newColor);
			}
		});
		
		btnNewButton_5_2c2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				Color newColor = Color.red;
				mZoneDessin.setmCouleurPointer(newColor);
			}
		});
		
		btnNewButton_5_2c3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				Color newColor = new Color(255,0,225);
				mZoneDessin.setmCouleurPointer(newColor);
			}
		});
		
		btnNewButton_5_2c4.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				Color newColor = new Color(139,61,19);
				mZoneDessin.setmCouleurPointer(newColor);
			}
		});
		
		btnNewButton_5_3c1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				Color newColor = Color.black;
				mZoneDessin.setmCouleurPointer(newColor);
			}
		});
		
		btnNewButton_5_3c2.addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent arg0) 
			{
				Color newColor = Color.GRAY;
				mZoneDessin.setmCouleurPointer(newColor);
			}
		});
		
		btnNewButton_5_3c3.addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent arg0) 
			{
				Color newColor = Color.pink;
				mZoneDessin.setmCouleurPointer(newColor);
			}
		});
		
		btnNewButton_5_3c4.addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent arg0) 
			{
				Color newColor = Color.yellow;
				mZoneDessin.setmCouleurPointer(newColor);
			}
		});
		//++++++++++++++++FERMETURE BOUTONS COLORS++++++++++++++++	
		btnPcouleur.addActionListener(new ActionListener() 
		{	
			
			public void actionPerformed(ActionEvent e) 
			{	 
				Color newColor = JColorChooser.showDialog(Fenetre.this, "Choisissez la couleur de votre Crayon ou Pinceau",
	                     Color.red);
				mZoneDessin.setmCouleurPointer(newColor);
			}
		});
		
		btnBgcolor.addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent arg0) 
			{
				Color newColorBg = JColorChooser.showDialog(Fenetre.this,"Choisissez la couleur de fond", Color.white);
				mZoneDessin.setmCouleurBackground(newColorBg);
				couleur = newColorBg;
				mZoneDessin.setBgChanging(true);
				mZoneDessin.repaint();
				mZoneDessin.changeBackground();
			}
		});
	
		btnpencile.addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent arg0) 
			{
				mZoneDessin.setmFormeType("Style");
				mZoneDessin.repaint();
				mZoneDessin.setmPointerTaille(4);
			}
		});
		
		btnpoint.addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent arg0) 
			{
				mZoneDessin.setmFormeType("Style");
				mZoneDessin.repaint();
				mZoneDessin.setmPointerTaille(8);
				
			}
		});
		
		btnpoint2.addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent arg0) 
			{
				mZoneDessin.setmFormeType("Style");	
				mZoneDessin.setmPointerTaille(12);
				mZoneDessin.repaint();
			}
		});
	}

	private void reglage_Elements() {
		
		
		// Coloration de l'arrriere plan de ces boutons++++++++++++++++++++++++++++++++++
		
		btngomme.setBackground(Color.white);
		btnpinceau.setBackground(Color.white);
		btnligne.setBackground(Color.white);
		btnrectV.setBackground(Color.white);
		btnrectP.setBackground(Color.white);
		btncercleV.setBackground(Color.white);
		btncercleP.setBackground(Color.white);
		btnPcouleur.setBackground(Color.white);
		btnBgcolor.setBackground(Color.white);
		btnpencile.setBackground(Color.white);
		btnpoint.setBackground(Color.white);
		btnpoint2.setBackground(Color.white);
		
		//Ajout et reglage d'une positions et d'une  taille de ces boutons++++++++++++++++++
		btngomme.setBounds(5, 35, 50, 43);
		this.getContentPane().add(btngomme);
		
		btnpinceau.setBounds(62, 35, 50, 43);
		this.getContentPane().add(btnpinceau);
		
		btnligne.setBounds(120, 35, 50, 43);
		this.getContentPane().add(btnligne);
		
		btnrectV.setBounds(5, 130, 70, 43);
		this.getContentPane().add(btnrectV);
		
		btnrectP.setBounds(100, 130, 70, 43);
		this.getContentPane().add(btnrectP);
	
		btncercleV.setBounds(5, 190, 70, 43);
		this.getContentPane().add(btncercleV);
		
		btncercleP.setBounds(100, 190, 70, 43);
		this.getContentPane().add(btncercleP);
		
		btnNewButton_5_1c1.setBounds(12, 270, 38, 28);
		this.getContentPane().add(btnNewButton_5_1c1);
		btnNewButton_5_1c2.setBounds(50, 270, 38, 28);
		this.getContentPane().add(btnNewButton_5_1c2);
		btnNewButton_5_1c3.setBounds(85, 270, 38, 28);
		this.getContentPane().add(btnNewButton_5_1c3);
		btnNewButton_5_1c4.setBounds(123, 270, 38, 28);
		this.getContentPane().add(btnNewButton_5_1c4);
		
		btnNewButton_5_2c1.setBounds(12, 300, 38, 28);
		this.getContentPane().add(btnNewButton_5_2c1);
		btnNewButton_5_2c2.setBounds(50, 300, 38, 28);
		this.getContentPane().add(btnNewButton_5_2c2);
		btnNewButton_5_2c3.setBounds(85, 300, 38, 28);
		this.getContentPane().add(btnNewButton_5_2c3);
		btnNewButton_5_2c4.setBounds(124, 300, 38, 28);
		this.getContentPane().add(btnNewButton_5_2c4);
		
		btnNewButton_5_3c1.setBounds(12, 328, 38, 28);
		this.getContentPane().add(btnNewButton_5_3c1);
		btnNewButton_5_3c2.setBounds(50, 328, 38, 28);
		this.getContentPane().add(btnNewButton_5_3c2);
		btnNewButton_5_3c3.setBounds(85, 328, 38, 28);
		this.getContentPane().add(btnNewButton_5_3c3);
		btnNewButton_5_3c4.setBounds(124, 328, 38, 28);
		this.getContentPane().add(btnNewButton_5_3c4);
	
		lblCouleurs.setBounds(38, 250, 83, 14);
		lblCouleurs.setForeground(Color.WHITE);
		lblCouleurs.setFont(new Font("Georgia", Font.BOLD, 14));
		this.getContentPane().add(lblCouleurs);
		
		
		
		btnPcouleur.setBounds(5, 390, 70, 43);
		this.getContentPane().add(btnPcouleur);
		
		btnBgcolor.setBounds(100, 390, 70, 43);
		this.getContentPane().add(btnBgcolor);
		
		btnpencile.setBounds(5, 475, 50, 43);
		this.getContentPane().add(btnpencile);
		
		btnpoint.setBounds(63, 475, 50, 43);
		this.getContentPane().add(btnpoint);
		
		btnpoint2.setBounds(120, 475, 50, 43);
		this.getContentPane().add(btnpoint2);

		lblStyle1.setBounds(5, 9, 200, 14);
		lblStyle1.setForeground(Color.WHITE);
		lblStyle1.setFont(new Font("Georgia", Font.BOLD, 12));
		lblGometriques.setBounds(7, 110, 200, 14);
		this.getContentPane().add(lblStyle1);
		
		lblGometriques.setForeground(Color.WHITE);
		lblGometriques.setFont(new Font("Georgia", Font.BOLD, 14));
		this.getContentPane().add(lblGometriques);	
		
		
		lblFormes1.setBounds(60, 122, 83, 14);
		lblFormes1.setForeground(Color.WHITE);
		lblFormes1.setFont(new Font("Georgia", Font.BOLD, 14));
	    this.getContentPane().add(lblFormes1);
	   
	}
	
	
}
