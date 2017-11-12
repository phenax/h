package kotlinexample

import io.github.phenax.h.Component
import io.github.phenax.h.Layout
import io.github.phenax.h.node.DOMNode
import io.github.phenax.h.layouts.EmptyLayout

class MyComponent: Component() {

	override val layout = EmptyLayout()

	override fun render(): DOMNode {
		return p(null, "This is text boeey")
	}
}
