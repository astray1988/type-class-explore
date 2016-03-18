



val languageWordCounts = Map(
  ("english", "hello") -> 4,
  ("chinese", "nihao") -> 1,
  ("english","hi") -> 1,
  ("chinese", "zaijian") -> 2
)

val s = languageWordCounts.flatMap(pair => Map(pair. -> pair._2))
println(s)