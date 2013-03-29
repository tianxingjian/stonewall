<%@ page import="com.stonewall.web.model.Plant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div>
	<h3>
		At Stonewall we stock the following, Shrubs, Trees, Herbaceous and
		much more. <br />Call or check us out for different selections as the
		seasons pass us by.
	</h3>
	<div class="plantsHeading">Shrubs</div>
	<div class="plantsDisplay">
		<ul>
			<li>Abelia (Edward Gouchers)</li>
			<li>Acorus (Ogon)</li>
			<li>Andromeda (Nikko)</li>
			<li>Aucuba (Jap. Picturata, Variegata,Crotonifolia)</li>
			<li>Ajuga (Braunherz, Black Scallop)</li>
			<li>Azalea (Hino Crimson, Ann Frank(pink), Hotshot(red),
				Mothersday(red), Mary Helen (white), Hisqka</li>
			<li>Berberis (Buxifolia nana, Candidula, Darwinii, Thun "Rose
				Glow", X Ottawensis "Superba")</li>
			<li>Blueberry (Blue Jay, Dixi, Goldtraube)</li>
			<li>Buddleia (Black Night, Empire Blue, Royal Red, White
				Profusion)</li>
			<li>Campanula (Stella)</li>
			<li>Caryopteris (Worcester Gold)</li>
			<li>Carex (Evergold)</li>
			<li>Cenaothis (Delight, Thry. Repens, Victoria)</li>
			<li>Ceratostigma (Griffithii)</li>
			<li>Chaenomeles (Texas Scarlet)</li>
			<li>Choisya (Ternata, Sundance)</li>
			<li>Cistus (Sunset)</li>
			<li>Convolulus (Cneorum)</li>
			<li>Cordyline (Australis)</li>
			<li>Cornus (Aurea, Sang "Winter Fire", Spaethii, Stolonifera)</li>
			<li>Cotinus (Royal Purple)</li>
			<li>Coreopsis (Limerock Ruby, Zagreb)</li>
			<li>Cotoneaster (Coral Beauty, Horizontalis, Horizontalis
				Variegata, Queen of Carpets, Coral Beauty "Mop head")</li>
			<li>Crinodendrum (Hookerianum)</li>
			<li>Cytisus (Boskoop Ruby, Cynii, Lena "Orange/Red", Luna "Lemon
				Bicolor", Praecox albus "White", Praecox Allgold "Yellow", Racemosa
				"Prolock Broom", Zeelandia)</li>
			<li>Dicentra (Form. Bacchanal)</li>
			<li>Elaeagnus (Ebbingei)</li>
			<li>Erica (Alberts Gold, Estella Gold, Pink Joy)</li>
			<li>Erigeron (Sea Breeze)</li>
			<li>Escallonia (Gold Brian, Ingramia, Red Dream, Rub Macrantha)</li>
			<li>Euonymus (Emerald Gaiety, Emerald n Gold, Jap "Microphyllus
				Pulchellus", Blondy, Harlequin, Golden Harequin, Jap Extase, Ovetus
				Aurea, Pierollino)</li>
			<li>Erica (Winter/Spring Flowering, Summer/Autumn Flowering)</li>
			<li>Euphorbia (Amy. Purpurea, Bonfire)</li>
			<li>Forsythia (Spectablis)</li>
			<li>Fragaria (Lipstick, Pink Panda)</li>
			<li>Fuchsia (Alice Hoffman, Army Nurse, Genii, Mrs Popple, Tom
				Thumb, Versicolour, Riccarthonia)</li>
			<li>Geranium (Johnsons Blue, Patrica)</li>
			<li>Gernista (Hispanica, Lydia, Lemon Spreader)</li>
			<li>Griselinia (Littoralis, Litt Variegata)</li>
			<li>Grevillea (Juniperoides)</li>
			<li>Halimiocistus (Sahaucii)</li>
			<li>Halimium (Libanotis)</li>
			<li>Hebe (Sutherlandii)</li>
			<li>Helleborus (Foetidus, Red Hybrids)</li>
			<li>Helianthemum (Ben Ledi "Red", Golden Queen "Yellow",
				Georgham "Pink", The Bride "White", Wisley Yellow "Yellow")</li>
			<li>Helichrysum (Splendidum)</li>
			<li>Heuchera (Beauty Color, Cascade Dawn, Chocolate Ruffles,
				Frosted Violet, Jade Gloss, Lime Rickey, Midnight Rose, Peach
				Flamebe, Plum Pudding, Plum Royale, Raspberry Ice, Starry Nite,
				Stoplight)</li>
			<li>Houttuynia (Chamaelon)</li>
			<li>Hydrangea (Annabelle, Bluebird, Blue Wave, Bouquet Rose,
				Masja)</li>
			<li>Hypericum (Hidcote,Tricolor)</li>
			<li>Ilex (Argenteo-Marginata, Golden King, Jc Van Tol,
				Lawsoniana, Pyramidalis Variegata, Silver Queen)</li>
			<li>Kerria (Pleniflora)</li>
			<li>Itea (Illicfolia)</li>
			<li>Laurus (Nobilis, Nobilis Aurea)</li>
			<li>Lavandula (Hidcote)</li>
			<li>Lavatera (Rosea, Barnsley Baby, Brendon Springs)</li>
			<li>Leptospermum (Crimson n' Gold, Kiwi, Martini)</li>
			<li>Libertia (Goldfinger)</li>
			<li>Lonicera (Pileata)</li>
			<li>Lophomyrtus (Red Dragon, Milticolor)</li>
			<li>Lithodora (Heavenly Blue)</li>
			<li>Mahonia (X Media "Charity", Charity, Winder Sun)</li>
			<li>Myrtus (Glanlean)</li>
			<li>Nandinia (Fire Power)</li>
			<li>Nepeta (Six Hills Giant)</li>
			<li>Olearia (Hassatii)</li>
			<li>Oregano (Aureum)</li>
			<li>Ophiopogon (Plan. Nigrescens)</li>
			<li>Osmanthus (Tricolor, Delavyii)</li>
			<li>Ozothamnus (Ledifolus, Sussex Silver)</li>
			<li>Pachysandra (T. Greencarpet)</li>
			<li>Penstemon (Garnet "Red")</li>
			<li>Pernettya (Mucronata "Purple", Mucr. "Alba" White, Mucr
				"Coccinea" Red, Mucr "Rosea" Pink)</li>
			<li>Persicaria (Affine)</li>
			<li>Physocarpus (Diobolo)</li>
			<li>Pseudowintera (Colorata, Mount Congreve)</li>
			<li>Philadelphus (Aureus)</li>
			<li>Phormium (Tenax Atro Purpurea, Allison Jackmann, Jester,
				Tricolor, Yellow Wave)</li>
			<li>Phlox (Alexanders Surprise, Amazing Grace, Daniels Cushion)</li>
			<li>Photina (Chamilvy, Fras. "Red Robin", Little Red Robin)</li>
			<li>Pieris (Forest Flame, Little Heath Var., Mountain Fire,
				Japonica "Debutante")</li>
			<li>Pittosporum (Elizabeth, Gold Star, Golf Ball, Irene
				Patterson, Silver Queen, Tom Thumb)</li>
			<li>Potentilla (Frut "Abbotswood" White, Glenroy Pinkie "Pink",
				Goldfinger "Yellow", Kolbold "Dwarf Yellow", Lovely Pink, Red Ace,
				Reb Robin, Tangerine)</li>
			<li>Prosthanthera (Ballerina, Cuneata)</li>
			<li>Prunus (Laurocerasus)</li>
			<li>Pyracantha (Golden Charmer, Orange Charmer, Red Column,
				Soleil D'or)</li>
			<li>Rubus (Tricolor)</li>
			<li>Santolina (Incana Nana)</li>
			<li>Sophora (Prostrata 'Little Baby')</li>
			<li>Sarocococca (Confusa, Hookeranum)</li>
			<li>Senecio (Sunshine)</li>
			<li>Skimmia (Rubella)</li>
			<li>Spirea (Arguta, Firelight, Goldenflame, Pink Fountain, Jap.
				"Goldmound", Nipp "Snowmound")</li>
			<li>Stephanandra (Incisa 'Crispa')</li>
			<li>Syringa (Meyeri "Palibin")</li>
			<li>Teucrim (Chamaedrys)</li>
			<li>Ulex (Flore Plena)</li>
			<li>Viburnum (Davidii, Eves Price, French White, Tinus
				"Gwellian", Lanarth, Mariesii)</li>
			<li>Veronica (Royal Candles "Dwarf Blue", Spicata "Heidekind"
				Red)</li>
			<li>Weigela (Purpura 'Nana', Variegata 'Nana', Monet)</li>
		</ul>
	</div>
	<div class="plantsHeading">Climbers</div>
	<div class="plantsDisplay">
		<ul>
			<li>Cissus (Striata)</li>
			<li>Clematis (Alba Luxurians, Blue Bell, Etiole Violette, Little
				Nell, Viticella, Viticella 'Kermesina', Vit. 'Margot Koster',
				Princess of Wales, Vit. 'Polish Spirit', Tango, Montana Rubens,
				Montana Elizabeth, Montana Fragrant Spring, Montana Wilsonii
				'White', Montanna Mayleen)</li>
			<li>Hedera (Gold Child, Glacier, Goldhearth, Kolbri, Paddy's
				Pride)</li>
			<li>Hydrangea (Petiolaris)</li>
			<li>Jasminum (Nudiflorum)</li>
			<li>Lonicera (Goldflame, Beligica Select, Mint Crisp, Serotina,
				Halliana, Henryii)</li>
			<li>Kerria (Pleniflora)</li>
			<li>Parthenocissus (Quinquefloia, Purpurea)</li>
			<li>Pyracantha (Golden Charmer, Orange Charmer, Red Column,
				Soleil D'or)</li>
			<li>Solanum (Crispum 'Glasnevin Blue', Lanata 'Bleu',
				Jasminoides 'Albus', Jasminoides 'Aurea')</li>
			<li>Sollya (Heter. 'Bluebellis')</li>
			<li>Trachelospernum (Jasminoides)</li>
		</ul>
	</div>
	<div class="plantsHeading">Conifers</div>
	<div class="plantsDisplay">
		<ul>
			<li>Chamaecyparis (Boulevard, Minima Aurea)</li>
			<li>Cupessus (Minima Glauca, Wilma)</li>
			<li>Cupressocyparis (Leylandii, Castlewellian Gold, Gold Rider)</li>
			<li>Crytomeria (Vilmoriana)</li>
			<li>Juniperus (Blue Arrow, Blue Carpet, Blue Star, Old Gold)</li>
			<li>Picea (Albertiana Conica)</li>
			<li>Thuja (Rheingold, Smargd)</li>
		</ul>
	</div>
	<div class="plantsHeading">Grasses</div>
	<div class="plantsDisplay">
		<ul>
			<li>Acorus (Ogon)</li>
			<li>Carex (Evergold)</li>
			<li>Cordyline (Australis)</li>
			<li>Libertia (Gold Finger)</li>
			<li>Ophiopogon (Nigresens)</li>
			<li>Phormium (Tenas Atro Purpurea, Allison Jackmann, Jester,
				Tricolor,Yellow Wave)</li>
		</ul>
	</div>
	<div class="plantsHeading">Fruit</div>
	<div class="plantsDisplay">
		<ul>
			<li>Red Currant (Red Lake)</li>
			<li>Black Currant (Ben Lomond, Ben Sarek)</li>
			<li>Rheum (Timberly Early)</li>
			<li>Vaccinum (Blue Jay, Dixi, Goldtrube)</li>
			<li>Plum (Victoria)</li>
			<li>Apple (Brambley Seedling, Cox Orange Pippin, Golden
				Delicious, Katja)</li>
			<li>Pear (Conferance)</li>
			<li>Cherry Morello</li>
		</ul>
	</div>
	<div class="plantsHeading">Hedging</div>
	<div class="plantsDisplay">
		<ul>
			<li>Berberis (Darwinii, Superba)</li>
			<li>Cupressocyparis (Laylandii, Castlewellian Gold, Robinsons
				Gold, Gold Rider)</li>
			<li>Escallonia (Rubra Macrantha, Ingramii)</li>
			<li>Griselinia (Littolaris, Variegata)</li>
			<li>Ilex (Golden King, Silver Queen, Lawsoniana)</li>
			<li>Oleria (Haastii)</li>
			<li>Prunus (Common Laurel, Laurcerasus)</li>
			<li>Photina (Red Robin)</li>
			<li>Viburnum (Tinus Eves Price, Tinus Gwellian)</li>
		</ul>
	</div>
	<div class="plantsHeading">Heather's - Winter - Spring</div>
	<div class="plantsDisplay">
		<ul>
			<li>Brightness</li>
			<li>Darley Dale</li>
			<li>Furzey</li>
			<li>Ghosthills</li>
			<li>Kramer Red</li>
			<li>Jack B Brummage</li>
			<li>Irish Salmon</li>
			<li>Silberschmelze</li>
			<li>White Perfection</li>
		</ul>
	</div>
	<div class="plantsHeading">Heather's - Summer - Autumn</div>
	<div class="plantsDisplay">
		<ul>
			<li>Cin. Velvet Night</li>
			<li>Cin. Violetta</li>
			<li>Vags St Keverne</li>
			<li>Vags Lyonesse</li>
			<li>Vags Mrs Maxwell</li>
			<li>Alberts Gold</li>
			<li>Estrella Gold</li>
			<li>Pink Joy</li>
		</ul>
	</div>
	<div class="plantsHeading">Trees</div>
	<div class="plantsDisplay">
		<ul>
			<li>Acer Platanoides Crimson King</li>
			<li>Acer Platanoides</li>
			<li>Acer Pseudo Brilliantissimum</li>
			<li>Alnus Glutinosa Imperalis</li>
			<li>Alnus Incana Laciniata</li>
			<li>Amelanchier Canadensis</li>
			<li>Betula Jacquemontii</li>
			<li>Betula Pendula Youngii</li>
			<li>Carpinus Betulus Fastigiata</li>
			<li>Coloneaster Coral Beauty</li>
			<li>Crataegus L. Rosa Flora Plena</li>
			<li>Fagus Sylvatica Rohan Obelisk</li>
			<li>Fraxinus Excelsior Jaspidea</li>
			<li>Laburnum Waterii Vossii</li>
			<li>Liquidamber Styraciflua</li>
			<li>Malus Evereste</li>
			<li>Malus Golden Hornet</li>
			<li>Malus Gorgeous</li>
			<li>Malus John Downie</li>
			<li>Malus Red Sentinel</li>
			<li>Populus Candicans Aurora</li>
			<li>Prunus Avium Plena</li>
			<li>Prunus C. Pissardii Nigra</li>
			<li>Prunus Serrulata Amanogawa</li>
			<li>Prunus Serrulata Kanzan</li>
			<li>Pyrus Salicifolia Pendula</li>
			<li>Quercus Robur</li>
			<li>Salix Caprea Pendula</li>
			<li>Sorbus Aria Asplenifolia</li>
			<li>Sorbus Aria Lutescens</li>
			<li>Sorbus Aria Sheerwater Seedling</li>
			<li>Sorbus Commixta</li>
			<li>Sorbus Joseph Rock</li>
			<li>Sorbus Vilmorinii</li>
		</ul>
	</div>
	<div class="plantsHeading">Roses - Bush</div>
	<div class="plantsDisplay">
		<ul>
			<li>Rosa Arthur Bell</li>
			<li>Rosa Chinatown</li>
			<li>Rose Fragrant Cloud</li>
			<li>Rosa Iceberg</li>
			<li>Rosa Ruby Wedding</li>
			<li>Rosa Silver Jubilee</li>
			<li>Rose Trumpeter</li>
		</ul>
	</div>
	<div class="plantsHeading">Roses - Climbling</div>
	<div class="plantsDisplay">
		<ul>
			<li>Rosa Albertine</li>
			<li>Rose Dublin Bay</li>
			<li>Rosa Galway Bay</li>
			<li>Rosa Golden Showers</li>
			<li>Rosa Handel</li>
			<li>Rosa Iceberg</li>
		</ul>
	</div>
	<div class="plantsHeading">Roses - Floral</div>
	<div class="plantsDisplay">
		<ul>
			<li>Flower Carpet Gold</li>
			<li>Flower Carpet Pink</li>
			<li>Flower Carpet Red Velvet</li>
			<li>Flower Carpet White</li>
		</ul>
	</div>
</div>
