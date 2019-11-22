package com.ustglobal.hibernatecrudoperation.jdbc;

import java.sql.*;
import com.mysql.jdbc.Driver;

public class ExecuteInsert {
	
	public static void main(String[] args) {

		Connection conn = null;
		//Statement stmt = null;
		PreparedStatement pstmt = null;

		try {
			// Step 1 Load the Driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			// Step 2 Get the Connection
			String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=tiger";
			conn = DriverManager.getConnection(url);

			// Step 3 Issue SQL query
			//			String sql = " insert into employee_info values "
			//					+ " ("+args[0]+",'"+args[1]+"',"+args[2]+",'"+args[3]+"') ";
			//			stmt = conn.createStatement();

			String sql = "insert into employee_info values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			String empid = args[0];
			int id = Integer.parseInt(empid);
			pstmt.setInt(1,id);

			String name = args[1];
			pstmt.setString(2, name);

			String empsal = args[2];
			int sal = Integer.parseInt(empsal);
			pstmt.setInt(3,sal);

			String gender = args[3];
			pstmt.setString(4, gender);

			int count = pstmt.executeUpdate();

			//	int count = stmt.executeUpdate(sql);

			//Step 4 Read the Result
			System.out.println(count + " Row(s) inserted ");

		}catch(SQLException e) {
			e.printStackTrace();

		}finally {

			// step 5 Close all JDBC Objects
			try {
				if(conn!=null) {
					conn.close();
				}if (pstmt!=null) {
					pstmt.close();}
				//				}if (stmt!=null) {
				//					stmt.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}

	} // end of main()


}