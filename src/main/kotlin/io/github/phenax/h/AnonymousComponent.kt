package io.github.phenax.h

import io.github.phenax.h.layouts.EmptyLayout
import io.github.phenax.h.node.DOMNode

// Anonymous component
class AnonymousComponent(
        val _getRenderNode: (d: AnonymousComponent) -> DOMNode,
        override val layout: Layout = EmptyLayout()
): Component() {

	// Render node
	override fun render(): DOMNode {
		return _getRenderNode(this)
	}
}

// Empty layout component
fun component(cb: AnonymousComponent.() -> DOMNode) = AnonymousComponent(cb)

// Custom layout component
fun component(layout: Layout, cb: AnonymousComponent.() -> DOMNode) = AnonymousComponent(cb, layout)
