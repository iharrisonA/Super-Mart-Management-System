import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CashierWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtBillNo;
	private JTextField txtCutomer;
	private JTextField txtQuantity;
	private JPanel BillPanel;
	private JTextField txtRate;
	private List<Product> products = new ArrayList<Product>(); 
	private CircularLinkedList data = new CircularLinkedList();
	private JTable table;
	private JTextField txtTotal;
	private JComboBox comboBox;
	private JButton btnFinish;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashierWindow frame = new CashierWindow();
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
	
	public CashierWindow() {
		setTitle("Billing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel header = new JPanel();
		header.setLayout(null);
		header.setBackground(new Color(245, 245, 245));
		header.setBounds(0, 0, 1362, 83);
		contentPane.add(header);

		products.add(new Product("Shampoo", 230));
		products.add(new Product("Soap", 50));
		products.add(new Product("Rice", 120));
		products.add(new Product("Biscuit", 20));
		products.add(new Product("Pulses", 90));
		
		ImageIcon img1 = new ImageIcon("D:\\Documents\\University\\Second Semester\\OOP Assignments\\Project\\Images\\logo.png");

		Image g1 = img1.getImage();
		Image mg1 = g1.getScaledInstance(150, 80, Image.SCALE_SMOOTH);
		ImageIcon img2 = new ImageIcon("D:\\Documents\\University\\Second Semester\\OOP Assignments\\Project\\Images\\logout.png");

		Image g2 = img2.getImage();
		Image mg2 = g2.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ImageIcon img3 = new ImageIcon("D:\\Documents\\University\\Second Semester\\OOP Assignments\\Project\\Images\\bill.png");

		Image g3 = img3.getImage();
		Image mg3 = g3.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ImageIcon img4 = new ImageIcon("D:\\Documents\\University\\Second Semester\\OOP Assignments\\Project\\Images\\report.jpg");

		Image g4 = img4.getImage();
		Image mg4 = g4.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		
		JLabel lblQuickBill = new JLabel("Quick Bill");
		lblQuickBill.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblQuickBill.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblQuickBill.setHorizontalTextPosition(SwingConstants.CENTER);
		lblQuickBill.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuickBill.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuickBill.setIcon(new ImageIcon(mg3));
		lblQuickBill.setIconTextGap(0);
		lblQuickBill.setBorder(null);
		lblQuickBill.setBackground(Color.BLACK);
		lblQuickBill.setBounds(1103, 2, 120, 83);
		lblQuickBill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblQuickBill.setForeground(Color.blue);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblQuickBill.setForeground(Color.black);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Bill bill = new Bill();
				txtBillNo.setText(bill.BillNo+"");
//				txtDate.setText(cashier.Id+"");
				BillPanel.setVisible(BillPanel.isVisible() ? false : true);
//				ProductPanel.setVisible(false);
			}
		});
		header.add(lblQuickBill);
		
		JLabel label_2 = new JLabel("Logout");
		label_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_2.setVerticalTextPosition(SwingConstants.BOTTOM);
		label_2.setVerticalAlignment(SwingConstants.BOTTOM);
		label_2.setIconTextGap(0);
		label_2.setHorizontalTextPosition(SwingConstants.CENTER);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setIcon(new ImageIcon(mg2));
		label_2.setBorder(null);
		label_2.setIcon(new ImageIcon(mg2));
		label_2.setBackground(Color.BLACK);
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				label_2.setForeground(Color.blue);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_2.setForeground(Color.black);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				CashierWindow.getFrames()[0].dispose();
				Login n = new Login();
				n.frmLogin.show();
			}
		});
		label_2.setBounds(1232, 0, 120, 83);
		header.add(label_2);
		
		JLabel label_3 = new JLabel("Great Supermart");
		label_3.setIcon(new ImageIcon(mg1));
		label_3.setIconTextGap(0);
		label_3.setFont(new Font("Castellar", Font.PLAIN, 26));
		label_3.setBounds(10, 0, 444, 83);
		header.add(label_3);
		
		BillPanel = new JPanel();
		BillPanel.setVisible(false);
		BillPanel.setBounds(0, 83, 1362, 622);
		contentPane.add(BillPanel);
		BillPanel.setLayout(null);
		
		JLabel lblCreateBill = new JLabel("Create Bill");
		lblCreateBill.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblCreateBill.setBounds(234, 24, 143, 47);
		BillPanel.add(lblCreateBill);
		
		txtBillNo = new JTextField();
		txtBillNo.setEditable(false);
		txtBillNo.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtBillNo.setColumns(10);
		txtBillNo.setBounds(234, 100, 270, 26);
		BillPanel.add(txtBillNo);
		
		JLabel lblBillNo = new JLabel("Bill No:");
		lblBillNo.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblBillNo.setBounds(35, 100, 118, 26);
		BillPanel.add(lblBillNo);
		
		JLabel lblProductName = new JLabel("Customer Name:");
		lblProductName.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblProductName.setBounds(35, 147, 164, 26);
		BillPanel.add(lblProductName);
		
		txtCutomer = new JTextField();
		txtCutomer.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtCutomer.setColumns(10);
		txtCutomer.setBounds(234, 147, 270, 26);
		BillPanel.add(txtCutomer);
		
		JLabel lblProductName_1 = new JLabel("Product Name:");
		lblProductName_1.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblProductName_1.setBounds(35, 193, 164, 26);
		BillPanel.add(lblProductName_1);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblQuantity.setBounds(35, 239, 118, 26);
		BillPanel.add(lblQuantity);
		
		txtQuantity = new JTextField();
		txtQuantity.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(234, 239, 270, 26);
		BillPanel.add(txtQuantity);
		
		JLabel lblRate = new JLabel("Rate:");
		lblRate.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblRate.setBounds(35, 292, 118, 26);
		BillPanel.add(lblRate);
		
		txtRate = new JTextField();
		txtRate.setEditable(false);
		txtRate.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtRate.setColumns(10);
		txtRate.setBounds(234, 292, 270, 26);
		BillPanel.add(txtRate);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean exist = false;
				if(txtCutomer.getText().equals("") || txtQuantity.getText().equals("") || txtRate.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "All Fields are required!");
				}
				else {
					String price = Double.parseDouble(txtRate.getText()) * Integer.parseInt(txtQuantity.getText()) +"";
					String[] newData = { comboBox.getSelectedItem().toString(), txtQuantity.getText(), price};
					DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
					tblModel.addRow(newData);
					
					data.add(newData);
					
					Product n = new Product();
					txtQuantity.setText("");
					txtRate.setText("");
					txtCutomer.setEditable(false);
				}
			}
		});
		btnAdd.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnAdd.setFocusable(false);
		btnAdd.setEnabled(true);
		btnAdd.setBackground(Color.LIGHT_GRAY);
		btnAdd.setBounds(49, 396, 118, 37);
		BillPanel.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnUpdate.setFocusable(false);
		btnUpdate.setEnabled(false);
		btnUpdate.setBackground(Color.LIGHT_GRAY);
		btnUpdate.setBounds(202, 396, 118, 37);
		BillPanel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnDelete.setFocusable(false);
		btnDelete.setEnabled(false);
		btnDelete.setBackground(Color.LIGHT_GRAY);
		btnDelete.setBounds(350, 396, 118, 37);
		BillPanel.add(btnDelete);
		
		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String name = arg0.getItem().toString();
				String price = "";
				for(Product product : products)
				{
					if(name.equals(product.Name))
					{
						price = product.Price+"";
					}
				}
				txtRate.setText(price);
				}
		});
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(Product.SampleProducts.values()));
		comboBox.setBounds(234, 196, 270, 28);
		BillPanel.add(comboBox);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRequestFocusEnabled(false);
		table.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		table.setFocusable(false);
		table.setBounds(625, 50, 706, 452);
		table.setModel(new DefaultTableModel( new String[][] {},
			new String[] {
					"Name", "Quantity", "Price"
			}
		));
		BillPanel.add(table);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(572, 50, 23, 519);
		BillPanel.add(separator);
		
		JButton btnTotal = new JButton("Total");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				double total = data.PriceTotal();
				txtTotal.setText(total+"");
				btnFinish.setEnabled(true);
			}
		});
		btnTotal.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnTotal.setFocusable(false);
		btnTotal.setEnabled(true);
		btnTotal.setBackground(Color.LIGHT_GRAY);
		btnTotal.setBounds(625, 532, 118, 37);
		BillPanel.add(btnTotal);
		
		txtTotal = new JTextField();
		txtTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTotal.setEditable(false);
		txtTotal.setBounds(787, 532, 253, 37);
		BillPanel.add(txtTotal);
		txtTotal.setColumns(10);
		
		btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Bill n = new Bill();
				txtBillNo.setText(n.BillNo+"");
				txtQuantity.setText("");
				txtRate.setText("");
				txtTotal.setText("");
				txtCutomer.setText("");
				txtCutomer.setEditable(true);
				DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
				int rows = tblModel.getRowCount();
				for(int i=0;i<=rows-1;i++)
				{
					tblModel.removeRow(0);
				}
				
				btnFinish.setEnabled(false);
			}
		});
		btnFinish.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnFinish.setFocusable(false);
		btnFinish.setEnabled(false);
		btnFinish.setBackground(Color.LIGHT_GRAY);
		btnFinish.setBounds(1213, 532, 118, 37);
		BillPanel.add(btnFinish);
	}
}
