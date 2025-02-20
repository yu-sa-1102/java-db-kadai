package kadai_015;

//車クラスを定義
public class Car_Chapter15 {
	
		// フィールド（内部データ）
		private int gear = 1;
		private int speed = 10;
		
		// コンストラクタの定義
		public Car_Chapter15() {
	
		}
		
		// 車クラスのgearChangeメソッドを実行する
		public void  gearChange(int afterGear) {
			System.out.println("ギア" + gear + "から" + afterGear + "に切り替えました");
			gear = afterGear;
			
			switch(afterGear) {
			case 1 -> this.speed = 10;
			case 2 -> this.speed = 20;
			case 3 -> this.speed = 30;
			case 4 -> this.speed = 40;
			case 5 -> this.speed = 50;
			}
			
		}
		
		// 車クラスのrunメソッドを実行する
		public void run() {
			System.out.println("速度は時速" + speed + "kmです");
		}
}
