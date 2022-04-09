package pages;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class OOP_Item extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txt_Id;
	private JTextField txt_Name;
	private JTextField txt_Quantity;
	private JTextField txt_Price;
	private JTextField txt_search;
	private JTable table_data;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OOP_Item frame = new OOP_Item();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public OOP_Item() {
		initialize();
		Condb();
	}
	
	String Host = "jdbc:mysql://localhost:3306/project";
	String User = "root";
	String Password = "";
	
	private void Condb() {	
		try {
			Connection conn = null;
			conn = (Connection) DriverManager.getConnection(Host, User, Password);
			System.out.println("Connect Database OOP_Item");
			Statement stmt = conn.createStatement();
	        String sql = "SELECT * FROM user";
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
	
	/**
	 * Create the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		
		this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
		bi.setNorthPane(null);
		
		setBounds(0, 0, 717, 640);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 204, 153));
		panel.setBounds(0, 0, 717, 613);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0E04\u0E25\u0E31\u0E07\u0E2A\u0E34\u0E19\u0E04\u0E49\u0E32");
		lblNewLabel.setForeground(new Color(255, 255, 102));
		lblNewLabel.setBounds(303, 11, 127, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		panel.add(lblNewLabel);
		
		JLabel lb_id = new JLabel("\u0E23\u0E2B\u0E31\u0E2A\u0E2A\u0E34\u0E19\u0E04\u0E49\u0E32");
		lb_id.setForeground(new Color(255, 255, 204));
		lb_id.setBounds(60, 67, 90, 17);
		lb_id.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lb_id);
		
		txt_Id = new JTextField();
		txt_Id.setBounds(165, 63, 170, 25);
		txt_Id.setColumns(10);
		panel.add(txt_Id);
		
		JLabel lb_name = new JLabel("\u0E0A\u0E37\u0E48\u0E2D\u0E2A\u0E34\u0E19\u0E04\u0E49\u0E32");
		lb_name.setForeground(new Color(255, 255, 204));
		lb_name.setBounds(60, 103, 90, 17);
		lb_name.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lb_name);
		
		txt_Name = new JTextField();
		txt_Name.setBounds(165, 99, 170, 25);
		txt_Name.setColumns(10);
		panel.add(txt_Name);
		
		JLabel lb_quantity = new JLabel("\u0E08\u0E33\u0E19\u0E27\u0E19");
		lb_quantity.setForeground(new Color(255, 255, 204));
		lb_quantity.setBounds(360, 67, 98, 17);
		lb_quantity.setFont(new Font("Tahoma", Font.BOLD, 19));
		panel.add(lb_quantity);
		
		txt_Quantity = new JTextField();
		txt_Quantity.setBounds(460, 62, 170, 25);
		txt_Quantity.setColumns(10);
		panel.add(txt_Quantity);
		
		JLabel lb_price = new JLabel("\u0E23\u0E32\u0E04\u0E32\u0E2A\u0E34\u0E19\u0E04\u0E49\u0E32");
		lb_price.setForeground(new Color(255, 255, 204));
		lb_price.setBounds(360, 103, 98, 17);
		lb_price.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lb_price);
		
		txt_Price = new JTextField();
		txt_Price.setBounds(460, 99, 170, 25);
		txt_Price.setColumns(10);
		panel.add(txt_Price);
		
		
		
		JButton btnNewButton = new JButton("\u0E40\u0E1E\u0E34\u0E48\u0E21\u0E2A\u0E34\u0E19\u0E04\u0E49\u0E32");
		btnNewButton.addMouseListener(new MouseAdapter() {
			//insert
			@Override
			public void mouseClicked(MouseEvent e) {
				//check data is empty
				String data_id = txt_Id.getText();
				String data_name = txt_Name.getText();
				String data_amount = txt_Quantity.getText();
				String data_price = txt_Price.getText();
				if((data_id == null || data_id.length()==0)||(data_name == null || data_name.length()==0)||(data_amount == null || data_amount.length()==0)||(data_price == null || data_price.length()==0))
				{
					JOptionPane.showMessageDialog(null,
						    "Please complete the information.",
						    "insert error",
						    JOptionPane.ERROR_MESSAGE);
				//show error message here
				}else if((data_id != null || data_id.length()!=0)||(data_name != null || data_name.length()!=0)||(data_amount != null || data_amount.length()!=0)||(data_price != null || data_price.length()!=0)) {
					int ns = JOptionPane.showConfirmDialog(null,
						    "Do you want to add data?",
						    "An Inane Question",
						    JOptionPane.YES_NO_OPTION);
					if(ns==JOptionPane.YES_OPTION) {
						try {
				            Connection con = DriverManager.getConnection(Host, User, Password);
				            Statement stmt = con.createStatement();
				            
				            System.out.print("Connection");
				            
				            String sql = "INSERT INTO USER (ID,NAME,QUANTITY,PRICE) VALUES ("
					            		+ "'"+txt_Id.getText()+"',"
					            		+ "'"+txt_Name.getText()+"',"
					            		+ "'"+txt_Quantity.getText()+"',"
					            		+ "'"+txt_Price.getText()+"')";
				            System.out.println(sql);
				            System.out.println("ADD  DATA-->");
				            stmt.execute(sql) ;
				            
				            //JOptionPane.showMessageDialog(null, "Insert");
				            
				            txt_Id.setText("");
				            txt_Name.setText("");
				            txt_Quantity.setText("");
				            txt_Price.setText("");
				             
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
		btnNewButton.setFont(new Font("Angsana New", Font.BOLD, 18));
		btnNewButton.setBounds(54, 203, 107, 35);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u0E41\u0E01\u0E49\u0E44\u0E02\u0E2A\u0E34\u0E19\u0E04\u0E49\u0E32");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			//edit
			public void mouseClicked(MouseEvent e) {
				//check data is empty
				String data_id = txt_Id.getText();
				String data_name = txt_Name.getText();
				String data_amount = txt_Quantity.getText();
				String data_price = txt_Price.getText();
				if((data_id == null || data_id.length()==0)||(data_name == null || data_name.length()==0)||(data_amount == null || data_amount.length()==0)||(data_price == null || data_price.length()==0))
				{
					JOptionPane.showMessageDialog(null,
						    "Please complete the information.",
						    "insert error",
						    JOptionPane.ERROR_MESSAGE);
				//show error message here
				}else if((data_id != null || data_id.length()!=0)||(data_name != null || data_name.length()!=0)||(data_amount != null || data_amount.length()!=0)||(data_price != null || data_price.length()!=0)) {
					int ns = JOptionPane.showConfirmDialog(null,
						    "Do you want to edit?",
						    "Question",
						    JOptionPane.YES_NO_OPTION);
						if(ns==JOptionPane.YES_OPTION) {
							try {
		                        Connection conn ;
		                        conn = (Connection) DriverManager.getConnection(Host, User, Password);
		                        Statement stmt = conn.createStatement();

		                        System.out.println("UPDATE  DATA IN DATABASE");

		                        String sql = "UPDATE user SET ID = '"+txt_Id.getText()+"',NAME = '"+txt_Name.getText()+"'  , QUANTITY = '"+Integer.parseInt(txt_Quantity.getText())+"' , PRICE = "+Integer.parseInt(txt_Price.getText())+"  WHERE ID = "+txt_Id.getText();
		                        stmt.execute(sql) ;
		                        JOptionPane.showMessageDialog(null, "Update  Profile ID :"+txt_Id.getText());
		                        Condb() ;
		                        System.out.print(sql);
		                    } catch (SQLException ex) {
		                        System.out.println(ex.getMessage());
		                    }
						}else if(ns==JOptionPane.NO_OPTION) {
							return;
						}
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Angsana New", Font.BOLD, 18));
		btnNewButton_1.setBounds(189, 203, 107, 35);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u0E25\u0E1A\u0E2A\u0E34\u0E19\u0E04\u0E49\u0E32");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			//delete
			public void mouseClicked(MouseEvent e) {
				//check data is empty
				String data_id = txt_Id.getText();
				String data_name = txt_Name.getText();
				String data_amount = txt_Quantity.getText();
				String data_price = txt_Price.getText();
				if((data_id == null || data_id.length()==0)||(data_name == null || data_name.length()==0)||(data_amount == null || data_amount.length()==0)||(data_price == null || data_price.length()==0))
				{
					JOptionPane.showMessageDialog(null,
						    "Please complete the information.",
						    "insert error",
						    JOptionPane.ERROR_MESSAGE);
				//show error message here
				}else if ((data_id != null || data_id.length()!=0)||(data_name != null || data_name.length()!=0)||(data_amount != null || data_amount.length()!=0)||(data_price != null || data_price.length()!=0)) {
					int ns = JOptionPane.showConfirmDialog(null,
						    "Do you want to delete data?",
						    "Question",
						    JOptionPane.YES_NO_OPTION);
						if(ns==JOptionPane.YES_OPTION) {
							try {
								 Connection conn ;
							        conn = (Connection) DriverManager.getConnection(Host, User, Password);
							           Statement stmt = conn.createStatement();

						            
						            System.out.println("DELETE  DATA-->");
					            String sql = "DELETE FROM user WHERE ID = "+txt_Id.getText();
						            stmt.execute(sql) ;
						            JOptionPane.showMessageDialog(null, "DELETE  Product ID :"+txt_Id.getText());
						             Condb() ;
						            System.out.print(sql);
						        } catch (SQLException ex) {
						        	System.out.println(ex.getMessage());
						        }
						}else if(ns==JOptionPane.NO_OPTION) {
							return;
						}
				}
					
			}
		});
		btnNewButton_2.setFont(new Font("Angsana New", Font.BOLD, 18));
		btnNewButton_2.setBounds(323, 203, 107, 35);
		panel.add(btnNewButton_2);
		
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
			}
		});
		txt_search.setBounds(518, 203, 158, 28);
		txt_search.setColumns(10);
		panel.add(txt_search);
		
		JLabel lb_search = new JLabel("\u0E04\u0E49\u0E19\u0E2B\u0E32");
		lb_search.setForeground(new Color(0, 51, 255));
		lb_search.setBounds(460, 206, 52, 22);
		lb_search.setFont(new Font("Angsana New", Font.BOLD, 25));
		panel.add(lb_search);
		
		table_data = new JTable();
		table_data.setFillsViewportHeight(true);
		table_data.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				int row = table_data.getSelectedRow();
				txt_Id.setText(String.valueOf(table_data.getValueAt(row, 0)));
				txt_Name.setText(String.valueOf(table_data.getValueAt(row, 1)));
				txt_Quantity.setText(String.valueOf(table_data.getValueAt(row, 2)));
				txt_Price.setText(String.valueOf(table_data.getValueAt(row, 3)));
			}
		});
		table_data.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"id", "name", "quantity", "price"
			}
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Integer.class, Integer.class
			};

			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_data.getColumnModel().getColumn(1).setPreferredWidth(20);
		table_data.getColumnModel().getColumn(1).setMinWidth(80);
		table_data.getColumnModel().getColumn(2).setMinWidth(20);
		table_data.getColumnModel().getColumn(3).setMinWidth(20);
		table_data.setBounds(10, 347, 697, 317);
		//panel.add(table_data);
		
		
		
		JLabel lb_id_1 = new JLabel("\u0E23\u0E2B\u0E31\u0E2A\u0E2A\u0E34\u0E19\u0E04\u0E49\u0E32");
		lb_id_1.setForeground(new Color(255, 255, 204));
		lb_id_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_id_1.setBounds(54, 257, 90, 17);
		panel.add(lb_id_1);
		
		JLabel lb_name_1 = new JLabel("\u0E0A\u0E37\u0E48\u0E2D\u0E2A\u0E34\u0E19\u0E04\u0E49\u0E32");
		lb_name_1.setForeground(new Color(255, 255, 204));
		lb_name_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_name_1.setBounds(224, 257, 90, 17);
		panel.add(lb_name_1);
		
		JLabel lb_quantity_1 = new JLabel("\u0E08\u0E33\u0E19\u0E27\u0E19");
		lb_quantity_1.setForeground(new Color(255, 255, 204));
		lb_quantity_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lb_quantity_1.setBounds(400, 257, 98, 17);
		panel.add(lb_quantity_1);
		
		JLabel lb_price_1 = new JLabel("\u0E23\u0E32\u0E04\u0E32\u0E2A\u0E34\u0E19\u0E04\u0E49\u0E32");
		lb_price_1.setForeground(new Color(255, 255, 204));
		lb_price_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_price_1.setBounds(565, 257, 98, 17);
		panel.add(lb_price_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(10, 249, 697, 7);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(10, 249, 6, 40);
		panel.add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1.setForeground(Color.WHITE);
		separator_1_1.setBounds(182, 249, 6, 40);
		panel.add(separator_1_1);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setOrientation(SwingConstants.VERTICAL);
		separator_1_2.setForeground(Color.WHITE);
		separator_1_2.setBounds(357, 249, 6, 40);
		panel.add(separator_1_2);
		
		JSeparator separator_1_3 = new JSeparator();
		separator_1_3.setOrientation(SwingConstants.VERTICAL);
		separator_1_3.setForeground(Color.WHITE);
		separator_1_3.setBounds(531, 249, 6, 40);
		panel.add(separator_1_3);
		
		JSeparator separator_1_3_1 = new JSeparator();
		separator_1_3_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_3_1.setForeground(Color.WHITE);
		separator_1_3_1.setBounds(705, 249, 6, 40);
		panel.add(separator_1_3_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 288, 697, 314);
		panel.add(scrollPane_1);
		scrollPane_1.setViewportView(table_data);
		
	}
}
