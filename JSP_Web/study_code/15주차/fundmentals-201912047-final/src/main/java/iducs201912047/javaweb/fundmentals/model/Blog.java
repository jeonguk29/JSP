package iducs201912047.javaweb.fundmentals.model;

// 관용적 프로그램 코드를 한번에 처리  lombok API는 즉 보일러 코드를 처리해주는 놈임
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString

public class Blog {
    private long id; // long : 기본자료형 64bit 정수형, Long : long 자료를 효과적으로 다루기 위한 Wrapper Class,
    private String title;
    private String content;
    private String author;
    private String email;
    private String regdate;
}
