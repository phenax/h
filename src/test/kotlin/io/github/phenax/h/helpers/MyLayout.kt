package io.github.phenax.h.helpers

import io.github.phenax.h.Component
import io.github.phenax.h.Layout
import io.github.phenax.h.node.DOMNode

class MyLayout(
	private val _getRenderNode: (MyLayout) -> (Component) -> DOMNode
): Layout() {
	// Render node
	override fun render(comp: Component): DOMNode {
		return (_getRenderNode(this))(comp)
	}
}
