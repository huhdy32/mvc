package hello.servlet.web.frontcontroller.v4.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.v4.ControllerV4;
import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, Object> params, Map<String, Object> model) {
        final String memberName = (String) params.get("username");
        final int age = Integer.parseInt(params.get("age").toString());
        final Member member = new Member(memberName, age);
        memberRepository.save(member);
        model.put("member", member);

        return "save-result";
    }
}
