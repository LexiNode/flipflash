/**
 * 
 */
package flipflash;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

/**
 * @author James Hooker
 *
 */
public class FlipFlash {

	JFrame frame = new JFrame("Flip Flash");
	JPanel frontPanel = new JPanel();
	JLabel frontLabel = new JLabel("Welcome to Flip Flash \npress button to begin");
	JButton flipButton = new JButton("Flip!");
	JPanel backPanel = new JPanel();
	JLabel backLabel = new JLabel("Onward!");
	Dimension cardSize = new Dimension(405,250);
	Dimension buttonSize = new Dimension(50,50);
	
	Flash[] cards;
	FlipFlashListener ffListener;
	FlipFlashHelper ffHelper;
	
	/**
	 * 
	 */
	public FlipFlash() {
		// TODO Auto-generated constructor stub
		ffHelper = new FlipFlashHelper(this);
		ffListener = new FlipFlashListener(this, ffHelper);
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FlipFlash ff = new FlipFlash();
		ff.createAndShowGUI();
	}

	private void createAndShowGUI() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		addAndArrangePanels(frame);
		addMenu(frame);
		
		frame.pack();
		frame.setVisible(true);
	}

	private void addMenu(JFrame frame2) {
		// TODO Auto-generated method stub
		
	}

	private void addAndArrangePanels(JFrame frame2) {
		Border paddingBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border lineBorder = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
		frontPanel.setBorder(lineBorder);
		frontPanel.setPreferredSize(cardSize);
		backPanel.setBorder(lineBorder);
		backPanel.setPreferredSize(cardSize);
		frontLabel.setBorder(paddingBorder);
		frontLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		flipButton.setPreferredSize(buttonSize);
		flipButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		backLabel.setBorder(paddingBorder);
		backLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		frontPanel.add(frontLabel);
		backPanel.add(backLabel);
		frame.add(frontPanel);
		frame.add(flipButton);
		frame.add(backPanel);
	}

}
