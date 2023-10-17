@import com.baloise.cc2023diabetes.htmx.food.FoodModel
@import com.baloise.cc2023diabetes.htmx.food.FoodVM

@param FoodVM model

@template.layout.page(
content = @`
<%--	<div class="search-container" x-data="$store.state">--%>
<%--	</div>--%>
	<div class="search-container">
		<input
				type="search"
				id="myInput"
				name="search"
				placeholder="Suche nach Lebensmittel"
				hx-get="/food/search"
				hx-target="#search-result"
				hx-trigger="keyup delay:200ms changed"
		/>

		<div id="dropdown-and-chips" x-data="{ items: $persist([]) }">
			<div id="search-result">
			</div>

			<hr/>

			<div id="chips">
				<div x-text="items.length"></div>
<%--				<template x-for="item in items" :key="item.id">--%>
				<template x-for="item in items">
					<div class="chip">
						<div class="chip-content" x-text="item.title"></div>
					</div>
				</template>
			</div>
<%--
			<div id="chips" x-data>
				<template x-for="item in $store.globalstate.items">
					<div class="chip">
						<div class="chip-content" x-text="item || '-'"></div>
					</div>
				</template>
			</div>
--%>
		</div>


<%--
			<template x-for="item in items">
				<div class="chip">
					<div class="chip-content" x-text="item"></div>
					<div class="chip-close" @click="items = items.filter(it => it !== item)">
						<svg class="chip-svg" focusable="false" viewBox="0 0 24 24" aria-hidden="true"><path d="M12 2C6.47 2 2 6.47 2 12s4.47 10 10 10 10-4.47 10-10S17.53 2 12 2zm5 13.59L15.59 17 12 13.41 8.41 17 7 15.59 10.59 12 7 8.41 8.41 7 12 10.59 15.59 7 17 8.41 13.41 12 17 15.59z"></path></svg>

					</div>
				</div>
			</template>
--%>
<%--		</div>--%>
		<hr/>

		<a role="button" href="/calculation">Weiter zur Berechnung</a>
	</div>

`
)

