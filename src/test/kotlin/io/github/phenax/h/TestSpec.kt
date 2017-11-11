package io.github.phenax.h

import io.kotlintest.matchers.*
import io.kotlintest.properties.*
import io.kotlintest.specs.ShouldSpec
import io.kotlintest.*


class TestSpec : ShouldSpec() {

	/**
	 * Test case interceptor (Before test and after test)
	 */
	private val testCaseInterceptor: (TestCaseContext, () -> Unit) -> Unit = { _, test ->
		test()
	}

	// Test config
	override val defaultTestCaseConfig: TestCaseConfig =
		TestCaseConfig(
			interceptors = listOf(testCaseInterceptor)
		)

	override val oneInstancePerTest = true

	init {
		"String.length" {
			should("return the length of the string") {
				"sammy".length shouldBe 5
				"".length shouldBe 0
			}

			/*should("eat my dick") {
				forAll(200) { a: String ->
					true
				}
			}*/
		}
	}
}