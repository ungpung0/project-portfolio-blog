package com.ungpung0.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "MEMBER")
public class MemberEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long memberId;

    @Column(name = "MEMBER_NAME")
    private String memberName;

    @Column(name = "MEMBER_PASSWORD")
    private String memberPassword;

    @Column(name = "MEMBER_BIRTH_DATE")
    private LocalDateTime memberBirthDate;

    @Column(name = "MEMBER_PHONE_NUMBER")
    private String memberPhoneNumber;
}