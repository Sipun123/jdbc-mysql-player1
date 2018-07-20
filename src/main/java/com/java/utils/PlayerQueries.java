package com.java.utils;

public class PlayerQueries {

	public static final String INSERT = "INSERT INTO TBL_PLAYER(ID,NAME,COUNTRY,RANK) VALUES(?,?,?,?)";

	public static final String SELECT_ALL = "SELECT *FROM TBL_PLAYER";
	public static final String SELECT_BY_ID = "SELECT * FROM TBL_PLAYER WHERE ID=?";
	public static final String UPDATE_COUNTRY = "UPDATE TBL_PLAYER SET COUNTRY=? WHERE ID=?";
	public static final String UPDATE_NAME_RANK = "UPDATE TBL_PLAYER SET NAME=?,RANK=? WHERE ID=?";
	public static final String DELETE_BY_ID = "DELETE FROM TBL_PLAYER WHERE ID=?";
}
