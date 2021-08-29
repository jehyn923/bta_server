package net.frankie.api.rabbitmq.service;

import net.frankie.api.rabbitmq.domain.Quiz;
import reactor.core.publisher.Mono;

public interface QuizService {
    Mono<Quiz> createQuiz();
}
