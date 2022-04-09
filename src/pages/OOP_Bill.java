package pages;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.sql.*;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;


public class OOP_Bill extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txt_Namebill;
	private JTextField txt_Quantitybill;
	private JTextField txt_Pricebill;
	private JTable table_bill;
	private JTable table_databill;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OOP_Bill frame = new OOP_Bill();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public OOP_Bill() {
		initialize();
		Condb();
		Condb2();
	}
	
	String Host = "jdbc:mysql://localhost:3306/project";
	String User = "root";
	String Password = "";
	private JTextField txt_date;
	

	private void Condb() {	
		try {
			Connection conn = null;
			conn = (Connection) DriverManager.getConnection(Host, User, Password);
			System.out.println("Connect Database OOP_Item");
			Statement stmt = conn.createStatement();
	        String sql = "SELECT * FROM user";
	        ResultSet res= stmt.executeQuery(sql);
	        DefaultTableModel model = null ;
	        
	        model = (DefaultTableModel) table_databill.getModel();
	           
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
	private void Condb2() {	
		try {
			Connection conn = null;
			conn = (Connection) DriverManager.getConnection(Host, User, Password);
			System.out.println("Connect Database OOP_Item");
			Statement stmt = conn.createStatement();
	        String sql = "SELECT * FROM seller_history";
	        ResultSet res= stmt.executeQuery(sql);
	        DefaultTableModel model = null ;
	        
	        model = (DefaultTableModel) table_bill.getModel();
	           
            model.setRowCount(0);
             ResultSetMetaData meta2 = res.getMetaData();
             int numberOfColumns2 = meta2.getColumnCount();
            
             while(res.next()){
             Object [] rowData = new Object[numberOfColumns2];
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
	/**
	 * Create the frame.
	 */
	
	
	private void initialize() {
		this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
		bi.setNorthPane(null);
		setBounds(0, 0, 717, 640);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 102, 255));
		panel.setBounds(0, 0, 717, 613);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0E08\u0E31\u0E14\u0E01\u0E32\u0E23\u0E1A\u0E34\u0E25\u0E02\u0E32\u0E22\u0E2A\u0E34\u0E19\u0E04\u0E49\u0E32");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Angsana New", Font.BOLD, 25));
		lblNewLabel.setBounds(45, 14, 142, 29);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("\u0E0A\u0E37\u0E48\u0E2D\u0E2A\u0E34\u0E19\u0E04\u0E49\u0E32");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Angsana New", Font.BOLD, 25));
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(55, 54, 78, 29);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u0E08\u0E33\u0E19\u0E27\u0E19");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Angsana New", Font.BOLD, 25));
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setBounds(55, 111, 78, 29);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u0E23\u0E32\u0E04\u0E32");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Angsana New", Font.BOLD, 25));
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setBounds(55, 178, 78, 29);
		panel.add(lblNewLabel_4);
		
		txt_Namebill = new JTextField();
		txt_Namebill.setBounds(132, 54, 187, 29);
		panel.add(txt_Namebill);
		txt_Namebill.setColumns(10);
		
		txt_Quantitybill = new JTextField();
		txt_Quantitybill.setColumns(10);
		txt_Quantitybill.setBounds(132, 116, 187, 29);
		panel.add(txt_Quantitybill);
		
		txt_Pricebill = new JTextField();
		txt_Pricebill.setColumns(10);
		txt_Pricebill.setBounds(132, 178, 187, 29);
		panel.add(txt_Pricebill);
		
		JTextArea txtBill = new JTextArea();
		txtBill.setFont(new Font("Monospaced", Font.PLAIN, 14));
		txtBill.setEditable(false);
		txtBill.setBounds(45, 11, 321, 334);
		//panel.add(txtBill);

		txtBill.setText(" ====================================="+"\n"
			            + "\t      Synlixz Inc"+"\n"
					    + "Computer & electronic equipment for you"+"\n"
					    + "     address xx/xx Nang Linchi Rd, \n"
					    + "   Thung Maha Mek, Sathorn District,\n "
					    + "      Bangkok 10120 Thailand"+"\n"
					    +" ====================================="+"\n"
					    +"\tname\tamount\tprice"+"\n");
		JButton btnNewButton = new JButton("\u0E40\u0E1E\u0E34\u0E48\u0E21\u0E23\u0E32\u0E22\u0E01\u0E32\u0E23");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String data_namebill = txt_Namebill.getText();
				String data_amountbill = txt_Quantitybill.getText();
				String data_pricebill = txt_Pricebill.getText();
						if((data_namebill == null || data_namebill.length()==0)||(data_amountbill == null || data_amountbill.length()==0)||(data_pricebill == null || data_pricebill.length()==0)) {
							JOptionPane.showMessageDialog(null,
								    "Please complete the information.",
								    "insert error",
								    JOptionPane.ERROR_MESSAGE);
						}else if((data_namebill != null || data_namebill.length()!=0)||(data_amountbill != null || data_amountbill.length()!=0)||(data_pricebill != null || data_pricebill.length()!=0)) {
							txtBill.setText(
								    txtBill.getText()+"   " +txt_Namebill.getText()+"\t"+txt_Quantitybill.getText()+"\t"+txt_Pricebill.getText()+"\n"
								    );

								    txt_Namebill.setText("");
								    txt_Quantitybill.setText("");
								    txt_Pricebill.setText("");
						}						
			}
		});
		btnNewButton.setFont(new Font("Angsana New", Font.BOLD, 20));
		btnNewButton.setBounds(122, 308, 101, 37);
		panel.add(btnNewButton);
		
		table_bill = new JTable();
		table_bill.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "name", "amount", "price", "date"
			}
		));
		table_bill.setBounds(31, 190, 321, 190);
		//panel.add(table_bill);
		
		JButton btnNewButton_1 = new JButton("\u0E22\u0E01\u0E40\u0E25\u0E34\u0E01\u0E1A\u0E34\u0E25");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtBill.setText("    ");
			}
		});
		btnNewButton_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtBill.setText(" ");
			}
		});
		btnNewButton_1.setFont(new Font("Angsana New", Font.BOLD, 20));
		btnNewButton_1.setBounds(606, 356, 101, 37);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("\u0E23\u0E32\u0E22\u0E01\u0E32\u0E23\u0E2A\u0E34\u0E19\u0E04\u0E49\u0E32");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Angsana New", Font.BOLD, 25));
		lblNewLabel_2_2.setBackground(Color.WHITE);
		lblNewLabel_2_2.setBounds(31, 372, 108, 29);
		panel.add(lblNewLabel_2_2);
		
		table_databill = new JTable();
		table_databill.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "name", "quantity", "price"
			}
		));
		table_databill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table_databill.getSelectedRow();
				//txt_Idbill.setText(String.valueOf(table_databill.getValueAt(row, 0)));
				txt_Namebill.setText(String.valueOf(table_databill.getValueAt(row, 1)));
				txt_Quantitybill.setText(String.valueOf(table_databill.getValueAt(row, 2)));
				txt_Pricebill.setText(String.valueOf(table_databill.getValueAt(row, 3)));
			}
		});
		table_databill.setBounds(281, 463, 321, 190);
		//panel.add(table_databill);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("\u0E23\u0E32\u0E22\u0E01\u0E32\u0E23\u0E1A\u0E34\u0E25\u0E2A\u0E34\u0E19\u0E04\u0E49\u0E32");
		lblNewLabel_2_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1.setFont(new Font("Angsana New", Font.BOLD, 25));
		lblNewLabel_2_2_1.setBackground(Color.WHITE);
		lblNewLabel_2_2_1.setBounds(386, 370, 133, 29);
		panel.add(lblNewLabel_2_2_1);
		
		JButton btnNewButton_2 = new JButton("\u0E22\u0E37\u0E19\u0E22\u0E31\u0E19\u0E1A\u0E34\u0E25");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//check data is empty
				String data_name = txt_Namebill.getText();
				String data_amount = txt_Quantitybill.getText();
				String data_price = txt_Pricebill.getText();
				if((data_name == null || data_name.length()==0)||(data_amount == null || data_amount.length()==0)||(data_price == null || data_price.length()==0))
				{
					JOptionPane.showMessageDialog(null,
						    "Please complete the information.",
						    "insert error",
						    JOptionPane.ERROR_MESSAGE);
				//show error message here
				}else if((data_name != null || data_name.length()!=0)||(data_amount != null || data_amount.length()!=0)||(data_price != null || data_price.length()!=0)) {
					int ns = JOptionPane.showConfirmDialog(null,
						    "Do you want to add data?",
						    "An Inane Question",
						    JOptionPane.YES_NO_OPTION);
					if(ns==JOptionPane.YES_OPTION) {
						try {
				            Connection con = DriverManager.getConnection(Host, User, Password);
				            Statement stmt = con.createStatement();
				            
				            System.out.print("Connection");
				            
				            String sql = "INSERT INTO seller_history (NAME,AMOUNT,PRICE,DATE) VALUES ("
					            		+ "'"+txt_Namebill.getText()+"',"
					            		+ "'"+txt_Quantitybill.getText()+"',"
					            		+ "'"+txt_Pricebill.getText()+"',"
					            		+ "'"+txt_date.getText()+"')";
				            System.out.println(sql);
				            System.out.println("ADD  DATA-->");
				            stmt.execute(sql) ;
				            
				            //JOptionPane.showMessageDialog(null, "Insert");
				            
				           // txt_Idbill.setText("");
				            txt_Namebill.setText("");
				            txt_Quantitybill.setText("");
				            txt_Pricebill.setText("");
				             
				            JOptionPane.showMessageDialog(null, "Add DATA Successfuly");

				            Condb();
				            
				        } catch (SQLException ex) {
				        	System.out.println(ex.getMessage());
				        }
					}else if(ns==JOptionPane.NO_OPTION) {
						return;
					}
				}
				
			}
		});
		btnNewButton_2.setFont(new Font("Angsana New", Font.BOLD, 20));
		btnNewButton_2.setBounds(253, 308, 101, 37);
		panel.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table_databill.getSelectedRow();
				//txt_Idbill.setText(String.valueOf(table_databill.getValueAt(row, 0)));
				txt_Namebill.setText(String.valueOf(table_databill.getValueAt(row, 1)));
				txt_Quantitybill.setText(String.valueOf(table_databill.getValueAt(row, 2)));
				txt_Pricebill.setText(String.valueOf(table_databill.getValueAt(row, 3)));
			}
		});
		scrollPane.setBounds(31, 412, 321, 190);
		panel.add(scrollPane);
		scrollPane.setViewportView(table_databill);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(376, 14, 331, 334);
		panel.add(scrollPane_1);
		scrollPane_1.setViewportView(txtBill);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(376, 412, 331, 190);
		panel.add(scrollPane_2);
		scrollPane_2.setViewportView(table_bill);
		
		txt_date = new JTextField();
		txt_date.setColumns(10);
		txt_date.setBounds(132, 239, 187, 29);
		panel.add(txt_date);
		
		JLabel lblNewLabel_4_1 = new JLabel("\u0E27\u0E31\u0E19\u0E17\u0E35\u0E48");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Angsana New", Font.BOLD, 25));
		lblNewLabel_4_1.setBackground(Color.WHITE);
		lblNewLabel_4_1.setBounds(55, 239, 78, 29);
		panel.add(lblNewLabel_4_1);



	}
}
