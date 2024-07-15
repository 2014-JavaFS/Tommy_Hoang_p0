package com.tommy_hoang_p0.Members;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tommy_hoang_p0.Util.Interfaces.Serviceable;

public class MemberService implements Serviceable<Member> {
     private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
     private final List<Member> memberList = new ArrayList<>();
     private final MemberRepository memberRepository;

     public MemberService(MemberRepository memberRepository) {
          this.memberRepository = memberRepository;
     }

     @Override
     public List<Member> findAll(){
          return memberRepository.findAll();
     }
     @Override
     public Member findById(int memberId) {
          logger.info("Member ID was sent to service as {}", memberId);

          return memberRepository.findById(memberId);
     }
     @Override
     public Member create(Member newMember) {
          memberList.add(newMember);
          return newMember;
     }

     /**
      * Credential validation for member login.
      * 
      * @param email
      * @param password
      * @return
      */
     public Member findByEmailAndPassword(String email, String password) {
          return memberRepository.findByEmailAndPassword(email, password);
     }

     public void update(Member updatedMember) {
          for(int i = 0; i < memberList.size(); i++) {
               if(memberList.get(i).getMemberId() == updatedMember.getMemberId()) {
                    memberList.set(i, updatedMember);
                    return;
               }
          }
     }

}
