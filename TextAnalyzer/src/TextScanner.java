public class TextScanner {

	private int pos = -1;
	private String text = "";

	public TextScanner() {

	}

	public TextScanner(String text) {
		if (text != null) {
			this.text = text;
		}
	}

	// 获取扫描器设置的扫描文本
	public String getText() {
		return text;
	}

	// 设置要扫描的文本
	public void setText(String text) {
		if (text != null)
			this.text = text;
	}

	// 判断能否扫描到新的字符
	public boolean canScan() {
		if (text != null) {
			if (pos < (text.length() - 1))
				return true;
			else
				return false;
		} else {
			return false;
		}
	}

	// 扫描得到一个字符
	public char scanChar() {
		if (text != null) {
			if (canScan()) {
				pos++;
				return text.charAt(pos);
			}
			return 0;
		} else {
			return 0;
		}
	}

	// 回退一个字符
	public void retract() {
		pos--;
		if (pos < -1)
			pos = -1;
	}

	// 重置扫描器
	public void reset() {
		pos = -1;
	}

	// 获取扫描器当前的扫描位置
	public int getPos() {
		return pos;
	}

}
