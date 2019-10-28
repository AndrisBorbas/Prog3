import code.CaesarCode;
import gui.CaesarFrame;

public class App {

	public static void main(String[] args) {

		CaesarCode c = new CaesarCode();

		String s = c.caesarCode("abcxyza", 's');

		System.out.println(s);

		CaesarFrame f = new CaesarFrame();
		f.setVisible(true);
	}

}
