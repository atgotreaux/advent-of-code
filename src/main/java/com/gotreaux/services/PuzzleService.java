package com.gotreaux.services;

import com.gotreaux.annotations.ShellPuzzle;
import com.gotreaux.input.FileInputProvider;
import com.gotreaux.input.InputProvider;
import com.gotreaux.puzzles.Puzzle;
import com.gotreaux.records.PuzzleResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Service;

@Service
public class PuzzleService {

    public List<PuzzleResult> getPuzzles(List<Integer> years, List<Integer> days) throws Exception {
        ClassPathScanningCandidateComponentProvider provider =
                new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AnnotationTypeFilter(ShellPuzzle.class));
        Set<BeanDefinition> components = provider.findCandidateComponents("com.gotreaux.puzzles");

        List<PuzzleResult> puzzleResults = new ArrayList<>();

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

                puzzleResults.add(
                        new PuzzleResult(
                                shellPuzzle.year(),
                                shellPuzzle.day(),
                                shellPuzzle.title(),
                                puzzle.getPartOne(),
                                puzzle.getPartTwo()));
            }
        }

        return puzzleResults;
    }
}
