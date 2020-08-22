package io.github.phenax.h

import io.kotlintest.matchers.shouldBe

class ComponentSpec: MySpec() {

	init {



		"Node rendering" {

			should("render text node") {

				val text = "Hello world"
				val comp = component { text(text) }

				comp.renderToHtml() shouldBe text
			}

			should("render empty div") {

				val comp = component { div(null, null) }

				comp.renderToHtml() shouldBe "<div></div>"
			}

			should("render empty div with attributes") {

				val comp = component {
					div(
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

				comp.renderToHtml() shouldBe expectedHtml
			}

			should("render empty div with children") {

				val comp = component {
					div(
						mapOf( "class" to "card" ),
						listOf(
							h1(
								mapOf( "class" to "card--title" ),
								listOf( text("Card title") )
							),
							p(
								mapOf( "class" to "card--description" ),
								listOf( text("Card description"), em("with emphasis") )
							)
						)
					)
				}

				val expectedHtml =
					"""
						|<div class="card">
							|<h1 class="card--title">Card title</h1>
							| <p class="card--description">Card description <em>with emphasis</em></p>
						|</div>
					""".trimMargin().replace("\n", "")

				comp.renderToHtml() shouldBe expectedHtml
			}

			should("render paragraph tag with text") {
				val text = "Hello world"
				val comp = component { p(null, text) }
				val expectedHtml = "<p>$text</p>"

				comp.renderToHtml() shouldBe expectedHtml
			}

			should("escape html string passed as text") {
				val comp = component { p(null, "<h1>Hello world</h1>") }
				val expectedHtml = "<p>&lt;h1&gt;Hello world&lt;/h1&gt;</p>"

				comp.renderToHtml() shouldBe expectedHtml
			}

			should("render paragraph tag with unsafe text") {
				val text = "<h1>Hello world</h1>"
				val comp = component { p(null, listOf( unsafeText(text) )) }
				val expectedHtml = "<p>$text</p>"

				comp.renderToHtml() shouldBe expectedHtml
			}

			should("render link tag and style tag") {
				val component =
					component {
						div(null, listOf(
							style("/css/style.css"),
							style(null, "html, body { margin: 0; }")
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







		"Loops and conditionals" {

			should("Conditionals test") {

				var isThisVariableTrue = true;

				val comp =
					component {
						div(null, listOf(
							if(isThisVariableTrue) {
								text("Yep")
							} else {
								text("Nope")
							}
						))
					}

				isThisVariableTrue = true;
				comp.renderToHtml() shouldBe "<div>Yep</div>"

				isThisVariableTrue = false;
				comp.renderToHtml() shouldBe "<div>Nope</div>"
			}

			should("render numbers from 2 to 6") {

				val comp =
					component { div(null, (2..6).map { text("$it") }) }

				comp.renderToHtml() shouldBe """<div>2 3 4 5 6</div>"""
			}

			should("render list of bands") {

				val listOfBands = listOf(
					mapOf( "name" to "Avenged Sevenfold" ),
					mapOf( "name" to "Trivium" ),
					mapOf( "name" to "Foo Fighters" ),
					mapOf( "name" to "Suicide Silence" ),
					mapOf( "name" to "Dragonforce" ),
					mapOf( "name" to "Bullet for my valentine" ),
					mapOf( "name" to "FALLOUTBOY" )
				)

				val comp =
					component {
						div(null,
							listOfBands
								.filter { "${it["name"]}" != "FALLOUTBOY" }
								.map { p(null, "${it["name"]}") }
						)
					}

				val expectedHtml = """
					|<div>
						|<p>Avenged Sevenfold</p>
						| <p>Trivium</p>
						| <p>Foo Fighters</p>
						| <p>Suicide Silence</p>
						| <p>Dragonforce</p>
						| <p>Bullet for my valentine</p>
					|</div>
				""".trimMargin().replace("\n", "")

				comp.renderToHtml() shouldBe expectedHtml
			}
		}
	}
}