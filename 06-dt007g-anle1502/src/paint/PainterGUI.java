package paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;


/** 
 * This class creates a window-based application which works like Paint.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 17:48, November 12, 2015.
 */
public class PainterGUI extends JFrame implements ActionListener, CoordinateListener {
	
	private static final long serialVersionUID = 3495883917426331695L;
	
	// Color-Selections Constants.
	private static final int GREEN = 1;
	private static final int BLUE = 2;
	private static final int BLACK = 3;
	private static final int RED = 4;
	private static final int YELLOW = 5;
	
	// GUI-components.
	private JPanel headPanel;
	private JPanel greenColor;
	private JPanel blueColor;
	private JPanel blackColor;
	private JPanel redColor;
	private JPanel yellowColor;
	private JComboBox<String> typeComboBox;
	private PaintArea paintArea;
	private JPanel footPanel;
	private JPanel coordPanel;
	private JLabel coordLabel;
	private JLabel coordXY;
	private JPanel colorPanel;
	private JLabel colorSelectionLabel;
	private JPanel selectedColor;
		
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
		setSize(800, 500);			
		setMinimumSize(new Dimension(300, 200));
		
		// Add window listener for Exit.
		addWindowListener( 
		    new WindowAdapter() { 
		        public void windowClosing(WindowEvent e) { 
		            exit(); 
		        } 
		    } 
		);
		
