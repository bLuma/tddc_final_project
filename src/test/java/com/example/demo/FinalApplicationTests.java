package com.example.demo;

import com.example.demo.entity.Memo;
import com.example.demo.repository.MemosRepository;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class FinalApplicationTests {

    @Autowired
    private MemosRepository memos;

    @Test
    void testThatDbIsWorking() {
        memos.deleteAll();
        
        Memo memo = new Memo("hello world");
        memos.save(memo);
        
        Memo actual = memos.findAll().iterator().next();
        assertEquals("hello world", actual.getMemo());
        System.out.println("From TEST: " + actual.getMemo());
    }

}
