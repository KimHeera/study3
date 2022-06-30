package base;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {
	static int count=0;
	static int count2;
	private static Connection conn; //DB 커넥션 연결 객체
    private static final String USERNAME = "root";//DBMS접속 시 아이디
    private static final String PASSWORD = "12345678";//DBMS접속 시 비밀번호
    private static final String URL = "jdbc:mysql://localhost/LoginDB";//DBMS접속할 db명
    
    static String userid="";
    static String userpw="";
    static String usern = "";
    
    static ArrayList<String> arr = new ArrayList<String>();
    
    
	public Database() {
		try {
            System.out.println("생성자");
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("드라이버 로딩 성공");
        } catch (Exception e) {
            System.out.println("드라이버 로딩 실패 ");
            try {
                conn.close();
            } catch (SQLException e1) {    }
        }
	}
	
	public static void insert(String name, int id, String pw, String birth, String gender, String pnum,  String hint) {
		String sql = "insert into tb_user(username, userid, userpw, userbirth, usergender, userphone, userhint) values (?,?,?,?,?,?,?);";
        PreparedStatement pstmt = null;
		
        try {
        	
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, name);
            pstmt.setInt(2, id);
            pstmt.setString(3, pw);
            pstmt.setString(4, birth);
            pstmt.setString(5, gender);
            pstmt.setString(6, pnum);
            pstmt.setString(7, hint);
            
            System.out.println(name + " " + id + " " + pw + " " + birth + " " + gender + " " + pnum + " " + hint);
            int result = pstmt.executeUpdate();
            if(result==1) {
                System.out.println("Board데이터 삽입 성공!");
                
            }
            
        } catch (Exception e) {
            System.out.println("Board데이터 삽입 실패!");
        }    finally {
            try {
                if(pstmt!=null && !pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (Exception e2) {}
        }
	}
	
	public static String[] select(int id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String[] userinfo = new String[7];
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("연결 성공");
			String sql = "select * from tb_user where userid =" + id+ ";";
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery(sql);
	
	        while(rs.next()){
	        	userinfo[0] = rs.getString(1);
	            userinfo[1] = rs.getString(2);
	            userinfo[2] = rs.getString(3);
	            userinfo[3] = rs.getString(4);
	            userinfo[4] = rs.getString(5);
	            userinfo[5] = rs.getString(6);
	            userinfo[6] = rs.getString(7);
	        }
	    }
	    catch( ClassNotFoundException e){
	        System.out.println("드라이버 로딩 실패");
	    }
	    catch( SQLException e){
	        System.out.println("에러 " + e);
	    }
	    finally{
	        try{
	            if( conn != null && !conn.isClosed()){
	                conn.close();
	            }
	            if( stmt != null && !stmt.isClosed()){
	                stmt.close();
	            }
	            if( rs != null && !rs.isClosed()){
	                rs.close();
	            }
	        }
	        catch( SQLException e){
	            e.printStackTrace();
	        }
	    }
		
		return userinfo;
	}
	
	public static void select() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String[] userinfo = new String[7];
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("연결 성공");
			String sql = "select * from tb_user;";
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery(sql);
	
	        while(rs.next()){
	            
	            String username = rs.getString(1);
	            String userid = rs.getString(2);
	            String userpwd = rs.getString(3);
	            String userbirth = rs.getString(4);
	            String usergender = rs.getString(5);
	            String userphone = rs.getString(6);
	            String userhint = rs.getString(7);
	            arr.add(username + "    " + userid + "    " + userpwd + "    " + userbirth + "    " + usergender + "    " + userphone + "    " + userhint);
	            
	        }
	    }
	    catch( ClassNotFoundException e){
	        System.out.println("드라이버 로딩 실패");
	    }
	    catch( SQLException e){
	        System.out.println("에러 " + e);
	    }
	    finally{
	        try{
	            if( conn != null && !conn.isClosed()){
	                conn.close();
	            }
	            if( stmt != null && !stmt.isClosed()){
	                stmt.close();
	            }
	            if( rs != null && !rs.isClosed()){
	                rs.close();
	            }
	        }
	        catch( SQLException e){
	            e.printStackTrace();
	        }
	    }
		
	}
	
	public static void selectnamean(String name, String an) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("연결 성공");
			String sql = "select userid, userpw from tb_user where username= '" + name + "' and userhint='" + an + "';";
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery(sql);
	
	        if(rs.next()) {
	        	userid = rs.getString(1);
	        	userpw = rs.getString(2);
	  
	        }
	        
	    }
	    catch( ClassNotFoundException e){
	        System.out.println("드라이버 로딩 실패");
	    }
	    catch( SQLException e){
	        System.out.println("에러 " + e);
	    }
	    finally{
	        try{
	            if( conn != null && !conn.isClosed()){
	                conn.close();
	            }
	            if( stmt != null && !stmt.isClosed()){
	                stmt.close();
	            }
	            if( rs != null && !rs.isClosed()){
	                rs.close();
	            }
	        }
	        catch( SQLException e){
	            e.printStackTrace();
	        }
	    }
	}
	
	
	
	public static void selectidpwd(int id, String pwd) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("연결 성공");
			String sql = "select count(*)  from tb_user where userid= " + id + " and userpw='" + pwd + "';";
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery(sql);
	        
	        if(rs.next()) {
	        	count = rs.getInt(1);
	        }
	        
	    }
	    catch( ClassNotFoundException e){
	        System.out.println("드라이버 로딩 실패");
	    }
	    catch( SQLException e){
	        System.out.println("에러 " + e);
	    }
	    finally{
	        try{
	            if( conn != null && !conn.isClosed()){
	                conn.close();
	            }
	            if( stmt != null && !stmt.isClosed()){
	                stmt.close();
	            }
	            if( rs != null && !rs.isClosed()){
	                rs.close();
	            }
	        }
	        catch( SQLException e){
	            e.printStackTrace();
	        }
	    }
	}
	
	public static void selectidpwC(int id, String pwd) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("연결 성공");
			String sql = "select username from tb_user where userid= " + id + " and userpw='" + pwd + "';";
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery(sql);
	        
	        if(rs.next()) {
	        	usern = rs.getString(1);
	        }
	        
	    }
	    catch( ClassNotFoundException e){
	        System.out.println("드라이버 로딩 실패");
	    }
	    catch( SQLException e){
	        System.out.println("에러 " + e);
	    }
	    finally{
	        try{
	            if( conn != null && !conn.isClosed()){
	                conn.close();
	            }
	            if( stmt != null && !stmt.isClosed()){
	                stmt.close();
	            }
	            if( rs != null && !rs.isClosed()){
	                rs.close();
	            }
	        }
	        catch( SQLException e){
	            e.printStackTrace();
	        }
	    }
	}
	
	public static void selectid(int id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("연결 성공");
			String sql = "select count(*)  from tb_user where userid= " + id +";";
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery(sql);
	        
	        if(rs.next()) {
	        	count = rs.getInt(1);
	        }
	        
	    }
	    catch( ClassNotFoundException e){
	        System.out.println("드라이버 로딩 실패");
	    }
	    catch( SQLException e){
	        System.out.println("에러 " + e);
	    }
	    finally{
	        try{
	            if( conn != null && !conn.isClosed()){
	                conn.close();
	            }
	            if( stmt != null && !stmt.isClosed()){
	                stmt.close();
	            }
	            if( rs != null && !rs.isClosed()){
	                rs.close();
	            }
	        }
	        catch( SQLException e){
	            e.printStackTrace();
	        }
	    }
	}
	
