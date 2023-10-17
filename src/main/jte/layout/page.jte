@import gg.jte.Content

@param Content content

<!doctype html>
<html lang="">
<head>
	<title>Diabetes Helper</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@next/css/pico.min.css"/>
	<script src="https://unpkg.com/htmx.org@1.9.4" crossorigin="anonymous"></script>

	<!-- Alpine Plugins -->
	<script defer src="https://unpkg.com/@alpinejs/persist@3.13.1/dist/cdn.min.js"></script>
<%--	<script defer src="https://cdn.jsdelivr.net/npm/@alpinejs/persist@3.13.1/dist/cdn.min.js"></script>--%>

	<!-- Alpine Core -->
<%--	<script defer src="https://cdn.jsdelivr.net/npm/alpinejs@3.13.1/dist/cdn.min.js"></script>--%>
	<script defer src="https://unpkg.com/alpinejs@3.13.1/dist/cdn.min.js"></script>

	<link rel="stylesheet" href="/site.css">
	<script>
        document.addEventListener('alpine:init', () => {
            // console.log($persist);
/*
            Alpine.data('state', () => {
                return {
                    items: ['1', '2'],
					addItem() {
                        this.items = ['a', 'b'];
					}
                };
            });
*/
            Alpine.store('globalstate', {
                // items: $persist([]),
                items: [],
                addItem(name) {
                    this.items = [...this.items, name];
                    console.log(this.items);
                }
            });

        });
	</script>
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
