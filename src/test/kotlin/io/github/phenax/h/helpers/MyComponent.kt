package io.github.phenax.h.helpers

import io.github.phenax.h.HComponent
import io.github.phenax.h.HLayout
import io.github.phenax.h.layouts.EmptyLayout
import io.github.phenax.h.node.DOMNode

class MyComponent(
	val _getRenderNode: (d: MyComponent) -> DOMNode,
	override val layout: HLayout = EmptyLayout()
): HComponent() {

	// Render node
	override fun render(): DOMNode {
		return _getRenderNode(this)
	}
}
