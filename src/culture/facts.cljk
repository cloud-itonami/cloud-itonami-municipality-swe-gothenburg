(ns culture.facts
  "Regional-culture catalog for Gothenburg -- local dishes,
  protected products, beverages, festivals and heritage sites, piggybacked
  onto this municipality compliance repo per ADR-2607171400
  (cloud-itonami-municipality-culture-catalog, in com-junkawasaki/root),
  sibling namespace to `ordinance.facts` (ADR-2607141700).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "municipality-slug -> vector of culture entries."
  {"gothenburg"
   [{:culture/id "gothenburg.dish.halv-special"
     :culture/name "Halv special"
     :culture/municipality "gothenburg"
     :culture/country "SWE"
     :culture/kind :dish
     :culture/summary "Hot-dog bread with one sausage topped with mashed potato, originating at a sausage kiosk on Hisingen in Gothenburg in the 1940s."
     :culture/url "https://sv.wikipedia.org/wiki/Halv_special"
     :culture/url-provenance :wikipedia-sv
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "gothenburg.dish.kanelbulle"
     :culture/name "Cinnamon roll"
     :culture/name-local "Kanelbulle"
     :culture/municipality "gothenburg"
     :culture/country "SWE"
     :culture/kind :dish
     :culture/summary "Sweet roll; the modern Swedish kanelbulle was created after the First World War, and since 1999 October 4 has been promoted in Sweden as Cinnamon Roll Day (Kanelbullens dag) — national rather than Gothenburg-specific."
     :culture/url "https://en.wikipedia.org/wiki/Cinnamon_roll"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "gothenburg.dish.koettbullar"
     :culture/name "Swedish meatballs"
     :culture/name-local "Köttbullar"
     :culture/municipality "gothenburg"
     :culture/country "SWE"
     :culture/kind :dish
     :culture/summary "Meatballs, called köttbullar in Sweden, where they are considered a national dish; national rather than Gothenburg-specific."
     :culture/url "https://en.wikipedia.org/wiki/Meatball"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "gothenburg.beverage.pripps"
     :culture/name "Pripps"
     :culture/municipality "gothenburg"
     :culture/country "SWE"
     :culture/kind :beverage
     :culture/summary "Beer from the Pripps brewery, founded in Gothenburg by Johan Albrecht Pripp in 1828."
     :culture/url "https://en.wikipedia.org/wiki/Pripps"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "gothenburg.festival.goeteborg-film-festival"
     :culture/name "Göteborg Film Festival"
     :culture/municipality "gothenburg"
     :culture/country "SWE"
     :culture/kind :festival
     :culture/summary "Film festival held in Gothenburg since 1979, the largest film event in Scandinavia, screening around 450 films for around 115,000 visitors annually."
     :culture/url "https://en.wikipedia.org/wiki/G%C3%B6teborg_Film_Festival"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "gothenburg.festival.gothia-cup"
     :culture/name "Gothia Cup"
     :culture/municipality "gothenburg"
     :culture/country "SWE"
     :culture/kind :festival
     :culture/summary "International youth association football tournament held annually in Gothenburg since 1975, the biggest tournament in the world in terms of participating teams."
     :culture/url "https://en.wikipedia.org/wiki/Gothia_Cup"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "gothenburg.heritage.liseberg"
     :culture/name "Liseberg"
     :culture/municipality "gothenburg"
     :culture/country "SWE"
     :culture/kind :heritage
     :culture/summary "Amusement park in Gothenburg opened in 1923, the second most visited theme park in Scandinavia with around three million visitors annually."
     :culture/url "https://en.wikipedia.org/wiki/Liseberg"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "gothenburg.heritage.feskekoerka"
     :culture/name "Feskekôrka"
     :culture/municipality "gothenburg"
     :culture/country "SWE"
     :culture/kind :heritage
     :culture/summary "Building in Gothenburg that formerly housed an indoor fish market, whose neo-Gothic design earned it the nickname 'Fish Church'."
     :culture/url "https://en.wikipedia.org/wiki/Feskek%C3%B4rka"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "gothenburg.heritage.haga"
     :culture/name "Haga district"
     :culture/name-local "Haga"
     :culture/municipality "gothenburg"
     :culture/country "SWE"
     :culture/kind :heritage
     :culture/summary "City district of Gothenburg renowned for its picturesque wooden houses, 19th-century atmosphere and cafés."
     :culture/url "https://en.wikipedia.org/wiki/Haga,_Gothenburg"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [muni] (get catalog muni))

(defn coverage
  ([] (coverage (keys catalog)))
  ([munis]
   (let [have (filter catalog munis)
         missing (remove catalog munis)]
     {:requested (count munis)
      :covered (count have)
      :covered-municipalities (vec (sort have))
      :missing-municipalities (vec (sort missing))
      :note (str "cloud-itonami-municipality-swe-gothenburg culture catalog "
                 "(ADR-2607171400): " (count (get catalog "gothenburg"))
                 " Gothenburg entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [muni kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis muni)))
