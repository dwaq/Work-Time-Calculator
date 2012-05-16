import javax.swing.*;
import java.awt.*;

public class WorkTime extends JFrame {
	
	// Set up row 0
	// today's date is...
	
	// Set up row 1
	JPanel row1 = new JPanel();
	// Adds text
	JLabel startTimeText = new JLabel("What time does your shift start?");
	// Adds hour combo box
	JComboBox startHour = new JComboBox();
        // Adds colon to seperate hours and minutes
        JLabel colon = new JLabel(":");
        // Adds minute combo box
        JComboBox startMinute = new JComboBox();
        // Adds AM/PM conbo boxes
	ButtonGroup amPM = new ButtonGroup();
	JCheckBox am = new JCheckBox("AM", true);
        JCheckBox pm = new JCheckBox("PM", false);
        
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
        super("Work Time Keeper");
        setLookAndFeel();
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Sets up layout for entire app
        FlowLayout flow = new FlowLayout();
        setLayout(flow);
        
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
        leaveTime.setEditable(false); // not sure if this is right
        add(row4);
        
        /*
        // Sets up layout for row 5
        FlowLayout layout4 = new FlowLayout(FlowLayout.CENTER, 10, 10);
        // Adds the components of row 4 using layout4
        // I'm not sure how to do this. I'll just wait til I know what I'm doing
        */
        
        setVisible(true);
    }
    
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