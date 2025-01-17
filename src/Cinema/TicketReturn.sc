# NOTE: Задание 3. Прокомментировала исходные шаблоны и закомментировала их,
#       чтобы можно было потестить исправленный вариант.
#       Незакомментированные строки мои


patterns:
    # в $return и $giveBack целые запстроки, надо разбить на отдельные словари, а запстроки прописать в стейте
    # в $return тасовка из 4 элементов (+ что-то с пробелами)
    # в $giveBack звезды у необязательных элементов
    # паттерны типа как* слишком короткие (из трех символов) для звезды
    # $return = {[как*/где][могу/мож*][мне/нам](верни*/вернуть/возврат)}
    # $giveBack = [как*/где/куда] * [могу/мож*] сдать
    
    # в $my перечисляются только формы именительного/винительного падежа. Либо перечислить остальные, либо добавить глоссу AccNom
    # $my = (мой/моя/мое/мои)
    $my = (
        мой/моего/моему/моем/моим/
        мого/моево/маего/маево/маиго/маиво/
        моиму/маему/маиму/маем/маим/
        моя/мое/мои/моей/моих/мою/моими/
        мая/мае/маи/маей/маю/маих/маими
        )
    
    # ~билет частично дублирует билет*; в билет* будет попадаться "билетный"; стоит прописать опечатки (белет)
    # $ticket = (билет*/~билет)
    # Можно использовать созданный в задании 1 словарь:
    # $ticket = (~билет/~белет/~билетик/~белетик/~билетек/~белетек)
    
    
    
    # $giveBackVImp - отдай, отдавай
    $backwards = (назад/назат/нозад/нозат/обратно/обратна/абратно/абратна)
    
    # $compensateVImp - в т.ч. компенсируй, компенсируйте
    $compensateVImp = $regexp<к[оа][мн]п[еи]н?сн?ируй(т[еи])?>
    # $compensateVInf - в т.ч. компенсировать
    $compensateVInf = $regexp<к[оа][мн]п[еи]н?сн?ир[оа]вать>
    # $compensateVPast - компенсировал, компенсировали
    $compensateVPast = $regexp<к[оа][мн]п[еи]н?сн?ир[оа]в[ао]ли?>
    $compensation = (~компенсация/~кампенсация/~компинсация/~кампинсация/~компенснация/~кампенснация)
    
    $giveBackVImp = {($regexp<[оа][тд]дай(т[еи])?>/$regexp<[оа][тд]д[ао]вай(т[еи])?>) [$backwards]}
    # $giveBackVInf - отдать, отдавать
    $giveBackVInf = {($regexp<[оа][тд]дать>/$regexp<[оа][тд]д[ао]вать>) [$backwards]}
    $money = (
        деньг*/денег/денек/дениг/деник/денех/дених/
        денги/денге/денгов/денгам*/денгах/
        денежк*/денешк*/денюжк*/денюшк*/денижк*/денишк*/денежьк*/денешьк*/денюжьк*/денюшьк*/денижьк*/денишьк*/
        денежек/денешек/денюжек/денюшек/денижек/денишек
        )
    $moneyMeans = ([денеж*/дениж*/ден] (средства*/средств/срества*/среств/ср ва/ср-ва/ср-в/ср в))
    $moneySyns = ($money/$moneyMeans/бабло/бабла/баблом/баблу/бабле/баблишк*/бабки/бабок/бабкам*/бабках)
    $returnN = {(~возврат/~возрат/~вазврат/~вазрат/~возвращение/~возврощение/~вазвращение/~вазврощение) [$backwards]}
    # $returnVImp - верни, возвращай, возврати, сделай возврат
    #$returnVFutWRefl3 - вернет, вернется, возвратит, возвратится, сделает возврат
    $returnVFutWRefl3 = {[$backwards]
        ($regexp<в[еи]рн[еу]т>/
        $regexp<в[еи]рн[еу](ть?с|цц?)[яа]?>/
        $regexp<в[оа]звр[ао]т[ия]т>/
        $regexp<в[оа]звр[ао]т[ия](ть?с|цц?)[яа]?>/
        {$regexp<[сз]?дел[ао][еию]т> $returnN})
        }
    $returnVImp = {[$backwards]
        ($regexp<в[еи]рни(т[еи])?>/
        $regexp<в[оа]звр[ао][щш][ая]й(т[еи])?>/
        $regexp<в[оа]звр[ао]ти(т[еи])?>/
        {$regexp<[сз]?дел[ао]й(т[еи])?> $returnN})
        }
    # $returnVInf - вернуть, возвратить, возвращать, сделать возврат
    $returnVInf = {[$backwards]
        ($regexp<в[еи]рнуть>/
        $regexp<в[оа]звр[ао]тить>/
        $regexp<в[оа]звр[ао][щш][ая]ть>/
        {$regexp<[сз]?дел[ао]ть> $returnN})
        }
    # $returnVPast - возвратил, вернул, возвращал, сделал возврат
    $returnVPast = {[$backwards]
        ($regexp<в[оа]звр[ао]тил[аои]?>/
        $regexp<в[еи]рнул[аои]?>/
        $regexp<в[оа]звр[ао][щш][ая]л[аои]?>/
        {$regexp<[сз]?дел[ао]л[аои]?> $returnN})
        }
    # $returnVPastRefl - возвратился, вернулся, возвращался
    $returnVPastRefl = {[$backwards]
        ($regexp<в[оа]звр[ао]тил[аои]?с[ья]?>/
        $regexp<в[еи]рнул[аои]?с[ья]?>/
        $regexp<в[оа]звр[ао][щш][ая]л[аои]?с[ья]?>)
        }
    $returnVPastWRefl = ($returnVPast/$returnVPastRefl)
    # $returnVPres3 - возвращает, возвращают
    $returnVPres3 = {[$backwards] $regexp<в[оа]звр[ао][щш][ая][ею]т>}
    # $returnVPresRefl3 - возвращается, возвращаются
    $returnVPresRefl3 = {[$backwards] $regexp<в[оа]звр[ао][щш][ая][ею](ть?с|цц?)[яа]?>}
    $returnVPresWRefl3 = ($returnVPres3/$returnVPresRefl3)
    
    # $ruVozmeshchenie - возмещение
    $ruVozmeshchenie = ($regexp<в[оа]зм[еи](щ|сч|ч)ен[ьи](ем?|я|ю|и)>/$regexp<в[оа]зм[еи](щ|сч|ч)ен[ьи](ях?|й|ями?)>)
    # $ruVozmeshchatVImp - возместите, возмести, возмещай
    $ruVozmeshchatVImp = ($regexp<в[оа]зм[еи]сь?ти(т[ие])?>/$regexp<в[оа]зм[еи](щ|сч|ч)ай(т[ие])?>)
    # $ruVozmeshchatVInf - возместить, возмещать
    $ruVozmeshchatVInf = ($regexp<в[оа]зм[еи]сь?тить>/$regexp<в[оа]зм[еи](щ|сч|ч)ать>)
    $ruVozmeshchatVImpInf = ($ruVozmeshchatVInf/$ruVozmeshchatVImp)
    
    $thisM = ($thisSgM/$thisPl)
    # $thisSgM - этот, данный
    $thisSgM = (
        $regexp<эт([оа]т|[оа]?[гв][оа]|[оа]?му?|им)>/
        $regexp<данн?(ы[йм]|[оа][гв][оа]|[оа]му?)>
        )
    $thisPl = (эти/этих/этим/этими/данные/даные/данных/даных/данным/даным/данными/даными)
    


