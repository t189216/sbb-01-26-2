package com.ll.sbb2401262;

import com.ll.sbb2401262.domain.question.QuestionService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Sbb2401262ApplicationTests {

    @Autowired
    private QuestionService questionService;

    @Test
    @DisplayName("test1")
    void test1() {
        for (int i = 1; i <= 300; i++) {
            String subject = String.format("테스트 데이터입니다:[%03d]", i);
            String content = "내용 X";
            this.questionService.create(subject, content, null);
        }
    }
}