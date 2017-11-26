package io.github.phenax.h

import io.github.phenax.h.node.DOMNode

/**
 * Component
 */
abstract class Component: AbstractView() {

	// Layout to wrap the component (view.layout.EmptyLayout for no wrapper)
	abstract val layout: Layout

	override protected fun _render(): DOMNode {

		// Render component inside wrapper
		return layout.render(this)
	}
}
