package cn.aki.demo.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LuceneService {
	public static final String INDEX_PATH = "D://index";

	public static void main(String[] args) throws IOException, ParseException {
		new LuceneService().index();
		new LuceneService().search("快乐动漫城");
	}

	public void index() throws IOException {
		Analyzer analyzer = new SmartChineseAnalyzer();
		IndexWriterConfig config = new IndexWriterConfig(analyzer);
		config.setOpenMode(IndexWriterConfig.OpenMode.CREATE);

		try (Directory directory = FSDirectory.open(Paths.get(INDEX_PATH));
			 IndexWriter writer = new IndexWriter(directory, config)) {
			List<Post> list = createTestData();
			for (Post post : list) {
				Document document = new Document();
				document.add(new StringField("id", post.getId(), Field.Store.YES));
				document.add(new StringField("title", post.getTitle(), Field.Store.YES));
				document.add(new TextField("content", post.getContent(), Field.Store.NO));
				writer.addDocument(document);
			}
		}
	}


	private List<Post> createTestData() {
		List<Post> list = new ArrayList<>();
		list.add(new Post("1", "爆炸肥肥！", "仓促是一个共享技能"));
		list.add(new Post("2", "法界之火.猛男團被梦境缠绕", "为什么老人家精神这么好，一大早就要出发"));
		list.add(new Post("3", "快乐R语言(91/412)", "暗示见噗噗咻咻家长"));
		list.add(new Post("4", "快乐动漫城", "东门的1234商场二楼有喜茶"));
		list.add(new Post("5", "快乐R语言(91/412)", "然后东门天虹边快乐R上有一个死的差不多的动漫城"));
		list.add(new Post("6", "wodi", "现充阿黄 名不虚传"));
		list.add(new Post("7", "法界之火.猛男團被梦境缠绕", "谢谢煌先"));
		list.add(new Post("8", "本分奶", "现充阿黄快乐快乐快乐RR 名不虚传"));
		list.add(new Post("9", "本工地谢绝肥仔", "我TM牛奶喝爆"));
		return list;
	}

	public void search(String keyWords) throws IOException, ParseException {
		Directory directory = FSDirectory.open(Paths.get(INDEX_PATH));
		IndexReader reader = DirectoryReader.open(directory);
		IndexSearcher searcher = new IndexSearcher(reader);

		Analyzer analyzer = new SmartChineseAnalyzer();
		QueryParser parser = new QueryParser("content", analyzer);
		Query contentQuery = parser.parse(keyWords);
		// 组合查询
		BooleanQuery.Builder builder = new BooleanQuery.Builder();
		builder.add(new BooleanClause(new TermQuery(new Term("title", keyWords)),  BooleanClause.Occur.SHOULD));
		builder.add(contentQuery, BooleanClause.Occur.SHOULD);

		TopDocs topDocs = searcher.search(builder.build(), 5);
		System.err.println("totalHits" + topDocs.totalHits);

		List<String> idList = new ArrayList<>();
		for (ScoreDoc hit : topDocs.scoreDocs) {
			Document dic = searcher.doc(hit.doc);
			idList.add(dic.get("id"));
		}
		System.err.println(idList);
	}
}
