import java.util.ArrayList;
import java.util.List;

public class TextAnalyzer {
	
	private static TextScanner scanner = new TextScanner();

	// 分析文本
	// 返回一个TextSpan对象对象
	public List<TextSpan> analyText(String text) {
		List<TextSpan> list = new ArrayList<>();
		// 设置要扫描的文本
		scanner.setText(text);
		// 重置扫描器
		scanner.reset();

		if (text != null) {
			int start = 0;
			int end = 0;
			while (scanner.canScan()) {
				char c = scanner.scanChar();
				switch (c) {
				case '\n':
					analyzeLF(list);
					break;
				case '\r':
					analyzeCR(list);
					break;
				case '\t':
					analyzeTab(list);
					break;
				default:
					analyzeDefault(list);
					break;
				}
			}
		}

		// 返回TextSpan对象集合
		return list;
	}

	// 分析其它字符
	private void analyzeDefault(List<TextSpan> list) {
		int start = 0;
		int end = 0;
		start = scanner.getPos();
		end = start + 1;
		if (scanner.canScan()) {
			while(scanner.canScan()){
				char ch = scanner.scanChar();
				if(ch != '\r' && ch != '\n' && ch != '\t')
				{
					end++;
				}
				else
				{
					scanner.retract();
					break;
				}
			}
			list.add(new TextSpan(TextSpan.TYPE_TEXT, start, end));
		} else {
			list.add(new TextSpan(TextSpan.TYPE_TEXT, start, end));
		}
	}

	// 分析\t
	private void analyzeTab(List<TextSpan> list) {
		int start = 0;
		int end = 0;
		
		start = scanner.getPos();
		end = start + 1;
		list.add(new TextSpan(TextSpan.TYPE_TAB, start, end));
	}

	// 分析\r
	private void analyzeCR(List<TextSpan> list) {
		int start = 0;
		int end = 0;

		start = scanner.getPos();
		end = start + 1;
		// 如果扫描器能扫描字符
		if (scanner.canScan()) {
			char ch = scanner.scanChar();
			// \r\n
			if (ch == '\n') {
				end++;
				list.add(new TextSpan(TextSpan.TYPE_LINE, start, end));
			} else { // \r\r \r其它字符
				list.add(new TextSpan(TextSpan.TYPE_LINE, start, end));
				// 扫描器后退一个扫描一个位置
				scanner.retract();
			}
		} else { // 以\r结尾
			list.add(new TextSpan(TextSpan.TYPE_LINE, start, end));
		}

	}

	// 分析\n
	private void analyzeLF(List<TextSpan> list) {
		int start = 0;
		int end = 0;

		start = scanner.getPos();
		end = start + 1;
		list.add(new TextSpan(TextSpan.TYPE_LINE, start, end));
	}
}
