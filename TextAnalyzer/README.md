# TextAnalyzer
### 一个简易的文本分析工具

### TextSpan类简单介绍
##### TextSpan将文本内容的类型分为三类，
1. 普通文本
2. 换行符
3. 制表符
##### TextSpan类中的getStart()方法 获取文本的起始索引
##### TextSpan类中的getEnd()方法 获取文本的结束索引

### TextAnalyzer类使用示例
```java
// 创建一个TextAnalyzer对象
TextAnalyzer analyzer = new TextAnalyzer();

// 调用analyText方法分析指定的文本，得到一个TextSpan对象集合
String text = "abc\r\n";
List<TextSpan> list = analyzer.analyText("abc\r\n");

// 遍历list
for(TextSpan span : list){
    System.out.println(span);
}
```
上面的正确运行结果如下

(text)(0,3)  
(line)(3,5)  

后面括号内的数字分别代表 起始索引 和 结束索引
