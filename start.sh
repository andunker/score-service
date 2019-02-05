./mvnw clean package
docker build -t scores .
docker run -d -p 9090:8080  scores 
