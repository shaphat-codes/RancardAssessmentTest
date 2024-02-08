#Rancard solutions technical interview task

## Installation

### Setting up environment
Create a .env file in the root directory with the credentials below
```js
DATABASE_URL=jdbc:mysql://mysql:3306/<db-name>
DATABASE_USERNAME=<your-db-user>
DATABASE_PASSWORD=<your-db-password>
```

### Start the application using Docker
After setting up docker and docker-compose on your computer, use the command below to spin up the project.
```bash
docker-compose up --build
```
The development server should be up and running

## TESTING
