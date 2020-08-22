package io.github.phenax.h.node

class InlineHtmlNode(
        nodeName: String,
        props: Map<String, String>?,
        children: List<InlineDOMNode>?,
        isClosingTagRequired: Boolean)
    : HtmlNode(nodeName, props, children, isClosingTagRequired), InlineDOMNode {
}