#webscraping
from bs4 import BeautifulSoup as soup
from urllib.request import urlopen as urlopen
import pandas as pd

url = "https://www.misprofesores.com/escuelas/Tec-de-Monterrey-ITESM-CCM_1001"

#Opening connection
webpage = urlopen(url)
page_html = webpage.read()

#Closing connection
webpage.close()
page_soup = soup(page_html, "html5lib")

names = soup.findAll('table')[2].findAll('tr')
print(names)
