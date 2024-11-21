package advancedJava2;

import java.sql.*;

public class DBDemo4 {
  public static void main(String[] args) throws SQLException {
    Connection conn = makeConnection();
    getPersonInfos(conn);
  }

  private static void getPersonInfos(Connection conn) throws SQLException {
    String sql = "select * from person ";
    PreparedStatement ps = conn.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    while(rs.next()) {
      System.out.println(rs.getString(1) + "," + rs.getString(2) + "," +
          rs.getString(3));
    }
    rs.close();
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
