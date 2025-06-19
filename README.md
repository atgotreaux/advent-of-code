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

* [**Maven 3.9.10+**](https://maven.apache.org/download.cgi)
* [**Java 24**](https://jdk.java.net/24/)

## Installation

1. Import the project into your IDE of choice ([IntelliJ](https://www.jetbrains.com/help/idea/maven-support.html) | [Eclipse](https://projects.eclipse.org/projects/technology.m2e) | [NetBeans](https://netbeans.apache.org/wiki/main/wiki/MavenBestPractices/)).
2. Confirm run configuration for the `com.gotreaux.aoc.Application` class ([IntelliJ](https://www.jetbrains.com/help/idea/run-debug-configuration.html) | [Eclipse](https://help.eclipse.org/latest/index.jsp?topic=%2Forg.eclipse.cdt.doc.user%2Ftasks%2Fcdt_t_new_run_config.htm) | [NetBeans](https://netbeans.apache.org/tutorial/main/kb/docs/java/quickstart/)).
3. Build and run the project with Maven ([Spring Getting Started Guide](https://spring.io/guides/gs/maven/)).
   1. Use run configuration from Step 2, **OR**
   2. Launch from the command line using the `mvn spring-boot:run` run goal, **OR**
   3. Use `mvn clean package` to build a fat jar and invoke it using `java -jar advent-of-code.jar`.

## Running

### Interactive Mode

Running the project without any commands or options will launch a REPL shell where commands can be executed.

### Non-interactive Mode

Running the project with commands or options will execute the command without launching a REPL shell.

## Usage

### Puzzle Input

Puzzle inputs can be managed as resource files, external files or in a database.

#### Resource Files

Resource files match the structure of source file packages.

Example: the `com/gotreaux/aoc/puzzles/year2015/day1/input.txt` resource file acts as the puzzle input for the `com.gotreaux.aoc.puzzles.year2015.day1.ApartmentFloorPuzzle` class.

[Because the AoC staff does NOT want puzzle input redistributed](https://adventofcode.com/2023/about), these resource files appear as blank placeholders in version control. The intent is for the user to provide their input by copying it from the AoC site into these files.

Run the `bin/ignore-input-resources.cmd` or `bin/ignore-input-resources.sh` script to ignore working directory changes to these files.

#### External Files

External files are any file that can be read from or written to.

These values need to be escaped and quoted to preserve separators.

Example: `"C:\\Users\\atgotreaux\\Downloads\\input.txt"`.

#### Database

Currently, the project will verify database migrations against a configured `h2` database table on launch.

Puzzle input is held in the `input` column of the `puzzle` table.

Example: The puzzle input for ApartmentFloorPuzzle would be represented as below.

| Year | Day | Input   |
|------|-----|---------|
| 2015 | 1   | [input] |

### Seeding Puzzle Input

The `seed-puzzle` command will seed puzzle input for the given year and day to the specified target list.

Synopsis: `seed-puzzle [--help|-h] --year|-Y YEAR --day|-D DAY --session|-S --target|-T [database,resource,{filePath}]`

#### Session

This is a SHA-512 hash (in hex format) representing your session ID with the adventofcode.com website.

The value can be retrieved from the `session` key-value pair of the `Cookie` header.

This is needed to authorize the request to the website.

#### Target

Targets can be a resource file, external file or an `h2` database.

### Solving Puzzles

The `solve-puzzle` command will solve a puzzle for the given year and day with the provided puzzle input.

Synopsis: `solve-puzzle [--help|-h] --year|-Y YEAR --day|-D DAY --input|-I [database,resource,{filePath}]`

#### Input

Inputs can be a resource file, external file or an `h2` database row.