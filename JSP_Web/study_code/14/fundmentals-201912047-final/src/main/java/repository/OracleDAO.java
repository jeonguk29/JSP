package repository;

import java.sql.*;

public class OracleDAO implements DAO{

    @Override
    public Connection getConnection() {
        Connection conn = null;
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
        String dbUser = "sw201912047";
        String dbPass = "cometrue";
/*
1단계 드라이브 빌드시스템에 적용
*/
        try {
            Class.forName("oracle.jdbc.OracleDriver"); // 드라이버 로딩  : 이드라이브를 메모리에 적제시킴
            conn = DriverManager.getConnection(jdbcUrl,dbUser,dbPass); // 여기는 오라클이던 mysql이던 바뀌지 않음
            // 반환 값 커낸션 정보를 받아야람  3단계까지 끝 총 6단 계임
        }catch (ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }

        return conn;
    }

    @Override
    public void closeResources(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet rs) {
      // 자원 회수 6단계
        if (rs != null) try { rs.close(); } catch(Exception e) {}
        if (pstmt != null) try { pstmt.close(); } catch(Exception e) {}
        if (stmt != null) try { stmt.close(); } catch(Exception e) {}
        if (conn != null) try { conn.close(); } catch(Exception e) {}

    }
}
