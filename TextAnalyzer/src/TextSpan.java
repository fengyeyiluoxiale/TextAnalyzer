public class TextSpan {
	// 普通文本
	public static final int TYPE_TEXT = 0;
	// 换行符
	public static final int TYPE_LINE = 1;
	// 制表符
	public static final int TYPE_TAB = 2;

	// TextSpan的类型
	private int type = 0;

	public TextSpan(int type, int start, int end) {
		super();
		if (start >= 0 && end >= 0) {
			this.type = type;
			this.start = start;
			this.end = end;
		}

	}

	// TextSpan的起始索引
	private int start = 0;
	// TextSpan的结束索引
	private int end = 0;

	// 获取起始索引
	public int getStart() {
		return start;
	}

	// 设置起始索引
	public void setStart(int start) {
		if (start >= 0)
			this.start = start;
	}

	// 获取结束索引
	public int getEnd() {
		return end;
	}

	// 设置结束索引
	public void setEnd(int end) {
		if (end >= 0)
			this.end = end;
	}

	private static StringBuffer sb = new StringBuffer();

	// toString
	@Override
	public String toString() {
		// 清空
		sb.delete(0, sb.length());
		switch (type) {
		case TextSpan.TYPE_LINE:
			sb.append("(line)");
			break;
		case TextSpan.TYPE_TAB:
			sb.append("(tab)");
			break;
		default:
			sb.append("(text)");
			break;
		}

		sb.append("(");
		sb.append(start);
		sb.append(",");
		sb.append(end);
		sb.append(")");
		return sb.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj instanceof TextSpan) {
			TextSpan span = (TextSpan) obj;
			if (this.type != span.type)
				return false;
			if (this.start != span.start)
				return false;
			if (this.end != span.end)
				return false;

			// 否则则认为相等
			return true;
		} else {
			return false;
		}
	}
}