theme: /returnTicketOrMoney
    
    
    state: GetMoneyBack
        # для стейта с таким названием "деньги" должны быть обязательным элементом
        # q!: * $return *
        # здесь и ниже в обоих стейтах необязательные элементы рядом со звездой
        # для денег лучше сделать словарь + включить туда средства
        # q!: * [деньги/денежки/денег] * $return *
        # здесь тасовка не нужна
        # q!: * {$return [ден*]} за $ticket *
        # сюда будет ловиться "хочу билет". $return должно быть обязательным, а модальные можно опустить
        # в ден* может пойматься лишнее
        # q!: * (хочу/надо/можно) {[$return] [ден*]} * $ticket *
        # в строке нет обязательных элементов
        #q!: * {[где/отда*/требу*/возмес*] * ([{[$my] (деньги/денежки/денег/стоимос*)}] * ([за][$ticket/фильм*]))} *
        

        # деньги мне возместите
        # верните деньги за возврат моего билета
        q!: * {($giveBackVImp/$giveBackVInf/$returnVImp/$returnVInf/$returnVPastWRefl/$returnVFutWRefl3/$returnVPresRefl3/$returnN/$ruVozmeshchatVImpInf/$ruVozmeshchenie/$compensateVImp/$compensateVInf/$compensateVPast/$compensation/требую/требуем) * $moneySyns} *
        q!: * {($giveBackVImp/$giveBackVInf/$returnVImp/$returnVInf/$returnVPastWRefl/$returnVFutWRefl3/$returnVPresRefl3/$returnN/$ruVozmeshchatVImpInf/$ruVozmeshchenie/$compensateVImp/$compensateVInf/$compensateVPast/$compensation/требую/требуем) * $moneySyns * (за [$returnN] {[$thisM] [$my] [$NumberOneToTen]} $ticket)} *
        # нужна еще жесткая строка с "где/хде" для запросов типа "где мои деньги"
        # нужны еще строки с отрицанием глаголов для запросов типа "деньги не вернулись"
        # также хорошо бы прописать спроки для запросов типа "сделал возврат билета отдай деньги", чтобы они не ловились во второй стейт
        
        # битый путь
        # go!: /returnTicketOrMoney/OperatorWillHelpYou
        go!: /returnTicketOrMoney/Ans_OperatorWillHelpYou
        
        
    state: ReturnTicket
        # $ticket в этом стейте должен быть обязательным (во-первых, по смыслу, во-вторых иначе будут дубли с первым стейтом)
        # q!: * ($giveBack/вернуть) [$ticket] *
        # как уже входит в $giveBack, но, кажется, оно здесь вообще не нужно
        # q!: *как* * $giveBack * $ticket *
        # можно без $my; $my $ticket нужно было объединить скобками
        # последняя звезда должна быть за фигурными скобками
        # возьми надо тоже со звездой, а лучше вообще в словарь
        # q!: * {(забери*/возьми) * $my $ticket * }
        # тасовка из 5 элементов
        # пробел между q! и двоеточием, тег не считается
        # мне и $my не нужны в качестве обязательных, строку можно сделать более свободной
        # строка больше подходит для первого стейта
        # q! : * {$giveBack мне $my ден* (за $ticket)} *
        
        # хотел бы сдать свой билет
        # процесс сдачи билетов
        q!: * {(сдать/здать/сдавать/здавать/сдач*/здач*/$returnN/$returnVInf/$giveBackVInf/забери*/забири*/возьми*/возми*/вазьми*/вазми*) * $ticket} *
        # можно еще добавить строки для запросов типа "билет не сдается помогите"
        
        # Тут нужно go! (с воскл знаком), иначе не будет выдаваться ответ в анс стейте, а просто будет переход в контекст этого стейта
        # go: /returnTicketOrMoney/ReturnInfoOnWebSite
        go!: /returnTicketOrMoney/Ans_ReturnInfoOnWebSite
        
    
    # по-хорошему надо бы ответные стейты в отдельный файл
    
    # это ответный стейт, должен начинаться с префикса Ans_
    # state: ReturnInfoOnWebSite
    state: Ans_ReturnInfoOnWebSite
        a: С информацией о возврате билетов и возмещении денежных средств можно ознакомиться на нашем сайте.



    state: Ans_OperatorWillHelpYou
        a: Вызываю оператора