		// Add GUI-components.
		addMenu();
		addHeader();
		addPaintArea();
		addFooter();
	}

	/**
	 * Add a Menu to the JFrame.
	 */
	private void addMenu() {
		
		// Create MenuBar.
		JMenuBar menuBar = new JMenuBar();

		// Create a Menu.
		JMenu menu1 = new JMenu("Arkiv");

		// Create three MenuItems.
		JMenuItem menuItem1 = new JMenuItem("Nytt");
		JMenuItem menuItem2 = new JMenuItem("Ångra");
		JMenuItem menuItem3 = new JMenuItem("Avsluta");

		// Set Mnemonic for each selection.
		menu1.setMnemonic(KeyEvent.VK_M);
		menuItem1.setMnemonic(KeyEvent.VK_1);
		menuItem2.setMnemonic(KeyEvent.VK_2);
		menuItem3.setMnemonic(KeyEvent.VK_3);

		// Add a ActionListener to each MenuItem.
		menuItem1.addActionListener(this);
		menuItem2.addActionListener(this);
		menuItem3.addActionListener(this);

		// Add the MenuItems to the Menu.
		menu1.add(menuItem1);
		menu1.add(menuItem2);
		menu1.addSeparator();
		menu1.add(menuItem3);

		// Add the Menu to the MenuBar.
		menuBar.add(menu1);

		// Add the MenuBar to the JFrame.
		setJMenuBar(menuBar);
	}

	/**
	 * Add a header to the JFrame.
	 */
	private void addHeader() {
		
		// Create Header.
		headPanel = new JPanel();
		headPanel.setLayout(new GridBagLayout());
		
			// Initialize Components.
			greenColor = new JPanel();
			blueColor = new JPanel();
			blackColor = new JPanel();
			redColor = new JPanel();
			yellowColor = new JPanel();		
			typeComboBox = new JComboBox<String>(new String[] {"Frihand", "Rektangel"});
			
			// Set background.
			greenColor.setBackground(Color.GREEN);	
			blueColor.setBackground(Color.BLUE);
			blackColor.setBackground(Color.BLACK);
			redColor.setBackground(Color.RED);
			yellowColor.setBackground(Color.YELLOW);
			
			// Set Constraints.
			GridBagConstraints colorSelectionsConstraints = new GridBagConstraints();
			colorSelectionsConstraints.fill = GridBagConstraints.BOTH;
			colorSelectionsConstraints.weightx = 1;
			colorSelectionsConstraints.weighty = 1;
			
			// Add a MouseListener to each Color-Selection in the Header.
			greenColor.addMouseListener(new ColorSelectionMouseListener(GREEN));
			blueColor.addMouseListener(new ColorSelectionMouseListener(BLUE));
			blackColor.addMouseListener(new ColorSelectionMouseListener(BLACK));
			redColor.addMouseListener(new ColorSelectionMouseListener(RED));
			yellowColor.addMouseListener(new ColorSelectionMouseListener(YELLOW));
			
			// Add ActionListener for the JComboBox.
			typeComboBox.addActionListener (new ActionListener () {
				public void actionPerformed(ActionEvent e) {
		        	paintArea.setDrawingType(typeComboBox.getSelectedIndex());
			    }
			});
			
		// Add to Header.
		headPanel.add(greenColor, colorSelectionsConstraints);
		headPanel.add(blueColor, colorSelectionsConstraints);
		headPanel.add(blackColor, colorSelectionsConstraints);
		headPanel.add(redColor, colorSelectionsConstraints);
		headPanel.add(yellowColor, colorSelectionsConstraints);
		headPanel.add(typeComboBox);
		
		// Add to Frame.
		add(headPanel, BorderLayout.PAGE_START);
	}

	/**
	 * Add a container for painting to the JFrame.
	 */
	private void addPaintArea() {
		
		// Create Paint Area.
		paintArea = new PaintArea();
		
		// Add CoordinateListener (using the observer-pattern).
		paintArea.addListener(this);
		
		// Add to Frame.
		add(paintArea, BorderLayout.CENTER);
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
			colorSelectionLabel = new JLabel("Färgval: ");
			selectedColor = blackColor;
	
				// Set background.
				selectedColor.setBackground(Color.BLACK);
			
			// Add to Panels.
			coordPanel.add(coordLabel);
			coordPanel.add(coordXY);
			colorPanel.add(colorSelectionLabel);
			colorPanel.add(selectedColor);
			
		// Add to Footer.
		footPanel.add(coordPanel, BorderLayout.LINE_START);
		footPanel.add(colorPanel, BorderLayout.LINE_END);
		
		// Add to Frame.
		add(footPanel, BorderLayout.PAGE_END);
	}

	/**
	 * Performs the action for each selection in the Menu.
	 * 
	 * @param e - ActionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "Nytt":
				paintArea.reset();
			break;
			case "Ångra":
				paintArea.undo();
			break;
			case "Avsluta":
				exit();
			break;
		}				
	}
	
	/**
	 * Exits the application.
	 */
	private void exit() {
		
        // Display confirm dialog.
        int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION); 
        
        // Exit if user confirmed.
        if (confirmed == JOptionPane.YES_OPTION) {                             
             System.exit(0);
        } 
	}
	
	/**
	 * Selection-class of which color to draw with.
	 */
	private class ColorSelectionMouseListener extends MouseAdapter {
	    private final int index;

	    public ColorSelectionMouseListener(int index) {
	        this.index = index;
	    }

	    @Override
	    public void mouseClicked(MouseEvent e) {
			switch (index) {
				case GREEN:
					paintArea.setColor(Color.GREEN);
					selectedColor.setBackground(Color.GREEN);
				break;
				case BLUE:
					paintArea.setColor(Color.BLUE);
					selectedColor.setBackground(Color.BLUE);
				break;
				case BLACK:
					paintArea.setColor(Color.BLACK);
					selectedColor.setBackground(Color.BLACK);
				break;
				case RED:
					paintArea.setColor(Color.RED);
					selectedColor.setBackground(Color.RED);
				break;
				case YELLOW:
					paintArea.setColor(Color.YELLOW);
					selectedColor.setBackground(Color.YELLOW);
				break;
			}	
	    }
	}

	/**
	 * Keeps track of the mouse coordinates.
	 * 
	 * @param coordinates - Point
	 */
	@Override
	public void coordinateStatus(Point coordinates) {
		coordXY.setText(coordinates.getX() + ", " + coordinates.getY());
	}
}