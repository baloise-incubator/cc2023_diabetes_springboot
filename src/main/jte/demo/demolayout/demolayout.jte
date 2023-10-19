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

<body hx-boost="true" x-data="{ lcounter: 0 }">
<main class="container">
	<header>
			<all-caps>HTMX Demo App</all-caps>
	</header>
	${content}

	<hr>
	<pre>
		Explanation:
		If you want to share frontend state in a Multi Page Application (MPA)
		you can put an "x-data" attributge on the "body" tag:

		&lt;body hx-boost="true" x-data="{ counter: 0 }">

		 hx-boot is enabled so that only "body" is changed and not the whole page.
		 hx-boot will change the innerHTML of "body" and thus x-data is retained.
		 This is the basis for the "global" data sharing.

		Trying to achieve the same result with "Alpine.store(..."
		caused an error and does not seem to work.

		One could also use the "persist" extension which uses the browsers localstore.

	</pre>
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
