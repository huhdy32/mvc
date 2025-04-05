package hello.servlet.web.frontcontroller.v1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 서블릿과 비슷한 모양의 컨트롤러 인터페이스를 도입한다.
 * 각 컨트롤러들은 이 인터페이스를 구현한다.
 *
 * Front Controller 는 이 인터페이스를 호출함으로써, 세부 구현과 상관없이 로직을 처리할 수 있다.
 */
public interface ControllerV1 {

    void processs(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException;
}
