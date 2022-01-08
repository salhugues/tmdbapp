package com.salhugues.tmdbandroid

import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(
    plugin = ["pretty", "json:target/json/results.json"],
    features = ["src/test/res/feature"]
)
class ExampleUnitTest
