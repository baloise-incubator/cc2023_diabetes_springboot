@template.demo.spa.alpine-store.alpine-store-layout(
title = "Data Sharing with alpine-store: Page 1",
init = "init",
content = @`
	<h1>Page 1</h1>

	@template.demo.spa.alpine-store.common_store-counter()

	<a href="page2">To Page 2</a>

`
)


