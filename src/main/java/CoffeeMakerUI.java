package main.java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CoffeeMakerUI {

	private JFrame frame;
	private CoffeMaker coffeeMaker;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeeMakerUI window = new CoffeeMakerUI();
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
	public CoffeeMakerUI() {
		initialize();
		coffeeMaker = new CoffeMaker();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(CoffeeMakerUI.class.getResource("/javax/swing/plaf/basic/icons/image-failed.png")));
		frame.setBounds(100, 100, 541, 477);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblCoffeeMaker = new JLabel("Coffee Maker");
		lblCoffeeMaker.setIcon(new ImageIcon(CoffeeMakerUI.class.getResource("/main/java/CleanCoffeMaker.png")));
		lblCoffeeMaker.setBounds(0, 0, 326, 448);
		panel.add(lblCoffeeMaker);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(325, 0, 210, 448);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnFillBoiler = new JButton("Fill Boiler");
		btnFillBoiler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//pressButton();
			}
		});
		panel_1.add(btnFillBoiler);
		
		JButton btnBrew = new JButton("Fill Receptacle");
		btnBrew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		panel_1.add(btnBrew);
		
		JButton btnNewButton_1 = new JButton("Place Pot");
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Take Pot");
		panel_1.add(btnNewButton_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"4", "6", "8", "10", "12"}));
		panel_1.add(comboBox);
		
		JButton btnNewButton_2 = new JButton("Make Coffe");
		btnNewButton_2.setBackground(new Color(0, 139, 139));
		panel_1.add(btnNewButton_2);
	}
}
