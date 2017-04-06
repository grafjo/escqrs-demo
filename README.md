## Sprint anlegen:

curl -X POST 'http://localhost:8080/sprints'  -v -H 'Content-Type: application/json' --data-binary '{"name": "foo"}'

## Backlogitem zu Sprint hinzufügen:

curl -X PUT 'http://localhost:8080/backlogitems/a73f21d2-bd3b-4033-a50b-3181aea04749/commitment' -v -H 'Content-Type: application/json' --data-binary '{"sprintIdentifier": "eecc72a4-2e22-4417-a5ec-78a764b474ec"}'

## Backlogitem anlegen:

curl -X POST 'http://localhost:8080/backlogitems'  -v -H 'Content-Type: application/json' --data-binary '{"name": "foo"}' --compressed
