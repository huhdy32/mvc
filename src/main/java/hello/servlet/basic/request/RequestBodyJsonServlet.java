package hello.servlet.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.springframework.util.StreamUtils;

@WebServlet("/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String body = StreamUtils.copyToString(req.getInputStream(), StandardCharsets.UTF_8);
        System.out.println("body = " + body);

        ObjectMapper objectMapper = new ObjectMapper();
        final HelloData helloData = objectMapper.readValue(body, HelloData.class);

        System.out.println("helloData.getUserName() = " + helloData.getUserName());
        System.out.println("helloData.getAge() = " + helloData.getAge());

        // json 으로 보냈을 땐, 특수 문자가 포함되지 않는다.
        // http url Encoded, 으로 받았을 땐, 특수 문자 포함
    }
}
