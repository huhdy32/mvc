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
        내부 파라미터 이름이 중복되는 경우,
        http://localhost:8080/request-param?userName=hello&age=20&userName=john

         */


    }
}
