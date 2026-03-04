# 1. 봇에게 "우분투 컴퓨터에 Java 25 버전을 깔아줘!" 라고 주문합니다.
FROM eclipse-temurin:25-jdk-alpine

# 2. 스프링 부트가 빌드되면서 만들어진 .jar 파일(실행 파일)을 찾습니다.
ARG JAR_FILE=build/libs/*.jar

# 3. 그 파일을 도커 박스 안에 'app.jar'라는 이름으로 복사해 넣습니다.
COPY ${JAR_FILE} app.jar

# 4. "도커 박스를 켜면 자동으로 java -jar app.jar 명령어를 실행해 줘!" 라고 알려줍니다.
ENTRYPOINT ["java", "-jar", "/app.jar"]