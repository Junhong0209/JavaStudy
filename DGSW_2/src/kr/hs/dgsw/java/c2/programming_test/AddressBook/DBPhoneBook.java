package kr.hs.dgsw.java.c2.programming_test.AddressBook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBPhoneBook implements PhoneBook {
	
	private Connection getConnection() throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");

        return DriverManager.getConnection("jdbc:mariadb://211.53.209.159/dgsw_java", "dgsw_student", "1234");
	}
	
	private NameCard addNameCard (ResultSet rs) throws Exception {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String phoneNumber = rs.getString("phone_number");
		String address = rs.getString("address");
		
		NameCard nameCard = new NameCard();
		nameCard.setId(id);
		nameCard.setName(name);
		nameCard.setPhoneNumber(phoneNumber);
		nameCard.setAddress(address);
		
		return nameCard;
	}
	
	@Override
	public List<NameCard> getList() {
		try {
			Connection con = getConnection();
			
			String sql = "SELECT * FROM phone_book";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			List<NameCard> list = new ArrayList<NameCard>();
			NameCard nameCard = null;
			while (rs.next()) {
				nameCard = addNameCard(rs);
				
				list.add(nameCard);
			}
			
			rs.close();
			pstmt.close();
			con.close();
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public NameCard getCard(int id) {
		try {
			Connection con = getConnection();
			
			String sql = "SELECT * FROM phone_book WHERE id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			NameCard nameCard = null;
			
			if (rs.next()) {
				nameCard = addNameCard(rs);
			}
			
			rs.close();
			pstmt.close();
			con.close();
			
			return nameCard;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public List<NameCard> getCard(String name) {
		try {
			Connection con = getConnection();
			
			String sql = "SELECT * FROM phone_book WHERE name = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			
			ResultSet rs = pstmt.executeQuery();
			
			List<NameCard> list = new ArrayList<NameCard>();
			NameCard nameCard = null;
			while (rs.next()) {
				nameCard = addNameCard(rs);
				
				list.add(nameCard);
			}
			
			rs.close();
			pstmt.close();
			con.close();
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public int addCard(String name, String phoneNumber, String address) {
		try {
			Connection con = getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO phone_book ");
			sql.append("  (name, phone_number, address) ");
			sql.append("VALUES ");
			sql.append("  (?, ?, ?) ");
			
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNumber);
			pstmt.setString(3, address);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	@Override
	public boolean removeCard(int id) {
		try {
			Connection con = getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM phone_book");
			sql.append(" WHERE id = ?");
			
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, id);
			
			pstmt.executeUpdate();
			pstmt.close();
			
			con.close();
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public void updateCard(int id, String name, String phoneNumber, String address) {
		try {
			Connection con = getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE phone_book SET ");
			sql.append(" name = ?, ");
			sql.append("  phone_number = ?, ");
			sql.append("  address = ? ");
			sql.append(" WHERE id = ?");
			
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNumber);
			pstmt.setString(3, address);
			pstmt.setInt(4, id);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int size() {
		List<NameCard> list = this.getList();
		return list.size();
	}
	
}
