import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class WorkTime extends JFrame implements ItemListener, KeyListener {
	
	// Set up row 0
	JPanel row0 = new JPanel();
	// Adds text and room for output
	JLabel dateText = new JLabel("Today's date is ", JLabel.RIGHT);
	JTextField dateField = new JTextField(18); // Room for the longest possible date
	
	// Set up row 1
	JPanel row1 = new JPanel();
	// Adds text
	JLabel startTimeText = new JLabel("What time does your shift start?");
	// Adds hour combo box
	JComboBox startHour = new JComboBox();
	startHour.addItemListener(this);
	Object startHour = item.getItem();
	String startHour = startHour.toString();
	int startHour = Integer.parseInt(startHour);
	// Adds colon to seperate hours and minutes
	JLabel colon = new JLabel(":");
	// Adds minute combo box
	JComboBox startMinute = new JComboBox();
	startMinute.addItemListener(this);
	Object startMinute = item.getItem();
	String startMinute= startHour.toString();
	int startMinute = Integer.parseInt(startMinute);
	// Adds AM/PM combo boxes
	ButtonGroup amPM = new ButtonGroup();
	JCheckBox am = new JCheckBox("AM", true);
	am.addItemListener(this);
	int am = item.getStateChange();
	if (am == ItemEvent.SELECTED) {
		// Do nothing
	} 
	JCheckBox pm = new JCheckBox("PM", false);
	pm.addItemListener(this);
	int am = item.getStateChange();
	if (pm == ItemEvent.SELECTED) {
		// Turn 12 hour time into 24 hour time
		startHour+=12;
	} 

		// Set up row 2
		JPanel row2 = new JPanel();
		// Adds text
		JLabel durationText = new JLabel("How long is your shift?");
		// Adds hour combo box
		JComboBox durationHour = new JComboBox();
		// Adds label to previous number
		JLabel hourLabel = new JLabel(" hours ");
		// Adds minute combo box
		JComboBox durationMin = new JComboBox();
		// Adds label to previous number
		JLabel minLabel = new JLabel(" minutes");
		
		// Set up row 3
		JPanel row3 = new JPanel();
		// Adds text
		JLabel breakText = new JLabel("What is the duration of your breaks?");
		// Adds minute slider
		JSlider breakMin = new JSlider(0, 90, 30);
		// Adds label to previous number
		JLabel breakMinLabel = new JLabel(" minutes");
		
		// Set up row 4
		JPanel row4 = new JPanel();
		// Adds text and room for output
		JLabel leaveText = new JLabel("You can leave at ", JLabel.RIGHT);
		JTextField leaveTime = new JTextField(10); // this can be shorter to better fit the time
		
		/*
		// Set up row 5
		JPanel row5 = new JPanel();
		// decides between having to stay longer or working over
		if (currentTime < leaveTime) {
			// Adds text and room for output
			JLabel leaveInText = new JLabel("You can leave in ", JLabel.RIGHT);
			JTextField leaveWait = new JTextField(20); // this can be shorter to better fit the time
			} else {
				// Adds text and room for output
			JLabel timeOverText = new JLabel("You worked over by ", JLabel.RIGHT);
			JTextField timeOver = new JTextField(20); // this can be shorter to better fit the time
			}
		*/
		
	public WorkTime() {
		// Sets up defaults for UI
		super("Work Time Calculator");
		setLookAndFeel();
		setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Sets up layout for entire app
		FlowLayout flow = new FlowLayout();
		setLayout(flow);
		
		// Sets up layout for row 0
		FlowLayout layout0 = new FlowLayout(FlowLayout.CENTER, 10, 10);
		// Adds the components of row 0 using layout0
		row0.setLayout(layout0);
		row0.add(dateText);
		row0.add(dateField);
		// Set up date
		Calendar now = Calendar.getInstance();
		int month = now.get(Calendar.MONTH) + 1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		int year = now.get(Calendar.YEAR);
		// Display the name of the month
		String monthName = "";
		switch (month) {
			case 1:
				monthName = ("January");
				break;
			case 2:
				monthName = ("February");
				break;
			case 3:
				monthName = ("March");
				break;
			case 4:
				monthName = ("April");
				break;
			case 5:
				monthName = ("May");
				break;
			case 6:
				monthName = ("June");
				break;
			case 7:
				monthName = ("July");
				break;
			case 8:
				monthName = ("August");
				break;
			case 9:
				monthName = ("September");
				break;
			case 10:
				monthName = ("October");
				break;
			case 11:
				monthName = ("November");
				break;
			case 12:
				monthName = ("December");
		}

		// display the date and year
		dateField.setText(monthName + " " + day + ", " + year);
		datefield.setHorizontalAlignment(JTextField.CENTER);
		dateField.setEditable(false);
		add(row0);
		
		// Sets up layout for row 1
		FlowLayout layout1 = new FlowLayout(FlowLayout.CENTER, 10, 10);
		// Sets up the two check boxes
		amPM.add(am);
		amPM.add(pm);
		// Adds the components of row 1 using layout1
		row1.setLayout(layout1);
		row1.add(startTimeText);
		row1.add(startHour);
		for (int hr = 0; hr < 13; hr++) {
			startHour.addItem(hr);
		}
		row1.add(colon);
		row1.add(startMinute);
		for (int min = 0; min < 60; min++) {
			if (min < 10){
				startMinute.addItem("0" + min);
			} else {
				startMinute.addItem(min);
			}
		}
		row1.add(am);
		row1.add(pm);
		add(row1);
	   
		// Sets up layout for row 2
		FlowLayout layout2 = new FlowLayout(FlowLayout.CENTER, 10, 10);
		// Adds the components of row 2 using layout2
		row2.setLayout(layout2);
		row2.add(durationText);
		row2.add(durationHour);
		for (int hr = 0; hr < 17; hr++) {
			durationHour.addItem(hr);
		}
		row2.add(hourLabel);
		row2.add(durationMin);
		for (int min = 0; min < 60; min++) {
			durationMin.addItem(min);
		}
		row2.add(minLabel);
		add(row2);
		
		// Sets up layout for row 3
		FlowLayout layout3 = new FlowLayout(FlowLayout.CENTER, 10, 10);
		// Adds the components of row 3 using layout3
		row3.setLayout(layout3);
		row3.add(breakText);
		row3.add(breakMin);
		breakMin.setMajorTickSpacing(15);
		breakMin.setMinorTickSpacing(5);
		breakMin.setPaintTicks(true);
		breakMin.setPaintLabels(true);
		row3.add(breakMinLabel);
		add(row3);
		
		// Sets up layout for row 4
		FlowLayout layout4 = new FlowLayout(FlowLayout.CENTER, 10, 10);
		// Adds the components of row 4 using layout4
		row4.setLayout(layout4);
		row4.add(leaveText);
		row4.add(leaveTime);
		leaveTime.setEditable(false);
		add(row4);
		
		/*
		// Sets up layout for row 5
		FlowLayout layout4 = new FlowLayout(FlowLayout.CENTER, 10, 10);
		// Adds the components of row 4 using layout4
		// I'm not sure how to do this. I'll just wait til I know what I'm doing
		*/
		
		setVisible(true);
	}
	
	public void keyTyped(KeyEvent input) {
		char key = input.getKeyCode;
		// Start program if enter pressed?
		// Need to put "keyText.addKeyListener(this);" in JTextField
		// This may not work
		// Erase "impliments KeyListener" if not used
	}
	/* These lines needed if doing keyTyped
	public void keyPressed(KeyEvent txt) {
		// Do nothing
	}
	public void keyReleased(KeyEvent txt) {
		// Do nothing
	}
	*/
	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(
					"com.sun.java.swing.plaf.nimbus.NumbusLookAndFeel"
			);
		} catch (Exception exc) {
			// ignore error
		}
	}
	
	public static void main(String[] arguments) {
		WorkTime wt = new WorkTime();
	}
}