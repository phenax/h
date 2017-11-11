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

			should("render empty div with attributes") {

				val component = createComponent {
					it.div(
						mapOf(
							"class" to "this-div",
							"a" to "b",
							"data-hello" to "world"
						),
						null
					)
				}

				val expectedHtml =
					"""<div class="this-div" a="b" data-hello="world"></div>"""

				component.renderToHtml() shouldBe expectedHtml
			}

			should("render empty div with children") {

				val component = createComponent {
					it.div(
						mapOf( "class" to "card" ),
						listOf(
							it.h1(
								mapOf( "class" to "card--title" ),
								listOf( it.text("Card title") )
							),
							it.p(
								mapOf( "class" to "card--description" ),
								listOf( it.text("Card description") )
							)
						)
					)
				}

				val expectedHtml =
					"""
						|<div class="card">
							|<h1 class="card--title">Card title</h1>
							| <p class="card--description">Card description</p>
						|</div>
					""".trimMargin().replace("\n", "")

				component.renderToHtml() shouldBe expectedHtml
			}
		}
	}

	private fun createComponent(_getRenderNode: (d: MyComponent) -> DOMNode): MyComponent {
		return MyComponent(_getRenderNode)
	}
}