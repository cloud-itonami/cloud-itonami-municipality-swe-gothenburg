(ns ordinance.facts
  "Municipal-ordinance compliance catalog for Gothenburg (Göteborgs
  Stad, Sweden) -- the TWENTY-FOURTH municipality-level entry (see
  cloud-itonami-municipality-jpn-tokyo, -usa-washington-dc, -gbr-london,
  -can-toronto, -deu-berlin, -fra-paris, -nld-amsterdam, -esp-madrid,
  -kor-seoul, -ita-roma, -aus-sydney, -arg-buenos-aires, -fin-helsinki,
  -dnk-copenhagen, -nor-oslo, -bel-brussels, -chl-santiago, -col-bogota,
  -cri-san-jose, -bra-sao-paulo, -ury-montevideo, -zaf-cape-town,
  -ecu-quito for the first twenty-three) per ADR-2607141700
  (cloud-itonami-compliance-fact-federation).

  Stockholm was attempted for Sweden in an earlier tick and abandoned:
  its official KFS PDF (waste regulation) rendered with a
  font-subsetting artifact severe enough that even the document's own
  title was illegible. Gothenburg's official goteborg.se-hosted PDFs
  rendered cleanly instead -- both entries here cite goteborg.se
  directly, never fabricated.

  'Lokala ordningsföreskrifter för Göteborgs kommun' (local public-
  order regulations): the document's title and statutory basis (SFS
  1993:1617/1993:1632) were directly confirmed by reading the saved
  PDF's own cover page. Its enacted-date (2025-01-01, the effective
  date; kommunfullmäktige decided 2024-10-04) is WebSearch-corroborated
  from the actual council 'Handling_2024_nr_188.pdf' record, which was
  too large (>10MB) to WebFetch directly -- matching the same
  WebSearch-corroborated-date discipline used for NAB's Political
  Broadcast Catechism in an earlier tick, rather than fabricated.

  'Göteborgs Stadsmiljöpolicy' (City Environment Policy): title and
  content directly confirmed by reading the saved PDF's own pages. The
  only date visible on those pages attaches to a QUOTED EXCERPT from a
  different document (Översiktsplan för Göteborg, adopted 2009-02-26)
  reproduced inside the policy as a sidebar quote -- not the policy's
  own adoption date. To avoid misattributing that date to the wrong
  document, :ordinance/enacted-date is deliberately omitted for this
  entry.")

(def catalog
  "municipality-slug -> vector of ordinance entries."
  {"gothenburg"
   [{:ordinance/id "gothenburg.lokala-ordningsforeskrifter"
     :ordinance/title "Lokala ordningsföreskrifter för Göteborgs kommun"
     :ordinance/municipality "gothenburg"
     :ordinance/country "SWE"
     :ordinance/kind :ordinance
     :ordinance/url "https://goteborg.se/wps/wcm/connect/6b3e77e8-c13a-4d62-bcc4-f7809e7a4912/Lokala+ordningsf%C3%B6reskrifter+f%C3%B6r+G%C3%B6teborgs+kommun.pdf?MOD=AJPERES"
     :ordinance/url-provenance :official-goteborg-se
     :ordinance/enacted-date "2025-01-01"
     :ordinance/retrieved-at "2026-07-16"
     :ordinance/topic #{:public-order}}
    {:ordinance/id "gothenburg.stadsmiljopolicy"
     :ordinance/title "Göteborgs Stadsmiljöpolicy"
     :ordinance/municipality "gothenburg"
     :ordinance/country "SWE"
     :ordinance/kind :ordinance
     :ordinance/url "https://goteborg.se/wps/wcm/connect/3ffbf99d-7a74-48b3-8cf4-e88192e91e59/G%C3%B6teborgs+stadsmilj%C3%B6policy+%C3%B6vergripande.pdf?MOD=AJPERES"
     :ordinance/url-provenance :official-goteborg-se
     :ordinance/retrieved-at "2026-07-16"
     :ordinance/topic #{:urban-planning}}]})

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
      :note (str "cloud-itonami-municipality-swe-gothenburg Wave 0 (ADR-2607141700): "
                 (count (get catalog "gothenburg")) " Gothenburg entries seeded "
                 "with an official goteborg.se citation. "
                 "Extend `ordinance.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [muni topic]
  (filterv #(contains? (:ordinance/topic %) topic) (spec-basis muni)))
