package io.github.phenax.h

import io.kotlintest.matchers.shouldBe

class LayoutSpec: MySpec() {

	init {

		"Layout" {

			should("should render child") {

				val layout = createLayout { l -> { c -> 
					l.div(mapOf( "id" to "wrapper" ), listOf( l.h(c) ))
				} }

				val comp = component(layout) {
					div(null, listOf( text("Hello") ))
				}

				comp.renderToHtml() shouldBe """<div id="wrapper"><div>Hello</div></div>"""
			}
		}
	}
}