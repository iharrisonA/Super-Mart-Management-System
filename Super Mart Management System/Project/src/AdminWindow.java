import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class AdminWindow extends JFrame {

	private JPanel contentPane;
	private JPanel CashierPanel;
	private JPanel ProductPanel;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtPassword;
	private JTable table;
	private CashierArrayList data = new CashierArrayList() {};
	private ProductLinkedList products = new ProductLinkedList() {};
	private JButton btnDelete;
	private JButton btnNewButton;
	private JButton btnUpdate;
	private JTextField productId;
	private JTextField productName;
	private JTextField productQuantity;
	private JTextField productPrice;
	private JTable table_1;
	private JButton button_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminWindow frame = new AdminWindow();
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
	public AdminWindow() {
		setTitle("Admin Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon img1 = new ImageIcon(System.getProperty("user.dir")+"\\images\\cashier.png");
		Image g = img1.getImage();
		Image mg = g.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		
		ImageIcon img2 = new ImageIcon(System.getProperty("user.dir")+"\\images\\product.png");
		Image g1 = img2.getImage();
		Image mg1 = g1.getScaledInstance(90, 65, Image.SCALE_SMOOTH);
		
		ImageIcon img3 = new ImageIcon(System.getProperty("user.dir")+"\\images\\logout.png");
		Image g2 = img3.getImage();
		Image mg2 = g2.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		
		ImageIcon img4 = new ImageIcon(System.getProperty("user.dir")+"\\images\\payment.png");
		Image g3 = img4.getImage();
		Image mg3 = g3.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		
		ImageIcon img5 = new ImageIcon(System.getProperty("user.dir")+"\\images\\logo.png");
		Image g4 = img5.getImage();
		Image mg4 = g4.getScaledInstance(150, 80, Image.SCALE_SMOOTH);
		
		ProductPanel = new JPanel();
		ProductPanel.setVisible(false);
		ProductPanel.setBounds(0, 83, 1362, 611);
		
		JLabel lblAddProduct = new JLabel("Add Product");
		lblAddProduct.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblAddProduct.setBounds(201, 11, 143, 47);
		ProductPanel.add(lblAddProduct);
		
		JLabel label_1 = new JLabel("Id:");
		label_1.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		label_1.setBounds(52, 87, 118, 26);
		ProductPanel.add(label_1);
		
		productId = new JTextField();
		productId.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		productId.setEnabled(false);
		productId.setColumns(10);
		productId.setBounds(201, 87, 270, 26);
		ProductPanel.add(productId);
		
		JLabel label_2 = new JLabel("Name:");
		label_2.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		label_2.setBounds(52, 134, 118, 26);
		ProductPanel.add(label_2);
		
		productName = new JTextField();
		productName.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		productName.setColumns(10);
		productName.setBounds(201, 134, 270, 26);
		ProductPanel.add(productName);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblQuantity.setBounds(52, 180, 118, 26);
		ProductPanel.add(lblQuantity);
		
		productQuantity = new JTextField();
		productQuantity.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		productQuantity.setColumns(10);
		productQuantity.setBounds(201, 180, 270, 26);
		ProductPanel.add(productQuantity);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblPrice.setBounds(52, 226, 118, 26);
		ProductPanel.add(lblPrice);
		
		productPrice = new JTextField();
		productPrice.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		productPrice.setColumns(10);
		productPrice.setBounds(201, 226, 270, 26);
		ProductPanel.add(productPrice);
		
		JLabel lblDescription = new JLabel("Description: ");
		lblDescription.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblDescription.setBounds(52, 279, 118, 26);
		ProductPanel.add(lblDescription);
		
		JTextArea productDesc = new JTextArea();
		productDesc.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		productDesc.setBorder(UIManager.getBorder("TextField.border"));
		productDesc.setBounds(201, 280, 270, 47);
		ProductPanel.add(productDesc);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(565, 47, 23, 519);
		ProductPanel.add(separator_1);
		
		JButton button = new JButton("Add");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean exist = false;
				if(productName.getText().equals("") || productPrice.getText().equals("") || productQuantity.getText().equals("") || productDesc.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "All Fields are required!");
				}
				else {
					String[] newData = { productId.getText(), productName.getText(), productQuantity.getText(), productPrice.getText(), productDesc.getText() };
					Product nData = new Product(Integer.parseInt(productId.getText()), productName.getText(), productQuantity.getText(), Double.parseDouble(productPrice.getText()), productDesc.getText());
					
					DefaultTableModel tblModel = (DefaultTableModel)table_1.getModel();
					tblModel.addRow(newData);
					products.add(nData);
					JOptionPane.showMessageDialog(null, "Product Added Successfuly!");
					
					Product n = new Product();
					productId.setText(n.Id+"");
					productName.setText("");
					productQuantity.setText("");
					productPrice.setText("");
					productDesc.setText("");
				}				
			}
		});
		button.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		button.setFocusable(false);
		button.setEnabled(true);
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(52, 426, 118, 37);
		ProductPanel.add(button);
		
		JButton button_1 = new JButton("Delete");
		button_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		button_1.setFocusable(false);
		button_1.setEnabled(false);
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				products.remove(Integer.parseInt((String) ((DefaultTableModel)table_1.getModel()).getValueAt(table_1.getSelectedRow(), 0)));
				((DefaultTableModel)table_1.getModel()).removeRow(table_1.getSelectedRow());
				products.display();
				
				Product n = new Product();
				productId.setText(n.Id+"");
				productName.setText("");
				productQuantity.setText("");
				productPrice.setText("");
				productDesc.setText("");
				button.setEnabled(true);
				button_2.setEnabled(false);
				button_1.setEnabled(false);
			}
		});
		button_1.setBounds(353, 426, 118, 37);
		ProductPanel.add(button_1);
		
		button_2 = new JButton("Update");
		button_2.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		button_2.setFocusable(false);
		button_2.setEnabled(false);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				DefaultTableModel tblModel = (DefaultTableModel)table_1.getModel();
				tblModel.setValueAt(productId.getText(), table_1.getSelectedRow(), 0);
				tblModel.setValueAt(productName.getText(), table_1.getSelectedRow(), 1);
				tblModel.setValueAt(productQuantity.getText(), table_1.getSelectedRow(), 2);
				tblModel.setValueAt(productPrice.getText(), table_1.getSelectedRow(), 3);
				tblModel.setValueAt(productDesc.getText(), table_1.getSelectedRow(), 4);

				products.remove(Integer.parseInt(productId.getText()));
				products.add(new Product(Integer.parseInt(productId.getText()), productName.getText(), productQuantity.getText(), Integer.parseInt(productPrice.getText()), productDesc.getText()));
				products.display();
				
				Product n = new Product();
				productId.setText(n.Id+"");
				productName.setText("");
				productQuantity.setText("");
				productPrice.setText("");
				productDesc.setText("");
				button.setEnabled(true);
				button_2.setEnabled(false);
				button_1.setEnabled(false);
			}
		});
		button_2.setBackground(Color.LIGHT_GRAY);
		button_2.setBounds(205, 426, 118, 37);
		ProductPanel.add(button_2);
		
		products.add(new Product(15455, "Shampoo", "1", 250, "Heads & Shoulders Shampoo"));
		products.add(new Product(65465, "Soap", "3", 300, "Large Soaps Safeguard"));
		products.add(new Product(25789, "Rice (1KG)", "5", 650, "Banasmati Rice"));
		products.add(new Product(25458, "Biscuit", "10", 100, "Prince Biscuit"));
		products.add(new Product(21245, "Mixed Pulses (1KG)", "3", 176, "Daalayn"));
		
		table_1 = new JTable();
		table_1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table_1.setModel(new DefaultTableModel( new String[][] {
			new String[] {"15455", "Shampoo", "1", "250", "Heads & Shoulders Shampoo"},
			new String[] {"65465", "Soap", "3", "300", "Large Soaps Safeguard"},
			new String[] {"25789", "Rice (1KG)", "5", "650", "Banasmati Rice"},
			new String[] {"25458", "Biscuit", "10", "100", "Prince Biscuit"},
			new String[] {"21245", "Mixed Pulses (1KG)", "3", "176", "Daalayn"},
		},
			new String[] {
				"Id", "Name", "Quantity", "Price", "Description"
			}
		));
		table_1.setRequestFocusEnabled(false);
		table_1.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		table_1.setFocusable(false);
		table_1.setBounds(625, 47, 706, 519);
		
		table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	if(table_1.getSelectedRow() != -1)
	        	{
	            productId.setText(table_1.getValueAt(table_1.getSelectedRow(), 0).toString());
	            productName.setText(table_1.getValueAt(table_1.getSelectedRow(), 1).toString());
	            productQuantity.setText(table_1.getValueAt(table_1.getSelectedRow(), 2).toString());
	            productPrice.setText(table_1.getValueAt(table_1.getSelectedRow(), 3).toString());
	            productDesc.setText(table_1.getValueAt(table_1.getSelectedRow(), 4).toString());

	    		button.setEnabled(false);
	    		button_1.setEnabled(true);
	    		button_2.setEnabled(true);
	        	}
	        }
	    });
		ProductPanel.add(table_1);
		ProductPanel.setLayout(null);
		contentPane.add(ProductPanel);
		
				CashierPanel = new JPanel();
				CashierPanel.setVisible(false);
				CashierPanel.setBounds(0, 83, 1362, 611);
				CashierPanel.setLayout(null);
				
				
				JLabel lblHeading = new JLabel("Add Cashier");
				lblHeading.setFont(new Font("Century Gothic", Font.PLAIN, 20));
				lblHeading.setBounds(195, 11, 143, 47);
				CashierPanel.add(lblHeading);
				
				JLabel lblId = new JLabel("Id:");
				lblId.setFont(new Font("Century Gothic", Font.PLAIN, 18));
				lblId.setBounds(46, 87, 118, 26);
				CashierPanel.add(lblId);
				
				txtId = new JTextField();
				txtId.setEnabled(false);
				txtId.setFont(new Font("Century Gothic", Font.PLAIN, 16));
				txtId.setBounds(195, 87, 270, 26);
				CashierPanel.add(txtId);
				txtId.setColumns(10);
				
				JLabel lblName = new JLabel("Name:");
				lblName.setFont(new Font("Century Gothic", Font.PLAIN, 18));
				lblName.setBounds(46, 186, 118, 26);
				CashierPanel.add(lblName);
				
				txtName = new JTextField();
				txtName.setFont(new Font("Century Gothic", Font.PLAIN, 16));
				txtName.setColumns(10);
				txtName.setBounds(195, 186, 270, 26);
				CashierPanel.add(txtName);
				
				JLabel lblEmail = new JLabel("Email:");
				lblEmail.setFont(new Font("Century Gothic", Font.PLAIN, 18));
				lblEmail.setBounds(46, 232, 118, 26);
				CashierPanel.add(lblEmail);
				
				txtEmail = new JTextField();
				txtEmail.setFont(new Font("Century Gothic", Font.PLAIN, 16));
				txtEmail.setColumns(10);
				txtEmail.setBounds(195, 232, 270, 26);
				CashierPanel.add(txtEmail);
				
				JLabel lblPhone = new JLabel("Phone:");
				lblPhone.setFont(new Font("Century Gothic", Font.PLAIN, 18));
				lblPhone.setBounds(46, 278, 118, 26);
				CashierPanel.add(lblPhone);
				
				txtPhone = new JTextField();
				txtPhone.setFont(new Font("Century Gothic", Font.PLAIN, 16));
				txtPhone.setColumns(10);
				txtPhone.setBounds(195, 278, 270, 26);
				CashierPanel.add(txtPhone);
				
				JLabel lblAddress = new JLabel("Address");
				lblAddress.setFont(new Font("Century Gothic", Font.PLAIN, 18));
				lblAddress.setBounds(46, 327, 118, 26);
				CashierPanel.add(lblAddress);
				
				txtPassword = new JTextField();
				txtPassword.setEnabled(false);
				txtPassword.setFont(new Font("Century Gothic", Font.PLAIN, 16));
				txtPassword.setColumns(10);
				txtPassword.setBounds(195, 138, 270, 26);
				CashierPanel.add(txtPassword);
				
				JLabel lblPw = new JLabel("Password:");
				lblPw.setFont(new Font("Century Gothic", Font.PLAIN, 18));
				lblPw.setBounds(46, 138, 118, 26);
				CashierPanel.add(lblPw);
				
				JTextArea txtAddress = new JTextArea();
				txtAddress.setBorder(UIManager.getBorder("TextField.border"));
				txtAddress.setFont(new Font("Century Gothic", Font.PLAIN, 16));
				txtAddress.setBounds(195, 332, 270, 47);
				CashierPanel.add(txtAddress);
				
				JSeparator separator = new JSeparator();
				separator.setOrientation(SwingConstants.VERTICAL);
				separator.setBounds(559, 47, 23, 519);
				CashierPanel.add(separator);
				contentPane.add(CashierPanel);
				
				
				btnNewButton = new JButton("Add");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(txtName.getText().equals("") || txtEmail.getText().equals("") || txtPhone.getText().equals("") || txtAddress.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null, "All Fields are required!");
						}
						else {
							String[] newData = { txtId.getText(), txtName.getText(), txtEmail.getText(), txtPhone.getText(), txtAddress.getText() };
							Cashier nData = new Cashier(txtId.getText(), txtName.getText(), txtEmail.getText(), txtPhone.getText(), txtAddress.getText());

							DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
							tblModel.addRow(newData);
							data.add(nData);
							JOptionPane.showMessageDialog(null, "Cashier Added Successfuly!");
							data.display();
							
							Cashier n = new Cashier();
							txtId.setText(n.Id+"");
							txtPassword.setText(n.Id+"");
							txtName.setText("");
							txtEmail.setText("");
							txtPhone.setText("");
							txtAddress.setText("");
						}
					}
				});
				btnNewButton.setBackground(Color.LIGHT_GRAY);
				btnNewButton.setFocusable(false);
				btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 16));
				btnNewButton.setBounds(46, 426, 118, 37);
				CashierPanel.add(btnNewButton);
				
				
				btnDelete = new JButton("Delete");
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						data.remove(data.indexof(((DefaultTableModel)table.getModel()).getValueAt(table.getSelectedRow(), 0).toString()));
						data.display();
						((DefaultTableModel)table.getModel()).removeRow(table.getSelectedRow());
						
						Cashier n = new Cashier();
						txtId.setText(n.Id+"");
						txtPassword.setText(n.Id+"");
						txtName.setText("");
						txtEmail.setText("");
						txtPhone.setText("");
						txtAddress.setText("");
						btnNewButton.setEnabled(true);
						btnUpdate.setEnabled(false);
						btnDelete.setEnabled(false);
					}
				});
				btnDelete.setFont(new Font("Century Gothic", Font.PLAIN, 16));
				btnDelete.setFocusable(false);
				btnDelete.setBackground(Color.LIGHT_GRAY);
				btnDelete.setBounds(347, 426, 118, 37);
				CashierPanel.add(btnDelete);
				
				btnUpdate = new JButton("Update");
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
//				String[] newData = { txtId.getText(), txtName.getText(), txtEmail.getText(), txtPhone.getText(), txtAddress.getText() };
						DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
						tblModel.setValueAt(txtId.getText(), table.getSelectedRow(), 0);
						tblModel.setValueAt(txtName.getText(), table.getSelectedRow(), 1);
						tblModel.setValueAt(txtEmail.getText(), table.getSelectedRow(), 2);
						tblModel.setValueAt(txtPhone.getText(), table.getSelectedRow(), 3);
						tblModel.setValueAt(txtAddress.getText(), table.getSelectedRow(), 4);
						
						data.remove(Integer.parseInt(txtId.getText()));
						data.add(new Cashier(txtId.getText(), txtName.getText(), txtEmail.getText(), txtPhone.getText(), txtAddress.getText()));
						data.display();
						
						Cashier n = new Cashier();
						txtId.setText(n.Id+"");
						txtPassword.setText(n.Id+"");
						txtName.setText("");
						txtEmail.setText("");
						txtPhone.setText("");
						txtAddress.setText("");
						btnNewButton.setEnabled(true);
						btnUpdate.setEnabled(false);
						btnDelete.setEnabled(false);
					}
				});
				

				btnNewButton.setEnabled(true);
				btnUpdate.setEnabled(false);
				btnDelete.setEnabled(false);
				
				btnUpdate.setFont(new Font("Century Gothic", Font.PLAIN, 16));
				btnUpdate.setFocusable(false);
				btnUpdate.setBackground(Color.LIGHT_GRAY);
				btnUpdate.setBounds(199, 426, 118, 37);
				CashierPanel.add(btnUpdate);

				
				data.add(new Cashier("11985", "Rao Ahsan", "ahsan@gmail.com", "03187667987", "Guslhan-e-Iqbal"));
				data.add(new Cashier("11654", "M. Umer", "umer@gmail.com", "656868986", "Model Colony"));
				data.add(new Cashier("11685", "Harison Arnold", "harrison@gmail.com", "97671279182", "Malir Tanki"));
				data.add(new Cashier("15354", "Irfan Khan", "irfan@gmail.com", "6781291872712","Model Colony"));
				data.add(new Cashier("87515", "Fasihuddin", "fasih@gmail.com", "01218728786","Khokrapar"));
				
			table = new JTable();
			table.setFocusable(false);
			table.setRequestFocusEnabled(false);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setModel(new DefaultTableModel( new String[][] {
				new String[] {"11985", "Rao Ahsan", "ahsan@gmail.com", "03187667987", "Guslhan-e-Iqbal"},
				new String[] {"11654", "M. Umer", "umer@gmail.com", "656868986", "Model Colony"},
				new String[] {"11685", "Harison Arnold", "harrison@gmail.com", "97671279182", "Malir Tanki"},
				new String[] {"15354", "Irfan Khan", "irfan@gmail.com", "6781291872712","Model Colony"},
				new String[] {"87515", "Fasihuddin", "fasih@gmail.com", "01218728786","Khokrapar"},
			},
				new String[] {
					"Id", "Name", "Email", "Phone", "Address"
				}
			));
			table.setFont(new Font("Century Gothic", Font.PLAIN, 13));
			//DefaultTableModel d= new DefaultTableModel(columns);
			table.setBounds(619, 47, 706, 519);
			
			table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	if(table.getSelectedRow() != -1)
	        	{
	            txtId.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
	            txtPassword.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
	            txtName.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
	            txtEmail.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
	            txtPhone.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
	            txtAddress.setText(table.getValueAt(table.getSelectedRow(), 4).toString());

	    		btnNewButton.setEnabled(false);
	    		btnUpdate.setEnabled(true);
	    		btnDelete.setEnabled(true);
	        	}
	        }
	    });
			CashierPanel.add(table);
			
			JPanel header = new JPanel();
			header.setBackground(new Color(245, 245, 245));
			header.setBounds(0, 0, 1362, 83);
			contentPane.add(header);
			header.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Cashiers");
			lblNewLabel.setBorder(null);
			lblNewLabel.setBounds(765, 0, 120, 83);
			header.add(lblNewLabel);
			lblNewLabel.setBackground(new Color(0, 0, 0));
			lblNewLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					lblNewLabel.setForeground(Color.blue);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					lblNewLabel.setForeground(Color.black);
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					Cashier cashier = new Cashier();
					txtId.setText(cashier.Id+"");
					txtPassword.setText(cashier.Id+"");
					CashierPanel.setVisible(CashierPanel.isVisible() ? false : true);
					ProductPanel.setVisible(false);
				}
			});
			lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblNewLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			lblNewLabel.setIcon(new ImageIcon(mg));
			
			JLabel lblProduct = new JLabel("Products");
			lblProduct.setIconTextGap(0);
			lblProduct.setVerticalAlignment(SwingConstants.BOTTOM);
			lblProduct.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblProduct.setVerticalTextPosition(SwingConstants.BOTTOM);
			lblProduct.setHorizontalTextPosition(SwingConstants.CENTER);
			lblProduct.setHorizontalAlignment(SwingConstants.CENTER);
			lblProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblProduct.setBorder(null);
			lblProduct.setBackground(Color.BLACK);
			lblProduct.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					lblProduct.setForeground(Color.blue);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					lblProduct.setForeground(Color.black);
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					Product product = new Product();
					productId.setText(product.Id+"");
					ProductPanel.setVisible(ProductPanel.isVisible() ? false : true);
					CashierPanel.setVisible(false);
				}
			});
			lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			lblProduct.setIcon(new ImageIcon(mg1));
			lblProduct.setBounds(895, 0, 120, 83);
			header.add(lblProduct);
			
			JLabel lblLogout = new JLabel("Logout");
			lblLogout.setVerticalTextPosition(SwingConstants.BOTTOM);
			lblLogout.setVerticalAlignment(SwingConstants.BOTTOM);
			lblLogout.setIconTextGap(0);
			lblLogout.setHorizontalTextPosition(SwingConstants.CENTER);
			lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
			lblLogout.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblLogout.setBorder(null);
			lblLogout.setBackground(Color.BLACK);
			lblLogout.setIcon(new ImageIcon(System.getProperty("user.dir")+"\\images\\logout.png"));
			lblLogout.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					lblLogout.setForeground(Color.red);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					lblLogout.setForeground(Color.black);
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					AdminWindow.getFrames()[0].dispose();
					Login n = new Login();
					n.frmLogin.show();
				}
			});
			lblLogout.setBounds(1232, 0, 120, 83);
			header.add(lblLogout);
			
			JLabel logo = new JLabel("Great Supermart");
			logo.setIconTextGap(0);
			logo.setFont(new Font("Castellar", Font.PLAIN, 26));
			logo.setIcon(new ImageIcon(mg4));
			logo.setBounds(10, 0, 444, 83);
			header.add(logo);
	}
}
