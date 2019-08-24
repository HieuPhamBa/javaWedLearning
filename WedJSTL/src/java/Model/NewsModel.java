/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DBConect.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author PhamBaHieu
 */
public class NewsModel {
  private Connection conn = null;
  private DBConnection db = null;
  public int getNumberNews() throws SQLException, ClassNotFoundException{
      db = new DBConnection();
      conn = db.connect();
      String sql = "SELECT COUNT(*) from news";
      PreparedStatement psmt = conn.prepareStatement(sql);
      ResultSet rs = psmt.executeQuery();
      if(rs.next())
           return rs.getInt(1);
      return 1;
  }
  
   public int getNumberNews(String keys) throws SQLException, ClassNotFoundException{
      db = new DBConnection();
      conn = db.connect();
      String sql = "SELECT COUNT(*) from news  join authour on news.id_author = authour.id";
      sql += " where name = ?";
      sql += " or content = ?";
      sql += " or title = ?";
      
      PreparedStatement psmt = conn.prepareStatement(sql);
      
      psmt.setString(1, keys);
      psmt.setString(2, keys);
      psmt.setString(3, keys);
      
      ResultSet rs = psmt.executeQuery();
      if(rs.next())
           return rs.getInt(1);
      return 1;
  }
  
  public List<News> getNews(int limit, int offset) throws ClassNotFoundException, SQLException{
      db = new DBConnection();
      conn = db.connect();
      String sql = "SELECT * from news  join authour on news.id_author = authour.id LIMIT ? OFFSET ?";
      
      PreparedStatement psmt = conn.prepareStatement(sql);
      psmt.setInt(1, limit);
      psmt.setInt(2, offset);
      ResultSet rs = psmt.executeQuery();
      News nws = new News();
      List<News> lst = new ArrayList<>();
      while(rs.next()){
          nws.setAuthor(rs.getString("name"));
          nws.setContent(rs.getString("content"));
          nws.setTitle("title");
          lst.add(nws);
      }
      return lst;
  }
  
   public List<News> getNews() throws ClassNotFoundException, SQLException{
      db = new DBConnection();
      conn = db.connect();
      String sql = "SELECT * from news  join authour on news.id_author = authour.id";
      PreparedStatement psmt = conn.prepareStatement(sql);
    
      ResultSet rs = psmt.executeQuery();
      News nws = new News();
      List<News> lst = new ArrayList<>();
      while(rs.next()){
          nws.setAuthor(rs.getString("name"));
          nws.setContent(rs.getString("content"));
          nws.setTitle("title");
          lst.add(nws);
      }
      return lst;
   }
   
   public List<News> getNewsByKeys(int limit, int offset, String key) throws ClassNotFoundException, SQLException{
      db = new DBConnection();
      conn = db.connect();
      String sql = "SELECT * from news  join authour on news.id_author = authour.id ";//
      sql += " where name = ?";
      sql += " or content = ?";
      sql += " or title = ?";
      sql += " LIMIT ? OFFSET ?";
      PreparedStatement psmt = conn.prepareStatement(sql);
     
      psmt.setString(1, key);
      psmt.setString(2, key);
      psmt.setString(3, key);
      psmt.setInt(4, limit);
      psmt.setInt(5, offset);
      
      ResultSet rs = psmt.executeQuery();
      News nws = new News();
      List<News> lst = new ArrayList<>();
      while(rs.next()){
          nws.setAuthor(rs.getString("name"));
          nws.setContent(rs.getString("content"));
          nws.setTitle(rs.getString("title"));
          lst.add(nws);
      }
      return lst;
  }
}
