@import gg.jte.Content

@param String init
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
<body>
<main class="container">
	<header>
		<h1>
			<all-caps>Diabetes Helper (HTMX inside)</all-caps>
		</h1>
	</header>
	${content}
</main>
</body>
<script>
    document.addEventListener("DOMContentLoaded", function() {
        htmx.trigger("body", "${init}");
    });
</script>
</html>
