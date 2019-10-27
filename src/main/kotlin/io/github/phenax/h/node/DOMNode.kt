package io.github.phenax.h.node

interface DOMNode {
    // Convert the node to html string for rendering
    fun toHtml(): String
}