package cn.aki.demo.test;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;

public class LuceneTest {

	@Test
	public void analyzerTest() {
		String testWords =
				"然后东门天虹边上有一个死的差不多的动漫城";
//		getTokens(new StandardAnalyzer(), testWords);
		getTokens(new SmartChineseAnalyzer(), testWords);
//		getTokens(new IKAnalyzer(), testWords);

	}

	private void getTokens(Analyzer analyzer, String msg) {
		try (TokenStream tokenStream = analyzer.tokenStream("content", new StringReader(msg))) {
			tokenStream.reset();

			CharTermAttribute ta = tokenStream.addAttribute(CharTermAttribute.class);
			StringBuilder result = new StringBuilder();
			while (tokenStream.incrementToken()) {
				if (result.length() > 0) {
					result.append(",");
				}
				result.append("[").append(ta.toString()).append("]");
			}
			System.err.println(analyzer.getClass().getSimpleName() + "->" + result.toString());

			tokenStream.end();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
