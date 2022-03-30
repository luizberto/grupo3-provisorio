import requests
def get_pais(url):
    
    """"create request from viacep and print the results"""
    response = requests.get(url)
    if response.status_code == 200:
        return response.json()
    else:
        return None


print(get_pais('https://viacep.com.br/ws/01001000/json/')['logradouro'])