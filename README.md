# demo-spring-rest-api

## Geting started

Getting started and testing your application endpoints is quite straightforward:

- Clone the repository.
- Open in your editor of choice.
- Create a demo database `demodb`.
- Setup your postgresql databse by creating a new user `demodb_user` and running the `demodb.sql` script at the root of the project directory.
- In the `application.properties` file, change `<PASSWORD>` to your `demodb_user`'s password.
- Make sure that you have no errors, and then run the application while ensuring it's listening on `localhost:8080`.
- Start postman and import the collection in the `collection` folder found at the root of the project directory.
- Test the the various endpoint requests as found in your collection.
