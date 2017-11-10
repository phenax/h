package io.github.phenax.h.dom


/**
 * DOM node to render html elements
 * 
 * @param nodeName    Name of the node/element
 * @param props       Element attributes
 * @param children    Child nodes
 */
class HtmlNode(val nodeName: String, val props: Map<String, String>? = null, val children: List<DOMNode>? = null): DOMNode() {

	override fun toHtml(): String {

		// Properties map to string
		var propsString =
			props?.map({ "${it.key}=\"${it.value}\"" })?.joinToString(" ")
		propsString = if(propsString != null) " $propsString" else ""

		// Node list to string
		var childrenHtml =
			children?.map({ it.toHtml() })?.joinToString(" ")
		childrenHtml = if(childrenHtml != null) childrenHtml else ""

		return "<$nodeName$propsString>${childrenHtml}</$nodeName>"
	}
}
