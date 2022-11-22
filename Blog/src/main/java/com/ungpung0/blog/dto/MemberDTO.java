package com.ungpung0.blog.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberDTO {
    private Long memberId;

    private String memberName;

    private String memberPassword;

    private LocalDateTime memberBirthDate;

    private String memberPhoneNumber;

}
