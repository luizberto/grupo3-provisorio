# importing geopy library
from geopy.geocoders import Nominatim
import requests

def getEndereco(cep):
    endereco = requests.get(f'https://viacep.com.br/ws/{cep}/json/').json()
    rua = endereco['logradouro']
    bairro = endereco['bairro']
    cidade = endereco['localidade']
    uf = endereco['uf']
    print(endereco)
    return rua, bairro, cidade, uf

getEndereco('09710180')
# calling the Nominatim tool
# loc = Nominatim(user_agent="GetLoc")
  
# # entering the location name
# getLoc = loc.geocode(f"{rua}, {cidade}, {bairro}, {uf}")
  
# # printing address
# print(getLoc.address)
  
# # printing latitude and longitude
# print("Latitude = ", getLoc.latitude, "\n")
# print("Longitude = ", getLoc.longitude)