package com.example.shopping_mall.productdomain.service;

import com.example.shopping_mall.productdomain.dto.MemberCreateDto;
import com.example.shopping_mall.productdomain.dto.MemberInquiryDto;
import com.example.shopping_mall.productdomain.entity.Member;
import com.example.shopping_mall.productdomain.entity.MemberStatus;
import com.example.shopping_mall.productdomain.exception.NotUniqueUserException;
import com.example.shopping_mall.productdomain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    MemberInquiryDto getOneMember(String userId) {
        Optional<Member> byUserId = memberRepository.findByUserId(userId);
        if(byUserId.isPresent()) {
            Member member = byUserId.get();
            return MemberInquiryDto.of(member);
        }
        return null;
    }

    List<MemberInquiryDto> getAllMembers(){
        List<Member> all = memberRepository.findAll();
        return all.stream()
                .map(member -> new MemberInquiryDto(
                        member.getMemberId(),
                        member.getMemberName(),
                        member.getUserId()))
                .collect(Collectors.toList());
    }

    MemberInquiryDto addMember(MemberCreateDto memberDto){
        if (checkUniqueUserId(memberDto.getUserId())){
            Member member = new Member(
                    0,
                    memberDto.getMemberName(),
                    memberDto.getUserId(),
                    memberDto.getPassword(),
                    memberDto.getEmail(),
                    memberDto.getPhone(),
                    memberDto.getAddress(),
                    MemberStatus.A,
                    LocalDate.now(),
                    null);
            Member save = memberRepository.save(member);
            return MemberInquiryDto.of(save);
        }
        return null;
    }


    boolean checkUniqueUserId(String userId) {
        Optional<Member> byUserId = memberRepository.findByUserId(userId);
        if (byUserId.isPresent()){
            throw new NotUniqueUserException("동일한 ID가 존재합니다.");
        }
        return true;
    }
}
