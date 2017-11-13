package io.github.phenax.h.helpers

import io.github.phenax.h.Component
import io.github.phenax.h.Layout
import io.github.phenax.h.node.DOMNode

class MyLayout(
	val _getRenderNode: (d: MyLayout, c: Component) -> DOMNode
): Layout() {
	// Render node
	override fun render(c: Component): DOMNode {
		return _getRenderNode(this, c)
	}
}
