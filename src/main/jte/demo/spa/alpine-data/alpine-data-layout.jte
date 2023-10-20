@import gg.jte.Content

@param String title
@param Content content

<!doctype html>
<html lang="" >
<head>
	<title>${title}</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@next/css/pico.min.css"/>
	<script src="https://unpkg.com/htmx.org@1.9.4" crossorigin="anonymous"></script>
	<script defer src="https://cdn.jsdelivr.net/npm/alpinejs@3.13.1/dist/cdn.min.js"></script>
	<link rel="stylesheet" href="/site.css">
</head>

<body hx-boost="true" x-data="{ lcounter: 0 }">
<main class="container">
	<header>
			<all-caps>HTMX Demo App</all-caps>
	</header>
	${content}

	<hr>

	<p>Explanation:</p>
	<p class="demo-explanation">
		If you want to share state across pages
		you can put an "x-data" attribute on the "body" tag:
	</p>

	<code>&lt;body hx-boost="true" x-data="{ counter: 0 }"></code>

	<p class="demo-explanation">
		Although it feels like a Multi Page Application technically it is
		a Single Page Application (SPA).
	</p>

	<p class="demo-explanation">
		hx-boot is enabled so that only "body" is changed and not the whole page.
		hx-boot will change the innerHTML of "body" and thus x-data is retained.
		This is the basis for the "global" data sharing.
	</p>

</main>
</body>
</html>
