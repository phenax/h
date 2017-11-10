package io.github.phenax.h

import io.github.phenax.h.dom.*

/**
 * Component
 */
abstract class AbstractComponent: AbstractView() {

	// Layout to wrap the component (view.layout.EmptyLayout for no wrapper)
	abstract val layout: AbstractLayout

	override protected fun _render(): DOMNode {

		// Render component inside wrapper
		return layout.render(this)
	}
}
