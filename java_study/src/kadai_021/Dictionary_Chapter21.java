package kadai_021;

import java.util.HashMap;

public class Dictionary_Chapter21 {

	public void translate(String keyword) {
		HashMap<String,String> fruitMap = new HashMap<>();
		fruitMap.put("apple", "りんご");
		fruitMap.put("peach", "桃");
		fruitMap.put("banana", "バナナ");
		fruitMap.put("lemon", "レモン");
		fruitMap.put("pear", "梨");
		fruitMap.put("kiwi", "キウィ");
		fruitMap.put("strawberry", "いちご");
		fruitMap.put("grape", "ぶどう");
		fruitMap.put("muscat", "マスカット");
		fruitMap.put("cherry", "さくらんぼ");
		
		String result = fruitMap.get(keyword);
		
		if(result == null) {
			System.out.println(keyword +  "は辞書に存在しません");
		}
		
		else {
			System.out.println(keyword + "の意味は" + fruitMap.get(keyword) + "です");
		}
		
	}
	

}
