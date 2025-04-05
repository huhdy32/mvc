package hello.servlet.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



// setter 없이도 가능,
// 다만 항상 NoArgsConstructor는 존재해야함

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HelloData {
    private String userName;
    private int age;
}
