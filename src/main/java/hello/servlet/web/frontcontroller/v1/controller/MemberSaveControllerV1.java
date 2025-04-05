package hello.servlet.web.frontcontroller.v1.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.v1.ControllerV1;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveControllerV1 implements ControllerV1 {
    private final MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public void processs(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
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
