## Sample Sprong Boot Project Using Postgres DB

1. Database Setup (Postgres):
      ```sql
      CREATE DATABASE shopme;
      CREATE USER shopmeuser WITH ENCRYPTED PASSWORD 'shopmepass';
      GRANT ALL PRIVILEGES ON DATABASE shopme TO shopmeuser;
      ```
2. Once DB has been setup, download the repo and launch it in IntelliJ IDE.
3. Update DB credentials in _`application.yaml`_ file inside _`src/main/resources`_ directory path.
4. Run the project.
5. All Done!! [Click Here](http://localhost:7788/students) to interact with your app:

> _**Assumptions**: IntelliK IDE, Java (Open JDK 1.7+) and Postgres DB have been setup and is running prior to starting with this project._

> _**References**: For Complete details, please refer [`Spring Boot Connect to PostgreSQL Database Examples`](https://www.codejava.net/frameworks/spring-boot/connect-to-postgresql-database-examples) - the source article for this Repo._
