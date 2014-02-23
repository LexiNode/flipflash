/**
 * 
 */
package flipflash;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

/**
 * @author James Hooker
 *
 */
public class FlipFlash {

	JFrame frame = new JFrame("Flip Flash");
	List<Image> icons = new ArrayList<Image>();
	JPanel framePanel = new JPanel();
	JPanel frontPanel = new JPanel();
	JLabel frontLabel = new JLabel("Welcome to Flip Flash \npress button to begin");
	JButton flipButton = new JButton("Flip!");
	JPanel backPanel = new JPanel();
	JLabel backLabel = new JLabel("Onward!");
	Dimension cardSize = new Dimension(405,250);
	Dimension buttonSize = new Dimension(50,50);
	
	Flash[] cards;
	int currentcard = 0;
	
	FlipFlashListener ffListener;
	FlipFlashHelper ffHelper;
	
	/**
	 * 
	 */
	
	public FlipFlash() {
		ffHelper = new FlipFlashHelper(this);
		ffListener = new FlipFlashListener(this, ffHelper);
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		flipButton.addMouseListener(ffListener);
		ffHelper.loadCards();
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
		
		addIcons(frame);
		addAndArrangePanels(frame);
		addMenu(frame);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	/**
	 * Sets the Icons for the Swing frame.
	 * Icons are not displayed in OSX as far as I can tell.
	 * Testing is needed on other environments also.
	 * @param frame
	 */
	private void addIcons(JFrame frame) {
		int[] macIconSizes = {16,32,64,128,256,512,1024};
		for(int i : macIconSizes){
			System.out.println(i);
			icons.add(new ImageIcon("/flipflash/res/logo"+i+".png").getImage());
		}
		frame.setIconImages(icons);
	}

	private void addMenu(JFrame frame) {
		JMenu file = new JMenu("File");
		file.setMnemonic('F');
		JMenuItem loadItem = new JMenuItem("Load Deck");
		loadItem.setMnemonic('L');
		loadItem.addActionListener(ffListener);
		file.add(loadItem);
		JMenuItem saveItem = new JMenuItem("Save Deck");
		saveItem.setMnemonic('S');
		saveItem.addActionListener(ffListener);
		file.add(saveItem);
		JMenuItem resetItem = new JMenuItem("Reset Deck");
		resetItem.setMnemonic('R');
		resetItem.addActionListener(ffListener);
		file.add(resetItem);
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.setMnemonic('x');
		exitItem.addActionListener(ffListener);
		file.add(exitItem);
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(file);
		frame.setJMenuBar(menuBar);
		
	}

	private void addAndArrangePanels(JFrame frame) {
		Border paddingBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border lineBorder = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
		frontPanel.setBorder(lineBorder);
		frontPanel.setPreferredSize(cardSize);
		frontPanel.setLayout(new BorderLayout(5,5));
		backPanel.setBorder(lineBorder);
		backPanel.setPreferredSize(cardSize);
		backPanel.setLayout(new BorderLayout(5,5));
		frontLabel.setBorder(paddingBorder);
		frontLabel.setHorizontalAlignment(JLabel.CENTER);
		flipButton.setPreferredSize(buttonSize);
		flipButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		backLabel.setBorder(paddingBorder);
		backLabel.setHorizontalAlignment(JLabel.CENTER);
		backLabel.setVisible(false);
		frontPanel.add(frontLabel, BorderLayout.CENTER);
		backPanel.add(backLabel, BorderLayout.CENTER);
		framePanel.setBorder(paddingBorder);
		framePanel.setLayout(new BoxLayout(framePanel, BoxLayout.Y_AXIS));
		framePanel.add(frontPanel);
		framePanel.add(flipButton);
		framePanel.add(backPanel);
		frame.add(framePanel);
	}

}
