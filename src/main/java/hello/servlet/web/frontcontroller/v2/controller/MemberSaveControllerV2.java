package hello.servlet.web.frontcontroller.v2.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveControllerV2 implements ControllerV2 {
    private final MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public MyView process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 파라미터 추출
        final String userName = req.getParameter("username");
        final Integer age = Integer.parseInt(req.getParameter("age"));

        // 비즈니스 로직
        final Member member = new Member(userName, age);
        memberRepository.save(member);

        // model 에 데이터 담기
        req.setAttribute("member", member);

        return new MyView("/WEB-INF/view/save-result.jsp");
    }
}
