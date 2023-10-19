<article>
<h3>Alpine Store State (not working)</h3>
<div x-data="$store.globalstate">
	<div>Counter: <span x-text="counter"></span></div>
	<button @click="counter += 1">+</button>
	<button @click="counter -= 1">-</button>
</div>
</article>
