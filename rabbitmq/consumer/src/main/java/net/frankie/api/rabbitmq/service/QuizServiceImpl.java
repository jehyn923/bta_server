package net.frankie.api.rabbitmq.service;

import lombok.RequiredArgsConstructor;
import net.frankie.api.rabbitmq.domain.Quiz;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service @RequiredArgsConstructor
public class QuizServiceImpl implements QuizService{
    private final GeneratorService service;

    @Override
    public Mono<Quiz> createQuiz() {
        int factorA = service.randomFactory();
        int factorB = service.randomFactory();
        Quiz quiz = new Quiz(factorA, factorB);
        return Mono.just(quiz);
    }
}
