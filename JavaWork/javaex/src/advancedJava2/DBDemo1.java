package advancedJava2;

import java.sql.*;

public class DBDemo1 {
  public static void main(String[] args) throws SQLException {
    Connection conn = makeConnection();
    createNewPerson(conn);
  }

  private static void createNewPerson(Connection conn) throws SQLException {
    String sql = "insert into person (name, phone, email) values (?, ?, ?)";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, "kim");
    ps.setString(2, "010-444-4444");
    ps.setString(3, "k@a.com");
    int res = ps.executeUpdate();
    if(res == 0) {
      System.out.println("데이터 추가가 정상적으로 진행되지 않았습니다.");
    } else {
      System.out.println(res + "개의 데이터가 추가되었습니다.");
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
