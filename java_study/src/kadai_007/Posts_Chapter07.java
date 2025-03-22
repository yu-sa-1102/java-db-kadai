package kadai_007;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Posts_Chapter07 {

	public static void main(String[] args) {
		Connection con = null;
		Statement statement = null;

		try {
			con = DriverManager.getConnection(
					"dbc:mysql://localhost/challenge_java",
					"root",
					"Yukino0123"
					);
			System.out.println("データベース接続成功");
			System.out.println("レコード追加を実行します");
			
			//SQLクエリを準備
			statement = con.createStatement();
			String sql = """
								INSERT INTO posts (user_id,posted_at,post_content,likes) VALUES 
					 			(1003, '2023-02-08', '昨日の夜は徹夜でした・・', 13),
					 			(1002, '2023-02-08', 'お疲れ様です！', 12),
					 			(1003, '2023-02-09', '今日も頑張ります！', 18),
					 			(1001, '2023-02-09', '無理は禁物ですよ！', 17),
					 			(1002, '2023-02-10', '明日から連休ですね！', 20);
								
								""";
			
			String sql2 = "SELECT posted_at, post_content, likes FROM posts WHERE user_id = 1002;";
			
			// SQLクエリを実行（DBMSに送信）
			System.out.println("5件のレコードが追加されました");
			statement.executeUpdate(sql);
			System.out.println("ユーザーIDが1002のレコードを検索しました");
			ResultSet result = statement.executeQuery(sql2);
			
			// SQLクエリの実行結果を抽出
			while(result.next()) {
				Date postedAt = result.getDate("posted_at") ;
				String content = result.getString("post_content");
				int iine = result.getInt("likes");
				System.out.println(result.getRow() + "件目：投稿日時=" + postedAt + "／投稿内容=" + content + "／いいね数=" + iine);
			}
			
		
		}
		
		catch(SQLException e) {
			System.out.println("エラー発生：" + e.getMessage());
		}
		
		finally {
			//使用したオブジェクトを解放
			if(statement != null) {
				try {statement.close();} catch(SQLException ignore) {}
			}
			if(con != null) {
				try {con.close();} catch(SQLException ignore) {}
			}
		}
		
	}

}
