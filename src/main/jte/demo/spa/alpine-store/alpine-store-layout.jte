@import gg.jte.Content

@param String title
@param String init
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

<body hx-boost="true">
<main class="container">
	<header>
		<all-caps>Data Sharing with alpine-store</all-caps>
	</header>
	${content}

	<hr>

	<p>Explanation:</p>
	<p class="demo-explanation">
		Trying to share state across pages with
		<code>"Alpine.store(..."</code>
		and hx-boost enabled causes an error and does not seem to work.
		Disabling hx-boost means we have a real MPA and therefore the shared state
		will be lost reinitialized on each page load.
	</p>
	<p>
		One could also use the "persist" extension which uses the browsers localstore.
	</p>

</main>
</body>
<script>
    document.addEventListener('alpine:init', () => {
        console.log('alpine:init');
        Alpine.store('globalstate', {
            counter: 22,
        });
    });
</script>
</html>
