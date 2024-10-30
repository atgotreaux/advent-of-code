CREATE TABLE IF NOT EXISTS `puzzle_input` (
    `puzzle_year` SMALLINT NOT NULL,
    `puzzle_day` TINYINT NOT NULL,
    `input_data` CLOB NOT NULL,
    PRIMARY KEY(`puzzle_year`, `puzzle_day`),
    CHECK (`puzzle_year` >= 2015 AND `puzzle_year` <= 2023),
    CHECK (`puzzle_day` >= 1 AND `puzzle_day` <= 25)
);