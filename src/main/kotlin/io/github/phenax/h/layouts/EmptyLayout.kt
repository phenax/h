package io.github.phenax.h.layouts

import io.github.phenax.h.Layout
import io.github.phenax.h.Component
import io.github.phenax.h.node.DOMNode

class EmptyLayout: Layout() {

	override fun render(comp: Component): DOMNode {
		return h(comp);
	}
}
