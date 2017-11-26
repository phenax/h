package io.github.phenax.h.node

// Render nothing
class EmptyNode: DOMNode() {
	override fun toHtml(): String = ""
}
