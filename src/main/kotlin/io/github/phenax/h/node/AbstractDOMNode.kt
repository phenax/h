package io.github.phenax.h.node

/**
 * DOM node for templating html stuff
 */
abstract class AbstractDOMNode : DOMNode {

	override fun toString() = toHtml()
}
