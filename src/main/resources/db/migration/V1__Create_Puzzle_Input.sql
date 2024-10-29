CREATE TABLE IF NOT EXISTS `puzzle_input` (
    `puzzle_year` SMALLINT,
    `puzzle_day` TINYINT,
    `input_data` CLOB,
    PRIMARY KEY(`puzzle_year`, `puzzle_day`)
);