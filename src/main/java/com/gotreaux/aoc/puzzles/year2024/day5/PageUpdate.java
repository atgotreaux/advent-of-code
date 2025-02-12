package com.gotreaux.aoc.puzzles.year2024.day5;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PageUpdate {

    private final List<Integer> pages;
    private final Map<Integer, Integer> pageWeights;

    static PageUpdate of(String line) {
        Collection<Integer> pages = Arrays.stream(line.split(",")).map(Integer::parseInt).toList();

        return new PageUpdate(pages);
    }

    PageUpdate(Collection<Integer> pages) {
        this.pages = pages.stream().toList();
        pageWeights = new HashMap<>(pages.size());
    }

    Collection<Integer> getPages() {
        return pages;
    }

    boolean isCorrectOrder(Collection<PageOrderingRule> rules) {
        return pages.equals(getOrderedPages(rules));
    }

    int getMiddlePage(Collection<PageOrderingRule> rules) {
        List<Integer> orderedPages = getOrderedPages(rules);

        return orderedPages.get(orderedPages.size() / 2);
    }

    private List<Integer> getOrderedPages(Collection<PageOrderingRule> rules) {
        initializePageWeights(rules);

        return pageWeights.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .toList();
    }

    private void initializePageWeights(Collection<PageOrderingRule> rules) {
        if (pageWeights.isEmpty()) {
            Collection<PageOrderingRule> filteredRules = filterRules(rules);
            for (PageOrderingRule rule : filteredRules) {
                pageWeights.merge(rule.before(), -1, Integer::sum);
                pageWeights.merge(rule.after(), 1, Integer::sum);
            }
        }
    }

    private Collection<PageOrderingRule> filterRules(Collection<PageOrderingRule> rules) {
        return rules.stream()
                .filter(rule -> pages.contains(rule.before()) && pages.contains(rule.after()))
                .toList();
    }
}
