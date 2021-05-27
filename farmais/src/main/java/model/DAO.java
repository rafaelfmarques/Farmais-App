package model;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {

	private Connection conectar() {

		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?serverTimezone=UTC", "",
					"");
			return con;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// CRUD CREATE
	public void insertRemedio(Remedio remedio) {

		String create = "INSERT INTO remedio (nome_tec, tipo_tarja, nome_com, nome_fab) VALUES (?, ?, ?, ?)";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);

			// Substituir os (?) pelos values recebidos no form
			pst.setString(1, remedio.getNome_tec());
			pst.setString(2, remedio.getTipo_tarja());
			pst.setString(3, remedio.getNome_com());
			pst.setString(4, remedio.getNome_fab());
			pst.executeUpdate();

			con.close();
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
	}

	// CRUD READ
	public ArrayList<Remedio> readRemedios() {
		ArrayList<Remedio> remedios = new ArrayList<>();

		String read = "SELECT * FROM remedio ORDER BY idrem";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			//rs.next verifica se ha o dado
			while (rs.next()) {
				String idrem = rs.getString(1);
				String nome_tec = rs.getString(2);
				String tipo_tarja = rs.getString(3);
				String nome_com = rs.getString(4);
				String nome_fab = rs.getString(5);
				String data_atual = rs.getString(6);
				remedios.add(new Remedio(idrem, nome_tec, tipo_tarja, nome_com, nome_fab, data_atual));

			}

			con.close();
			return remedios;

		} catch (Exception e) {
			System.out.println("Erro: " + e);
			return null;
		}

	}

	// CRUD UPDATE

	public void selecionarRemedio(Remedio remedios) {

		String list = "SELECT * FROM remedio WHERE idrem=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(list);
			pst.setString(1, remedios.getIdrem());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// Variaveis Remedios
				remedios.setIdrem(rs.getString(1));
				remedios.setNome_tec(rs.getString(2));
				remedios.setTipo_tarja(rs.getString(3));
				remedios.setNome_com(rs.getString(4));
				remedios.setNome_fab(rs.getString(5));
				remedios.setData_atual(rs.getString(6));
			}
			con.close();

		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
	}
	
	public void alterarRemedio(Remedio remedios) {
	
		String editar = "UPDATE remedio SET nome_tec=?, tipo_tarja=?, nome_com=?, nome_fab=? WHERE idrem=?";
	
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(editar);

			pst.setString(1, remedios.getNome_tec());
			pst.setString(2, remedios.getTipo_tarja());
			pst.setString(3, remedios.getNome_com());
			pst.setString(4, remedios.getNome_fab());
			pst.setString(5, remedios.getIdrem());
			
			pst.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			System.out.println("Erro: "+e);
		}
	}
	
	//CRUD DELETE
	
	public void removerRemedio(Remedio remedios) {
		String remover = "DELETE FROM remedio WHERE idrem=?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(remover);
			
			pst.setString(1, remedios.getIdrem());
			pst.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			System.out.println("Erro: "+e);
		}
	}
	
	//cria o funcionario
	
	public void cadastraFunc(Func func) {
		String create = "INSERT INTO func (nome, fone, email, passw) VALUES (?, ?, ?, ?)";

		try {
			//recebe a senha e gera o hash
			MessageDigest md = MessageDigest.getInstance("SHA-256");	
			byte messageDigest[] = md.digest(func.getPassw().getBytes("UTF-8"));
			StringBuilder sb = new StringBuilder();
			
			for (byte b : messageDigest) {
				sb.append(String.format("%02X", 0xFF & b));
			
			}
			
			//senha recebe o hash
			String senha = sb.toString();

			
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);

			// Substituir os (?) pelos values recebidos no form
			pst.setString(1, func.getNome());
			pst.setString(2, func.getFone());
			pst.setString(3, func.getEmail());
			pst.setString(4, senha);
			pst.executeUpdate();

			con.close();
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
	}
	//autentica o usuario
	public boolean autenticar(Func func) {
		String read = "SELECT * FROM func WHERE email=? AND passw=?";
		
		try {
			//cria o hash
			MessageDigest md = MessageDigest.getInstance("SHA-256");	
			byte messageDigest[] = md.digest(func.getPassw().getBytes("UTF-8"));
			StringBuilder sb = new StringBuilder();
			
			for (byte b : messageDigest) {
				sb.append(String.format("%02X", 0xFF & b));
			
			}
			//senha recebe o has gerado
			String senha = sb.toString();
			
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
   
			pst.setString(1, func.getEmail());
			pst.setString(2, senha);
			
			ResultSet rs = pst.executeQuery();
			
			//se true usuario existe
			if(rs.next()) {
				return true;
			}
						
		} catch (Exception e) {
			return false;
		}
		
		return false;
		
	}
	
}
