import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.ComponentOrientation;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Window.Type;
import java.awt.Component;

public class Login {

	JFrame frmLogin;
	private JTextField txtId;
	private JPasswordField passwordField;
	private User user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.setTitle("Welcome");
		frmLogin.setBounds(100, 100, 835, 452);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frmLogin.setLocation(dim.width/2-frmLogin.getSize().width/2, dim.height/2-frmLogin.getSize().height/2);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		ImageIcon img1 = new ImageIcon(System.getProperty("user.dir")+"\\images\\cart.jpg");
		Image g = img1.getImage();
		Image mg = g.getScaledInstance(840, 450, Image.SCALE_SMOOTH);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
		passwordField.setBorder(BorderFactory.createCompoundBorder(passwordField.getBorder(), BorderFactory.createEmptyBorder(0,6,0,6)));
		passwordField.setEchoChar((char)0);
		passwordField.setText("Password");
		passwordField.setForeground(Color.LIGHT_GRAY);
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(passwordField.getText().equals("Password"))
				{
					passwordField.setEchoChar('*');
					passwordField.setText("");
					passwordField.setForeground(SystemColor.controlDkShadow);
				}
			}
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (passwordField.getText().isEmpty()) {
		        	passwordField.setEchoChar((char)0);
		    		passwordField.setForeground(Color.LIGHT_GRAY);
		    		passwordField.setText("Password");
		        }
		    }
		});
		
		
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setBounds(523, 245, 266, 32);
		frmLogin.getContentPane().add(passwordField);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBorder(null);
		comboBox.setFocusable(false);
		comboBox.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		comboBox.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		comboBox.setModel(new DefaultComboBoxModel(User.UserTypes.values()));
		comboBox.setBackground(new Color(245, 245, 245));
		comboBox.setBounds(523, 288, 266, 32);
		frmLogin.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				Supermart m = new Supermart();
				user = new User();
				user.Id = txtId.getText();
				user.Password = passwordField.getText();
				user.UserType = comboBox.getSelectedItem().toString() == "Admin" ? User.UserTypes.Admin : User.UserTypes.Cashier;
				
				if(user.UserType.equals(User.UserTypes.Admin))
				{
					frmLogin.dispose();
					AdminWindow n = new AdminWindow();
					n.show();
					JOptionPane.showMessageDialog(null, "Admin Loged in successfully!");
				}
				else if(user.UserType.equals(User.UserTypes.Cashier)) {
					frmLogin.dispose();
					CashierWindow n = new CashierWindow();
					n.show();
					JOptionPane.showMessageDialog(null, "Cashier loged in successfully!");					
				}
			}
		});
		btnNewButton.setFocusable(false);
		btnNewButton.setForeground(new Color(105, 105, 105));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBackground(new Color(245, 245, 245));
		btnNewButton.setBorder(new LineBorder(new Color(169, 169, 169)));
		btnNewButton.setBounds(573, 343, 164, 42);
		frmLogin.getContentPane().add(btnNewButton);
		
		txtId = new JTextField();
		txtId.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
		txtId.setBorder(BorderFactory.createCompoundBorder(txtId.getBorder(), BorderFactory.createEmptyBorder(0,6,0,6)));
		txtId.setText("User Id");
		txtId.setForeground(Color.LIGHT_GRAY);
		txtId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(txtId.getText().equals("User Id"))
				{
					txtId.setText("");
					txtId.setForeground(SystemColor.controlDkShadow);
				}
			}
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (txtId.getText().isEmpty()) {
		        	txtId.setForeground(Color.LIGHT_GRAY);
		        	txtId.setText("User Id");
		        }
		    }
		});
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtId.setColumns(10);
		txtId.setBounds(523, 202, 266, 32);
		frmLogin.getContentPane().add(txtId);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.control);
		separator.setBounds(550, 151, 222, 2);
		frmLogin.getContentPane().add(separator);
		
		JLabel helpText = new JLabel("Please login to continue");
		helpText.setHorizontalAlignment(SwingConstants.CENTER);
		helpText.setForeground(SystemColor.controlDkShadow);
		helpText.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		helpText.setBounds(550, 92, 222, 34);
		frmLogin.getContentPane().add(helpText);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(SystemColor.controlDkShadow);
		lblLogin.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		lblLogin.setBounds(605, 43, 106, 56);
		frmLogin.getContentPane().add(lblLogin);
		
		JLabel SidePanel = new JLabel("");
		SidePanel.setIcon(new ImageIcon("E:\\Documents\\University\\OOP Assignments\\Project\\Images\\background.png"));
		SidePanel.setBounds(525, 11, 309, 430);
		frmLogin.getContentPane().add(SidePanel);
		
		JLabel Background = new JLabel("");
		
		Background.setBounds(0, 0, 835, 452);
		Background.setIcon(new ImageIcon(mg));
		frmLogin.getContentPane().add(Background);
	}
}
