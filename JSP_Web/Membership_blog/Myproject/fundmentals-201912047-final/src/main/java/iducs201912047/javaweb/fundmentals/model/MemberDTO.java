package iducs201912047.javaweb.fundmentals.model;

import java.util.Objects;

public class MemberDTO {
    // DTO's fields
    private String name;
    private String email;

    private String work;

    // gertter setter method  : boiler plate code(상용, 관용 코드) generation
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    @Override
    public boolean equals(Object o) { // 두객치 비교하는데 이름과 이메일이 같으면 같은 객체로 보겠다라는 것임
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberDTO memberDTO = (MemberDTO) o;
        return Objects.equals(name, memberDTO.name) && email.equals(memberDTO.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    // 객체 값을 문자열로 변환했을때 값이 무엇인지 확인 하고 싶을때 사용
    public String toString() { // 객체를 문자열화 할 때 사용
        return "MemberDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", work='" + work + '\'' +
                '}';
    }
}
