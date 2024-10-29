package com.gotreaux.aoc.input.database;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuzzleInputRepository extends JpaRepository<PuzzleInput, Integer> {

    Optional<PuzzleInput> findById(PuzzleInputKey id);
}
