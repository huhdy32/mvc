package hello.servlet.web.springmvc;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


/* 스프링 MVC는 핸들러 매핑 시, 처리 순서가 있다.
1. RequestMappingHanderlMapping
2. BeanNameURLHandlerMapping

적절한 핸들러 ( 컨트롤러 ) 를 찾으면,
핸들러 어댑터를 조회한다.

1. RequestMappingHandlerAdapter
2. HttpRequestHandlerAdapter        : Http
3. SimpleControllerHandlerAdapter   <- Controller 인터페이스를 구현한 빈
*/
@Component("/springmvc/old-controller")
public class OldController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");
        return new ModelAndView("new-form");
    }
}
