package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1. request Param 방식 데이터 수신 기능 http://localhost:8080/request_param?username=hello&age=20 2. url-encoded 방식 데이터 수신 기능
 * <p>
 * 3.
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("전체 파라미터 조회");
        request.getParameterNames().asIterator()
                // getParamerterNames = userName, age 추출
                .forEachRemaining(param -> System.out.println(param + " = " + request.getParameter(param)));

        System.out.println("단일 파라미터 조회");

        final String userName = request.getParameter("userName");
        final String age = request.getParameter("age");
        System.out.println("userName = " + userName);
        System.out.println("age = " + age);


        /*
        클라이언트에서는, 두가지 방식
        1. URL로 보내는 방식,
        2. 바디에 쿼리파라미터를 보내는 방식

        두가지라도, 서버에선 HttpServletRequest 를 통해 .getParameter()로 가져온다.
        하지만, 서블릿은 (2) 방식에서 Content-Type이 x-www-url-encoded 가 적용되지 않았다면, 위 처럼 사용불가
        -> PostMan 으로 확인해보기ㄷ

         */
    }
}
