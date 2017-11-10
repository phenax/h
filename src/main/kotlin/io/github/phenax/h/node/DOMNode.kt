package io.github.phenax.h.dom

/**
 * DOM node for templating html stuff
 */
abstract class DOMNode {

	// Convert the node to html string for rendering
	abstract fun toHtml(): String

	override fun toString() = toHtml()
}
