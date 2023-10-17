@template.layout.page(
content = @`
<form action="/saveSelectedFood" method="POST">
	<input name="title" value="mytitle">
	<input name="p2" value="v2">
	<button>Submit</button>
</form>
`
)
