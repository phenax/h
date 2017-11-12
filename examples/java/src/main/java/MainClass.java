package javaexample;


public class MainClass {

	public static void main(String[] args) {

		MyComponent component = new MyComponent();

		String html = component.renderToHtml();

		System.out.println(html);
		System.out.println(html);
	}
}

