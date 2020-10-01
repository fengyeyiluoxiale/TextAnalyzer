import java.util.List;

public class Main {

	public static void main(String[] args) {

		TextAnalyzer analyzer = new TextAnalyzer();

		List<TextSpan> list = analyzer.analyText("abc\r\n");
		for(TextSpan span : list){
			System.out.println(span);
		}
	}

}
