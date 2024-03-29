package com.gotreaux.aoc.services;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.dto.PuzzleDto;
import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

public final class PuzzleService {

    private PuzzleService() {}

    public static List<PuzzleDto> getPuzzles(Collection<Integer> years, Collection<Integer> days)
            throws Exception {
        ClassPathScanningCandidateComponentProvider provider =
                new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AnnotationTypeFilter(ShellPuzzle.class));
        Set<BeanDefinition> components =
                provider.findCandidateComponents("com.gotreaux.aoc.puzzles");

        List<PuzzleDto> puzzles = new ArrayList<>();

        for (BeanDefinition component : components) {
            var puzzleClass = Class.forName(component.getBeanClassName());
            ShellPuzzle shellPuzzle = puzzleClass.getAnnotation(ShellPuzzle.class);
            if ((years.isEmpty() || years.contains(shellPuzzle.year()))
                    && (days.isEmpty() || days.contains(shellPuzzle.day()))) {
                FileInputProvider inputProvider = new FileInputProvider(puzzleClass);
                Puzzle puzzle =
                        (Puzzle)
                                puzzleClass
                                        .getDeclaredConstructor(InputProvider.class)
                                        .newInstance(inputProvider);

                puzzles.add(new PuzzleDto(shellPuzzle, puzzle));
            }
        }

        return puzzles;
    }
}
