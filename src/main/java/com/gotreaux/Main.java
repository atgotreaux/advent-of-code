package com.gotreaux;

import com.gotreaux.annotation.Day;
import com.gotreaux.annotation.Year;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AnnotationTypeFilter(Year.class));
        provider.addIncludeFilter(new AnnotationTypeFilter(Day.class));
        Set<BeanDefinition> components = provider.findCandidateComponents("com.gotreaux");

        for (BeanDefinition component : components) {
            var puzzleClass = Class.forName(component.getBeanClassName());
            if (puzzleClass.getSuperclass().equals(Puzzle.class)) {
                Year year = puzzleClass.getAnnotation(Year.class);
                Day day = puzzleClass.getAnnotation(Day.class);
                if (year.year() == 2015 && day.day() == 1) {
                    Puzzle puzzle = (Puzzle) puzzleClass.getDeclaredConstructor().newInstance();

                    puzzle.solve();
                }
            }
        }
    }
}
