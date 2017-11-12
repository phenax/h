# h
[![Build Status](https://circleci.com/gh/phenax/h.svg?style=shield&circle-token=4d17eafbc842c9e17f2efa731cc89d44fe5a8d73)](https://circleci.com/gh/phenax/h)

Html templating library for kotlin.

### Instructions
* Test it with `./gradlew test`. Generated test report -> `build/reports/tests/test`.
* Build it yourself my dude and get the jar. (Gonna add a release jar soon and ).
* Use it in your project and rock


### Get started
Simple component examples in `/examples`
(Gonna make an api reference website and stuff but for now, this is all you got)

##### Create a component

```kotlin
import io.github.phenax.h.Component
import io.github.phenax.h.Layout
import io.github.phenax.h.node.DOMNode
import io.github.phenax.h.layouts.EmptyLayout

class MyComponent: Component() {

  // Layout(EmptyLayout is no wrapper. You can use a custom layout)
  override val layout = EmptyLayout()

  // This renders a div card component
  // <div class="card">
  //   <h1 class="card--title">Card title</h1>
  //   <p class="card--description">Card description</p>
  //   <p class="card--description">Card description</p>
  // </div>
  override fun render(): DOMNode {
    return div( mapOf( "class" to "card" ),
      listOf(
        h1( mapOf( "class" to "card--title" ),
          listOf( text("Card title") )
        ),
        p( mapOf( "class" to "card--description" ),
          listOf( text("Card description") )
        ),
        p( mapOf( "class" to "card--description" ),
          "Card description"
        )
      )
    )
  }
}
```

#### Create a layout
```kotlin
import io.github.phenax.h.Component
import io.github.phenax.h.Layout
import io.github.phenax.h.node.DOMNode

class HtmlLayout(val title: String = "Moosic"): Layout() {
  override fun render(component: AbstractComponent): DOMNode {
    return (
      html(null, listOf(
        head(null, listOf(
          h("title", null, listOf( text(title) ) ),
          style("/css/style.css"),                               // External stylesheet
          style(null, "html, body { background-color: red; }")   // Inline style
        )),
        body(null, listOf(
          div(null, h(component)),
          script("/js/script.js", mapOf( "defer" to "defer", "async" to "async" ))
        ))
      ))
    )
  }
}
```
