package pages;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class OOP_SalaryHistory extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table_data;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OOP_SalaryHistory frame = new OOP_SalaryHistory();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	
	public OOP_SalaryHistory() {		
		initialize();
		Condb();
		sum_total();
	}
	
	String Host = "jdbc:mysql://localhost:3306/project";
	String User = "root";
	String Password = "";
	private JTextField txt_search;
	
	private void Condb() {	
		try {
			Connection conn = null;
			conn = (Connection) DriverManager.getConnection(Host, User, Password);
			System.out.println("Connect Database OOP_Item");
			Statement stmt = conn.createStatement();
	        String sql = "SELECT * FROM seller_history";
	        ResultSet res= stmt.executeQuery(sql);
	        DefaultTableModel model = null ;
	        
	        model = (DefaultTableModel) table_data.getModel();
	           
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
	

	public void initialize() {
		this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
		bi.setNorthPane(null);
		setBounds(0, 0, 717, 640);
		getContentPane().setBackground(Color.ORANGE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0E22\u0E2D\u0E14\u0E01\u0E32\u0E23\u0E02\u0E32\u0E22\u0E2A\u0E34\u0E19\u0E04\u0E49\u0E32");
		lblNewLabel.setFont(new Font("Angsana New", Font.BOLD, 23));
		lblNewLabel.setBounds(10, 11, 143, 33);
		getContentPane().add(lblNewLabel);
		
		table_data = new JTable();
		table_data.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"id", "name", "amount", "price", "date"
			}
		));
		table_data.setBounds(10, 59, 697, 474);
		//getContentPane().add(table_data);
		
		JLabel lblNewLabel_1 = new JLabel("\u0E22\u0E2D\u0E14\u0E23\u0E27\u0E21");
		lblNewLabel_1.setFont(new Font("Angsana New", Font.BOLD, 29));
		lblNewLabel_1.setBounds(430, 558, 71, 33);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u0E1A\u0E32\u0E17");
		lblNewLabel_1_1.setFont(new Font("Angsana New", Font.BOLD, 29));
		lblNewLabel_1_1.setBounds(609, 558, 58, 33);
		getContentPane().add(lblNewLabel_1_1);
	}
	
	public void sum_total() {
		JLabel lb_sum = new JLabel("");
		lb_sum.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lb_sum.setBounds(511, 566, 88, 21);
		getContentPane().add(lb_sum);
		int sum = 0;
		int numrow = table_data.getRowCount();
		for(int i = 0 ; i< numrow;i++ ) {
			int val = Integer.valueOf(table_data.getValueAt(i, 3).toString());
			sum += val;
			//sum+=Integer.valueOf(table_data.getValueAt(i, 3).toString());
		}
		lb_sum.setText(String.valueOf(sum));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 59, 697, 474);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(table_data);
		
		txt_search = new JTextField();
		txt_search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_search.setText("");
			}
		});
		txt_search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				DefaultTableModel table = (DefaultTableModel)table_data.getModel();
				String search = txt_search.getText();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
				table_data.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(search));
				
				int rownum = tr.getViewRowCount();
				int sum = 0;
				for(int i = 0;i < rownum;i++) {
					sum+=(int)(table.getValueAt(tr.convertRowIndexToModel(i), 3));					
				}
				System.out.println("=="+sum);
				lb_sum.setText(String.valueOf(sum));
			}
		});
		txt_search.setColumns(10);
		txt_search.setBounds(479, 16, 228, 25);
		getContentPane().add(txt_search);
		
		JLabel lblNewLabel_2 = new JLabel("\u0E0A\u0E37\u0E48\u0E2D\u0E2A\u0E34\u0E19\u0E04\u0E49\u0E32");
		lblNewLabel_2.setFont(new Font("Angsana New", Font.BOLD, 27));
		lblNewLabel_2.setBounds(408, 10, 71, 33);
		getContentPane().add(lblNewLabel_2);
	}
}
