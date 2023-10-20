@template.demo.demolayout.demolayout(
title = "MPA Page 2",
init = "init",
content = @`
	<h1>Page 2</h1>

	@template.demo.mpa.common_data-counter()
		@template.demo.mpa.common_store-counter()

	<a href="page1">To Page 1</a>
`
)


