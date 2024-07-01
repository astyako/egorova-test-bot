theme: /goAnsCinema

    
    # Если спросили про цену, проверим, было ли в запросе название фильма
    state: CheckFilmName4Price
        if: $parseTree._filmNames
            go!: /goAnsCinema/Ans_CheckPriceHere
        # Если в запросе названия фильма не было, пытаемся его получить
        else:
            a: Пожалуйста, уточните, цена на какой фильм вас интересует?
            # кнопка со ссылкой на сайт с фильмами
            inlineButtons:
                {text: "Список фильмов в прокате", url: "https://karofilm.ru/films/1"}
        
        
        state: react_FilmName
            q: * $filmNames * 
            go!: /goAnsCinema/Ans_CheckPriceHere
        
        
        # на всякий случай, если кнопку продублируют текстом
        state: react_ListOfFilms
            q: * список фильмов *
            q: * фильмы в прокате *
            go!: /goAnsCinema/Ans_FilmInfoIsOnSite


        state: react_Undef
            q: *
            go!: /goAnsCinema/Ans_CheckPriceHere
    
    
    # Выдаем ответ в зависимости от того, получили ли название фильма
    state: Ans_CheckPriceHere
        if: $parseTree._filmNames && $parseTree._filmNames.name && $parseTree._filmNames.site
            a: Цены билетов на фильм "{{$parseTree._filmNames.name}}" можно узнать по [ссылке]({{$parseTree._filmNames.site}}).
        else:
            a: Цены билетов на фильмы можно узнать по [ссылке](https://karofilm.ru/films).
    

    # Если спросили про покупку, проверим, было ли в запросе название фильма
    state: CheckFilmName4Buy
        if: $parseTree._filmNames && $parseTree._filmNames.name
            go!: /goAnsCinema/Ans_BuyTicketsHere
        else:
            a: Пожалуйста, уточните, на какой фильм вы хотели бы купить билет?
            # кнопка со ссылкой на сайт с фильмами
            inlineButtons:
                {text: "Список фильмов в прокате", url: "https://karofilm.ru/films/1"}
        
        state: react_FilmName
            q: * $filmNames * 
            go!: /goAnsCinema/Ans_BuyTicketsHere
        
        # на всякий случай, если кнопку продублируют текстом
        state: react_ListOfFilms
            q: * список фильмов *
            q: * фильмы в прокате *
            go!: /goAnsCinema/Ans_FilmInfoIsOnSite
        
        state: react_Undef
            q: *
            go!: /goAnsCinema/Ans_BuyTicketsHere
    
    
    # Выдаем ответ в зависимости от того, получили ли название фильма
    state: Ans_BuyTicketsHere
        if: $parseTree._filmNames && $parseTree._filmNames.name && $parseTree._filmNames.site
            a: Билеты на фильм "{{$parseTree._filmNames.name}}" можно купить по [ссылке]({{$parseTree._filmNames.site}}).
        else:
            a: Билеты на фильмы можно купить по [ссылке](https://karofilm.ru/films).
    
    
    # В зависимости от того, поймали ли название фильма, выдаем либо инфу о конкретном фильме, либо все фильмы в прокате
    state: Ans_FilmInfoIsOnSite
        if: $parseTree._filmNames && $parseTree._filmNames.name && $parseTree._filmNames.site
            a: Информацию о фильме "{{$parseTree._filmNames.name}}" можно посмотреть на [сайте]({{$parseTree._filmNames.site}}).
        else:
            a: Информацию о фильмах в прокате можно посмотреть на [сайте](https://karofilm.ru/films/1).
