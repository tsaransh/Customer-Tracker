package com.JDBC.TestServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class TestDatabase
 */
@WebServlet("/TestDatabase")
public class TestDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// setup connection variables
		String user = "SpringApplication";
		String pass = "springapps";
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String drvier = "com.mysql.jdbc.Driver";
		// get connection to database
		try {
			PrintWriter out = response.getWriter();
			out.println("connecting to database: "+jdbcUrl);
			Class.forName(drvier);
			Connection cn = DriverManager.getConnection(jdbcUrl,user,pass);
			out.println("SUCCESS!!!");
			
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
