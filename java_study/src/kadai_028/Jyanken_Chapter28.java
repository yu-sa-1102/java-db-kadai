package kadai_028;

import java.util.HashMap;
import java.util.Scanner;

public class Jyanken_Chapter28 {

	//自分のじゃんけんの手を入力する
	public String getMyChoice() {
		
		System.out.println("自分のじゃんけんの手を入力しましょう");
		System.out.println("グーはrockのrを入力しましょう");
		System.out.println("チョキはscissorsのsを入力しましょう");
		System.out.println("パーはpaperのpを入力しましょう");
		
		//Scannerクラスのオブジェクトを生成する
		Scanner scanner = new Scanner(System.in);
		    
		
	     while(true){
	    	 
	    	//入力した内容を取得する
	 		String input = scanner.next();
	 		//入力した内容を出力する
	 	     System.out.println(input); 
	    	 
	    	// 正しいじゃんけんの手であるか判定する
	 		if(input.equals("r") || input.equals("s") || input.equals("p")) {
	 			scanner.close();
	 			return input;
	 		}
	 		else {
	 			System.out.println("入力値がエラーです。正しい手 (r, s, p) を入力してください。");
	 			continue;
	 		}
	 		
	     }
		
	}
	
		public String getRandom() {
			//対戦相手のじゃんけんの手を乱数で選ぶ
			String items[] = {"r","s","p"};
			/*
			 乱数で3未満の数を取得し、取得した
			3未満の数をfloor()メソッドで切り捨て、配列の要素数である0から2を取得する
			*/
			String randJanken = items[(int) Math.floor(Math.random() * 3)];
			return randJanken;
		}
		
		//じゃんけんを行う
		public void playGame() {
			HashMap<String,String> choice = new HashMap<>();
			//自分と対戦相手のじゃんけんの手をHashMap要素に追加する
			choice.put("r","グー");
			choice.put("s","チョキ");
			choice.put("p", "パー");
			
			//自分と対戦相手のじゃんけんの手を出力する処理
			String mChoice = getMyChoice();
			String gRandom = getRandom();
			
			System.out.println("自分の手は" + choice.get(mChoice) + "," + "対戦相手の手は" + choice.get(gRandom));
			
			if(mChoice.equals(gRandom)) {
				System.out.println("あいこです");
			}
			
			else if (mChoice.equals("r") && gRandom.equals("s") || mChoice.equals("s") && gRandom.equals("p") ||  
					 mChoice.equals("p") && gRandom.equals("r")) {
				System.out.println("自分の勝ちです");
			}
			
			else {
				System.out.println("自分の負けです");
			}
				
		}

}
