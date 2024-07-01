theme: /ticketInfo

    # в качестве названий фильмов ловим "Челюсти" ("Челюсти. Кровавый риф"), "Унесенные призраками" и "Мастер и Маргарита" ("МиМ")
    
    state: HowMuchForTicket
        # сколько стоят 2 билета
        # билет на фильм сколько стоит
        q!: * { ($ruSkolkoNom * ($costVInfPres/выйдет/выидет/выйдит/выидит/выйдут/выидут)) * $ticket} *
        q!: * $ruSkolkoNom * $ticket * ($costVInfPres/выйдет/выидет/выйдит/выидит/выйдут/выидут) *
        # 3 билета на мастера и маргариту сколько будут стоить
        # сколько билет на фильм челюсти стоит
        q!: * { ($ruSkolkoNom * ($costVInfPres/выйдет/выидет/выйдит/выидит/выйдут/выидут)) * $ticket * $filmNames} *
        q!: * { ($ruSkolkoNom * $ticket * ($costVInfPres/выйдет/выидет/выйдит/выидит/выйдут/выидут)) * $filmNames} *
        q!: * { ($ruSkolkoNom * $filmNames * ($costVInfPres/выйдет/выидет/выйдит/выидит/выйдут/выидут)) * $ticket} *
        q!: * $ruSkolkoNom * {$filmNames * $ticket} ($costVInfPres/выйдет/выидет/выйдит/выидит/выйдут/выидут) *
        
        # стоимость билетов
        # дорогие у вас билеты-то?
        q!: * {($price/почем/пачем/$cheapAdjAdvSyns/$expensiveAdjAdvSyns) *  $ticket} *
        # стоимость билетов на унесенных призраками
        # у вас билеты на челюсти дешевые?
        q!: * {($price/почем/пачем/$cheapAdjAdvSyns/$expensiveAdjAdvSyns) *  $ticket * $filmNames} *
        
        # сколько за билет у вас?
        # за 4 билета сколько будет?
        q!: * {$ruSkolkoNom * (за [$NumberOneToTen]  $ticket)} *
        # сколько за билет на фильм челюсти
        q!: * {$ruSkolkoNom * (за [$NumberOneToTen]  $ticket) * $filmNames} *
        
        go!: /goAnsCinema/CheckFilmName4Price

    
    state: HowCanIBuyTicket
        # как мне купить билет на фильм
        # хочу приобрести билет на фильм
        # как у вас билеты приобретаются
        q!: * {($buyInf/{$buyPastPerf бы}/$buyFut1/$buyPresRefl3/$buyN) * $ticket} *
        # купить билет на фильм челюсти кровавый риф
        # покупка билетов на унесенных призраками
        q!: * {($buyInf/{$buyPastPerf бы}/$buyFut1/$buyPresRefl3/$buyN) * $ticket * $filmNames} *
        # 2 билета на МиМ
        q!: * {$ticket * $filmNames} *
        
        go!: /goAnsCinema/CheckFilmName4Buy
