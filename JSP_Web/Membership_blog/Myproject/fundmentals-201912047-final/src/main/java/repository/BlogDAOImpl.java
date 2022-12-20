package repository;

import iducs201912047.javaweb.fundmentals.model.Blog;
import iducs201912047.javaweb.fundmentals.model.Member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class BlogDAOImpl extends OracleDAO implements BlogDAO {
    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;

    @Override
    public int create(Blog b) {
        int ret = 0;
        String sql = "insert into bl201912047 values(seq_mb201912047.nextval, ?,?,?,?,?)";

        //sSystem.out.println(sql);
        try {
            conn = getConnection(); // DB 연결 객체 생성

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, b.getTitle());
            pstmt.setString(2, b.getContent());
            pstmt.setString(3, b.getRegdate());
            pstmt.setString(4, b.getAuthor());
            pstmt.setString(5, b.getEmail());

            ret = pstmt.executeUpdate(); // SQL 실행 후 결과를 rs에 반환, 질의 결과로 영향받은 레코드의 수를 반환 (Int형)
            if (ret <= 0)
                throw new SQLException("블로그 포스트 실패");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeResources(conn, stmt, pstmt, rs);  // 6단계 자원 반납까지
            return ret;
        }

    }



    @Override
    public Blog read(Blog b) {
        Blog ret = null;
        String sql = "select * from bl201912047 where id ='" + b.getId() + "'";
        try {
            conn =  getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);   // id 값 연결후 질의해서 가져옴
            if(rs.next()){
                ret = new Blog();
                ret.setId(rs.getLong("id"));
                ret.setTitle(rs.getString("title"));
                ret.setRegdate(rs.getString("regdate"));
                ret.setContent(rs.getString("content"));
                ret.setAuthor(rs.getString("author"));
                ret.setEmail(rs.getString("email"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            closeResources(conn, stmt, pstmt, rs);
            return  ret;
        }

    }

    @Override
    public List<Blog> readList() {
        List<Blog> blogList = null;
        Blog ret = null;
        String sql = "select * from bl201912047";
        try {
            conn = getConnection(); // DB 연결 객체 생성
            stmt = conn.createStatement(); // 문장(statement) 객체 생성 후 배정
            rs = stmt.executeQuery(sql); // SQL 실행 후 결과를 rs에 반환
            blogList = new ArrayList<Blog>();
            while (rs.next()) { // 결과 집합에서 다음 결과가 있는 지 확인, 있으면 true
                // resultSet의 내용을 DTO 집합 객체(JCF 이해가 필요)에 설정
                ret = new Blog();
                ret.setId(rs.getLong("id"));
                ret.setTitle(rs.getString("title"));
                ret.setRegdate(rs.getString("regdate"));
                ret.setContent(rs.getString("content"));
                ret.setAuthor(rs.getString("author"));
                ret.setEmail(rs.getString("email")); //DBMS records == resultSet 필드 이름

                blogList.add(ret); // 최종결과가 memberList에 담김
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeResources(conn, stmt, pstmt, rs);
            return blogList;
        }
    }

    @Override
    public int update(Blog b) {
        int ret = 0;
        String sql = "update bl201912047 set title =? , content=?, regdate=?, author=? where email =? and id=?"; // ? : placeholder 자리 대체자
        //and id=?
        //sSystem.out.println(sql);
        try {
            conn = getConnection(); // DB 연결 객체 생성

            // 4단계 문장 객체 만들고, 5단계 실행까지
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, b.getTitle());
            pstmt.setString(2, b.getContent());  // 위 ? 에 넣어주는 것임
            pstmt.setString(3, b.getRegdate());  // 위 ? 에 넣어주는 것임
            pstmt.setString(4, b.getAuthor());
            pstmt.setString(5, b.getEmail());
            pstmt.setLong(6, b.getId());
            ret = pstmt.executeUpdate(); // SQL 실행 후 결과를 rs에 반환, 질의 결과로 영향받은 레코드의 수를 반환
            if (ret <= 0)
                throw new SQLException("수정 실패");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeResources(conn, stmt, pstmt, rs);  // 6단계 자원 반납까지
            return ret;
        }

    }

    @Override
    public int delete(Blog blog) {
        int ret = 0;
        String sql = "delete from bl201912047 where id = ?"; // ? : placeholder 자리 대체자
        //sSystem.out.println(sql);
        try {
            conn = getConnection(); // DB 연결 객체 생성

            // 4단계 문장 객체 만들고, 5단계 실행까지
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, blog.getId());
            ret = pstmt.executeUpdate(); // SQL 실행 후 결과를 rs에 반환, 질의 결과로 영향받은 레코드의 수를 반환
            if (ret <= 0)
                throw new SQLException("삭제 실패");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeResources(conn, stmt, pstmt, rs);  // 6단계 자원 반납까지
            return ret;
        }
    }

    @Override
    public List<Blog> sort() {
        List<Blog> blogList = null;
        Blog ret = null;
        String sql = "select * from bl201912047 ORDER BY regdate";
        try {
            conn = getConnection(); // DB 연결 객체 생성
            stmt = conn.createStatement(); // 문장(statement) 객체 생성 후 배정
            rs = stmt.executeQuery(sql); // SQL 실행 후 결과를 rs에 반환
            blogList = new ArrayList<Blog>();
            while (rs.next()) { // 결과 집합에서 다음 결과가 있는 지 확인, 있으면 true
                // resultSet의 내용을 DTO 집합 객체(JCF 이해가 필요)에 설정
                ret = new Blog();
                ret.setId(rs.getLong("id"));
                ret.setTitle(rs.getString("title"));
                ret.setRegdate(rs.getString("regdate"));
                ret.setContent(rs.getString("content"));
                ret.setAuthor(rs.getString("author"));
                ret.setEmail(rs.getString("email")); //DBMS records == resultSet 필드 이름

                blogList.add(ret); // 최종결과가 memberList에 담김
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeResources(conn, stmt, pstmt, rs);
            return blogList;
        }
    }

    @Override
    public List<Blog> reverse() {
        List<Blog> blogList = null;
        Blog ret = null;
        String sql = "select * from bl201912047 ORDER BY regdate DESC ";
        try {
            conn = getConnection(); // DB 연결 객체 생성
            stmt = conn.createStatement(); // 문장(statement) 객체 생성 후 배정
            rs = stmt.executeQuery(sql); // SQL 실행 후 결과를 rs에 반환
            blogList = new ArrayList<Blog>();
            while (rs.next()) { // 결과 집합에서 다음 결과가 있는 지 확인, 있으면 true
                // resultSet의 내용을 DTO 집합 객체(JCF 이해가 필요)에 설정
                ret = new Blog();
                ret.setId(rs.getLong("id"));
                ret.setTitle(rs.getString("title"));
                ret.setRegdate(rs.getString("regdate"));
                ret.setContent(rs.getString("content"));
                ret.setAuthor(rs.getString("author"));
                ret.setEmail(rs.getString("email")); //DBMS records == resultSet 필드 이름

                blogList.add(ret); // 최종결과가 memberList에 담김
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeResources(conn, stmt, pstmt, rs);
            return blogList;
        }
    }

    @Override
    public List<Blog> titlereverse() {
        List<Blog> blogList = null;
        Blog ret = null;
        String sql = "select * from bl201912047 ORDER BY title DESC ";
        try {
            conn = getConnection(); // DB 연결 객체 생성
            stmt = conn.createStatement(); // 문장(statement) 객체 생성 후 배정
            rs = stmt.executeQuery(sql); // SQL 실행 후 결과를 rs에 반환
            blogList = new ArrayList<Blog>();
            while (rs.next()) { // 결과 집합에서 다음 결과가 있는 지 확인, 있으면 true
                // resultSet의 내용을 DTO 집합 객체(JCF 이해가 필요)에 설정
                ret = new Blog();
                ret.setId(rs.getLong("id"));
                ret.setTitle(rs.getString("title"));
                ret.setRegdate(rs.getString("regdate"));
                ret.setContent(rs.getString("content"));
                ret.setAuthor(rs.getString("author"));
                ret.setEmail(rs.getString("email")); //DBMS records == resultSet 필드 이름

                blogList.add(ret); // 최종결과가 memberList에 담김
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeResources(conn, stmt, pstmt, rs);
            return blogList;
        }
    }


}
