patterns:
    
    # $expensiveAdj - дорогой
    $expensiveAdj = $regexp<д[оа]р[оа]г[иоау](й|[гв][оа]|м[иу]?|я|ю|е|х)>
    # $expensiveAdjSyns - в т.ч. недешевый
    $expensiveAdjSyns = ($expensiveAdj/(не/ни/нк/ен) $cheapAdj/$regexp<н[еи]д[еи]ш[ео]в[ыоау](й|[гв][оа]|м[иу]?|я|ю|е|х)>)
    # $expensiveAdv - дорого, дороговато
    $expensiveAdv = ($regexp<дор[оа]г[оа]>/$regexp<д[оа]р[оа]г[оа]ват[оа]>)
    # $expensiveAdvSyns - в т.ч. недешево
    $expensiveAdvSyns = ($expensiveAdv/(не/ни/нк/ен) $cheapAdv/$regexp<н[еи]деш[еи]в[оа]>)
    $expensiveAdjAdvSyns = ($expensiveAdjSyns/$expensiveAdvSyns)
    
