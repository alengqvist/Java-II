package paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.*;


/** 
 * This class creates a window-based application which works like Paint.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 20:25, November 10, 2015.
 */
public class PainterGUI extends JFrame {
	
	private static final long serialVersionUID = 3495883917426331695L;
	
	// GUI-components.
	private JPanel headPanel;
	private JPanel greenPanel;
	private JPanel bluePanel;
	private JPanel blackPanel;
	private JPanel redPanel;
	private JPanel yellowPanel;
	private JComboBox<String> typeComboBox;
	private JPanel paintAreaPanel;
	private JPanel footPanel;
	private JPanel coordPanel;
	private JLabel coordLabel;
	private JLabel coordXY;
	private JPanel colorPanel;
	private JLabel colorSelectionLabel;
	private JPanel colorSelectionPanel;
	
	public static void main(String[] args) {
		
		// Build and show GUI on separate thread.
		SwingUtilities.invokeLater(() -> new PainterGUI().setVisible(true));
	}
	
	/**
	 * Constructor which builds the GUI.
	 */
	public PainterGUI() {
		
		// Setup JFrame.
		setTitle("Ritprogram");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(800, 500);			
		setMinimumSize(new Dimension(300, 200));
		
		// Add GUI-components.
		addHeader();
		addPaintArea();
		addFooter();
	}

	/**
	 * Add a header to the JFrame.
	 */
	private void addHeader() {
		
		// Create Header.
		headPanel = new JPanel();
		headPanel.setLayout(new GridBagLayout());
		
			// Initialize Components.
			greenPanel = new JPanel();
			bluePanel = new JPanel();
			blackPanel = new JPanel();
			redPanel = new JPanel();
			yellowPanel = new JPanel();		
			typeComboBox = new JComboBox<String>(new String[] {"Rektangel", "Frihand"});
			
			// Set background.
			greenPanel.setBackground(Color.GREEN);	
			bluePanel.setBackground(Color.BLUE);
			blackPanel.setBackground(Color.BLACK);
			redPanel.setBackground(Color.RED);
			yellowPanel.setBackground(Color.YELLOW);
			
			// Set Constraints.
			GridBagConstraints colorSelectionsConstraints = new GridBagConstraints();
			colorSelectionsConstraints.fill = GridBagConstraints.BOTH;
			colorSelectionsConstraints.weightx = 1;
			colorSelectionsConstraints.weighty = 1;
		
		// Add to Header.
		headPanel.add(greenPanel, colorSelectionsConstraints);
		headPanel.add(bluePanel, colorSelectionsConstraints);
		headPanel.add(blackPanel, colorSelectionsConstraints);
		headPanel.add(redPanel, colorSelectionsConstraints);
		headPanel.add(yellowPanel, colorSelectionsConstraints);
		headPanel.add(typeComboBox);
		
		// Add to Frame.
		add(headPanel, BorderLayout.PAGE_START);
	}

	/**
	 * Add a container for painting to the JFrame.
	 */
	private void addPaintArea() {
		
		// Create Paint Area.
		paintAreaPanel = new JPanel();
		
		// Set background.
		paintAreaPanel.setBackground(Color.WHITE);
		
		// Add to Frame.
		add(paintAreaPanel, BorderLayout.CENTER);
	}

	/**
	 * Add a footer to the JFrame.
	 */
	private void addFooter() {
		
		// Create Footer.
		footPanel = new JPanel();
		footPanel.setLayout(new BorderLayout());
		
			// Initialize Components.
			coordPanel = new JPanel();
			coordLabel = new JLabel("Koordinater: ");
			coordXY = new JLabel("0, 0");
			colorPanel = new JPanel();
			colorPanel.setLayout(new GridLayout(0, 2));
			colorSelectionLabel = new JLabel("FŠrgval: ");
			colorSelectionPanel = new JPanel();
	
				// Set background.
				colorSelectionPanel.setBackground(Color.RED);
			
			// Add to Panels.
			coordPanel.add(coordLabel);
			coordPanel.add(coordXY);
			colorPanel.add(colorSelectionLabel);
			colorPanel.add(colorSelectionPanel);
			
		// Add to Footer.
		footPanel.add(coordPanel, BorderLayout.LINE_START);
		footPanel.add(colorPanel, BorderLayout.LINE_END);
		
		// Add to Frame.
		add(footPanel, BorderLayout.PAGE_END);
	}
}