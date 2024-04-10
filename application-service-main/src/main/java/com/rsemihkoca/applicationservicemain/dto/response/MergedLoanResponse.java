package com.rsemihkoca.applicationservicemain.dto.response;

import lombok.*;

import java.io.Serializable;


@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MergedLoanResponse implements Serializable {


    private String bankName;

    private String type;

    private Double amount;

    private Double interestRate;

    private Integer duration;
}
