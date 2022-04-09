package pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JDesktopPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;


import javax.swing.SwingConstants;
import java.awt.Toolkit;


public class home {

	private JFrame frmSynlixzIncOop;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home window = new home();
					window.frmSynlixzIncOop.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public home() {
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmSynlixzIncOop = new JFrame();
		frmSynlixzIncOop.setIconImage(Toolkit.getDefaultToolkit().getImage(home.class.getResource("/images/logo.png")));
		frmSynlixzIncOop.setTitle("Synlixz Inc OOP System By : !nwgodrip");
		frmSynlixzIncOop.setResizable(false);
		frmSynlixzIncOop.setBounds(100, 100, 975, 651);
		frmSynlixzIncOop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSynlixzIncOop.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 959, 612);
		frmSynlixzIncOop.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 51, 204));
		panel_1.setBounds(0, 0, 243, 612);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		
		JDesktopPane Homedesktop = new JDesktopPane();
		Homedesktop.setBounds(242, 0, 717, 612);
		panel.add(Homedesktop);
		
		JPanel panel_home = new JPanel();
		panel_home.setBackground(new Color(153, 204, 255));
		panel_home.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				Homedesktop.removeAll();
				OOP_Item it1 = new OOP_Item();
				Homedesktop.add(it1).setVisible(true);
				
			}
		});
		panel_home.setBounds(0, 122, 243, 47);
		panel_1.add(panel_home);
		panel_home.setLayout(null);
		
		JLabel lblHome = new JLabel("\u0E2B\u0E19\u0E49\u0E32\u0E2B\u0E25\u0E31\u0E01");
		lblHome.setBounds(70, 6, 89, 36);
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setFont(new Font("Angsana New", Font.BOLD, 30));
		panel_home.add(lblHome);
		
		JPanel panel_stock = new JPanel();
		panel_stock.setBackground(new Color(153, 204, 255));
		panel_stock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Homedesktop.removeAll();
				OOP_Item it1 = new OOP_Item();
				Homedesktop.add(it1).setVisible(true);
				
			}
		});
		panel_stock.setBounds(0, 180, 243, 47);
		panel_1.add(panel_stock);
		panel_stock.setLayout(null);
		
		JLabel lblStock = new JLabel("\u0E04\u0E25\u0E31\u0E07\u0E2A\u0E34\u0E19\u0E04\u0E49\u0E32");
		lblStock.setHorizontalAlignment(SwingConstants.CENTER);
		lblStock.setFont(new Font("Angsana New", Font.BOLD, 30));
		lblStock.setBounds(71, 6, 89, 36);
		panel_stock.add(lblStock);
		
		JPanel panel_saveitem = new JPanel();
		panel_saveitem.setBackground(new Color(153, 204, 255));
		panel_saveitem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Homedesktop.removeAll();
				OOP_Bill it1 = new OOP_Bill();
				Homedesktop.add(it1).setVisible(true);
			}
		});
		panel_saveitem.setLayout(null);
		panel_saveitem.setBounds(0, 238, 243, 47);
		panel_1.add(panel_saveitem);
		
		JLabel lblSaveitem = new JLabel("\u0E1A\u0E31\u0E19\u0E17\u0E36\u0E01\u0E01\u0E32\u0E23\u0E02\u0E32\u0E22");
		lblSaveitem.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaveitem.setFont(new Font("Angsana New", Font.BOLD, 30));
		lblSaveitem.setBounds(55, 6, 127, 36);
		panel_saveitem.add(lblSaveitem);
		
		JPanel panel_saveitem_1 = new JPanel();
		panel_saveitem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Homedesktop.removeAll();
				OOP_Dayseller it1 = new OOP_Dayseller();
				Homedesktop.add(it1).setVisible(true);
			}
		});
		panel_saveitem_1.setBackground(new Color(153, 204, 255));
		panel_saveitem_1.setLayout(null);
		panel_saveitem_1.setBounds(0, 296, 243, 47);
		panel_1.add(panel_saveitem_1);
		
		JLabel lblSaveitem_1 = new JLabel("\u0E22\u0E2D\u0E14\u0E02\u0E32\u0E22\u0E23\u0E32\u0E22\u0E27\u0E31\u0E19");
		lblSaveitem_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaveitem_1.setFont(new Font("Angsana New", Font.BOLD, 30));
		lblSaveitem_1.setBounds(55, 6, 127, 36);
		panel_saveitem_1.add(lblSaveitem_1);
		
		JPanel panel_saveitem_2 = new JPanel();
		panel_saveitem_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Homedesktop.removeAll();
				OOP_SalaryHistory it1 = new OOP_SalaryHistory();
				Homedesktop.add(it1).setVisible(true);
			}
		});
		panel_saveitem_2.setBackground(new Color(153, 204, 255));
		panel_saveitem_2.setLayout(null);
		panel_saveitem_2.setBounds(0, 354, 243, 47);
		panel_1.add(panel_saveitem_2);
		
		JLabel lblSaveitem_2 = new JLabel("\u0E22\u0E2D\u0E14\u0E02\u0E32\u0E22\u0E2A\u0E34\u0E19\u0E04\u0E49\u0E32");
		lblSaveitem_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaveitem_2.setFont(new Font("Angsana New", Font.BOLD, 30));
		lblSaveitem_2.setBounds(55, 6, 127, 36);
		panel_saveitem_2.add(lblSaveitem_2);
		
		JLabel lb_Synlixz = new JLabel("Synlixz Inc");
		lb_Synlixz.setForeground(new Color(255, 255, 255));
		lb_Synlixz.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		lb_Synlixz.setBounds(40, 22, 165, 56);
		panel_1.add(lb_Synlixz);
		
		JLabel lblNewLabel = new JLabel("Developer : !nwgodrip");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(new Color(255, 255, 204));
		lblNewLabel.setBounds(107, 67, 126, 14);
		panel_1.add(lblNewLabel);
		
		
	}
}
