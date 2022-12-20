package repository;

import iducs201912047.javaweb.fundmentals.model.Member;

import java.util.List;

public interface MemberDAO {
    int create(Member m);

    Member read(Member m);

    List<Member> readList();

    int update(Member m);

    int delete(Member m);
    Member login(Member m);
}
