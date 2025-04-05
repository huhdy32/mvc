package hello.servlet.domain.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Member {
    private Long id;
    private String username;
    private int age;

    public Member(String userName, int age) {
        this.username = userName;
        this.age = age;
    }
}
