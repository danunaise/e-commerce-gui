package pages;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.sql.*;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;

public class OOP_Dayseller extends JInternalFrame {

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
					OOP_Dayseller frame = new OOP_Dayseller();
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
	public OOP_Dayseller() {
		initialize();
		Condb();
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
	
	private void initialize() {
		this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
		bi.setNorthPane(null);
		setBounds(0, 0, 717, 640);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 0, 717, 613);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0E22\u0E2D\u0E14\u0E01\u0E32\u0E23\u0E02\u0E32\u0E22\u0E2A\u0E34\u0E19\u0E04\u0E49\u0E32\u0E23\u0E32\u0E22\u0E27\u0E31\u0E19");
		lblNewLabel.setFont(new Font("Angsana New", Font.BOLD, 27));
		lblNewLabel.setBounds(10, 11, 198, 33);
		panel.add(lblNewLabel);
		
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
		
		JLabel lb_sum = new JLabel("0");
		lb_sum.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lb_sum.setBounds(504, 567, 88, 21);
		panel.add(lb_sum);
		
		
		txt_search = new JTextField();
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
		txt_search.setBounds(479, 20, 228, 25);
		panel.add(txt_search);
		txt_search.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 55, 697, 480);
		panel.add(scrollPane);
		scrollPane.setViewportView(table_data);
		
		JLabel lblNewLabel_2 = new JLabel("\u0E27\u0E31\u0E19\u0E17\u0E35\u0E48");
		lblNewLabel_2.setFont(new Font("Angsana New", Font.BOLD, 27));
		lblNewLabel_2.setBounds(430, 15, 46, 33);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("\u0E22\u0E2D\u0E14\u0E23\u0E27\u0E21");
		lblNewLabel_1_2.setFont(new Font("Angsana New", Font.BOLD, 29));
		lblNewLabel_1_2.setBounds(430, 558, 71, 33);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\u0E1A\u0E32\u0E17");
		lblNewLabel_1_1_1.setFont(new Font("Angsana New", Font.BOLD, 29));
		lblNewLabel_1_1_1.setBounds(602, 558, 58, 33);
		panel.add(lblNewLabel_1_1_1);
		
		
		
	}
}
