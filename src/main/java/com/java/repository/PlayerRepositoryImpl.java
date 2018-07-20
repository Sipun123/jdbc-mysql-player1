package com.java.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.model.Player;
import com.java.utils.PlayerQueries;

public class PlayerRepositoryImpl implements IPlayerRepository {

	public void save(Player pl, Connection con) throws SQLException {
		// TODO Auto-generated method stub
		
		PreparedStatement ps=con.prepareStatement(PlayerQueries.INSERT);
		ps.setInt(1, pl.id);
		ps.setString(2, pl.name);
		ps.setString(3, pl.country);
		ps.setInt(4, pl.rank);
		
		ps.executeUpdate();
		
	}

	public void updateNameAndSalary(String name, String salary, int id, Connection con) {
		// TODO Auto-generated method stub

	}

	public void updateCity(String city, int id, Connection con) {
		// TODO Auto-generated method stub

	}

	public List<Player> findAll(Connection con) throws SQLException {
		// TODO Auto-generated method stub
		List<Player> players=new ArrayList<Player>();
		PreparedStatement ps=con.prepareStatement(PlayerQueries.SELECT_ALL);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Player pl=new Player();
			pl.id=rs.getInt("ID");// ID is column_name in the table tbl_player
			pl.name=rs.getString("NAME");
			pl.country=rs.getString("COUNTRY");
			pl.rank=rs.getInt("RANK");
			
			players.add(pl);
		}
		return players;
	}

	public Player findById(int id, Connection con) throws SQLException {
		// TODO Auto-generated method stub
		Player pl=new Player();
		PreparedStatement ps=con.prepareStatement(PlayerQueries.SELECT_BY_ID);
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			pl.id=rs.getInt("ID");// ID is column_name in the table tbl_employee
			pl.name=rs.getString("NAME");
			pl.country=rs.getString("COUNTRY");
			pl.rank=rs.getInt("RANK");
		}
		
		return pl;
		
	}

	public void deleteById(int id, Connection con) {
		// TODO Auto-generated method stub

	}

	public void deleteAll(Connection con) {
		// TODO Auto-generated method stub

	}

	public void updateNameAndRANK(String name, int rank, int id, Connection con) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps=con.prepareStatement(PlayerQueries.UPDATE_NAME_RANK);
		ps.setString(1,name);
		ps.setInt(2, rank);
		ps.setInt(3, id);
		ps.executeUpdate();
	}

	public void updateCountry(String country, int id, Connection con) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps=con.prepareStatement(PlayerQueries.UPDATE_COUNTRY);
		ps.setInt(2,id);
		ps.setString(1, country);
		
		ps.executeUpdate();
			
	}

}
