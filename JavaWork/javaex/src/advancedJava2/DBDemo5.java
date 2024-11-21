package advancedJava2;

import java.sql.*;
import java.util.Scanner;

public class DBDemo5 {
  public static void main(String[] args) throws SQLException {
    Connection conn = makeConnection();
    getSpecificPersonInfo(conn);
  }

  private static void getSpecificPersonInfo(Connection conn) {
    Scanner in = new Scanner(System.in);
    System.out.println("조회하고 싶은 사람의 전화번호를 입력하세요 : ");
    String phone = in.nextLine();
    String sql = "select * from person where phone = ? ";
    ResultSet rs = null;
    try {
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, phone);
      rs = ps.executeQuery();
      if(rs.getRow()== 0) {
        System.out.println("조건에 맞는 데이터가 없습니다.");
      } else {
        while (rs.next()) {
          System.out.println(rs.getString(1) + "," + rs.getString(2) + "," +
              rs.getString(3));
        }
      }
      rs.close();
    } catch (SQLException e) {
      System.out.println("SQL 실행중 오류가 발생했습니다.");
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
