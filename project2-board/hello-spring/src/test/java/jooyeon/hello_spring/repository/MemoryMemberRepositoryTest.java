package jooyeon.hello_spring.repository;

import jooyeon.hello_spring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("test1");
        memoryMemberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("test2");
        memoryMemberRepository.save(member2);

        Optional<Member> result = memoryMemberRepository.findByName("test2");
        //Member member = memoryMemberRepository.findByName("test2").get();
        System.out.println(result);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("test1");
        memoryMemberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("test2");
        memoryMemberRepository.save(member2);

        List<Member> arrayList = memoryMemberRepository.findAll();
        System.out.println(arrayList);
    }

    @AfterEach
    public void afterEach(){
        memoryMemberRepository.clearStore();
    }
}
