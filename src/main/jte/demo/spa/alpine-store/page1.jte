@template.demo.demolayout.demolayout(
title = "MPA Page 1",
init = "init",
content = @`
	<h1>Page 1</h1>

	@template.demo.mpa.common_data-counter()
		@template.demo.mpa.common_store-counter()

	<a href="page2">To Page 2</a>

`
)


