package flipflash;

public class FlipFlashHelper {

	private FlipFlash ff;
	
	public FlipFlashHelper(FlipFlash flipFlash) {
		// TODO Auto-generated constructor stub
		this.ff = flipFlash;
	}

	public void nextFlash() {
		// TODO Auto-generated method stub
		if(ff.currentcard++ >= ff.cards.length-1)
			ff.currentcard = 0;
		ff.frontLabel.setText(ff.cards[ff.currentcard].getFront());
		ff.backLabel.setText(ff.cards[ff.currentcard].getBack());
	}

	public void loadCards() {
		// TODO Auto-generated method stub
		ff.cards = new Flash[5];
		ff.cards[0]=new Flash("a","あ");
		ff.cards[1]=new Flash("i","い");
		ff.cards[2]=new Flash("u","う");
		ff.cards[3]=new Flash("e","え");
		ff.cards[4]=new Flash("o","お");
		loadCard(0);
	}
	
	public void loadCard(int i){
		ff.frontLabel.setText(ff.cards[i].getFront());
		ff.backLabel.setText(ff.cards[i].getBack());
	}

}
