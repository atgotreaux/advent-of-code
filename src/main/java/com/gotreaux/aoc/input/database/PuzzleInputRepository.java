package com.gotreaux.aoc.input.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuzzleInputRepository extends JpaRepository<PuzzleInput, PuzzleInputKey> {}
