package main.java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		frame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(CoffeeMakerUI.class.getResource("/javax/swing/plaf/basic/icons/JavaCup16.png")));
		frame.setBounds(100, 100, 541, 477);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel imagePanel = new JPanel();
		frame.getContentPane().add(imagePanel, BorderLayout.CENTER);
		imagePanel.setLayout(null);

		JLabel lblBoiler = new JLabel("");
		lblBoiler.setIcon(new ImageIcon(CoffeeMakerUI.class.getResource("/visualResources/cleanBoiler.png")));
		lblBoiler.setBounds(200, 0, 124, 448);
		imagePanel.add(lblBoiler);

		JLabel lblReceptacle = new JLabel("");
		lblReceptacle.setIcon(new ImageIcon(CoffeeMakerUI.class.getResource("/visualResources/cleanRcptcl.png")));
		lblReceptacle.setBounds(0, 0, 200, 191);
		imagePanel.add(lblReceptacle);

		JLabel lblPot = new JLabel("");
		lblPot.setIcon(new ImageIcon(CoffeeMakerUI.class.getResource("/visualResources/withoutPot.png")));
		lblPot.setBounds(0, 191, 200, 211);
		imagePanel.add(lblPot);

		JLabel lblLed = new JLabel("");
		lblLed.setIcon(new ImageIcon(CoffeeMakerUI.class.getResource("/visualResources/barGray.png")));
		lblLed.setBounds(0, 402, 200, 46);
		imagePanel.add(lblLed);

		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBounds(325, 0, 210, 448);
		buttonsPanel.setBackground(Color.WHITE);
		imagePanel.add(buttonsPanel);
		buttonsPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JButton btnPlacePot = new JButton("Place Pot");
		btnPlacePot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				markIV.getWarmerPlate().placePot();
				lblPot.setIcon(new ImageIcon(CoffeeMakerUI.class.getResource("/visualResources/cleanPot.png")));
			}
		});
		buttonsPanel.add(btnPlacePot);

		JButton btnFillReceptacle = new JButton("Fill Receptacle");
		btnFillReceptacle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblReceptacle
						.setIcon(new ImageIcon(CoffeeMakerUI.class.getResource("/visualResources/rcptclFilled.png")));
			}
		});
		buttonsPanel.add(btnFillReceptacle);

		JPanel panelFillWaterSelector = new JPanel();
		buttonsPanel.add(panelFillWaterSelector);
		panelFillWaterSelector.setLayout(new BorderLayout(0, 0));

		JComboBox comboBoxWaterSelector = new JComboBox();
		comboBoxWaterSelector.setModel(new DefaultComboBoxModel(new String[] { "4", "6", "8", "10", "12" }));
		panelFillWaterSelector.add(comboBoxWaterSelector, BorderLayout.WEST);

		JButton btnFillBoiler = new JButton("Fill Boiler");
		panelFillWaterSelector.add(btnFillBoiler, BorderLayout.CENTER);
		btnFillBoiler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String optionSelected = comboBoxWaterSelector.getSelectedItem().toString();
				markIV.getBoiler().pourWater(Integer.parseInt(optionSelected));
				String icon = "/visualResources/boilerFilled" + optionSelected + ".png";
				lblBoiler.setIcon(new ImageIcon(CoffeeMakerUI.class.getResource(icon)));
			}
		});

		panelFillWaterSelector.add(btnFillBoiler);

		JButton btnTakePot = new JButton("Take Pot");
		btnTakePot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				markIV.getWarmerPlate().liftPot();
				lblPot.setIcon(new ImageIcon(CoffeeMakerUI.class.getResource("/visualResources/withoutPot.png")));
			}
		});
		buttonsPanel.add(btnTakePot);

		JPanel jPanelBrewSelector = new JPanel();
		buttonsPanel.add(jPanelBrewSelector);
		jPanelBrewSelector.setLayout(new BorderLayout(0, 0));

		JComboBox qtyCups = new JComboBox();
		jPanelBrewSelector.add(qtyCups, BorderLayout.WEST);
		qtyCups.setModel(new DefaultComboBoxModel(new String[] { "4", "6", "8", "10", "12" }));

		JButton btnBrew = new JButton("Brew");
		jPanelBrewSelector.add(btnBrew, BorderLayout.CENTER);

		btnBrew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (markIV.getWarmerPlate().plateSensor.getStatus() != PlateSensor.WARMER_EMPTY) {
					if (Integer.parseInt(qtyCups.getSelectedItem().toString()) <= Integer
							.parseInt(comboBoxWaterSelector.getSelectedItem().toString())) { // obtener el agua del boiler y no del comboBox
						lblPot.setIcon(
								new ImageIcon(CoffeeMakerUI.class.getResource("/visualResources/potFilled4.png")));
						lblLed.setIcon(new ImageIcon(CoffeeMakerUI.class.getResource("/visualResources/barRed.png")));
						frame.update(frame.getGraphics());
						try {
							markIV.startProcess(Integer.parseInt(qtyCups.getSelectedItem().toString()));
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						String optionSelected = qtyCups.getSelectedItem().toString();
						String icon = "/visualResources/potFilled" + optionSelected + ".png";
						lblPot.setIcon(new ImageIcon(CoffeeMakerUI.class.getResource(icon)));
						lblLed.setIcon(new ImageIcon(CoffeeMakerUI.class.getResource("/visualResources/barGreen.png")));
					} else {
						JOptionPane.showMessageDialog(null, "Insufficient water!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please, place the pot");
				}

			}
		});
	}
}
