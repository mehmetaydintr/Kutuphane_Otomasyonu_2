package Kutuphane;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Color;

public class AnaMenu extends JFrame {

	private JPanel contentPane;
	private JTextField txtEkleKitapAdi;
	private JTextField txtEkleKitapYazari;
	private JTextField txtEkleTuru;
	private JTextField txtEkleSayfaSayisi;
	private JTextField txtEkleYayinEvi;
	private JTextField txtEkleBasimYili;
	private JTextField txtEkleAdet;
	private JTextField txtEkleISBNNo;
	private JTextField txtSilISBN;
	private JTextField txtSilAdet;
	private JTextField txtAraISBNNo;
	private JTextField txtUyeAdi;
	private JTextField txtUyeSoyadi;
	private JTextField txtUyeEmail;
	private JTextField txtUyeAra;
	private JTextField txtUyeSil;
	private JTextField txtOduncUyeNo;
	private JTextField txtOduncISBNNo;
	private JTextField txtGeriUyeNo;
	private JTextField txtGeriISBN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnaMenu frame = new AnaMenu();
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
	public AnaMenu() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 651, 664);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(169, 169, 169));
		tabbedPane.addTab("KÝTAP EKLE", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kitap Ad\u0131 :");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel.setBounds(162, 142, 132, 22);
		panel.add(lblNewLabel);
		
		JLabel lblYazar = new JLabel("Yazar\u0131 :");
		lblYazar.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblYazar.setBounds(162, 175, 132, 19);
		panel.add(lblYazar);
		
		JLabel lblTr = new JLabel("T\u00FCr\u00FC :");
		lblTr.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblTr.setBounds(162, 207, 132, 19);
		panel.add(lblTr);
		
		JLabel lblSayfaSays = new JLabel("Sayfa Say\u0131s\u0131 :");
		lblSayfaSays.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblSayfaSays.setBounds(162, 237, 132, 22);
		panel.add(lblSayfaSays);
		
		JLabel lblYaynEvi = new JLabel("Yay\u0131n Evi :");
		lblYaynEvi.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblYaynEvi.setBounds(162, 272, 132, 20);
		panel.add(lblYaynEvi);
		
		JLabel lblBasmYl = new JLabel("Bas\u0131m Y\u0131l\u0131 :");
		lblBasmYl.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblBasmYl.setBounds(162, 305, 132, 24);
		panel.add(lblBasmYl);
		
		JLabel lblAdeti = new JLabel("Adet :");
		lblAdeti.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblAdeti.setBounds(162, 342, 132, 19);
		panel.add(lblAdeti);
		
		JLabel lblIsbnNo = new JLabel("ISBN No :");
		lblIsbnNo.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblIsbnNo.setBounds(162, 374, 132, 18);
		panel.add(lblIsbnNo);
		
		txtEkleKitapAdi = new JTextField();
		txtEkleKitapAdi.setBounds(311, 141, 116, 22);
		panel.add(txtEkleKitapAdi);
		txtEkleKitapAdi.setColumns(10);
		
		txtEkleKitapYazari = new JTextField();
		txtEkleKitapYazari.setColumns(10);
		txtEkleKitapYazari.setBounds(311, 176, 116, 22);
		panel.add(txtEkleKitapYazari);
		
		txtEkleTuru = new JTextField();
		txtEkleTuru.setColumns(10);
		txtEkleTuru.setBounds(311, 206, 116, 22);
		panel.add(txtEkleTuru);
		
		txtEkleSayfaSayisi = new JTextField();
		txtEkleSayfaSayisi.setColumns(10);
		txtEkleSayfaSayisi.setBounds(311, 235, 116, 22);
		panel.add(txtEkleSayfaSayisi);
		
		txtEkleYayinEvi = new JTextField();
		txtEkleYayinEvi.setColumns(10);
		txtEkleYayinEvi.setBounds(311, 270, 116, 22);
		panel.add(txtEkleYayinEvi);
		
		txtEkleBasimYili = new JTextField();
		txtEkleBasimYili.setColumns(10);
		txtEkleBasimYili.setBounds(311, 304, 116, 22);
		panel.add(txtEkleBasimYili);
		
		txtEkleAdet = new JTextField();
		txtEkleAdet.setColumns(10);
		txtEkleAdet.setBounds(311, 339, 116, 22);
		panel.add(txtEkleAdet);
		
		txtEkleISBNNo = new JTextField();
		txtEkleISBNNo.setColumns(10);
		txtEkleISBNNo.setBounds(311, 374, 116, 22);
		panel.add(txtEkleISBNNo);
		
		JButton btnEkle = new JButton("EKLE");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Kitap k = new Kitap();
				try {
					k.KitapAdi = txtEkleKitapAdi.getText();
					k.Yazar = txtEkleKitapYazari.getText();
					k.Türü = txtEkleTuru.getText();
					k.SayfaSayisi = Integer.parseInt(txtEkleSayfaSayisi.getText()) ;
					k.YayinEvi = txtEkleYayinEvi.getText();
					k.BasimYili =  Integer.parseInt(txtEkleBasimYili.getText()) ;
					k.Adet =  Integer.parseInt(txtEkleAdet.getText()) ;
					k.ISBN =  Integer.parseInt(txtEkleISBNNo.getText()) ;
					Baglanti b = new Baglanti();
					b.KitapEkle(k);
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"Lütfen girdiðiniz deðerleri kontrol ediniz.", "Hata Mesajý", -1);
				}
				
			}
		});
		btnEkle.setBounds(311, 409, 116, 40);
		panel.add(btnEkle);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(169, 169, 169));
		tabbedPane.addTab("KÝTAP SÝL", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("ISBN No :");
		label.setFont(new Font("Arial Black", Font.BOLD, 14));
		label.setBounds(166, 217, 132, 18);
		panel_1.add(label);
		
		txtSilISBN = new JTextField();
		txtSilISBN.setColumns(10);
		txtSilISBN.setBounds(315, 217, 116, 22);
		panel_1.add(txtSilISBN);
		
		JLabel label_1 = new JLabel("Adet :");
		label_1.setFont(new Font("Arial Black", Font.BOLD, 14));
		label_1.setBounds(166, 255, 132, 19);
		panel_1.add(label_1);
		
		txtSilAdet = new JTextField();
		txtSilAdet.setColumns(10);
		txtSilAdet.setBounds(315, 252, 116, 22);
		panel_1.add(txtSilAdet);
		
		JButton btnKitabSil = new JButton("K\u0130TABI S\u0130L");
		btnKitabSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					int ISBNNo,Adet;
		            ISBNNo = Integer.parseInt(txtSilISBN.getText());
		            Adet = Integer.parseInt(txtSilAdet.getText());
		            if(0>=Adet) {
		            	JOptionPane.showMessageDialog(null, "Adet 0 veya daha küçük girilemez. ");
		            }
		            else
		            {
		            	Baglanti b = new Baglanti();
						b.KitapSil(ISBNNo,Adet);
		            }
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"Lütfen girdiðiniz deðerleri kontrol ediniz.", "Hata Mesajý", -1);
				}
				
				
			}
		});
		btnKitabSil.setBounds(315, 302, 116, 40);
		panel_1.add(btnKitabSil);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(169, 169, 169));
		tabbedPane.addTab("KÝTAP ARA", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel label_2 = new JLabel("ISBN No :");
		label_2.setFont(new Font("Arial Black", Font.BOLD, 14));
		label_2.setBounds(166, 218, 132, 18);
		panel_2.add(label_2);
		JLabel lblKitapAdi = new JLabel("");
		lblKitapAdi.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblKitapAdi.setBounds(92, 194, 265, 27);
		panel_2.add(lblKitapAdi);
		
		JLabel lblKitapYazar = new JLabel("");
		lblKitapYazar.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblKitapYazar.setBounds(92, 234, 265, 27);
		panel_2.add(lblKitapYazar);
		
		JLabel lblTuru = new JLabel("");
		lblTuru.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblTuru.setBounds(92, 274, 265, 27);
		panel_2.add(lblTuru);
		
		JLabel lblSayfaSayisi = new JLabel("");
		lblSayfaSayisi.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblSayfaSayisi.setBounds(92, 316, 265, 27);
		panel_2.add(lblSayfaSayisi);
		
		JLabel lblBasimYili = new JLabel("");
		lblBasimYili.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblBasimYili.setBounds(92, 356, 265, 27);
		panel_2.add(lblBasimYili);
		
		JLabel lblYayinEvi = new JLabel("");
		lblYayinEvi.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblYayinEvi.setBounds(92, 396, 265, 27);
		panel_2.add(lblYayinEvi);
		
		JLabel lblKitapAdeti = new JLabel("");
		lblKitapAdeti.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblKitapAdeti.setBounds(92, 436, 265, 27);
		panel_2.add(lblKitapAdeti);
		
		txtAraISBNNo = new JTextField();
		txtAraISBNNo.setColumns(10);
		txtAraISBNNo.setBounds(315, 218, 116, 22);
		panel_2.add(txtAraISBNNo);
		
		JButton btnAra = new JButton("K\u0130TABI ARA");
		btnAra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Kitap kitap = new Kitap();
					Baglanti b = new Baglanti();
					int ISBNNo = Integer.parseInt(txtAraISBNNo.getText() );
					kitap= b.KitapAra(ISBNNo);
					if(kitap.SayfaSayisi!=0)
					{
						lblKitapAdi.setText("Kitap Adý :" + kitap.KitapAdi);
						lblKitapYazar.setText("Yazarý :" + kitap.Yazar);
						lblTuru.setText("Türü :" + kitap.Türü);
						lblSayfaSayisi.setText("Sayfa Sayýsý :" + kitap.SayfaSayisi);
						lblBasimYili.setText("Basým Yýlý :" + kitap.BasimYili);
						lblYayinEvi.setText("Yayýn Evi :" + kitap.YayinEvi);
						lblAdeti.setText("Adet :" + kitap.Adet);				
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Kitap Bulunamadý..", "Onay Mesajý", -1);
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"Lütfen girdiðiniz deðerleri kontrol ediniz.", "Hata Mesajý", -1);
				}
				
				
			}
		});
		btnAra.setBounds(315, 303, 116, 40);
		panel_2.add(btnAra);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(169, 169, 169));
		tabbedPane.addTab("KÝTABI GERÝ ALMA", null, panel_7, null);
		panel_7.setLayout(null);
		
		JLabel label_6 = new JLabel("\u00DCye No :");
		label_6.setFont(new Font("Arial Black", Font.BOLD, 14));
		label_6.setBounds(161, 213, 132, 18);
		panel_7.add(label_6);
		
		JLabel label_7 = new JLabel("ISBN No :");
		label_7.setFont(new Font("Arial Black", Font.BOLD, 14));
		label_7.setBounds(161, 251, 132, 18);
		panel_7.add(label_7);
		
		txtGeriUyeNo = new JTextField();
		txtGeriUyeNo.setColumns(10);
		txtGeriUyeNo.setBounds(310, 213, 116, 22);
		panel_7.add(txtGeriUyeNo);
		
		txtGeriISBN = new JTextField();
		txtGeriISBN.setColumns(10);
		txtGeriISBN.setBounds(310, 251, 116, 22);
		panel_7.add(txtGeriISBN);
		
		JButton btnKitabiGeriAl = new JButton("K\u0130TABI GER\u0130 AL");
		btnKitabiGeriAl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Baglanti b = new Baglanti();
					b.GeriAl(Integer.parseInt(txtGeriUyeNo.getText()), Integer.parseInt(txtGeriISBN.getText()));	
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"Lütfen girdiðiniz deðerleri kontrol ediniz.", "Hata Mesajý", -1);
				}

			}
		});
		btnKitabiGeriAl.setBounds(298, 298, 143, 46);
		panel_7.add(btnKitabiGeriAl);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(169, 169, 169));
		tabbedPane.addTab("ÜYE EKLE ", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblAd = new JLabel("Ad\u0131 :");
		lblAd.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblAd.setBounds(158, 194, 132, 22);
		panel_3.add(lblAd);
		
		JLabel lblSoyad = new JLabel("Soyad\u0131 :");
		lblSoyad.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblSoyad.setBounds(158, 227, 132, 19);
		panel_3.add(lblSoyad);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblEmail.setBounds(158, 259, 132, 19);
		panel_3.add(lblEmail);
		
		JLabel lblCinsiyet = new JLabel("Cinsiyet :");
		lblCinsiyet.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblCinsiyet.setBounds(158, 303, 132, 24);
		panel_3.add(lblCinsiyet);
		
		txtUyeAdi = new JTextField();
		txtUyeAdi.setColumns(10);
		txtUyeAdi.setBounds(304, 193, 116, 22);
		panel_3.add(txtUyeAdi);
		
		txtUyeSoyadi = new JTextField();
		txtUyeSoyadi.setColumns(10);
		txtUyeSoyadi.setBounds(304, 228, 116, 22);
		panel_3.add(txtUyeSoyadi);
		
		txtUyeEmail = new JTextField();
		txtUyeEmail.setColumns(10);
		txtUyeEmail.setBounds(304, 258, 116, 22);
		panel_3.add(txtUyeEmail);
		
		JRadioButton rdoUyeErkek = new JRadioButton("Erkek");
		rdoUyeErkek.setSelected(true);
		rdoUyeErkek.setBounds(290, 304, 75, 25);
		JRadioButton rdoUyeKadin = new JRadioButton("Kad\u0131n");
		rdoUyeKadin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdoUyeKadin.isSelected()) {
					rdoUyeErkek.setSelected(false);
				}
				else
				{
					rdoUyeErkek.setSelected(true);
				}
			}
		});
		rdoUyeKadin.setBounds(369, 304, 75, 25);
		rdoUyeErkek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdoUyeErkek.isSelected()) {
					rdoUyeKadin.setSelected(false);
				}
				else
				{
					rdoUyeKadin.setSelected(true);
				}
			}
		});
		
		panel_3.add(rdoUyeErkek);
		
		
		panel_3.add(rdoUyeKadin);
		
		JButton btnUyeyiKaydet = new JButton("\u00DCYEY\u0130 KAYDET");
		btnUyeyiKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String pattern="\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
					Pattern r = Pattern.compile(pattern);
					Matcher m =r.matcher(txtUyeEmail.getText());
					if(m.find())
					{
						Uye uye = new Uye();
						uye.Ad = txtUyeAdi.getText();
						uye.Soyad = txtUyeSoyadi.getText();
						uye.Email = txtUyeEmail.getText();
						if(rdoUyeErkek.isSelected()) {
							uye.Cinsiyet="Erkek";
						}
						else
						{
							uye.Cinsiyet="Kadýn";
						}
						Baglanti b = new Baglanti();
						b.UyeEkle(uye);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Girilen email standartlara uymuyor.", "Hata Mesajý", -1);
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"Lütfen girdiðiniz deðerleri kontrol ediniz.", "Hata Mesajý", -1);
				}
				
				}
		});
		btnUyeyiKaydet.setBounds(304, 338, 116, 43);
		panel_3.add(btnUyeyiKaydet);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(169, 169, 169));
		tabbedPane.addTab("ÜYE ARA", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblyeNo = new JLabel("\u00DCye No :");
		lblyeNo.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblyeNo.setBounds(162, 213, 132, 18);
		panel_4.add(lblyeNo);
		
		txtUyeAra = new JTextField();
		txtUyeAra.setColumns(10);
		txtUyeAra.setBounds(311, 213, 116, 22);
		panel_4.add(txtUyeAra);
		
		JLabel lblUyeAd = new JLabel("");
		lblUyeAd.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblUyeAd.setBounds(103, 189, 265, 27);
		panel_4.add(lblUyeAd);
		
		JLabel lblUyeSoyad = new JLabel("");
		lblUyeSoyad.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblUyeSoyad.setBounds(103, 229, 265, 27);
		panel_4.add(lblUyeSoyad);
		
		JLabel lblUyeEmail = new JLabel("");
		lblUyeEmail.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblUyeEmail.setBounds(103, 269, 265, 27);
		panel_4.add(lblUyeEmail);
		
		JLabel lblUyeCinsiyet = new JLabel("");
		lblUyeCinsiyet.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblUyeCinsiyet.setBounds(103, 311, 265, 27);
		panel_4.add(lblUyeCinsiyet);
		
		JButton btnUyeAra = new JButton("\u00DCYE ARA");
		btnUyeAra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Uye uye = new Uye();
					Baglanti b = new Baglanti();
					int UyeNo = Integer.parseInt(txtUyeAra.getText() );
					uye = b.UyeAra(UyeNo);
					if(!(uye.Email.isEmpty()))
					{
						lblUyeAd.setText("Adý :" + uye.Ad);
						lblUyeSoyad.setText("Soyadý :" + uye.Soyad);
						lblUyeEmail.setText("Email : :" + uye.Email);
						lblUyeCinsiyet.setText("Cinsiyet :" + uye.Cinsiyet);
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"Üye Bulunamadý..", "Hata Mesajý", -1);
				}
				
				
			}
		});
		btnUyeAra.setBounds(311, 298, 116, 40);
		panel_4.add(btnUyeAra);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(169, 169, 169));
		tabbedPane.addTab("ÜYE SÝL", null, panel_5, null);
		panel_5.setLayout(null);
		
		JLabel label_3 = new JLabel("\u00DCye No :");
		label_3.setFont(new Font("Arial Black", Font.BOLD, 14));
		label_3.setBounds(172, 218, 132, 18);
		panel_5.add(label_3);
		
		txtUyeSil = new JTextField();
		txtUyeSil.setColumns(10);
		txtUyeSil.setBounds(321, 218, 116, 22);
		panel_5.add(txtUyeSil);
		
		JButton btnUyeSil = new JButton("\u00DCYE S\u0130L");
		btnUyeSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int UyeNo;
		            UyeNo = Integer.parseInt(txtUyeSil.getText());
		            	Baglanti b = new Baglanti();
						b.UyeSil(UyeNo);
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"Üye Bulunamadý..", "Hata Mesajý", -1);
				}
				
				
			}
		});
		btnUyeSil.setBounds(321, 303, 116, 40);
		panel_5.add(btnUyeSil);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(169, 169, 169));
		tabbedPane.addTab("ÖDÜNÇ KÝTAP VERME", null, panel_6, null);
		panel_6.setLayout(null);
		
		JLabel label_4 = new JLabel("\u00DCye No :");
		label_4.setFont(new Font("Arial Black", Font.BOLD, 14));
		label_4.setBounds(168, 219, 132, 18);
		panel_6.add(label_4);
		
		txtOduncUyeNo = new JTextField();
		txtOduncUyeNo.setColumns(10);
		txtOduncUyeNo.setBounds(317, 219, 116, 22);
		panel_6.add(txtOduncUyeNo);
		
		JLabel label_5 = new JLabel("ISBN No :");
		label_5.setFont(new Font("Arial Black", Font.BOLD, 14));
		label_5.setBounds(168, 257, 132, 18);
		panel_6.add(label_5);
		
		txtOduncISBNNo = new JTextField();
		txtOduncISBNNo.setColumns(10);
		txtOduncISBNNo.setBounds(317, 257, 116, 22);
		panel_6.add(txtOduncISBNNo);
		
		JButton btnOduncKitapVer = new JButton("K\u0130TABI \u00D6D\u00DCN\u00C7 VER");
		btnOduncKitapVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Baglanti b = new Baglanti();
					b.OduncVer(Integer.parseInt(txtOduncUyeNo.getText()),Integer.parseInt(txtOduncISBNNo.getText()) );
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"Geçersiz deðerler girdiniz.", "Hata Mesajý", -1);
				}
				
			}
		});
		btnOduncKitapVer.setBounds(305, 304, 143, 46);
		panel_6.add(btnOduncKitapVer);
		
		
		
		
	}
}
