#!/bin/bash

hacer_solicitud() {
    local metodo=$1
    local url=$2
    local datos=$3

    respuesta=$(curl -s -X  "$metodo" -H "Content-Type: application/json" -d "$datos" "http://localhost:8080/api/$url")
    if [[ $? -eq 0 ]]; then
        echo "El servicio está funcionando correctamente."
        echo $respuesta
    else
        echo "El servicio no está funcionando."
    fi                                                  
}

hacer_solicitud "GET" "books" ""
echo

hacer_solicitud "GET" "books/2" ""
echo

# hacer_solicitud "POST" "books" '
#     {"name": "Acotar", "author": "Sara", "pages": 349}'
# echo

# hacer_solicitud "PUT" "books/4" '
#     {"name": "fdsadf", "author": "Sara", "pages": 349 }'
# echo

# hacer_solicitud "DELETE" "books/1" ""