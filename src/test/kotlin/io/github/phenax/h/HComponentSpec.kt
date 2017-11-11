package io.github.phenax.h

import io.kotlintest.matchers.*
import io.kotlintest.properties.*
import io.kotlintest.*

import io.github.phenax.h.node.DOMNode
import io.github.phenax.h.helpers.MyComponent

class HComponentSpec: MySpec() {

	init {
		"Component" {

			should("render text node") {

				val text = "Hello world"

				val component = createComponent { it.text(text) }

				component.renderToHtml() shouldBe text
			}

			should("render empty div") {

				val component = createComponent { it.div(null, null) }

				component.renderToHtml() shouldBe "<div></div>"
			}
		}
	}

	private fun createComponent(_getRenderNode: (d: MyComponent) -> DOMNode): MyComponent {
		return MyComponent(_getRenderNode)
	}
}