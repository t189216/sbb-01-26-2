package com.ll.sbb2401262;

import com.ll.sbb2401262.answer.Answer;
import com.ll.sbb2401262.answer.AnswerRepository;
import com.ll.sbb2401262.question.Question;
import com.ll.sbb2401262.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class Sbb2401262ApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Test
    void test1() {
        Optional<Question> oq = this.questionRepository.findById(1);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        Answer a = new Answer();
        a.setContent("답변 1");
        a.setQuestion(q);
        a.setCreateDate(LocalDateTime.now());
        this.answerRepository.save(a);
    }
}