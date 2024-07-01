$global.$converters = $global.$converters || {};
var cnv = $global.$converters;

cnv.filmNameConverter = function (parseTree) {
    var id = parseTree.libFilmNames[0].value;
    return libFilmNames[id].value;
}
