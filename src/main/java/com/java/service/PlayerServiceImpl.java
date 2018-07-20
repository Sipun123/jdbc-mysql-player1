package com.java.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.java.model.Player;
import com.java.repository.IPlayerRepository;
import com.java.utils.ConnectionUtils;

public class PlayerServiceImpl implements IPlayerService {

	private IPlayerRepository repository;

	public PlayerServiceImpl(IPlayerRepository repository) {
		this.repository = repository;
	}

	public void save(Player pl) {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			con = ConnectionUtils.getConnection(); // create connection
			repository.save(pl, con); // save
			con.commit();// commit
			System.out.println("**** saved player: " + pl.id);
		} catch (Exception e) {
			// TODO: handle exception
			try {
				con.rollback(); // rollback
				System.out.println("**** failed to save player: " + pl.id);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				ConnectionUtils.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void updateNameAndRank(String name, int rank, int id) {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			con = ConnectionUtils.getConnection();
			repository.updateNameAndRANK(name, rank, id, con);
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally {

			try {
				ConnectionUtils.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public void updateCountry(String country, int id) {
		// TODO Auto-generated method stub

		Connection con = null;

		try {
			con = ConnectionUtils.getConnection();
			repository.updateCountry(country, id, con);
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				ConnectionUtils.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public List<Player> findAll() {
		List<Player> players = null;
		Connection con = null;
		try {
			con = ConnectionUtils.getConnection();
			players = repository.findAll(con);// try
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ConnectionUtils.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // finally try
		}
		return players;
	}

	public Player findById(int id) {

		Player pl = null;
		Connection con = null;
		try {
			con = ConnectionUtils.getConnection();
			pl = repository.findById(id, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ConnectionUtils.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return pl;
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub

	}

	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
