@import gg.jte.Content

@param Content content

<!doctype html>
<html lang="">
<head>
	<title>Contact App</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@next/css/pico.min.css"/>
	<script src="https://unpkg.com/htmx.org@1.9.4" crossorigin="anonymous"></script>
	<script defer src="https://cdn.jsdelivr.net/npm/alpinejs@3.13.1/dist/cdn.min.js"></script>
	<link rel="stylesheet" href="/site.css">
</head>
<body hx-boost="true">
<main class="container">
	<header>
		<h1>
			<all-caps>Diabetes Helper</all-caps>
		</h1>
	</header>
	${content}
</main>
</body>
</html>
