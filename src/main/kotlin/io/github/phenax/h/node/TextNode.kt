package io.github.phenax.h.dom

/**
 * DOM node for rendering strings
 * 
 * @param text  The string to render
 */
class TextNode(val text: String): DOMNode() {
	override fun toHtml() = text
}
