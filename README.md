# Cucumber-JVM Dependency Injection with Spring using selenium


## Intro

The purpose of this repo is to demonstrate how a cucumber scenario can be written in such a way as to be implementation
agnostic, achieving this using dependency injection. Depending on one system property the tests will either run the
mobile implementation of the application under test, or the desktop implementation.

## The Scenario

It's pretty simple: webdriver loads [Bing](https://www.bing.com), searches for "cucumber", and verifies that the
first hit in the search results contains the word "Cucumber".

## The dependency injection bit

The project is set up such that Page Objects are implementation specific, i.e. there's a `MobileBingHomePage` and a
`DesktopBingHomePage`, but both implement a single `BingHomePage` interface. The decision between which implementation
is used is determined at runtime through the use of spring [Profiles](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#beans-definition-profiles-java).
If the `-Dspring.profiles.active` command line argument is set to `desktop` then the step definition class will be injected
with `DesktopBingHomePage`, or, if it's set to `mobile` then `MobileBingHomePage` will be injected.

The same happens with the Page Objects themselves. They all need a WebDriver instance so one is injected in. Depending,
again, on which spring profile is set, the Page Object will be injected with a WebDriver instance that is either set up
with "desktop" dimensions, or with "mobile" dimensions and appropriate user-agent.

That's about the sum of it.

Note, this is just one way to arrange things. This repo is to demonstrate how all the pieces work together, not their
optimal arrangement - that'll be determined by your own unique requirements.

## Usage

To run the feature with a "desktop browser":

```sh
mvn clean verify -Dspring.profiles.active=desktop
```

To run the feature with a "mobile browser":

```sh
mvn clean verify -Dspring.profiles.active=mobile
```

## Tested with...

On 9th Jan 2022, with the following setup, It Worked On My Machine:

* windows 10
* Maven 3.6.0
* jdk1.8
* Chrome 97
* ChromeDriver ChromeDriver 97.0.4692.71

