package io.github.phenax.h

import io.github.phenax.h.node.*

/**
 * Layout
 */
abstract class Layout: AbstractView() {

	// Dont need empty render
	override fun render(): DOMNode { throw Exception("Need to pass component to render layout") }

	// Render component inside layout
	abstract fun render(comp: Component): DOMNode
}
