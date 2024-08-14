package com.gotreaux.aoc.puzzles.year2015.day16;

record MFCSAM(
        int children,
        int cats,
        int samoyeds,
        int pomeranians,
        int akitas,
        int vizslas,
        int goldfish,
        int trees,
        int cars,
        int perfumes) {
    boolean matches(Aunt aunt) {
        return aunt.matches(Attribute.CHILDREN, children, Integer::equals)
                && aunt.matches(Attribute.CATS, cats, Integer::equals)
                && aunt.matches(Attribute.SAMOYEDS, samoyeds, Integer::equals)
                && aunt.matches(Attribute.POMERANIANS, pomeranians, Integer::equals)
                && aunt.matches(Attribute.AKITAS, akitas, Integer::equals)
                && aunt.matches(Attribute.VIZSLAS, vizslas, Integer::equals)
                && aunt.matches(Attribute.GOLDFISH, goldfish, Integer::equals)
                && aunt.matches(Attribute.TREES, trees, Integer::equals)
                && aunt.matches(Attribute.CARS, cars, Integer::equals)
                && aunt.matches(Attribute.PERFUMES, perfumes, Integer::equals);
    }

    boolean matchesRange(Aunt aunt) {
        return aunt.matches(Attribute.CHILDREN, children, Integer::equals)
                && aunt.matches(Attribute.CATS, cats, (x, y) -> x > y)
                && aunt.matches(Attribute.SAMOYEDS, samoyeds, Integer::equals)
                && aunt.matches(Attribute.POMERANIANS, pomeranians, (x, y) -> x < y)
                && aunt.matches(Attribute.AKITAS, akitas, Integer::equals)
                && aunt.matches(Attribute.VIZSLAS, vizslas, Integer::equals)
                && aunt.matches(Attribute.GOLDFISH, goldfish, (x, y) -> x < y)
                && aunt.matches(Attribute.TREES, trees, (x, y) -> x > y)
                && aunt.matches(Attribute.CARS, cars, Integer::equals)
                && aunt.matches(Attribute.PERFUMES, perfumes, Integer::equals);
    }
}
