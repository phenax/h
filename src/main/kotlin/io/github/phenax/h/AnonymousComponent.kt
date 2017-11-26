package io.github.phenax.h

import io.github.phenax.h.node.DOMNode
import io.github.phenax.h.layouts.EmptyLayout

class AnonymousComponent(
	val _getRenderNode: (d: AnonymousComponent) -> DOMNode,
	override val layout: Layout = EmptyLayout()
): Component() {

	// Render node
	override fun render(): DOMNode {
		return _getRenderNode(this)
	}
}


fun component(cb: (d: AnonymousComponent) -> DOMNode): AnonymousComponent {
	val comp = AnonymousComponent(cb)
	return comp
}

