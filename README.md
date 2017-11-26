# h
[![Build Status](https://circleci.com/gh/phenax/h.svg?style=shield&circle-token=4d17eafbc842c9e17f2efa731cc89d44fe5a8d73)](https://circleci.com/gh/phenax/h)
[![release](http://github-release-version.herokuapp.com/github/phenax/h/release.svg?style=flat)](https://github.com/phenax/h/releases/latest)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

Html templating library for kotlin.


## Get started

#### Download
* Download  the latest release. ([View releases](https://github.com/phenax/h/releases))
* Clone the repo for the source code `git clone https://github.com/phenax/h`.
* Test it with `./gradlew test`. Generated test report -> `build/reports/tests/test`.

#### Examples
Simple component examples in `/examples`


#### Create a component

```kotlin
import io.github.phenax.h.Component
import io.github.phenax.h.Layout
import io.github.phenax.h.node.DOMNode
import io.github.phenax.h.layouts.EmptyLayout

class CardComponent(val myTitle: String): Component() {

  // Layout(EmptyLayout is no wrapper. You can use a custom layout)
  override val layout = EmptyLayout()

  // This renders a div card component
  // <div class="card">
  //   <h1 class="card--title">Card title</h1>
  //   <p class="card--description">Card description</p>
  // </div>
  override fun render(): DOMNode {
    return div( mapOf( "class" to "card" ),
      listOf(
        h1( mapOf( "class" to "card--title" ), myTitle),
        p( mapOf( "class" to "card--description" ), "Card description" )
      )
    )
  }
}

val helloWorldCard = CardComponent("Hello world")
```

OR

```kotlin
import io.github.phenax.h.*

fun createCard(myTitle: String) = component {
  div( mapOf( "class" to "card" ),
    listOf(
      h1( mapOf( "class" to "card--title" ), myTitle),
      p( mapOf( "class" to "card--description" ), "Card description")
    )
  )
}

val helloWorldCard = createCard("Hello world")
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


#### Use components inside other components
```kotlin
class UserCardComponent(user: User): Component() {
  override val layout = EmptyLayout()
  override fun render(): DOMNode {
    return div(null, listOf(
      div(null, listOf( text(user.name) )),
      div(null, listOf( text('@' + user.nickname) )),
    ))
  }
}

class UserListComponent(usersList: List<User>): Component() {
  override val layout = EmptyLayout()
  override fun render(): DOMNode {
    return div(null,
      usersList.map { user ->
        div(null, listOf( h(UserCardComponent(user)) ))
      }
    )
  }
}
```


#### Render to html string
```kotlin
val component = CardComponent()
println(component.renderToHtml())
```

