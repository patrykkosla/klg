Lista comend curl

Lista wszystkich rezerwacji Json
curl http://localhost:8080/api/reservations

Lista rezerwacji dla danego obiektu
curl http://localhost:8080/api/reservations/facility/2

Nowa rezerwacja
"/new/{facilityId}/{reservedFrom}/{reservedTo}/{userId}/{reservationCost}"
curl -X POST http://localhost:8080/api/reservations/new/1/2025-04-08/2025-04-18/2/333

Edycja rezerwacji
curl -X PUT -H 'Content-Type:application/json' -d '{"id":1,"facility":{"id":5,"facilityName":"Vila Stefana","pricePerDay":225.0,"propertyArea":2.0,"descryption":"Possimus nobis ex molestias. Eveniet consequatur sit quos. Deleniti veritatis quo est minus. Libero est ut suscipit quasi hic amet. Voluptate fugiat maiores soluta velit rerum.","owner":{"userId":6,"userName":"Aleksandra"}},"reservedBy":{"userId":3,"userName":"Jan"},"reservedFrom":"2050-11-21T23:00:00.000+00:00","reservedTo":"2051-11-26T23:00:00.000+00:00","reservationCost":100.0}' http://localhost:8080/api/reservations/edit/

Deploy projektu

Będąc w katalogu projektu

$ mvn clean package spring-boot:repackage
$ java -jar .\target\klg-test-0.0.1-SNAPSHOT.jar
