package io.github.phenax.h

import io.kotlintest.specs.ShouldSpec
import io.kotlintest.*


open class MySpec(
	private val testCaseInterceptor: (TestCaseContext, () -> Unit) -> Unit = { _, test -> test() }
): ShouldSpec() {

	// Test config
	override val defaultTestCaseConfig: TestCaseConfig =
		TestCaseConfig(
			interceptors = listOf(testCaseInterceptor)
		)

	override val oneInstancePerTest = true
}
