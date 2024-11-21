package com.example.product;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ProductDAO {
  //driver
  final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
  final String JDBC_URL = "jdbc:mysql://localhost:3305/db?serverTimezone=Asia/Seoul";
  //db connection
  Connection conn;
  //Statement
  PreparedStatement pstmt;
  //sql

  public void open(){
    try {
      Class.forName(JDBC_DRIVER);
      conn = DriverManager.getConnection(JDBC_URL,"root","1234");
    } catch (Exception e) {
        e.printStackTrace();
        log.error("데이터베이스 연결 실패: {}", e.getMessage());
    } finally {
      if(conn != null){
        log.info("데이터베이스 접속 완료...");
      } else {
        log.error("데이터베이스 연결이 설정되지 않았습니다.");
      }
    }
  }

  public void close(){
    try {
      if(pstmt!=null) pstmt.close();
      if(conn!=null) conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      log.info("데이터베이스 종료");
    }
  }

  public void create(Product p){
    String sql = "INSERT INTO product(name, description, price) VALUES(?,?,?)";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, p.getName());
      pstmt.setString(2, p.getDescription());
      pstmt.setInt(3, p.getPrice());

      int result = pstmt.executeUpdate();
      log.info("insert = " + result);
      if(result > 0){
        log.info("Product insert 성공: {}", p.getName());
      } else {
        log.error("Product insert 실패: {}", p.getName());
      }
    } catch (SQLException e) {
      e.printStackTrace();
      log.error("Product insert 에러: {}", e.getMessage());
    }
  }

  public List<Product> findAll() {
    List<Product> products = new ArrayList<Product>();

    String sql = "SELECT * FROM product";
    try {
      pstmt = conn.prepareStatement(sql);
      ResultSet rs = pstmt.executeQuery();
      log.info("findAll rs = " + rs);
      while(rs.next()){
        Product p = new Product(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("description"),
            rs.getInt("price")
        );
        products.add(p);
      }
    }  catch (SQLException e) {
      e.printStackTrace();
    }
    return products;
  }

  public Product findById(int id) {
    Product product = null;

    String sql = "SELECT * FROM product WHERE id =?";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, id);
      ResultSet rs = pstmt.executeQuery();
      log.info("findById rs = " + rs);

      if(rs.next()){
        product = new Product(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("description"),
            rs.getInt("price")
        );
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return product;
  }

  public void updateProduct(Product p){
    // price 수정 불가능
    String sql = "UPDATE product SET name=?, description=? WHERE id=?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, p.getName());
      pstmt.setString(2, p.getDescription());
      pstmt.setInt(3, p.getId());

      int result = pstmt.executeUpdate();
      log.info("updateProduct: " +result);
      if(result > 0){
        log.info("Product update 성공: {}", p.getName());
      } else {
        log.error("Product update 실패: {}", p.getName());
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void deleteProduct(int id){
    //1. sql 작성
    String sql = "DELETE FROM product WHERE id = ?";

    try {
      //2. pstmt 준비
      pstmt = conn.prepareStatement(sql);
      //3. pstmt 매개변수 설정
      pstmt.setInt(1, id);

      //4. pstmt의 sql을 실행
      int result = pstmt.executeUpdate();
      log.info("deleteProduct: " + result);

      if(result > 0){
        log.info("Product delete 성공: id={}", id);
      } else {
        log.error("Product delete 실패: id={}", id);
      }
    } catch (SQLException e) {
      e.printStackTrace();

    }
  }
}
