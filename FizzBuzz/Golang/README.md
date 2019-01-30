# Katas in the "Go" Language

Just a template project for "Go". It contains libraries and command-line apps and should be placed inside your ```$GOPATH``` folder (the "Go" workspace).

## How to Run Tests

Execute the following command inside the correspondent kata package:

    go test

## How to Build

    go build
    go install

As a rule of thumb, katas in this project are libraries (suffixed with "_lib"), but they might contain a corresondent command-line app (suffixed with "_app").

For my own future reference, after an app is built, its correspondent binary is located inside ```$GOPATH/bin```.

## Katas

- [FizzBuzz](./src/fizzbuzz_lib)
