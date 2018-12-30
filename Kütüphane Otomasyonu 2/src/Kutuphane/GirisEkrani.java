package Kutuphane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GirisEkrani extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtSifre;
	private JTextField txtKullaniciAdi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GirisEkrani frame = new GirisEkrani();
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GirisEkrani() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(169, 169, 169));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKullancAd = new JLabel("Kullan\u0131c\u0131 Ad\u0131 :");
		lblKullancAd.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblKullancAd.setBounds(64, 46, 108, 61);
		contentPane.add(lblKullancAd);
		
		JLabel lblifre = new JLabel("\u015Eifre :");
		lblifre.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblifre.setBounds(64, 101, 108, 61);
		contentPane.add(lblifre);
		
		txtSifre = new JPasswordField();
		txtSifre.setBounds(184, 121, 161, 22);
		contentPane.add(txtSifre);
		
		txtKullaniciAdi = new JTextField();
		txtKullaniciAdi.setBounds(184, 66, 161, 22);
		contentPane.add(txtKullaniciAdi);
		
		JButton btnGirisYap = new JButton("G\u0130R\u0130\u015E YAP");
		btnGirisYap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Baglanti b = new Baglanti();
				b.GirisYap(txtKullaniciAdi.getText(), txtSifre.getText());
			}
		});
		btnGirisYap.setBounds(231, 166, 114, 39);
		contentPane.add(btnGirisYap);
	}
}
