package kotlinexample


fun main(args: Array<String>) {

	val component = MyComponent()
	val html = component.renderToHtml()

	println(html)
}
