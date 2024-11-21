package com.example.shopping_mall.productdomain.service;

import com.example.shopping_mall.productdomain.dto.MemberCreateDto;
import com.example.shopping_mall.productdomain.dto.MemberInquiryDto;
import com.example.shopping_mall.productdomain.entity.Member;
import com.example.shopping_mall.productdomain.entity.MemberStatus;
import com.example.shopping_mall.productdomain.exception.NotUniqueUserException;
import com.example.shopping_mall.productdomain.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 전체회원정보조회() {
        // given
        Member member = new Member(0, "test1", "aaa","1111","a@naver.com","1111","오리역", MemberStatus.A, LocalDate.now(),null);
        memberRepository.save(member);
        // when
        List<MemberInquiryDto> allMembers = memberService.getAllMembers();
        // then
        Assertions.assertThat(allMembers.size()).isEqualTo(1);
    }

    @Test
    public void 회원등록테스트(){
        //given
        MemberCreateDto memberCreateDto = new MemberCreateDto(
                "test1","aaa","1111","a","1","a"
        );
        memberService.addMember(memberCreateDto);
        MemberCreateDto memberCreateDto1 = new MemberCreateDto(
                "test1","aaa","1111","a","1","a"
        );
        //when
        Assertions.assertThat(memberService.getAllMembers().size()).isEqualTo(1);

        //then
        assertThrows(NotUniqueUserException.class, () -> {
            memberService.addMember(memberCreateDto1);
        });
    }
}