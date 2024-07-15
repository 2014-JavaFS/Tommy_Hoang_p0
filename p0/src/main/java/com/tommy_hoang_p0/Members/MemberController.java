package com.tommy_hoang_p0.Members;

public class MemberController {
     private final MemberService memberService;

     public MemberController(MemberService memberService) {
          this.memberService = memberService;
     }

     public Member findById(int memberId) {
          return memberService.findById(memberId);
     }
}
