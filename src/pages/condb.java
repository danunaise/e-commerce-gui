package pages;
import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class condb {

	String Host = "jdbc:mysql://localhost:3306/project";
	String User = "root";
	String Password = "";
	
	private void Condb() {	
		try {
			Connection conn = null;
			conn = (Connection) DriverManager.getConnection(Host, User, Password);
			System.out.println("Connect Database");
			Statement stmt = conn.createStatement();
	        String sql = "SELECT * FROM user";
	        ResultSet res= stmt.executeQuery(sql);
	        DefaultTableModel model = null ;
	        
	        //model = (DefaultTableModel) table_data.getModel();
	           
            model.setRowCount(0);
             ResultSetMetaData meta = res.getMetaData();
             int numberOfColumns = meta.getColumnCount();
            
             while(res.next()){
             Object [] rowData = new Object[numberOfColumns];
                 for (int i = 0; i < rowData.length; ++i)
                 {
                     rowData[i] = res.getObject(i+1);
                 }
                 model.addRow(rowData);            
             }
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null,
				    "Could not connect to database.",
				    "data base error",
				    JOptionPane.ERROR_MESSAGE);
		    System.out.println(e.getMessage());
		} 		
	}

}
