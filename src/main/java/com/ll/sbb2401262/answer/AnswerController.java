package com.ll.sbb2401262.answer;

import com.ll.sbb2401262.question.Question;
import com.ll.sbb2401262.question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/answer")
public class AnswerController {

    private final QuestionService questionService ;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id,
                               @RequestParam(value = "content") String content) {
        Question question = this.questionService.getQuestion(id);
        this.answerService.create(question, content);

        return String.format("redirect:/question/detail/%s", id);
    }
}