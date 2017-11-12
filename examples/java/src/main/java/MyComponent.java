package javaexample;

import io.github.phenax.h.Component;
import io.github.phenax.h.Layout;
import io.github.phenax.h.node.DOMNode;
import io.github.phenax.h.layouts.EmptyLayout;

public class MyComponent extends Component {

	public Layout getLayout() {
		return new EmptyLayout();
	}

	public DOMNode render() {
		return p(null, "This is text boeey");
	}
}
