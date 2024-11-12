CREATE TABLE IF NOT EXISTS "puzzle" (
    "year" SMALLINT NOT NULL,
    "day" TINYINT NOT NULL,
    "input" CLOB NOT NULL,
    PRIMARY KEY("year", "day"),
    CHECK ("year" >= 2015 AND "year" <= 2023),
    CHECK ("day" >= 1 AND "day" <= 25)
);