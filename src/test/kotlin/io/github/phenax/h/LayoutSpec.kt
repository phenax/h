package io.github.phenax.h

import io.kotlintest.matchers.*
import io.kotlintest.properties.*
import io.kotlintest.*

import io.github.phenax.h.Component
import io.github.phenax.h.node.DOMNode
import io.github.phenax.h.helpers.MyLayout
import io.github.phenax.h.layouts.EmptyLayout

class LayoutSpec: MySpec() {

	init {

		"Layout" {

			should("should render child") {

				val layout = createLayout { l -> { c -> 
					l.div(mapOf( "id" to "wrapper" ), listOf( l.h(c) ))
				} }

				val component = createComponent(layout) { c ->
					c.div(null, listOf( c.text("Hello") ))
				}

				component.renderToHtml() shouldBe """<div id="wrapper"><div>Hello</div></div>"""
			}
		}
	}
}