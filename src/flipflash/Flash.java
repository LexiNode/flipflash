/**
 * 
 */
package flipflash;

/**
 * @author hookerjs
 *
 */
public class Flash {
	private String	front;
	private String	back;
	
	public Flash(){
		
	}
	
	public Flash(String front, String back) {
		super();
		this.front = front;
		this.back = back;
	}

	public String getFront() {
		return front;
	}

	public void setFront(String front) {
		this.front = front;
	}

	public String getBack() {
		return back;
	}

	public void setBack(String back) {
		this.back = back;
	}
}
