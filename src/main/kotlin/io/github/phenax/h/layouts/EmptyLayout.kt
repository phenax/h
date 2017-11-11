package io.github.phenax.h.layouts

import io.github.phenax.h.HLayout
import io.github.phenax.h.HComponent
import io.github.phenax.h.node.DOMNode

class EmptyLayout: HLayout() {

	override fun render(component: HComponent): DOMNode {
		return h(component);
	}
}
