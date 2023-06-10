# sigma-builders [![Latest version](https://index.scala-lang.org/guapswap/sigma-builders/sigma-builders/latest.svg)](https://index.scala-lang.org/guapswap/sigma-builders/sigma-builders)
Easy to use library for creating protocol abstractions interacting with Ergo blockchain.

## Motivation
When developing protocols on Ergo that involve multiple contracts and transactions, there is no standard way of structuring your code base to make using your protocol abstractions easy. However, there are common patterns since most of the time projects do the same thing: build and compile ErgoScript contracts, build custom boxes, build custom transactions.

This library defines common abstractions for creating the latter in a structured way, making use of the built-in functions from the Ergo Appkit library.


## Packages

The library currently defines the following packages to help you design your protocol, with the intent of adding more functionality in the future as needed:
```
- builders
   - box_builders
   - contract_builders
   - tx_builders
- encoders
   - register_encoders
   - minting_encoders
```

When creating your project's structure, it is useful to duplicate the builders hierarchy, since those will be three primary constructs used throughout your protocol.