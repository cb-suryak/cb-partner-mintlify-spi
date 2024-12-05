# Fetch the Health Status of the Service Provider

### Overview
Use this endpoint to check the health status of the service provider, including the status of its internal components such as the application database and API servers. The endpoint returns detailed status information about the service and its components.

### Endpoint
`GET /health`

### Summary
Fetch the current health status of the service provider and its components. The response includes the overall service status and the status of individual components, such as the database and server.

### Responses

#### 200 - Service is Healthy
A `200` response indicates that the service is healthy. The response provides the overall status along with detailed information about individual components.

Example Response:

```json
{
  "status": "UP",
  "version": "1.0.0",
  "description": "The service is healthy.",
  "components": [
    {
      "id": "app-db-memory",
      "name": "Application Database",
      "type": "DATABASE",
      "status": "UP"
    },
    {
      "id": "adapter-server",
      "name": "Adapter API Server",
      "type": "ADAPTER",
      "status": "UP"
    },
    {
      "id": "service-server",
      "name": "API Server",
      "type": "API",
      "status": "UP"
    }
  ],
  "time": "2022-11-01T10:42:08.131+05:30"
}
