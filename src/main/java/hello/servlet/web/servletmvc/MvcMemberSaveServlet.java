package hello.servlet.web.servletmvc;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet-mvc/members/save")
public class MvcMemberSaveServlet extends HttpServlet {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 파라미터 추출
        final String userName = req.getParameter("username");
        final Integer age = Integer.parseInt(req.getParameter("age"));

        // 비즈니스 로직
        final Member member = new Member(userName, age);
        memberRepository.save(member);

        // model 에 데이터 담기
        req.setAttribute("member", member);

        // 뷰 전달
        final String viewPath = "/WEB-INF/view/save-result.jsp";
        req.getRequestDispatcher(viewPath).forward(req, resp);
    }
}
