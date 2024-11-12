package com.gotreaux.aoc.persistence.repository;

import com.gotreaux.aoc.persistence.entity.PuzzleEntity;
import com.gotreaux.aoc.persistence.entity.PuzzleEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuzzleRepository extends JpaRepository<PuzzleEntity, PuzzleEntityId> {}
