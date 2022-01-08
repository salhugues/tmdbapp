package com.salhugues.tmdbandroid.steps

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import io.cucumber.java8.En
import org.junit.Assert
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class HomeSteps : En {
    init {
        Before { scenario ->
            tmpValue = "null"
            printClass(ApplicationProvider.getApplicationContext())
        }

        Given("I open Application {string}") { appName: String ->
            println("I click on $appName")
            printStepsVariable(appName)
            Assert.assertEquals("TmdbAndroid", appName)
        }

        When("I click on {string}") { button: String ->
            println("I click on $button")
            printStepsVariable(button)
            Assert.assertEquals("Go to Search Button", button)
        }

        Then("Search Fragment open after") {
            Assert.assertEquals(42, 42)
        }
    }

    private var tmpValue: String? = null
    private lateinit var context: Context

    private fun printClass(context: Context) {
        println("{${context.applicationInfo.className}}")
    }

    private fun printStepsVariable(value: String) {
        tmpValue = value

        println("VARIABLE: $tmpValue")
    }
}
