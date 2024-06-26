package com.rsemihkoca.applicationservicemain.model;


import com.rsemihkoca.applicationservicemain.dto.response.MergedLoanResponse;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Data
public class ApplicationPipeline {
    private String currentUserEmail;
    private MergedLoanResponse currentLoanRequest;

}
