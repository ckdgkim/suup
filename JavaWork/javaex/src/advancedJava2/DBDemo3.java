package advancedJava2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBDemo3 {
  public static void main(String[] args) throws SQLException {
    Connection conn = makeConnection();
    removePersonInfo(conn);
  }

  private static void removePersonInfo(Connection conn) throws SQLException {
    String sql = "delete from person where phone = ? ";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, "010-444-4444");
    int res = ps.executeUpdate();
    if(res == 0) {
      System.out.println("데이터 삭제가 정상적으로 진행되지 않았습니다.");
    } else {
      System.out.println(res + "개의 데이터가 삭제되었습니다.");
    }
  }

  public static Connection makeConnection(){
    String url = "jdbc:mysql://localhost/javaex?serverTimezone=Asia/Seoul";
    Connection conn = null;
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      System.out.println("데이터베이스 연결중 ...");
      conn = DriverManager.getConnection(url, "root", "1111");
      System.out.println("데이터베이스 연결 성공");
    } catch (ClassNotFoundException e) {
      System.out.println("JDBC 드라이버 검색 오류");
    }  catch (SQLException e) {
      System.out.println("데이터베이스 연결 실패");
    }
    return conn;
  }
}
