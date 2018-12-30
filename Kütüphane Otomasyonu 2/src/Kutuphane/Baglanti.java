package Kutuphane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Baglanti {
	private String kullanici_adi="root";
	private String parola="";
	
	private String db_ismi ="kutuphane";
	
	private String host="localhost";
	
	private int port=3306;
	
	private Connection con = null;
	private Statement statement =null;
	
	public Baglanti() 
	{
		String url = "jdbc:mysql://" + host + ":" + port + "/" + db_ismi + "?useUnicode=true&characterEncoding=utf8";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		}catch(ClassNotFoundException ex)
		{
			System.out.println("Dirver Bulunamadý");
		}
		
		try {
			con=DriverManager.getConnection(url, kullanici_adi, parola);
		}catch(SQLException ex) {
			System.out.println("Baðlantý Baþarýsýz");
		}
		
	}
	public void GirisYap(String KullaniciAdi, String Sifre) {		
		try {
			boolean buldumu=false;
			String sorgu = "Select *From tblpersoneller";
			statement=con.createStatement();
			ResultSet rs = statement.executeQuery(sorgu);
			while(rs.next()){
				String ka=rs.getString("kullaniciAdi");
				String s = rs.getString("sifre");
				if(KullaniciAdi.compareTo(ka)==0 && Sifre.compareTo(s)==0) {
					buldumu=true;
					AnaMenu anamenu = new AnaMenu();
					anamenu.setVisible(true);		
				}			
			}
			if(buldumu==false)
				JOptionPane.showMessageDialog(null,"Kullanýcý Adý veya Þifre Hatalý", "Hata Mesajý", -1);
		}catch(SQLException ex) {
				JOptionPane.showMessageDialog(null,"Opps! Beklenmeyen bir hata oluþtu.", "Hata Mesajý", -1);
		}
	}
	public void KitapEkle(Kitap kitap) {
		try {
			statement=con.createStatement();
			String sorgu = "Insert Into tblkitaplar(ISBN,KitapAdi,Türü,SayfaSayisi,Yazar,YayinEvi,BasimYili,Adet) VALUES ("+"'"+kitap.ISBN +"', "+"'"+kitap.KitapAdi +"',"+"'"+kitap.Türü +"',"+"'"+kitap.SayfaSayisi +"',"+"'"+kitap.Yazar +"',"+"'"+kitap.YayinEvi +"',"+"'"+kitap.BasimYili+"',"+"'"+kitap.Adet +"')";
			statement.executeUpdate(sorgu);
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null,"Lütfen girdiðiniz deðerleri kontrol ediniz.", "Hata Mesajý", -1);
		}
	}
	public void KitapSil(int ArananISBN, int Adet) {	
		try {
			int ISBN,mevcutadet=0;
			int tempadet;
			String sorgu = "Select *From tblkitaplar";
			statement=con.createStatement();
			ResultSet rs = statement.executeQuery(sorgu);
			while(rs.next()){
			    ISBN=rs.getInt("ISBN");
				if(ArananISBN==ISBN) {
				  mevcutadet=rs.getInt("adet");
				}
			}
			if(mevcutadet >= Adet)
			{
				tempadet= mevcutadet-Adet;
				statement = con.createStatement();
				String sorgu2 = "Update tblkitaplar Set Adet = '"+tempadet+"' where ISBN='"+ArananISBN+"'";
				statement.executeUpdate(sorgu2);
				
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Adet Yetersiz", "Onay Mesajý", -1);
			}
		}	catch(Exception ex) {
				JOptionPane.showMessageDialog(null,"Lütfen girdiðiniz deðerleri kontrol ediniz.", "Hata Mesajý", -1);
			}
		
	}
	public Kitap KitapAra(int ArananISBN) {	
		Kitap k = new Kitap();
		try {
			int ISBN;		
			String sorgu = "Select *From tblkitaplar";
			statement=con.createStatement();
			ResultSet rs = statement.executeQuery(sorgu);
			while(rs.next()){
			    ISBN=rs.getInt("ISBN");
				if(ArananISBN==ISBN) {
					k.KitapAdi =rs.getString("KitapAdi");
					k.Yazar = rs.getString("Yazar");
					k.Türü = rs.getString("Türü");
					k.SayfaSayisi = rs.getInt("SayfaSayisi");
					k.BasimYili = rs.getInt("BasimYili");
					k.YayinEvi = rs.getString("YayinEvi");
					k.Adet = rs.getInt("Adet");
					break;
				}
			}
			
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Lütfen girdiðiniz deðerleri kontrol ediniz.", "Hata Mesajý", -1);
		}
		   return k;
	}
	public void UyeEkle(Uye u) {
		try {
			statement=con.createStatement();
			String sorgu = "Insert Into tbluyeler(ID,ad,soyad,email,cinsiyet) VALUES ("+"'"+u.ID +"', "+"'"+u.Ad +"',"+"'"+u.Soyad+"',"+"'"+u.Email +"',"+"'"+u.Cinsiyet +"')";
			statement.executeUpdate(sorgu);
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null,"Lütfen girdiðiniz deðerleri kontrol ediniz.", "Hata Mesajý", -1);
			}
	}
	public Uye UyeAra(int ArananUyeNo) {	
		Uye u = new Uye();
		try {
			int UyeNo;		
			String sorgu = "Select *From tbluyeler";
			statement=con.createStatement();
			ResultSet rs = statement.executeQuery(sorgu);
			while(rs.next()){
			    UyeNo=rs.getInt("ID");
				if(ArananUyeNo==UyeNo) {
					u.Ad =rs.getString("ad");
					u.Soyad=rs.getString("soyad");
					u.Email=rs.getString("email");
					u.Cinsiyet=rs.getString("cinsiyet");
					break;
				}
			}
			
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Üye Bulunamadý.", "Hata Mesajý", -1);
		}
		   return u;
	}
	public void UyeSil(int ArananUyeNo) {	
		try {	
			statement = con.createStatement();
			String sorgu2 = "Delete from tbluyeler  where ID='"+ArananUyeNo+"'";
			statement.executeUpdate(sorgu2);
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null,"Üye Bulunamadý..", "Hata Mesajý", -1);
			}
	}
	public void OduncVer(int ArananUyeNo,int ArananISBNNo) {
		try {
			boolean boyleuyevarmi=false;
			boolean aynikitapalinmismi=false;
			int ISBNNo,adet=0;
			int UyeNo;
			int OduncUyeID,OduncISBN;
			String sorgu = "Select *From tblkitaplar";
			statement=con.createStatement();
			ResultSet rs = statement.executeQuery(sorgu);
			while(rs.next()){
			    ISBNNo=rs.getInt("ISBN");
				if(ArananISBNNo==ISBNNo) {
					adet =rs.getInt("adet");
					break;
				}
			}
			String sorgu2 = "Select *From tbluyeler";
			statement=con.createStatement();
			ResultSet rs2 = statement.executeQuery(sorgu2);
			while(rs2.next()){
			    UyeNo=rs2.getInt("ID");
				if(ArananUyeNo==UyeNo) {
					boyleuyevarmi=true;
					break;
				}
			}
			String sorgu3 = "Select *From tblodunc";
			statement=con.createStatement();
			ResultSet rs3 = statement.executeQuery(sorgu3);
			while(rs3.next()){
			   OduncISBN=rs3.getInt("ISBN");
			   OduncUyeID=rs3.getInt("uyeID");
				if(ArananISBNNo==OduncISBN && ArananUyeNo==OduncUyeID) {
					aynikitapalinmismi=true;
					break;
				}
			}
			if(boyleuyevarmi==true && adet>0 && aynikitapalinmismi==false)
			{
				adet--;
				statement = con.createStatement();
				String sorgu4 = "Update tblkitaplar Set Adet = '"+adet+"' where ISBN='"+ArananISBNNo+"'";
				statement.executeUpdate(sorgu4);
				statement=con.createStatement();
				String sorgu5 = "Insert Into tblodunc(uyeID,ISBN) VALUES ("+"'"+ArananUyeNo +"', "+"'"+ArananISBNNo +"')";
				statement.executeUpdate(sorgu5);
			}
			else if (aynikitapalinmismi==true)
			{
				JOptionPane.showMessageDialog(null,"Bu kitap ayný üye tarafýndan alýnmýþ", "Hata Mesajý", -1);
			}
			else if(adet==0) {
				JOptionPane.showMessageDialog(null,"Bu kitap kütüphanemizde kalmadý :(", "Hata Mesajý", -1);
			}
			else if(boyleuyevarmi==false )
			{
				JOptionPane.showMessageDialog(null,"Bu IDye ait üye yok ", "Hata Mesajý", -1);
			}
		}		catch(Exception ex) {
				JOptionPane.showMessageDialog(null,"Geçersiz deðerler girdiniz.", "Hata Mesajý", -1);
			}
		
	}
	public void GeriAl(int ArananUyeNo,int ArananISBNNo) {
		int GeriISBN=0,GeriUyeID;
		int adet=0;
		boolean oduncbulundumu=false;
		try {
			String sorgu = "Select *From tblodunc";
			statement=con.createStatement();
			ResultSet rs = statement.executeQuery(sorgu);
			while(rs.next()){
			   GeriISBN=rs.getInt("ISBN");
			   GeriUyeID=rs.getInt("uyeID");
				if(ArananISBNNo==GeriISBN && ArananUyeNo==GeriUyeID) {
					oduncbulundumu=true;
					break;
				}
			}
			if(oduncbulundumu==true)
			{
				statement = con.createStatement();
				String sorgu2 = "Delete from tblodunc  where uyeID='"+ArananUyeNo+"' and ISBN='"+ArananISBNNo+"'";
				statement.executeUpdate(sorgu2);
				String sorgu3 = "Select *From tblkitaplar";
				statement=con.createStatement();
				ResultSet rs3 = statement.executeQuery(sorgu3);
				while(rs3.next()){
					if(ArananISBNNo==GeriISBN) {
						adet=rs3.getInt("adet");
						break;
					}
				}
				adet++;
				statement = con.createStatement();
				String sorgu4 = "Update tblkitaplar Set Adet = '"+adet+"' where ISBN='"+ArananISBNNo+"'";
				statement.executeUpdate(sorgu4);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Bu bilgilere sahip ödünç bulunamadý ", "Hata Mesajý", -1);
			}
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Lütfen girdiðiniz deðerleri kontrol ediniz.", "Hata Mesajý", -1);
		}
		
		
	}
	public static void main(String[] args)
	{
		Baglanti baglanti = new Baglanti();
	}
}
