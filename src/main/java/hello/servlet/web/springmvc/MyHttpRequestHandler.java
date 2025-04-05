package hello.servlet.web.springmvc;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

/* 스프링 MVC는 핸들러 매핑 시, 처리 순서가 있다.
1. RequestMappingHanderlMapping
2. BeanNameURLHandlerMapping

적절한 핸들러 ( 컨트롤러 ) 를 찾으면,
핸들러 어댑터를 조회한다.

1. RequestMappingHandlerAdapter
2. HttpRequestHandlerAdapter        <- HttpRequestHandler 인터페이스를 구현한 빈 어댑터
3. SimpleControllerHandlerAdapter
*/
@Component("/springmvc/request-handler")
public class MyHttpRequestHandler implements HttpRequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("MyHttpRequestHandler.handleRequest");
    }
}
