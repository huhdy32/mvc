package hello.servlet.web.frontcontroller.v1.controller;

import hello.servlet.web.frontcontroller.v1.ControllerV1;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV1 implements ControllerV1{
    @Override
    public void processs(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String viewPath = "/WEB-INF/view/new-form.jsp";
        // WEB-INF 하위 디렉토리의 파일들은 웹 서버의 정적 파일 호스팅을 지원하지 않는다.
        // 오로지 서버 내부의 호출로만 렌더링될 수 있다.


        /*
         컨트롤러에서 view 로 이동시켜주는 놈

         리다이렉트가 아닌, 서버 내에서 다른 서블릿으로 옮겨주는 메소드이다.  ( 서버 내 호출 )
         이를 통해, 현재 서블릿을 Controller로써 사용하고, 호출되는 서블릿(JSP)를 View 로써 사용한다.
         */
        final RequestDispatcher requestDispatcher = req.getRequestDispatcher(viewPath);
        requestDispatcher.forward(req, resp);
    }
}
