package advancedJava2;

import java.sql.*;

public class DBDemo {
  public static void main(String[] args) throws SQLException {
    Connection conn = makeConnection();
    createNewPerson(conn);
  }

  private static void createNewPerson(Connection conn) throws SQLException {
    Statement stmt = conn.createStatement();
    String sql = "insert into person (name, phone, email) values ('hong', '010-1111-1111', 'h@a.com')";
    int result = stmt.executeUpdate(sql);
    System.out.println(result + "개의 데이터가 추가되었습니다.");
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
