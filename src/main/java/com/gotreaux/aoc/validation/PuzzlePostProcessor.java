package com.gotreaux.aoc.validation;

import com.gotreaux.aoc.puzzles.Puzzle;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import java.util.Set;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class PuzzlePostProcessor implements BeanPostProcessor {

    private final Validator validator;

    public PuzzlePostProcessor(Validator validator) {
        this.validator = validator;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        if (bean instanceof Puzzle) {
            Set<ConstraintViolation<Object>> violations = validator.validate(bean);
            if (!violations.isEmpty()) {
                throw new IllegalStateException("Puzzle bean validation failed: " + violations);
            }
        }
        return bean;
    }
}
