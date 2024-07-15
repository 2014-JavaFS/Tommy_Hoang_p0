package com.tommy_hoang_p0.Util.Auth;

import javax.security.sasl.AuthenticationException;

import com.tommy_hoang_p0.Members.Member;
import com.tommy_hoang_p0.Members.MemberService;

public class AuthService {
     
     private final MemberService memberService;
     
     public AuthService(MemberService memberService) {
          this.memberService = memberService;
     }

     public Member login(String email, String password) throws AuthenticationException {
          Member member = memberService.findByEmailAndPassword(email, password);
          if(member == null) throw new AuthenticationException("Invalid email or password.");
          return member;
     }
     
}
