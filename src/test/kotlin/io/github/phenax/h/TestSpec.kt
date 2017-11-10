import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.ShouldSpec

class TestSpec : ShouldSpec() {
	init {
		"String.length" {
			should("return the length of the string") {
				"sammy".length shouldBe 5
				"".length shouldBe 0
			}
		}
	}
}