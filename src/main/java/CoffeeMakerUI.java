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
	CoffeeMaker markIV;
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
		markIV = new CoffeeMaker();
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
		
		JPanel imagePanel = new JPanel();
		frame.getContentPane().add(imagePanel, BorderLayout.CENTER);
		imagePanel.setLayout(null);
				
		JLabel lblCoffeeMaker = new JLabel("Coffee Maker");
		lblCoffeeMaker.setIcon(new ImageIcon(CoffeeMakerUI.class.getResource("/main/java/coffeeMakerEmpty.png")));
		lblCoffeeMaker.setBounds(0, 0, 326, 448);
		imagePanel.add(lblCoffeeMaker);
				
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBackground(Color.WHITE);
		buttonsPanel.setBounds(325, 0, 210, 448);
		imagePanel.add(buttonsPanel);
		buttonsPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnPlacePot = new JButton("Place Pot");
		btnPlacePot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				markIV.getWarmerPlate().placePot();
				lblCoffeeMaker.setIcon(new ImageIcon(CoffeeMakerUI.class.getResource("/main/java/CleanCoffeMaker.png")));
			}
		});
		buttonsPanel.add(btnPlacePot);
		
		JButton btnFillBoiler = new JButton("Fill Boiler");
		btnFillBoiler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				markIV.getBoiler().pourWater(10);
				lblCoffeeMaker.setIcon(new ImageIcon(CoffeeMakerUI.class.getResource("/main/java/boilerFilled10.png")));
			}
		});
		buttonsPanel.add(btnFillBoiler);
		
		JButton btnFillReceptacle = new JButton("Fill Receptacle");
		btnFillReceptacle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblCoffeeMaker.setIcon(new ImageIcon(CoffeeMakerUI.class.getResource("/main/java/receptacleFill.png")));
			}
		});
		buttonsPanel.add(btnFillReceptacle);
		
		
		
		JButton btnTakePot = new JButton("Take Pot");
		buttonsPanel.add(btnTakePot);
		
		JComboBox qtyCups = new JComboBox();
		qtyCups.setModel(new DefaultComboBoxModel(new String[] {"4", "6", "8", "10", "12"}));
		buttonsPanel.add(qtyCups);
		
		JButton btnBrew = new JButton("Brew");
		btnBrew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblCoffeeMaker.setIcon(new ImageIcon(CoffeeMakerUI.class.getResource("/main/java/coffeeMakerOn.png")));
				try {
					markIV.startProcess(Integer.parseInt(qtyCups.getSelectedItem().toString()));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		buttonsPanel.add(btnBrew);
	}
}
