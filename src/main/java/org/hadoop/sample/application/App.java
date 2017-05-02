package org.hadoop.sample.application;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class App {

	private JFrame frame;
	JPanel panel=null;
	private JTextField first;
	private JTextField middle;
	private JTextField last;
	private JTextField street1;
	private JTextField street2;
	private JTextField city;
	private JTextField state;
	private JTextField zip;
	private JTextField email;
	private JTextField telephoneh;
	private JTextField telephonem;
	private JTextField website;
	private JTextField rules;
	List<Contact> contactList=new ArrayList<Contact>();
	static FileWriter fi=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					fi=new FileWriter(new File("contact2.txt"));
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setVisible(true);
		frame.getContentPane().setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.setBounds(10, 10, 1350, 937);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();

		contactListView(false,"","");
		frame.revalidate();
		frame.repaint();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void formView(){
		panel.removeAll();
		panel.setOpaque(false);
		panel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel.setAutoscrolls(true);
		panel.setBackground(Color.BLACK);
		frame.getContentPane().add(panel, "name_89273679935601");
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{10, 10, 10, 10, 10, 10, 10, 10,10, 10, 10, 10, 10, 10, 10, 10};
		gbl_panel.rowHeights = new int[]{10, 10, 10, 10, 10, 10, 10, 10,10, 10, 10, 10, 10, 10, 10, 10,10, 10, 10, 10, 10, 10, 10, 10,10, 10, 10, 10, 10, 10, 10, 0, 10,10, 10, 10, 10, 10, 10, 10, 10};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		JLabel lblContactForm = new JLabel("Contact Form ");
		lblContactForm.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblContactForm.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblContactForm = new GridBagConstraints();
		gbc_lblContactForm.gridwidth = 2;
		gbc_lblContactForm.gridheight = 2;
		gbc_lblContactForm.insets = new Insets(0, 0, 5, 5);
		gbc_lblContactForm.gridx = 5;
		gbc_lblContactForm.gridy = 1;
		panel.add(lblContactForm, gbc_lblContactForm);

		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setAutoscrolls(true);
		lblNewLabel.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 4;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		first = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 6;
		gbc_textField.gridy = 4;
		panel.add(first, gbc_textField);
		first.setColumns(10);

		JLabel lblMiddleName = new JLabel("Middle Name");
		GridBagConstraints gbc_lblMiddleName = new GridBagConstraints();
		lblMiddleName.setFont(new Font("Dialog", Font.BOLD, 13));
		lblMiddleName.setForeground(Color.WHITE);
		lblMiddleName.setAutoscrolls(true);
		lblMiddleName.setBackground(Color.WHITE);
		gbc_lblMiddleName.insets = new Insets(0, 0, 5, 5);
		gbc_lblMiddleName.gridx = 3;
		gbc_lblMiddleName.gridy = 6;
		panel.add(lblMiddleName, gbc_lblMiddleName);

		middle = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 6;
		gbc_textField_1.gridy = 6;
		panel.add(middle, gbc_textField_1);
		middle.setColumns(10);

		JLabel lblMiddleName1 = new JLabel("Last Name");
		GridBagConstraints gbc_lblMiddleName1 = new GridBagConstraints();
		lblMiddleName1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblMiddleName1.setForeground(Color.WHITE);
		lblMiddleName1.setAutoscrolls(true);
		lblMiddleName1.setBackground(Color.WHITE);
		gbc_lblMiddleName1.insets = new Insets(0, 0, 5, 5);
		gbc_lblMiddleName1.gridx = 3;
		gbc_lblMiddleName1.gridy = 8;
		panel.add(lblMiddleName1, gbc_lblMiddleName1);

		JLabel lblMiddleName2 = new JLabel("Street1");
		GridBagConstraints gbc_lblMiddleName2 = new GridBagConstraints();
		lblMiddleName2.setFont(new Font("Dialog", Font.BOLD, 13));
		lblMiddleName2.setForeground(Color.WHITE);
		lblMiddleName2.setAutoscrolls(true);
		lblMiddleName2.setBackground(Color.WHITE);
		gbc_lblMiddleName2.insets = new Insets(0, 0, 5, 5);
		gbc_lblMiddleName2.gridx = 3;
		gbc_lblMiddleName2.gridy = 10;
		panel.add(lblMiddleName2, gbc_lblMiddleName2);

		JLabel lblMiddleName3 = new JLabel("Street2");
		GridBagConstraints gbc_lblMiddleName3 = new GridBagConstraints();
		lblMiddleName3.setFont(new Font("Dialog", Font.BOLD, 13));
		lblMiddleName3.setForeground(Color.WHITE);
		lblMiddleName3.setAutoscrolls(true);
		lblMiddleName3.setBackground(Color.WHITE);
		gbc_lblMiddleName3.insets = new Insets(0, 0, 5, 5);
		gbc_lblMiddleName3.gridx = 3;
		gbc_lblMiddleName3.gridy = 12;
		panel.add(lblMiddleName3, gbc_lblMiddleName3);

		JLabel lblMiddleName4 = new JLabel("City");
		GridBagConstraints gbc_lblMiddleName4 = new GridBagConstraints();
		lblMiddleName4.setFont(new Font("Dialog", Font.BOLD, 13));
		lblMiddleName4.setForeground(Color.WHITE);
		lblMiddleName4.setAutoscrolls(true);
		lblMiddleName4.setBackground(Color.WHITE);
		gbc_lblMiddleName4.insets = new Insets(0, 0, 5, 5);
		gbc_lblMiddleName4.gridx = 3;
		gbc_lblMiddleName4.gridy = 14;
		panel.add(lblMiddleName4, gbc_lblMiddleName4);

		JLabel lblMiddleName5 = new JLabel("State");
		GridBagConstraints gbc_lblMiddleName5 = new GridBagConstraints();
		lblMiddleName5.setFont(new Font("Dialog", Font.BOLD, 13));
		lblMiddleName5.setForeground(Color.WHITE);
		lblMiddleName5.setAutoscrolls(true);
		lblMiddleName5.setBackground(Color.WHITE);
		gbc_lblMiddleName5.insets = new Insets(0, 0, 5, 5);
		gbc_lblMiddleName5.gridx = 3;
		gbc_lblMiddleName5.gridy = 16;
		panel.add(lblMiddleName5, gbc_lblMiddleName5);

		JLabel lblMiddleName6 = new JLabel("Zip");
		GridBagConstraints gbc_lblMiddleName6 = new GridBagConstraints();
		lblMiddleName6.setFont(new Font("Dialog", Font.BOLD, 13));
		lblMiddleName6.setForeground(Color.WHITE);
		lblMiddleName6.setAutoscrolls(true);
		lblMiddleName6.setBackground(Color.WHITE);
		gbc_lblMiddleName6.insets = new Insets(0, 0, 5, 5);
		gbc_lblMiddleName6.gridx = 3;
		gbc_lblMiddleName6.gridy = 18;
		panel.add(lblMiddleName6, gbc_lblMiddleName6);

		JLabel lblMiddleName7 = new JLabel("Email");
		GridBagConstraints gbc_lblMiddleName7 = new GridBagConstraints();
		lblMiddleName7.setFont(new Font("Dialog", Font.BOLD, 13));
		lblMiddleName7.setForeground(Color.WHITE);
		lblMiddleName7.setAutoscrolls(true);
		lblMiddleName7.setBackground(Color.WHITE);
		gbc_lblMiddleName7.insets = new Insets(0, 0, 5, 5);
		gbc_lblMiddleName7.gridx = 3;
		gbc_lblMiddleName7.gridy = 20;
		panel.add(lblMiddleName7, gbc_lblMiddleName7);

		JLabel lblMiddleName9 = new JLabel("Telephone(H)");
		GridBagConstraints gbc_lblMiddleName9 = new GridBagConstraints();
		lblMiddleName9.setFont(new Font("Dialog", Font.BOLD, 13));
		lblMiddleName9.setForeground(Color.WHITE);
		lblMiddleName9.setAutoscrolls(true);
		lblMiddleName9.setBackground(Color.WHITE);
		gbc_lblMiddleName9.insets = new Insets(0, 0, 5, 5);
		gbc_lblMiddleName9.gridx = 3;
		gbc_lblMiddleName9.gridy = 22;
		panel.add(lblMiddleName9, gbc_lblMiddleName9);

		JLabel lblMiddleName10 = new JLabel("Telephone(M)");
		GridBagConstraints gbc_lblMiddleName10 = new GridBagConstraints();
		lblMiddleName10.setFont(new Font("Dialog", Font.BOLD, 13));
		lblMiddleName10.setForeground(Color.WHITE);
		lblMiddleName10.setAutoscrolls(true);
		lblMiddleName10.setBackground(Color.WHITE);
		gbc_lblMiddleName10.insets = new Insets(0, 0, 5, 5);
		gbc_lblMiddleName10.gridx = 3;
		gbc_lblMiddleName10.gridy = 24;
		panel.add(lblMiddleName10, gbc_lblMiddleName10);

		JLabel lblMiddleName11 = new JLabel("Website");
		GridBagConstraints gbc_lblMiddleName11 = new GridBagConstraints();
		lblMiddleName11.setFont(new Font("Dialog", Font.BOLD, 13));
		lblMiddleName11.setForeground(Color.WHITE);
		lblMiddleName11.setAutoscrolls(true);
		lblMiddleName11.setBackground(Color.WHITE);
		gbc_lblMiddleName11.insets = new Insets(0, 0, 5, 5);
		gbc_lblMiddleName11.gridx = 3;
		gbc_lblMiddleName11.gridy = 26;
		panel.add(lblMiddleName11, gbc_lblMiddleName11);

		JLabel lblMiddleName12 = new JLabel("Rules");
		GridBagConstraints gbc_lblMiddleName12 = new GridBagConstraints();
		lblMiddleName12.setFont(new Font("Dialog", Font.BOLD, 13));
		lblMiddleName12.setForeground(Color.WHITE);
		lblMiddleName12.setAutoscrolls(true);
		lblMiddleName12.setBackground(Color.WHITE);
		gbc_lblMiddleName12.insets = new Insets(0, 0, 5, 5);
		gbc_lblMiddleName12.gridx = 3;
		gbc_lblMiddleName12.gridy = 28;
		panel.add(lblMiddleName12, gbc_lblMiddleName12);

		last = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.gridx = 6;
		gbc_textField_2.gridy = 8;
		panel.add(last, gbc_textField_2);
		last.setColumns(10);

		street1 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.BOTH;
		gbc_textField_3.gridx = 6;
		gbc_textField_3.gridy = 10;
		panel.add(street1, gbc_textField_3);
		street1.setColumns(10);

		street2 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.BOTH;
		gbc_textField_4.gridx = 6;
		gbc_textField_4.gridy = 12;
		panel.add(street2, gbc_textField_4);
		street2.setColumns(10);

		city = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.BOTH;
		gbc_textField_5.gridx = 6;
		gbc_textField_5.gridy = 14;
		panel.add(city, gbc_textField_5);
		city.setColumns(10);

		state = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.BOTH;
		gbc_textField_6.gridx = 6;
		gbc_textField_6.gridy = 16;
		panel.add(state, gbc_textField_6);
		state.setColumns(10);

		zip= new JTextField();
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.insets = new Insets(0, 0, 5, 5);
		gbc_textField_7.fill = GridBagConstraints.BOTH;
		gbc_textField_7.gridx = 6;
		gbc_textField_7.gridy = 18;
		panel.add(zip, gbc_textField_7);
		zip.setColumns(10);

		email = new JTextField();
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.insets = new Insets(0, 0, 5, 5);
		gbc_textField_8.fill = GridBagConstraints.BOTH;
		gbc_textField_8.gridx = 6;
		gbc_textField_8.gridy = 20;
		panel.add(email, gbc_textField_8);
		email.setColumns(10);

		telephoneh = new JTextField();
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.insets = new Insets(0, 0, 5, 5);
		gbc_textField_9.fill = GridBagConstraints.BOTH;
		gbc_textField_9.gridx = 6;
		gbc_textField_9.gridy = 22;
		panel.add(telephoneh, gbc_textField_9);
		telephoneh.setColumns(10);

		telephonem = new JTextField();
		GridBagConstraints gbc_textField_10 = new GridBagConstraints();
		gbc_textField_10.insets = new Insets(0, 0, 5, 5);
		gbc_textField_10.fill = GridBagConstraints.BOTH;
		gbc_textField_10.gridx = 6;
		gbc_textField_10.gridy = 24;
		panel.add(telephonem, gbc_textField_10);
		telephonem.setColumns(10);

		website = new JTextField();
		GridBagConstraints gbc_textField_11 = new GridBagConstraints();
		gbc_textField_11.insets = new Insets(0, 0, 5, 5);
		gbc_textField_11.fill = GridBagConstraints.BOTH;
		gbc_textField_11.gridx = 6;
		gbc_textField_11.gridy = 26;
		panel.add(website, gbc_textField_11);
		website.setColumns(10);

		rules = new JTextField();
		GridBagConstraints gbc_textField_12 = new GridBagConstraints();
		gbc_textField_12.insets = new Insets(0, 0, 5, 5);
		gbc_textField_12.fill = GridBagConstraints.BOTH;
		gbc_textField_12.gridx = 6;
		gbc_textField_12.gridy = 28;
		panel.add(rules, gbc_textField_12);
		rules.setColumns(10);

		JButton btnReset = new JButton("Reset");
		GridBagConstraints gbc_btnReset = new GridBagConstraints();
		gbc_btnReset.fill = GridBagConstraints.BOTH;
		gbc_btnReset.insets = new Insets(0, 0, 5, 5);
		gbc_btnReset.gridx = 3;
		gbc_btnReset.gridy = 31;
		panel.add(btnReset, gbc_btnReset);

		btnReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				contactListView(false,"","");
				frame.revalidate();
				frame.repaint();
			}
		});

		JButton btnSave = new JButton("Save");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.fill = GridBagConstraints.BOTH;
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.gridx = 5;
		gbc_btnSave.gridy = 31;
		panel.add(btnSave, gbc_btnSave);

		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Contact c=new Contact();
				c.setFirst(""+first.getText());
				c.setMiddle(""+middle.getText());
				c.setLast(""+last.getText());
				c.setStreet1(""+street1.getText());
				c.setStreet2(""+street2.getText());
				c.setCity(""+city.getText());
				c.setState(""+state.getText());
				c.setZip(""+zip.getText());
				c.setEmail(""+email.getText());
				c.setRules(""+rules.getText());
				c.setTelephoneh(""+telephoneh.getText());
				c.setTelephonem(""+telephonem.getText());
				c.setWebsite(""+website.getText());
				contactList.add(c);
				try {
					fi.write("Saved Contact :"+c.getFirst());
				} catch (IOException e) {
					e.printStackTrace();
				}
				contactListView(false,"","");
				frame.revalidate();
				frame.repaint();
			}
		});
	}

	private void contactListView(boolean queryView,String pattern,String filter){
		panel.removeAll();
		panel.setBackground(Color.BLACK);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 1.0};
		panel.setLayout(gbl_panel);

		JLabel lblContactForm = new JLabel("Contact List");
		lblContactForm.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblContactForm.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblContactForm = new GridBagConstraints();
		gbc_lblContactForm.insets = new Insets(0, 0, 5, 5);
		gbc_lblContactForm.gridx = 3;
		gbc_lblContactForm.gridy = 0;
		panel.add(lblContactForm, gbc_lblContactForm);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setAutoscrolls(true);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 1;
		panel.add(scrollPane, gbc_scrollPane);

		JTable table = new JTable();
		scrollPane.setViewportView(table);
		if(!queryView){
			table.setModel(new DefaultTableModel(
					getStringArray(contactList),
					new String[] {
							"First", "Middle", "Last", "Street1", "Street2", "City", "State", "Zip", "Email", "Telephone(H)", "Telephone(M)", "Website", "Rules"
					}
					));
			table.getColumnModel().getColumn(10).setPreferredWidth(97);
		}else{
			List<Contact> queriedList=new ArrayList<Contact>();
			for(Contact c:contactList){
				if("first".equalsIgnoreCase(filter)&&c.getFirst().contains(pattern)){
					queriedList.add(c);
				}else if("middle".equalsIgnoreCase(filter)&&c.getMiddle().contains(pattern)){
					queriedList.add(c);
				}else if("last".equalsIgnoreCase(filter)&&c.getLast().contains(pattern)){
					queriedList.add(c);
				}else if("zip".equalsIgnoreCase(filter)&&c.getZip().contains(pattern)){
					queriedList.add(c);
				}else if("email".equalsIgnoreCase(filter)&&c.getEmail().contains(pattern)){
					queriedList.add(c);
				}else if("city".equalsIgnoreCase(filter)&&c.getCity().contains(pattern)){
					queriedList.add(c);
				}else if("state".equalsIgnoreCase(filter)&&c.getState().contains(pattern)){
					queriedList.add(c);
				}
			}
			table.setModel(new DefaultTableModel(
					getStringArray(queriedList),
					new String[] {
							"First", "Middle", "Last", "Street1", "Street2", "City", "State", "Zip", "Email", "Telephone(H)", "Telephone(M)", "Website", "Rules"
					}
					));
			table.getColumnModel().getColumn(10).setPreferredWidth(97);
		}
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNew = new JMenuItem("New");
		mnNewMenu.add(mntmNew);
		mntmNew.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				formView();
				frame.revalidate();
				frame.repaint();
			}
		});

		JMenuItem mntmNewMenuItem = new JMenuItem("Query View");
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				final JFrame frame = new JFrame();
				frame.getContentPane().setVisible(true);
				frame.setBounds(100, 100, 450, 300);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setVisible(true);
				JPanel panel = new JPanel();
				frame.getContentPane().add(panel, BorderLayout.CENTER);
				GridBagLayout gbl_panel = new GridBagLayout();
				gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
				gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
				gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
				gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
				panel.setLayout(gbl_panel);
				
				JLabel lblNewLabel = new JLabel("Query View");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.gridwidth = 6;
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel.gridx = 2;
				gbc_lblNewLabel.gridy = 1;
				panel.add(lblNewLabel, gbc_lblNewLabel);
				
				JLabel lblSearchString = new JLabel("Search String");
				GridBagConstraints gbc_lblSearchString = new GridBagConstraints();
				gbc_lblSearchString.insets = new Insets(0, 0, 5, 5);
				gbc_lblSearchString.gridx = 2;
				gbc_lblSearchString.gridy = 3;
				panel.add(lblSearchString, gbc_lblSearchString);
				
				final JTextField textField = new JTextField();
				GridBagConstraints gbc_textField = new GridBagConstraints();
				gbc_textField.insets = new Insets(0, 0, 5, 5);
				gbc_textField.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField.gridx = 4;
				gbc_textField.gridy = 3;
				panel.add(textField, gbc_textField);
				textField.setColumns(10);
				
				final JComboBox<String> comboBox = new JComboBox<String>();
				GridBagConstraints gbc_comboBox = new GridBagConstraints();
				gbc_comboBox.insets = new Insets(0, 0, 5, 5);
				gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBox.gridx = 7;
				gbc_comboBox.gridy = 3;
				panel.add(comboBox, gbc_comboBox);
				
				comboBox.addItem("First");
				comboBox.addItem("Middle");
				comboBox.addItem("Last");
				comboBox.addItem("Email");
				comboBox.addItem("Zip");
				comboBox.addItem("City");
				comboBox.addItem("State");
				
				JButton btnOk = new JButton("Ok");
				GridBagConstraints gbc_btnOk = new GridBagConstraints();
				gbc_btnOk.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnOk.insets = new Insets(0, 0, 5, 5);
				gbc_btnOk.gridx = 4;
				gbc_btnOk.gridy = 6;
				panel.add(btnOk, gbc_btnOk);
				
				btnOk.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							fi.write("Filtered Records based on pattern :"+textField.getText()+"\n Filter:"+(String)comboBox.getSelectedItem());
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						contactListView(true,textField.getText(),(String)comboBox.getSelectedItem());
						frame.revalidate();
						frame.repaint();
						frame.dispose();
					}
				});
				
				JButton btnCancel = new JButton("Cancel");
				GridBagConstraints gbc_btnCancel = new GridBagConstraints();
				gbc_btnCancel.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
				gbc_btnCancel.gridx = 7;
				gbc_btnCancel.gridy = 6;
				panel.add(btnCancel, gbc_btnCancel);
				
				btnCancel.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						frame.dispose();
					}
				});
			}
		});

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Open");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Save As");
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenu mnNewMenu_1 = new JMenu("Edit");
		menuBar.add(mnNewMenu_1);

		JMenu mnNewMenu_2 = new JMenu("Help");
		menuBar.add(mnNewMenu_2);
		frame.revalidate();
		frame.repaint();
	}
	
	public String[][] getStringArray(List<Contact> contactsList){
		String[][] contacts=new String[contactsList.size()][13];
		int i=0;
		for(Contact c:contactsList){
			contacts[i][0]=c.getFirst();
			contacts[i][1]=c.getMiddle();
			contacts[i][2]=c.getLast();
			contacts[i][3]=c.getStreet1();
			contacts[i][4]=c.getStreet2();
			contacts[i][5]=c.getCity();
			contacts[i][6]=c.getState();
			contacts[i][7]=c.getZip();
			contacts[i][8]=c.getEmail();
			contacts[i][9]=c.getTelephoneh();
			contacts[i][10]=c.getTelephonem();
			contacts[i][11]=c.getWebsite();
			contacts[i][12]=c.getRules();
			i++;
		}
		return contacts;
	}

}
