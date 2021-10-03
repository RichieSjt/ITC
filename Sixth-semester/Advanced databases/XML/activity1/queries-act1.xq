(: XPath queries :)

(: Retrieve the name of all the pubs in the Condesa Area :)
/pl/pub[area="Condesa"]/pname

(: Retrieve the names of all beers sold at the Celtic’s pub :)
/pl/pub[pname="Celtic's"]/beer/bname

(: Retrieve the names of all customers over 25 years of age :)
/pl/customer[age > 25]/cname

(: Retrieve the name of all male customers over 25 years of age :)
/pl/customer[age > 25 and gender="Male"]/cname

(: Retrieve the prices of the Guinness beer (at all pubs) :)
/pl/pub/beer[bname="Guinness"]/price


(: XQuery queries :)

(: Retrieve the names of all blond beers sold at the Celtic’s pub :)
for $b in pl/pub[pname="Celtic's"]/beer
where $b/color = "Blond"
return $b/bname

(: Retrieve the names of all customers who frequent the Nada pub. :)

for $c in pl/customer
let $p := id($c/@frequents)
where $p [pname="Nada"]
return $c/cname

(: Retrieve the names of all customers who frequent pubs in the Polanco area. :)
for $c in pl/customer
let $p := id($c/@frequents)
where $p [area="Polanco"]
return $c/cname

(: Retrieve the areas where Irish beer is sold. :)
for $p in pl/pub
let $b := $p/beer
where $b[country="Ireland"]
return $p/area