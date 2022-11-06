# MyRepository

## Описание.
### Черновик.
Проект работает через Postman.
Б/Д - PostgreSQL
Запросы:
Для Certificate
http://localhost:8080/api/v1/gifts/?page=0 - вывод заданной
страницы, по 10 товаров.

http://localhost:8080/api/v1/gifts/get-id?id=1 - вывод заданного сертификата по id.

http://localhost:8080/api/v1/gifts/2 - обновление сертификато по id
через тело запроса. Пример:
{
    "name": "Certificate_01",
    "description": "yes",
    "price": 1.25,
    "duration": 2,
    "createData": "2022-09-26T10:29:43.000",
    "lastUpdateDate": "2022-09-27T10:30:36.000"
}

http://localhost:8080/api/v1/gifts/2 - удаление сертификата.

http://localhost:8080/api/v1/gifts/add - добавление сертификата
через тело запроса. Пример:
{
        {
            "name": "Certificate_02",
            "description": "yes",
            "price": 1.5,
            "duration": 2,
            "createData": "2022-09-26T13:29:43.123",
            "lastUpdateDate": "2022-09-27T13:30:36.123",
            "tagEntities": [
                {
                    "name": "Certificate_02"
                }
            ]
        }
    }
    
http://localhost:8080/api/v1/gifts/name?name=t - вывод по части имение без учёта регистра.

http://localhost:8080/api/v1/tags/sort - вывод в отсортированном виде по имени.