public static void delete(int userid) {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
      try { // 1. 드라이버 로딩
         Class.forName("com.mysql.cj.jdbc.Driver");
         conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

         String sql = "DELETE from tb_user where userid = "+userid+";";                                                                                                   // 준비
         stmt = conn.createStatement();
         stmt.executeUpdate(sql);
	     System.out.println("삭제 성공");
	     
      } catch (ClassNotFoundException e) {
         System.out.println("드라이버 로딩 실패");
      } catch (SQLException e) {
         System.out.println("에러 " + e);
      } finally {
         try {
            if (conn != null && !conn.isClosed()) {
               conn.close();
            }
            if (stmt != null && !stmt.isClosed()) {
               stmt.close();
            }
            if( rs != null && !rs.isClosed()){
                rs.close();
            }
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }

public static void delete() {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
      try { // 1. 드라이버 로딩
         Class.forName("com.mysql.cj.jdbc.Driver");
         conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

         String sql = "DELETE from tb_user where userid != 22100241;";                                                                                                   // 준비
         stmt = conn.createStatement();
         stmt.executeUpdate(sql);
	     System.out.println("삭제 성공");
	     
      } catch (ClassNotFoundException e) {
         System.out.println("드라이버 로딩 실패");
      } catch (SQLException e) {
         System.out.println("에러 " + e);
      } finally {
         try {
            if (conn != null && !conn.isClosed()) {
               conn.close();
            }
            if (stmt != null && !stmt.isClosed()) {
               stmt.close();
            }
            if( rs != null && !rs.isClosed()){
                rs.close();
            }
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }
	
public static void update(String name, int id, String pw, String birth, String pnum,  String hint) {
	      Connection conn = null;
	      Statement stmt = null;
	      ResultSet rs = null;
	      try{
	         Class.forName("com.mysql.cj.jdbc.Driver");
	            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	         System.out.println("연결 성공");
	         String sql = "update tb_user SET username ='"+name+"', userpw = "+pw+" , userbirth = '"+birth+"', userphone = '" + pnum + "', userhint = '"+hint+"' where userid = '"+id+"' ;";
	           stmt = conn.createStatement();
	           stmt.executeUpdate(sql);
	   
	       }
	       catch( ClassNotFoundException e){
	           System.out.println("드라이버 로딩 실패");
	       }
	       catch( SQLException e){
	           System.out.println("에러 " + e);
	       }
	       finally{
	           try{
	               if( conn != null && !conn.isClosed()){
	                   conn.close();
	               }
	               if( stmt != null && !stmt.isClosed()){
	                   stmt.close();
	               }
	               if( rs != null && !rs.isClosed()){
	                   rs.close();
	               }
	           }
	           catch( SQLException e){
	               e.printStackTrace();
	           }
	       }
	   }
}
 