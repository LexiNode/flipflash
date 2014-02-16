package flipflash;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class FlipFlashListener implements ActionListener, MouseListener{

	private FlipFlash ff;
	private FlipFlashHelper ffHelper;
	
	public FlipFlashListener(FlipFlash flipFlash, FlipFlashHelper ffHelper) {
		this.ff = flipFlash;
		this.ffHelper = ffHelper;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton clickedButton = (JButton) e.getSource();
		if (clickedButton == ff.flipButton){
			if(e.getButton() == MouseEvent.BUTTON1){
				if(!ff.backLabel.isVisible())
					// Display back of card
					ff.backLabel.setVisible(true);
				else{
					// Display next card
					ff.backLabel.setVisible(false);
					ffHelper.nextFlash();
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
