package io.github.phenax.h

import io.github.phenax.h.node.*

/**
 * View
 */
abstract class AbstractView {

	// Renders the dom node that is returned
	abstract fun render(): DOMNode

	open protected fun _render(): DOMNode = render()

	// Render to node and html methods
	fun renderToNode(): DOMNode = _render()
	fun renderToHtml(): String = renderToNode().toHtml()


	// Html node shorthand
	fun h(nodeName: String, props: Map<String, String>?, children: List<DOMNode>?): DOMNode {
		return HtmlNode(nodeName, props, children)
	}

	// Mount a custom component
	fun h(component: HComponent): DOMNode = component.render()

	// Text node shorthand
	fun text(text: String): DOMNode = TextNode(text)

	// Unsafe Text node shorthand
	fun unsafeText(text: String): DOMNode = TextNode(text, false)

	// File node shorthand
	fun file(text: String, loadOnCreate: Boolean): DOMNode = FileNode(text, loadOnCreate)

	// Html element shorthands
	fun html(props: Map<String, String>?, children: List<DOMNode>?): DOMNode = h("html", props, children)
	fun body(props: Map<String, String>?, children: List<DOMNode>?): DOMNode = h("body", props, children)
	fun head(props: Map<String, String>?, children: List<DOMNode>?): DOMNode = h("head", props, children)
	fun div(props: Map<String, String>?, children: List<DOMNode>?): DOMNode = h("div", props, children)
	fun h1(props: Map<String, String>?, children: List<DOMNode>?): DOMNode = h("h1", props, children)
	fun h2(props: Map<String, String>?, children: List<DOMNode>?): DOMNode = h("h2", props, children)
	fun h3(props: Map<String, String>?, children: List<DOMNode>?): DOMNode = h("h3", props, children)
	fun h4(props: Map<String, String>?, children: List<DOMNode>?): DOMNode = h("h4", props, children)
	fun h5(props: Map<String, String>?, children: List<DOMNode>?): DOMNode = h("h5", props, children)
	fun h6(props: Map<String, String>?, children: List<DOMNode>?): DOMNode = h("h6", props, children)
	fun p(props: Map<String, String>?, children: List<DOMNode>?): DOMNode = h("p", props, children)
	fun p(props: Map<String, String>?, content: String): DOMNode = h("p", props, listOf( text(content) ))
	fun script(src: String, props: Map<String, String> = mapOf<String, String>()): DOMNode {
		val mutableProps = props.toMutableMap()
		mutableProps.put("src", src)
		return h("script", mutableProps, null)
	}
}
