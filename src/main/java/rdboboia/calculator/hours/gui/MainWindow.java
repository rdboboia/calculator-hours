package rdboboia.calculator.hours.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;

import rdboboia.calculator.hours.HoursDifferenceCalculator;

import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import java.time.LocalTime;

public class MainWindow {

	private JFrame frmHoursdiffcalc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
				try {
					MainWindow window = new MainWindow();
					window.frmHoursdiffcalc.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		frmHoursdiffcalc = new JFrame();
		frmHoursdiffcalc.setTitle("HoursDiffCalc");
		frmHoursdiffcalc.setBounds(100, 100, 255, 180);
		frmHoursdiffcalc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHoursdiffcalc.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmHoursdiffcalc.getContentPane().add(panel, "frmHoursdiffcalc");
		
		JLabel lblStartTime = new JLabel("Start time:");
		
		JLabel lblEndTime = new JLabel("End time:");
		
		JLabel lblHour = new JLabel("Hour");
		
		JLabel lblMinute = new JLabel("Minute");
		
		JLabel lblSecond = new JLabel("Second");
		
		JSpinner spnStartHour = new JSpinner();
		spnStartHour.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		
		JSpinner spnStartMin = new JSpinner();
		spnStartMin.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		
		JSpinner spnStartSec = new JSpinner();
		spnStartSec.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		
		JSpinner spnEndHour = new JSpinner();
		spnEndHour.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		
		JSpinner spnEndSec = new JSpinner();
		spnEndSec.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		
		JSpinner spnEndMin = new JSpinner();
		spnEndMin.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		
		JButton btnGetDiff = new JButton("Get diff");
		btnGetDiff.addActionListener(e -> {

			LocalTime startTime = LocalTime.of((int) spnStartHour.getValue(), (int) spnStartMin.getValue(), (int) spnStartSec.getValue());
			LocalTime endTime = LocalTime.of((int) spnEndHour.getValue(), (int) spnEndMin.getValue(), (int) spnEndSec.getValue());

			LocalTime hourDiff = HoursDifferenceCalculator.getHourDiff(startTime, endTime);
			
			String hourDiffString = hourDiff.toString();
			if (hourDiffString.length() == 5)
				hourDiffString += ":00";
			
			JOptionPane.showMessageDialog(null, hourDiffString, "Result", JOptionPane.INFORMATION_MESSAGE);

		});
		GroupLayout glPanel = new GroupLayout(panel);
		glPanel.setHorizontalGroup(
			glPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(glPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(glPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnGetDiff, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, glPanel.createSequentialGroup()
							.addGroup(glPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblStartTime)
								.addComponent(lblEndTime))
							.addGap(18)
							.addGroup(glPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(spnStartHour, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHour)
								.addComponent(spnEndHour, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(glPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(glPanel.createSequentialGroup()
									.addGroup(glPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblMinute)
										.addGroup(glPanel.createParallelGroup(Alignment.LEADING)
											.addComponent(spnEndMin, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
											.addComponent(spnStartMin, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
									.addGap(18)
									.addGroup(glPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(spnStartSec, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblSecond)))
								.addComponent(spnEndSec, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(205, Short.MAX_VALUE))
		);
		glPanel.setVerticalGroup(
			glPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(glPanel.createSequentialGroup()
					.addGap(19)
					.addGroup(glPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(glPanel.createSequentialGroup()
							.addGroup(glPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblHour)
								.addComponent(lblMinute)
								.addComponent(lblSecond))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(glPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(spnStartHour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(spnStartMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(spnStartSec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblStartTime))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(glPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(spnEndHour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(spnEndSec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(spnEndMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblEndTime))
					.addGap(18)
					.addComponent(btnGetDiff)
					.addContainerGap(135, Short.MAX_VALUE))
		);
		panel.setLayout(glPanel);
	}
}
