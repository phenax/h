package io.github.phenax.h.node

import org.apache.commons.lang3.StringEscapeUtils

/**
 * DOM node for rendering strings
 * 
 * @param text  The string to render
 */
class TextNode(val text: String, val isSafe: Boolean = true): DOMNode() {

	override fun toHtml(): String {

		if(isSafe) {
			return StringEscapeUtils.escapeHtml4(text)
		}

		return text
	}
}
