package hello.servlet.domain.member;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void test() {
        // given
        Member member = new Member("tes", 12);

        // when
        Member savedMember = memberRepository.save(member);

        // then
        Member findMember = memberRepository.findById(savedMember.getId());
        Assertions.assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll() {
        Member member1 = new Member("tes1", 12);
        Member member2 = new Member("tes2", 12);
        Member member3 = new Member("tes3", 12);

        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);

        Assertions.assertThat(memberRepository.findAll().size()).isEqualTo(3);
        Assertions.assertThat(memberRepository.findAll()).contains(member1, member2, member3);
    }
}