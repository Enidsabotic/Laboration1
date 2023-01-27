package laboration1;

public class DString implements DynamicString { // implementera metoderna i DynamicString - se lab
	private char[] text;
	private int length = 0;
	
	public DString() {
		this(10);
	}
	
	public DString(int size) {

		text = new char[size];
		length = 0;
	}
	
	public DString(String str) {
		text = str.toCharArray();
		length = text.length;
	}

	public DString(DString str) {
		text = new char[str.length()];
		for(int i=0; i<str.length(); i++) {
			text[i] = str.charAt(i);
		}
		length = text.length;
	}
	
	private void grow() {
		char[] newArr = new char[length*2];
		System.arraycopy(text, 0, newArr, 0, text.length);
		text = newArr;
	}

	@Override
	public int length() {
		length = text.length;
		return length;
	}

	@Override
	public char charAt(int index) {

		return text[index];
	}

	public void append(char chr) {
		if(length==text.length) {
			grow();
		}
		text[length++] = chr;
	}

	@Override
	public void append(DString str) {

		for (int i = 0; i<str.length;i++){
			append(str.charAt(i));
		}
	}

	@Override
	public void delete(int start, int end) {
        //
		System.arraycopy(text, end, text, start, length-end);
		int removed = (end-start);
		length = length - removed;

	}
	/**
	 * Tar bort tecknet i angiven position
	 * @param index Positionen för tecknet som ska tas bort
	 */
	@Override
	public void delete(int index) {

	delete(index,index+1);


	}

	@Override
	public String substring(int start, int end) {
		char [] text2 = new char[start-end];

		System.arraycopy(text, start, text2, start, end);

		return ;
	}

	@Override
	public String substring(int start) {
		return null;
	}

	@Override
	public int indexOf(char chr) {
		return 0;
	}
}