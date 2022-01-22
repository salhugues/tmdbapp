package com.salhugues.tmdbandroid.steps

import io.cucumber.java8.Fr
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
class HomeFrSteps : Fr {
    init {
        Before { _ -> tmpValue = 42 }

        Etantdonnéque("J'ouvre l'application {string}") { appName: String ->
            Assert.assertEquals("TmdbAndroid", appName)
        }
        Lorsque("Je clique sur le bouton {string}") { button: String ->
            Assert.assertEquals("GotoSearch", button)
        }
        Alors("Search Fragment s'ouvre après {int} secondes") { nb: Int ->
            Assert.assertEquals(tmpValue, nb)
        }
    }

    private var tmpValue: Int? = null
}
