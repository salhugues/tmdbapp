package com.salhugues.tmdbandroid

import io.cucumber.junit.CucumberOptions
import org.robolectric.RobolectricTestRunner

@CucumberOptions(
    features = ["src/test/res/feature"],
    plugin = ["summary", "pretty"],
    publish = true
)
class CucumberTestRunner(testClass: Class<*>?) : RobolectricTestRunner(testClass)
