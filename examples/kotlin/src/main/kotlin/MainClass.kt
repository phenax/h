package kotlinexample

import io.github.phenax.h.*

fun main(args: Array<String>) {

	val comp = MyComponent()
	val html = comp.renderToHtml()

	println(html)
	println(component {
		div(null, listOf(
			h1(null, "Hello"),
			text("yo ma boey")
		))
	}.renderToHtml())
}
