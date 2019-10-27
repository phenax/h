package io.github.phenax.h.node

// Render nothing
class EmptyNode: AbstractDOMNode(), InlineDOMNode {
	override fun toHtml(): String = ""
}
