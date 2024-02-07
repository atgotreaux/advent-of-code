@echo off

setlocal enabledelayedexpansion
setlocal enableextensions

FOR /L %%y IN (2015,1,2023) DO (
    FOR /L %%d IN (1,1,25) DO (
        SET inputFile=%~dp0..\src\main\resources\com\gotreaux\aoc\puzzles\year%%y\day%%d\input.txt
        IF EXIST "!inputFile!" (
            git update-index --assume-unchanged !inputFile!
        )
    )
)