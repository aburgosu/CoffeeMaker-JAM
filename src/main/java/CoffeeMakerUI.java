package main.java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class CoffeeMakerUI {
	private JFrame mainFrame;
	private CoffeeMaker markIV;
	private SwingWorker<Void, Integer> worker;

	// UI Items
	JPanel imagePanel;
	JLabel lblBoiler;
	JLabel lblReceptacle;
	JLabel lblPot;
	JLabel lblLed;
	JPanel buttonsPanel;
	JButton btnPlacePot;
	JPanel panelFillWaterSelector;
	JButton btnFillReceptacle;
	JComboBox comboBoxWaterSelector;
	JButton btnFillBoiler;
	JButton btnTakePot;
	JPanel jPanelBrewSelector;
	JComboBox qtyCups;
	JButton btnBrew;
	JProgressBar progressBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeeMakerUI window = new CoffeeMakerUI();
					window.mainFrame.setVisible(true);
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
		mainFrame = new JFrame();
		mainFrame.setResizable(false);
		mainFrame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(CoffeeMakerUI.class.getResource("/javax/swing/plaf/basic/icons/JavaCup16.png")));
		mainFrame.setBounds(100, 100, 541, 477);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		imagePanel = new JPanel();
		mainFrame.getContentPane().add(imagePanel, BorderLayout.CENTER);
		imagePanel.setLayout(null);

		progressBar = new JProgressBar();
		progressBar.setValue(0);
		progressBar.setForeground(SystemColor.activeCaption);
		progressBar.setStringPainted(true);
		progressBar.setBounds(122, 410, 164, 24);
		imagePanel.add(progressBar);

		lblBoiler = new JLabel("");
		lblBoiler.setIcon(new ImageIcon(CoffeeMakerUI.class.getResource("/visualResources/cleanBoiler.png")));
		lblBoiler.setBounds(200, 0, 124, 448);
		imagePanel.add(lblBoiler);

		lblReceptacle = new JLabel("");
		lblReceptacle.setIcon(new ImageIcon(CoffeeMakerUI.class.getResource("/visualResources/cleanRcptcl.png")));
		lblReceptacle.setBounds(0, 0, 200, 191);
		imagePanel.add(lblReceptacle);

		lblPot = new JLabel("");
		lblPot.setIcon(new ImageIcon(CoffeeMakerUI.class.getResource("/visualResources/withoutPot.png")));
		lblPot.setBounds(0, 191, 200, 211);
		imagePanel.add(lblPot);

		lblLed = new JLabel("");
		lblLed.setIcon(new ImageIcon(CoffeeMakerUI.class.getResource("/visualResources/barGray.png")));
		lblLed.setBounds(0, 402, 200, 46);
		imagePanel.add(lblLed);

		buttonsPanel = new JPanel();
		buttonsPanel.setBounds(325, 0, 210, 448);
		buttonsPanel.setBackground(Color.WHITE);
		imagePanel.add(buttonsPanel);
		buttonsPanel.setLayout(new GridLayout(0, 1, 0, 0));

		btnPlacePot = new JButton("Place Pot");
		btnPlacePot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				markIV.placePotInWarmerPlate();
				progressBar.setValue(0);
				lblPot.setIcon(new ImageIcon(CoffeeMakerUI.class.getResource("/visualResources/cleanPot.png")));

			}
		});
		buttonsPanel.add(btnPlacePot);

		btnFillReceptacle = new JButton("Fill Receptacle");
		btnFillReceptacle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				markIV.fillGroundCoffee();
				lblReceptacle
						.setIcon(new ImageIcon(CoffeeMakerUI.class.getResource("/visualResources/rcptclFilled.png")));
			}
		});
		buttonsPanel.add(btnFillReceptacle);

		panelFillWaterSelector = new JPanel();
		buttonsPanel.add(panelFillWaterSelector);
		panelFillWaterSelector.setLayout(new BorderLayout(0, 0));

		comboBoxWaterSelector = new JComboBox();
		comboBoxWaterSelector.setModel(new DefaultComboBoxModel(new String[] { "4", "6", "8", "10", "12" }));
		panelFillWaterSelector.add(comboBoxWaterSelector, BorderLayout.WEST);
		btnFillBoiler = new JButton("Fill Boiler");
		panelFillWaterSelector.add(btnFillBoiler, BorderLayout.CENTER);
		btnFillBoiler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String optionSelected = comboBoxWaterSelector.getSelectedItem().toString();
				markIV.pourWaterInBoiler(Integer.parseInt(optionSelected));
				String icon = "/visualResources/boilerFilled" + optionSelected + ".png";
				lblBoiler.setIcon(new ImageIcon(CoffeeMakerUI.class.getResource(icon)));
			}
		});

		panelFillWaterSelector.add(btnFillBoiler);

		btnTakePot = new JButton("Take Pot");
		btnTakePot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				markIV.liftPot();
				worker.cancel(true);
				lblPot.setIcon(new ImageIcon(CoffeeMakerUI.class.getResource("/visualResources/withoutPot.png")));

			}
		});
		buttonsPanel.add(btnTakePot);

		jPanelBrewSelector = new JPanel();
		buttonsPanel.add(jPanelBrewSelector);
		jPanelBrewSelector.setLayout(new BorderLayout(0, 0));

		qtyCups = new JComboBox();
		jPanelBrewSelector.add(qtyCups, BorderLayout.WEST);
		qtyCups.setModel(new DefaultComboBoxModel(new String[] { "4", "6", "8", "10", "12" }));

		btnBrew = new JButton("Brew");
		jPanelBrewSelector.add(btnBrew, BorderLayout.CENTER);

		btnBrew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (markIV.getWarmerPlateStatus() != PlateSensor.WARMER_EMPTY) {
					int qtyCupsSelected = Integer.parseInt(qtyCups.getSelectedItem().toString());
					if (qtyCupsSelected <= markIV.getWaterOfBoiler()) {
						lblLed.setIcon(new ImageIcon(CoffeeMakerUI.class.getResource("/visualResources/barRed.png")));
						mainFrame.update(mainFrame.getGraphics());

						// Initialize in background
						initializeWorker(qtyCupsSelected);
						worker.execute();

					} else {
						JOptionPane.showMessageDialog(null, "Insufficient water!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please, place the pot");

				}

			}
		});
	}

	private void initializeWorker(int qtyCupsSelected) {
		worker = new SwingWorker<Void, Integer>() {

			@Override
			protected Void doInBackground() throws Exception {
				markIV.brewCoffee(qtyCupsSelected);
				int progressBarIncrement = 100 / (qtyCupsSelected * 2);
				for (int i = 0; i < qtyCupsSelected * 2; i++) {
					Thread.sleep(500);
					progressBar.setValue(progressBar.getValue() + progressBarIncrement);
					if (i == qtyCupsSelected * 2 - 1) {
						progressBar.setValue(100);
						lblLed.setIcon(new ImageIcon(CoffeeMakerUI.class.getResource("/visualResources/barGreen.png")));
						markIV.liftPot();
					}
					if (i == 2 || i == 4 || i == 6 || i == 8 || i == 10 || i == 12) {
						
						String icon = "/visualResources/potFilled" + (i-2) + ".png";
						lblPot.setIcon(new ImageIcon(CoffeeMakerUI.class.getResource(icon)));
						icon = "/visualResources/boilerFilled" + (markIV.getWaterOfBoiler()) + ".png";
						lblBoiler.setIcon(new ImageIcon(CoffeeMakerUI.class.getResource(icon)));
						markIV.pourWaterInBoiler(markIV.getWaterOfBoiler() - 2);

					}

				}

				return null;
			}

		};
	}
}
