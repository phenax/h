package io.github.phenax.h

import io.kotlintest.matchers.*
import io.kotlintest.properties.*
import io.kotlintest.*

import io.github.phenax.h.Component
import io.github.phenax.h.node.DOMNode
import io.github.phenax.h.helpers.MyLayout

class LayoutSpec: MySpec() {

	init {

		"Layout" {

			should("should render child") {
				val layout =
					createLayout { (l: MyLayout, c: Component) -> 
						l.div(null, listOf(
							l.h(c)
						))
					}

				val component =
					createComponent(layout) {
						it.div(null, listOf( text("Hello") ))
					}
				
				println(layout.renderToHtml())

			}
		}
	}
}