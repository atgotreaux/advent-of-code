<p align="center">
<a href="https://github.com/atgotreaux/advent-of-code/actions/workflows/tests.yml"><img src="https://github.com/atgotreaux/advent-of-code/workflows/Tests/badge.svg" alt="Tests"></a>
<a href="https://github.com/atgotreaux/advent-of-code/actions/workflows/code-style.yml"><img src="https://github.com/atgotreaux/advent-of-code/workflows/Code%20Style/badge.svg" alt="Code Style"></a>
<a href="https://github.com/atgotreaux/advent-of-code/actions/workflows/code-coverage.yml"><img src="https://github.com/atgotreaux/advent-of-code/workflows/Code%20Coverage/badge.svg" alt="Code Coverage"></a>
<a href="https://github.com/atgotreaux/advent-of-code/actions/workflows/static-analysis.yml"><img src="https://github.com/atgotreaux/advent-of-code/workflows/Static%20Analysis/badge.svg" alt="Static Analysis"></a>
<a href="https://github.com/atgotreaux/advent-of-code/actions/workflows/dependency-vulnerabilities.yml"><img src="https://github.com/atgotreaux/advent-of-code/workflows/Dependency%20Vulnerabilities/badge.svg" alt="Dependency Vulnerabilities"></a>
</p>

My solutions for [**Advent of Code**](https://adventofcode.com/), an Advent calendar of programming puzzles.

This project is powered by [**Spring Boot**](https://spring.io/projects/spring-boot/) and [**Spring Shell**](https://spring.io/projects/spring-shell/).

## Requirements

* [**Maven**](https://maven.apache.org/download.cgi)
* [**Java 22**](https://jdk.java.net/22/)

## Installation

1. Import the project into your IDE of choice ([IntelliJ](https://www.jetbrains.com/help/idea/maven-support.html) | [Eclipse](https://projects.eclipse.org/projects/technology.m2e) | [NetBeans](https://netbeans.apache.org/wiki/main/wiki/MavenBestPractices/)).
2. Create a run configuration for the `com.gotreaux.aoc.Application` class ([IntelliJ](https://www.jetbrains.com/help/idea/run-debug-configuration.html) | [Eclipse](https://help.eclipse.org/latest/index.jsp?topic=%2Forg.eclipse.cdt.doc.user%2Ftasks%2Fcdt_t_new_run_config.htm) | [NetBeans](https://netbeans.apache.org/tutorial/main/kb/docs/java/quickstart/)).
3. Build the project with Maven ([Spring Getting Started Guide](https://spring.io/guides/gs/maven/)). `mvn clean package` will create a fat jar if you prefer an executable file.

## Running

### Interactive Mode

Running the `com.gotreaux.aoc.Application` class or the `advent-of-code` jar without any commands or options will launch a REPL shell where commands can be executed.

### Non-interactive Mode

Running the `com.gotreaux.aoc.Application` class or the `advent-of-code` jar with commands or options will execute the command without launching a REPL shell.

## Usage

### Puzzle Input

Puzzle inputs are managed as resource files whose directory structure matches the structure of source file packages.

For example, the `com/gotreaux/aoc/puzzles/year2015/day1/input.txt` resource file acts as the puzzle input for the `com.gotreaux.aoc.puzzles.year2015.day1.ApartmentFloorPuzzle` class.

[Because the AoC staff does NOT want puzzle input redistributed](https://adventofcode.com/2023/about), these resource files appear as blank placeholders in version control. The intent is for the user to provide their input by copying it from the AoC site into these files.

Run the `bin/ignore-input-resources.cmd` or `bin/ignore-input-resources.sh` script to ignore working directory changes to these files.

### Solving Puzzles

The `solve-puzzle` command will solve puzzles with the provided puzzle input for the specified year(s) and day(s).

Synopsis: `solve-puzzle [--help|-h] --year|-Y YEAR... --day|-D DAY...`