#! /bin/bash

scriptDir=$(dirname "$(readlink -f "$0")")

for year in {2015..2023}
do
  for day in {1..25}
  do
    inputFile="$scriptDir/../src/main/resources/com/gotreaux/aoc/puzzles/year$year/day$day/input.txt"
    if test -f "$inputFile"; then
      git update-index --assume-unchanged "$inputFile"
    fi
  done
done

exit 0