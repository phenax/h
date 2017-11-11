package io.github.phenax.h.helpers

import io.github.phenax.h.Component
import io.github.phenax.h.Layout
import io.github.phenax.h.layouts.EmptyLayout
import io.github.phenax.h.node.DOMNode

class MyComponent(
	val _getRenderNode: (d: MyComponent) -> DOMNode,
	override val layout: Layout = EmptyLayout()
): Component() {

	// Render node
	override fun render(): DOMNode {
		return _getRenderNode(this)
	}
}
