# Kiosk
För att testa PUT integrationen ifrån frontend så behöver en order ha genomförts utan att cookies har rensats. Sedan kan den kundens data ändras på Mina Sidor.

För att få tillgång till ett urval produkter kan följande JSONs POSTas mot localhost:8080/api/products/

    {  
        "name": "Potatis",
        "type": "VEGETABLE",
        "price": "5,00",
        "unit": "Kg",
        "img": "/images/potatoe2.jpg",
        "description": "Passar bra i soffan.",
        "inventory": 601
    },
    {
        "name": "Banan",
        "type": "FRUIT",
        "price": "9,99",
        "unit": "Kg",
        "img": "/images/banana.jpg",
        "description": "Gula och kurvade. Precis som du vill ha dem!",
        "inventory": 100
    },
    {
        "name": "Potatis - Premium",
        "type": "VEGETABLE",
        "price": "23,00",
        "unit": "Kg",
        "img": "/images/potatoe.jpg",
        "description": "Handplockade från Litauen. 12% intensivare smakupplevelse än vår basvariant - perfekt för potatiskonnässören.",
        "inventory": 100
    },
    {
        "name": "Lax",
        "type": "FISH",
        "price": "82,20",
        "unit": "hg",
        "img": "/images/salmon.jpg",
        "description": "OBS: Fisk.",
        "inventory": 241
    },
    {
        "name": "Croissant",
        "type": "PANTRY",
        "price": "9,00",
        "unit": "st",
        "img": "/images/croissant.jpg",
        "description": "Både Franska och goda.",
        "inventory": 1064
    },
    {
        "name": "Camembert",
        "type": "DAIRY",
        "price": "29,00",
        "unit": "st",
        "img": "/images/camembert.jpg",
        "description": "Ej färdigslicad.",
        "inventory": 700
    }

