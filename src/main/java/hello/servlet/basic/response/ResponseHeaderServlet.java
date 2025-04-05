package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);

        resp.setHeader("Content-Type", "text/plain");
        resp.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("MyHeader", "Hello Header");
        resp.setHeader("Keep-Alive", "-1");

        // 편의 메소드
        // 위와 같이 직점 작성할 필요 없이
        // resp.setContentLength();
        // resp. .... 등등 많앙
    }
}
