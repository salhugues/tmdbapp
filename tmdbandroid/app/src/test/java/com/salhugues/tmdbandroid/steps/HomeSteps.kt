package com.salhugues.tmdbandroid.steps

import io.cucumber.java8.En
import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.Assert
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(
    features = ["src/test/res/feature"],
    plugin = ["summary", "pretty"],
    publish = true
)
class HomeSteps : En {
    init {
        Before { _ ->
            tmpValue = 42
            // when(ctx.getMainLooper()).thenReturn(mLooper)
            // printClass(ApplicationProvider.getApplicationContext())
        }

        Given("I open Application {string}") { appName: String ->
            Assert.assertEquals("TmdbAndroid", appName)
        }

        When("I click on {string}") { button: String ->
            Assert.assertEquals("Go to Search Button", button)
        }

        Then("Search Fragment open after {int} seconds") { nb: Int ->
            Assert.assertEquals(tmpValue, nb)
        }
    }

    private var tmpValue: Int? = null
    // private lateinit var context: Context

    /*private fun printClass(context: Context) {
        println("{${context.applicationInfo.className}}")
    }*/
}
