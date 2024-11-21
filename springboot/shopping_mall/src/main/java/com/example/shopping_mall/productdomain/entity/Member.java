package com.example.shopping_mall.productdomain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;
    @Column(length = 20)
    private String memberName;
    @Column(length = 6, unique = true)
    private String userId;
    @Column(length = 8)
    private String password;
    @Column(length = 30)
    private String email;
    @Column(length = 11)
    private String phone;
    @Column(length = 100)
    private String address;
    @Enumerated(EnumType.STRING) // EnumType.STRING
    private MemberStatus memberStatus; // refactoring 필요
    private LocalDate registerDate;
    private LocalDate leaveDate;

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public boolean changePassword(String password, String newPassword) {
        if (password.equals(this.password)) {
            this.password = newPassword;
            return true;
        }
        return false;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void leave(){
        //탈퇴 일자로 처리
        this.leaveDate = LocalDate.now();
        this.memberStatus = MemberStatus.B;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                ", userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", memberStatus=" + memberStatus +
                ", registerDate=" + registerDate +
                ", leaveDate=" + leaveDate +
                '}';
    }
}
