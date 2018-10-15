# CPSC 411- Mobile Device Application Development
# Fall 2018 - Mini-App 2, due October 18
## Introduction
Convert your code for [Mini-App 1](https://github.com/tngo0508/mini-app01) to Kotlin.
Begin by using Code > Convert Java File to Kotlin File on each Java class in your project.
## Kotlin Fixes
 + Convert any var declarations to val
 + Eliminate nullable types (e.g. String?)
 + When possible, take advantage of type inference by eliminating type declarations
 + A larger label below the two fields should be used to show the computed result.
## Kotlin Android Features
 + Import your layout from kotlinx.android.synthetic… and remove calls to findViewById()
 + Use an [object](https://kotlinlang.org/docs/reference/object-declarations.html) to implement the TextWatcher interface
 + Move some of the code from your activity into an appropriate TextView or EditText extension function
