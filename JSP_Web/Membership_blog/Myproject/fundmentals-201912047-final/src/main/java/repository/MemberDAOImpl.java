package repository;

import iducs201912047.javaweb.fundmentals.model.Blog;
import iducs201912047.javaweb.fundmentals.model.Member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;




public class MemberDAOImpl extends OracleDAO implements MemberDAO {
// 오라클 DAO 상속받고 멤버 DAO에서 구현해야될 목록을 받고

    // 2단계 객체 참조 변수 생성
    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public MemberDAOImpl() {
    }


    @Override
    public int create(Member m) {
        int ret = 0;
        String sql = "insert into mb201912047 values(seq_mb201912047.nextval, ?,?,?,?,?)";

        //sSystem.out.println(sql);
        try {
            conn = getConnection(); // DB 연결 객체 생성

            // 4단계 문장 객체 만들고, 5단계 실행까지
            // stmt = conn.createStatement();
            // ret = stmt.executeUpdate(sql); // SQL 실행 후 결과를 rs에 반환, 질의 결과로 영향받은 레코드의 수를 반환
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, m.getEmail());
            pstmt.setString(2, m.getPw());
            pstmt.setString(3, m.getName());
            pstmt.setString(4, m.getPhone());
            pstmt.setString(5, m.getAddress());
            ret = pstmt.executeUpdate(); // SQL 실행 후 결과를 rs에 반환, 질의 결과로 영향받은 레코드의 수를 반환 (Int형)
            if (ret <= 0)
                throw new SQLException("등록 실패");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeResources(conn, stmt, pstmt, rs);  // 6단계 자원 반납까지
            return ret;
        }

    }

    @Override
    public Member read(Member m) {

        Member retMember = null;
        String sql = "  select * from mb201912047 where email=?";
        try {
            conn = getConnection(); // DB 연결 객체 생성
            pstmt = conn.prepareStatement(sql); // 문장(statement) 객체 생성 후 배정
            pstmt.setString(1, m.getEmail());
            rs = pstmt.executeQuery(); // SQL 실행 후 결과를 rs에 반환

            if(rs.next()) { // 로그인은 한번만 돌거라 if 한번만 사용 (list 코드 가져와서 사용하고 있음) 결과 집합에서 다음 결과가 있는지 확인, 있으면 true
                retMember = new Member();
                retMember.setEmail(rs.getString("email")); //DBMS records == resultSet 필드 이름
               // retMember.setPw(rs.getString("pw")); 암호 노출 될 수 있어서 위험함
                retMember.setName(rs.getString("name"));
                retMember.setPhone(rs.getString("phone"));
                retMember.setAddress(rs.getString("address"));

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeResources(conn, stmt, pstmt, rs);
            return retMember;
        }
    }


    @Override
    public List<Member> readList() {
        List<Member> memberList = null;
        Member retMember = null;
        String sql = "select * from mb201912047";
        try {
            conn = getConnection(); // DB 연결 객체 생성
            stmt = conn.createStatement(); // 문장(statement) 객체 생성 후 배정
            rs = stmt.executeQuery(sql); // SQL 실행 후 결과를 rs에 반환
            memberList = new ArrayList<Member>();
            while (rs.next()) { // 결과 집합에서 다음 결과가 있는 지 확인, 있으면 true
                // resultSet의 내용을 DTO 집합 객체(JCF 이해가 필요)에 설정
                retMember = new Member();
                retMember.setEmail(rs.getString("email")); //DBMS records == resultSet 필드 이름
                retMember.setPw(rs.getString("pw"));
                retMember.setName(rs.getString("name"));
                retMember.setPhone(rs.getString("phone"));
                retMember.setAddress(rs.getString("address"));


                // retMember.setTname(rs.getString("tabtype")); // 174번 반복
                memberList.add(retMember); // 최종결과가 memberList에 담김
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeResources(conn, stmt, pstmt, rs);
            return memberList;
        }

    }

    @Override
    public int update(Member m) {
        int ret = 0;
        String sql = "update mb201912047 set name =? , phone=?, address=? where email =?"; // ? : placeholder 자리 대체자
        //sSystem.out.println(sql);
        try {
            conn = getConnection(); // DB 연결 객체 생성

            // 4단계 문장 객체 만들고, 5단계 실행까지
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, m.getName());
            pstmt.setString(2, m.getPhone());  // 위 ? 에 넣어주는 것임
            pstmt.setString(3, m.getAddress());
            pstmt.setString(4, m.getEmail());
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
    public int delete(Member m) {

        int ret = 0;
        String sql = "delete from mb201912047 where email = ? and pw= ?"; // ? : placeholder 자리 대체자
        //sSystem.out.println(sql);
        try {
            conn = getConnection(); // DB 연결 객체 생성

            // 4단계 문장 객체 만들고, 5단계 실행까지
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, m.getEmail());
            pstmt.setString(2, m.getPw());
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
    public Member login(Member m) {
        Member retMember = null;
        // String sql = "select * from member where email='" + m.getEmail()
        //         + "' and pw= '" + m.getPw() + "'";

        String sql = "select * from mb201912047 where email=? and pw=?";
        try {
            conn = getConnection(); // DB 연결 객체 생성
            pstmt = conn.prepareStatement(sql); // 문장(statement) 객체 생성 후 배정
            pstmt.setString(1, m.getEmail());
            pstmt.setString(2, m.getPw());
            rs = pstmt.executeQuery(); // SQL 실행 후 결과를 rs에 반환

            if(rs.next()) { // 로그인은 한번만 돌거라 if 한번만 사용 (list 코드 가져와서 사용하고 있음)
                retMember = new Member();
                retMember.setEmail(rs.getString("email")); //DBMS records == resultSet 필드 이름
                //retMember.setPw(rs.getString("pw"));
                retMember.setName(rs.getString("name"));
                //retMember.setPhone(rs.getString("phone"));
                //retMember.setAddress(rs.getString("address"));

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeResources(conn, stmt, pstmt, rs);
            return retMember;
        }
    }


}
