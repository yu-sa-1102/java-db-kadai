package kadai_004;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Employees_Chapter04 {

	public static void main(String[] args) {
		Connection con = null ;
		Statement statement = null;
		
		try {
			//データベースに接続
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/challenge_java","root","Yukino0123");
			
			System.out.println("データベース接続成功");
			System.out.println(con);
			
			//クエリを準備する
			statement = con.createStatement();
			String sql = """
								CREATE TABLE users (
									id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
									name VARCHAR(60) NOT NULL,
									email VARCHAR(255) NOT NULL,
									age INT(11),
									address VARCHAR(255)
								);
								""";
			//SQLを実行(DBMSに送信)
			int rowCnt = statement.executeUpdate(sql);
			System.out.println("テーブルを作成:rowCnt=" + rowCnt);
		}
		
		catch(SQLException e) {
			System.out.println("データベース接続失敗：" + e.getMessage());
		}
		
		finally {
			// 使用したオブジェクトを解放
			if(statement != null) {
				try {statement.close();} catch(SQLException ignore) {}
			}
			
			if(con != null) {
				try {con.close();} catch(SQLException ignore) {}
			}
		}

	}

}
