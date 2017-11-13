package io.github.phenax.h

import io.kotlintest.matchers.*
import io.kotlintest.properties.*
import io.kotlintest.*

import io.github.phenax.h.node.DOMNode
import io.github.phenax.h.helpers.MyComponent

class ComponentSpec: MySpec() {

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

			should("render paragraph tag with text") {
				val text = "Hello world"
				val component = createComponent { it.p(null, text) }
				val expectedHtml = "<p>$text</p>"

				component.renderToHtml() shouldBe expectedHtml
			}

			should("escape html string passed as text") {
				val component = createComponent { it.p(null, "<h1>Hello world</h1>") }
				val expectedHtml = "<p>&lt;h1&gt;Hello world&lt;/h1&gt;</p>"

				component.renderToHtml() shouldBe expectedHtml
			}

			should("render paragraph tag with unsafe text") {
				val text = "<h1>Hello world</h1>"
				val component = createComponent { it.p(null, listOf( it.unsafeText(text) )) }
				val expectedHtml = "<p>$text</p>"

				component.renderToHtml() shouldBe expectedHtml
			}

			should("render link tag and style tag") {
				val component =
					createComponent {
						it.div(null, listOf(
							it.style("/css/style.css"),
							it.style(null, "html, body { margin: 0; }")
						))
					}

				val expectedHtml = """
					|<div>
						|<link href="/css/style.css" />
						| <style>html, body { margin: 0; }</style>
					|</div>
				""".trimMargin().replace("\n", "")

				component.renderToHtml() shouldBe expectedHtml
			}
		}
	}
}