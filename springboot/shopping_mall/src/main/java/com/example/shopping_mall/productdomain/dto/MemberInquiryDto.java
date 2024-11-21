package com.example.shopping_mall.productdomain.dto;

import com.example.shopping_mall.productdomain.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberInquiryDto {
    private int memberId;
    private String memberName;
    private String userId;

    public static MemberInquiryDto of(Member member) {
        // Member 객체의 값을 MemberInquiryDto로 변환
        return new MemberInquiryDto(
                member.getMemberId(),
                member.getMemberName(),
                member.getUserId()
        );
    }
}
