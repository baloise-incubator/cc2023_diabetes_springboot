@template.layout.page(
content = @`
<h1>Form 1</h1>
<form action="/saveSelectedFood" method="POST">
	<input name="title" value="mytitle">
	<input name="p2" value="v2">
	<button>Submit</button>
</form>

<h1>Form 2</h1>
<%--<form>--%>
	<input name="amount" placeholder="Menge eingeben" hx-put="/changeSelectedFood">
	<button>Submit</button>
<%--</form>--%>
`
)
