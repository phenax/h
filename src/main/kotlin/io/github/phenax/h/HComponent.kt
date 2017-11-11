package io.github.phenax.h

import io.github.phenax.h.node.*

/**
 * Component
 */
abstract class HComponent: AbstractView() {

	// Layout to wrap the component (view.layout.EmptyLayout for no wrapper)
	abstract val layout: HLayout

	override protected fun _render(): DOMNode {

		// Render component inside wrapper
		return layout.render(this)
	}
}
