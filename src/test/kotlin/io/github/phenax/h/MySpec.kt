package io.github.phenax.h

import io.github.phenax.h.helpers.MyLayout
import io.github.phenax.h.node.DOMNode
import io.kotlintest.TestCaseConfig
import io.kotlintest.TestCaseContext
import io.kotlintest.specs.ShouldSpec


abstract class MySpec(
	private val testCaseInterceptor: (TestCaseContext, () -> Unit) -> Unit = { _, test -> test() }
): ShouldSpec() {

	// Test config
	override val defaultTestCaseConfig: TestCaseConfig =
		TestCaseConfig(
			interceptors = listOf(testCaseInterceptor)
		)

	override val oneInstancePerTest = true

    protected fun createLayout(_getRenderNode: (MyLayout) -> (Component) -> DOMNode): MyLayout {
		return MyLayout(_getRenderNode)
	}
}
