patterns:
    
    # $cheapAdj - дешевый
    $cheapAdj = $regexp<д[еи]ш[ео]в[ыоау](й|[гв][оа]|м[иу]?|я|ю|е|х)>
    # $cheapAdjSyns - в т.ч. недорогой
    $cheapAdjSyns = ($cheapAdj/(не/ни/нк/ен) $expensiveAdj/$regexp<н[еи]д[оа]р[оа]г[иоау](й|[гв][оа]|м[иу]?|я|ю|е|х)>)
    # $cheapAdv - дешево
    $cheapAdv = $regexp<деш[еи]в[оа]>
    # $cheapAdvSyns - в т.ч. недорого
    $cheapAdvSyns = ($cheapAdv/(не/ни/нк/ен) $expensiveAdv/$regexp<н[еи]дор[оа]г[оа]>)
    $cheapAdjAdvSyns = ($cheapAdjSyns/$cheapAdvSyns)
    
    $costVInf = (стоить/стоеть/тсоить/мтоить)
    $costVPres = (стоит/стоет/стоят/стоют/тсоит/мтоит)
    $costVInfPres = ($costVInf/$costVPres)
