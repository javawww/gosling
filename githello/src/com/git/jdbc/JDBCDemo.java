package com.git.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo {

	
	public static void main(String[] args) {
		
		
	}
	
	
	public String get(int id){
		
		String url = "SELECT * FROM t_student WHERE id = " + id;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		return "";
	}
}
