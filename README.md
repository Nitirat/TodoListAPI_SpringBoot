# TodoListAPI_SpringBoot

### Build & Run

Require JDK 1.8

1. gradlew clean
2. gradlew test
3. gradlew bootRun
4. Url: localhost:8080

### API DOCS

	Get All Task:
		Request : GET
		URL : '/'  Or '/tasks'
		
	Get Task by Id:
		Request: GET
		URL: '/tasks/{id}'
		
	Create New Task:
      Request: POST
      URL: '/tasks'
      Header: Content-Type : application/json
      Body: 
		{
			"subject" : "Stand-up meeting",
			"detail" : "10.00 AM",
			"done" : "false"
		}
		
	Update Task:
		Request: PATCH
		URL: '/tasks'
		Header: Content-Type : application/json
		Body: 
		{ 
			"id" : 1 , 
			"subject" : "Retrospective",
			"detail" : "Friday", 
			"done" : "false" 
		}
		
	Update Status Task:
		Request: PUT
		URL: '/tasks/{id}'
		
	Delete Task:
		Request: DELETE
		URL: '/tasks/{id}'
