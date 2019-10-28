package code;

public class CaesarCode {

	public static String caesarCode(String input, char offset) {
		String s = "";
		input = input.toUpperCase();
		offset = Character.toUpperCase(offset);
		int numOffset = (int) offset - (int) 'A';
		for (int x = 0; x < input.length(); x++) {
			char c = (char) (input.charAt(x) + numOffset);
			if (c > 'Z')
				s += (char) (c - 26);
			else
				s += c;
		}
		return s;
	}

	public static String caesarDeCode(String input, char offset) {
		String s = "";
		input = input.toUpperCase();
		offset = Character.toUpperCase(offset);
		int numOffset = (int) offset - (int) 'A';
		for (int x = 0; x < input.length(); x++) {
			char c = (char) (input.charAt(x) - numOffset);
			if (c < 'A')
				s += (char) (c + 26);
			else
				s += c;
		}
		return s;
	}

}
